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
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.FillAllFields;
import exceptions.ObjectDoesNotExist;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.awt.event.ActionEvent;

public class AllBookingOfSpecCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JPanel panelInfo;
	private JLabel lblHomePage;
	private JLabel lblAllBooking;
	private JPanel panel;
	private JPanel panelSearch;
	private JLabel lblCustomerId;
	private JButton btnSearch;
	private ImageIcon hotelIcon;
	private Image newimg;
	private JScrollPane scrollPane;
	private ImageIcon BTN;
	Hotel hotel;
	SoundPlayer btn;

	public AllBookingOfSpecCustomer(String user) {
		hotel = Hotel.getInstance();
		btn = new SoundPlayer(this.getClass().getResource("/click.wav"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("All Booking Of Spec Customer ");
		setResizable(false);

		setBounds(100, 100, 834, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 202, 541);
		contentPane.add(panel);
		panel.setLayout(null);

		// HomePage Icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 101, 91);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				homePage.setVisible(true);
				dispose();

			}
		});
		lblHomePage.setIcon(hotelIcon);
		panel.add(lblHomePage);

		// search panel
		panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.activeCaption);
		panelSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearch.setBounds(9, 161, 169, 118);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		// label customer
		lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setBounds(10, 25, 111, 33);
		panelSearch.add(lblCustomerId);

		// text field
		textField = new JTextField();
		textField.setBounds(20, 64, 139, 20);
		panelSearch.add(textField);
		textField.setColumns(10);

		// info panel
		panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaptionBorder);
		panelInfo.setBounds(203, 0, 615, 541);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		// table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 595, 432);
		panelInfo.add(scrollPane);

		String col[] = { "Booking Number", "Room Number", "Customer Id", "Check In Date", "Number Of Days",
				"Total Revenue", "Total Cost" };
		DefaultTableModel model = new DefaultTableModel(col, 0);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		// label booking
		lblAllBooking = new JLabel("All Booking");
		lblAllBooking.setForeground(SystemColor.window);
		lblAllBooking.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAllBooking.setBounds(30, 11, 185, 36);
		panelInfo.add(lblAllBooking);

		// button search
		btnSearch = new JButton("New button");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn.clickSound();
				DefaultTableModel model = clearTable(table);

				model.setRowCount(0);

				try {

					if (!textField.getText().isEmpty()) {
						if (hotel.getAllCustomers().containsKey(textField.getText())) {
							List<Booking> specCustomer = hotel.allBookingsOfSpecCustomer(textField.getText());
							if (!specCustomer.isEmpty()) {
								for (Booking b : specCustomer) {

									model.addRow(new Object[] { b.getBookingNumber(), b.getRoomNumber(),
											b.getCustomer().getId(), "" + b.getCheckInDate(), b.getNumberOfDays(),
											b.getTotalRevenue(), b.getTotalCost() });
								}
							} else {
								JOptionPane.showMessageDialog(null, "Customer Does Not Have Any Booking", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								throw new ObjectDoesNotExist("Booking");

							}
						} else {
							JOptionPane.showMessageDialog(null, "Customer Does Not EXSIT", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							throw new ObjectDoesNotExist("Customer");
						}
					} else
						throw new FillAllFields();
				} catch (FillAllFields ex) {
					JOptionPane.showMessageDialog(null, "Please Fill The ID of Customer", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);

				} catch (ObjectDoesNotExist ex) {
					System.err.println(ex);
				}
			}
		});
		btnSearch.setBounds(12, 351, 138, 43);
		BTN = new ImageIcon(this.getClass().getResource("/SearchBtn.png"));

		btnSearch.setIcon(BTN);
		panel.add(btnSearch);
	}

	private DefaultTableModel clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// Clear all rows from the model
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		return model;
	}

}
