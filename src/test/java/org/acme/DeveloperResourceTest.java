package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class DeveloperResourceTest {

    @Order(1)
    @Test
    public void testInsertDeveloper() {
        
        Developer d = new Developer();
        d.name = "Alex";
        d.age = 41;

        given()
        .contentType(ContentType.JSON)
        .body(d)
        .when()
        .post("/developer")
        .then()
        .statusCode(200);
    }

    @Order(2)
    @Test
    public void testListDevelopers() {
        given()
          .when().get("/developer")
          .then()
             .statusCode(200)
             .assertThat()
             .body("name", hasItems("Alex"));
    }

}