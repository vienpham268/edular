package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDatas {

    private static XSSFWorkbook workbook;

    public static List<String> getDataFromExcel(String path, int column) {
        List<String> listString = new ArrayList<String>();
        try {
            FileInputStream file = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFCell cell;
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                cell = row.getCell(column);
                if (cell.getCellType() == CellType.STRING) {
                    listString.add(new String(cell.getStringCellValue().getBytes(StandardCharsets.UTF_8)));

                }
                if (cell.getCellType() == CellType.NUMERIC) {
                    listString.add("0".concat(
                            new String(String.valueOf(cell.getNumericCellValue()).getBytes(StandardCharsets.UTF_8))
                                    .split("\\.")[0]));

                }
            }

            return listString;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
