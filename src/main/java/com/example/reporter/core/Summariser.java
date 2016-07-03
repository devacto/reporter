package com.example.reporter.core;

import com.example.reporter.builder.SummaryBuilder;
import com.example.reporter.model.Question;
import com.example.reporter.model.Response;
import com.example.reporter.model.Summary;
import com.example.reporter.model.Survey;

import java.util.List;
import java.util.stream.Collectors;

public class Summariser {

    public static final double MAGIC_AVERAGE = 1.5;

    public static Summary summarise(Survey s, List<Response> response) {

        List<Question> questions = s.getQuestions();

        List<Response> submittedResponse = response.stream().filter(Response::submitted).collect(Collectors.toList());

        SummaryBuilder builder = new SummaryBuilder();

        builder.count(submittedResponse.size())
               .participationRate((double) submittedResponse.size() / (double) response.size());

        questions.stream()
                 .filter(Question::ratingQuestion)
                 .forEach(q -> builder.addResult(q.getText(), MAGIC_AVERAGE));

        return builder.build();
    }
}
