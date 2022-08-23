package pe.com.restapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerson;
	@Column(name = "fullName", nullable = false, length = 100)
	private String fullName;
	@Column(name = "typeDoc", nullable = false, length = 10)
	private String typeDoc;
	@Column(name = "numberDoc", nullable = false, length = 15)
	private String numberDoc;
	@Column(name = "dateBirth", nullable = false)
	private LocalDateTime dateBirth;
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	@Column(name = "phone", nullable = false, length = 15)
	private String phone;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "userCreation", nullable = false, length = 30)
	private String userCreation;
	@Column(name = "ipCreation", nullable = false, length = 30)
	private String ipCreation;
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (idPerson == null) {
            if (other.idPerson != null)
                return false;
        } else if (!idPerson.equals(other.idPerson))
            return false;
        return true;
    }

}
