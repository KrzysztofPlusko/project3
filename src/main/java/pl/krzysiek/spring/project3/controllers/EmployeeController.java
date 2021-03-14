package pl.krzysiek.spring.project3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysiek.spring.project3.entities.Employee;
import pl.krzysiek.spring.project3.repositories.IEmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping("new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);

        return "/employees/new-employee";
    }

    public String createEmployee(Model model, Employee employee) {

        return"";
    }
}
