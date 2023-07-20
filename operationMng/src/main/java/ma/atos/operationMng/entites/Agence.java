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

    @OneToMany(mappedBy = "agence")
    private List<Caisse> caisseList;

    public void setCaisse(Caisse caisse) {
        this.caisseList = (List<Caisse>) caisse;
        caisse.setAgence(this);
    }
}
