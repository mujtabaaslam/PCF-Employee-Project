package com.example.companybase.clients;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ActionServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    public static int PAGE_SIZE = 5;

    private ClientsBean clientsBean;

    public ActionServlet(ClientsBean clientsBean){
        this.clientsBean = clientsBean;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("Add".equals(action)){
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int years = Integer.parseInt((request.getParameter("years"));
            long projectValue = Long.parseLong(request.getParameter("projectValue"));

            Client client = new Client(name, email, years, projectValue);

            clientsBean.addClient(client);
            response.sendRedirect("clients");
        } else if ("Remove".equals(action)){
            String[] ids = request.getParameterValues("id");
            for(String id: ids){
                clientsBean.deleteClientId(new Long(id));
            }
        } else{
            String key = request.getParameter("key");
            String field = request.getParameter("field");

            int count = 0;

            if(StringUtils.isEmpty(key) || StringUtils.isEmpty(field)){
                count = clientsBean.countAll();
                key = "";
                field = "";
            } else{
                count = clientsBean.count(field, key);
            }

            int page = 1;

            try{
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e){

            }

            int pageCount = (count / PAGE_SIZE);
            if (pageCount == 0 || count % PAGE_SIZE != 0) {
                pageCount++;
            }

            if (page < 1) {
                page = 1;
            }

            if (page > pageCount) {
                page = pageCount;
            }

            int start = (page - 1) * PAGE_SIZE;
            List<Client> range;

            if(StringUtils.isEmpty(key) || StringUtils.isEmpty(field)){
                range = clientsBean.findAll(start, PAGE_SIZE);
            } else {
                range = clientsBean.findRange(field, key, start, PAGE_SIZE);
            }

            int end = start + range.size();

            request.setAttribute("count", count);
            request.setAttribute("start", start + 1);
            request.setAttribute("end", end);
            request.setAttribute("page", page);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("clients", range);
            request.setAttribute("key", key);
            request.setAttribute("field", field);

        }

        request.getRequestDispatcher("WEB-INF"/clients.jsp).forward(request, response);
    }


}
