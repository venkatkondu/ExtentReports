package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetUtility {
	/*
	In this class what I have to cover is 

	0 -  I create one constructor for Loading(fis) and closing(fos) the Excel file

Done-	1 - Load the ExcelSheet into this program 
Done-	2 - Create New Sheet with Name --- public void createSheet(String sheetName);// if sheet name is not exists in that workbook then only that Sheet is 												created
Done-	3 - Remove the Sheet with Name --- public void removeSheet(String sheetName);// if sheet is exist then only this operation is performed

Done-	4 - get the last row Number of the sheet -- public  getLastRowNumber(String sheetName);// first that sheet is available or not, for that I will 			use above functions  
Done-	5 - get the last column Number of the row -- public getLastColNumber(String sheetName, int rowNumber);// first I will check that sheet is available or not then after I will perform that operation 

	5.2 - get the Cell Data in String format -- public String getCellData(String sheetName,String column name,int rowNumber);//  
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	// below these are get the row Data in String format and List<String> format 

Done-	6 - get the Row Data in List<String> format -- public List<String> getRowList(String sheetName,int rowNumber);// here also If sheet is 										available then only I will perform  get the row details into List format
Done-	6.2- get the row Data in String[] format -- public String[] getRowData(String sheetName,int rowNum)

Done-	7 - get the Table type of data for achieving the DataDriven  -- public String[][] getTableData(String sheetName,int rowNum)// from which row I want 																	the data

Done-	7.2 - get the Table type of data by using List<List<String>>  -- public List<List<String>> getTableList(Strign sheetName,int rowNum) 

	//-------------------------------------------------------------------------------------------------------------------------------------------------

	8 - set the List<String> data into Row wise ---public void setRowDataListInRow(String sheetName,List<String> listRow , int rowNumber);
	8.2 set the String[] data into row wise --public void setRowDataStringInRow(String sheetName,String cData[],int rowNum);
	
	9 - Set the List<String> data into column wise --public void setRowDataInColumn(String sheetName,List<Strign> listCol, String columnName);
	9.2 -SEt the String[] data into column wise --public void setRowDataStringInColumn(String sheetName,String rData[],String olumnName)
	
	10 - Get the  Cell data in String format -- public String getTheCellData(String sheetName, int rowNum,String columnName)

	*/


	
	FileInputStream fis=null;
	
	//FileOutputStream fosss=null;
	File file=null;
	
	XSSFWorkbook wBook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String excelPath=null;
	
 	public ExcelSheetUtility(String path)
 	{
 	this.excelPath=path;
 	file =new File(this.excelPath);
 	
 	try {
		
 		this.fis=new FileInputStream(this.file);System.out.println("Excel file is loaded for get the data from the Sheet");
 	//	this.fosss=new FileOutputStream(this.file); // check this will work or not  
 		this.wBook=new XSSFWorkbook(fis); System.out.println("Excel file is loaded ");
 		
 	} catch (FileNotFoundException e) {
		System.out.println("Excel file not loaded from the paht :: "+this.excelPath);
		System.exit(0);
		System.out.println("I close Execution of the program because without file we can not to any other things");
		e.printStackTrace();
		} catch (IOException e) {
		System.out.println("WorkBook is not loaded properly check the code ");
		System.exit(0);
		System.out.println("I close Execution of the program because without file we can not to any other things");
		e.printStackTrace();
	}
 	
 	
 	}// constructor --closed 
 	
 	

	public  int getLastRowNumber(String sheetName)
	{ //System.out.println("This is get the Last RowNumber");
		int rowNum=0;rowNum=this.wBook.getSheet(sheetName).getLastRowNum();System.out.println("Last Row Number of this sheetName = [ "+sheetName+" ] = "+rowNum);
		return rowNum;
	}
	public int getLastColumnNumber(String sheetName,int rowNum)
	{//System.out.println("This is for get the Last Colmn Number ");
		int colNum=0;
			colNum=wBook.getSheet(sheetName).getRow(rowNum).getLastCellNum();System.out.println("Last Column Number of the = [ "+sheetName+" ] and row Number = [ "+rowNum +" ] Number of column are available in that  = "+colNum );
		return colNum;
	}
	
	
	public void createSheet(String sheetName)
	{
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(this.file);System.out.println("Excel file is loaded for writing the data operation ");
		} catch (FileNotFoundException e1) {
			System.out.println("Excel file in not loaded for writing the data operation chek the ="+this.file);
			e1.printStackTrace();
		}
		
		int sheetNumber=wBook.getSheetIndex(sheetName); // sheet Numbers starts with  [ 0 - index ] in the workbook 
		if(sheetNumber==-1) 
		{// in that work book that sheetName is not available so we can create a new sheet with sheetName
			wBook.createSheet(sheetName);
			try {
				wBook.write(fos);System.out.println("Sheet is created with name :: "+sheetName);
				} catch (IOException e) {
					System.out.println("Sheet is not created check the  createSheet() function");
					e.printStackTrace();
				}
		}else
		{System.out.println(sheetName+" this sheet is already available in at Position of ::= "+sheetNumber);	}
		
	}
	
	public void removeSheet(String sheetName)
	{//Remove the sheet in the workBook // working fine as per my expectations
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(this.file);System.out.println("Excel file is loaded for writing the data operation ");
		} catch (FileNotFoundException e1) {
			System.out.println("Excel file in not loaded for writing the data operation chek the ="+this.file);
			e1.printStackTrace();
		}
		
				int sheetNumber=wBook.getSheetIndex(sheetName);
		
		if(sheetNumber==-1) 
		{
			System.out.println("Sheet is not Available in Workbook ");
			System.out.println("Invalid operation  to Remove the Sheet "+sheetName);
		}
		else
		{
			wBook.removeSheetAt(sheetNumber);System.out.println(sheetName+" -- Sheet is removed From the WorkBook");
			
			try {
					wBook.write(fos);System.out.println("Operation is performed to remove the sheet in Work Book");
				} catch (IOException e) {
					System.out.println("wBook.write() fuction is not working properly check over there");
					e.printStackTrace();
				}
				
			
		}// if-else -close
		
	} // removeSheet() --close
	
	
	public void excelFileClose()
	{
		System.out.println(" excelFileClose()--This method  is for Excel file is closing smoothly ");
	
		try {
		//	this.fosss.close();System.out.println("Excel file is closed check the="+this.fosss);
			this.fis.close();System.out.println("Excel file is closed check the="+fis);
		} catch (IOException e) {
		System.out.println("Excel file is not able to close check the closed ");
			e.printStackTrace();
		}
		
		
	}
	public String getCellData(String sheetName , int rowNum, String columnName)
	{ // Yes working fine as per my expectations 
		String celData=null;
		// How to do this 
		
		sheet=wBook.getSheet(sheetName);
	
		int cellnum=0; // I want to get the cell num on basis of the columnName How to do this I will try
		row=sheet.getRow(0);
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
		cell=row.getCell(i);
		String celText=cell.getStringCellValue().toString();
		if(celText.equalsIgnoreCase(columnName))
		{
			cellnum=i;
		}
		}
		
		row=sheet.getRow(rowNum);// this must be contains the row 
				
		cell=row.getCell(cellnum);
		
		return celData=cell.getStringCellValue().toString(); // I will check this weather I'm get or not 
		
		
		
	}
	
	
	
