package com.example.reporter.parser;

import com.example.reporter.builder.ResponseBuilder;
import com.example.reporter.model.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResponseParser {

    public static final int ANSWER_STARTING_INDEX = 3;

    public static List<Response> parse(String path) throws IOException {

        InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");

        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);

        List<Response> responses = new ArrayList<>();

        for (CSVRecord record : records) {

            ResponseBuilder builder = new ResponseBuilder();

            // Adding a single row.
            builder.email(record.get(0))
                   .employeeId(record.get(1))
                   .submittedAt(record.get(2));

            for (int i = ANSWER_STARTING_INDEX; i < record.size(); i++) {
                builder.addAnswer(record.get(i));
            }

            responses.add(builder.build());
        }

        return responses;
    }

}
