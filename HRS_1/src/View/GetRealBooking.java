//author juliana abu shkara 207840216


package View;

import exceptions.*;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;

public class GetRealBooking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AninamationOfBookNow aninamationOfBookNow;
	private Image image;
	private Image newimg;
	private ImageIcon hotelIcon;
	private ImageIcon enterButtonIcon;
	private JPanel panelInfo;
	private JPanel panel;
	private JLabel lblHomePage;
	private JLabel labelGetBooking;
	private JButton btnEnter;
	private JPanel panelSearch;
	private JTextField textField;
	private JLabel lblBookingNum;
	private JLabel lblRoomNumber;
	private JLabel lblCustomerId;
	private JLabel lblNumberOfDays;
	private JLabel lblCheckInDate;
	private JLabel lblTotalRevenue;
	Hotel hotel;
	private JPanel panelBookingId;
	private JPanel panelRoomNumber;
	private JPanel panelNumberOfDays;
	private JPanel panelCheckInDate;
	private JLabel lblphone;
	private JLabel lblArea;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblDate;
	private JPanel panelDateOfJoining;
	private JPanel panelGender;
	private JPanel panelArea;
	private JPanel panelPhone;
	private JPanel panelName;
	private JLabel lblBookingNumR;
	private JLabel lblRoomNumberR;
	private JLabel lblNumberOfDaysR;
	private JLabel lblCheckInDateR;
	private JLabel lblName_1;
	private JLabel lblphone_1;
	private JLabel lblArea_1;
	private JLabel lblGender_1;
	private JPanel panelPer;
	private JLabel lblPer;
	private JLabel lblPer_1;
	private JLabel lblTotalCost;
	private JPanel panelRevenue;
	private JLabel lblTotalRevenueR;
	private JPanel panelTotalCost;
	private JLabel lblTotalCostR;
	private JPanel panelId;
	private JLabel lblCustomerIdR;
	private JLabel lblDate_1;
	SoundPlayer btn;

	public GetRealBooking(String user) {
		hotel = Hotel.getInstance();

		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		aninamationOfBookNow = new AninamationOfBookNow();
		aninamationOfBookNow.setLocation(0, 375);
		aninamationOfBookNow.setSize(862, 206);
		setResizable(false);
		this.setTitle("Get Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 875, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(aninamationOfBookNow);
		aninamationOfBookNow.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 173, 374);
		contentPane.add(panel);
		panel.setLayout(null);

		// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		image = hotelIcon.getImage();
		newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);


		// homepage
		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 84, 75);
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

		// enter button

		enterButtonIcon = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnEnter = new JButton("New button");
		btnEnter.setIcon(enterButtonIcon);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textField.getText().isEmpty()) {
						String bookingId = textField.getText();
						if (hotel.getAllBookings().containsKey(bookingId)) {

							Booking booking = hotel.getRealBooking(bookingId);
							fillTheInfo(booking);

						}

						else
							throw new ObjectDoesNotExist("Booking");

					} else {
						throw new FillAllFields();
					}
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill either the Booking Number or any other Field ",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "The Booking Does Not Exist ", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				}
			}

		});
		btnEnter.setIcon(new ImageIcon(this.getClass().getResource("/EnterBtn.png")));

		btnEnter.setBounds(22, 321, 128, 48);
		panel.add(btnEnter);

		panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBounds(10, 75, 152, 94);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		// booking id
		labelGetBooking = new JLabel("Booking Id:");
		labelGetBooking.setForeground(Color.WHITE);
		labelGetBooking.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelGetBooking.setBounds(10, 11, 122, 29);
		panelSearch.add(labelGetBooking);

		// text field
		textField = new JTextField();
		textField.setBounds(10, 51, 132, 20);
		panelSearch.add(textField);
		textField.setColumns(10);

		panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaptionBorder);
		panelInfo.setBounds(166, 0, 696, 374);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		// booking number label
		lblBookingNum = new JLabel("Booking Id:");
		lblBookingNum.setForeground(Color.WHITE);
		lblBookingNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBookingNum.setBounds(25, 31, 85, 27);
		panelInfo.add(lblBookingNum);

		// label room number
		lblRoomNumber = new JLabel("Room Number :");
		lblRoomNumber.setForeground(Color.WHITE);
		lblRoomNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomNumber.setBounds(25, 89, 104, 27);
		panelInfo.add(lblRoomNumber);

		// customer Id
		lblCustomerId = new JLabel("Customer Id:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerId.setBounds(25, 325, 85, 27);
		panelInfo.add(lblCustomerId);

		// label number of days
		lblNumberOfDays = new JLabel("Number Of Days :");
		lblNumberOfDays.setForeground(Color.WHITE);
		lblNumberOfDays.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNumberOfDays.setBounds(25, 146, 117, 27);
		panelInfo.add(lblNumberOfDays);

		// label check in date
		lblCheckInDate = new JLabel("Check In Date :");
		lblCheckInDate.setForeground(Color.WHITE);
		lblCheckInDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCheckInDate.setBounds(25, 202, 117, 27);
		panelInfo.add(lblCheckInDate);

		// total revenue label
		lblTotalRevenue = new JLabel("Total Revenue :");
		lblTotalRevenue.setForeground(Color.WHITE);
		lblTotalRevenue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalRevenue.setBounds(25, 253, 117, 27);
		panelInfo.add(lblTotalRevenue);

		// booking id panel
		panelBookingId = new JPanel();
		panelBookingId.setBackground(SystemColor.controlShadow);
		panelBookingId.setBounds(141, 31, 150, 27);
		panelInfo.add(panelBookingId);
		panelBookingId.setLayout(null);

		// booking number label resault
		lblBookingNumR = new JLabel("");
		lblBookingNumR.setForeground(Color.WHITE);
		lblBookingNumR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBookingNumR.setBounds(0, 0, 150, 27);
		panelBookingId.add(lblBookingNumR);

		// panel room number
		panelRoomNumber = new JPanel();
		panelRoomNumber.setLayout(null);
		panelRoomNumber.setBackground(SystemColor.controlShadow);
		panelRoomNumber.setBounds(141, 89, 150, 27);
		panelInfo.add(panelRoomNumber);

		// room number result
		lblRoomNumberR = new JLabel("");
		lblRoomNumberR.setForeground(Color.WHITE);
		lblRoomNumberR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomNumberR.setBounds(0, 0, 150, 27);
		panelRoomNumber.add(lblRoomNumberR);

		// panel number of days
		panelNumberOfDays = new JPanel();
		panelNumberOfDays.setLayout(null);
		panelNumberOfDays.setBackground(SystemColor.controlShadow);
		panelNumberOfDays.setBounds(141, 146, 150, 27);
		panelInfo.add(panelNumberOfDays);

		// number of days R
		lblNumberOfDaysR = new JLabel("");
		lblNumberOfDaysR.setForeground(Color.WHITE);
		lblNumberOfDaysR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNumberOfDaysR.setBounds(0, 0, 150, 27);
		panelNumberOfDays.add(lblNumberOfDaysR);

		// panel check in date
		panelCheckInDate = new JPanel();
		panelCheckInDate.setLayout(null);
		panelCheckInDate.setBackground(SystemColor.controlShadow);
		panelCheckInDate.setBounds(141, 202, 150, 27);
		panelInfo.add(panelCheckInDate);

		// label check in date result
		lblCheckInDateR = new JLabel("");
		lblCheckInDateR.setForeground(Color.WHITE);
		lblCheckInDateR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCheckInDateR.setBounds(0, 0, 150, 27);
		panelCheckInDate.add(lblCheckInDateR);

		// phone label
		lblphone = new JLabel("Phone:");
		lblphone.setForeground(Color.WHITE);
		lblphone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblphone.setBounds(364, 89, 55, 27);
		panelInfo.add(lblphone);

		// area label
		lblArea = new JLabel("Area:");
		lblArea.setForeground(Color.WHITE);
		lblArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblArea.setBounds(364, 146, 55, 27);
		panelInfo.add(lblArea);

		// name label
		lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(364, 31, 55, 27);
		panelInfo.add(lblName);

		// gender label
		lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGender.setBounds(364, 202, 55, 27);
		panelInfo.add(lblGender);

		// label date of joining
		lblDate = new JLabel("Date Of Joining:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(316, 260, 103, 27);
		panelInfo.add(lblDate);

		// panel of date of joining
		panelDateOfJoining = new JPanel();
		panelDateOfJoining.setLayout(null);
		panelDateOfJoining.setBackground(SystemColor.controlShadow);
		panelDateOfJoining.setBounds(430, 260, 256, 27);
		panelInfo.add(panelDateOfJoining);

		// panel of lbl Date result
		lblDate_1 = new JLabel("");
		lblDate_1.setForeground(Color.WHITE);
		lblDate_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate_1.setBounds(0, 0, 256, 27);
		panelDateOfJoining.add(lblDate_1);

		// gender panel
		panelGender = new JPanel();
		panelGender.setLayout(null);
		panelGender.setBackground(SystemColor.controlShadow);
		panelGender.setBounds(430, 202, 256, 27);
		panelInfo.add(panelGender);

		// Result gender label
		lblGender_1 = new JLabel("");
		lblGender_1.setForeground(Color.WHITE);
		lblGender_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGender_1.setBounds(0, 0, 256, 27);
		panelGender.add(lblGender_1);

		// area panel
		panelArea = new JPanel();
		panelArea.setLayout(null);
		panelArea.setBackground(SystemColor.controlShadow);
		panelArea.setBounds(430, 146, 256, 27);
		panelInfo.add(panelArea);

		// label area result
		lblArea_1 = new JLabel("");
		lblArea_1.setForeground(Color.WHITE);
		lblArea_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblArea_1.setBounds(0, 0, 256, 27);
		panelArea.add(lblArea_1);

		// panel phone
		panelPhone = new JPanel();
		panelPhone.setLayout(null);
		panelPhone.setBackground(SystemColor.controlShadow);
		panelPhone.setBounds(430, 89, 256, 27);
		panelInfo.add(panelPhone);

		// label phone area
		lblphone_1 = new JLabel("");
		lblphone_1.setForeground(Color.WHITE);
		lblphone_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblphone_1.setBounds(0, 0, 256, 27);
		panelPhone.add(lblphone_1);

		// panel name
		panelName = new JPanel();
		panelName.setLayout(null);
		panelName.setBackground(SystemColor.controlShadow);
		panelName.setBounds(430, 31, 256, 27);
		panelInfo.add(panelName);

		// label name result
		lblName_1 = new JLabel("");
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName_1.setBounds(0, 0, 256, 27);
		panelName.add(lblName_1);

		// panelPer
		panelPer = new JPanel();
		panelPer.setLayout(null);
		panelPer.setBackground(SystemColor.controlShadow);
		panelPer.setBounds(430, 313, 256, 27);
		panelInfo.add(panelPer);

		// label Per result
		lblPer_1 = new JLabel("");
		lblPer_1.setForeground(Color.WHITE);
		lblPer_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPer_1.setBounds(0, 0, 256, 27);
		panelPer.add(lblPer_1);

		// label per
		lblPer = new JLabel("discount Percentage:");
		lblPer.setForeground(Color.WHITE);
		lblPer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPer.setBounds(301, 313, 128, 27);
		panelInfo.add(lblPer);

		// label total cost
		lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setForeground(Color.WHITE);
		lblTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalCost.setBounds(25, 287, 85, 27);
		panelInfo.add(lblTotalCost);

		// panel revenue
		panelRevenue = new JPanel();
		panelRevenue.setLayout(null);
		panelRevenue.setBackground(SystemColor.controlShadow);
		panelRevenue.setBounds(141, 253, 150, 27);
		panelInfo.add(panelRevenue);

		// label total revenue
		lblTotalRevenueR = new JLabel("");
		lblTotalRevenueR.setForeground(Color.WHITE);
		lblTotalRevenueR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalRevenueR.setBounds(0, 0, 150, 27);
		panelRevenue.add(lblTotalRevenueR);

		// panel total cost
		panelTotalCost = new JPanel();
		panelTotalCost.setLayout(null);
		panelTotalCost.setBackground(SystemColor.controlShadow);
		panelTotalCost.setBounds(141, 287, 150, 27);
		panelInfo.add(panelTotalCost);

		// label total cost
		lblTotalCostR = new JLabel("");
		lblTotalCostR.setForeground(Color.WHITE);
		lblTotalCostR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalCostR.setBounds(0, 0, 150, 27);
		panelTotalCost.add(lblTotalCostR);

		// panel id
		panelId = new JPanel();
		panelId.setLayout(null);
		panelId.setBackground(SystemColor.controlShadow);
		panelId.setBounds(141, 325, 150, 27);
		panelInfo.add(panelId);

		// label customer id
		lblCustomerIdR = new JLabel("");
		lblCustomerIdR.setForeground(Color.WHITE);
		lblCustomerIdR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerIdR.setBounds(0, 0, 150, 27);
		panelId.add(lblCustomerIdR);

		panelPer.setVisible(false);
		lblPer.setVisible(false);
	}

	public void fillTheInfo(Booking booking) {

		Customer customer = booking.getCustomer();

		lblBookingNumR.setText(booking.getBookingNumber());
		lblRoomNumberR.setText(booking.getRoomNumber());
		lblNumberOfDaysR.setText("" + booking.getNumberOfDays());
		lblCheckInDateR.setText("" + booking.getCheckInDate());
		lblTotalRevenueR.setText("" + booking.getTotalRevenue());
		lblTotalCostR.setText("" + booking.getTotalCost());
		lblCustomerIdR.setText(customer.getId());
		lblName_1.setText(customer.getFirstName() + " " + customer.getLastName());
		lblphone_1.setText(customer.getPhoneNumber());
		lblArea_1.setText("" + customer.getArea());
		lblGender_1.setText("" + customer.getGender());
		lblDate_1.setText("" + customer.getDateOfJoining());
		if (customer instanceof VIPCustomer) {
			VIPCustomer vipCustomer = (VIPCustomer) customer;
			panelPer.setVisible(true);
			lblPer.setVisible(true);
			lblPer_1.setText("" + vipCustomer.getDiscountPercentage());
		}else 
		{
			panelPer.setVisible(false);
			lblPer.setVisible(false);
			lblPer_1.setText("");
		}

			

	}

}
