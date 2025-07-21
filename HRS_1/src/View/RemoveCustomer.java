//author juliana abu shkara 207840216

package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RemoveCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblHomePage;
	private JLabel lblCustomerId;
	private JPanel panel;
	private ImageIcon hotelIcon;
	private ImageIcon enterButtonIcon;
	private Image newimg;
	private ImageIcon background;
	Hotel hotel;
	SoundPlayer btn;
	private JLabel lblBackground;

	public RemoveCustomer(String user) {
		hotel = Hotel.getInstance();

		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Remove Customer");
		
		setResizable(false);


		setBounds(100, 100, 357, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// background
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 321, 279);
		contentPane.add(panel);
		panel.setLayout(null);

		// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// HomePage Lebal

		lblHomePage = new JLabel("New label");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 107, 72);
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

		// CustomerId
		lblCustomerId = new JLabel("Customer Id:");
		lblCustomerId.setForeground(SystemColor.textHighlight);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCustomerId.setBounds(25, 104, 100, 33);
		panel.add(lblCustomerId);

		// text field
		textField = new JTextField();
		textField.setBounds(25, 140, 238, 20);
		panel.add(textField);
		textField.setColumns(10);

		// Enter button
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textField.getText().isEmpty()) {
						if (hotel.getAllCustomers().containsKey(textField.getText())) {
							if (checkIsCustomerVip()) {
								boolean success = hotel
										.removeVIPCustomer(hotel.getRealVIPCustomer(textField.getText()));
								if (success)
									JOptionPane.showMessageDialog(null, "Successfully removed VIP Customer");
								else
									JOptionPane.showMessageDialog(null, "Failed to remove VIP Customer", "ERROR",
											JOptionPane.ERROR_MESSAGE);

							} else {
								boolean success = hotel.removeCustomer(hotel.getRealCustomer(textField.getText()));
								if (success)
									JOptionPane.showMessageDialog(null, "Successfully removed Customer");
								else
									JOptionPane.showMessageDialog(null, "Failed to remove Customer", "ERROR",
											JOptionPane.ERROR_MESSAGE);
							}

						} else
							throw new ObjectDoesNotExist("Customer");

					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "please Fill All Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Customer Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				}
			}
		});

		enterButtonIcon = new ImageIcon(this.getClass().getResource("/REMOVEbtn.png"));
		btnNewButton.setIcon(enterButtonIcon);
		btnNewButton.setBounds(146, 220, 117, 48);
		panel.add(btnNewButton);

		// background

		background = new ImageIcon(this.getClass().getResource("/Background.jpg"));
		lblBackground = new JLabel("New label");
		lblBackground.setBounds(0, 0, 331, 290);
		lblBackground.setIcon(background);
		panel.add(lblBackground);
	}

	public Boolean checkIsCustomerVip() {
		Customer customer = hotel.getAllCustomers().get(textField.getText());
		if (customer instanceof VIPCustomer)
			return true;
		return false;
	}

}
