package gui_package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlIn extends JFrame {
	private CircleBtn btnIn;
	private JComboBox<String> cboLoaiTep;
	private RoundTextField txtSrc;
	private CircleBtn btnSrc;

	public PnlIn() {
		/**
		 * In
		 */
		JPanel pnlIn = new RoundedPanel();
		pnlIn.setLayout(null);
		pnlIn.setBackground(new Color(248, 198, 153));
		pnlIn.setBounds(961, 516, 608, 331);
		add(pnlIn);

		btnIn = new CircleBtn("In");
		btnIn.setForeground(Color.WHITE);
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIn.setBackground(new Color(233, 180, 46));
		btnIn.setBounds(262, 251, 177, 44);
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnIn);

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

		JLabel lblInBangLuong = new JLabel("In bảng lương");
		lblInBangLuong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInBangLuong.setBounds(24, 11, 268, 42);
		pnlIn.add(lblInBangLuong);

		JLabel lblURL = new JLabel("Đường dẫn: ");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblURL.setBounds(34, 161, 134, 44);
		pnlIn.add(lblURL);

		txtSrc = new RoundTextField("", 1000);
		txtSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSrc.setBounds(178, 163, 345, 43);
		pnlIn.add(txtSrc);
		txtSrc.setColumns(10);

		btnSrc = new CircleBtn("...");
		btnSrc.setForeground(Color.WHITE);
		btnSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSrc.setBackground(new Color(233, 180, 46));
		btnSrc.setBounds(533, 161, 51, 44);
		btnSrc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnSrc);
	}

}
