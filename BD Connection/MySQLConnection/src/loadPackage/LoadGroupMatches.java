package loadPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import controllers.SQLConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class LoadGroupMatches extends JFrame {

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
					LoadGroupMatches frame = new LoadGroupMatches();
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
	public LoadGroupMatches() {
		connection = SQLConnection.DBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(37, 62, 638, 291);
		contentPane.add(table);
		
		JButton btnViewMatches = new JButton("View matches");
		btnViewMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					String query = "select * from meciuri_grupe";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));	
				}catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnViewMatches.setBounds(239, 11, 186, 23);
		contentPane.add(btnViewMatches);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		             LoadFrame frm = new LoadFrame();
		             contentPane.setVisible(false);
		             frm.setVisible(true);
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
			}
		});
		btnNewButton.setBounds(617, 364, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(37, 62, 638, 291);
		contentPane.add(scrollPane);
	}

}
