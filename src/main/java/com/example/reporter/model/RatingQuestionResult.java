package com.example.reporter.model;

public class RatingQuestionResult {

    private final String question;

    private final double averageRating;

    public String getQuestion() {
        return question;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public RatingQuestionResult(String q, double averageRating) {
        this.question = q;
        this.averageRating = averageRating;
    }
}
