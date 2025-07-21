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

public class Clouds extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int w =1000;
	private final int h =200;

	private ImageIcon cloudIcon;
	private ImageIcon cloudBackground;

	private Image cloud1;
	private Image cloud2;
	private Image background;
	
	private Timer timer;
	private int speedCloud1=5;
	private int speedCloud2=5;

	private int x=0;
	private int y=0;
	private int z=w;
	private int v=50;

	public Clouds() {
		
		this.setPreferredSize(new Dimension(w,h));
		
		cloudIcon = new ImageIcon(this.getClass().getResource("/clouds1.png"));
		cloud1 = cloudIcon.getImage().getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH); 
		cloud2 = cloudIcon.getImage().getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
		cloudBackground=new ImageIcon(this.getClass().getResource("/cloudBackground.jpg"));
		background=cloudBackground.getImage().getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH);
		timer=new Timer(50,this);
		timer.start();
	}
	
	public void paint(Graphics clouds)
	{
		super.paint(clouds);
		Graphics2D cloud=(Graphics2D)clouds;

		cloud.drawImage(background, 0, 0, null);
		cloud.drawImage(cloud1, x, y, null);
		cloud.drawImage(cloud2, z-cloud2.getWidth(null), v, null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if((x>=w-cloud1.getWidth(null))||(x<0))
		{
			speedCloud1=speedCloud1*-1;
		}
		
		x=x+speedCloud1;
	
		z=z-speedCloud2;
        if((z+(0-cloud1.getWidth(null))<0)||(z>w))
        {
        	speedCloud2=speedCloud2*-1;
        }
		repaint();
		
		
		
	}

}
