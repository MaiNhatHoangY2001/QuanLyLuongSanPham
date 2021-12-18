package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui_package.BangLuongExcelExporter;
import gui_package.ExportPhieuLuong;

public class Gui_XuatFile extends JFrame {

	private JPanel contentPane;
	private JButton btnXuatFile;
	private JTextField txtSrc;
	private JButton btnSrc;
	private String path;

	/**
	 * Create the frame.
	 */
	public Gui_XuatFile(List<?> list, int month, int year, String chucVu, String loaiIn) {
		setResizable(false);
		setBounds(100, 100, 603, 288);
		setTitle("Xuất file");
		setIconImage(new ImageIcon("img/logo.png").getImage());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlIn = new JPanel();
		pnlIn.setLayout(null);
		pnlIn.setBackground(new Color(248, 198, 153));
		pnlIn.setBounds(961, 516, 608, 331);
		getContentPane().add(pnlIn);

		btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setForeground(Color.WHITE);
		btnXuatFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXuatFile.setBackground(new Color(233, 180, 46));
		btnXuatFile.setBounds(216, 171, 177, 44);
		btnXuatFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXuatFile.addActionListener(e -> {
			int rs = JOptionPane.YES_OPTION;
			if (list.isEmpty())
				rs = JOptionPane.showConfirmDialog(null, "Dữ liệu trống. bạn có muốn xuất file ko?",
						"Thông báo dữ liệu trống", JOptionPane.YES_NO_OPTION);
			if (rs == JOptionPane.YES_OPTION) {
				try {
					if (loaiIn.equals("BL")) {
						BangLuongExcelExporter bangLuong = new BangLuongExcelExporter(list, month, year);
						bangLuong.exportBangLuong(path);
					} else {
						ExportPhieuLuong exportPhieuLuong = new ExportPhieuLuong(list, month, year, chucVu);
						exportPhieuLuong.saveFile(path);
					}
					JOptionPane.showMessageDialog(this, "Xuất File thành công");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Xuất File không thành công");
					e1.printStackTrace();
				}
			}

		});
		pnlIn.add(btnXuatFile);

		JLabel lblInBangLuong = new JLabel("Xuất File ");
		lblInBangLuong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInBangLuong.setBounds(24, 11, 268, 42);
		pnlIn.add(lblInBangLuong);

		JLabel lblURL = new JLabel("Đường dẫn: ");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblURL.setBounds(36, 100, 134, 44);
		pnlIn.add(lblURL);

		txtSrc = new JTextField("", 1000);
		txtSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSrc.setBounds(148, 101, 329, 43);
		pnlIn.add(txtSrc);
		txtSrc.setColumns(10);

		btnSrc = new JButton("...");
		btnSrc.setForeground(Color.WHITE);
		btnSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSrc.setBackground(new Color(233, 180, 46));
		btnSrc.setBounds(487, 100, 51, 44);
		btnSrc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSrc.addActionListener(e -> {

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents (.xlsx)", "xlsx"));
			fileChooser.setAcceptAllFileFilterUsed(true);

			int userSelection = fileChooser.showSaveDialog(this);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				path = fileToSave.getAbsolutePath();
				txtSrc.setText(path);
			}
		});
		pnlIn.add(btnSrc);

	}
}
