package ma.atos.operationMng.enums;

public enum TypeClient {
    B2B("B2B"),
    B2C("B2C");

    private String type;
    TypeClient(String type) {
        this.type = type;
    }
}
