//author juliana abu shkara 207840216

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import model.*;
import javax.swing.SwingConstants;

public class RemoveDepartment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JTextField textFieldDept;
	private ImageIcon entrIcon;
	private JLabel lblBackground;
	SoundPlayer btn;
	private JLabel lblHomePage;
	private ImageIcon Background;
	private ImageIcon hotelIcon;
	private JPanel panel;
	private JLabel lblRemoveDept;
	private JButton btnEnter;
	private Image image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDepartment frame = new RemoveDepartment("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RemoveDepartment(String user) {
		hotel = Hotel.getInstance();

		// button sounds
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Remove Department");
		setResizable(false);

		setBounds(100, 100, 361, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 352, 237);
		contentPane.add(panel);
		panel.setLayout(null);

		// label remove department
		lblRemoveDept = new JLabel("Department Id:");
		lblRemoveDept.setForeground(SystemColor.textHighlight);
		lblRemoveDept.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRemoveDept.setBounds(30, 83, 101, 33);
		panel.add(lblRemoveDept);

		// text field id
		textFieldDept = new JTextField();
		textFieldDept.setBounds(28, 127, 190, 20);
		panel.add(textFieldDept);
		textFieldDept.setColumns(10);

		// button
		entrIcon = new ImageIcon(this.getClass().getResource("/REMOVEbtn.png"));
		btnEnter = new JButton("");
		btnEnter.setIcon(entrIcon);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					if (!textFieldDept.getText().isEmpty()) {
						if (hotel.getAllDepartments().containsKey(textFieldDept.getText())) {
							boolean success = hotel.removeDepartment(hotel.getRealDepartment(textFieldDept.getText()));
							if (success)
								JOptionPane.showMessageDialog(null, "Successfully removed Department");
							else
								JOptionPane.showMessageDialog(null, "Failed to remove Department", "ERROR",
										JOptionPane.ERROR_MESSAGE);
						} else {
							throw new ObjectDoesNotExist("Department");

						}
					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill all Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Department Does Not EXSITS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}
		});
		btnEnter.setBounds(185, 176, 139, 38);

		panel.add(btnEnter);

		/// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		image = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(image);

		// home page icon
		lblHomePage = new JLabel("");
		lblHomePage.setBounds(0, 0, 103, 72);
		panel.add(lblHomePage);
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setIcon(hotelIcon);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				dispose();
				homePage.setVisible(true);

			}
		});

		// background
		Background = new ImageIcon(this.getClass().getResource("/Background.jpg"));

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 342, 226);
		lblBackground.setIcon(Background);
		panel.add(lblBackground);

	}

}
