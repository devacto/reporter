package com.example.reporter;

import java.io.IOException;

import static java.lang.System.exit;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Needs 2 arguments: <path-to-survey.csv> <path-to-response.csv>");
            exit(1);
        }

        // Survey survey = SurveyParser.parse(args[0]);
        // List<Response> responses = ResponseParser.parse(args[1]);

        // Summary summary = Summariser.summarise(survey, responses)
        // ConsolePrinter.print(summary);
    }
}
