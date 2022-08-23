package pe.com.restapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	@Column(name = "typeClient", nullable = false, length = 30)
	private String typeClient;
	@Column(name = "dateEntry")
	private LocalDateTime dateEntry;
	@Column(name = "userCreation", nullable = false, length = 30)
	private String userCreation;
	@Column(name = "ipCreation", nullable = false, length = 30)
	private String ipCreation;
	@ManyToOne
	@JoinColumn(name = "idPerson", nullable = false, foreignKey = @ForeignKey(name = "fk_client_person"))
	private Person person;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
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
        Client other = (Client) obj;
        if (idClient == null) {
            if (other.idClient != null)
                return false;
        } else if (!idClient.equals(other.idClient))
            return false;
        return true;
    }
}
