//author juliana abu shkara 207840216


package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import exceptions.DiscountPercentageNotValid;
import exceptions.FillAllFields;
import exceptions.WrongDate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import model.*;
import utils.Area;
import utils.Gender;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CustomerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> yes_No_comboBox;
	private JComboBox<Gender> comboBoxGender;
	private JComboBox<Area> comboBoxArea;
	private JTextField TextFID;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhone;
	private JTextField textFieldYearOfBirth;
	private JTextField textFieldDiscountPer;
	private JLabel lblDiscount_Percentage;
	private JDateChooser chooserDateOfJoining;
	private JLabel lblid;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPhone;
	private JLabel lblYearOfBirth;
	private JLabel lblDateOfJoining;
	private JLabel lblGender;
	private JLabel lblArea;
	private JLabel lblVIPcustomer;
	private JLabel lblCustomer;
	private JButton btnEntr;
	SoundPlayer btn;

	Hotel hotel;
	/**
	 * Create the panel.
	 */
	public CustomerPanel(String user) {
		setBackground(SystemColor.activeCaption);
		hotel = Hotel.getInstance();
		btn=new SoundPlayer(this.getClass().getResource("/click.wav"));

		setBounds(0, 0, 785, 518);

		//combo box and button enter
		String[] combo = { "No", "Yes" };
		yes_No_comboBox = new JComboBox<String>(combo);
		yes_No_comboBox.setBounds(169, 340, 200, 23);
		comboBoxGender = new JComboBox<Gender>(Gender.values());
		comboBoxGender.setBounds(169, 280, 200, 23);
		comboBoxArea = new JComboBox<Area>(Area.values());
		comboBoxArea.setBounds(169, 310, 200, 23);
		btnEntr = new JButton("Enter");

		//text fields
		textFieldYearOfBirth = new JTextField();
		textFieldYearOfBirth.setBounds(169, 220, 200, 23);
		TextFID = new JTextField();
		TextFID.setBounds(169, 100, 200, 20);
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(169, 130, 200, 20);
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(169, 160, 200, 20);
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(169, 190, 200, 20);
		chooserDateOfJoining = new JDateChooser();
		chooserDateOfJoining.setBounds(169, 250, 200, 20);

		setLayout(null);

		// labels
		lblCustomer = new JLabel("CUSTOMER INFO");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblCustomer.setForeground(new Color(255, 255, 255));
		lblCustomer.setBounds(168, 42, 225, 23);
		add(lblCustomer);

		// ID
		lblid = new JLabel("ID :");
		lblid.setHorizontalAlignment(SwingConstants.LEFT);
		lblid.setForeground(Color.WHITE);
		lblid.setBackground(SystemColor.activeCaption);
		lblid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblid.setBounds(30, 100, 129, 20);
		add(lblid);
		add(TextFID);

		// FIRST NAME
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(30, 130, 139, 20);
		add(lblFirstName);
		add(textFieldFirstName);

		// LAST NAME
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(28, 160, 141, 20);
		add(lblLastName);
		add(textFieldLastName);

		// PHONE
		lblPhone = new JLabel("Phone Number:");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhone.setBounds(30, 190, 139, 20);
		add(lblPhone);
		add(textFieldPhone);

		// YEAR OF BIRTH
		lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYearOfBirth.setForeground(new Color(255, 255, 255));
		lblYearOfBirth.setBounds(30, 220, 139, 20);
		add(lblYearOfBirth);
		add(textFieldYearOfBirth);

		// DATE OF JOINING
		lblDateOfJoining = new JLabel("Date Of Joining:");
		lblDateOfJoining.setForeground(Color.WHITE);
		lblDateOfJoining.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDateOfJoining.setBounds(30, 250, 139, 20);
		add(lblDateOfJoining);
		add(chooserDateOfJoining);

		// GENDER
		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(30, 280, 141, 20);
		add(lblGender);
		add(comboBoxGender);

		// AREA
		lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblArea.setForeground(Color.WHITE);
		lblArea.setBounds(30, 310, 139, 20);
		add(lblArea);
		add(comboBoxArea);

		// IS VIP CUSTOMER
		lblVIPcustomer = new JLabel("Is VIP Customer?");
		lblVIPcustomer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVIPcustomer.setForeground(Color.WHITE);
		lblVIPcustomer.setBounds(30, 340, 139, 20);
		add(lblVIPcustomer);
		add(yes_No_comboBox);

		// Enter buttn
		btnEntr.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnEntr.setBounds(133, 424, 120, 50);
		add(btnEntr);

		/// textFieldDiscountPer
		textFieldDiscountPer = new JTextField();
		textFieldDiscountPer.setBounds(169, 370, 200, 23);
		add(textFieldDiscountPer);

		// label discount
		lblDiscount_Percentage = new JLabel("Discount Percentage:");
		lblDiscount_Percentage.setForeground(Color.WHITE);
		lblDiscount_Percentage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDiscount_Percentage.setBounds(30, 370, 139, 20);
		add(lblDiscount_Percentage);

		lblDiscount_Percentage.setVisible(false);
		textFieldDiscountPer.setVisible(false);
		yes_No_comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblDiscount_Percentage.setVisible(isVipCustomer());
				textFieldDiscountPer.setVisible(isVipCustomer());
				revalidate();

			}

		});
		btnEntr.setFocusable(false);
		btnEntr.setIcon(new ImageIcon(this.getClass().getResource("/EnterBtn.png")));

		btnEntr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn.clickSound();
				try {

					// checks if all fields are filled
					if (areAllFieldsFilled()) {
						if (checkYearOfBirth()) {
							if (!hotel.getAllCustomers().containsKey(TextFID.getText())) {
								if (isVipCustomer()) {
									if (checkDiscountpercentage()) {
										VIPCustomer customer = (VIPCustomer) createsCustomer();
										try {

											boolean Successfully = hotel.addVIPCustomer(customer);
											if (Successfully)
												JOptionPane.showMessageDialog(null, "Successfully added VIP Customer");
											else
												JOptionPane.showMessageDialog(null, "Failed to add  VIP Customer",
														"ERROR", JOptionPane.ERROR_MESSAGE);

										} catch (PersonAlreadyExistException e1) {
											JOptionPane.showMessageDialog(null, "VIP Customer already EXSITS", "ERROR",
													JOptionPane.ERROR_MESSAGE);
										}
									} else

										throw new DiscountPercentageNotValid();

								} else {
									Customer customer = createsCustomer();
									try {
										boolean Successfully = hotel.addCustomer(customer);
										if (Successfully)
											JOptionPane.showMessageDialog(null, "Successfully added Customer");
										else
											JOptionPane.showMessageDialog(null, "Failed to add Customer", "ERROR",
													JOptionPane.ERROR_MESSAGE);

									} catch (PersonAlreadyExistException e1) {
										JOptionPane.showMessageDialog(null, "Customer already EXSITS", "ERROR",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							} else
								JOptionPane.showMessageDialog(null, "Customer already EXSITS", "ERROR",
										JOptionPane.ERROR_MESSAGE);

						} else
							throw new WrongDate();
					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (WrongDate ex) {
					JOptionPane.showMessageDialog(null, "Wrong Year Of Birth", "ERROR", JOptionPane.ERROR_MESSAGE);

					System.err.println(ex);

				} catch (DiscountPercentageNotValid ex) {
					JOptionPane.showMessageDialog(null, "Wrong Discount Percentage", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}

		});

	}

	// checks if all fields are entered
	public Boolean areAllFieldsFilled() {
		Boolean fieldsFilled = false;
		Date chosenDate = chooserDateOfJoining.getDate();

		if (chosenDate == null)
			return false;
		if (isVipCustomer())
			fieldsFilled = !textFieldDiscountPer.getText().isEmpty() && !TextFID.getText().isEmpty()
					&& !textFieldFirstName.getText().isEmpty() && !textFieldLastName.getText().isEmpty()
					&& !textFieldPhone.getText().isEmpty() && !textFieldYearOfBirth.getText().isEmpty()
					&& !chooserDateOfJoining.getDate().equals(null);
		else
			fieldsFilled = !TextFID.getText().isEmpty() && !textFieldFirstName.getText().isEmpty()
					&& !textFieldLastName.getText().isEmpty() && !textFieldPhone.getText().isEmpty()
					&& !textFieldYearOfBirth.getText().isEmpty() && !chooserDateOfJoining.getDate().equals(null);
		return fieldsFilled;
	}


	

	public Boolean checkYearOfBirth() {
		int year = Integer.parseInt(textFieldYearOfBirth.getText());
		return year >= 1900 && year <= 2023;
	}

	// Discount percentagE

	public Boolean checkDiscountpercentage() {
		double discount = Double.parseDouble(textFieldDiscountPer.getText());
		return discount >= 0 && discount < 1;
	}

	// get selected combo box items
	public Gender getComboGender() {
		return (Gender) comboBoxGender.getSelectedItem();
	}

	public Area getComboArea() {
		return (Area) comboBoxArea.getSelectedItem();
	}

	// method checks if the customer is vip if it is returns true
	public Boolean isVipCustomer() {
		return yes_No_comboBox.getSelectedItem().equals("Yes");
	}

	public Date getDayeOfJoining() {
		return chooserDateOfJoining.getDate();
	}

	// String id, String firstName, String lastName, String phoneNumber, Area area,
	// Gender gender,
	// int yearOfBirth, Date dateOfJoining
	// creates an object of customer or VipCustomer
	public Customer createsCustomer() {
		String FirstName = textFieldFirstName.getText();
		String LastName = textFieldLastName.getText();
		String PhoneNumber = textFieldPhone.getText();
		String ID = TextFID.getText();
		if (!isVipCustomer())
			return new Customer(ID, FirstName, LastName, PhoneNumber, getComboArea(), getComboGender(),
					Integer.parseInt(textFieldYearOfBirth.getText()), getDayeOfJoining());
		return new VIPCustomer(ID, FirstName, LastName, PhoneNumber, getComboArea(), getComboGender(),Integer.parseInt(textFieldYearOfBirth.getText()),
				getDayeOfJoining(), Double.parseDouble(textFieldDiscountPer.getText()));
	}
}
