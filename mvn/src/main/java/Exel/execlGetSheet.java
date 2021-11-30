package Exel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class execlGetSheet {

	public static void main(String args[]) throws IOException {
		getRowData("Purchase");
	}
	
	public static void getRowData(String rowName) throws IOException {
		ArrayList<String> rowData = new ArrayList<String>();
		FileInputStream fil = new FileInputStream("D:\\Udmey\\DemoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		int numberOfSheets = workbook.getNumberOfSheets();
		for(int i=0; i<numberOfSheets; i++) {
			if(workbook.getSheetName(i).contains("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator <Row> rows = sheet.iterator();
				Row nextRow = rows.next();
				Iterator<Cell> cell = nextRow.cellIterator();
				int k=0;
				int colIndex=0;
				while(cell.hasNext()) {
					Cell cellData = cell.next();
					if(cellData.getStringCellValue().equals("Test case")) 
					{
						colIndex = k;
					}
					k++;
				}
				System.out.println("Desired data is on column index: " +colIndex);
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(colIndex).getStringCellValue().equalsIgnoreCase(rowName))
					{
						Iterator<Cell> cd = r.cellIterator();
						while(cd.hasNext()) {
							Cell c = cd.next();
							if(c.getCellType()==CellType.STRING) {
								//System.out.println(cd.next().getStringCellValue());
								rowData.add(cd.next().getStringCellValue());
							}
							else
							{
								rowData.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
					
				}
			}
			
		}
		System.out.println(rowData);
	}
}
