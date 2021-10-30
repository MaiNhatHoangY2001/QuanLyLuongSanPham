package gui_package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Regex {
	public boolean kiemTraEmail(JTextField txt) {
		String input = txt.getText();
		String regex = "^([a-zA-Z0-9]+)([\\_\\.\\-{1}])?([a-zA-Z0-9]+)\\@([a-zA-Z0-9]+)([\\.])([a-zA-Z\\.]+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Email của bạn không chính xác! Vui lòng kiểm tra lại.\n VD:abc123@gmail.com");
			txt.requestFocus();
			txt.selectAll();
			return true;
		} else
			return false;
	}
	
	public boolean kiemTraSDT(JTextField txt) {
		String input = txt.getText();
		String regex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không chính xác! Vui lòng kiểm trả lại\n Chỉ chấp nhận 10 số VD: 03341172541");
			txt.requestFocus();
			txt.selectAll();
			return true;
		} else
			return false;
	}
	
	public boolean kiemTraCMND(JTextField txt) {
		String input = txt.getText();
		String regex = "^[0-9]{9,12}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Số chứng minh không chính xác! Vui lông kiểm tra lại\nChỉ cho phếp nhập 12 số\nVí dụ: 321780336 hoặc 083201009278");
			txt.requestFocus();
			txt.selectAll();
			return true;
		} else
			return false;
	}
}
