package md.electro.model.enums;

public enum VoucherAccountEnum {
    ACTIVE("Active"),
    BROKEN("Broken"),
    SUCCESS("Success");

    private final String value;

    VoucherAccountEnum(String status) {
        this.value = status;
    }
    public String getValue() {
        return value;
    }

}
