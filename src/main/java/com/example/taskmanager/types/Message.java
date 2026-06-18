package com.example.taskmanager.types;

public class Message {
    private Types.Code status;
    private String message;

    public Types.Code getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(Types.Code status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(Types.Code status, String message) {
        setMessage(message);
        setStatus(status);
    }
}
