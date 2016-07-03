package com.example.reporter.model;

import com.google.common.collect.ImmutableList;

public class Summary {

    private final int participantCount;

    private final double participationPercentage; // XX.XX

    private final ImmutableList<RatingQuestionResult> ratingQuestionResults;

    public ImmutableList<RatingQuestionResult> getRatingQuestionResults() {
        return ratingQuestionResults;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public double getParticipationPercentage() {
        return participationPercentage;
    }

    public Summary(int participantCount, double participationPercentage, ImmutableList<RatingQuestionResult> results) {
        this.participantCount = participantCount;
        this.participationPercentage = participationPercentage;
        this.ratingQuestionResults = results;
    }
}
