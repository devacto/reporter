package com.example.reporter;

import com.example.reporter.model.Survey;
import com.example.reporter.parser.SurveyParser;

import java.io.IOException;

import static java.lang.System.exit;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Needs 2 arguments: <path-to-survey.csv> <path-to-response.csv>");
            exit(1);
        }

        Survey survey = SurveyParser.parse(args[0]);
        System.out.println(survey.toString());
    }
}
