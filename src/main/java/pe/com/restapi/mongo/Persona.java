package pe.com.restapi.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "persona")
public class Persona {

	@Id
	private Integer id;
	private String nombre;
}
