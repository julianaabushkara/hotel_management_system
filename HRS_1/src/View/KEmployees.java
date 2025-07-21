//author juliana abu shkara 207840216


package View;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.awt.event.ActionEvent;

public class KEmployees extends JFrame {

	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JPanel panel;
	private JLabel lblHomePage;
	private JPanel panelSearch;
	private JLabel lblEnterNumber;
	private JScrollPane scrollPane;
	private JButton btnEnter;
	private ImageIcon hotelIcon;
	private Image newimg;
	SoundPlayer btn;

	public KEmployees(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("K Employees");
		setResizable(false);

		setBounds(100, 100, 1016, 578);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 182, 539);
		contentPane.add(panel);
		panel.setLayout(null);

		// homepage icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("New label");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 116, 96);
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

		// Search panel
		panelSearch = new JPanel();
		panelSearch.setBorder(new TitledBorder(null, "Enter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBounds(10, 119, 162, 114);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		// enter button
		lblEnterNumber = new JLabel("Enter Number:");
		lblEnterNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterNumber.setForeground(new Color(255, 255, 255));
		lblEnterNumber.setBounds(10, 23, 105, 32);
		panelSearch.add(lblEnterNumber);

		// text field id
		textField = new JTextField();
		textField.setBounds(10, 71, 142, 20);
		panelSearch.add(textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 23, 798, 505);
		contentPane.add(scrollPane);

		String col[] = { "ID", "FirstName", "LastName", "Phone", "Area", "Gender", "Year Of Birth", "Start Of Work",
				"Salary", "Department ID", "Bonus" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		// enter button
		btnEnter = new JButton("New button");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = clearTable(table);
				model.setRowCount(0);

				btn.clickSound();
				if (!textField.getText().isEmpty()) {
					if (Integer.parseInt(textField.getText()) > 0) {
						List<Employee> kEmployees = hotel.KEmployees(Integer.parseInt(textField.getText()));
						if (!kEmployees.isEmpty()) {
							for (Employee em : kEmployees) {
								if (em instanceof DepartmentManager) {
									DepartmentManager dep = (DepartmentManager) em;

									model.addRow(new Object[] { dep.getId(), dep.getFirstName(), dep.getLastName(),
											dep.getPhoneNumber(), "" + dep.getArea(), "" + dep.getGender(),
											dep.getYearOfBirth(), dep.getStartOfWork(), dep.getSalary(),
											dep.getDepartment().getDepartmentId(), dep.getBonus() });

								} else {
									model.addRow(new Object[] { em.getId(), em.getFirstName(), em.getLastName(),
											em.getPhoneNumber(), "" + em.getArea(), "" + em.getGender(),
											em.getYearOfBirth(), em.getStartOfWork(), em.getSalary(),
											em.getDepartment().getDepartmentId(), 0.0 });
								}

							}

						} else
							JOptionPane.showMessageDialog(null, "There Is NO employees", "ERROR",
									JOptionPane.ERROR_MESSAGE);

					} else
						JOptionPane.showMessageDialog(null, "Please Enter A Number Bigger Than 0", "ERROR",
								JOptionPane.ERROR_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Fill All The Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		ImageIcon btn = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnEnter.setBounds(10, 317, 133, 55);
		btnEnter.setIcon(btn);
		panel.add(btnEnter);
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

}
