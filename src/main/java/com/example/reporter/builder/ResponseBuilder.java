package com.example.reporter.builder;

import com.example.reporter.model.Response;
import com.google.common.collect.ImmutableList;

public class ResponseBuilder {

    private String employeeEmail;

    private String employeeId;

    private String submittedAt;

    private final ImmutableList.Builder<String> answersBuilder;

    public ResponseBuilder() {
        this.answersBuilder = ImmutableList.builder();
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
        this.answersBuilder.add(answer);
        return this;
    }

    public Response build() {
        return new Response(employeeEmail, employeeId, submittedAt, this.answersBuilder.build());
    }
}
