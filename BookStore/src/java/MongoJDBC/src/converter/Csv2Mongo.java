package converter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dataStru.C_MONGODB;

public class Csv2Mongo {
	public static class TestExcel {
		//Jsonkey: store schema 
	    private class JsonKey{
	        private String key;
	        private int cellnum;

	        public String getKey(){
	            return key;
	        }

	        public int getCellNum(){
	            return cellnum;
	        }

	        public void setKey(String key){
	            this.key = key;
	        }

	        public void setCellNum(int num){
	            this.cellnum = num;
	        }
	    };
	    //read file
	    private static Workbook readFile(String filename) throws IOException, InvalidFormatException {
	        FileInputStream fis = new FileInputStream(filename);
	        Workbook aWorkbook = null;
	        try {
				
	            return aWorkbook;
	        } finally {
	            fis.close();
	        }
	    }
	    public static void main(String[] args) {
	        JsonKey JKey[]=null;  //定义表头
	        int flag = 0;         //定义表头标志（一般是首行）
	        String oid = null ;   //存储表头的MongoDB的“_id”

//	        String curDir = System.getProperty("user.dir");
//	        System.out.println("你当前的工作目录为 :" + curDir);
	        String fileName = "src/test.xls";
	        try {
	            if (args.length < 2) {
	            	//fileName is name of ***.csv
	                Workbook wb = readFile(fileName);

	                System.out.println("Data dump:\n");
	                // get the number of spreadsheets in the workbook 
	                for (int k = 0; k < wb.getNumberOfSheets(); k++) {
	                    sheet = wb.getSheetAt(k);
	                    //Returns the number of physically defined rows (NOT the number of rows in the sheet)
	                    int rows = sheet.getPhysicalNumberOfRows();
	                    System.out.println("Sheet " + k + " \"" + wb.getSheetName(k) + "\" has " + rows + " row(s).");
	                    StringBuffer tabledef = new StringBuffer();
	                    tabledef.append("{\"TableDef\":\"" + wb.getSheetName(k) + "\",");
	                    for (int r = 0; r < rows; r++) {
	                        Row row = sheet.getRow(r);
	                        //过滤空行
	                        if (row == null) {
	                            rows++;
	                            continue;
	                        }else{
	                        	//取表头的数据，flag＝＝0表示  key has not been extracted
	                            if (flag==0){
	                            	/*
	        						 * gets the number of defined cells (NOT number of cells in the actual row!). 
	        						 * That is to say if only columns 0,4,5 have values then there would be 3.
	        						 */
	                                int cells = row.getPhysicalNumberOfCells();
	                                StringBuffer tableheader = new StringBuffer();
	                                tableheader.append("\"Columns\":[");
	                                JKey = new JsonKey[cells];
	                                //此部门用于取表头
	                                int cellnum = 0;
	                                for (int c = 0; c < cells; c++) {
	                                    HSSFCell cell = row.getCell(c);
	                                    //过滤空列
	                                    if (cell == null){
	                                        cells++;
	                                        continue;
	                                    }
	                                    JKey[cellnum] = new TestExcel().new JsonKey();

	                                    String value = null;

	                                    value = cell.getStringCellValue();
	                                    JKey[cellnum].setKey(value);
	                                    JKey[cellnum].setCellNum(c);
	                                    tableheader.append("{\"FiledName\":\"" + value + "\"}");
	                                    tableheader.append(",");
	                                    cellnum ++;
	                                }
	                                
	                                tableheader.deleteCharAt(tableheader.length()-1);
	                                tableheader.append("]}");
	                                //表头取完，准备取value
	                                flag = 1;
	                                tabledef.append(tableheader);
	                                System.out.println("TableDef " + tabledef.toString());
	                                //保存到MongoDB
	                                oid = new C_MONGODB("test","site1").saveObjectByJson(tabledef.toString(),wb.getSheetName(k));
	                                continue;
	                            }
	                        }
	                        //value extract
	                        int cells = JKey.length;
	                        StringBuffer datastr = new StringBuffer();
	                        datastr.append("{\"oid\":\"" + oid + "\",");  //标记本次导入数据的表头定义的_id
	                        for (int c = 0; c < cells; c++) {
	                            HSSFCell cell = row.getCell(JKey[c].getCellNum());

	                            String value = null;

	                            switch (cell.getCellType()) {
	                                case HSSFCell.CELL_TYPE_FORMULA:
	                                    value = "\"" + JKey[c].getKey() + "\":\"" + cell.getCellFormula() + "\"";
	                                    break;
	                                case HSSFCell.CELL_TYPE_NUMERIC:
	                                    value = "\"" + JKey[c].getKey() + "\":\"" + cell.getNumericCellValue() + "\"";
	                                    break;
	                                case HSSFCell.CELL_TYPE_STRING:
	                                    value = "\"" + JKey[c].getKey() + "\":\"" + cell.getStringCellValue() + "\"";
	                                    break;
	                                default:
	                            }
	                            if (value == null){
	                                value = "\"" + JKey[c].getKey() + "\":\"\"";;
	                            }
	                            datastr.append(value);
	                            datastr.append(",");
	                        }
	                        datastr.deleteCharAt(datastr.length()-1);
	                        datastr.append("}");
	                        new C_MONGODB("test","site1").saveObjectByJson(datastr.toString(),wb.getSheetName(k));
	                        System.out.println(datastr.toString());
	                    }
	                }
	                wb.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
