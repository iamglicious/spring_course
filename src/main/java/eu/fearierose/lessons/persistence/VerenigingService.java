package eu.fearierose.lessons.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.fearierose.lessons.domain.Vereniging;

/**
 * 
 * @author FaerieRose
 */
@Service
@Transactional
public class VerenigingService {
	
	@Autowired
	private VerenigingRepository verenigingRepository;
	
	public Vereniging save(Vereniging vereniging) {
		return this.verenigingRepository.save(vereniging);
	}
	
	public Iterable<Vereniging> findAll() {
		return this.verenigingRepository.findAll();
	}
	
	public Vereniging findById(Long id) {
		return this.verenigingRepository.findOne(id);
	}	
}
