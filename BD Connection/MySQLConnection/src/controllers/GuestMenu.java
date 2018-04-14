package controllers;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import loadPackage.LoadFrame;

public class GuestMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbBackGround = new JLabel("New label");
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestMenu frame = new GuestMenu();
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
	public GuestMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLoad = new JButton("Vizualizare");
		btnLoad.setFont(new Font("Calibri", Font.BOLD, 18));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ LoadFrame load = new LoadFrame();
				contentPane.setVisible(false);
	             load.setVisible(true);
			    }catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
			}
		});
		contentPane.setLayout(null);
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.setForeground(new Color(30, 144, 255));
		btnLoad.setBounds(134, 118, 177, 23);
		contentPane.add(btnLoad);
		lbBackGround.setBounds(0, 0, 533, 261);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lbBackGround.setIcon(new ImageIcon(img1));
		contentPane.add(lbBackGround);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ Login log = new Login();
				 contentPane.setVisible(false);
                log.frmBineAtiVenit.setVisible(true);
		    }catch(Exception f){JOptionPane.showMessageDialog(null,f);}
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(167, 203, 106, 23);
		contentPane.add(btnNewButton_1);
		
		
	}

}
