package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class ChuckNorrisAPI extends CommonOps {

    @Test(description = "Test 01: Get Random Joke")
    @Description("Business Flow: Get Random Joke")
    public static void test01_getRandomJoke() {
        String joke = ApiFlows.getRandomJoke("value");
        System.out.println(joke);
        Verifications.assertTextContains("Chuck Norris", joke);

    }

    @Test(description = "Test 02: Get Random Food Joke")
    @Description("Business Flow: Get Random Food Joke and Verify Category")
    public static void test02_getRandomFoodJoke() {
        String foodJoke = ApiFlows.getRandomJokeByCategory("value", ApiFlows.categoriesEnum.food);
        String category = ApiActions.extractFromJSON(response, "categories");
        System.out.println(foodJoke);
        Verifications.assertText(String.valueOf(ApiFlows.categoriesEnum.food), category.substring(1, category.length() - 1));

    }
}
