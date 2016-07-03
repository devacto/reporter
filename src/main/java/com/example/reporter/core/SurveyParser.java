package com.example.reporter.core;

import com.example.reporter.builder.SurveyBuilder;
import com.example.reporter.model.Question;
import com.example.reporter.model.Survey;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SurveyParser {

    public static Survey parse(String path) throws IOException {
        SurveyBuilder builder = new SurveyBuilder();

        InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");

        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);

        for (CSVRecord record : records) {

            String theme = record.get("theme");
            Question.Type type = convertToType(record.get("type"));
            String text = record.get("text");

            builder.addQuestion(theme, type, text);
        }

        return builder.build();
    }

    private static Question.Type convertToType(String questionType) {
        Question.Type type;

        if (questionType.equalsIgnoreCase("ratingquestion")) {
            type = Question.Type.RATING;
        } else {
            type = Question.Type.SINGLE_SELECT;
        }

        return type;
    }

}
