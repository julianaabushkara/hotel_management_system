//author juliana abu shkara 207840216


package View;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

public class AddCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblHomePage;
	private ImageIcon hotelIcon ;
	private Image newimg;


	public AddCustomer(String user) {
		this.setTitle("ADD CUSTOMER");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 427, 540);
		setResizable(false);

		// customer panal
		CustomerPanel customerPanel = new CustomerPanel(user);
		setContentPane(customerPanel);
		// hotel icon

		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// HOMEPAGE
		lblHomePage = new JLabel();
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 106, 85);
		lblHomePage.setIcon(hotelIcon);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});
		getContentPane().add(lblHomePage);

		setVisible(true);
	}

}
