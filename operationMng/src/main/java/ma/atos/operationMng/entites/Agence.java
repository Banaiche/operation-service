package ma.atos.operationMng.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agence")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "location")
    private String localisation;

    @OneToOne(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Caisse caisse;

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
        caisse.setAgence(this);
    }
}
