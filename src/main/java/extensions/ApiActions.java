package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get data from server")
    public static Response get(String paramValues) {
        response = request.get(paramValues);
        return response;

    }

    @Step("Extract value from JSON")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();

    }

    @Step("Post data to server")
    public static void post(JSONObject params, String resource) {
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.post(resource);
        response.prettyPrint();

    }

    @Step("Update data to server")
    public static void put(JSONObject params, String resource) {
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.put(resource);
        response.prettyPrint();

    }

    @Step("Delete data from server")
    public static void delete(JSONObject params, String resource) {
        response = request.delete(resource);
        response.prettyPrint();

    }

}
