package com.example.reporter.builder;

import com.example.reporter.model.Response;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {

    private String employeeEmail;

    private String employeeId;

    private String submittedAt;

    private List<String> answers;

    public ResponseBuilder() {
        this.answers = new ArrayList<>();
    }

    public ResponseBuilder email(String employeeEmail) {
        this.employeeEmail = employeeEmail;
        return this;
    }

    public ResponseBuilder employeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public ResponseBuilder submittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
        return this;
    }

    public ResponseBuilder addAnswer(String answer) {
        this.answers.add(answer);
        return this;
    }

    public Response build() {
        return new Response(employeeEmail, employeeId, submittedAt, this.answers);
    }
}
