package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ElectronFlows extends UIActions {

    @Step("Add new task to the list")
    public static void addNewTask(String taskName) {
        UIActions.clickElement(todoMain.txt_taskNameInput);
        UIActions.fillText(todoMain.txt_taskNameInput, taskName);
        UIActions.insertKey(todoMain.txt_taskNameInput, Keys.RETURN);
    }

    @Step("Count and return number of tasks on the list")
    public static int getTaskCount() {
        return todoMain.list_tasks.size();
    }

    @Step("Remove all tasks from list")
    public static void removeAllTasks() {
        for (int i = 0; i <= getTaskCount(); i++) {
            UIActions.mouseHover(todoMain.btn_x);
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        }

    }

    @Step("Copy Tasks to Clipboard")
    public static String getClipboardData() throws IOException, UnsupportedFlavorException {
        UIActions.clickElement(todoMain.btn_copy_to_clipboard);
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    @Step("Mark Task As Completed")
    public static void completeAllTasks() {
        for (WebElement task : todoMain.list_tasks) {
            todoMain.btn_complete_task.click();
        }


    }


}
