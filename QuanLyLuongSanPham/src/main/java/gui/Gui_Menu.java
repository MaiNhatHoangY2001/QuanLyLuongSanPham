package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Gui_Menu extends JPanel {
	private JButton btnTrangChu;
	private JButton btnQuanLyNhanVien;
	private JButton btnNewButton;
	private JButton btnQuanLyLuong;
	private JButton btnThoat;
	private JButton btnVeChungToi;
	private JButton btnQuanLyDuLieu;
	private JButton btnQuanLySanPham;
	private JButton btnThongKe;

	/**
	 * Create the panel.
	 */
	public Gui_Menu() {
		setBackground(new Color(231, 231, 231));
		setBorder(new LineBorder(new Color(255, 140, 0)));
		setSize(new Dimension(400, 1024));
		setMinimumSize(new Dimension(400, 1024));
		setLayout(null);

		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setIconTextGap(50);
		btnTrangChu.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnTrangChu.setAlignmentX(0.5f);
		btnTrangChu.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/Home.PNG"));
		btnTrangChu.setBackground(new Color(231, 231, 231));
		btnTrangChu.setBorder(new LineBorder(new Color(255, 127, 80)));
		btnTrangChu.setForeground(new Color(242, 129, 25));
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTrangChu.setBounds(0, 0, 400, 86);
		add(btnTrangChu);

		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setIconTextGap(50);
		btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhanVien.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/QuanLyNhanVien.PNG"));
		btnQuanLyNhanVien.setBackground(new Color(231, 231, 231));
		btnQuanLyNhanVien.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnQuanLyNhanVien.setForeground(new Color(242, 129, 25));
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyNhanVien.setBounds(0, 83, 400, 86);
		add(btnQuanLyNhanVien);

		btnNewButton = new JButton("Quản lý hóa đơn");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIconTextGap(50);
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/QuanLyHoaDon.PNG"));
		btnNewButton.setBackground(new Color(231, 231, 231));
		btnNewButton.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnNewButton.setForeground(new Color(242, 129, 25));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(0, 167, 400, 86);
		add(btnNewButton);

		btnQuanLyLuong = new JButton("Quản lý lương");
		btnQuanLyLuong.setLocation(new Point(20, 0));
		btnQuanLyLuong.setIconTextGap(50);
		btnQuanLyLuong.setHorizontalAlignment(SwingConstants.LEADING);
		btnQuanLyLuong.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/QuanLyLuong.PNG"));
		btnQuanLyLuong.setBackground(new Color(231, 231, 231));
		btnQuanLyLuong.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnQuanLyLuong.setForeground(new Color(242, 129, 25));
		btnQuanLyLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyLuong.setBounds(0, 249, 400, 86);
		add(btnQuanLyLuong);

		btnThongKe = new JButton("Thống kê thu chi");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIconTextGap(50);
		btnThongKe.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/ThongkeThuChi.PNG"));
		btnThongKe.setBackground(new Color(231, 231, 231));
		btnThongKe.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnThongKe.setForeground(new Color(242, 129, 25));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThongKe.setBounds(0, 333, 400, 86);
		add(btnThongKe);

		btnQuanLySanPham = new JButton("Quản lý sản phẩm");
		btnQuanLySanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLySanPham.setIconTextGap(50);
		btnQuanLySanPham.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/QuanLysanPham.PNG"));
		btnQuanLySanPham.setBackground(new Color(231, 231, 231));
		btnQuanLySanPham.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnQuanLySanPham.setForeground(new Color(242, 129, 25));
		btnQuanLySanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLySanPham.setBounds(0, 415, 400, 86);
		add(btnQuanLySanPham);

		btnQuanLyDuLieu = new JButton("Quản lý dữ liệu");
		btnQuanLyDuLieu.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyDuLieu.setIconTextGap(50);
		btnQuanLyDuLieu.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/QuanLyDuLieu.PNG"));
		btnQuanLyDuLieu.setBackground(new Color(231, 231, 231));
		btnQuanLyDuLieu.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnQuanLyDuLieu.setForeground(new Color(242, 129, 25));
		btnQuanLyDuLieu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyDuLieu.setBounds(0, 499, 400, 86);
		add(btnQuanLyDuLieu);

		btnVeChungToi = new JButton("Về chúng tôi");
		btnVeChungToi.setHorizontalAlignment(SwingConstants.LEFT);
		btnVeChungToi.setIconTextGap(50);
		btnVeChungToi.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/VeChungToi.PNG"));
		btnVeChungToi.setBackground(new Color(231, 231, 231));
		btnVeChungToi.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnVeChungToi.setForeground(new Color(242, 129, 25));
		btnVeChungToi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnVeChungToi.setBounds(0, 581, 400, 86);
		add(btnVeChungToi);

		btnThoat = new JButton("Thoát");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIconTextGap(50);
		btnThoat.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/Thoat.PNG"));
		btnThoat.setBackground(new Color(231, 231, 231));
		btnThoat.setBorder(new LineBorder(new Color(255, 140, 0)));
		btnThoat.setForeground(new Color(242, 129, 25));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThoat.setBounds(0, 665, 400, 86);
		add(btnThoat);
	
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/Logo.PNG"));
		lblNewLabel.setBounds(105, 805, 175, 121);
		add(lblNewLabel);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 1024);
		frame.getContentPane().add(new Gui_Menu());
		frame.setVisible(true);

	}

}
