package collections;

import javax.swing.table.AbstractTableModel;

public class TableGioHang extends AbstractTableModel {

	private GioHang gioHang;
	private final String[] colsName = { "STT", "Tên sản phẩm", "Giá thành", "Số lượng", "Xóa" };

	public TableGioHang(GioHang gioHang) {
		super();
		this.gioHang = gioHang;
	}

	@Override
	public int getRowCount() {

		return gioHang.getSize();
	}

	@Override
	public int getColumnCount() {
		return colsName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MatHang matHang = gioHang.getMatHang(rowIndex);
		switch (rowIndex) {
		case 0:
			return gioHang.getIndex(matHang);
		case 1:
			return matHang.getSanPham().getTenSanPham();
		case 2:
			return matHang.getSanPham().getGiaThanh();
		case 3:
			return matHang.getSoLuong();
		case 4: return new String();
		}
		return new String();
	}
	/**
	 * set các giá trị của table
	 * Note: chỉ thay đổi được đố lượng
	 */
	public void setValueAt(Object value, int row, int col) {
		MatHang matHang = gioHang.getMatHang(row);
		switch (row) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			matHang.setSoLuong((int) value);
			break;
		case 4:break;
		}
	}
	/**
	 * lấy số cột của table
	 */
	public String getColumnName(int col) {
		return colsName[col];
	}
	/**
	 * lấy class của cột
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	public boolean isCellEditable(int row, int col) {
		if(col==3)
			return true;
		else return false;
		
	}
}
