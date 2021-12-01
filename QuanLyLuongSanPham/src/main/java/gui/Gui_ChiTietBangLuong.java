package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import gui_package.ChucNang;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class Gui_ChiTietBangLuong extends JFrame {

	private JPanel pnlChinh;
	private JTable tblChiTietLuong;
	private String[] colsCTLuong = { "", "" };
	private DefaultTableModel modelCTLuong;
	private static final int MIN_ROW_HEIGHT = 12;
	private JTextField txtThanhTien;
	private JLabel lblTieuDe;
	private JLabel lblMaNV;
	private JLabel lblThanhTien;
	private JLabel lblTenNV;
	private JLabel lblChucVu;
	private JButton btnIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ChiTietBangLuong frame = new Gui_ChiTietBangLuong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_ChiTietBangLuong() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 670);
		setResizable(false);
		setTitle("Chi tiết bảng lương");
		setIconImage(new ImageIcon("img/logo.png").getImage());

		pnlChinh = new JPanel();
		pnlChinh.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlChinh);
		setLocationRelativeTo(null);
		pnlChinh.setBackground(new Color(242, 129, 25));

		/**
		 * Bảng CT lương
		 */
		new DefaultTableModel(colsCTLuong, 0);
		tblChiTietLuong = new JTable(new DefaultTableModel(
				new Object[][] { { "Mức Lương", null }, { "Hệ số lương", null }, { "Tiền sản phẩm", null },
						{ "Số ngày công", null }, { "Thưởng", null }, { "Phạt", null }, },
				colsCTLuong)) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				if (col == 0) {
					return this.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(this,
							this.getValueAt(row, col), false, false, row, col);
				} else {
					return super.prepareRenderer(renderer, row, col);
				}
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

		};
		tblChiTietLuong.setAutoCreateRowSorter(false);
		tblChiTietLuong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblChiTietLuong.setRowMargin(5);
		tblChiTietLuong.setRowHeight(30);
		tblChiTietLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblChiTietLuong.setToolTipText("Chi tiết bảng lương của 1 nhân viên");
		JTableHeader headerTable1 = tblChiTietLuong.getTableHeader();
		headerTable1.setDefaultRenderer(new HeaderRenderer(tblChiTietLuong));
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
		pnlChinh.setLayout(null);
		JScrollPane thanhCuon1 = new JScrollPane(tblChiTietLuong);
		thanhCuon1.setBounds(10, 201, 513, 308);
		thanhCuon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon1.setToolTipText("Chi tiết bảng lương của 1 nhân viên");
		getContentPane().add(thanhCuon1);

		// Căn phải cột của bảng sản phẩm
		int[] listCanPhaiTblSanPham = { 1 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblSanPham, tblChiTietLuong);

		lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setForeground(Color.WHITE);
		lblThanhTien.setFont(new Font("Arial", Font.PLAIN, 24));
		lblThanhTien.setBounds(47, 531, 123, 24);
		pnlChinh.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setHorizontalAlignment(SwingConstants.RIGHT);
		txtThanhTien.setEditable(false);
		txtThanhTien.setToolTipText("Nhập thông tin thưởng");
		txtThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(178, 520, 289, 47);
		pnlChinh.add(txtThanhTien);

		lblTieuDe = new JLabel("Bảng lương tháng 11/2021");
		lblTieuDe.setBorder(new LineBorder(null, 2));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.WHITE);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieuDe.setBounds(0, 0, 533, 64);
		pnlChinh.add(lblTieuDe);

		lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setForeground(Color.WHITE);
		lblMaNV.setFont(new Font("Arial", Font.PLAIN, 24));
		lblMaNV.setBounds(10, 87, 513, 24);
		pnlChinh.add(lblMaNV);

		lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setForeground(Color.WHITE);
		lblTenNV.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTenNV.setBounds(10, 122, 513, 24);
		pnlChinh.add(lblTenNV);

		lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setForeground(Color.WHITE);
		lblChucVu.setFont(new Font("Arial", Font.PLAIN, 24));
		lblChucVu.setBounds(10, 157, 513, 24);
		pnlChinh.add(lblChucVu);

		btnIn = new JButton("In");
		btnIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIn.setForeground(Color.WHITE);
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIn.setFocusPainted(false);
		btnIn.setBorderPainted(false);
		btnIn.setBackground(new Color(233, 180, 46));
		btnIn.setBounds(209, 578, 112, 47);
		pnlChinh.add(btnIn);
		modelCTLuong = (DefaultTableModel) tblChiTietLuong.getModel();

	}

	public void setDataCTBangLuong(int month, int year, String chucVu, List<String> bangLuong) {
		lblTieuDe.setText("Bảng lương tháng " + month + "/" + year);
		lblMaNV.setText("Mã nhân viên: " + bangLuong.get(0));
		lblTenNV.setText("Tên nhân viên: " + bangLuong.get(1));
		lblChucVu.setText("Chức vụ: " + chucVu);
		ChucNang.clearDataTable(modelCTLuong);

		List<String> tieuDe = new ArrayList<>();
		tieuDe.add("Mức Lương");
		tieuDe.add("Hệ số lương");
		tieuDe.add("Tiền sản phẩm");
		tieuDe.add("Số ngày công");
		tieuDe.add("Thưởng");
		tieuDe.add("Phạt");

		for (int i = 0; i < 6; i++) {
			modelCTLuong.addRow(new Object[] { tieuDe.get(i), bangLuong.get(i + 2) });
		}

		txtThanhTien.setText(bangLuong.get(8));
	}

	private static class HeaderRenderer implements TableCellRenderer {

		TableCellRenderer renderer;

		public HeaderRenderer(JTable table) {
			table.setRowHeight(50);
			renderer = table.getTableHeader().getDefaultRenderer();

		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {

			return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		}
	}
}
