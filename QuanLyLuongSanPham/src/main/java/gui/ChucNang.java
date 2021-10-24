package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChucNang {
	private int xClicked;
	private int yClicked;
	/**
	 * chỉnh giờ cho lable
	 * 
	 * @param lblGio
	 */
	public static void setGio(JLabel lblGio) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				lblGio.setText((new Date().getHours() >= 10 ? "" : "0") + (new Date().getHours())
						+ ((new Date().getSeconds() % 2) != 0 ? " " : ":")
						+ ((new Date().getMinutes() >= 10 ? "" : "0") + (new Date().getMinutes())));
			}

		};
		long delay = 1000L;
		Timer timer = new Timer("Timer");
		timer.schedule(timerTask, 0, delay);
	}
	
	
	public static void setDiChuyenGD(JFrame frame) {
		
		AtomicInteger xClicked = new AtomicInteger(0);
		AtomicInteger yClicked = new AtomicInteger(0);

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xClicked.set(e.getX());
				yClicked.set(e.getY());
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xClicked.get(), y - yClicked.get());
			}
		});
	}
	
}
