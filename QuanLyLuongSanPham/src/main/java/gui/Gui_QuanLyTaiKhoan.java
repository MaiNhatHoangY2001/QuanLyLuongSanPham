package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gui_package.ChucNang;

import java.awt.Font;
import javax.swing.JButton;

public class Gui_QuanLyTaiKhoan extends JPanel{
	private JPanel panel;
	private JLabel lblQLTK;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblLogoNV;
	private JPanel panelXoa;
	private JPanel panelThem;
	public Gui_QuanLyTaiKhoan() {
		setSize(1600, 1046);
		setBackground(new Color(194, 93, 0));
		setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1600, 100);
		add(panel);
		
		lblQLTK = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQLTK.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblQLTK.setForeground(Color.WHITE);
		lblQLTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLTK.setBounds(499, 0, 601, 100);
		panel.add(lblQLTK);
		
		lblNgay = new JLabel("New label");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(0, 16, 233, 33);
		panel.add(lblNgay);
		
		lblGio = new JLabel("New label");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 201, 42);
		panel.add(lblGio);
		
		ChucNang.setGio(lblGio, lblNgay);
		
		lblLogoNV = new JLabel("Chinh");
		lblLogoNV.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogoNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoNV.setForeground(Color.WHITE);
		lblLogoNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogoNV.setBounds(1393, 10, 192, 45);
		panel.add(lblLogoNV);
		
		panelXoa = new JPanel();
		panelXoa.setBounds(975, 646, 625, 400);
		add(panelXoa);
		
		panelThem = new JPanel();
		panelThem.setBounds(975, 200, 625, 400);
		add(panelThem);
		panelThem.setLayout(null);
	}
	
}
