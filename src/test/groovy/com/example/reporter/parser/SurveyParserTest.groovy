package com.example.reporter.parser

import com.example.reporter.model.Question
import com.example.reporter.model.Survey
import org.junit.Test

class SurveyParserTest {

    @Test
    void "should parse a survey file"() {
        Survey survey = SurveyParser.parse('./example-data/survey-1.csv')

        assert survey.questions.first().theme == 'The Work'
        assert survey.questions.first().type  == Question.Type.RATING
        assert survey.questions.first().text  == 'I like the kind of work I do.'
    }

    @Test
    void "should parse a survey file with different header arrangement"() {
        Survey survey = SurveyParser.parse('./example-data/survey-3.csv')

        assert survey.questions.first().theme == 'The Work'
        assert survey.questions.first().type  == Question.Type.RATING
        assert survey.questions.first().text  == 'I like the kind of work I do.'
    }

    @Test(expected = IOException)
    void "should throw IOException given wrong file"() {
        SurveyParser.parse('i-do-not-exist.csv')
    }
}
