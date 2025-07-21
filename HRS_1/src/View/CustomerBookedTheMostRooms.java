//author juliana abu shkara 207840216


package View;

import model.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

public class CustomerBookedTheMostRooms extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JPanel Panel1;
	private JLabel lblHomePage;
	private JTable tableBooking;
	private JTable tableCustomer;
	private JScrollPane scrollPane;
	private JLabel lblBooking;

	public CustomerBookedTheMostRooms(String user) {
		hotel = Hotel.getInstance();
		this.setTitle("Customer Booked The Most Rooms");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel1 = new JPanel();
		Panel1.setBackground(SystemColor.activeCaption);
		Panel1.setLayout(null);
		Panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		Panel1.setBounds(0, 0, 906, 425);
		contentPane.add(Panel1);

		// homePage
		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 109, 95);
		lblHomePage.setIcon(hotelIcon);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});
		Panel1.add(lblHomePage);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 886, 85);
		Panel1.add(scrollPane);

		lblBooking = new JLabel("Booking:");
		lblBooking.setForeground(Color.WHITE);
		lblBooking.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBooking.setBounds(20, 185, 82, 37);
		Panel1.add(lblBooking);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 233, 886, 170);
		Panel1.add(scrollPane_1);

		// tables
		String colmnBooking[] = { "Booking Number", "Room Number", "Check In Day", "Number Days", "Total Revenue",
				"Total Cost " };

		String colmnCustomer[] = { "ID", "First Name", "Last Name", "Phone", "Area", "Gender", "Year Of Birth",
				"Date Of Joining", "Discount" };
		DefaultTableModel bookingModel = new DefaultTableModel(colmnBooking, 0);
		DefaultTableModel customerModel = new DefaultTableModel(colmnCustomer, 0);

		tableBooking = new JTable(bookingModel);
		tableCustomer = new JTable(customerModel);

		// scroll
		scrollPane.setViewportView(tableCustomer);
		scrollPane_1.setViewportView(tableBooking);

		Customer customerBookedMostRooms = hotel.customerBookedTheMostRooms();
		if (customerBookedMostRooms != null) {
			customerModel = clearTable(tableCustomer);
			bookingModel = clearTable(tableBooking);
			customerModel.setRowCount(0);
			bookingModel.setRowCount(0);

			if (customerBookedMostRooms instanceof VIPCustomer) {
				VIPCustomer cV = (VIPCustomer) customerBookedMostRooms;
				customerModel.addRow(new Object[] { cV.getId(), cV.getFirstName(), cV.getLastName(),
						cV.getPhoneNumber(), "" + cV.getArea(), "" + cV.getGender(), cV.getYearOfBirth(),
						"" + cV.getDateOfJoining(), cV.getDiscountPercentage() });

			} else {
				customerModel.addRow(new Object[] { customerBookedMostRooms.getId(),
						customerBookedMostRooms.getFirstName(), customerBookedMostRooms.getLastName(),
						customerBookedMostRooms.getPhoneNumber(), "" + customerBookedMostRooms.getArea(),
						"" + customerBookedMostRooms.getGender(), customerBookedMostRooms.getYearOfBirth(),
						"" + customerBookedMostRooms.getDateOfJoining(), 0.0 });

			}

			Set<Booking> bookingC = customerBookedMostRooms.getAllBookings();
			if (bookingC != null) {
				for (Booking b : bookingC) {
					bookingModel.addRow(new Object[] { b.getBookingNumber(), b.getRoomNumber(), "" + b.getCheckInDate(),
							b.getNumberOfDays(), b.getTotalRevenue(), b.getTotalCost() });

				}
			}

		}

	}

	private DefaultTableModel clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// Clear all rows from the model
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		return model;
	}
}
