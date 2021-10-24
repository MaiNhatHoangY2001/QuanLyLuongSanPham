package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class FrmQuanLyLuong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLyLuong frame = new FrmQuanLyLuong();
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
	public FrmQuanLyLuong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 1024);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 93, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1424, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));

		JLabel lblChinh = new JLabel("QUẢN LÝ LƯƠNG");
		lblChinh.setForeground(Color.WHITE);
		lblChinh.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblChinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblChinh.setBounds(292, 34, 885, 74);
		panel.add(lblChinh);

		UIManager.put("TabbedPane.selected", new Color(242, 129, 25));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 150, 1424, 835);
		tabbedPane.setBackground(new Color(194, 93, 0));

		contentPane.add(tabbedPane);

		/**
		 * tab
		 */

		tabbedPane.add("Tính lương", new FrmTinhLuong());
		tabbedPane.setTabComponentAt(0, new DemoCustomTab(this));

		tabbedPane.add("Tính doanh thu", new FrmTinhDoanhThu());
		tabbedPane.setTabComponentAt(1, new DemoCustomTab(this));

	}
}
