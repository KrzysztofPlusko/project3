package pl.krzysiek.spring.project3.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.krzysiek.spring.project3.entities.Project;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();
}
