package org.ddt;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
    /**
     * Generic util to read data out from 97-2003 excel format
     */

    private Sheet sheet = null;
    private Hashtable<String, Integer> colMapping = new Hashtable<>();

    /**
     * Constructor to instantiate work book/sheet and prepare a
     * mapping dict with column name and its index
     */
    public ExcelReader(String path) {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(path));
            sheet = workbook.getSheet("Sheet1");
            constructColumnDictionary();
        }
        catch (BiffException | IOException e) {
            // Above with '|' operator is an example of java multi catch statement
            // which allows to avoid duplication of similar catch blocks
            e.printStackTrace();
        }

    }

    /**
     * Method to read header row and construct mapping between
     * column name and its index
     */
    private void constructColumnDictionary() {

        for (int colIdx = 0; colIdx < sheet.getColumns(); colIdx++) {
            String cellVal = getCellValue(colIdx, 0);
            colMapping.put(cellVal, colIdx);
        }
    }

    /**
     * Reads and returns a specific row and column value from Sheet 0 of the
     provided excel workbook.
     * @param colNum column no to read
     * @param rowNum row no to read
     * @return cell value
     */
    public String getCellValue(int colNum, int rowNum) {
        return sheet.getCell(colNum, rowNum).getContents();
    }

    /**
     * Gets column index from the mapping dict
     * @param colName name of column name in excel
     * @return index of column name
     */
    public int getColumnIndex(String colName) {
        return colMapping.get(colName);
    }
}
