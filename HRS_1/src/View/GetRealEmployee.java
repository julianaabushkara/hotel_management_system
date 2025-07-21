//author juliana abu shkara 207840216


package View;

import exceptions.*;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.*;

import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GetRealEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelEmployeeId;
	private JPanel panelStartOfWork;
	private JPanel panelSalary;
	private JPanel panelBonus;
	private JPanel panelDepartmentId;
	private JPanel panelYearOfBirth;
	private JPanel panelGender;
	private JPanel panelArea;
	private JPanel panelPhone;
	private JPanel panelName;
	private JPanel panel;
	private JPanel panelSearch;
	private JPanel panelInfo;

	private JButton btnNewButton;
	Hotel hotel;

	private JLabel lblNameR;
	private JLabel lblPhoneR;
	private JLabel lblAreaR;
	private JLabel lblGenderR;
	private JLabel lblYearOfBirthR;
	private JLabel lblStartOfWorkR;
	private JLabel lblSalaryR;
	private JLabel lblDepartmentIdR;
	private JLabel lblBonusR;
	private JLabel lblId_1;

	private JLabel lblHomePage;
	private JLabel lblIdR;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblArea;
	private JLabel lblGender;
	private JLabel lblYearOfBirth;
	private JLabel lblStartOfWork;
	private JLabel lblSalary;
	private JLabel lblDepartmentId;
	private JLabel lblBonus;
	private JLabel lblId;

	private JTextField textField;
	private JLabel lblEmplyeeOrDeptManager;
	private JPanel panelSpecialazation;
	private JLabel lblDeptSpecialazation;
	private JLabel lblDeptSpecialazation_1;
	private ImageIcon searchBtn;
	SoundPlayer btn;

	public GetRealEmployee(String user) {

		hotel = Hotel.getInstance();
		btn = new SoundPlayer((this.getClass().getResource("/click.wav")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Get Employee");
		
		setBounds(100, 100, 771, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 184, 543);
		contentPane.add(panel);
		panel.setLayout(null);

		//search panel
		panelSearch = new JPanel();
		panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBounds(10, 141, 164, 106);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		//label ID
		lblId = new JLabel("Employee Id:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblId.setBounds(10, 23, 105, 26);
		panelSearch.add(lblId);

		//Text field id
		textField = new JTextField();
		textField.setBounds(10, 60, 144, 20);
		panelSearch.add(textField);
		textField.setColumns(10);

		
		//search button
		searchBtn = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnNewButton = new JButton("New button");
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(searchBtn);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textField.getText().isEmpty()) {
						String EmId = textField.getText();

						if (hotel.getAllEmployees().containsKey(EmId)) {
							Employee employee = hotel.getAllEmployees().get(EmId);

							lblIdR.setText(EmId);
							lblNameR.setText(employee.getFirstName() + " " + employee.getLastName());
							lblPhoneR.setText(employee.getPhoneNumber());
							lblAreaR.setText("" + employee.getArea());
							lblGenderR.setText("" + employee.getGender());
							lblYearOfBirthR.setText("" + employee.getYearOfBirth());
							lblStartOfWorkR.setText("" + employee.getStartOfWork());
							lblSalaryR.setText("" + employee.getSalary());
							lblDepartmentIdR.setText(employee.getDepartment().getDepartmentId());
							lblDeptSpecialazation_1.setText("" + employee.getDepartment().getSpecialization());
							if (employee instanceof DepartmentManager) {
								lblEmplyeeOrDeptManager.setText("Department Manager");
								DepartmentManager currDept = (DepartmentManager) employee;
								lblBonusR.setVisible(true);
								lblBonus.setVisible(true);
								panelBonus.setVisible(true);
								lblBonusR.setText("" + currDept.getBonus());
							} else
								lblEmplyeeOrDeptManager.setText("Employee");

						} else
							throw new ObjectDoesNotExist("Employee");

					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "please Fill All Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Employee Does Not EXSITS", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}

		});
		btnNewButton.setBounds(10, 385, 130, 45);
		panel.add(btnNewButton);

		// homePage
		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 115, 74);
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

		
		
		//label in the info panel
		lblEmplyeeOrDeptManager = new JLabel("");
		lblEmplyeeOrDeptManager.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmplyeeOrDeptManager.setBounds(10, 85, 164, 30);
		panel.add(lblEmplyeeOrDeptManager);

		panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaptionBorder);
		panelInfo.setBounds(182, 0, 574, 543);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		lblId_1 = new JLabel("Employee Id:");
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblId_1.setBounds(10, 29, 105, 26);
		panelInfo.add(lblId_1);

		panelEmployeeId = new JPanel();
		panelEmployeeId.setBackground(SystemColor.controlShadow);
		panelEmployeeId.setBounds(131, 29, 372, 26);
		panelInfo.add(panelEmployeeId);
		panelEmployeeId.setLayout(null);

		lblIdR = new JLabel("");
		lblIdR.setForeground(Color.WHITE);
		lblIdR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIdR.setBounds(0, 0, 372, 26);
		panelEmployeeId.add(lblIdR);

		lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(10, 77, 105, 26);
		panelInfo.add(lblName);

		lblPhone = new JLabel("phone:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhone.setBounds(10, 127, 105, 26);
		panelInfo.add(lblPhone);

		lblArea = new JLabel("Area");
		lblArea.setForeground(Color.WHITE);
		lblArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblArea.setBounds(10, 176, 105, 26);
		panelInfo.add(lblArea);

		lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGender.setBounds(10, 220, 105, 26);
		panelInfo.add(lblGender);

		lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setForeground(Color.WHITE);
		lblYearOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYearOfBirth.setBounds(10, 264, 105, 26);
		panelInfo.add(lblYearOfBirth);

		lblStartOfWork = new JLabel("Start Of Work:");
		lblStartOfWork.setForeground(Color.WHITE);
		lblStartOfWork.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStartOfWork.setBounds(10, 313, 105, 26);
		panelInfo.add(lblStartOfWork);

		lblSalary = new JLabel("Salary:");
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSalary.setBounds(10, 357, 105, 26);
		panelInfo.add(lblSalary);

		lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setForeground(Color.WHITE);
		lblDepartmentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDepartmentId.setBounds(10, 404, 105, 26);
		panelInfo.add(lblDepartmentId);

		lblBonus = new JLabel("Bonus:");
		lblBonus.setForeground(Color.WHITE);
		lblBonus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBonus.setBounds(10, 478, 105, 26);
		panelInfo.add(lblBonus);

		panelName = new JPanel();
		panelName.setLayout(null);
		panelName.setBackground(SystemColor.controlShadow);
		panelName.setBounds(131, 77, 372, 26);
		panelInfo.add(panelName);

		lblNameR = new JLabel("");
		lblNameR.setForeground(Color.WHITE);
		lblNameR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNameR.setBounds(0, 0, 372, 26);
		panelName.add(lblNameR);

		panelPhone = new JPanel();
		panelPhone.setLayout(null);
		panelPhone.setBackground(SystemColor.controlShadow);
		panelPhone.setBounds(131, 127, 372, 26);
		panelInfo.add(panelPhone);

		lblPhoneR = new JLabel("");
		lblPhoneR.setForeground(Color.WHITE);
		lblPhoneR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneR.setBounds(0, 0, 372, 26);
		panelPhone.add(lblPhoneR);

		panelArea = new JPanel();
		panelArea.setLayout(null);
		panelArea.setBackground(SystemColor.controlShadow);
		panelArea.setBounds(131, 176, 372, 26);
		panelInfo.add(panelArea);

		lblAreaR = new JLabel("");
		lblAreaR.setForeground(Color.WHITE);
		lblAreaR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAreaR.setBounds(0, 0, 372, 26);
		panelArea.add(lblAreaR);

		panelGender = new JPanel();
		panelGender.setLayout(null);
		panelGender.setBackground(SystemColor.controlShadow);
		panelGender.setBounds(131, 220, 372, 26);
		panelInfo.add(panelGender);

		lblGenderR = new JLabel("");
		lblGenderR.setForeground(Color.WHITE);
		lblGenderR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenderR.setBounds(0, 0, 372, 26);
		panelGender.add(lblGenderR);

		panelYearOfBirth = new JPanel();
		panelYearOfBirth.setLayout(null);
		panelYearOfBirth.setBackground(SystemColor.controlShadow);
		panelYearOfBirth.setBounds(131, 264, 372, 26);
		panelInfo.add(panelYearOfBirth);

		lblYearOfBirthR = new JLabel("");
		lblYearOfBirthR.setForeground(Color.WHITE);
		lblYearOfBirthR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYearOfBirthR.setBounds(0, 0, 372, 26);
		panelYearOfBirth.add(lblYearOfBirthR);

		panelStartOfWork = new JPanel();
		panelStartOfWork.setLayout(null);
		panelStartOfWork.setBackground(SystemColor.controlShadow);
		panelStartOfWork.setBounds(131, 313, 372, 26);
		panelInfo.add(panelStartOfWork);

		lblStartOfWorkR = new JLabel("");
		lblStartOfWorkR.setForeground(Color.WHITE);
		lblStartOfWorkR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStartOfWorkR.setBounds(0, 0, 372, 26);
		panelStartOfWork.add(lblStartOfWorkR);

		panelSalary = new JPanel();
		panelSalary.setLayout(null);
		panelSalary.setBackground(SystemColor.controlShadow);
		panelSalary.setBounds(131, 357, 372, 26);
		panelInfo.add(panelSalary);

		lblSalaryR = new JLabel("");
		lblSalaryR.setForeground(Color.WHITE);
		lblSalaryR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSalaryR.setBounds(0, 0, 372, 26);
		panelSalary.add(lblSalaryR);

		panelDepartmentId = new JPanel();
		panelDepartmentId.setLayout(null);
		panelDepartmentId.setBackground(SystemColor.controlShadow);
		panelDepartmentId.setBounds(131, 404, 372, 26);
		panelInfo.add(panelDepartmentId);

		lblDepartmentIdR = new JLabel("");
		lblDepartmentIdR.setForeground(Color.WHITE);
		lblDepartmentIdR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDepartmentIdR.setBounds(0, 0, 372, 26);
		panelDepartmentId.add(lblDepartmentIdR);

		panelBonus = new JPanel();
		panelBonus.setLayout(null);
		panelBonus.setBackground(SystemColor.controlShadow);
		panelBonus.setBounds(131, 478, 372, 26);
		panelInfo.add(panelBonus);

		lblBonusR = new JLabel("");
		lblBonusR.setBounds(0, 0, 372, 26);
		panelBonus.add(lblBonusR);
		lblBonusR.setForeground(Color.WHITE);
		lblBonusR.setFont(new Font("Times New Roman", Font.BOLD, 15));

		panelSpecialazation = new JPanel();
		panelSpecialazation.setBackground(SystemColor.controlShadow);
		panelSpecialazation.setBounds(131, 441, 372, 26);
		panelInfo.add(panelSpecialazation);
		panelSpecialazation.setLayout(null);

		lblDeptSpecialazation_1 = new JLabel("");
		lblDeptSpecialazation_1.setForeground(Color.WHITE);
		lblDeptSpecialazation_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeptSpecialazation_1.setBounds(0, 0, 372, 26);
		panelSpecialazation.add(lblDeptSpecialazation_1);

		lblDeptSpecialazation = new JLabel("Specialization:");
		lblDeptSpecialazation.setForeground(Color.WHITE);
		lblDeptSpecialazation.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeptSpecialazation.setBounds(10, 441, 105, 26);
		panelInfo.add(lblDeptSpecialazation);

		panelBonus.setVisible(false);
		lblBonus.setVisible(false);

	}

}
