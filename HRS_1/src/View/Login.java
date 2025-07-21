//author juliana abu shkara 207840216

package View;
import model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.ObjectDoesNotExist;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;



public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel ;
	
	private JTextField textFieldUserId;
	private JPasswordField passwordField;
	
	private JButton btnLogin;
	private JButton btnReset ;
	
	private JLabel lblUserName;
	private JLabel lblPassword ;
	private JLabel WELCOME;

	private JLabel backgroundHotel;

	
	SoundPlayer sound,btn;
	

	
	private final int w = 854;
	private final int h = 480;
	private final int x=100;
	private final int y=100;
	Hotel hotel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hotel hotelFromFile =SerialazableHotel.loadHotel();
		if (hotelFromFile!=null)
			Hotel.setInstance(hotelFromFile);
		hotelFromFile=Hotel.getInstance();
		Room.setRunningNumber(hotelFromFile.getRoomPk());
		Booking.setRunningNumber(hotelFromFile.getBookingPK());
		
		// Register a shutdown hook to save the hotel object when the program exits
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> SerialazableHotel.saveHotel(Hotel.getInstance())));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
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
	public Login() {
		hotel=Hotel.getInstance();
		sound =new SoundPlayer(this.getClass().getResource("/LogIn.wav"));
		btn=new SoundPlayer(this.getClass().getResource("/click.wav"));

		sound.soundOn();
		sound.loop();
		setSize(683 , 459 );
		HashMap<String, String> logInInfo=hotel.getAdmin().getLoginInfo();
		this.setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(x, y, 854,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(0,0, w, h);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, w, h);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(328, 187, 350, 25);
		textFieldUserId.setColumns(10);
		panel_1.add(textFieldUserId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(328, 243, 350, 25);
		panel_1.add(passwordField);
		
		btnLogin = new JButton();
		btnLogin.setIcon(new ImageIcon(this.getClass().getResource("/LogInBtn.png")));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				String UserId=textFieldUserId.getText();
				String Password=String.valueOf(passwordField.getPassword());
				try 
				{
				if(logInInfo.containsKey(UserId))
				{
					if(logInInfo.get(UserId).equals(Password))
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
						
						HomePage homePage=new HomePage(UserId);
						sound.stop();
						dispose();
						homePage.setVisible(true);
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid password","ERROR", JOptionPane.ERROR_MESSAGE);
						throw new ObjectDoesNotExist("password");
					}
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid UserId","ERROR", JOptionPane.ERROR_MESSAGE);

					throw new ObjectDoesNotExist("UserId");

				}

				
			}catch(ObjectDoesNotExist ex)
			{
			}
			
			}
		});
		btnLogin.setBounds(242, 320, 133, 35);
		panel_1.add(btnLogin);
		
		
		btnReset = new JButton();
		btnReset.setIcon(new ImageIcon(this.getClass().getResource("/ResetBtn.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.clickSound();
				textFieldUserId.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setBounds(436, 320, 133, 35);
		panel_1.add(btnReset);
		
		
		//WELCOME LABEL
		WELCOME = new JLabel("WELCOME");
		WELCOME.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 27));
		WELCOME.setForeground(new Color(255, 255, 255));
		WELCOME.setBounds(283, 84, 312, 92);
		panel_1.add(WELCOME);
		WELCOME.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		btnReset.setFocusable(false);
		btnLogin.setFocusable(false);
		
		
		ImageIcon hotelBackground=new ImageIcon(this.getClass().getResource("/Video.gif"));
	
		/* */
		
		//user name
		lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(212, 186, 106, 25);
		panel_1.add(lblUserName);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//password
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(212, 242, 106, 25);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		
		//BACKGROUND HOTEL
		backgroundHotel = new JLabel("");
		backgroundHotel.setBounds(0, 0, 844 , 437);
		backgroundHotel.setIcon(hotelBackground);
		panel_1.add(backgroundHotel);

	}
	
}
