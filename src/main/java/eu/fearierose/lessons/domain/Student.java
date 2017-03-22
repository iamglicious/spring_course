/**
 * 
 */
package eu.fearierose.lessons.domain;

import javax.persistence.Entity;

/**
 * 
 * @author FaerieRose
 */
@Entity
public class Student extends Person {
	private String studieRichting;

	public String getStudieRichting() {
		return studieRichting;
	}
	public void setStudieRichting(String studieRichting) {
		this.studieRichting = studieRichting;
	}
	
	
}
