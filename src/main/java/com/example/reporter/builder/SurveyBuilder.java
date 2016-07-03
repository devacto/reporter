package com.example.reporter.builder;

import com.example.reporter.model.Question;
import com.example.reporter.model.Survey;
import com.google.common.collect.ImmutableList;

public class SurveyBuilder {

    private ImmutableList.Builder<Question> questionsBuilder;

    public SurveyBuilder() {
        this.questionsBuilder = ImmutableList.builder();
    }

    public SurveyBuilder addQuestion(String theme, Question.Type type, String text) {
        this.questionsBuilder.add(new Question(theme, type, text));
        return this;
    }

    public Survey build() {
        return new Survey(this.questionsBuilder.build());
    }
}
