package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Gui_SuaThongTinSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenSanPham;
	private JTextField txtGiaThanh;
	private JTextField txtNCC;
	private JTextField txtNSX;
	private JTextField txtSanPham;
	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;

	/**
	 * Create the frame.
	 */
	public Gui_SuaThongTinSanPham() {
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);
		pnlHeader.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN SẢN PHẨM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(294, 28, 835, 93);
		pnlHeader.add(lblNewLabel);
		
		JLabel lblIcon = new JLabel("New label");
		Image imgUser = new ImageIcon("img\\dtVua.png").getImage();
		lblIcon.setIcon(new ImageIcon(imgUser));
		lblIcon.setBounds(50, 42, 96, 66);
		pnlHeader.add(lblIcon);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 151, 1424, 834);
		contentPane.add(pnlContent);
		pnlContent.setLayout(null);
		
		JPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(50, 50));
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(113, 115, 1200, 556);
		pnlContent.add(pnlInput);
		pnlInput.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(81, 59, 225, 40);
		pnlInput.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá Thành:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(78, 158, 225, 40);
		pnlInput.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loại:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(78, 257, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhà Cung Cấp:");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1.setBounds(78, 356, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày Sản Xuất");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1.setBounds(78, 455, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1_1);
		
		txtTenSanPham = new RoundTextField("", 1000);
		txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenSanPham.setBounds(387, 54, 730, 50);
		pnlInput.add(txtTenSanPham);
		txtTenSanPham.setColumns(10);
		
		txtGiaThanh = new RoundTextField("", 1000);
		txtGiaThanh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtGiaThanh.setColumns(10);
		txtGiaThanh.setBounds(387, 158, 730, 50);
		pnlInput.add(txtGiaThanh);
		
		txtNCC = new RoundTextField("", 1000);
		txtNCC.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNCC.setColumns(10);
		txtNCC.setBounds(387, 351, 730, 50);
		pnlInput.add(txtNCC);
		
		txtNSX = new RoundTextField("", 1000);
		txtNSX.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNSX.setColumns(10);
		txtNSX.setBounds(387, 450, 730, 50);
		pnlInput.add(txtNSX);
		
		JComboBox cmbLoai = new JComboBox();
		cmbLoai.setBackground(Color.WHITE);
		cmbLoai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbLoai.setBounds(387, 252, 730, 50);
		pnlInput.add(cmbLoai);
		
		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBounds(168, 707, 250, 90);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);
		
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(586, 707, 250, 90);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);
		
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1004, 707, 250, 90);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 180, 46));
		panel.setBounds(113, 36, 279, 43);
		pnlContent.add(panel);
		panel.setLayout(null);
		
		txtSanPham = new JTextField();
		txtSanPham.setEnabled(false);
		txtSanPham.setBounds(114, 0, 165, 43);
		panel.add(txtSanPham);
		txtSanPham.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sản Phẩm");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 0, 106, 43);
		panel.add(lblNewLabel_2);
	}

}
