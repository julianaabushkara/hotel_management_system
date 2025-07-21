//author juliana abu shkara 207840216


package View;

import model.*;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class AllCustomersByPk extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private ImageIcon hotelIcon;
	private Image newimg;
	private JLabel lblAllCustomerByPk;
	Hotel hotel;
	private JLabel lblHomePage;

	public AllCustomersByPk(String user) {
		hotel = Hotel.getInstance();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("All Customers By Pk ");

		setBounds(100, 100, 735, 565);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 93, 685, 389);
		contentPane.add(scrollPane);

		// table
		String colmnCustomer[] = { "ID", "First Name", "Last Name", "Phone", "Area", "Gender", "Year Of Birth",
				"Date Of Joining", "Discount" };
		DefaultTableModel model = new DefaultTableModel(colmnCustomer, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		// homePage
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(10, 0, 103, 82);
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

		// label all customers by pk
		lblAllCustomerByPk = new JLabel("All Customer By Pk");
		lblAllCustomerByPk.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAllCustomerByPk.setForeground(Color.WHITE);
		lblAllCustomerByPk.setBounds(177, 11, 224, 38);
		contentPane.add(lblAllCustomerByPk);
		ArrayList<Customer> cPK = hotel.allCustomersByPK();
		if (!cPK.isEmpty()) {
			model = clearTable(table);

			model.setRowCount(0);

			for (Customer c : cPK) {

				if (c instanceof VIPCustomer) {
					VIPCustomer cV = (VIPCustomer) c;
					model.addRow(new Object[] { cV.getId(), cV.getFirstName(), cV.getLastName(), cV.getPhoneNumber(),
							"" + cV.getArea(), "" + cV.getGender(), cV.getYearOfBirth(), "" + cV.getDateOfJoining(),
							cV.getDiscountPercentage() });

				} else {
					model.addRow(new Object[] { c.getId(), c.getFirstName(), c.getLastName(), c.getPhoneNumber(),
							"" + c.getArea(), "" + c.getGender(), c.getYearOfBirth(), "" + c.getDateOfJoining(), 0.0 });
				}
			}
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
}
