package com.example.reporter.core

import com.example.reporter.model.Question
import com.example.reporter.model.Response
import com.example.reporter.model.Summary
import com.example.reporter.model.Survey
import groovy.transform.CompileStatic
import org.junit.Before
import org.junit.Test

@CompileStatic
class SummariserTest {

    private Survey survey

    private List<Response> responses

    private Summary summary

    @Before
    void setup() {
        Question q1 = new Question('The Work', Question.Type.RATING, 'I like working here.')
        Question q2 = new Question('The Work', Question.Type.SINGLE_SELECT, 'Manager')

        survey = new Survey([q1, q2])

        Response r1 = new Response('abc@def', '1', '2016-01-01', ['5', 'Victor'])
        Response r2 = new Response('ghi@jkl', '2', '2016-02-01', ['2', 'Victor'])
        Response r3 = new Response('mno@pqr', '3', '', ['3', 'Victor'])

        responses = [r1, r2, r3]

        summary = Summariser.summarise(survey, responses)
    }

    @Test
    void "only takes into account rating questions"() {
        assert summary.ratingQuestionResults.size() == 1
    }

    @Test
    void "inserts correct question text"() {
        assert summary.ratingQuestionResults.first().question == 'I like working here.'
    }

    @Test
    void "calculates the correct average rating"() {
        assert summary.ratingQuestionResults.first().averageRating == (double) 1.5
    }

    @Test
    void "calculates the correct number of participants"() {
        assert summary.participantCount == 2
    }

    @Test
    void "calculates the correct participation rate"() {
        assert summary.participationPercentage == (double) 2 / (double) 3
    }
}
