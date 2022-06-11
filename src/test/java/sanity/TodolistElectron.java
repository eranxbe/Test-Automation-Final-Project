package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


@Listeners(utilities.Listeners.class)
public class TodolistElectron extends CommonOps {
    @Test(description = "Test 01 - Add task and verify created")
    @Description("This test adds a new task verifies on the list")
    public void test01_addTaskAndVerify() {
        ElectronFlows.addNewTask("Task 1");
        ElectronFlows.addNewTask("And this is Task 2");
        Verifications.assertNumber(ElectronFlows.getTaskCount(), 2);
    }

    @Test(description = "Test 02 - Verify Copy to Clipboard functionality")
    @Description("This test adds new tasks verifies on the list")
    public void test02_validateClipboardContainsTasks() throws IOException, UnsupportedFlavorException {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Clean Room");
        Verifications.assertTextContains( "Here is my task list:", ElectronFlows.getClipboardData());

    }

    @Test(description = "Test 03 - Add 2 Tasks and Complete Them")
    @Description("This test adds 2 tasks and completes Them")
    public void test03_CompleteTasks()  {
        ElectronFlows.addNewTask("Pet Cats");
        ElectronFlows.addNewTask("Pet Dogs");
        ElectronFlows.completeAllTasks();
        Verifications.visibilityOfElement(todoMain.completed_task_vee);

    }




}
