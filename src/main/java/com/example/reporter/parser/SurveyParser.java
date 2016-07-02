package com.example.reporter.parser;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class SurveyParser {

    public static void parse(String path) {

        try {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            // Do not read the first line which is the header line.
            reader.readNext();

            // Read the second line onwards.
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.printf("%s %s %s %n", nextLine[0], nextLine[1], nextLine[2]);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            exit(1);
        }

    }

}
