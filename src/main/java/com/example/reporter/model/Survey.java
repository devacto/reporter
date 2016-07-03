package com.example.reporter.model;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

public class Survey {

    private final ImmutableList<Question> questions;

    public Survey(ImmutableList<Question> questions) {
        this.questions = questions;
    }

    public ImmutableList<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("questions", questions)
                .toString();
    }
}
