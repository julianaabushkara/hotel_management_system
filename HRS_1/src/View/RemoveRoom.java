//author juliana abu shkara 207840216


package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;

public class RemoveRoom extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblHomePage;
	private JLabel lblRommID;
	private JButton btnEntr;
	private ImageIcon hotelIcon;

	private ImageIcon Background;
	private JPanel panel;
	private ImageIcon enterButton;
	Hotel hotel;
	private JComboBox<String> typeComboBox;
	SoundPlayer btn;
	private JLabel lblBackground;

	public RemoveRoom(String user) {

		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));
		setResizable(false);

		int i = 0;
		String[] combo = new String[hotel.getAllRooms().values().size()];
		for (Room r : hotel.getAllRooms().values())
			combo[i++] = r.getRoomNumber();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Remove Room");

		setBounds(100, 100, 387, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 353, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		typeComboBox = new JComboBox<String>(combo);
		typeComboBox.setBounds(23, 119, 231, 25);
		panel.add(typeComboBox);

		// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 87, 80);
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

		// RoomID
		lblRommID = new JLabel("Room Id:");
		lblRommID.setForeground(SystemColor.textHighlight);
		lblRommID.setBackground(Color.WHITE);
		lblRommID.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRommID.setBounds(25, 67, 123, 34);
		panel.add(lblRommID);

		// Button
		enterButton = new ImageIcon(this.getClass().getResource("/REMOVEbtn.png"));

		btnEntr = new JButton("New button");
		btnEntr.setIcon(enterButton);
		btnEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				if (hotel.getAllRooms().containsKey(typeComboBox.getSelectedItem().toString())) {
					hotel.getAllRooms().remove(typeComboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Successfully removed Room");
				}
				RemoveRoom r=new RemoveRoom(user);
				dispose();
				r.setVisible(true);
				
			}
			
		});
		btnEntr.setBounds(132, 161, 123, 42);
		panel.add(btnEntr);

		// background
		Background = new ImageIcon(this.getClass().getResource("/Background.jpg"));

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 360, 250);
		lblBackground.setIcon(Background);
		panel.add(lblBackground);
	}

}
