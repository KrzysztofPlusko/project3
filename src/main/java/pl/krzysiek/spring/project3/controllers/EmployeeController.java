package pl.krzysiek.spring.project3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysiek.spring.project3.entities.Employee;
import pl.krzysiek.spring.project3.entities.Project;
import pl.krzysiek.spring.project3.repositories.IEmployeeRepository;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("employees", listEmployees);
        return "employees/list-employees";

    }

    @GetMapping("new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);

        return "employees/new-employee";
    }

    @PostMapping("save")
    public String createEmployee(Model model, Employee employee) {

        empRepo.save(employee);
        return"redirect:/employees/new";
    }
}
