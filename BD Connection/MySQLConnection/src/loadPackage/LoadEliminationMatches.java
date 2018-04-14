package loadPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.DatabaseMetaData;


import controllers.SQLConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoadEliminationMatches extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final DatabaseMetaData Connection = null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadEliminationMatches frame = new LoadEliminationMatches();
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
	public LoadEliminationMatches() {
		connection = SQLConnection.DBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(55, 105, 463, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton btnViewMatches = new JButton("View matches");
		btnViewMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
				/* In stringul query am scris continutul view-ului RESULT  , iar apoi
				 * am folosit preparedstatement pentru a ne conecta la baza de date.
				 * Dupa am folosit metoda resultset unde am executat statementul nostru(continutul 
				 * din view si in final l-am pus intr-un JTable
				 */
					
					String query = "select * from meciuri_eliminatorii";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		btnViewMatches.setBounds(200, 50, 169, 23);
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
		btnNewButton.setBounds(625, 357, 89, 23);
		contentPane.add(btnNewButton);
	}

}
