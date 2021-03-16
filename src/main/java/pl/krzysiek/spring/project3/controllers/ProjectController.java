package pl.krzysiek.spring.project3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.krzysiek.spring.project3.entities.Employee;
import pl.krzysiek.spring.project3.entities.Project;
import pl.krzysiek.spring.project3.repositories.IEmployeeRepository;
import pl.krzysiek.spring.project3.repositories.IProjectRepository;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projectList = proRepo.findAll();
        model.addAttribute("projects", projectList);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees );

        return "projects/new-project";

    }

    @PostMapping("save")

    public String createProject(Model Model, @RequestParam List<Long> employees, Project project) {

        proRepo.save(project);

        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
            for(Employee emp : chosenEmployees) {
                emp.setTheProject(project);
                empRepo.save(emp);
            }

        return"redirect:/projects/new";
    }
}
