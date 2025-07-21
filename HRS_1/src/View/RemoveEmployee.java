//author juliana abu shkara 207840216


package View;

import model.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import java.awt.SystemColor;
import java.awt.Color;
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

public class RemoveEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmployeeId;
	private JLabel lblBackground;
	private JPanel panel;
	private ImageIcon hotelIcon;
	private Image image;
	private JLabel lblHomePageIcon;
	private ImageIcon entrIcon;
	private JButton btnEnter;
	private JLabel lblRemoveEmployee;
	private ImageIcon background;
	Hotel hotel;
	SoundPlayer btn;

	public RemoveEmployee(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Remove Employee");

		setResizable(false);

		setBounds(100, 100, 361, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 320, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		// hompage icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		image = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(image);

		lblHomePageIcon = new JLabel("");
		lblHomePageIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomePageIcon.setBounds(0, 0, 139, 72);
		lblHomePageIcon.setIcon(hotelIcon);

		lblHomePageIcon.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				dispose();
				homePage.setVisible(true);

			}
		});
		panel.add(lblHomePageIcon);

		// lebal removes employee
		lblRemoveEmployee = new JLabel("Employee Id:");
		lblRemoveEmployee.setForeground(new Color(255, 255, 255));
		lblRemoveEmployee.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRemoveEmployee.setBounds(29, 83, 110, 29);
		panel.add(lblRemoveEmployee);

		// text field employee id
		textFieldEmployeeId = new JTextField();
		textFieldEmployeeId.setBounds(29, 117, 212, 20);
		panel.add(textFieldEmployeeId);
		textFieldEmployeeId.setColumns(10);

		// enter button
		entrIcon = new ImageIcon(this.getClass().getResource("/REMOVEbtn.png"));
		btnEnter = new JButton("New button");
		btnEnter.setIcon(entrIcon);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {

					if (!textFieldEmployeeId.getText().isEmpty()) {
						if (hotel.getAllEmployees().containsKey(textFieldEmployeeId.getText())) {
							if (checkIsManager()) {
								boolean success = hotel.removeDepartmentManager(
										hotel.getRealDepartmentManager(textFieldEmployeeId.getText()));
								success = hotel.removeUserNameByEmployeeID(textFieldEmployeeId.getText());
								if (success)
									JOptionPane.showMessageDialog(null, "Successfully removed Department Manager");
								else
									JOptionPane.showMessageDialog(null, "Failed to remove Department Manager", "ERROR",
											JOptionPane.ERROR_MESSAGE);

							} else {
								boolean success = hotel
										.removeEmployee(hotel.getAllEmployees().get(textFieldEmployeeId.getText()))
										&& hotel.removeUserNameByEmployeeID(textFieldEmployeeId.getText());
								if (success)
									JOptionPane.showMessageDialog(null, "Successfully removed Employee");
								else
									JOptionPane.showMessageDialog(null, "Failed to remove Employee", "ERROR",
											JOptionPane.ERROR_MESSAGE);
							}

						} else
							throw new ObjectDoesNotExist("Employee");
					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "please Fill All Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Employee Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}
		});
		btnEnter.setBounds(122, 181, 119, 47);
		panel.add(btnEnter);

		// background image
		background = new ImageIcon(this.getClass().getResource("/Background.jpg"));

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 320, 239);
		lblBackground.setIcon(background);
		panel.add(lblBackground);
	}

	public Boolean checkIsManager() {
		Employee currentEmployee = hotel.getAllEmployees().get(textFieldEmployeeId.getText());
		if (currentEmployee instanceof DepartmentManager)
			return true;
		return false;
	}

}
