//author juliana abu shkara 207840216

package View;

import model.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TotalProfit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hotel hotel;
	private JPanel contentPane;
	private ImageIcon hotelIcon;
	private Image newimg;
	private JLabel lblTotalProfit_1;
	private JPanel panel;
	private JLabel lblHomePage;
	private JLabel lblTotalProfit;

	public TotalProfit(String user) {
		hotel = Hotel.getInstance();
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		this.setTitle("TotalProfit");
		setBounds(100, 100, 423, 301);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// label total profit
		lblTotalProfit = new JLabel("Total Profit:");
		lblTotalProfit.setForeground(Color.WHITE);
		lblTotalProfit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalProfit.setBounds(10, 68, 146, 29);
		contentPane.add(lblTotalProfit);

		// homepage icon
		hotelIcon = new ImageIcon(this.getClass().getResource("/HotelIcon.png"));
		newimg = hotelIcon.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		hotelIcon = new ImageIcon(newimg);

		lblHomePage = new JLabel("");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setBounds(0, 0, 112, 69);
		lblHomePage.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				HomePage homePage = new HomePage(user);
				dispose();
				homePage.setVisible(true);

			}
		});
		lblHomePage.setIcon(hotelIcon);
		contentPane.add(lblHomePage);

		// panel
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(57, 108, 247, 29);
		contentPane.add(panel);
		panel.setLayout(null);

		// label of total profit
		lblTotalProfit_1 = new JLabel("");
		lblTotalProfit_1.setBounds(0, 0, 247, 29);
		panel.add(lblTotalProfit_1);
		lblTotalProfit_1.setForeground(Color.WHITE);
		lblTotalProfit_1.setFont(new Font("Times New Roman", Font.BOLD, 15));

		// caling total profit
		int totalProfit = hotel.totalProfit();
		lblTotalProfit_1.setText("" + totalProfit);

	}

}
