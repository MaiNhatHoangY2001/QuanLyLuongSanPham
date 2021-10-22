package collections;

import javax.swing.table.AbstractTableModel;

import javassist.expr.NewArray;
import model.HoaDonBanHang;

public class TableHoaDonBanHang extends AbstractTableModel {

	private HoaDonCollection hoaDonCollection;
	private String[] colsname = { "Mã hóa đơn", "Số lượng", "Ngày lập", "Khuyến mãi", "Thuế", "Tên nhân viên",
			"Thành tiền" };

	@Override
	public int getRowCount() {
		return hoaDonCollection.getSize();
	}

	public TableHoaDonBanHang(HoaDonCollection hoaDonCollection) {
		super();
		this.hoaDonCollection = hoaDonCollection;
	}

	@Override
	public int getColumnCount() {
		return colsname.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		HoaDonBanHang hoaDonBanHang = hoaDonCollection.getHoaDon(rowIndex);
		switch (columnIndex) {
		case 0:
			return hoaDonBanHang.getMaHoaDonBan();
		case 1:
			return hoaDonBanHang.getSoLuong();
		case 2:
			return hoaDonBanHang.getNgayLapHoaDon();
		case 3:
			return hoaDonBanHang.getKhuyenMai();
		case 4:
			return hoaDonBanHang.getThue();
		case 5:
			return hoaDonBanHang.getNhanVien().getTenNhanVien();
		case 6:
			return hoaDonBanHang.getThanhTien();
		}
		return new String();
	}

	public void setValueAt(Object object, int row, int col) {
		HoaDonBanHang hoaDonBanHang = hoaDonCollection.getHoaDon(row);
//		switch (col) {
//		case 0:
//			hoaDonBanHang.set;
//			break;
//		case 0:
//			hoaDonBanHang;
//			break;
//		case 0:
//			hoaDonBanHang;
//			break;
//		case 0:
//			hoaDonBanHang;
//			break;
//		case 0:
//			hoaDonBanHang;
//			break;
//		case 0:
//			hoaDonBanHang;
//			break;
//		}
	}

	public String getColumnName(int col) {
		return colsname[col];
	}

	// tạo checkbox
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
