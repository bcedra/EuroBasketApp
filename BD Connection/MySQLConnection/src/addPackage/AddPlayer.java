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
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPlayer extends JFrame {

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
					AddPlayer frame = new AddPlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public AddPlayer() {
		connection = (Connection) SQLConnection.DBConnection();
		setTitle("ADD PLAYER\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdjucator = new JLabel("Pozitie");
		lblIdjucator.setForeground(Color.WHITE);
		lblIdjucator.setBounds(26, 11, 59, 14);
		contentPane.add(lblIdjucator);
		
		JLabel lblNume = new JLabel("Nume\r\n");
		lblNume.setForeground(Color.WHITE);
		lblNume.setBounds(26, 36, 59, 14);
		contentPane.add(lblNume);
		
		JLabel lblInaltime = new JLabel("Inaltime");
		lblInaltime.setForeground(Color.WHITE);
		lblInaltime.setBounds(26, 61, 59, 14);
		contentPane.add(lblInaltime);
		
		JLabel lblGreutate = new JLabel("Greutate\r\n");
		lblGreutate.setForeground(Color.WHITE);
		lblGreutate.setBounds(26, 86, 59, 14);
		contentPane.add(lblGreutate);
		
		JLabel lblTara = new JLabel("Tara");
		lblTara.setForeground(Color.WHITE);
		lblTara.setBounds(26, 111, 46, 14);
		contentPane.add(lblTara);
		
		textField = new JTextField();
		textField.setBounds(135, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 33, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 58, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 83, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(135, 108, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					String query = "insert into jucator values (?,?,?,?,?)";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Player added");
					pst.close();
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("SimHei", Font.PLAIN, 17));
		btnNewButton.setBounds(38, 162, 126, 70);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -11, 493, 272);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel);
	}
}
