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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movement_fixed")
public class movement_fixed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovementFixed;
    
    @ManyToOne
    @JoinColumn(name = "idFixed", nullable = false, foreignKey = @ForeignKey(name = "fk_fixed_movement"))
    private Client idFixed;
    
    @Column(name = "dateMovement", nullable = false)
    private LocalDateTime dateMovement;    
    
    @Column(name = "typet", nullable = false, length = 1)
    private String type;    
    
    @Column(name = "interest", nullable = false)
    private Double interest;    
    
    @Column(name = "balance", nullable = false)
    private Double balance;

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMovementFixed == null) ? 0 : idMovementFixed.hashCode());
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
        movement_fixed other = (movement_fixed) obj;
        if (idMovementFixed == null) {
            if (other.idMovementFixed != null)
                return false;
        } else if (!idMovementFixed.equals(other.idMovementFixed))
            return false;
        return true;
    }
}
