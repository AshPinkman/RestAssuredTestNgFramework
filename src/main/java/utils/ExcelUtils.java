package utils;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils(){

    }

    @SneakyThrows
    public static Object[] getData()  {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/userdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("userdata");
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[] data = new Object[rows];
        Map<String,String> map;
        for (int i = 1; i <= rows; i++) {
            map = new HashMap<>();
            for (int j = 0; j < cols; j++) {
                DataFormatter formatter = new DataFormatter();
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                XSSFCell cell = sheet.getRow(i).getCell(j);
                String value = formatter.formatCellValue(cell);
                map.put(key,value);
            }
            data[i-1] = map;
        }
        workbook.close();
        fis.close();
        return data;
    }

}
