package eu.fearierose.lessons.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author FaerieRose
 */
@Entity
@Table(name = "SOCIETY")
/* More on @Table:
 * http://docs.oracle.com/javaee/5/api/javax/persistence/Table.html
 */
public class Vereniging {
	
	/* More info on @Id en @GeneratedValue
	 * http://www.java2s.com/Tutorials/Java/JPA/0220__JPA_ID_GenerationType.IDENTITY.htm
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/* More info on @Column : 
	 * http://docs.oracle.com/javaee/5/api/javax/persistence/Column.html 
	 * http://www.java2s.com/Tutorials/Java/JPA/0100__JPA_Column_Definition.htm 
	 */
	@Column(name = "SOCIETY_ID")                    
	private long id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR(40)") 
	private String naam;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Student voorzitter;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Student> students = new ArrayList<Student>();
	
	@Column(name = "oudleden")
	/* More info on @ElementCollection :
	 * http://www.java2s.com/Tutorials/Java/JPA/0320__JPA_ElementCollection_MapKeyEntity.htm
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	Map<Integer, Student> oudleden = new HashMap<Integer, Student>();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public Student getVoorzitter() {
		return voorzitter;
	}
	public void setVoorzitter(Student voorzitter) {
		this.voorzitter = voorzitter;
	}
	
	public Map<Integer, Student> getOudleden() {
		return oudleden;
	}
	public Student oudlidByKey(Integer key) {
		return this.oudleden.get(key);
	}
	public void setOudleden(Map<Integer, Student> oudleden) {
		this.oudleden = oudleden;
	}
	public void addOudlid(Student student) {
		this.oudleden.put(this.oudleden.size(), student);
	}
	
}
