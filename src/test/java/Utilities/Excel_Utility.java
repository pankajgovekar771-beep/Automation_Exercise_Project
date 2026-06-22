package Utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;


public class Excel_Utility {

	public static String getData(
            String sheet,
            int row,
            int col) throws Exception {

        FileInputStream fis =
            new FileInputStream(
            "src\\test\\resources\\AEProject_Data.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sh = wb.getSheet(sheet);

        String value =
          sh.getRow(row).getCell(col).getStringCellValue();

        wb.close();

        return value;
    }
}