/*	
	public String getCellData(String sheetName,String coloumnName,int rowNum)  
	{// by using this method we get the String of the data of a particular column and and particular row
		String cData=null;
		sheet=wBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		// for below this I need column name of the respective index value How to get the index value ... How do this 
		int indexCell=0;
		for(int i=0;i<=row.getLastColumn();i++)
		{
		indexCell=row.getRow(0).getColumnIndex(columnName); // this is not write to get the index of the column name How to get this 
		

		}
		cData=row.getStringCellValue();
		
		return cData;
	}
*/
	
	
	// this method is use for 1-D Array get the Row Details in String format
	public String[] getRowData(String sheetName,int rowNum)// I will get the particular row data in Array format
	{		
		String[] rowData=null;// this is static HOw to add size of this array may be last column Number I will check
		
		sheet=wBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		
		int lastColNum=row.getLastCellNum(); // check this method is as per expected or not
		System.out.println("Last column Number of the rowNum= [ "+rowNum+ " ] Number of columns are available = "+ lastColNum);
		rowData=new String[lastColNum];
		for(int i=0;i<lastColNum;i++)
		{		
			rowData[i]=row.getCell(i).getStringCellValue();
		}// for -- loop 
	System.out.println("------------------------------------------------------------------");
		for(String cData:rowData)
		{
			System.out.print("  "+cData+"  ");
		}
		System.out.println("\n------------------------------------------------------------------");

	
		return rowData;
	}// Return the Row data in String format

	// this method is for get the row and it's cell values in String[][] format 2-D array format for TDD framework
	public String[][] getTableDetails(String sheetName,int rowNum)// I think this  is enough for the form which row Number and which column number do you want later on I will update
	{
		String[][] table=null;// how to set the size of this 2-D array by using rows and columns 
		sheet=wBook.getSheet(sheetName);
		// I need last row number 
		int lastRowNum=sheet.getLastRowNum();
		
		 row=sheet.getRow(rowNum);// this is for just getting the rowData not for set the data 
				
		//I need last Column number 
		int lastCellNum=row.getLastCellNum();
						// below this is check about this we need from which row to last Row that why I specify
		table=new String[lastRowNum-rowNum][lastCellNum];// size of the 2-D Array 
		
		for(int i=rowNum;i<lastRowNum;i++)// including first column Number also I will update later on about the which RowNumber I want 
		{
			for(int j=0;j<lastCellNum;j++)
			{
				table[(i-rowNum)][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}// inner for-loop
			
		}// outer for -- loop 

		System.out.println("---------------------- Table Data -------------------------");
		for(String[] RowData:table)
		{
			for(String cData:RowData)
			{
				System.out.print("  "+cData+"  ");
			}
			System.out.println("\n-----------------------------------------------");
		}
		
		// internally can I use String[] getRowData inside How it will work 
		
		/* This is not working internally accessing the data May is there any other way to assess 
		 * String newDataTable[]=new String[lastRowNum-rowNum];
		 * 
		 * //table=new String[lastRowNum-rowNum][lastCellNum];// size of the 2-D Array
		 * 
		 * //newDataTable[]=new newDataTable[lastRowNum-rowNum];
		 * 
		 * for(int i=0;i<lastRowNum;i++) {
		 * //newDataTable[i][getRowData(sheetName,rowNumber)];
		 * 
		 * newDataTable[i]=getRowData(sheetName,i);// how to do this }
		 */	
		return table;
	} // Return the data in String[][] 2-D format -- close  

	
	public List<String> getRowList(String sheetName, int rowNum)// from which row number do you want I specify 
	{
		List<String> listRow=new ArrayList<String>();
		
		sheet=wBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		
		// I need lastColumn Number \
		
		int lastColNum=row.getLastCellNum();
		
		for(int i=0;i<lastColNum;i++)
		{
			listRow.add(row.getCell(i).getStringCellValue());
			
		}
	System.out.println("--------------------------------------------------------------------");
		listRow.stream().forEach(cData -> System.out.print("  "+cData+"  ") ); // this is for row data displaying
	System.out.println("-\n-----------------------------------------------------------------");
		return listRow;
	}
	
	
	public List<List<String>> getTableList(String sheetName , int rowNum)
	{		
		List<List<String>> table=new ArrayList<List<String>>(); //check this
		
		sheet=wBook.getSheet(sheetName);
		
		// I need last row Number 
		
		int lastRowNum=sheet.getLastRowNum();
		
		
		for(int i=rowNum;i<=lastRowNum;i++) // from which rowNumber do I want 
		{
			table.add(getRowList(sheetName,i));// Here I will use already existing ListRowType for re_Using the function
		}
		
		// I want to check the List of things 
		System.out.println("------------------------------------------------------");	
		table.parallelStream().forEachOrdered(list -> System.out.println(list)); // I will check about this 
		System.out.println("-----------------------------------------------------");

		System.out.println("-----------------------------------------------------");
		table.stream().forEach(list -> System.out.println(list)); // which one is working fine I will check 
		System.out.println("-----------------------------------------------------");
	
		return table;
		
	}
	
/*
	8 - set the List<String> data into Row wise ---public void setRowDataListInRow(String sheetName,List<String> listRow , int rowNumber);
	8.2 set the String[] data into row wise --public void setRowDataStringInRow(String sheetName,String cData[],int rowNum);
	
	9 - Set the List<String> data into column wise --public void setRowDataInColumn(String sheetName,List<Strign> listCol, String columnName);
	9.2 -SEt the String[] data into column wise --public void setRowDataStringInColumn(String sheetName,String rData[],String olumnName)
	
	10 - Get the  Cell data in String format -- public String getTheCellData(String sheetName, int rowNum,String columnName)
*/
	
	public void setRowDataList()
	{
		
	}
	public void setRowDataString()
	{
		
	}
	public void setCellData(String sheetName,String columnName,int rowNum,String cellData)
	{
		
		// How to do this scenario implemented 
		
		
		
	}
	
	public void setRowDataList_BYColumnNameWise()
	{
		
	}
	
	public void setRowDataString_BYColumnNameWise()
	{
		
	}
	
	public void inserDataInRowString()
	{
		
	}
	public void insertDataInRowList()
	{
		
	}
	public void insertDataInCellString()
	{
		
	}
	

	
	public static void main(String[] args) {
		String filePath="/home/venkat/Documents/testExcel.xlsx";
		String sName="Sheet1";
		ExcelSheetUtility excel=new ExcelSheetUtility(filePath);
		
		System.out.println(excel.getLastRowNumber("Sheet1"));
		System.out.println(excel.getLastColumnNumber("Sheet1", 1));
		
	//	excel.createSheet("NewFile"); working 
		
	//	excel.removeSheet("NewFile"); working 
		
//		excel.
		
	
//		Below are working fine but I'm not able to get the last of Row Values from the both String type  

		/*
		 * 
		 * 
		 
		for(int k=0;k<excel.getLastRowNumber(sName);k++)
	{
		String rowData[]=excel.getRowData(sName, k);	
	System.out.println("\n----------------------------------Get the data in String[] Row Type data -----------------------------------");

	for (int i = 0; i < rowData.length; i++) {
		System.out.print(rowData[i]+"  ");
	}

	System.out.println("\n---------------------------------------------------------------------");
	}
	System.out.println("\n");
	
	
	String tableData[][]=excel.getTableDetails(sName, 0);// this will get the data from the first row to end of the row 
	System.out.println("\n----------------------------------Get the data in String[][] table Type data -----------------------------------");
	
	for(String[] rowData1:tableData)
	{
		for(String cData:rowData1)
		{
			System.out.print(cData+"  ");
		}
		System.out.println("\n---------------------------------------------------------------------");
	}
	
	
	System.out.println("\n----------------------------------Get the Row data in List<String>  format Type data -----------------------------------");
	
		for (int i = 0; i < 4; i++) {
			excel.getRowList("Sheet1", i);
					if(i==3)// length-1
					{break;} // by this no need to chek the condition again
		}
	
		System.out.println("\n----------------------------------Get the data in List<List<String>> format table Type data -----------------------------------");
			
		excel.getTableList(sName, 1);//from second row onwards I will get the data in the form of List
			excel.excelFileClose();// this execute smoothly  close the file 
	
	*/
		for(int i=0;i<=excel.getLastRowNumber("Sheet1");i++)
		{
			System.out.println(excel.getCellData("Sheet1",i, "url"));

		}
		//System.out.println(excel.getCellData("Sheet1",1, "url"));
	
		excel.excelFileClose();// this execute smoothly  close the file 
		
	}

}
