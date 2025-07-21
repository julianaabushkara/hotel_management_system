package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import exceptions.FillAllFields;
import exceptions.NumberShouldBePositive;
import exceptions.ObjectDoesNotExist;
import exceptions.WrongDate;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Date;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class AddBooking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRoomNum;
	private JTextField textFieldNumberOfDays;
	private JLabel lblimageicon;
	private JLabel lblNumberOfDays;
	private JLabel lblCheckInDate;
	private JLabel lbroomNumber;
	private JPanel panel;
	private JLabel lblCustomerId;
	private JTextField textFieldCUSTOMERID;
	private JButton btnSearch;
	private JButton btnNewCustomer;
	private JDateChooser chooserCheckInDate;
	private ImageIcon bookingBackground;

	SoundPlayer btn;
	private JComboBox<String> typeComboBox;
	Hotel hotel;
	private JButton btnBOOK;
	private ImageIcon hotelIcon;
	private Image newimg;
	private JLabel lblFoundCustomer;
	private final int W = 785;
	private final int H = 516;
	private final int x = 100;
	private final int y = 100;
	private JLabel lblHomePage;

	public AddBooking(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setResizable(false);

		this.setTitle("ADD BOOKING");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(x, y, W, H);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// PANEL
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 250, 455);
		contentPane.add(panel);
		panel.setLayout(null);

		// PANEL 1
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(259, 11, 503, 455);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// home page
		//// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 106, 85);
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

		// type of room
		String[] combo = { "StandardRoom", "SuperiorRoom", "Suite" };
		typeComboBox = new JComboBox<String>(combo);
		typeComboBox.setBounds(147, 106, 107, 20);
		panel_1.add(typeComboBox);

		// check in date
		chooserCheckInDate = new JDateChooser();
		chooserCheckInDate.setBounds(147, 143, 164, 20);
		panel_1.add(chooserCheckInDate);

		// LBL ROOM NUMBER
		lbroomNumber = new JLabel("Room Number:");
		lbroomNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbroomNumber.setBounds(37, 99, 121, 33);
		panel_1.add(lbroomNumber);

		// TEXT ROOM NUMBER
		textFieldRoomNum = new JTextField();
		textFieldRoomNum.setBounds(264, 106, 53, 20);
		panel_1.add(textFieldRoomNum);
		textFieldRoomNum.setColumns(10);

		// check in days
		lblCheckInDate = new JLabel("check in date:");
		lblCheckInDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCheckInDate.setBounds(37, 136, 121, 33);
		panel_1.add(lblCheckInDate);

		// lbl numberof days

		lblNumberOfDays = new JLabel("number of days:");
		lblNumberOfDays.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNumberOfDays.setBounds(37, 173, 121, 33);
		panel_1.add(lblNumberOfDays);

		// text number of days
		textFieldNumberOfDays = new JTextField();
		textFieldNumberOfDays.setColumns(10);
		textFieldNumberOfDays.setBounds(147, 180, 164, 20);
		panel_1.add(textFieldNumberOfDays);
		bookingBackground = new ImageIcon(this.getClass().getResource("/booking.jpg"));

		// background
		lblimageicon = new JLabel("");
		lblimageicon.setBounds(0, 0, 575, 455);
		panel_1.add(lblimageicon);
		lblimageicon.setIcon(bookingBackground);

		// customer id search
		lblCustomerId = new JLabel("Customer Id:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerId.setBounds(13, 191, 93, 23);
		panel.add(lblCustomerId);

		// SearchButton
		btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon(this.getClass().getResource("/SearchBtn.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				String customerId = textFieldCUSTOMERID.getText();
				Customer customer = hotel.getRealCustomer(customerId);
				VIPCustomer Vipcustomer = hotel.getRealVIPCustomer(customerId);
				if (Vipcustomer == null && customer == null)
					JOptionPane.showMessageDialog(null, "Customer Does Not EXSITS", "ERROR", JOptionPane.ERROR_MESSAGE);
				else {
					lblFoundCustomer.setVisible(true);
					revalidate();
				}

			}
		});
		btnSearch.setBounds(126, 218, 114, 25);
		panel.add(btnSearch);

		textFieldCUSTOMERID = new JTextField();
		textFieldCUSTOMERID.setColumns(10);
		textFieldCUSTOMERID.setBounds(10, 218, 154, 25);
		panel.add(textFieldCUSTOMERID);

		// btn new customer
		btnNewCustomer = new JButton();
		btnNewCustomer.setIcon(new ImageIcon(this.getClass().getResource("/newCustomer.png")));
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer newCustomer = new AddCustomer(user);
				newCustomer.setVisible(true);
			}
		});
		btnNewCustomer.setBounds(10, 302, 175, 40);
		panel.add(btnNewCustomer);

		// Book button
		btnBOOK = new JButton("BOOK ROOM");
		btnBOOK.setIcon(new ImageIcon(this.getClass().getResource("/BookNowBtn.png")));

		btnBOOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {

					if (areAllFieldsFilled()) {
						if (doesRoomNumberExsit()) {
							if (checkCheckInDate()) {
								if (checkNumberOfDays()) {
									if (hotel.getAllCustomers().containsKey(textFieldCUSTOMERID.getText())) {
										String roomNum = textFieldRoomNum.getText();
										Booking booking = new Booking(
												((String) typeComboBox.getSelectedItem()) + roomNum,
												hotel.getAllCustomers().get(textFieldCUSTOMERID.getText()),
												(Date) chooserCheckInDate.getDate(),
												Integer.parseInt(textFieldNumberOfDays.getText()));

										Boolean success = hotel.addBooking(booking);

										if (success)
											JOptionPane.showMessageDialog(null, "Successfully Booked room");
										else
											JOptionPane.showMessageDialog(null, "failed to Book a room", "ERROR",
													JOptionPane.ERROR_MESSAGE);

									} else {
										JOptionPane.showMessageDialog(null, "Customer Does NOT Exist", "ERROR",
												JOptionPane.ERROR_MESSAGE);
										throw new ObjectDoesNotExist("Customer");

									}

								} else
									throw new NumberShouldBePositive("Number Of Days");
							} else
								throw new WrongDate();

						} else {
							JOptionPane.showMessageDialog(null, "Room Number Does NOT Exist", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							throw new ObjectDoesNotExist("Room");

						}
					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "All Fields Must be Filled", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					System.err.println(ex);

				} catch (WrongDate ex) {
					JOptionPane.showMessageDialog(null, "Check In Date should after today", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (NumberShouldBePositive ex) {
					JOptionPane.showMessageDialog(null, "Number Of Days should be positive", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				}
			}
		});
		btnBOOK.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBOOK.setBounds(10, 404, 161, 40);
		panel.add(btnBOOK);

		// found customer
		lblFoundCustomer = new JLabel("FOUND CUSTOMER");
		lblFoundCustomer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblFoundCustomer.setForeground(new Color(68, 200, 134));
		lblFoundCustomer.setBounds(13, 254, 137, 23);
		panel.add(lblFoundCustomer);
		lblFoundCustomer.setVisible(false);

	}

	// Number Of Days

	public Boolean checkNumberOfDays() {
		int NumberOfDays = Integer.parseInt(textFieldNumberOfDays.getText());
		return NumberOfDays > 0;
	}

	// check in day
	public Date getCheckInDate() {
		return (Date) chooserCheckInDate.getDate();
	}

	// returns true if the check in day equals or bigger than today else false
	public Boolean checkCheckInDate() {
		Date checkInDate = getCheckInDate();
		Date currentDate = new Date();
		if (checkInDate.after(currentDate) || checkInDate.equals(currentDate))
			return true;
		return false;
	}

	// checks if the room exsits
	public Boolean doesRoomNumberExsit() {
		String roomNumber = typeComboBox.getSelectedItem().toString() + textFieldRoomNum.getText();
		if (hotel.getAllRooms().containsKey(roomNumber))
			return true;
		return false;
	}

	public Customer getCustomer() {
		String customerId = textFieldCUSTOMERID.getText();
		Customer customer = hotel.getRealCustomer(customerId);
		VIPCustomer Vipcustomer = hotel.getRealVIPCustomer(customerId);
		if (customer != null)
			return customer;
		if (Vipcustomer != null)
			return Vipcustomer;
		return null;
	}

	// checks if all Fields are entered
	public Boolean areAllFieldsFilled() {
		Boolean fieldsFilled = false;
		Date chosenDate = chooserCheckInDate.getDate();

		if (chosenDate == null)
			return false;

		fieldsFilled = !textFieldRoomNum.getText().isEmpty() && !textFieldCUSTOMERID.getText().isEmpty()
				&& !textFieldNumberOfDays.getText().isEmpty() && !chooserCheckInDate.getDate().equals(null);

		return fieldsFilled;
	}

}
