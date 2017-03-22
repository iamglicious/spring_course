package eu.fearierose.lessons.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.fearierose.lessons.domain.Student;

/**
 * 
 * @author FaerieRose
 */
@Component
public interface StudentRepository extends CrudRepository<Student, Long> {

}
