package gui_package;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTable extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color bg, fg;

	public  CustomTable(Color bg, Color fg) {
		super();
		this.bg = bg;
		this.fg = fg;
		setHorizontalAlignment(CENTER);
	}
	
	public CustomTable() {
		setHorizontalAlignment(RIGHT);
	};
	

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
	
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		cell.setBackground(bg);
		cell.setForeground(fg);
		return cell;
	}

}
