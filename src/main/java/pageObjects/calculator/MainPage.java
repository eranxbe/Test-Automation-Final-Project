package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.HashMap;

public class MainPage {

    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;

    @FindBy(how = How.NAME, using = "Two")
    public WebElement btn_two;

    @FindBy(how = How.NAME, using = "Three")
    public WebElement btn_three;

    @FindBy(how = How.NAME, using = "Four")
    public WebElement btn_four;

    @FindBy(how = How.NAME, using = "Five")
    public WebElement btn_five;

    @FindBy(how = How.NAME, using = "Six")
    public WebElement btn_six;

    @FindBy(how = How.NAME, using = "Seven")
    public WebElement btn_seven;

    @FindBy(how = How.NAME, using = "Eight")
    public WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Nine")
    public WebElement btn_nine;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;

    @FindBy(how = How.NAME, using = "Minus")
    public WebElement btn_minus;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='multiplyButton']")
    public WebElement btn_multiply;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='divideButton']")
    public WebElement btn_divide;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='backSpaceButton']")
    public WebElement btn_backspace;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;


    public WebElement buttonsMap(String value){
        HashMap<String, WebElement> buttons = new HashMap<>();
        buttons.put("1", btn_one);
        buttons.put("2", btn_two);
        buttons.put("3", btn_three);
        buttons.put("4", btn_four);
        buttons.put("5", btn_five);
        buttons.put("6", btn_six);
        buttons.put("7", btn_seven);
        buttons.put("8", btn_eight);
        buttons.put("9", btn_nine);
        buttons.put("+", btn_plus);
        buttons.put("-", btn_minus);
        buttons.put("*", btn_multiply);
        buttons.put(":", btn_divide);
        return buttons.get(value);
    }


}
