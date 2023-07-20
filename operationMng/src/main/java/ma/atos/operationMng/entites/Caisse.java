package ma.atos.operationMng.entites;

import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import java.math.BigDecimal;

import javax.persistence.*;

import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "caisse")
public class Caisse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "etat")
    private String etat;

    @Column(name = "montant")
    private BigDecimal montant;


    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

}
