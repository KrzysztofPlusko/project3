package pl.krzysiek.spring.project3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysiek.spring.project3.entities.Project;
import pl.krzysiek.spring.project3.repositories.IProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    IProjectRepository proRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "/projects/new-project";

    }

    @PostMapping("save")

    public String createProject(Model Model, Project project) {

        proRepo.save(project);

        return"redirect:/projects/new";
    }
}
