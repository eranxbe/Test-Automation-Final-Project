package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    public enum categoriesEnum {
        animal,
        career,
        celebrity,
        dev,
        explicit,
        fashion,
        food,
        history,
        money,
        movie,
        music,
        political,
        religion,
        science,
        sport,
        travel
    }

    @Step("Business Flow: Get Random Joke")
    public static String getRandomJoke(String jPath) {
        response = ApiActions.get("/random");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Get Random Joke by category")
    public static String getRandomJokeByCategory(String jPath, categoriesEnum category) {
        response = ApiActions.get("/random?category=" + category);
        return ApiActions.extractFromJSON(response, jPath);
    }

}
