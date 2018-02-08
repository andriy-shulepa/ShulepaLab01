package excel;

import analyzer.Analyzer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class that allows you to write spreadsheet to your .xlsx file.
 *
 * @author Andriy Shulepa
 */
public class ExcelWriter {
    /**
     * Function to write spreadsheet to your .xlsx file.
     *
     * @param pathname pathname of your .xlsx file.
     * @param name     name of spreadsheet you want to write.
     * @param data     data for writing that consist of names of column (Map keys) and column data (Map values).
     *                 Also it include list of arrays size with key {@link analyzer.Analyzer#ARRAY_SIZE_KEY}.
     */
    public static void writeSpreadsheet(String pathname, String name, Map<String, List<Long>> data) {
        FileInputStream in;
        XSSFWorkbook workbook;
        try {
            File file = new File(pathname);
            if (!file.exists()) {
                file.createNewFile();
            }
            in = new FileInputStream(file);
            workbook = new XSSFWorkbook(in);

            XSSFSheet spreadsheet;
            if ((spreadsheet = workbook.getSheet(name)) == null) {
                spreadsheet = workbook.createSheet(name);
            }
            ;
            int rowId = 0;
            writeRow(spreadsheet, rowId++, Analyzer.ARRAY_SIZE_KEY, data.get(Analyzer.ARRAY_SIZE_KEY));
            Set<String> keySet = data.keySet();
            keySet.remove(Analyzer.ARRAY_SIZE_KEY);

            for (String key : keySet) {
                writeRow(spreadsheet, rowId++, key, data.get(key));
            }

            in.close();
            FileOutputStream out = new FileOutputStream(new File("result.xlsx"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            Set<String> keySet = data.keySet();
//            int rowId = 0;
//
//            List<Iterator<Long>> iterators = new ArrayList<>();
//
//            //filling title row
//            int titleId = 0;
//            row = spreadsheet.createRow(rowId++);
//            for (String key : keySet) {
//                Cell cell = row.createCell(titleId++);
//                cell.setCellValue(key);
//            }
//            //initializing iterators for each sorting
//            Iterator<String> keyIterator = keySet.iterator();
//            for (int i = 0; keyIterator.hasNext(); i++) {
//                iterators.add(data.get(keyIterator.next()).iterator());
//            }
//            //filling each rowId row with i elements of each iterators
//            while (iterators.get(0).hasNext()) {
//                int cellId = 0;
//                row = spreadsheet.createRow(rowId++);
//                for (int i = 0; i < iterators.size(); i++) {
//                    Cell cell = row.createCell(cellId++);
//                    cell.setCellValue(iterators.get(i).next());
//                }
//            }


    }

    private static void writeRow(XSSFSheet sheet, int rowId, String rowName, List<Long> data) {

        int cellId = 0;
        XSSFRow row = sheet.createRow(rowId);
        Cell cell = row.createCell(cellId++);
        cell.setCellValue(rowName);
        for (Iterator<Long> iterator = data.iterator(); iterator.hasNext(); ) {
            cell = row.createCell(cellId++);
            cell.setCellValue(iterator.next());
        }
    }


}
