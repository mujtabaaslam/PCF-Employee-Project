package com.example.companybase;

import com.example.mediabase.movies.MoviesBean;
import com.example.mediabase.podcasts.Podcast;
import com.example.mediabase.podcasts.PodcastInitialList;
import com.example.mediabase.podcasts.PodcastRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.mediabase.movies.MoviesInitialList;

import java.util.Map;

@Controller
public class RootController {
    private EmployeesInitialList employeesInitialList;
    private EmployeesBean employeesBean;
    private ClientRepository clientRepository;
    private ClientInitialList clientInitialList;

    public RootController(EmployeesInitialList employeesInitialList, EmployeesBean employeesBean, ClientRepository clientRepository, ClientInitialList clientInitialList) {
        this.employeesInitialList = employeesInitialList;
        this.employeesBean = employeesBean;
        this.clientRepository = clientRepository;
        this.clientInitialList = clientInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {
        employeesInitialList.asList().forEach(employeesBean::addMovie);

        model.put("employees", employeesBean.getMovies());

        clientInitialList.asList().forEach(clientRepository::save);

        model.put("clients", clientRepository.findAll());

        return "setup";
    }

}
