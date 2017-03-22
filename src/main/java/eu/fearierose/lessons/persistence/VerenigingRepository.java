package eu.fearierose.lessons.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.fearierose.lessons.domain.Vereniging;

/**
 * 
 * @author FaerieRose
 */
@Component
public interface VerenigingRepository extends CrudRepository<Vereniging, Long> {

}
