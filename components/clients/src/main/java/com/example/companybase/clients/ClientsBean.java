package com.example.companybase.clients;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;

@Repository
public class ClientsBean {

    @PersistenceContext
    private EntityManager entityManager;

    public Client find(Long id){
        return entityManager.find(Client.class, id);
    }

    @Transactional
    public void addClient(Client client){
        entityManager.persist(client);
    }

    @Transactional
    public void editClient(Client client){
        entityManager.merge(client);
    }

    @Transactional
    public void deleteClient(Client client){
        entityManager.remove(client);
    }

    @Transactional
    public void deleteClientId(long id){
        Client client = entityManager.find(Client.class, id);
        deleteClient(client);
    }

    public List<Client> getClients(){
        CriteriaQuery<Client> cq = entityManager.getCriteriaBuilder().createQuery(Client.class);
        cq.select(cq.from(Client.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Client> findAll(int firstResult, int maxResults){
        CriteriaQuery<Client> cq = entityManager.getCriteriaBuilder().createQuery(Client.class);
        cq.select(cq.from(Client.class));
        TypedQuery<Client> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int countAll(){
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        Root<Client> rt = cq.from(Client.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        TypedQuery<Long> q = entityManager.createQuery(cq);
        return (q.getSingleResult().intValue());
    }

    public int count(String field, String searchTerm){
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<Client> rt = cq.from(Client.class);
        EntityType<Client> type = entityManager.getMetamodel().entity(Client.class);

        Path<String> path = rt.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.select(qb.count(rt));
        cq.where(condition);

        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    public List<Client> findRange(String field, String searchTerm, int firstResult, int maxResults){
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cq = qb.createQuery(Client.class);
        Root<Client> rt = cq.from(Client.class);
        EntityType<Client> type = entityManager.getMetamodel().entity(Client.class);

        Path<String> path = rt.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.where(condition);
        TypedQuery<Client> q =entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    @Transactional
    public void clean(){
        entityManager.createQuery("delete from Client").executeUpdate();
    }


}
