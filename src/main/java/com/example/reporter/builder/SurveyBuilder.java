package com.example.reporter.builder;

import com.example.reporter.model.Question;
import com.example.reporter.model.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyBuilder {

    private List<Question> questions;

    public SurveyBuilder() {
        this.questions = new ArrayList<>();
    }

    public SurveyBuilder addQuestion(String theme, Question.Type type, String text) {
        this.questions.add(new Question(theme, type, text));
        return this;
    }

    public Survey build() {
        return new Survey(this.questions);
    }
}
