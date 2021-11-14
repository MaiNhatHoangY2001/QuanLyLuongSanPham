package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.KhachHang;
import services.QuanLyHoaDonService;

public class Gui_ThemKhachHang extends JDialog implements ActionListener {
	private JLabel lblDiaChi;
	private JLabel lblSdt;
	private JLabel lblTen;
	private JTextField txtDiaChi;
	private JTextField txtTen;
	private JTextField txtSdt;
	private JButton btnThem;
	private JButton btnHuy;
	private QuanLyHoaDonService quanLyHoaDonService;
	public Gui_ThemKhachHang() {

		quanLyHoaDonService = new QuanLyHoaDonService();
		setResizable(false);
		setIconImage(new ImageIcon("img/logo.png").getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(600, 200);
		setSize(800, 400);

		setLayout(new BorderLayout());
		JPanel pnN = new JPanel();
		JPanel pnC = new JPanel();
		JPanel pnS = new JPanel();
		pnC.setBackground(new Color(248, 198, 153));
		pnN.setBackground(new Color(242, 129, 25));
		pnS.setBackground(new Color(242, 129, 25));
		JLabel lblTieuDe = new JLabel("THÊM KHÁCH HÀNG MỚI");
		add(pnN, BorderLayout.NORTH);
		add(pnC);
		add(pnS, BorderLayout.SOUTH);

		lblDiaChi = new JLabel("Địa chỉ: ");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSdt = new JLabel("Số điện thoại: ");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTen = new JLabel("Tên khách hàng: ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 24));

		txtDiaChi = new JTextField(20);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem = new JButton("Thêm khách hàng");

		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		lblSdt.setPreferredSize(lblTen.getPreferredSize());
		pnN.add(lblTieuDe);

		btnHuy.setBackground(new Color(233, 180, 46));
		btnThem.setBackground(new Color(233, 180, 46));
		btnHuy.setForeground(Color.WHITE);
		btnThem.setForeground(Color.WHITE);
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();

		b1.add(lblTen);
		b1.add(txtTen);
		b2.add(lblSdt);
		b2.add(txtSdt);
		b3.add(lblDiaChi);
		b3.add(txtDiaChi);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		pnC.add(b);

		b1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		b2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		b3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pnS.add(btnHuy);
		pnS.add(btnThem);
		btnThem.addActionListener(this);
		btnHuy.addActionListener(e->{
			thongBaoHuy();
		});
		
	}
	private void thongBaoHuy() {
		int temp=JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy?","Cảnh báo",JOptionPane.YES_NO_OPTION);
		if(temp==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> {
			new Gui_ThemKhachHang().setVisible(true);
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem)) {
			if(kiemTraDuLieu()) {
				KhachHang khachHang= getKhachHangByTxt();
				if(quanLyHoaDonService.timKhachHangBySdt(khachHang.getsDT())==null) {
					quanLyHoaDonService.themKhachHang(khachHang);
					JOptionPane.showMessageDialog(this,"Đẫ thêm","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(this,"Khách hàng này đã tồn tại","Cảnh báo",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
	}
	private KhachHang getKhachHangByTxt() {
		String ten = txtTen.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String sdt = txtSdt.getText().trim();
		return new KhachHang(ten, diaChi, sdt);
	}
	public boolean kiemTraDuLieu() {
		String ten = txtTen.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String sdt = txtSdt.getText().trim();
		
		if(!ten.matches("[A-Za-z0-9a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\\.'\\-]+")) {
			JOptionPane.showMessageDialog(this,"Tên không được để trống, không chưa kí tự đặc biệt","Cảnh báo",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(diaChi.equals("")) {
			JOptionPane.showMessageDialog(this,"Địa chỉ không được để trống","Cảnh báo",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!sdt.matches("[0-9]{9,12}")) {
			JOptionPane.showMessageDialog(this,"Số điện thoại không được để trống, chỉ chấp nhận số, 9 đến 12 kí số","Cảnh báo",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}
}
