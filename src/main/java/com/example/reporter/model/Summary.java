package com.example.reporter.model;

import com.google.common.collect.ImmutableList;

public class Summary {

    private final int participantCount;

    private final double participationRate; // 0.XX

    private final ImmutableList<RatingQuestionResult> ratingQuestionResults;

    public ImmutableList<RatingQuestionResult> getRatingQuestionResults() {
        return ratingQuestionResults;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public double getParticipationRate() {
        return participationRate;
    }

    public Summary(int participantCount, double participationRate, ImmutableList<RatingQuestionResult> results) {
        this.participantCount = participantCount;
        this.participationRate = participationRate;
        this.ratingQuestionResults = results;
    }
}
