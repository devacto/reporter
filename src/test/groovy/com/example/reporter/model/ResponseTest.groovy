package com.example.reporter.model

import com.google.common.collect.ImmutableList
import groovy.transform.CompileStatic
import org.junit.Test

@CompileStatic
class ResponseTest {

    @Test
    void "empty submission time means not submitted"() {

        Response r = new Response('abc@def', '1', '', ImmutableList.builder().build())
        assert !r.submitted()
    }
}
