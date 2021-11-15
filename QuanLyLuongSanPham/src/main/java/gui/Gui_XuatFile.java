package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

public class Gui_XuatFile extends JFrame {

	private JPanel contentPane;
	private JButton btnXuatFile;
	private JComboBox<String> cboLoaiTep;
	private JTextField txtSrc;
	private JButton btnSrc;
	private String path;

	/**
	 * Create the frame.
	 */
	public Gui_XuatFile(int month, int year) {
		setResizable(false);
		setBounds(100, 100, 645, 396);
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
		btnXuatFile.setBounds(268, 251, 177, 44);
		btnXuatFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXuatFile.addActionListener(e -> {
			try {
				createExcel(path);
				JOptionPane.showMessageDialog(this, "Xuất File thành công");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Xuất File không thành công");
				e1.printStackTrace();
			}
		});
		pnlIn.add(btnXuatFile);

		cboLoaiTep = new JComboBox<String>();
		cboLoaiTep.setModel(new DefaultComboBoxModel<String>(new String[] { "Excel", "Notepad" }));

		cboLoaiTep.setForeground(Color.WHITE);
		cboLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiTep.setBackground(new Color(233, 180, 46));
		cboLoaiTep.setBounds(178, 94, 400, 41);
		pnlIn.add(cboLoaiTep);

		JLabel lblLoaiTep = new JLabel("Loại tệp tin: ");
		lblLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiTep.setBounds(34, 92, 134, 44);
		pnlIn.add(lblLoaiTep);

		JLabel lblInBangLuong = new JLabel("Xuất File ");
		lblInBangLuong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInBangLuong.setBounds(24, 11, 268, 42);
		pnlIn.add(lblInBangLuong);

		JLabel lblURL = new JLabel("Đường dẫn: ");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblURL.setBounds(34, 161, 134, 44);
		pnlIn.add(lblURL);

		txtSrc = new JTextField("", 1000);
		txtSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSrc.setBounds(178, 163, 345, 43);
		pnlIn.add(txtSrc);
		txtSrc.setColumns(10);

		btnSrc = new JButton("...");
		btnSrc.setForeground(Color.WHITE);
		btnSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSrc.setBackground(new Color(233, 180, 46));
		btnSrc.setBounds(533, 161, 51, 44);
		btnSrc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSrc.addActionListener(e -> {

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents (.xls)", "xls"));
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

	public void createExcel(String path) throws FileNotFoundException, IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Bảng lương nhân viên");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow(0);
		// Or do it on one line.

		Cell maNVCell = row.createCell(0);
		maNVCell.setCellValue("Mã nhân viên");
		setStyle(wb, row, maNVCell, HorizontalAlignment.CENTER);

		Cell tenNVCell = row.createCell(1);
		tenNVCell.setCellValue("Tên nhân viên");
		setStyle(wb, row, tenNVCell, HorizontalAlignment.CENTER);

		Cell mucLuongCell = row.createCell(2);
		mucLuongCell.setCellValue("Mức lương");
		setStyle(wb, row, mucLuongCell, HorizontalAlignment.CENTER);

		Cell heSoLuongCell = row.createCell(3);
		heSoLuongCell.setCellValue("Hệ số lương");
		setStyle(wb, row, heSoLuongCell, HorizontalAlignment.CENTER);

		Cell tienSpCell = row.createCell(4);
		tienSpCell.setCellValue("Tổng tiền sản phẩm");
		setStyle(wb, row, tienSpCell, HorizontalAlignment.CENTER);

		Cell soNgayCongCell = row.createCell(5);
		soNgayCongCell.setCellValue("Số ngày công");
		setStyle(wb, row, soNgayCongCell, HorizontalAlignment.CENTER);

		Cell tienLuongCell = row.createCell(6);
		tienLuongCell.setCellValue("Tiền lương");
		setStyle(wb, row, tienLuongCell, HorizontalAlignment.CENTER);

		// Write the output to a file
		try (OutputStream fileOut = new FileOutputStream(path + ".xls")) {
			wb.write(fileOut);
		}
	}

	/**
	 * Creates a cell and aligns it a certain way.
	 *
	 * @param wb     the workbook
	 * @param row    the row to create the cell in
	 * @param column the column number to create the cell in
	 * @param halign the horizontal alignment for the cell.
	 * @param valign the vertical alignment for the cell.
	 */
	public void setStyle(Workbook wb, Row row, Cell cell, HorizontalAlignment halign) {
		CellStyle cellStyle = wb.createCellStyle();
		HSSFFont font = (HSSFFont) wb.createFont();
		cellStyle.setAlignment(halign);
		font.setFontHeightInPoints((short) 13);
		font.setFontName("Times New Roman");
		cell.setCellStyle(cellStyle);
	}
}
