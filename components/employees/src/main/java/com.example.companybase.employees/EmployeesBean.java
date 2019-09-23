/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.companybase.employees;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;

@Repository
public class EmployeesBean {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee find(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional
    public void editEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Transactional
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }

    @Transactional
    public void deleteEmployeeId(long id) {
        Employee employee = entityManager.find(Employee.class, id);
        deleteEmployee(employee);
    }

    public List<Employee> getEmployees() {
        CriteriaQuery<Employee> cq = entityManager.getCriteriaBuilder().createQuery(Employee.class);
        cq.select(cq.from(Employee.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Employee> findAll(int firstResult, int maxResults) {
        CriteriaQuery<Employee> cq = entityManager.getCriteriaBuilder().createQuery(Employee.class);
        cq.select(cq.from(Employee.class));
        TypedQuery<Employee> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int countAll() {
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        Root<Employee> rt = cq.from(Employee.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        TypedQuery<Long> q = entityManager.createQuery(cq);
        return (q.getSingleResult()).intValue();
    }

    public int count(String field, String searchTerm) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<Employee> root = cq.from(Employee.class);
        EntityType<Employee> type = entityManager.getMetamodel().entity(Employee.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.select(qb.count(root));
        cq.where(condition);

        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    public List<Employee> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = qb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        EntityType<Employee> type = entityManager.getMetamodel().entity(Employee.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.where(condition);
        TypedQuery<Employee> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    @Transactional
    public void clean() {
        entityManager.createQuery("delete from Employee").executeUpdate();
    }
}