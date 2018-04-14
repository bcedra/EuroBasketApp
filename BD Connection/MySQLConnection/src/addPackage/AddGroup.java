package addPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controllers.SQLConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class AddGroup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGroup frame = new AddGroup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public AddGroup() {
		connection = (Connection) SQLConnection.DBConnection();
		setTitle("ADD A GROUP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdgrupa = new JLabel("IdGrupa");
		lblIdgrupa.setForeground(Color.WHITE);
		lblIdgrupa.setBounds(36, 33, 46, 14);
		contentPane.add(lblIdgrupa);
		
		JLabel lblFirstteam = new JLabel("Team1");
		lblFirstteam.setForeground(Color.WHITE);
		lblFirstteam.setBounds(36, 58, 77, 14);
		contentPane.add(lblFirstteam);
		
		JLabel lblNewLabel = new JLabel("Team2");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 83, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Team3");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Team4");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(36, 133, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(92, 30, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 55, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 83, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 105, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 130, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					String query = "insert into grupa values (?,?,?,?,?)";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Group added");
					pst.close();
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		btnAdd.setBounds(43, 183, 135, 67);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					 AddFrame frame = new AddFrame();
					  contentPane.setVisible(false);
			          frame.setVisible(true);
					}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
				
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		JLabel lblNewLabell = new JLabel("New label");
		lblNewLabell.setBounds(0, -11, 500, 272);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lblNewLabell.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabell);
	}
}
