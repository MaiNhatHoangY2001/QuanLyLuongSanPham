package gui;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class ChucNang {
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
}
