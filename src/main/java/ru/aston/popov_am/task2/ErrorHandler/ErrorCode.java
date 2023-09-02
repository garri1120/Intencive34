package ru.aston.popov_am.task2.ErrorHandler;

public enum ErrorCode {
    INVALID_ITEM_PRICE_ENTERED(1);
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
