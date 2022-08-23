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
@Table(name = "account_fixed")
public class AccountFixed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFixed;
	@Column(name = "typeCurrency", nullable = false, length = 10)
	private String typeCurrency;
	@Column(name = "accountNumber", nullable = false, length = 30)
	private String accountNumber;
	@Column(name = "depositDate", nullable = false)
	private LocalDateTime depositDate;
	@Column(name = "balance", nullable = false, scale = 2)
	private Double balance;
	@Column(name = "countMonth", nullable = false, length = 10)
	private String countMonth;
	@Column(name = "interestPay", nullable = false, scale = 2)
	private Double interestPay;
	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false, foreignKey = @ForeignKey(name = "fk_fixed_client"))
	private Client cliente;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idFixed == null) ? 0 : idFixed.hashCode());
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
        AccountFixed other = (AccountFixed) obj;
        if (idFixed == null) {
            if (other.idFixed != null)
                return false;
        } else if (!idFixed.equals(other.idFixed))
            return false;
        return true;
    }

}
