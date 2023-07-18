package ma.atos.operationMng.enums;

public enum TypePaiement {
    ESPECE("E"),
    CHEQUE("C");

    private String type;
    TypePaiement(String type) {
        this.type = type;
    }
}
