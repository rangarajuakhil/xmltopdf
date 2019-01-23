package com.jms.xmltopdf.payload;

public class PurgeAllResponse {
    private String operation;
    private String message;

    public PurgeAllResponse(String operation, String message) {
        this.operation = operation;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
