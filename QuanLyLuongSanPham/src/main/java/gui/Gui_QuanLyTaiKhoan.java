package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import gui_package.ChucNang;

public class Gui_QuanLyTaiKhoan extends JPanel{
	private JPanel panel;
	private JLabel lblGio;
	private JLabel lblTieuDe;
	private JLabel lblNgay;

	public Gui_QuanLyTaiKhoan(){
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(194, 93, 0));
		panel.setBounds(0, 90, 1600, 92);
		add(panel);
		
		lblTieuDe = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblTieuDe.setForeground(Color.WHITE);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTieuDe.setBounds(0, 0, 1600, 92);
		add(lblTieuDe);
		
		lblNgay = new JLabel("New label");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setBounds(0, 16, 233, 33);
		add(lblNgay);
		
		lblGio = new JLabel("New label");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 233, 33);
		add(lblGio);
		
		ChucNang.setGio(lblGio, lblNgay);
	}
}
