package com.proof.between.exception;

public enum ErrorTypeCode implements ErrorType {

    DATE_NOT_VALID("ERR-001", "Sorry date format not valid please use yyyy-MM-dd-HH.mm.ss"),

    BRAND_ID_OR_PRODUCT_ID_NOT_VALID("ERR-002", "Sorry brand or product id must be number.");

    private final String code;
    private final String description;

    ErrorTypeCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
