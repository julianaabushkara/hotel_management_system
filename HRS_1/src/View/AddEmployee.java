//author juliana abu shkara 207840216


package View;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exceptions.AlreadyExist;
import exceptions.FillAllFields;
import exceptions.NumberShouldBePositive;
import exceptions.ObjectDoesNotExist;
import exceptions.YearOfBirthAboveOneThousandNineHundred;

import java.awt.Image;

import model.*;
import utils.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> yes_No_comboBox;
	private JComboBox<Gender> comboBoxGender;
	private JComboBox<Area> comboBoxArea;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPhone;
	private JLabel lblArea;
	private JLabel lblGender;
	private JLabel lblYearOfBirth;
	private JLabel lblSalary;
	private JLabel lblDepartment;
	private JLabel lblStartOfWork;
	private JLabel lblIsManager;
	private JLabel lblBonus;
	private JTextField textFId;
	private JTextField textFFirstName;
	private JTextField textFLastName;
	private JTextField textFPhone;
	private JTextField textFYearOfBirth;
	private JTextField textFSalary;
	private JTextField textFDepartment;
	private JTextField textFBonus;
	private JTextField textFStartOfWork;
	private JLabel lblHomePage;
	private JLabel lblAddEmployee;
	Hotel hotel;
	private JButton btnAddEmployee;
	private JTextField textFieldUserId;
	private JTextField textFieldPassword;
	private JLabel lblUserId;
	private JLabel lblPassword;
	SoundPlayer btn;

	public AddEmployee(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		this.setTitle("Add Employee");
		setBounds(100, 100, 549, 664);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		// LABEL AND TEXT INFO
		lblId = new JLabel("ID :");
		lblId.setBackground(Color.WHITE);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(50, 90, 255, 25);
		contentPane.add(lblId);

		textFId = new JTextField();
		textFId.setBounds(207, 90, 255, 25);
		contentPane.add(textFId);

		lblFirstName = new JLabel("First Name :");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(50, 120, 255, 25);
		contentPane.add(lblFirstName);

		textFFirstName = new JTextField();
		textFFirstName.setBounds(207, 120, 255, 25);
		contentPane.add(textFFirstName);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBackground(Color.WHITE);
		lblLastName.setBounds(50, 150, 255, 25);
		contentPane.add(lblLastName);

		textFLastName = new JTextField();
		textFLastName.setBounds(207, 150, 255, 25);
		contentPane.add(textFLastName);

		lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(50, 180, 155, 25);
		contentPane.add(lblPhone);

		textFPhone = new JTextField();
		textFPhone.setBounds(207, 180, 255, 25);
		contentPane.add(textFPhone);

		lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblArea.setForeground(Color.WHITE);
		lblArea.setBounds(50, 210, 255, 25);
		contentPane.add(lblArea);

		comboBoxArea = new JComboBox<Area>(Area.values());
		comboBoxArea.setBounds(207, 210, 255, 25);
		contentPane.add(comboBoxArea);

		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(50, 240, 255, 25);
		contentPane.add(lblGender);

		comboBoxGender = new JComboBox<Gender>(Gender.values());
		comboBoxGender.setBounds(207, 240, 255, 25);
		contentPane.add(comboBoxGender);

		lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYearOfBirth.setForeground(Color.WHITE);
		lblYearOfBirth.setBounds(50, 270, 255, 25);
		contentPane.add(lblYearOfBirth);

		textFYearOfBirth = new JTextField();
		textFYearOfBirth.setBounds(207, 270, 255, 25);
		contentPane.add(textFYearOfBirth);

		lblStartOfWork = new JLabel("Start Of Work:");
		lblStartOfWork.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStartOfWork.setForeground(Color.WHITE);
		lblStartOfWork.setBounds(50, 300, 155, 25);
		contentPane.add(lblStartOfWork);

		textFStartOfWork = new JTextField();
		textFStartOfWork.setBounds(207, 300, 255, 25);
		contentPane.add(textFStartOfWork);

		lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setBounds(50, 330, 155, 25);
		contentPane.add(lblSalary);

		textFSalary = new JTextField();
		textFSalary.setBounds(207, 330, 255, 25);
		contentPane.add(textFSalary);

		lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setBounds(50, 360, 155, 25);
		contentPane.add(lblDepartment);

		textFDepartment = new JTextField();
		textFDepartment.setBounds(207, 360, 255, 25);
		contentPane.add(textFDepartment);

		lblIsManager = new JLabel("IsManager:");
		lblIsManager.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIsManager.setForeground(Color.WHITE);
		lblIsManager.setBounds(50, 450, 155, 25);
		contentPane.add(lblIsManager);

		String[] combo = { "no", "yes" };
		yes_No_comboBox = new JComboBox<String>(combo);
		yes_No_comboBox.setBounds(207, 450, 255, 25);
		contentPane.add(yes_No_comboBox);

		setContentPane(contentPane);
		// hotel icon
		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// homepage
		lblHomePage = new JLabel();
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
		contentPane.add(lblHomePage);

		lblAddEmployee = new JLabel("Employee Info");
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployee.setForeground(Color.WHITE);
		lblAddEmployee.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblAddEmployee.setBounds(215, 26, 178, 40);
		contentPane.add(lblAddEmployee);

		//
		btnAddEmployee = new JButton("");
		btnAddEmployee.setFocusable(false);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (areAllFieldsFilled()) {
						if (!hotel.getAllEmployees().containsKey(textFId.getText())) {
							if (checkYearOfBirth(textFYearOfBirth)) {
								if (checkStartOfWork(textFStartOfWork)) {
									if (checkNumberIsPositive(textFSalary)) {
										if (checkDepartmentExist()) {
											if (!checkUserIdExist()) {
												if (isManager()) {
													if (isDepartmentManagerFilledInDepartment()) {
														if (checkNumberIsPositive(textFBonus)) {
															DepartmentManager manager = (DepartmentManager) createsEmployee();
															try {

																boolean Successfully = hotel
																		.addDepartmentManager(manager)
																		&& hotel.addUserName(textFieldUserId.getText(),
																				textFieldPassword.getText(),
																				textFId.getText());
																if (Successfully)
																	JOptionPane.showMessageDialog(null,
																			"Successfully added Department Manager");
																else
																	JOptionPane.showMessageDialog(null,
																			"Failed to add Department Manager", "ERROR",
																			JOptionPane.ERROR_MESSAGE);

															} catch (PersonAlreadyExistException e1) {
																JOptionPane.showMessageDialog(null,
																		"Department Manager already EXSITS", "ERROR",
																		JOptionPane.ERROR_MESSAGE);
																e1.printStackTrace();
															}
														} else {
															JOptionPane.showMessageDialog(null,
																	"Bonus Should Be Positive ", "ERROR",
																	JOptionPane.ERROR_MESSAGE);
															throw new NumberShouldBePositive("Bonus");
														}
													} else {
														JOptionPane.showMessageDialog(null,
																"DepartMentManager For The Department already EXSITS",
																"ERROR", JOptionPane.ERROR_MESSAGE);
														throw new AlreadyExist("DepartMentManager");
													}
												} else// employee and not manager
												{
													Employee employee = createsEmployee();
													try {
														boolean Successfully = hotel.addEmployee(employee)
																&& hotel.addUserName(textFieldUserId.getText(),
																		textFieldPassword.getText(), textFId.getText());
														if (Successfully)
															JOptionPane.showMessageDialog(null,
																	"Successfully added Employee");
														else
															JOptionPane.showMessageDialog(null,
																	"Failed to add Employee ", "ERROR",
																	JOptionPane.ERROR_MESSAGE);

													} catch (PersonAlreadyExistException e1) {
														JOptionPane.showMessageDialog(null, "Employee already EXSITS",
																"ERROR", JOptionPane.ERROR_MESSAGE);
														e1.printStackTrace();
													}
												}
											} else {
												JOptionPane.showMessageDialog(null, "User ID already EXSITS", "ERROR",
														JOptionPane.ERROR_MESSAGE);
											throw new AlreadyExist("User ID");
											}
										} else {
											JOptionPane.showMessageDialog(null, "Department Does Not  EXSITS", "ERROR",
													JOptionPane.ERROR_MESSAGE);
											throw new ObjectDoesNotExist("Department");
										}
									} else {
										JOptionPane.showMessageDialog(null, "Salary Should Be Positive ", "ERROR",
												JOptionPane.ERROR_MESSAGE);
										throw new NumberShouldBePositive("Salary");
									}
								} else {
									JOptionPane.showMessageDialog(null, "Start Of Work Should Be Positive ", "ERROR",
											JOptionPane.ERROR_MESSAGE);
									throw new NumberShouldBePositive("Start Of Work");
								}

							} else
								throw new YearOfBirthAboveOneThousandNineHundred();

						} else {
							JOptionPane.showMessageDialog(null, "Employee Already EXSITS  ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							throw new AlreadyExist("Employee");
						}

					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (AlreadyExist ex) {

					System.err.println(ex);
				} catch (YearOfBirthAboveOneThousandNineHundred ex) {
					JOptionPane.showMessageDialog(null, "Year Of Birth Should Be Above 1900", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (NumberShouldBePositive ex) {
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					System.err.println(ex);
				}
			}
		});
		btnAddEmployee.setBounds(165, 546, 184, 50);
		btnAddEmployee.setIcon(new ImageIcon(this.getClass().getResource("/AddEmployee.png")));

		contentPane.add(btnAddEmployee);

		// LABEL enter user AND PASS
		lblUserId = new JLabel("User Id:");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserId.setBounds(50, 390, 155, 25);
		contentPane.add(lblUserId);

		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(50, 420, 155, 25);
		contentPane.add(lblPassword);

		// TEXTS USER ID AND PASS
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(207, 390, 255, 25);
		contentPane.add(textFieldUserId);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(207, 420, 255, 25);
		contentPane.add(textFieldPassword);

		// bonus
		lblBonus = new JLabel("Bonus:");
		lblBonus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBonus.setForeground(Color.WHITE);
		lblBonus.setBounds(50, 480, 155, 25);
		contentPane.add(lblBonus);

		textFBonus = new JTextField();
		textFBonus.setBounds(207, 480, 255, 25);
		contentPane.add(textFBonus);

		lblBonus.setVisible(false);
		textFBonus.setVisible(false);
		yes_No_comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblBonus.setVisible(isManager());
				textFBonus.setVisible(isManager());
				revalidate();

			}

		});

	}

	public Gender getComboGender() {
		return (Gender) comboBoxGender.getSelectedItem();
	}

	// get area combo box
	public Area getComboArea() {
		return (Area) comboBoxArea.getSelectedItem();
	}

	// checks that the number is above 0 positive
	public Boolean checkNumberIsPositive(JTextField textField) {
		double number = Double.parseDouble(textField.getText());
		return number > 0;
	}

	// Year Of Birth
	public Boolean checkYearOfBirth(JTextField YearOfBirth) {
		int year = Integer.parseInt(YearOfBirth.getText());
		return year >= 1900 && year <= 2023;
	}

	// checks that the number of start of work is >=0
	public Boolean checkStartOfWork(JTextField StartOfWork) {
		int years = Integer.parseInt(StartOfWork.getText());
		return years >= 0;
	}

	// does the department exist returns true if does else returns false
	public Boolean checkDepartmentExist() {
		return hotel.getAllDepartments().containsKey(textFDepartment.getText());
	}

	// checks if a user id exist already cant be two employee with the same user id
	public Boolean checkUserIdExist() {
		return hotel.doesUserNameExist(textFieldUserId.getText());
	}

	// method checks if the Employee is Manager if it is returns true
	public Boolean isManager() {
		return ((String) yes_No_comboBox.getSelectedItem()).equals("yes");
	}

	public Boolean isDepartmentManagerFilledInDepartment() {
		if (hotel.getRealDepartment(textFDepartment.getText()).getDepManager() != null)
			return false;
		return true;
	}

	// checks if all fields are entered
	public Boolean areAllFieldsFilled() {
		Boolean fieldsFilled = false;
		if (!isManager())
			fieldsFilled = !textFStartOfWork.getText().isEmpty() && !textFId.getText().isEmpty()
					&& !textFFirstName.getText().isEmpty() && !textFLastName.getText().isEmpty()
					&& !textFPhone.getText().isEmpty() && !textFYearOfBirth.getText().isEmpty()
					&& !textFSalary.getText().isEmpty() && !textFDepartment.getText().isEmpty()
					&& !textFieldPassword.getText().isEmpty() && !textFieldUserId.getText().isEmpty();
		else
			fieldsFilled = !textFBonus.getText().isEmpty() && !textFStartOfWork.getText().isEmpty()
					&& !textFId.getText().isEmpty() && !textFFirstName.getText().isEmpty()
					&& !textFLastName.getText().isEmpty() && !textFPhone.getText().isEmpty()
					&& !textFYearOfBirth.getText().isEmpty() && !textFSalary.getText().isEmpty()
					&& !textFDepartment.getText().isEmpty() && !textFieldPassword.getText().isEmpty()
					&& !textFieldUserId.getText().isEmpty();
		return fieldsFilled;
	}

	// creates employee
	public Employee createsEmployee() {
		String FirstName = textFFirstName.getText();
		String LastName = textFLastName.getText();
		String PhoneNumber = textFPhone.getText();
		String ID = textFId.getText();
		if (!isManager())
			return new Employee(ID, FirstName, LastName, PhoneNumber, getComboArea(), getComboGender(),
					Integer.parseInt(textFYearOfBirth.getText()), Integer.parseInt(textFStartOfWork.getText()),
					Double.parseDouble(textFSalary.getText()), hotel.getRealDepartment(textFDepartment.getText()));
		return new DepartmentManager(ID, FirstName, LastName, PhoneNumber, getComboArea(), getComboGender(),
				Integer.parseInt(textFYearOfBirth.getText()), Integer.parseInt(textFStartOfWork.getText()),
				Double.parseDouble(textFSalary.getText()), hotel.getRealDepartment(textFDepartment.getText()),
				Double.parseDouble(textFBonus.getText()));
	}
}
