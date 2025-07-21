//author juliana abu shkara 207840216


package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AninamationOfBookNow extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int w = 878;
	private final int h = 200;

	private ImageIcon bookNowIcon;
	private ImageIcon backgroundIcon;

	private Image bookNowImg;
	private Image background;

	private Timer timer;
	private int speedX = 12;
	private int speedY = 8;

	private int x = 0;
	private int y = 0;

	public AninamationOfBookNow() {

		this.setPreferredSize(new Dimension(w, h));

		bookNowIcon = new ImageIcon(this.getClass().getResource("/animateBooking.png"));
		bookNowImg = bookNowIcon.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		backgroundIcon = new ImageIcon(this.getClass().getResource("/HotelBack.jpg"));
		background = backgroundIcon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		timer = new Timer(50, this);
		timer.start();
	}

	public void paint(Graphics ad) {
		super.paint(ad);
		Graphics2D cloud = (Graphics2D) ad;

		cloud.drawImage(background, 0, 0, null);
		cloud.drawImage(bookNowImg, x, y, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ((x >= w - bookNowImg.getWidth(null)) || (x < 0)) {
			speedX = speedX * -1;
		}

		x = x + speedX;
		if ((y >= h - bookNowImg.getHeight(null)) || (y < 0)) {
			speedY = speedY * -1;
		}
		y = y + speedY;

		repaint();

	}
}
