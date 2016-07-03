package com.example.reporter;

import com.example.reporter.model.RatingQuestionResult;
import com.example.reporter.model.Summary;

class ConsolePrinter {

    public static final double ONE_HUNDRED = 100.0;

    static void print(Summary s) {

        System.out.println("----------------------------------------------");
        System.out.println("Survey Summary");
        System.out.println("----------------------------------------------");
        System.out.printf("Participant count: %d%n", s.getParticipantCount());
        System.out.printf("Participation percentage: %.1f%n", s.getParticipationRate() * ONE_HUNDRED);
        System.out.println("----------------------------------------------");

        for (RatingQuestionResult r : s.getRatingQuestionResults()) {
            System.out.println();
            System.out.printf("Q: %s%n", r.getQuestion());
            System.out.printf("Average rating: %.1f%n", r.getAverageRating());
        }

        System.out.println("----------------------------------------------");

    }
}
