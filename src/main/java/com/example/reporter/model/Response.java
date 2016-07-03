package com.example.reporter.model;

import com.google.common.base.MoreObjects;

import java.util.List;

public class Response {

    private String employeeEmail;

    private String employeeId;

    private String submittedAt;

    private List<String> answers;

    public Response(String employeeEmail, String employeeId, String submittedAt, List<String> answers) {
        this.employeeEmail = employeeEmail;
        this.employeeId = employeeId;
        this.submittedAt = submittedAt;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("employeeEmail", employeeEmail)
                .add("employeeId", employeeId)
                .add("submittedAt", submittedAt)
                .add("answers", answers)
                .toString();
    }
}
