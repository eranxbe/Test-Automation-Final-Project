package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static org.testng.Assert.fail;

public class ManageDDT extends CommonOps{

    @DataProvider(name = "data-provider-bmi")
    public Object[][] getDataObjectBMI() {
        return getDataFromCSV(getData("DDTFileBMI"));
    }

    @DataProvider(name = "data-provider-calculator")
    public Object[][] getDataObjectCalculator() {
        return getDataFromCSV(getData("DDTFileCalculator"));
    }

    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try{
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            fail("Error while reading CSV File: " + e);
        }
        return lines;
    }

    public static Object[][] getDataFromCSV(String filePath) {
        Object[][] data = new Object[4][4];
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
            data[i][2] = csvData.get(i).split(",")[2];
            data[i][3] = csvData.get(i).split(",")[3];
        }
        return data;
    }

}
