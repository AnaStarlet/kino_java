package com.kino.kinobackend;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class KinoApiTest {

    String baseUrl = "http://localhost:8080";

    @Test
    void testGetAllFilms() {
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/films")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5))
                .body("[0].title", equalTo("Inception"));
    }

    @Test
    void testRegisterUser() {
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Test\",\"email\":\"newuser@test.com\",\"password\":\"123\"}")
                .when()
                .post("/api/auth/register")
                .then()
                .statusCode(200)
                .body(containsString("Успешная регистрация"));
    }
}