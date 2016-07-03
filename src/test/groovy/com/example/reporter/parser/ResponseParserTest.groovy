package com.example.reporter.parser

import com.example.reporter.model.Response
import org.junit.Test

class ResponseParserTest {

    @Test
    void "should correctly parse a survey response file"() {
        List<Response> responses = ResponseParser.parse('./example-data/survey-1-responses.csv')
        Response firstResponse = responses.first()

        assert firstResponse.employeeEmail   == 'employee1@abc.xyz'
        assert firstResponse.answers.first() == '5'
        assert firstResponse.answers.last()  == '4'
    }

    @Test(expected = IOException)
    void "should throw IOException when given wrong path"() {
        ResponseParser.parse('i-do-not-exist.csv')
    }
}
