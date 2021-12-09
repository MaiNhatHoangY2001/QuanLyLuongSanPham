package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui_package.ChucNang;
import model.ChiTietHoaDonBan;
import model.HoaDonBanHang;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;
import services.QuanLyHoaDonService;

public class Gui_ThemHoaDonBan extends JDialog implements KeyListener {
	private JTable tblSanPham;
	private JTable tblGioHang;

	private DefaultTableModel modelGioHang;
	private JButton btnXoa;
	private JButton btnDatHang;
	private JButton btnHuyBo;
	private JButton btnThem;
	private JComboBox cboTimSp;
	private JLabel lblTong;
	private JTextField txtChietKhau;
	private JTextField txtTimSp;
	private JButton btnThemKh;
	private JComboBox cboLocTheoGia;
	private JComboBox cboLocCuThe;
	private JButton btnXoaLoc;
	private QuanLyHoaDonService quanLyHoaDonService;
	private DefaultTableModel modelSanPham;
	private List<SanPham> listSp;
	private List<SanPham> listGh;
	private List<KhachHang> listKh;
	private Double thanhTien = 0.0;
	private JComboBox cboKhachHang;
	private JTextField txtMaNV;
	private JTextField txtThue;
	private List<SanPham> tempListSp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ThemHoaDonBan frame = new Gui_ThemHoaDonBan();
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
	public Gui_ThemHoaDonBan() {
		setModal(true);
		setTitle("Thêm hóa đơn bán hàng");
		setIconImage(new ImageIcon("img/logo.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		quanLyHoaDonService = new QuanLyHoaDonService();
		this.setResizable(false);
		ChucNang.setTableAlternateRow();
		setMinimumSize(new Dimension(1440, 1046));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1424, 111);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("THÊM HÓA ĐƠN BÁN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(389, 10, 639, 91);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/images/img_bill/logoChung.PNG"));
		lblNewLabel_4.setBounds(28, 28, 152, 73);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(194, 93, 0));
		panel_1.setBounds(0, 106, 1424, 111);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		cboTimSp = new JComboBox();
		cboTimSp.setDoubleBuffered(true);
		cboTimSp.setEditable(true);
		cboTimSp.setToolTipText("Tìm kiếm nhanh sản phẩm");
		cboTimSp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboTimSp.setModel(new DefaultComboBoxModel(new String[] { "Tìm theo mã", "Tìm theo tên", "Tìm theo NCC" }));
		cboTimSp.setBounds(1190, 11, 224, 44);
		panel_1.add(cboTimSp);

		txtTimSp = new JTextField();
		txtTimSp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSp.setBounds(788, 11, 378, 44);
		panel_1.add(txtTimSp);
		txtTimSp.setColumns(10);

		cboLocTheoGia = new JComboBox();
		cboLocTheoGia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboLocTheoGia.setModel(new DefaultComboBoxModel(new String[] { "Giá tăng dần", "Giá giảm dần" }));
		cboLocTheoGia.setSelectedIndex(0);
		cboLocTheoGia.setBounds(788, 65, 165, 44);
		panel_1.add(cboLocTheoGia);

		cboLocCuThe = new JComboBox();
		cboLocCuThe.setModel(new DefaultComboBoxModel(
				new String[] { "Mức giá", "<200.000", "200.000 -1.000.000", ">1.000.000-3.000.000", ">3.000.000" }));
		cboLocCuThe.setSelectedIndex(0);
		cboLocCuThe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboLocCuThe.setBounds(984, 65, 283, 44);
		panel_1.add(cboLocCuThe);

