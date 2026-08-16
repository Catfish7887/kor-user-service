package ru.kor.APIresponse;

public class APIresponse {
    private String body;
    private int statusCode;

    public APIresponse(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "APIresponse{" +
                "body='" + body + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
