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
@Table(name = "account_saving")
public class AccountSaving {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSaving;
	@Column(name = "typeSaving", nullable = false, length = 30)
	private String typeSaving;
	@Column(name = "typeCurrency", nullable = false, length = 10)
	private String typeCurrency;
	@Column(name = "typeAccount", nullable = false, length = 15)
	private String typeAccount;
	@Column(name = "accountNumber", nullable = false, length = 30)
	private String accountNumber;
	@Column(name = "depositDate", nullable = false)
	private LocalDateTime depositDate;
	@Column(name = "balance", nullable = false, scale = 2)
	private Double balance;
	@Column(name = "interest", nullable = false, scale = 2)
	private Double interest;
	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false, foreignKey = @ForeignKey(name = "fk_saving_client"))
	private Client cliente;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idSaving == null) ? 0 : idSaving.hashCode());
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
        AccountSaving other = (AccountSaving) obj;
        if (idSaving == null) {
            if (other.idSaving != null)
                return false;
        } else if (!idSaving.equals(other.idSaving))
            return false;
        return true;
    }
	
}
