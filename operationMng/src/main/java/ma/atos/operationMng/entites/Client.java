package ma.atos.operationMng.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.atos.operationMng.enums.TypeClient;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SEGMENT", discriminatorType = DiscriminatorType.STRING)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "adresse")
    private String adresse;

    @Enumerated(EnumType.STRING)
    private TypeClient typeClient;

    @Column(updatable = false, insertable = false)
    private String segment;

}
