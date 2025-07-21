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

import java.util.TreeSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import model.VIPCustomer;
import javax.swing.JLabel;

public class AllCustomerCmp extends JFrame {

	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblHomePage;
	private ImageIcon hotelIcon;
	private Image newimg;
	private JScrollPane scrollPane;

	public AllCustomerCmp(String user) {
		hotel = Hotel.getInstance();
		this.setTitle("All Customer Cmp");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 821, 485);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 785, 285);
		contentPane.add(scrollPane);

		// homePage

		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(10, 11, 89, 86);
		lblHomePage.setIcon(hotelIcon);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});

		// table
		String col[] = { "ID", "First Name", "Last Name", "Phone", "Area", "Gender", "Year Of Birth", "Date Of Joining",
				"Discount" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.add(lblHomePage);

		// info to table
		TreeSet<Customer> cmp = hotel.allCustomersCmp();
		if (!cmp.isEmpty()) {
			model = clearTable(table);

			model.setRowCount(0);

			for (Customer c : cmp) {
				if (c instanceof VIPCustomer) {
					VIPCustomer cV = (VIPCustomer) c;
					model.addRow(new Object[] { cV.getId(), cV.getFirstName(), cV.getLastName(), cV.getPhoneNumber(),
							"" + cV.getArea(), "" + cV.getGender(), cV.getYearOfBirth(), "" + c.getDateOfJoining(),
							cV.getDiscountPercentage() });

				} else {
					model.addRow(new Object[] { c.getId(), c.getFirstName(), c.getLastName(), c.getPhoneNumber(),
							"" + c.getArea(), "" + c.getGender(), c.getYearOfBirth(), "" + c.getDateOfJoining(), 0.0 });

				}

			}
		}
	}

	// clear table
	private DefaultTableModel clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// Clear all rows from the model
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		return model;
	}

}
