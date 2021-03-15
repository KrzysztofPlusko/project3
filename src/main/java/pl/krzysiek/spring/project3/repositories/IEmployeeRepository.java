package pl.krzysiek.spring.project3.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.krzysiek.spring.project3.entities.Employee;
import pl.krzysiek.spring.project3.entities.Project;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
}
