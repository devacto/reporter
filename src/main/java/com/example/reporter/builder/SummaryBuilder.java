package com.example.reporter.builder;

import com.example.reporter.model.RatingQuestionResult;
import com.example.reporter.model.Summary;
import com.google.common.collect.ImmutableList;

public class SummaryBuilder {

    private int participantCount;

    private double participationPercentage;

    private final ImmutableList.Builder<RatingQuestionResult> resultsBuilder;

    public SummaryBuilder() {
        this.resultsBuilder = ImmutableList.builder();
    }

    public SummaryBuilder count(int participantCount) {
        this.participantCount = participantCount;
        return this;
    }

    public SummaryBuilder participationRate(double participationPercentage) {
        this.participationPercentage = participationPercentage;
        return this;
    }

    public SummaryBuilder addResult(String question, double avg) {
        RatingQuestionResult r = new RatingQuestionResult(question, avg);
        resultsBuilder.add(r);
        return this;
    }

    public Summary build() {
        return new Summary(participantCount, participationPercentage, resultsBuilder.build());
    }
}
