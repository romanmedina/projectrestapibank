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
@Table(name = "account_credit")
public class AccountCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCredit;
	@Column(name = "typeCurrency", nullable = false, length = 10)
	private String typeCurrency;
	@Column(name = "accountNumber", nullable = false, length = 30)
	private String accountNumber;
	@Column(name = "depositDate", nullable = false)
	private LocalDateTime depositDate;
	@Column(name = "datePay", nullable = false)
	private LocalDateTime datePay;
	@Column(name = "balance", nullable = false, scale = 2)
	private Double balance;
	@Column(name = "totalConsumed", nullable = false, scale = 2)
	private Double totalConsumed;
	@Column(name = "countMonth", nullable = false, length = 10)
	private String countMonth;
	@Column(name = "interestPay", nullable = false, scale = 2)
	private Double interestPay;
	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false, foreignKey = @ForeignKey(name = "fk_credit_client"))
	private Client cliente;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCredit == null) ? 0 : idCredit.hashCode());
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
        AccountCredit other = (AccountCredit) obj;
        if (idCredit == null) {
            if (other.idCredit != null)
                return false;
        } else if (!idCredit.equals(other.idCredit))
            return false;
        return true;
    }
}
