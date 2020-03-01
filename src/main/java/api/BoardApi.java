package api;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;

import java.util.HashMap;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.Method.*;
import static utils.PropertiesProvider.getPropertyByName;

public class BoardApi {

    private static final String BOARDS_PATH = "https://api.trello.com/1/boards/";
    private static final String PROPERTY_TOKEN = getPropertyByName("token");
    private static final String PROPERTY_KEY = getPropertyByName("key");

    private HashMap<String, String> params = new HashMap<>();

    private BoardApi() {}

    public static BoardApiBuilder with() {
        return new BoardApiBuilder(new BoardApi());
    }

    private static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .addQueryParam("key", PROPERTY_KEY)
                .addQueryParam("token", PROPERTY_TOKEN)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    private static Board makeBoardFromResponce(Response response) {
        return new Gson().fromJson(response.asString().trim(),new TypeToken<Board>() {}.getType());
    }

    public static class BoardApiBuilder {

        private BoardApi boardApi;

        private BoardApiBuilder(BoardApi boardApi) {
            this.boardApi = boardApi;
        }

        public BoardApiBuilder setName(String name) {
            boardApi.params.put("name", name);
            return this;
        }

        public BoardApiBuilder setDescription(String desc) {
            boardApi.params.put("desc", desc);
            return this;
        }

        public BoardApiBuilder setColor(String color) {
            boardApi.params.put("prefs/background", color);
            return this;
        }

        public BoardApiBuilder setClosed(Boolean isClosed) {
            boardApi.params.put("closed", isClosed.toString());
            return this;
        }

        public Response getResponse(String id) {
            return RestAssured.with()
                    .queryParam("id", id)
                    .queryParams(boardApi.params)
                    .spec(requestSpecification())
                    .baseUri(BOARDS_PATH + id)
                    .log().all()
                    .request(GET)
                    .prettyPeek();
        }

        public Board createBoard() {
            Response response = RestAssured.with()
                    .queryParam("name", RandomStringUtils.randomAlphanumeric(10))
                    .queryParam("desc", RandomStringUtils.randomAlphanumeric(10))
                    .queryParams(boardApi.params)
                    .spec(requestSpecification())
                    .baseUri(BOARDS_PATH)
                    .log().all()
                    .request(POST)
                    .prettyPeek();
            return makeBoardFromResponce(response);
        }

        public Board editBoard(String id) {
            Response response = RestAssured.with()
                    .queryParams(boardApi.params)
                    .spec(requestSpecification())
                    .baseUri(BOARDS_PATH + id)
                    .log().all()
                    .request(PUT)
                    .prettyPeek();
            return makeBoardFromResponce(response);
        }

        public void removeBoard(String id) {
            RestAssured.with()
                    .queryParams(boardApi.params)
                    .spec(requestSpecification())
                    .baseUri(BOARDS_PATH + id)
                    .log().all()
                    .request(DELETE)
                    .prettyPeek();
        }
    }
}