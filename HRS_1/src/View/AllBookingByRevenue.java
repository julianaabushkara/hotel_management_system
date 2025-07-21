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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AllBookingByRevenue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ImageIcon hotelIcon;
	private Image newimg;
	Hotel hotel;
	private JLabel lblNewLabel;

	public AllBookingByRevenue(String user) {
		hotel = Hotel.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AllBookingByRevenue ");

		setResizable(false);

		setBounds(100, 100, 779, 580);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 133, 704, 397);
		contentPane.add(scrollPane);

		// label Home Page
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 114, 101);
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});
		lblNewLabel.setIcon(hotelIcon);
		contentPane.add(lblNewLabel);

		// table
		String col[] = { "Total Revenue", "Booking Number", "Room Number", "CustomerID", "check In Date",
				"NumberOfDays", "TotalCost" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		model = clearTable(table);

		model.setRowCount(0);

		// insert info to the table
		TreeSet<Booking> allBR = hotel.allBookingByRevenue();
		if (!allBR.isEmpty()) {
			for (Booking b : allBR) {

				model.addRow(new Object[] { "" + b.getTotalRevenue(), "" + b.getBookingNumber(), "" + b.getRoomNumber(),
						"" + b.getCustomer().getId(), "" + b.getCheckInDate(), "" + b.getNumberOfDays(),
						"" + b.getTotalCost() });
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
