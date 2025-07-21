//author juliana abu shkara 207840216

package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;

public class GetRealRoom extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelSearch;
	private JPanel panelInfo;
	private JPanel panelRoomID;
	private JPanel panelDailyPriceR;
	private JPanel panelFloor;
	private JPanel panelAvgDailyCost;
	private JPanel panelSize;
	private JPanel panelRoomGrade;
	private JPanel panelMaxPop;
	private JPanel panelHasView;
	private JPanel panelHasJacozi;
	private JPanel panelIsBooked;
	private JPanel panelBalconySize;
	private JComboBox<String> typeComboBox;

	private ImageIcon searchBtn;
	private JLabel lblRoomId;
	private JLabel lblHomePage;
	private JLabel lblRoomIdResult;
	private JLabel lblDailyPrice;
	private JLabel lblfloor;
	private JLabel lblIsBooked;
	private JLabel lblDailyCost;
	private JLabel lblMaxPopulation;
	private JLabel lblSize;
	private JLabel lblHasView;
	private JLabel lblRoomGrade;
	private JLabel lblHasJacozi;
	private JLabel lblRoomIdResult_1;
	private JLabel lblDailyPriceR;
	private JLabel lblfloorR;
	private JLabel lblBalconySize;
	private JLabel lblMaxPopulationR;
	private JLabel lblSizeR;
	private JLabel lblDailyCostR;
	private JLabel lblIsBookedR;
	private JLabel lblRoomGradeR;
	private JLabel lblHasViewR;
	private JLabel lblHasJacoziR;
	private JLabel lblBalconySizeR;
	private Image newimg;
	private ImageIcon hotelIcon;
	SoundPlayer btn;
	private JButton btnSearchBtn;

	private JTextField textFieldRoomId;
	private final int w = 939;
	private final int h = 412;
	private final int x = 100;
	private final int y = 100;

	public GetRealRoom(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Get Real Room");
		setResizable(false);

		setBounds(x, y, w, h);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 179, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		String[] combo = { "StandardRoom", "SuperiorRoom", "Suite" };

		// combo box room type
		typeComboBox = new JComboBox<String>(combo);
		typeComboBox.setBounds(6, 137, 163, 25);
		panel.add(typeComboBox);

		// search panel
		panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBounds(10, 190, 159, 115);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		// room id label
		lblRoomId = new JLabel("Room Id:");
		lblRoomId.setForeground(Color.WHITE);
		lblRoomId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRoomId.setBounds(10, 23, 81, 26);
		panelSearch.add(lblRoomId);

		// text field room number
		textFieldRoomId = new JTextField();
		textFieldRoomId.setBounds(10, 60, 139, 20);
		panelSearch.add(textFieldRoomId);
		textFieldRoomId.setColumns(10);

		// homePage label
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 80, 76);
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

		// search button
		searchBtn = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnSearchBtn = new JButton("New button");
		btnSearchBtn.setIcon(searchBtn);
		btnSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();

				try {
					if (!textFieldRoomId.getText().isEmpty()) {
						String roomNumber = textFieldRoomId.getText();
						roomNumber = (String) typeComboBox.getSelectedItem() + roomNumber;
						if (hotel.getAllRooms().containsKey(roomNumber)) {
							// returns an object of room
							Room tmpRoom = hotel.getAllRooms().get(roomNumber);
							lblRoomIdResult_1.setText(roomNumber);
							lblDailyPriceR.setText("" + tmpRoom.getDailyPrice());
							lblfloorR.setText("" + tmpRoom.getFloor());
							lblDailyCostR.setText("" + tmpRoom.getAvgDailyCost());
							lblRoomGradeR.setText("" + tmpRoom.getRoomGrade());
							lblMaxPopulationR.setText("" + tmpRoom.getMaxPopulationCapacity());
							lblSizeR.setText("" + tmpRoom.getSize());
							lblIsBookedR.setText("" + tmpRoom.isBooked());

							if (((String) typeComboBox.getSelectedItem()).equals("Suite")) {
								Suite suite = (Suite) tmpRoom;
								lblHasViewR.setText("" + suite.isHasView());
								lblHasJacoziR.setText("" + suite.isHasJaccozi());
								lblBalconySizeR.setText("" + suite.getBalconySize());
							}
							if (((String) typeComboBox.getSelectedItem()).equals("SuperiorRoom")) {
								SuperiorRoom superiorRoom = (SuperiorRoom) tmpRoom;
								lblHasViewR.setText("" + superiorRoom.isHasView());
								lblHasJacoziR.setText("" + superiorRoom.isHasJaccozi());
							}
							if (((String) typeComboBox.getSelectedItem()).equals("StandardRoom")) {
								StandardRoom standardRoom = (StandardRoom) tmpRoom;
								lblHasViewR.setText("" + standardRoom.isHasView());
							}

						} else
							throw new ObjectDoesNotExist("Room");
					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Fill All Fields", "ERROR", JOptionPane.ERROR_MESSAGE);

					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Room Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
			}
		});
		btnSearchBtn.setBounds(20, 316, 121, 46);
		panel.add(btnSearchBtn);

		// info panel
		panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaptionBorder);
		panelInfo.setBounds(176, 0, 751, 373);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		// room result
		lblRoomIdResult = new JLabel("Room Id:");
		lblRoomIdResult.setForeground(Color.WHITE);
		lblRoomIdResult.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomIdResult.setBounds(10, 50, 81, 26);
		panelInfo.add(lblRoomIdResult);

		// daily price label
		lblDailyPrice = new JLabel("Daily Price:");
		lblDailyPrice.setForeground(Color.WHITE);
		lblDailyPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDailyPrice.setBounds(10, 100, 81, 26);
		panelInfo.add(lblDailyPrice);

		// floor label
		lblfloor = new JLabel("Floor:");
		lblfloor.setForeground(Color.WHITE);
		lblfloor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblfloor.setBounds(10, 160, 81, 26);
		panelInfo.add(lblfloor);

		// daily cost label
		lblDailyCost = new JLabel("Avg Daily Cost:");
		lblDailyCost.setForeground(Color.WHITE);
		lblDailyCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDailyCost.setBounds(10, 220, 113, 26);
		panelInfo.add(lblDailyCost);

		// MaxPopulation label
		lblMaxPopulation = new JLabel("Max Population Capacity:");
		lblMaxPopulation.setForeground(Color.WHITE);
		lblMaxPopulation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaxPopulation.setBounds(310, 50, 173, 26);
		panelInfo.add(lblMaxPopulation);

		// label size
		lblSize = new JLabel("Size:");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSize.setBounds(10, 325, 81, 26);
		panelInfo.add(lblSize);

		// label is booked
		lblIsBooked = new JLabel("Is Booked:");
		lblIsBooked.setForeground(Color.WHITE);
		lblIsBooked.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIsBooked.setBounds(386, 100, 81, 26);
		panelInfo.add(lblIsBooked);

		// label has view
		lblHasView = new JLabel("Has View:");
		lblHasView.setForeground(Color.WHITE);
		lblHasView.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHasView.setBounds(386, 160, 81, 26);
		panelInfo.add(lblHasView);

		// label room grade
		lblRoomGrade = new JLabel("Room Grade:");
		lblRoomGrade.setForeground(Color.WHITE);
		lblRoomGrade.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomGrade.setBounds(10, 275, 92, 26);
		panelInfo.add(lblRoomGrade);

		// has jacozi label
		lblHasJacozi = new JLabel("Has Jacozi :");
		lblHasJacozi.setForeground(Color.WHITE);
		lblHasJacozi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHasJacozi.setBounds(386, 220, 81, 26);
		panelInfo.add(lblHasJacozi);

		// labels info room
		panelRoomID = new JPanel();
		panelRoomID.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelRoomID.setBackground(SystemColor.controlShadow);
		panelRoomID.setBounds(115, 50, 181, 26);
		panelInfo.add(panelRoomID);
		panelRoomID.setLayout(null);

		lblRoomIdResult_1 = new JLabel("");
		lblRoomIdResult_1.setForeground(Color.WHITE);
		lblRoomIdResult_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomIdResult_1.setBounds(0, 0, 181, 26);
		panelRoomID.add(lblRoomIdResult_1);

		panelDailyPriceR = new JPanel();
		panelDailyPriceR.setLayout(null);
		panelDailyPriceR.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelDailyPriceR.setBackground(SystemColor.controlShadow);
		panelDailyPriceR.setBounds(115, 100, 181, 26);
		panelInfo.add(panelDailyPriceR);

		lblDailyPriceR = new JLabel("");
		lblDailyPriceR.setForeground(Color.WHITE);
		lblDailyPriceR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDailyPriceR.setBounds(0, 0, 181, 26);
		panelDailyPriceR.add(lblDailyPriceR);

		panelFloor = new JPanel();
		panelFloor.setLayout(null);
		panelFloor.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelFloor.setBackground(SystemColor.controlShadow);
		panelFloor.setBounds(115, 160, 181, 26);
		panelInfo.add(panelFloor);

		lblfloorR = new JLabel("");
		lblfloorR.setForeground(Color.WHITE);
		lblfloorR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblfloorR.setBounds(0, 0, 181, 26);
		panelFloor.add(lblfloorR);

		panelAvgDailyCost = new JPanel();
		panelAvgDailyCost.setLayout(null);
		panelAvgDailyCost.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelAvgDailyCost.setBackground(SystemColor.controlShadow);
		panelAvgDailyCost.setBounds(115, 220, 181, 26);
		panelInfo.add(panelAvgDailyCost);

		lblDailyCostR = new JLabel("");
		lblDailyCostR.setForeground(Color.WHITE);
		lblDailyCostR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDailyCostR.setBounds(0, 0, 181, 26);
		panelAvgDailyCost.add(lblDailyCostR);

		panelRoomGrade = new JPanel();
		panelRoomGrade.setLayout(null);
		panelRoomGrade.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelRoomGrade.setBackground(SystemColor.controlShadow);
		panelRoomGrade.setBounds(115, 275, 181, 26);
		panelInfo.add(panelRoomGrade);

		lblRoomGradeR = new JLabel("");
		lblRoomGradeR.setForeground(Color.WHITE);
		lblRoomGradeR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomGradeR.setBounds(0, 0, 181, 26);
		panelRoomGrade.add(lblRoomGradeR);

		panelSize = new JPanel();
		panelSize.setLayout(null);
		panelSize.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelSize.setBackground(SystemColor.controlShadow);
		panelSize.setBounds(115, 325, 181, 26);
		panelInfo.add(panelSize);

		lblSizeR = new JLabel("");
		lblSizeR.setForeground(Color.WHITE);
		lblSizeR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSizeR.setBounds(0, 0, 181, 26);
		panelSize.add(lblSizeR);

		lblBalconySize = new JLabel("Balcony Size:");
		lblBalconySize.setForeground(Color.WHITE);
		lblBalconySize.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBalconySize.setBounds(386, 275, 113, 26);
		panelInfo.add(lblBalconySize);

		panelMaxPop = new JPanel();
		panelMaxPop.setLayout(null);
		panelMaxPop.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelMaxPop.setBackground(SystemColor.controlShadow);
		panelMaxPop.setBounds(493, 50, 181, 26);
		panelInfo.add(panelMaxPop);

		lblMaxPopulationR = new JLabel("");
		lblMaxPopulationR.setForeground(Color.WHITE);
		lblMaxPopulationR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaxPopulationR.setBounds(0, 0, 181, 26);
		panelMaxPop.add(lblMaxPopulationR);

		panelIsBooked = new JPanel();
		panelIsBooked.setLayout(null);
		panelIsBooked.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelIsBooked.setBackground(SystemColor.controlShadow);
		panelIsBooked.setBounds(493, 100, 181, 26);
		panelInfo.add(panelIsBooked);

		lblIsBookedR = new JLabel("");
		lblIsBookedR.setForeground(Color.WHITE);
		lblIsBookedR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIsBookedR.setBounds(0, 0, 181, 26);
		panelIsBooked.add(lblIsBookedR);

		panelHasView = new JPanel();
		panelHasView.setLayout(null);
		panelHasView.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelHasView.setBackground(SystemColor.controlShadow);
		panelHasView.setBounds(493, 160, 181, 26);
		panelInfo.add(panelHasView);

		lblHasViewR = new JLabel("");
		lblHasViewR.setForeground(Color.WHITE);
		lblHasViewR.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHasViewR.setBounds(0, 0, 181, 26);
		panelHasView.add(lblHasViewR);

		panelHasJacozi = new JPanel();
		panelHasJacozi.setLayout(null);
		panelHasJacozi.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelHasJacozi.setBackground(SystemColor.controlShadow);
		panelHasJacozi.setBounds(493, 220, 181, 26);
		panelInfo.add(panelHasJacozi);

		lblHasJacoziR = new JLabel("");
		lblHasJacoziR.setForeground(Color.WHITE);
		lblHasJacoziR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHasJacoziR.setBounds(0, 0, 181, 26);
		panelHasJacozi.add(lblHasJacoziR);

		panelBalconySize = new JPanel();
		panelBalconySize.setLayout(null);
		panelBalconySize.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelBalconySize.setBackground(SystemColor.controlShadow);
		panelBalconySize.setBounds(493, 275, 181, 26);
		panelInfo.add(panelBalconySize);

		lblBalconySizeR = new JLabel("");
		lblBalconySizeR.setForeground(Color.WHITE);
		lblBalconySizeR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBalconySizeR.setBounds(0, 0, 181, 26);
		panelBalconySize.add(lblBalconySizeR);
	}

}
