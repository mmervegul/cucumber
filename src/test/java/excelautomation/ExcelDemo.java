package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelDemo {

    @Test
    public void readXLFile() throws Exception {

        // path to the Excel document
        String path = "/Users/merve/Documents/Countries.xls";

        // Open file and convert to stream of data
        FileInputStream inputStream = new FileInputStream(path);

        // WORKBOOK > WORKSHEET > ROW > CELL

        // Open the WorkBook. Any type
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Go to the First WorkSheet. Index 0
        Sheet worksheet = workbook.getSheetAt(0);

        // Go to the First Row
        Row row = worksheet.getRow(0);

        // Go to first 2 Cells
        Cell cell1 = row.getCell(0);
        Cell cell2 = row.getCell(1);

        //print cell values
        System.out.println(cell1.toString());
        System.out.println(cell2.toString());


        // read cell value using method chaining
        String country1 = worksheet.getRow(1).getCell(0).toString();
        String capital1 = workbook.getSheetAt(0).getRow(1).getCell(1).toString();

        System.out.println("Country1 : " + country1);
        System.out.println("Capital1 : " + capital1);

        // get capital and country names with for loop
        int rowsCount = worksheet.getLastRowNum(); // 14
        System.out.println("Number of rows : " + rowsCount);

        for (int i = 1; i <= rowsCount; i++){
            System.out.println("Country #" + i + " : " + worksheet.getRow(i).getCell(0).toString() +
                                        " ==> " + worksheet.getRow(i).getCell(1));
        }

        // loop again and add country and capital city values into a Map

        Map<String, String> countriesMap = new HashMap<>();

        for (int rowNum = 1; rowNum <= rowsCount; rowNum++){
            String country = worksheet
                            .getRow(rowNum)
                            .getCell(0)
                            .toString();

            String capital = worksheet
                            .getRow(rowNum)
                            .getCell(1)
                            .toString();

            countriesMap.put(country, capital);
        }

        System.out.println(countriesMap);


        // close workbook and steam
        workbook.close();
        inputStream.close();









































    }

}
