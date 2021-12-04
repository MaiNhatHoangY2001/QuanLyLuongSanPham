package gui_package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.BangLuongDao;
import model.BangLuong;

public class ExportPhieuLuong {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private BangLuong bangLuong;

	public ExportPhieuLuong(BangLuong bangLuong) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		this.bangLuong = bangLuong;
	}

	public void createHeader() {
		String head = "Phiếu lương tháng:"+bangLuong.getThoiGian().getMonthValue()+"/"+bangLuong.getThoiGian().getYear();
		Row headRow = sheet.createRow(0);
		Cell headCell = headRow.createCell(0);
		headCell.setCellValue(head);
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		headCell.setCellStyle(headStyle);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		System.out.println(headRow);
	}

	public void createRowInfor() {
		String maNhanVien = "Mã nhân viên: "+bangLuong.getNhanVien().getMaNhanVien();
		String tenNhanVien = "Tên nhân viên: "+bangLuong.getNhanVien().getTenNhanVien();
		String chucVu = "Chức vụ: "+(bangLuong.getHeSoLuong()==2?"Nhân viên kế toán":"Nhân viên bán hàng");
		Row rowMa = sheet.createRow(1);
		Row rowTen = sheet.createRow(2);
		Row rowChuc = sheet.createRow(3);

		Cell cellMa = rowMa.createCell(0);
		cellMa.setCellValue(maNhanVien);
		Cell cellTen = rowTen.createCell(0);
		cellTen.setCellValue(tenNhanVien);
		Cell cellChuc = rowChuc.createCell(0);
		cellChuc.setCellValue(chucVu);
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
		createCell(rowMucLuong, mucLuong, bangLuong.getNhanVien().getMucLuong());
		Row rowHeSo = sheet.createRow(5);
		createCell(rowHeSo, heSoLuong, bangLuong.getHeSoLuong());
		Row rowTienSp = sheet.createRow(6);
		createCell(rowTienSp, tienSanPham, bangLuong.getTienSanPham());
		Row rowSoNgay = sheet.createRow(7);
		createCell(rowSoNgay, soNgayCong, bangLuong.getSoNgayCong());
		Row rowThuong = sheet.createRow(8);
		createCell(rowThuong, thuong, bangLuong.getThuong());
		Row rowPhat = sheet.createRow(9);
		createCell(rowPhat, phat, bangLuong.getPhat());
		Row rowTong = sheet.createRow(10);
		createCell(rowTong, tong, bangLuong.tinhLuong());
	}

	public void createCell(Row row, String title, Object value) {
		Cell cell = row.createCell(0);
		cell.setCellValue(title);
		Cell cell1 = row.createCell(1);
		if (value instanceof Integer)
			cell1.setCellValue((Integer) value);
		else
			cell1.setCellValue((double) value);
	}

	public void saveFile(String filePath) throws IOException {
		createHeader();
		createRowInfor();
		createRowCell();
		autoResize();
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			out.close();
		}

	}

	public static void main(String[] args) throws IOException {
		BangLuongDao bangLuongDao= new BangLuongDao();
		ExportPhieuLuong exportPhieuLuong = new ExportPhieuLuong(bangLuongDao.getBangLuong("BL21100001"));
		exportPhieuLuong.saveFile("D:\\Day\\phieuLuong" + ".xlsx");
	}
}
