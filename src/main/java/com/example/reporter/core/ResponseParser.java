package com.example.reporter.core;

import com.example.reporter.builder.ResponseBuilder;
import com.example.reporter.model.Response;
import com.google.common.collect.ImmutableList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResponseParser {

    public static final int ANSWER_STARTING_INDEX = 3;

    public static ImmutableList<Response> parse(String path) throws IOException {

        InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");

        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);

        ImmutableList.Builder responseListBuilder = ImmutableList.builder();

        for (CSVRecord record : records) {
            ResponseBuilder builder = new ResponseBuilder();

            builder.email(record.get(0))
                   .employeeId(record.get(1))
                   .submittedAt(record.get(2));

            for (int i = ANSWER_STARTING_INDEX; i < record.size(); i++) {
                builder.addAnswer(record.get(i));
            }

            responseListBuilder.add(builder.build());
        }

        return responseListBuilder.build();
    }

}
