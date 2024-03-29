package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gui_package.ChucNang;
import model.TaiKhoan;
import services.QuanLyLuongService;

public class Gui_Chinh extends JFrame implements ActionListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlChange;
	private JButton btnQuanLyTaiKhoan;
	private JButton btnThoat;
	private JButton btnQuanLySanPham;
	private JButton btnThongKe;
	private JButton btnQuanLyLuong;
	private JButton btnQuanLyHoaDon;
	private JButton btnQuanLyNhanVien;
	private CardLayout cardLayout;
	private JButton temp;
	private TaiKhoan taiKhoan;

	private Gui_ThongKe trangTK = new Gui_ThongKe();
	private Gui_QuanLyHoaDon trangHD = new Gui_QuanLyHoaDon();
	private Gui_QuanLyLuong trangLuong = new Gui_QuanLyLuong();
	private Gui_QuanLyNhanVien trangNV = new Gui_QuanLyNhanVien();
	private Gui_QuanLySanPham trangSP = new Gui_QuanLySanPham();
	private Gui_QuanLyTaiKhoan trangtaiKhoan = new Gui_QuanLyTaiKhoan();
	private JPanel panel_1;

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
//		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();
//		this.revalidate();
//		this.repaint();
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangHD.pnlHead, this, Gui_DangNhap.getInstance(), trangHD);
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangLuong.pnlHead, this, Gui_DangNhap.getInstance(), trangLuong);
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangNV.pnlHead, this, Gui_DangNhap.getInstance(), trangNV);
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangTK.pnlHead, this, Gui_DangNhap.getInstance(), trangTK);
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangSP.pnlHead, this, Gui_DangNhap.getInstance(), trangSP);
		ChucNang.setLabelName(taiKhoan.getNhanVien().getTenNhanVien(),
				trangtaiKhoan.pnlHead, this, Gui_DangNhap.getInstance(), trangtaiKhoan);
		phanQuyen();
		System.out.println(taiKhoan.getTenTaiKhoan());
	}

	private void phanQuyen() {
		if (!(taiKhoan.getTenTaiKhoan().equals("NV00000000"))) {
			btnQuanLyNhanVien.setVisible(false);
			btnQuanLyTaiKhoan.setVisible(false);
			btnThoat.setBounds(0, 460, 320, 115);
		} else {
			btnQuanLyNhanVien.setVisible(true);
			btnQuanLyTaiKhoan.setVisible(true);
			btnThoat.setBounds(0, 690, 320, 115);
		}
	}

	/**
	 * Create the frame.
	 */
	public Gui_Chinh() {

		Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(r.width, r.height);
		//1920 1040
		setResizable(false);
		setTitle("Ứng dụng quản lý cửa hàng điện thoại 17");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png")));
		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// thông báo khi thoát
		addWindowListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 115, 0));
		panel.setBounds(0, 0, 320, 1055);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/dt-navbar.png"))));
		lblNewLabel.setBounds(95, 21, 174, 104);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CỬA HÀNG ĐIỆN THOẠI 17");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(9, 147, 294, 27);
		panel.add(lblNewLabel_1);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 200, 320, 807);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(242, 129, 25));

		/**
		 * các nút menu
		 */
		btnThoat = new JButton("Thoát");
		btnThoat.setFocusPainted(false);
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/thoat.png"))));
		btnThoat.setBounds(0, 690, 320, 115);
		panel_1.add(btnThoat);
		btnThoat.setIconTextGap(10);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThoat.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnThoat.setBackground(new Color(242, 129, 25));
		// Sự kiện thoát
		btnThoat.addActionListener(e -> {
			thongBaoThoat();
		});

		btnQuanLyTaiKhoan = new JButton("Quản lý tài khoản");
		btnQuanLyTaiKhoan.setFocusPainted(false);
		btnQuanLyTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyTaiKhoan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/user.png"))));
		btnQuanLyTaiKhoan.setBounds(0, 575, 320, 115);
		panel_1.add(btnQuanLyTaiKhoan);
		btnQuanLyTaiKhoan.setIconTextGap(10);
		btnQuanLyTaiKhoan.setForeground(Color.WHITE);
		btnQuanLyTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyTaiKhoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyTaiKhoan.setBackground(new Color(242, 129, 25));

		btnQuanLySanPham = new JButton("Quản lý sản phẩm");
		btnQuanLySanPham.setFocusPainted(false);
		btnQuanLySanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLySanPham.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/sanpham.png"))));
		btnQuanLySanPham.setBounds(0, 0, 320, 115);

		panel_1.add(btnQuanLySanPham);
		btnQuanLySanPham.setIconTextGap(10);
		btnQuanLySanPham.setForeground(Color.WHITE);
		btnQuanLySanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLySanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLySanPham.setBackground(new Color(242, 129, 25));

		btnThongKe = new JButton("Thống kê thu chi");
		btnThongKe.setFocusPainted(false);
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/thongke.png"))));
		btnThongKe.setBounds(0, 345, 320, 115);
		panel_1.add(btnThongKe);
		btnThongKe.setIconTextGap(0);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnThongKe.setBackground(new Color(242, 129, 25));

		btnQuanLyLuong = new JButton("Quản lý lương");
		btnQuanLyLuong.setFocusPainted(false);
		btnQuanLyLuong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyLuong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/luong.png"))));
		btnQuanLyLuong.setBounds(0, 230, 320, 115);
		panel_1.add(btnQuanLyLuong);
		btnQuanLyLuong.setIconTextGap(10);
		btnQuanLyLuong.setForeground(Color.WHITE);
		btnQuanLyLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyLuong.setBackground(new Color(242, 129, 25));

		btnQuanLyHoaDon = new JButton("Quản lý hóa đơn");
		btnQuanLyHoaDon.setFocusPainted(false);
		btnQuanLyHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyHoaDon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/hoadon.png"))));
		btnQuanLyHoaDon.setBounds(0, 115, 320, 115);
		panel_1.add(btnQuanLyHoaDon);
		btnQuanLyHoaDon.setIconTextGap(10);
		btnQuanLyHoaDon.setForeground(Color.WHITE);
		btnQuanLyHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyHoaDon.setBackground(new Color(242, 129, 25));
		btnQuanLyHoaDon.setAlignmentX(1.0f);

		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setFocusPainted(false);
		btnQuanLyNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhanVien.setIconTextGap(10);
		btnQuanLyNhanVien.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/nv.png"))));
		btnQuanLyNhanVien.setBounds(0, 460, 320, 115);
		panel_1.add(btnQuanLyNhanVien);
		btnQuanLyNhanVien.setForeground(Color.WHITE);
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyNhanVien.setBackground(new Color(242, 129, 25));

		btnQuanLyHoaDon.addActionListener(this);
		btnQuanLyLuong.addActionListener(this);
		btnQuanLyNhanVien.addActionListener(this);
		btnQuanLySanPham.addActionListener(this);
		btnQuanLyTaiKhoan.addActionListener(this);
		btnThongKe.addActionListener(this);

		pnlChange = new JPanel();
		pnlChange.setBounds(320, 0, 1600, 1055);
		getContentPane().add(pnlChange);
		pnlChange.setLayout(new CardLayout(0, 0));

		cardLayout = (CardLayout) pnlChange.getLayout();

		pnlChange.add(trangTK, "btnThongKe");
		pnlChange.add(trangHD, "btnQuanLyHoaDon");
		pnlChange.add(trangLuong, "btnQuanLyLuong");
		pnlChange.add(trangNV, "btnQuanLyNhanVien");
		pnlChange.add(trangSP, "btnQuanLySanPham");
		pnlChange.add(trangtaiKhoan, "btnQuanLyTaiKhoan");

		// set active khi bắt đầu vào
		temp = btnThongKe;
		activeButton(btnThongKe);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object key = e.getSource();

		activeButton((JButton) key);
		inActiveButton(temp);
		temp = (JButton) key;

		if (key == btnQuanLyHoaDon) {
			cardLayout.show(pnlChange, "btnQuanLyHoaDon");
			trangHD.setTaiKhoan(taiKhoan);
		} else if (key == btnQuanLyLuong)
			cardLayout.show(pnlChange, "btnQuanLyLuong");
		else if (key == btnQuanLyNhanVien)
			cardLayout.show(pnlChange, "btnQuanLyNhanVien");
		else if (key == btnQuanLySanPham)
			cardLayout.show(pnlChange, "btnQuanLySanPham");
		else if (key == btnQuanLyTaiKhoan)
			cardLayout.show(pnlChange, "btnQuanLyTaiKhoan");
		else if (key == btnThongKe) {
			cardLayout.show(pnlChange, "btnThongKe");
		}

	}

	/**
	 * đổ màu tab khi active
	 * 
	 * @param buttonActive
	 * 
	 */
	public void activeButton(JButton buttonActive) {
		buttonActive.setEnabled(false);
		buttonActive.setBackground(new Color(248, 198, 153));
		buttonActive.setForeground(Color.black);
	}

	/**
	 * đổ màu lại khi inactive
	 * 
	 * @param buttonInactive
	 */
	public void inActiveButton(JButton buttonInactive) {
		buttonInactive.setEnabled(true);
		buttonInactive.setForeground(Color.WHITE);
		buttonInactive.setBackground(new Color(242, 129, 25));
	}

	/**
	 * Thông báo khi muốn thoát ứng dụng
	 */
	public void thongBaoThoat() {
		JOptionPane jOptionPane = new JOptionPane();
		jOptionPane.setBackground(new Color(242, 129, 25));
		int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không", "Thông báo thoát",
				JOptionPane.YES_NO_OPTION);
		if (tl == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		thongBaoThoat();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
