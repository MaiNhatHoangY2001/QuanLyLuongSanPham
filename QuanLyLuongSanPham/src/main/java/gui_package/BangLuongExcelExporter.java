package gui_package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BangLuongExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<?> listValue;
	private int month, year;

	public BangLuongExcelExporter(List<?> listValue, int month, int year) {
		this.listValue = listValue;
		this.month = month;
		this.year = year;
		workbook = new XSSFWorkbook();
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer)
			cell.setCellValue((Integer) value);
		else if (value instanceof Boolean)
			cell.setCellValue((Boolean) value);
		else if (value instanceof Double)
			cell.setCellValue((Double) value);
		else if (value instanceof String)
			cell.setCellValue((String) value);
		cell.setCellStyle(style);
	}

	/**
	 * Xuất tiêu đề bảng lương
	 */
	private void writeHeaderBangLuong() {
		sheet = workbook.createSheet("Bảng lương " + month + "_" + year);
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);

		createCell(row, 0, "STT", style);
		createCell(row, 1, "Mã nhân viên", style);
		createCell(row, 2, "Tên nhân viên", style);
		createCell(row, 3, "Mức lương", style);
		createCell(row, 4, "Hệ số lương", style);
		createCell(row, 5, "Tiền sản phẩm", style);
		createCell(row, 6, "Số ngày công", style);
		createCell(row, 7, "Thưởng", style);
		createCell(row, 8, "Phạt", style);
		createCell(row, 9, "Tiền lương", style);

	}

	/**
	 * Xuất dữ liệu bản lương ra excel
	 */
	private void writeDataBangLuong() {
		int rowCount = 1;
		int stt = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Object object : listValue) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			Object[] o = (Object[]) object;
			createCell(row, columnCount++, stt++, style);
			createCell(row, columnCount++, o[0], style);
			createCell(row, columnCount++, o[1], style);
			createCell(row, columnCount++, o[2], style);
			createCell(row, columnCount++, o[3], style);
			createCell(row, columnCount++, o[4], style);
			createCell(row, columnCount++, o[5], style);
			createCell(row, columnCount++, o[6], style);
			createCell(row, columnCount++, o[7], style);
			createCell(row, columnCount++, o[8], style);

		}
	}

	/**
	 * xuất file bảng lương
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void exportBangLuong(String path) throws IOException {
		writeHeaderBangLuong();
		writeDataBangLuong();

		OutputStream outputStream = new FileOutputStream(path + ".xlsx");
		workbook.write(outputStream);
		workbook.close();

		outputStream.close(); 

	}
}