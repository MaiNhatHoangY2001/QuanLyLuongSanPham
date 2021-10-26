package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;

public class Gui_ThemNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;
	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbNgay;
	private JRadioButton rdbtnNam;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;
	private JRadioButton rdbtnNu;

	/**
	 * Create the frame.
	 */
	public Gui_ThemNhanVien() {
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);

		JLabel lblThmNhnVin = new JLabel("THÊM NHÂN VIÊN");
		lblThmNhnVin.setForeground(Color.WHITE);
		lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblThmNhnVin.setBounds(441, 28, 541, 93);
		pnlHeader.add(lblThmNhnVin);

		JLabel lblNewLabel = new JLabel("");
		Image imgUser = new ImageIcon("img\\dtVua.png").getImage();
		lblNewLabel.setIcon(new ImageIcon(imgUser));
		lblNewLabel.setBounds(50, 42, 96, 66);
		pnlHeader.add(lblNewLabel);

		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 151, 1424, 834);
		contentPane.add(pnlContent);

		JPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(50, 50));
		pnlInput.setLayout(null);
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(112, 40, 1200, 666);
		pnlContent.add(pnlInput);

		JLabel lblHoTen = new JLabel("Họ Và Tên:");
		lblHoTen.setForeground(Color.BLACK);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHoTen.setBounds(81, 38, 225, 40);
		pnlInput.add(lblHoTen);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDiaChi.setBounds(81, 272, 225, 40);
		pnlInput.add(lblDiaChi);

		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSDT.setBounds(81, 350, 225, 40);
		pnlInput.add(lblSDT);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setForeground(Color.BLACK);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCMND.setBounds(81, 428, 225, 40);
		pnlInput.add(lblCMND);

		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setForeground(Color.BLACK);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChucVu.setBounds(81, 506, 225, 40);
		pnlInput.add(lblChucVu);

		txtTen = new RoundTextField("", 1000);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen.setColumns(10);
		txtTen.setBounds(387, 33, 730, 50);
		pnlInput.add(txtTen);

		txtDiaChi = new RoundTextField("", 1000);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(387, 267, 730, 50);
		pnlInput.add(txtDiaChi);

		txtCMND = new RoundTextField("", 1000);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(387, 423, 730, 50);
		pnlInput.add(txtCMND);

		txtEmail = new RoundTextField("", 1000);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(387, 579, 730, 50);
		pnlInput.add(txtEmail);

		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbChucVu.setBackground(Color.WHITE);
		cmbChucVu.setBounds(387, 501, 730, 50);
		pnlInput.add(cmbChucVu);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEmail.setBounds(81, 584, 225, 40);
		pnlInput.add(lblEmail);

		txtSDT = new RoundTextField("", 1000);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(387, 345, 730, 50);
		pnlInput.add(txtSDT);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNgaySinh.setBounds(81, 116, 225, 40);
		pnlInput.add(lblNgaySinh);
		
		cmbNgay = new JComboBox<String>();
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(387, 117, 220, 50);
		pnlInput.add(cmbNgay);
		
		cmbThang = new JComboBox<String>();
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(646, 117, 220, 50);
		pnlInput.add(cmbThang);
		
		cmbNam = new JComboBox<String>();
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(897, 117, 220, 50);
		pnlInput.add(cmbNam);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setForeground(Color.BLACK);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGioiTinh.setBounds(81, 194, 225, 40);
		pnlInput.add(lblGioiTinh);
		
		JPanel pnlNam = new JPanel();
		pnlNam.setBackground(Color.WHITE);
		pnlNam.setBounds(387, 194, 220, 50);
		pnlInput.add(pnlNam);
		pnlNam.setLayout(null);
		
		rdbtnNam = new JRadioButton("");
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setPreferredSize(new Dimension(30, 30));
		rdbtnNam.setMaximumSize(new Dimension(30, 30));
		rdbtnNam.setIconTextGap(6);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnNam.setBounds(194, 0, 20, 50);
		pnlNam.add(rdbtnNam);
		
		JLabel lblNam = new JLabel("Nam");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNam.setBounds(10, 11, 49, 28);
		pnlNam.add(lblNam);
		
		JPanel pnlNu = new JPanel();
		pnlNu.setLayout(null);
		pnlNu.setBackground(Color.WHITE);
		pnlNu.setBounds(646, 194, 220, 50);
		pnlInput.add(pnlNu);
		
		rdbtnNu = new JRadioButton("");
		rdbtnNu.setPreferredSize(new Dimension(30, 30));
		rdbtnNu.setMaximumSize(new Dimension(30, 30));
		rdbtnNu.setIconTextGap(6);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(194, 0, 20, 50);
		pnlNu.add(rdbtnNu);
		
		JLabel lblNu = new JLabel("Nữ");
		lblNu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNu.setBounds(10, 11, 37, 28);
		pnlNu.add(lblNu);

		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setBounds(183, 730, 230, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(596, 730, 230, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1009, 730, 230, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		/**
		 * Các chức năng
		 */
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnHuyBo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			if (KiemTraRong()) {
				JOptionPane.showMessageDialog(this, "");
			}
		} else if (o.equals(btnXoaRong)) {
			txtTen.setText("");
			txtSDT.setText("");
			txtCMND.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			txtTen.requestFocus();
		} else if (o.equals(btnHuyBo)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}
	}

	public boolean KiemTraRong() {
		if (KiemTraRongText(txtTen))
			return true;
		else if (KiemTraRongText(txtSDT))
			return true;
		else if (KiemTraRongText(txtCMND))
			return true;
		else if (KiemTraRongText(txtEmail))
			return true;
		else if (KiemTraRongText(txtDiaChi))
			return true;
		return false;
	}

	public boolean KiemTraRongText(JTextField txt) {
		return txt.getText().equals("") ? true : false;
	}
}
