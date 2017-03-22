package eu.fearierose.lessons.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import eu.fearierose.lessons.domain.Student;
import eu.fearierose.lessons.persistence.StudentService;

/**
 * 
 * @author FaerieRose
 */
@Path("students")
@Component
public class StudentEndpoint {

	@Autowired
	private StudentService studentService;

	/**
	 * Creates a new student
	 * @param student the new Student to be created
	 * @return Code 202 (accepted) with the new student id
	 */	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postStudent(Student student)  {
		Student result = this.studentService.save(student);
		return Response.accepted(result.getId()).build();
	}
	
	/**
	 * Gets an existing student
	 * @param id the id of the Student to be fetched
	 * @return Code 200 (ok) with the Student or 204 (no content) if the student does not exist
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getStudentById(@PathParam("id") Long id ) {
		Student result = this.studentService.findById(id);
		if (result == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(result).build();
		}
	}
	
	/**
	 * Gets all students in DB
	 * @return Code 200 (ok) with the Student or 204 (no content) if there are no students in DB
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudents() {
		Iterable<Student> result = this.studentService.findAll();
		if (result == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(result).build();
		}
	}

}