		btnXoaLoc = new JButton("Xóa lọc");
		btnXoaLoc.setToolTipText("Xóa tất cả bộ lọc");
		btnXoaLoc.setForeground(Color.WHITE);
		btnXoaLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaLoc.setBackground(new Color(233, 180, 46));
		btnXoaLoc.setBounds(1293, 65, 121, 45);
		panel_1.add(btnXoaLoc);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(242, 129, 25));
		panel_3.setBounds(0, 217, 1424, 782);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		btnDatHang = new JButton("Đặt hàng");
		btnDatHang.setToolTipText("Tiến hành thêm khi đã nhập liệu xong");
		btnDatHang.setForeground(Color.WHITE);
		btnDatHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatHang.setBackground(new Color(233, 180, 46));
		btnDatHang.setBounds(583, 727, 149, 44);
		panel_3.add(btnDatHang);

		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setToolTipText("Hủy thao tác thêm");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(412, 727, 161, 44);
		panel_3.add(btnHuyBo);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(
				new TitledBorder(null, "S\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(787, 0, 627, 782);
		panel_3.add(scrollPane);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tblSanPham = new JTable();
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblSanPham.setRowHeight(40);
		tblSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader headerTable1 = tblSanPham.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
		modelSanPham = new DefaultTableModel(new Object[] { "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 th\u00E0nh",
				"Nh\u00E0 cung c\u1EA5p", "Lo\u1EA1i" }, 20) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblSanPham.setModel(modelSanPham);
		tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(141);
		tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(108);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(35);
		tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);

		scrollPane.setViewportView(tblSanPham);

		btnXoa = new JButton(">>");
		btnXoa.setBounds(707, 131, 74, 37);
		panel_3.add(btnXoa);
		btnXoa.setToolTipText("Xóa sản phẩm ra khỏi giỏ hàng");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(255, 204, 0));
		btnXoa.setForeground(Color.WHITE);

		btnThem = new JButton("<<");
		btnThem.setBounds(707, 68, 74, 37);
		panel_3.add(btnThem);
		btnThem.setToolTipText("Thêm sản phẩm vào giỏ");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(255, 204, 0));

		lblTong = new JLabel("Tổng cộng:  ");
		lblTong.setBorder(new LineBorder(Color.WHITE));
		lblTong.setForeground(Color.WHITE);
		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTong.setBounds(309, 655, 320, 44);
		panel_3.add(lblTong);

		btnThemKh = new JButton("+");
		btnThemKh.setBackground(new Color(233, 180, 46));
		btnThemKh.setForeground(new Color(255, 250, 250));
		btnThemKh.setToolTipText("Thêm khách hàng , dùng cho khách hàng mới");
		btnThemKh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThemKh.setBounds(248, 655, 51, 44);
		panel_3.add(btnThemKh);

		txtChietKhau = new JTextField();
		txtChietKhau.setBorder(
				new TitledBorder(null, "Chi\u1EBFt kh\u1EA5u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtChietKhau.setBounds(639, 657, 93, 44);
		panel_3.add(txtChietKhau);
		txtChietKhau.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(
				new TitledBorder(null, "Gi\u1ECF h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(10, 0, 692, 619);
		panel_3.add(scrollPane_1);
		tblGioHang = new JTable();
		tblGioHang.setToolTipText("Chỉ cho phép sửa số lượng");
		tblGioHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblGioHang.setRowHeight(40);
		tblGioHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader headerTable0 = tblGioHang.getTableHeader();
		headerTable0.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable0.setBackground(new Color(248, 198, 153));

		modelGioHang = new DefaultTableModel(new String[] { "STT", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 th\u00E0nh",
				"S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n" }, 20) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 3)
					return super.isCellEditable(row, column);
				return false;
			}
		};
		tblGioHang.setModel(modelGioHang);
		tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(168);
		tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(119);
		tblGioHang.revalidate();
		scrollPane_1.setViewportView(tblGioHang);

		cboKhachHang = new JComboBox<String>();
		cboKhachHang.setBorder(new TitledBorder(null, "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i kh\u00E1ch h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cboKhachHang.setToolTipText("Tìm kiếm khách hàng bằng số điện thoại");
		cboKhachHang.setEditable(true);
		cboKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboKhachHang.setBounds(10, 655, 237, 44);
		panel_3.add(cboKhachHang);

		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"M\u00E3 nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtMaNV.setBounds(10, 727, 237, 44);
		panel_3.add(txtMaNV);

		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtThue.setToolTipText("Thuế");
		txtThue.setColumns(10);
		txtThue.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thu\u1EBF",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtThue.setBounds(309, 726, 93, 44);
		panel_3.add(txtThue);
		listKh = new ArrayList<KhachHang>();
		listGh = new ArrayList<SanPham>();
		txtTimSp.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				int temp = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (JOptionPane.YES_OPTION == temp) {
					thoat();
				}

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		cboTimSp.addActionListener(e -> {
			int i = cboTimSp.getSelectedIndex();
			String value = txtTimSp.getText().trim();
			if (i == 0) {
				timTheoMa(value);
			}
			if (i == 1) {
				timTheoTenSanPham(value);

			}
			if (i == 2) {
				timTheoNhaCungCap(value);
			}
		});
		btnThemKh.addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				new Gui_ThemKhachHang().setVisible(true);
			});
		});
		btnHuyBo.addActionListener(e -> {
			int temp = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.YES_OPTION == temp) {
				this.dispose();
			}
		});
		txtThue.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					capNhatTongTien();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnDatHang.addActionListener(e -> {
			if (kiemTraDuLieu()) {
				if (modelGioHang.getDataVector().size() > 0)
					if (cboKhachHang.getSelectedIndex() >= 0)
						if (!txtMaNV.getText().trim().equals("")) {
							int index = cboKhachHang.getSelectedIndex();
							NhanVien nhanVien = quanLyHoaDonService.getNhanVienTheoMa(txtMaNV.getText().trim());
							HoaDonBanHang hoaDonBanHang = new HoaDonBanHang(
									Double.parseDouble(txtChietKhau.getText().trim().equals("") ? "0"
											: txtChietKhau.getText().trim()) / 100,
									Double.parseDouble(
											txtThue.getText().trim().equals("") ? "0" : txtThue.getText().trim()) / 100,
									nhanVien, listKh.get(index));
							int i = 0;
							List<ChiTietHoaDonBan> listCt = new ArrayList<ChiTietHoaDonBan>();
							for (SanPham sanPham : listGh) {
								ChiTietHoaDonBan chiTietHoaDonBan = new ChiTietHoaDonBan(sanPham.getGiaThanh(),
										Integer.parseInt((String) tblGioHang.getValueAt(i, 3)), hoaDonBanHang, sanPham);
								listCt.add(chiTietHoaDonBan);
							}
							hoaDonBanHang.setDsChiTietHoaDonBan(listCt);
							if (quanLyHoaDonService.themHoaDon(hoaDonBanHang)) {
								try {
									for (ChiTietHoaDonBan chiTietHoaDonBan : listCt) {
										quanLyHoaDonService.themChiTietBan(chiTietHoaDonBan);
									}
									JOptionPane.showMessageDialog(this, "Mua hàng thành công", "Thông báo",
											JOptionPane.INFORMATION_MESSAGE);

									this.dispose();
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(this,
											"Thêm thất bại \nVui lòng kiểm tra lại thông tin:", "Lỗi",
											JOptionPane.ERROR_MESSAGE);
								}

							}

						} else {
							JOptionPane.showMessageDialog(this, "Mã nhân viên trống", "Cảnh báo",
									JOptionPane.WARNING_MESSAGE);
						}
					else {
						JOptionPane.showMessageDialog(this, "Khách hàng trống", "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
					}
				else {
					JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		txtMaNV.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					NhanVien nhanVien = quanLyHoaDonService.getNhanVienTheoMa(txtMaNV.getText().trim());
					if (nhanVien == null) {
						JOptionPane.showMessageDialog(null,
								"Không tồn tại nhân viên nào có mã:" + txtMaNV.getText().trim(), "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
					} else if (!nhanVien.gettrangThaiLamViec()) {
						JOptionPane.showMessageDialog(null,
								"Nhân viên có mã:" + txtMaNV.getText().trim() + "Đã nghỉ việc", "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JTextField txtSdt = (JTextField) cboKhachHang.getEditor().getEditorComponent();
		txtSdt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cboKhachHang(txtSdt.getText().trim());
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtChietKhau.addKeyListener(this);
		/**
		 * Chức năng nút xóa
		 */
		btnXoa.addActionListener(e -> {
			int index = tblGioHang.getSelectedRow();
			if (index < 0 || index >= listGh.size()) {
				JOptionPane.showMessageDialog(this, "Chọn sai", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else {
				int soLuong = Integer.parseInt(((String) tblGioHang.getValueAt(index, 3)).trim());
				thanhTien -= listGh.get(index).getGiaThanh() * soLuong;
				listGh.remove(index);
				modelGioHang.removeRow(index);
				capNhatTongTien();
			}
		});
		/**
		 * Hiện thực chức năng cho button thêm sản phẩm
		 */
		btnThem.addActionListener(e -> {
			int index = tblSanPham.getSelectedRow();
			if (index + 1 > listSp.size() || index == -1) {
				JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			} else {
				SanPham sp = listSp.get(index);
				if (listGh.contains(sp)) {
					JOptionPane.showMessageDialog(this, "Sản phầm này đã tồn tại", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
				} else {
					clearNullRow(modelGioHang);
					listGh.add(sp);
					NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
					Object[] o = { modelGioHang.getDataVector().size() + 1, sp.getTenSanPham(),
							format.format(sp.getGiaThanh()), "1", format.format(sp.getGiaThanh()) };
					thanhTien += sp.getGiaThanh();
					modelGioHang.addRow(o);
					capNhatTongTien();
					ChucNang.addNullDataTable(modelGioHang);
				}
			}
		});
		/**
		 * Thực hiện thay đổi giá trị trong table
		 */
		modelGioHang.addTableModelListener(e -> {
			try {
				int col = e.getColumn();
				int row = e.getFirstRow();

				if (col == 3) {
					if (!(tblGioHang.getValueAt(row, 3) == null || tblGioHang.getValueAt(row, 3).equals(""))) {
						if (isInterger((String) tblGioHang.getValueAt(row, 3))) {
							NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
							Double gia = listGh.get(row).getGiaThanh();
							int soLuong = Integer.parseInt(((String) tblGioHang.getValueAt(row, 3)).trim());
							if (soLuong > 0) {
								Double thanhTien = soLuong * gia;
								tblGioHang.setValueAt(format.format(thanhTien), row, 4);
								capNhatTongTien();
							} else {
								JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Cảnh báo",
										JOptionPane.WARNING_MESSAGE);
								tblGioHang.setValueAt("1", row, 3);
							}
						} else {
							JOptionPane.showMessageDialog(this, "Phải nhập số nguyên", "Cảnh báo",
									JOptionPane.WARNING_MESSAGE);
							tblGioHang.setValueAt("1", row, 3);

						}
					}
					else {
						JOptionPane.showMessageDialog(this, "Không được để trống", "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
						tblGioHang.setValueAt("1", row, 3);
					}

				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Lựa chọn không phù hợp", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			}

		});
		cboLocCuThe.addActionListener(e -> {
			int temp = cboLocCuThe.getSelectedIndex();
			if (temp == 1) {
				locTheoMucGia(0, 200000);
			}
			if (temp == 2) {
				locTheoMucGia(200000, 1000000);
			}
			if (temp == 3) {
				locTheoMucGia(1000000, 3000000);
			}
			if (temp == 4) {
				locTheoMucGia(3000000, 2000000000);
			}
		});

		/**
		 * hiện thực chức năng cho comboBox sắp xếp theo giá
		 *
		 */
		cboLocTheoGia.addActionListener(e -> {
			ChucNang.clearDataTable(modelSanPham);
			if (cboLocTheoGia.getSelectedIndex() == 0) {
				sapXepList(listSp, true);
				addSp(listSp);
			} else if (cboLocTheoGia.getSelectedIndex() == 1) {
				sapXepList(listSp, false);
				addSp(listSp);
			}
			ChucNang.addNullDataTable(modelSanPham);
		});

		loadAllSanPham();

	}

	/**
	 * sắp xếp list b-true tăng dần, b-false giảm dần
	 * 
	 * @param list
	 * @param b
	 */
	public void sapXepList(List<SanPham> list, boolean b) {
		if (b == true)
			Collections.sort(list, new Comparator<SanPham>() {
				@Override
				public int compare(SanPham o1, SanPham o2) {
					return o1.getGiaThanh() < o2.getGiaThanh() ? -1 : 1;
				}
			});
		else if (b == false) {
			Collections.sort(list, new Comparator<SanPham>() {
				@Override
				public int compare(SanPham o1, SanPham o2) {
					return o1.getGiaThanh() > o2.getGiaThanh() ? -1 : 1;
				}
			});
		}
	}

	public boolean isInterger(String s) {
		try {
			int i = Integer.parseInt(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Hiển thị tất cả sản phẩm lên table
	 */
	public void loadAllSanPham() {
		listSp = quanLyHoaDonService.getAllSanPham();
		sapXepList(listSp, true);
		ChucNang.clearDataTable(modelSanPham);
		addSp(listSp);
		ChucNang.addNullDataTable(modelSanPham);
	}

	/**
	 * Xóa tất cả các dòng null trong table
	 * 
	 * @param model
	 */
	public void clearNullRow(DefaultTableModel model) {
		int row = model.getDataVector().size();
		for (int i = row - 1; i >= 0; i--) {
			if (model.getDataVector().get(i).elementAt(0) == null) {
				model.getDataVector().remove(i);
			}
		}
	}

	/**
	 * Thêm danh sách sản phẩm vào table
	 * 
	 * @param list
	 */
	public void addSp(List<SanPham> list) {
		for (SanPham sanPham : list) {
			NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
			String[] row = { sanPham.getTenSanPham(), "" + format.format(sanPham.getGiaThanh()), sanPham.getnCC(),
					sanPham.getLoai() };
			System.out.println(row);
			modelSanPham.addRow(row);
		}
	}

	/**
	 * hiện thực cbo khách hàng
	 */
	public void cboKhachHang(String sdt) {
		System.out.println(sdt);
		KhachHang khachHang = quanLyHoaDonService.getKhBySdt(sdt);
		if (khachHang != null) {
			if (!listKh.contains(khachHang)) {
				listKh.add(khachHang);
				cboKhachHang.addItem(khachHang.getTenKhachHang() + ": " + khachHang.getsDT());
				cboKhachHang.showPopup();
				cboKhachHang.setPopupVisible(true);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng này", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void thoat() {
		this.dispose();
	}

	public void capNhatTongTien() {
		thanhTien = 0.0;
		int i = 0;
		double km = Double.parseDouble(txtChietKhau.getText().trim().equals("") ? "0" : txtChietKhau.getText().trim())
				/ 100;
		double thue = Double.parseDouble(txtThue.getText().trim().equals("") ? "0" : txtThue.getText().trim()) / 100;
		for (SanPham sanPham : listGh) {
			int sl = Integer.parseInt((String) tblGioHang.getValueAt(i, 3));
			thanhTien += sanPham.getGiaThanh() * sl;
			i++;
		}
		NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
		lblTong.setText("Tổng cộng: " + format.format(thanhTien - thanhTien * (km) + thanhTien * thue));
	}

	public void locTheoMucGia(double from, double to) {
		tempListSp = new ArrayList<SanPham>();
		for (SanPham sanPham : listSp) {
			if (sanPham.getGiaThanh() >= from && sanPham.getGiaThanh() <= to)
				tempListSp.add(sanPham);
		}
		ChucNang.clearDataTable(modelSanPham);
		addSp(tempListSp);
		ChucNang.addNullDataTable(modelSanPham);
	}

	public void timTheoNhaCungCap(String ncc) {
		tempListSp = new ArrayList<SanPham>();
//		listSp= new ArrayList<SanPham>();

		tempListSp = quanLyHoaDonService.timSanPhamTheoNhaCungCap(ncc);
		listSp = tempListSp;
		ChucNang.clearDataTable(modelSanPham);
		addSp(tempListSp);
		ChucNang.addNullDataTable(modelSanPham);
	}

	public void timTheoTenSanPham(String ten) {
		tempListSp = new ArrayList<SanPham>();
		tempListSp = quanLyHoaDonService.timSanPhamTheoTen(ten);
		listSp = tempListSp;
		ChucNang.clearDataTable(modelSanPham);
		addSp(tempListSp);
		ChucNang.addNullDataTable(modelSanPham);
	}

	public void timTheoMa(String ma) {
		tempListSp = new ArrayList<SanPham>();
		SanPham sp = quanLyHoaDonService.timSanPhamTheoMa(ma);
		if (sp != null)
			tempListSp.add(sp);
		ChucNang.clearDataTable(modelSanPham);
		addSp(tempListSp);
		ChucNang.addNullDataTable(modelSanPham);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			capNhatTongTien();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean kiemTraDuLieu() {
		if (txtMaNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã nhân vien không được để trống");
			txtMaNV.requestFocus();
			txtMaNV.selectAll();
			return false;
		}

		NhanVien nhanVien = quanLyHoaDonService.getNhanVienTheoMa(txtMaNV.getText().trim());
//		if(nhanVien.get)
		if (nhanVien == null) {
			JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên nào có mã:" + txtMaNV.getText().trim(),
					"Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!nhanVien.gettrangThaiLamViec()) {
			JOptionPane.showMessageDialog(this, "Nhân viên có mã:" + txtMaNV.getText().trim() + "Đã nghỉ việc",
					"Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(quanLyHoaDonService.kiemTraLoaiNhanVien(nhanVien)) {
			JOptionPane.showMessageDialog(this, "Nhân viên có mã:" + txtMaNV.getText().trim() + "Không phải nhân viên bán hàng. Phải nhập nhân viên bán hàng",
					"Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		try {
			double chietKhau = Double.parseDouble(txtChietKhau.getText().trim());
			if(chietKhau<0) {
				JOptionPane.showMessageDialog(this, "Chiết khấu phải là số từ 0-100");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Chiết khấu phải là số từ 0-100");
			txtChietKhau.requestFocus();
			txtChietKhau.selectAll();
			return false;
		}
		try {
			double thue = Double.parseDouble(txtThue.getText().trim());
			if(thue<0) {
				JOptionPane.showMessageDialog(this, "Thuế phải là số dương");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Thuế phải là số dương");
			txtThue.requestFocus();
			txtThue.selectAll();
			return false;
		}
		return true;

	}
}
