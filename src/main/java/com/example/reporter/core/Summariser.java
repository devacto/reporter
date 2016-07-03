package com.example.reporter.core;

import com.example.reporter.builder.SummaryBuilder;
import com.example.reporter.model.Question;
import com.example.reporter.model.Response;
import com.example.reporter.model.Summary;
import com.example.reporter.model.Survey;
import com.google.common.base.Strings;

import java.util.List;
import java.util.stream.Collectors;

public class Summariser {

    public static Summary summarise(Survey s, List<Response> response) {

        List<Question> questions = s.getQuestions();

        List<Response> submittedResponses = response.stream()
                                                   .filter(Response::submitted)
                                                   .collect(Collectors.toList());

        SummaryBuilder builder = new SummaryBuilder();

        builder.count(submittedResponses.size())
               .participationRate((double) submittedResponses.size() / (double) response.size());

        questions.stream()
                 .filter(Question::ratingQuestion)
                 .forEach(q -> builder.addResult(q.getText(), calculateAverage(submittedResponses, questions.indexOf(q))));

        return builder.build();
    }

    private static double calculateAverage(List<Response> responses, int questionIndex) {

        List<Response> validResponses =
                responses
                        .stream()
                        .filter(Response::submitted)
                        .filter(r -> !Strings.isNullOrEmpty(r.getAnswers().get(questionIndex)))
                        .collect(Collectors.toList());

        double ratingTotal = 0.0;

        for (Response r : validResponses) {
            ratingTotal += Double.parseDouble(r.getAnswers().get(questionIndex));
        }

        double averageRating = ratingTotal / (double) validResponses.size();

        return averageRating;
    }
}
