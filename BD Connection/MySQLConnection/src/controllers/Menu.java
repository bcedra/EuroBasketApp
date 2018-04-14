package controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import addPackage.AddFrame;
import loadPackage.LoadFrame;


import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbBackGround = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("MENIU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 385);
		contentPane = new JPanel();
		
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAdaugare.setBackground(UIManager.getColor("Button.background"));
		btnAdaugare.setForeground(new Color(255, 140, 0));
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		             AddFrame plr = new AddFrame();
		             contentPane.setVisible(false);
		             plr.setVisible(true);
					
				}catch(Exception e){JOptionPane.showMessageDialog(null,e);}
				
			}
		});
		btnAdaugare.setBounds(136, 163, 177, 23);
		contentPane.add(btnAdaugare);
		
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
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.setForeground(new Color(30, 144, 255));
		btnLoad.setBounds(136, 197, 177, 23);
		contentPane.add(btnLoad);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Calibri", Font.BOLD, 18));
		btnExit.setBackground(new Color(0, 255, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ Login log = new Login();
					 contentPane.setVisible(false);
	                 log.frmBineAtiVenit.setVisible(true);
			    }catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
			}
		});
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBounds(10, 312, 89, 23);
		contentPane.add(btnExit);
		lbBackGround.setBounds(-114, -134, 614, 498);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lbBackGround.setIcon(new ImageIcon(img1));
		contentPane.add(lbBackGround);
	}

}
