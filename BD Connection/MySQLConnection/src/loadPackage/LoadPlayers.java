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

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;

public class LoadPlayers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadPlayers frame = new LoadPlayers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection = null;
    private JPanel panel;
    private JTable table;
    private JButton btnBack;
    private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public LoadPlayers() {
		connection = (Connection) SQLConnection.DBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setBounds(415, 291, -362, -208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLoadPlayers = new JButton("Load Players");
		btnLoadPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				String query = "select * from jucator order by Tara,idJUCATOR";
				PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		btnLoadPlayers.setBounds(306, 10, 117, 23);
		contentPane.add(btnLoadPlayers);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		             LoadFrame frm = new LoadFrame();
		             contentPane.setVisible(false);
		             frm.setVisible(true);
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
			}
			
		});
		btnBack.setBounds(620, 426, 89, 23);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(74, 46, 558, 369);
		contentPane.add(scrollPane);
	}
}
