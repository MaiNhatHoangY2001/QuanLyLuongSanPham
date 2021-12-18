package gui_package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportPhieuLuong {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<?> listValue;
	private int month, year;
	private String chucVu;

	public ExportPhieuLuong(List<?> listValue, int month, int year, String chucVu) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		this.listValue = listValue;
		this.month = month;
		this.year = year;
		this.chucVu = chucVu;
	}

	public void createHeader() {
		String head = "Phiếu lương tháng:" + month + "/" + year;
		Row headRow = sheet.createRow(0);
		Cell headCell = headRow.createCell(0);
		headCell.setCellValue(head);
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		headCell.setCellStyle(headStyle);
		XSSFFont font = workbook.createFont();
		font.setFontHeight(16);
		headStyle.setFont(font);
		font.setBold(true);

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		System.out.println(headRow);
	}

	public void createRowInfor() {
		String maNhanVien = "Mã nhân viên: " + listValue.get(0);
		String tenNhanVien = "Tên nhân viên: " + listValue.get(1);
		String chucvu = "Chức vụ: " + chucVu;
		Row rowMa = sheet.createRow(1);
		Row rowTen = sheet.createRow(2);
		Row rowChuc = sheet.createRow(3);

		Cell cellMa = rowMa.createCell(0);
		cellMa.setCellValue(maNhanVien);
		Cell cellTen = rowTen.createCell(0);
		cellTen.setCellValue(tenNhanVien);
		Cell cellChuc = rowChuc.createCell(0);
		cellChuc.setCellValue(chucvu);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));

	}

	public void autoResize() {
		for (int i = 0; i < 2; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	public void createRowCell() {
		String mucLuong = "Mức lương ";
		String heSoLuong = "Hệ số lương ";
		String tienSanPham = "Tiền sản phẩm  ";
		String soNgayCong = "Số ngày công ";
		String thuong = "Thưởng ";
		String phat = "Phạt ";
		String tong = "Thành tiền ";
		Row rowMucLuong = sheet.createRow(4);
		createCell(rowMucLuong, mucLuong, listValue.get(2));
		Row rowHeSo = sheet.createRow(5);
		createCell(rowHeSo, heSoLuong, listValue.get(3));
		Row rowTienSp = sheet.createRow(6);
		createCell(rowTienSp, tienSanPham, listValue.get(4));
		Row rowSoNgay = sheet.createRow(7);
		createCell(rowSoNgay, soNgayCong, listValue.get(5));
		Row rowThuong = sheet.createRow(8);
		createCell(rowThuong, thuong, listValue.get(6));
		Row rowPhat = sheet.createRow(9);
		createCell(rowPhat, phat, listValue.get(7));
		Row rowTong = sheet.createRow(10);
		createCell(rowTong, tong, listValue.get(8));
	}

	public void createCell(Row row, String title, Object value) {
		Cell cell = row.createCell(0);
		cell.setCellValue(title);
		if (value instanceof Integer)
			cell.setCellValue((Integer) value);
		else if (value instanceof Boolean)
			cell.setCellValue((Boolean) value);
		else if (value instanceof Double)
			cell.setCellValue((Double) value);
		else if (value instanceof String)
			cell.setCellValue((String) value);
	}

	public void saveFile(String filePath) throws IOException {
		createHeader();
		createRowInfor();
		createRowCell();
		autoResize();
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath + ".xlsx");
			workbook.write(out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			out.close();
		}

	}

}
