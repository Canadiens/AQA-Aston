package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanTest {
    @BeforeEach
    public void config() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetWoops() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get("/get").then().log().all().statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", containsString("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
    @Test
    void testGet() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get("/get").then().log().all().statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
    @Test
    void testPostText() {
        given()
                .body("post body")
                .when().post("/post").then().log().all().statusCode(200)
                .body("data", equalTo("post body"))
                .body("args.get(0)", equalTo(null))
                .body("files.get(0)", equalTo(null))
                .body("form.get(0)", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-length", equalTo("9"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    void testPostData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post("/post").then().log().body().statusCode(200)
                .body("args.get(0)", equalTo(null))
                .body("data", equalTo(""))
                .body("files.get(0)", equalTo(null))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-length", equalTo("19"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    void testPut() {
        given()
                .header("Content-Type", "application/json")
                .when().put("/put").then().log().body().statusCode(200)
                .body("args.get(0)", equalTo(null))
                .body("data.get(0)", equalTo(null))
                .body("files.get(0)", equalTo(null))
                .body("form.get(0)", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
    @Test
    void testPatch() {
        given()
                .header("Content-Type", "application/json")
                .when().patch("/patch").then().log().body().statusCode(200)
                .body("args.get(0)", equalTo(null))
                .body("data.get(0)", equalTo(null))
                .body("files.get(0)", equalTo(null))
                .body("form.get(0)", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    void testDelete() {
        given()
                .header("Content-Type", "application/json")
                .when().delete("/delete").then().log().body().statusCode(200)
                .body("args.get(0)", equalTo(null))
                .body("data.get(0)", equalTo(null))
                .body("files.get(0)", equalTo(null))
                .body("form.get(0)", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.8)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}