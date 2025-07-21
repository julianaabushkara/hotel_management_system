//author juliana abu shkara 207840216


package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveBooking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBookingId;
	private JLabel lblBookingId;
	private JLabel lblHomePage;
	private JLabel lblBackground;

	private JPanel panel;
	private JButton btnEntr;
	private ImageIcon hotelIcon;
	private ImageIcon entrBtn;
	private Image newimg;
	private ImageIcon background;
	Hotel hotel;
	SoundPlayer btn;

	public RemoveBooking(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Remove Booking");
		setResizable(false);

		setBounds(100, 100, 311, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 275, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		// hotel Icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel(" ");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 84, 72);
		lblHomePage.setIcon(hotelIcon);

		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				dispose();
				homePage.setVisible(true);

			}
		});

		panel.add(lblHomePage);

		// lebal booking id
		lblBookingId = new JLabel("Booking Id:");
		lblBookingId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblBookingId.setForeground(SystemColor.textHighlight);
		lblBookingId.setBounds(24, 83, 96, 32);
		panel.add(lblBookingId);

		// text booking id
		textFieldBookingId = new JTextField();
		textFieldBookingId.setBounds(25, 119, 199, 20);
		panel.add(textFieldBookingId);
		textFieldBookingId.setColumns(10);

		// enter button
		entrBtn = new ImageIcon(this.getClass().getResource("/REMOVEbtn.png"));

		btnEntr = new JButton("New button");
		btnEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textFieldBookingId.getText().isEmpty()) {
						if (hotel.getAllBookings().containsKey(textFieldBookingId.getText())) {

							boolean success = hotel.removeBooking(hotel.getRealBooking(textFieldBookingId.getText()));

							if (success) {
								JOptionPane.showMessageDialog(null, "Successfully removed Booking");
							} else
								JOptionPane.showMessageDialog(null, "Failed to remove Booking", "ERROR",
										JOptionPane.ERROR_MESSAGE);
						} else {
							throw new ObjectDoesNotExist("Booking");
						}
					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill all Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Booking Does Not EXSITS", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				}

			}
		});
		btnEntr.setBounds(106, 163, 118, 51);
		btnEntr.setIcon(entrBtn);
		panel.add(btnEntr);

		// background
		background = new ImageIcon(this.getClass().getResource("/Background.jpg"));

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 275, 239);
		lblBackground.setIcon(background);
		panel.add(lblBackground);
	}
}
