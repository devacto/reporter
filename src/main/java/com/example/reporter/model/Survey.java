package com.example.reporter.model;

import com.google.common.base.MoreObjects;

import java.util.List;

public class Survey {

    private final List<Question> questions;

    public Survey(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("questions", questions)
                .toString();
    }
}
