/**U10111033, Computer science 4, Hsueh_Hsin Lu*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class DisplayClock extends JFrame {
	// Create an analog clock for the current time; display hour, minute, and seconds in the message panel
	StillClock clock = new StillClock();
	MessagePanel messagePanel = new MessagePanel();
	
	public DisplayClock() {
		//set color and font
		messagePanel.setForeground(Color.blue);
		messagePanel.setFont(new Font("Courie", Font.BOLD, 16));
		
		//GridLayout
		JPanel p1 = new JPanel(); //Button panel
		p1.setLayout(new GridLayout(2,1)); //set grid
		p1.add(clock);
		p1.add(messagePanel);
		add(p1);
		
		//Both javax.swing and java.util has Timer, so we assign it to javax.swing.Timer
		javax.swing.Timer myTime = new javax.swing.Timer(1000, new TimerListener());
		myTime.start();
	}
	
	//TimerListener, and call the repaint and setCurrentTime on StillClock and MessagePanel
	public class TimerListener implements ActionListener{
		@Override /** Handle TimerListener */
		public void actionPerformed(ActionEvent e){
			clock.setCurrentTime();
			clock.repaint();
			messagePanel.setCurrentTime();
			messagePanel.repaint();
		}
	}
	
	//main here
	public static void main(String[] args) {
		DisplayClock frame = new DisplayClock();
		frame.setTitle("DisplayClock");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 350);
		frame.setVisible(true);
	}
	
	//class of messagePanel
	static class MessagePanel extends JPanel {
		private int x = 110;
		private int y = 50;
		private int second;
		private int minute;
		private int hour;
		
		public void setCurrentTime(){
			Calendar myCalendar = new GregorianCalendar();
			// Set current hour, minute and second
			this.hour = myCalendar.get(Calendar.HOUR_OF_DAY);
			this.minute = myCalendar.get(Calendar.MINUTE);
			this.second = myCalendar.get(Calendar.SECOND);
		}
		
		public MessagePanel() {
			setCurrentTime();
		}
		
		@Override /**rewrite paintComponent*/
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//draw it begin frme 110, 50
			g.drawString(hour + ":" + minute + ":" + second , x, y);
		}
	}
}