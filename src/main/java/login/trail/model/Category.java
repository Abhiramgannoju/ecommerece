package login.trail.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="category_table")
public class Category {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
//	 @Column(name="category_id")
	    private Integer id;
	    private String name;

	    // Getter method for 'id'
	    public Integer getId() {
	        return id;
	    }

	    // Setter method for 'id'
	    public void setId(Integer id) {
	        this.id = id;
	    }

	    // Getter method for 'name'
	    public String getName() {
	        return name;
	    }

	    // Setter method for 'name'
	    public void setName(String name) {
	        this.name = name;
	    }
	}
