//author juliana abu shkara 207840216


package View;

import exceptions.*;

import model.*;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.FillAllFields;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class GetRealCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panelID;
	private JPanel panelIName;
	private JPanel panelIPhone;
	private JPanel panelArea;
	private JPanel panelGender;
	private JPanel panelDateOfJoining;
	private JPanel panelYearOfBirth;

	private JButton btnSearch;

	Hotel hotel;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblArea;
	private JLabel lblGender;
	private JLabel lblYearOfBirth;
	private JLabel lblDateOfJoining;
	private JLabel lblID_1;
	private JLabel lblName_1;
	private JLabel lblPhone_1;
	private JLabel lblID;
	private JLabel lblArea_1;
	private JLabel lblGender_1;
	private JLabel lblYearOfBirth_1;
	private JLabel lblDateOfJoining_1;
	private JLabel lblPerCentage;
	private JPanel panelDiscount;
	private JLabel lblPerCentage_1;
	private ImageIcon btnSearchImage;
	private JPanel panelSearch;
	private JLabel lblCustomerID;
	private ImageIcon hotelIcon;
	private Image newimg;
	SoundPlayer btn;

	public GetRealCustomer(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Get Customer");

		setResizable(false);

		setBounds(100, 100, 838, 537);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg =hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// TYPE OF ROOM

		// homepage
		JLabel lblHomePage = new JLabel("");
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
		contentPane.add(lblHomePage);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(149, 0, 673, 505);
		contentPane.add(panel);
		panel.setLayout(null);

		// Customer Labels
		lblID = new JLabel("ID:");
		lblID.setBounds(10, 11, 44, 30);
		panel.add(lblID);

		lblName = new JLabel("Name:");
		lblName.setBounds(210, 11, 44, 30);
		panel.add(lblName);

		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 52, 44, 30);
		panel.add(lblPhone);

		lblArea = new JLabel("Area:");
		lblArea.setBounds(10, 93, 44, 30);
		panel.add(lblArea);

		lblGender = new JLabel("Gender:");
		lblGender.setBounds(210, 52, 44, 30);
		panel.add(lblGender);

		lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setBounds(10, 134, 75, 30);
		panel.add(lblYearOfBirth);

		lblDateOfJoining = new JLabel("Date Of Joining:");
		lblDateOfJoining.setBounds(210, 93, 98, 30);
		panel.add(lblDateOfJoining);

		panelID = new JPanel();
		panelID.setBackground(SystemColor.controlShadow);
		panelID.setBounds(47, 11, 149, 30);
		panel.add(panelID);
		panelID.setLayout(null);

		lblID_1 = new JLabel("");
		lblID_1.setBackground(Color.WHITE);
		lblID_1.setBounds(0, 0, 149, 30);
		panelID.add(lblID_1);

		panelIName = new JPanel();
		panelIName.setBackground(SystemColor.controlShadow);
		panelIName.setLayout(null);
		panelIName.setBounds(248, 11, 252, 30);
		panel.add(panelIName);

		lblName_1 = new JLabel("");
		lblName_1.setBounds(0, 0, 252, 30);
		panelIName.add(lblName_1);

		panelIPhone = new JPanel();
		panelIPhone.setLayout(null);
		panelIPhone.setBackground(SystemColor.controlShadow);
		panelIPhone.setBounds(47, 52, 149, 30);
		panel.add(panelIPhone);

		lblPhone_1 = new JLabel("");
		lblPhone_1.setBounds(0, 0, 149, 30);
		panelIPhone.add(lblPhone_1);

		panelArea = new JPanel();
		panelArea.setLayout(null);
		panelArea.setBackground(SystemColor.controlShadow);
		panelArea.setBounds(47, 93, 149, 30);
		panel.add(panelArea);

		lblArea_1 = new JLabel("");
		lblArea_1.setBounds(0, 0, 149, 30);
		panelArea.add(lblArea_1);

		panelGender = new JPanel();
		panelGender.setBackground(SystemColor.controlShadow);
		panelGender.setBounds(264, 52, 180, 30);
		panel.add(panelGender);
		panelGender.setLayout(null);

		lblGender_1 = new JLabel("");
		lblGender_1.setBounds(0, 0, 180, 30);
		panelGender.add(lblGender_1);

		panelYearOfBirth = new JPanel();
		panelYearOfBirth.setBackground(SystemColor.controlShadow);
		panelYearOfBirth.setBounds(82, 134, 149, 30);
		panel.add(panelYearOfBirth);
		panelYearOfBirth.setLayout(null);

		lblYearOfBirth_1 = new JLabel("");
		lblYearOfBirth_1.setBounds(0, 0, 149, 30);
		panelYearOfBirth.add(lblYearOfBirth_1);

		panelDateOfJoining = new JPanel();
		panelDateOfJoining.setBackground(SystemColor.controlShadow);
		panelDateOfJoining.setBounds(318, 93, 182, 30);
		panel.add(panelDateOfJoining);
		panelDateOfJoining.setLayout(null);

		lblDateOfJoining_1 = new JLabel("");
		lblDateOfJoining_1.setBounds(0, 0, 182, 30);
		panelDateOfJoining.add(lblDateOfJoining_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 653, 279);
		panel.add(scrollPane);

		// table
		String col[] = { "Booking Number", "Room Number", "Check In Date", "Numbe rOf Days", "Total Revenue",
				"Total Cost" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		// labels
		lblPerCentage = new JLabel("Discount :");
		lblPerCentage.setBounds(248, 134, 75, 30);
		panel.add(lblPerCentage);

		panelDiscount = new JPanel();
		panelDiscount.setBackground(SystemColor.controlShadow);
		panelDiscount.setBounds(333, 134, 180, 30);
		panel.add(panelDiscount);
		panelDiscount.setLayout(null);

		lblPerCentage_1 = new JLabel("");
		lblPerCentage_1.setBounds(0, 0, 180, 30);
		panelDiscount.add(lblPerCentage_1);

		lblPerCentage_1.setText("");

		// search button
		btnSearchImage = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnSearch = new JButton("New button");
		btnSearch.setIcon(btnSearchImage);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textField.getText().isEmpty()) {
						if (hotel.getAllCustomers().containsKey(textField.getText())) {
							Customer customer = hotel.getAllCustomers().get(textField.getText());
							lblID_1.setText(customer.getId());
							lblName_1.setText(customer.getFirstName() + " " + customer.getLastName());
							lblPhone_1.setText(customer.getPhoneNumber());
							lblArea_1.setText("" + customer.getArea());
							lblGender_1.setText("" + customer.getGender());
							lblYearOfBirth_1.setText("" + customer.getYearOfBirth());
							lblDateOfJoining_1.setText("" + customer.getDateOfJoining());

							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model = clearTable(table);

							Set<Booking> allBC = customer.getAllBookings();
							if (!allBC.isEmpty())
								for (Booking b : allBC)
									model.addRow(new Object[] { b.getBookingNumber(), b.getRoomNumber(),
											"" + b.getCheckInDate(), b.getNumberOfDays(), b.getTotalRevenue(),
											b.getTotalCost() });

							if (customer instanceof VIPCustomer) {
								VIPCustomer vipcustomer = (VIPCustomer) customer;
								lblPerCentage_1.setText("" + vipcustomer.getDiscountPercentage());
							} else
								lblPerCentage_1.setText("");

						} else
							throw new ObjectDoesNotExist("Customer");

					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill The Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Customer Doesn't EXSITS", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}

			}
		});

		btnSearch.setBounds(10, 379, 129, 49);
		contentPane.add(btnSearch);

		// panel search
		panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBounds(10, 98, 135, 128);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);

		// customer Id label
		lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setBounds(10, 23, 96, 40);
		panelSearch.add(lblCustomerID);
		lblCustomerID.setForeground(Color.WHITE);
		lblCustomerID.setFont(new Font("Times New Roman", Font.BOLD, 14));

		// text field
		textField = new JTextField();
		textField.setBounds(10, 60, 115, 20);
		panelSearch.add(textField);
		textField.setColumns(10);
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
