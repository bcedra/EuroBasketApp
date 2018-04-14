package loadPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controllers.SQLConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoadGroups extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadGroups frame = new LoadGroups();
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
	public LoadGroups() {
		connection = (Connection) SQLConnection.DBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(69, 64, 586, 251);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(68, 63, 587, 139);
		contentPane.add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		             LoadFrame frm = new LoadFrame();
		             contentPane.setVisible(false);
		             frm.setVisible(true);
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
			}
		});
		btnBack.setBounds(604, 321, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnViewGroups = new JButton("View Groups");
		btnViewGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					String query = "select * from grupa";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));	
				}catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnViewGroups.setBounds(291, 11, 141, 23);
		contentPane.add(btnViewGroups);
	}

}
