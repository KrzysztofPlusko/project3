package pl.krzysiek.spring.project3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysiek.spring.project3.entities.Employee;
import pl.krzysiek.spring.project3.entities.Project;
import pl.krzysiek.spring.project3.repositories.IEmployeeRepository;
import pl.krzysiek.spring.project3.repositories.IProjectRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping
    public String display(Model model ) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList",projects);

        List<Employee> employees  = empRepo.findAll();
        model.addAttribute("employeesList", employees);

        return "/main/home";
    }
}
