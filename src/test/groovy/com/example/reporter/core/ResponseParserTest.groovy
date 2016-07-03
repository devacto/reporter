package com.example.reporter.core

import com.example.reporter.model.Response
import groovy.transform.CompileStatic
import org.junit.Before
import org.junit.Test

@CompileStatic
class ResponseParserTest {

    private List<Response> responses

    @Before
    void setup() {
        responses = ResponseParser.parse('./example-data/survey-1-responses.csv')
    }

    @Test
    void "parses a survey response file"() {
        Response firstResponse = responses.first()

        assert firstResponse.employeeEmail   == 'employee1@abc.xyz'
        assert firstResponse.answers.first() == '5'
        assert firstResponse.answers.last()  == '4'
    }

    @Test(expected = IOException)
    void "throws IOException when given wrong path"() {
        ResponseParser.parse('i-do-not-exist.csv')
    }
}
