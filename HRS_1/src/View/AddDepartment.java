//author juliana abu shkara 207840216


package View;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.AlreadyExist;
import exceptions.FillAllFields;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import model.*;
import utils.*;
import javax.swing.SwingConstants;

public class AddDepartment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JLabel lblHomePage;
	private final int W = 598;
	private final int H = 494;
	private final int x = 100;
	private final int y = 100;
	private JTextField textFieldDepartmentId;
	private JButton btnEnter;
	private JComboBox<Specialization> comboBoxSpecialization;

	private JLabel lblspecialization;
	private ImageIcon enterButtonIcon;
	private JLabel lblDepartmentID;
	private JLabel lblDepartmentInfo;
	SoundPlayer btn;


	public AddDepartment(String user) {
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Department");
		
		setResizable(false);

		hotel = Hotel.getInstance();
		
		setBounds(x, y, W, H);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Button Enter
		enterButtonIcon = new ImageIcon(this.getClass().getResource("/AddDepartment.png"));

		btnEnter = new JButton();
		btnEnter.setIcon(enterButtonIcon);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {

					if (areAllFieldsFilled()) {
						if (departmentIdValid()) {
							JOptionPane.showMessageDialog(null, "Successfully added Department");
							Department newDepartment = new Department(textFieldDepartmentId.getText(),
									getComboSpecialization());
							hotel.addDepartment(newDepartment);

						} else {
							throw new AlreadyExist("Department");
						}
					} else {
						throw new FillAllFields();
					}

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (AlreadyExist ex) {
					JOptionPane.showMessageDialog(null, "Department ID already EXSITS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}
		});
		btnEnter.setBounds(31, 317, 217, 36);
		contentPane.add(btnEnter);

		// combo box
		comboBoxSpecialization = new JComboBox<Specialization>(Specialization.values());
		comboBoxSpecialization.setBounds(149, 196, 198, 20);
		contentPane.add(comboBoxSpecialization);

		// text department id
		textFieldDepartmentId = new JTextField();
		textFieldDepartmentId.setBounds(149, 155, 196, 20);
		contentPane.add(textFieldDepartmentId);
		textFieldDepartmentId.setColumns(10);

		// specialization label
		lblspecialization = new JLabel("Specialization:");
		lblspecialization.setForeground(Color.WHITE);
		lblspecialization.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblspecialization.setBounds(10, 190, 134, 30);
		contentPane.add(lblspecialization);

		// department Id Label
		lblDepartmentID = new JLabel("Department Id:");
		lblDepartmentID.setBounds(10, 149, 134, 30);
		contentPane.add(lblDepartmentID);
		lblDepartmentID.setForeground(new Color(255, 255, 255));
		lblDepartmentID.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// hotel icon
		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image hotelImage = hotelIcon.getImage();
		Image newimg = hotelImage.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// Homepage Label
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

		lblDepartmentInfo = new JLabel("Department info");
		lblDepartmentInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartmentInfo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblDepartmentInfo.setForeground(Color.WHITE);
		lblDepartmentInfo.setBounds(280, 11, 205, 46);
		contentPane.add(lblDepartmentInfo);
	}

	//CHECKS IF THE FIELDS ARE EMPTY
	public Boolean areAllFieldsFilled() {
		Boolean fieldsFilled = false;
		fieldsFilled = !textFieldDepartmentId.getText().isEmpty();
		return fieldsFilled;
	}

	//IF THE DEPT EXIST
	public Boolean departmentIdValid() {
		String deptId = textFieldDepartmentId.getText();
		Boolean validDepartId = !(hotel.getAllDepartments().containsKey(deptId));// checks if the input is PK
		return validDepartId;
	}

	
	public Specialization getComboSpecialization() {
		return (Specialization) comboBoxSpecialization.getSelectedItem();
	}
}
