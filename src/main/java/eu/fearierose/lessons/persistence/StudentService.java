package eu.fearierose.lessons.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.fearierose.lessons.domain.Student;

/**
 * 
 * @author FaerieRose
 */
@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student save(Student student) {
		return this.studentRepository.save(student);
	}
	
	public Iterable<Student> findAll() {
		return this.studentRepository.findAll();
	}
	
	public Student findById(Long id) {
		return this.studentRepository.findOne(id);
	}
	
}
