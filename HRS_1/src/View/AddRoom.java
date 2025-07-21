//author juliana abu shkara 207840216



package View;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.FillAllFields;
import exceptions.NumberShouldBePositive;
import model.*;

import java.awt.SystemColor;
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

public class AddRoom extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Hotel hotel;
	private JComboBox<String> typeOfRoomComboBox;
	private JComboBox<String> hasViewComboBox;
	private JComboBox<String> hasJacozyComboBox;
	private JTextField textFieldDailyPrice;
	private JTextField textFieldFloor;
	private JTextField textFieldAvgDailyCost;
	private JTextField textFieldRoomGrade;
	private JTextField textFieldMaxCapacity;
	private JTextField textFieldSize;
	private JLabel lblDailyPrice;
	private JLabel lblFloor;
	private JLabel lblAvgDailyCost;
	private JLabel lblRoomGrade;
	private JLabel lblMaxCapacity;
	private JLabel lblSize;
	private JLabel lblRoomType;
	private JLabel lblBackground;
	private JButton btnAddRoom;
	private JLabel lblHasView;
	private JLabel lblHasJacozi;
	private JLabel lblBalconySize;
	private JLabel lblHomePage;
	private JTextField textFieldBalconySize;
	private ImageIcon enterButtonIcon;
	SoundPlayer btn;

	public AddRoom(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setResizable(false);

		this.setTitle("Add Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 681, 463);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// daily price label
		lblDailyPrice = new JLabel("Daily Price :");
		lblDailyPrice.setForeground(Color.WHITE);
		lblDailyPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDailyPrice.setBounds(25, 94, 104, 28);
		contentPane.add(lblDailyPrice);

		// floor label
		lblFloor = new JLabel("Floor :");
		lblFloor.setForeground(Color.WHITE);
		lblFloor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFloor.setBounds(25, 133, 104, 28);
		contentPane.add(lblFloor);

		// daily cost label
		lblAvgDailyCost = new JLabel("Avg Daily Cost :");
		lblAvgDailyCost.setForeground(Color.WHITE);
		lblAvgDailyCost.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAvgDailyCost.setBounds(25, 172, 121, 28);
		contentPane.add(lblAvgDailyCost);

		// room grade label
		lblRoomGrade = new JLabel("Room Grade :");
		lblRoomGrade.setForeground(Color.WHITE);
		lblRoomGrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRoomGrade.setBounds(361, 94, 104, 28);
		contentPane.add(lblRoomGrade);

		// max capacity label
		lblMaxCapacity = new JLabel("max Capacity :");
		lblMaxCapacity.setForeground(Color.WHITE);
		lblMaxCapacity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMaxCapacity.setBounds(361, 133, 104, 28);
		contentPane.add(lblMaxCapacity);

		// size label
		lblSize = new JLabel("Size  :");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSize.setBounds(361, 172, 104, 28);
		contentPane.add(lblSize);

		// texts
		textFieldDailyPrice = new JTextField();
		textFieldDailyPrice.setBounds(156, 99, 162, 20);
		contentPane.add(textFieldDailyPrice);
		textFieldDailyPrice.setColumns(10);

		textFieldFloor = new JTextField();
		textFieldFloor.setColumns(10);
		textFieldFloor.setBounds(156, 138, 162, 20);
		contentPane.add(textFieldFloor);

		textFieldAvgDailyCost = new JTextField();
		textFieldAvgDailyCost.setColumns(10);
		textFieldAvgDailyCost.setBounds(156, 177, 162, 20);
		contentPane.add(textFieldAvgDailyCost);

		textFieldRoomGrade = new JTextField();
		textFieldRoomGrade.setColumns(10);
		textFieldRoomGrade.setBounds(472, 99, 162, 20);
		contentPane.add(textFieldRoomGrade);

		textFieldMaxCapacity = new JTextField();
		textFieldMaxCapacity.setColumns(10);
		textFieldMaxCapacity.setBounds(472, 138, 162, 20);
		contentPane.add(textFieldMaxCapacity);

		textFieldSize = new JTextField();
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(472, 177, 162, 20);
		contentPane.add(textFieldSize);

		// room type label
		lblRoomType = new JLabel("Room Type:");
		lblRoomType.setForeground(Color.WHITE);
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRoomType.setBounds(25, 211, 121, 28);
		contentPane.add(lblRoomType);

		String[] combo = { "StandardRoom", "SuperiorRoom", "Suite" };
		typeOfRoomComboBox = new JComboBox<String>(combo);
		typeOfRoomComboBox.setBounds(162, 214, 255, 25);
		contentPane.add(typeOfRoomComboBox);

		enterButtonIcon = new ImageIcon(this.getClass().getResource("/addRoomBtn.png"));

		btnAddRoom = new JButton("New button");
		btnAddRoom.setIcon(enterButtonIcon);
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				try {
					// checks if all the fields are filled
					if (areAllFieldsFilled()) {
						// checks if daily price >0
						if (checkNumberIsPositive(textFieldDailyPrice)) {
							// checks if floor is bigger than 0 or 0
							if (checkIntBiggerOrZero(textFieldFloor)) {
								// checks if size bigger than zero
								if (checkIntBigger(textFieldSize)) {

									if (((String) typeOfRoomComboBox.getSelectedItem()).equals("StandardRoom")) {

										if (standardRoomMaxCapacity()) {

											StandardRoom newRoom = createStandardObject();
											boolean success = hotel.addStandardRoom(newRoom);
											if (success)
												JOptionPane.showMessageDialog(null, "Successfully added StandardRoom");

										} else
											throw new MaxPopulationCapacityException();

									} else if (((String) typeOfRoomComboBox.getSelectedItem()).equals("SuperiorRoom")) {
										int maxC = Integer.parseInt(textFieldMaxCapacity.getText());
										if ((maxC >= 3) && (maxC <= 5)) {

											SuperiorRoom newRoom = createSuperiorRoomObject();

											boolean success = hotel.addSuperiorRoom(newRoom);
											if (success)
												JOptionPane.showMessageDialog(null, "Successfully added SuperiorRoom");

										} else
											throw new MaxPopulationCapacityException();

									} else if (((String) typeOfRoomComboBox.getSelectedItem()).equals("Suite")) {
										if (suiteMaxCapacity()) {

											Suite newRoom = createSuiteObject();
											boolean success = hotel.addSuite(newRoom);
											if (success)
												JOptionPane.showMessageDialog(null, "Successfully added Suite");

										} else
											throw new MaxPopulationCapacityException();

									}

								} else {
									JOptionPane.showMessageDialog(null, "Size Must be positive", "ERROR",
											JOptionPane.ERROR_MESSAGE);
									throw new NumberShouldBePositive("Size");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Floor must be 0 or bigger", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								throw new NumberShouldBePositive("Floor");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Daily Price must be positive", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							throw new NumberShouldBePositive("Daily price");

						}

					} else
						throw new FillAllFields();

				} catch (FillAllFields ex)

				{
					JOptionPane.showMessageDialog(null, "Please fill all Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (NumberShouldBePositive ex) {

					System.err.println(ex);
				} catch (MaxPopulationCapacityException e1) {
					JOptionPane.showMessageDialog(null, "wrong Population Capacity", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(e1);

				}

			}
		});

		btnAddRoom.setBounds(445, 335, 148, 38);
		contentPane.add(btnAddRoom);

		lblHasView = new JLabel("has View ?");
		lblHasView.setForeground(Color.WHITE);
		lblHasView.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHasView.setBounds(25, 264, 121, 28);
		contentPane.add(lblHasView);

		lblHasJacozi = new JLabel("has Jacozy?");
		lblHasJacozi.setForeground(Color.WHITE);
		lblHasJacozi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHasJacozi.setBounds(25, 296, 121, 28);
		contentPane.add(lblHasJacozi);

		lblBalconySize = new JLabel("Balcony Size:");
		lblBalconySize.setForeground(Color.WHITE);
		lblBalconySize.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBalconySize.setBounds(25, 335, 121, 28);
		contentPane.add(lblBalconySize);

		ImageIcon hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		Image image = hotelIcon.getImage();
		Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		// hompage
		lblHomePage = new JLabel("New label");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 121, 83);
		lblHomePage.setIcon(hotelIcon);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});
		contentPane.add(lblHomePage);

		// text balconySize
		textFieldBalconySize = new JTextField();
		textFieldBalconySize.setBounds(156, 335, 162, 20);
		contentPane.add(textFieldBalconySize);
		textFieldBalconySize.setColumns(10);

		// yes no combo box hasview
		String[] object = { "no", "yes" };
		hasViewComboBox = new JComboBox<String>(object);
		hasViewComboBox.setBounds(156, 267, 162, 25);
		contentPane.add(hasViewComboBox);

		// yes no combo box hasJacozyComboBox
		hasJacozyComboBox = new JComboBox<String>(object);
		hasJacozyComboBox.setBounds(156, 299, 162, 25);
		contentPane.add(hasJacozyComboBox);

		hasViewComboBox.setVisible(true);
		hasJacozyComboBox.setVisible(false);
		lblBalconySize.setVisible(false);
		lblHasJacozi.setVisible(false);
		lblHasView.setVisible(true);
		textFieldBalconySize.setVisible(false);

		typeOfRoomComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hasViewComboBox.setVisible(isHasView());
				lblHasView.setVisible(isHasView());
				hasJacozyComboBox.setVisible(isHasJacozi());
				lblHasJacozi.setVisible(isHasJacozi());
				textFieldBalconySize.setVisible(isBalcony());
				lblBalconySize.setVisible(isBalcony());

				revalidate();

			}

		});

		// background
		ImageIcon Background = new ImageIcon(this.getClass().getResource("/BedroomGuestRoom.jpg"));
		Image imageBack = Background.getImage();
		Image newImg = imageBack.getScaledInstance(645, 405, java.awt.Image.SCALE_SMOOTH);
		Background = new ImageIcon(newImg);

		lblBackground = new JLabel("");
		lblBackground.setBounds(10, 11, 645, 405);
		lblBackground.setIcon(Background);
		contentPane.add(lblBackground);
	}

	// return the selected combo box
	public String getCombotypeOfRoomComboBox() {
		return (String) typeOfRoomComboBox.getSelectedItem();
	}

	// method checks if the has view if it is returns true
	public Boolean isHasView() {
		return typeOfRoomComboBox.getSelectedItem().equals("StandardRoom")
				|| typeOfRoomComboBox.getSelectedItem().equals("SuperiorRoom")
				|| typeOfRoomComboBox.getSelectedItem().equals("Suite");
	}

	// method checks if the has jacozi if it is returns true
	public Boolean isHasJacozi() {
		return typeOfRoomComboBox.getSelectedItem().equals("SuperiorRoom")
				|| typeOfRoomComboBox.getSelectedItem().equals("Suite");
	}

	// method checks if the has view if it is returns true
	public Boolean isBalcony() {
		return typeOfRoomComboBox.getSelectedItem().equals("Suite");
	}

	// get has view combo box
	public boolean getHasView() {
		String hasView = (String) hasViewComboBox.getSelectedItem();
		if (hasView.equals("yes"))
			return true;
		return false;
	}

	// get has jacozy combo box
	public boolean getHasJacozi() {
		String hasJacozi = (String) hasJacozyComboBox.getSelectedItem();
		if (hasJacozi.equals("yes"))
			return true;
		return false;
	}

	// checks that the number is above 0 positive
	public Boolean checkNumberIsPositive(JTextField textField) {
		double number = Double.parseDouble(textField.getText());
		return number > 0;
	}

	// checks that the number is above 0 positive
	public Boolean checkNumberIsPositiveOrZero(JTextField textField) {
		double number = Double.parseDouble(textField.getText());
		return number >= 0;
	}

	// checks that the number of start of work is >=0
	public boolean checkIntBiggerOrZero(JTextField textfield) {
		int num = Integer.parseInt(textfield.getText());
		return num >= 0;
	}

	public boolean checkIntBigger(JTextField textfield) {
		int num = Integer.parseInt(textfield.getText());
		return num > 0;
	}

	public boolean standardRoomMaxCapacity() {
		int maxC = Integer.parseInt(textFieldMaxCapacity.getText());
		if ((maxC < 1) || (maxC > 2))
			return false;
		return true;
	}

	public boolean suiteMaxCapacity() {
		int maxC = Integer.parseInt(textFieldMaxCapacity.getText());
		if ((maxC < 1) || (maxC > 7))
			return false;
		return true;
	}

	public Boolean areAllFieldsFilled() {
		Boolean fieldsFilled = false;
		if (typeOfRoomComboBox.getSelectedItem().equals("StandardRoom")
				|| typeOfRoomComboBox.getSelectedItem().equals("SuperiorRoom"))
			fieldsFilled = !textFieldDailyPrice.getText().isEmpty() && !textFieldFloor.getText().isEmpty()
					&& !textFieldAvgDailyCost.getText().isEmpty() && !textFieldRoomGrade.getText().isEmpty()
					&& !textFieldMaxCapacity.getText().isEmpty() && !textFieldSize.getText().isEmpty();
		else if (isBalcony())
			fieldsFilled = !textFieldDailyPrice.getText().isEmpty() && !textFieldFloor.getText().isEmpty()
					&& !textFieldAvgDailyCost.getText().isEmpty() && !textFieldRoomGrade.getText().isEmpty()
					&& !textFieldMaxCapacity.getText().isEmpty() && !textFieldSize.getText().isEmpty()
					&& !textFieldBalconySize.getText().isEmpty();
		return fieldsFilled;
	}

	public StandardRoom createStandardObject() {
		return new StandardRoom(Double.parseDouble(textFieldDailyPrice.getText()),
				Integer.parseInt(textFieldFloor.getText()), Double.parseDouble(textFieldAvgDailyCost.getText()),
				Double.parseDouble(textFieldRoomGrade.getText()), Integer.parseInt(textFieldMaxCapacity.getText()),
				Integer.parseInt(textFieldSize.getText()), getHasView());
	}

	public SuperiorRoom createSuperiorRoomObject() {
		return new SuperiorRoom(Double.parseDouble(textFieldDailyPrice.getText()),
				Integer.parseInt(textFieldFloor.getText()), Double.parseDouble(textFieldAvgDailyCost.getText()),
				Double.parseDouble(textFieldRoomGrade.getText()), Integer.parseInt(textFieldMaxCapacity.getText()),
				Integer.parseInt(textFieldSize.getText()), getHasView(), getHasJacozi());
	}

	public Suite createSuiteObject() {
		return new Suite(Double.parseDouble(textFieldDailyPrice.getText()), Integer.parseInt(textFieldFloor.getText()),
				Double.parseDouble(textFieldAvgDailyCost.getText()), Double.parseDouble(textFieldRoomGrade.getText()),
				Integer.parseInt(textFieldMaxCapacity.getText()), Integer.parseInt(textFieldSize.getText()),
				getHasView(), getHasJacozi(), Double.parseDouble(textFieldBalconySize.getText()));
	}

}
