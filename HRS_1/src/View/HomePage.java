//author juliana abu shkara 207840216


package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Hotel hotel;
	private ImageIcon Background;
	private JLabel Backgroundlbl;
	private JMenuBar menuBar;
	private JMenu mnAdd;
	private JMenu mnRemove;
	private JMenu mnGetReal;
	private JMenu mnFunctions;
	private JMenuItem mntmAddCustomer;
	private JMenuItem mntmAddBooking;
	private JMenuItem mntmAddRoom;
	private JMenuItem mntmAddDepartment;
	private JMenuItem mntmAddEmployee;
	private JMenuItem mntmRemoveCustomer;
	private JMenuItem mntmRemoveBooking;
	private JMenuItem mntmRemoveRoom;
	private JMenuItem mntmRemoveDepartment;
	private JMenuItem mntmRemoveEmployee;
	private JMenuItem mntmGetRealCustomer;
	private JMenuItem mntmGetRealBooking;
	private JMenuItem mntmGetRealRoom;
	private JMenuItem mntmGetRealDepartment;
	private JMenuItem mntmGetEmployee;
	private JMenuItem mntmAllCustomersByPk;
	private JMenuItem mntmAllCustomersCmp;
	private JMenuItem mntmTotalProfit;
	private JMenuItem mntmAllBookingsOfSpecCustomers;
	private JMenuItem mntmCustomerBookedTheMostRooms;
	private JMenuItem mntmKEmployess;
	private JLabel lblHoteIcon;
	private JMenuItem mntmAllBookingByRevenue;
	



	public HomePage(String user) {
		hotel = Hotel.getInstance();

		this.setTitle("Welcome " + user);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setBounds(100, 100, 801, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Background = new ImageIcon(this.getClass().getResource("/hompageBackground.gif"));
		// background lbl
		Backgroundlbl = new JLabel("");
		Backgroundlbl.setBounds(0, 71, 785, 518);
		Backgroundlbl.setIcon(Background);
		contentPane.add(Backgroundlbl);

		// menu bar
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 785, 73);
		contentPane.add(menuBar);

		// hotel icon
		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		lblHoteIcon = new JLabel();
		menuBar.add(lblHoteIcon);
		lblHoteIcon.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.revalidate();

			}
		});
		lblHoteIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoteIcon.setIcon(hotelIcon);

		// menu ADD
		mnAdd = new JMenu("ADD");
		menuBar.add(mnAdd);

		// JMENU Items
		mntmAddCustomer = new JMenuItem("Add Customer");
		mntmAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AddCustomer addCustomerPage = new AddCustomer(user);
				dispose();
				addCustomerPage.setVisible(true);
			}
		});
		mnAdd.add(mntmAddCustomer);

		mntmAddBooking = new JMenuItem("Add Booking");
		mntmAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AddBooking bookingPage = new AddBooking(user);
				dispose();

				bookingPage.setVisible(true);
			}
		});
		mnAdd.add(mntmAddBooking);

		mntmAddRoom = new JMenuItem("Add Room");
		mntmAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AddRoom addRoomPage = new AddRoom(user);
				dispose();

				addRoomPage.setVisible(true);
			}
		});
		mnAdd.add(mntmAddRoom);

		mntmAddDepartment = new JMenuItem("Add Department");
		mntmAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AddDepartment addDepartmentPage = new AddDepartment(user);
				dispose();
				addDepartmentPage.setVisible(true);
			}
		});
		mnAdd.add(mntmAddDepartment);

		mntmAddEmployee = new JMenuItem("Add Employee");
		mntmAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AddEmployee addEmployeePage = new AddEmployee(user);
				dispose();

				addEmployeePage.setVisible(true);
			}
		});

		mnAdd.add(mntmAddEmployee);
		// only visable for admin
		mntmAddEmployee.setVisible(false);
		if (user.equals("admin")) {
			mntmAddEmployee.setVisible(true);
		}

		// menu Remove
		mnRemove = new JMenu("REMOVE");
		menuBar.add(mnRemove);

		// menuItems
		mntmRemoveCustomer = new JMenuItem("Remove Customer");
		mntmRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				RemoveCustomer removeCustomerPage = new RemoveCustomer(user);
				dispose();

				removeCustomerPage.setVisible(true);
			}
		});
		mnRemove.add(mntmRemoveCustomer);

		mntmRemoveBooking = new JMenuItem("Remove Booking");
		mntmRemoveBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				RemoveBooking removeBookingPage = new RemoveBooking(user);
				dispose();

				removeBookingPage.setVisible(true);
			}
		});
		mnRemove.add(mntmRemoveBooking);

		mntmRemoveRoom = new JMenuItem("Remove Room");
		mntmRemoveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				RemoveRoom removeRoomPage = new RemoveRoom(user);
				dispose();

				removeRoomPage.setVisible(true);
			}
		});
		mnRemove.add(mntmRemoveRoom);

		mntmRemoveDepartment = new JMenuItem("Remove Department");
		mntmRemoveDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				RemoveDepartment removeDepartmentPage = new RemoveDepartment(user);
				dispose();

				removeDepartmentPage.setVisible(true);
			}
		});
		mnRemove.add(mntmRemoveDepartment);

		mntmRemoveEmployee = new JMenuItem("Remove Employee");
		mntmRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				RemoveEmployee removeEmployeePage = new RemoveEmployee(user);
				dispose();

				removeEmployeePage.setVisible(true);
			}
		});
		mnRemove.add(mntmRemoveEmployee);

		// only visible for employee
		mntmRemoveEmployee.setVisible(false);
		if (user.equals("admin")) {
			mntmRemoveEmployee.setVisible(true);
		}

		// menu
		mnGetReal = new JMenu("GET REAL");
		menuBar.add(mnGetReal);

		mntmGetRealCustomer = new JMenuItem("Get Customer");
		mntmGetRealCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GetRealCustomer getRealCustomerPage = new GetRealCustomer(user);
				dispose();

				getRealCustomerPage.setVisible(true);
			}
		});
		mnGetReal.add(mntmGetRealCustomer);

		mntmGetRealBooking = new JMenuItem("Get Booking ");
		mntmGetRealBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GetRealBooking getBookingPage = new GetRealBooking(user);
				dispose();

				getBookingPage.setVisible(true);

			}
		});
		mnGetReal.add(mntmGetRealBooking);

		mntmGetRealRoom = new JMenuItem("Get Room");
		mntmGetRealRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GetRealRoom getRealRoomPage = new GetRealRoom(user);
				dispose();

				getRealRoomPage.setVisible(true);
			}
		});
		mnGetReal.add(mntmGetRealRoom);

		mntmGetRealDepartment = new JMenuItem("Get Department");
		mntmGetRealDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GetRealDepartment getRealDepartmentPage = new GetRealDepartment(user);
				dispose();

				getRealDepartmentPage.setVisible(true);
			}
		});
		mnGetReal.add(mntmGetRealDepartment);

		mntmGetEmployee = new JMenuItem("Get Employee");
		mntmGetEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GetRealEmployee getEmployeePage = new GetRealEmployee(user);
				dispose();

				getEmployeePage.setVisible(true);
			}
		});
		mnGetReal.add(mntmGetEmployee);

		// MenuItems for functions
		mnFunctions = new JMenu("FUNCTIONS");
		menuBar.add(mnFunctions);

		mntmAllCustomersByPk = new JMenuItem("All Customers By PK ");
		mntmAllCustomersByPk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AllCustomersByPk getPage = new AllCustomersByPk(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmAllCustomersByPk);

		mntmAllCustomersCmp = new JMenuItem("All Customers Cmp");
		mntmAllCustomersCmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AllCustomerCmp getPage = new AllCustomerCmp(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmAllCustomersCmp);

		mntmTotalProfit = new JMenuItem("Total Profit");
		mntmTotalProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				TotalProfit getPage = new TotalProfit(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmTotalProfit);

		mntmAllBookingsOfSpecCustomers = new JMenuItem("All Bookings Of Spec Customers");
		mntmAllBookingsOfSpecCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AllBookingOfSpecCustomer getPage = new AllBookingOfSpecCustomer(user);
				dispose();

				getPage.setVisible(true);

			}/* CustomerBookedTheMostRooms.java */
		});
		mnFunctions.add(mntmAllBookingsOfSpecCustomers);

		mntmCustomerBookedTheMostRooms = new JMenuItem("Customer Booked The Most Rooms");
		mntmCustomerBookedTheMostRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				CustomerBookedTheMostRooms getPage = new CustomerBookedTheMostRooms(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmCustomerBookedTheMostRooms);

		mntmKEmployess = new JMenuItem("K Employees");
		mntmKEmployess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				KEmployees getPage = new KEmployees(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmKEmployess);

		mntmAllBookingByRevenue = new JMenuItem("All Booking By Revenue");
		mntmAllBookingByRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AllBookingByRevenue getPage = new AllBookingByRevenue(user);
				dispose();

				getPage.setVisible(true);

			}
		});
		mnFunctions.add(mntmAllBookingByRevenue);

		revalidate();

	}
	
	
}
