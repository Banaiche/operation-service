package ma.atos.operationMng.entites;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("B2C")
public class B2C extends Client {
    private String cin;
    private String nomComplet;

}
