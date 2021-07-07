package com.gridu.phonebookmvc.apiTest;

import com.gridu.phonebookmvc.constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class RestTest {

    @Test
     public void getAllTest() {
        int responseCode = given().when().get(Endpoints.BASEPATHL+Endpoints.ENDPOINT_ALL).getStatusCode();
        assertThat(responseCode, equalTo(HttpStatus.FOUND));

    }
}
