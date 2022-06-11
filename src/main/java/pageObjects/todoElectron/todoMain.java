package pageObjects.todoElectron;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class todoMain {

    @FindBy(how = How.XPATH, using = "//div[@class=\"wrapper_3Uk1J\"]/input")
    public WebElement txt_taskNameInput;

    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90")
    public List<WebElement> list_tasks;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_x;

    @FindBy(how = How.XPATH, using = "//div[@class='icons_MDNeU']/*[2]")
    public WebElement btn_copy_to_clipboard;

    @FindBy(how = How.XPATH, using = "//div[@class=\"view_2Ow90\"]/label/*/*")
    public WebElement completed_task_vee;

    @FindBy(how = How.XPATH, using = "//*[@class='view_2Ow90']/label")
    public WebElement btn_complete_task;

    @FindBy(how = How.XPATH, using = "//div[@class=\"taskWrapper_2u8dN\"]/*/div/div/label")
    public WebElement label_task_name;



}
