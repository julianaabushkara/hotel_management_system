//author juliana abu shkara 207840216


package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

public class GetRealDepartment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final int x = 100;
	private final int y = 100;
	private int w = 1000;
	private int h = 650;
	Clouds animatedCloud;
	JPanel panelAnimateCloud;
	private JPanel panel;
	private JTextField textFieldDepartmentId;
	private JPanel panel_2;
	private JPanel SearchPanal;
	private JLabel lblDeptID;
	private JLabel lblSpecialazatin;
	private JLabel HomePage;
	private JLabel lblDepartmentId;
	private JPanel panelInfo;
	private JButton btnEnter;
	private ImageIcon enterButtonIcon;
	Hotel hotel;
	private ImageIcon hotelIcon;
	private Image image;
	private Image newimg;
	private JTable table;
	private JLabel lblDeptIdR;
	private JLabel lblSpecialazatinR;
	private JPanel panelDeptID;
	private JPanel panelSpec;
	SoundPlayer btn;

	public GetRealDepartment(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		animatedCloud = new Clouds();
		animatedCloud.setBounds(0, 0, 1000, 200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Get Department");

		setResizable(false);
		setBounds(x, y, w, h);
		this.setTitle("Get Department");
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ANIMATED PANEL
		panelAnimateCloud = new JPanel();
		panelAnimateCloud.setBounds(0, 0, 1000, 200);
		contentPane.add(panelAnimateCloud);
		panelAnimateCloud.setLayout(null);
		panelAnimateCloud.add(animatedCloud);
		animatedCloud.setLayout(null);

		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 200, 224, 411);
		contentPane.add(panel);
		panel.setLayout(null);

		// SEARCH
		SearchPanal = new JPanel();
		SearchPanal.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SearchPanal.setBounds(10, 90, 200, 102);
		panel.add(SearchPanal);
		SearchPanal.setLayout(null);

		// PANEL 2
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(6, 16, 188, 81);
		SearchPanal.add(panel_2);
		panel_2.setLayout(null);

		// TEXT FIELD ID
		textFieldDepartmentId = new JTextField();
		textFieldDepartmentId.setBounds(10, 40, 168, 20);
		panel_2.add(textFieldDepartmentId);
		textFieldDepartmentId.setColumns(10);

		// Department lebal
		lblDepartmentId = new JLabel("Department Id:");
		lblDepartmentId.setBounds(10, 11, 101, 18);
		panel_2.add(lblDepartmentId);
		lblDepartmentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDepartmentId.setForeground(Color.WHITE);
		lblDepartmentId.setHorizontalAlignment(SwingConstants.LEFT);

		// hotel icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		image = hotelIcon.getImage();
		newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		// HomePageIcon
		HomePage = new JLabel("");
		HomePage.setHorizontalAlignment(SwingConstants.CENTER);
		HomePage.setBounds(0, 0, 96, 79);
		HomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				dispose();
				homePage.setVisible(true);
			}
		});

		HomePage.setIcon(hotelIcon);

		panel.add(HomePage);

		panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaptionBorder);
		panelInfo.setBounds(210, 200, 774, 411);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		// department id lebal
		lblDeptID = new JLabel("Department Id :");
		lblDeptID.setForeground(Color.WHITE);
		lblDeptID.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDeptID.setBounds(25, 38, 154, 30);
		panelInfo.add(lblDeptID);

		// specialazation label
		lblSpecialazatin = new JLabel("Specialization :");
		lblSpecialazatin.setForeground(Color.WHITE);
		lblSpecialazatin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSpecialazatin.setBounds(25, 75, 154, 30);
		panelInfo.add(lblSpecialazatin);

		// table of the employee
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 116, 726, 284);
		panelInfo.add(scrollPane);

		String col[] = { "ID", "First Name", "Last Name", "phone ", "Area", "Gender", "year of Birth", "Start Of Work",
				"Bonus" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		// info labels
		panelDeptID = new JPanel();
		panelDeptID.setBackground(SystemColor.controlShadow);
		panelDeptID.setBounds(157, 38, 356, 30);
		panelInfo.add(panelDeptID);
		panelDeptID.setLayout(null);

		lblDeptIdR = new JLabel("");
		lblDeptIdR.setForeground(Color.WHITE);
		lblDeptIdR.setBounds(0, 0, 356, 30);
		panelDeptID.add(lblDeptIdR);
		lblDeptIdR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeptIdR.setHorizontalAlignment(SwingConstants.LEFT);

		panelSpec = new JPanel();
		panelSpec.setBackground(SystemColor.controlShadow);
		panelSpec.setLayout(null);
		panelSpec.setBounds(157, 79, 356, 30);
		panelInfo.add(panelSpec);

		lblSpecialazatinR = new JLabel("");
		lblSpecialazatinR.setBounds(0, 0, 356, 30);
		panelSpec.add(lblSpecialazatinR);
		lblSpecialazatinR.setForeground(Color.WHITE);
		lblSpecialazatinR.setFont(new Font("Times New Roman", Font.BOLD, 17));

		// ENTER BUTTON
		enterButtonIcon = new ImageIcon(this.getClass().getResource("/EnterBtn.png"));

		btnEnter = new JButton("New button");
		btnEnter.setIcon(enterButtonIcon);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DefaultTableModel model = clearTable(table);
				try {
					if (!textFieldDepartmentId.getText().isEmpty()) {
						if (hotel.getAllDepartments().containsKey(textFieldDepartmentId.getText())) {
							Department depart = hotel.getAllDepartments().get(textFieldDepartmentId.getText());
							lblDeptIdR.setText(depart.getDepartmentId());
							lblSpecialazatinR.setText("" + depart.getSpecialization());
							model.setRowCount(0);

							if (depart.getDepManager() != null) {
								DepartmentManager d = depart.getDepManager();
								model.addRow(new Object[] { d.getId(), d.getFirstName(), d.getLastName(),
										d.getPhoneNumber(), "" + d.getArea(), "" + d.getGender(), d.getYearOfBirth(),
										d.getStartOfWork(), d.getBonus() });
							}
							if (!depart.getAllEmployees().isEmpty()) {

								for (Employee em : depart.getAllEmployees()) {
									/*
									 * "ID", "First Name", "Last Name", "phone ", "Area", "Gender", "year of Birth",
									 * "Start Of Work", "Bonus"
									 */
									if (!(em instanceof DepartmentManager))
										model.addRow(new Object[] { em.getId(), em.getFirstName(), em.getLastName(),
												em.getPhoneNumber(), "" + em.getArea(), "" + em.getGender(),
												em.getYearOfBirth(), em.getStartOfWork(), 0.0 });
								}
							}
						} else
							throw new ObjectDoesNotExist("Department");

					} else
						throw new FillAllFields();

				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "please FILL the id field", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				} catch (ObjectDoesNotExist ex) {
					JOptionPane.showMessageDialog(null, "Department Does Not EXSITS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				}
			}

			// clears table
			private DefaultTableModel clearTable(JTable table) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				// Clear all rows from the model
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				return model;
			}
		});
		btnEnter.setBounds(10, 355, 124, 45);
		panel.add(btnEnter);

	}

}
