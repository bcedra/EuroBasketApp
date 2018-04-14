package addPackage;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlayer = new JButton("Add Player");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		             AddPlayer plr = new AddPlayer();
		             contentPane.setVisible(false);
		             plr.setVisible(true);
					
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
			}
		});
		btnPlayer.setBounds(172, 124, 129, 23);
		contentPane.add(btnPlayer);
		
		JButton btnGroup = new JButton("Add Group");
		btnGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		             AddGroup grp = new AddGroup();
		             contentPane.setVisible(false);
		             grp.setVisible(true);
					
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
				
			}
		});
		btnGroup.setBounds(172, 189, 129, 23);
		contentPane.add(btnGroup);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				  Menu meniu = new Menu();
				  contentPane.setVisible(false);
		          meniu.setVisible(true);
				}catch(Exception f){JOptionPane.showMessageDialog(null,f);}
			}
		});
		btnBack.setBounds(360, 288, 89, 23);
		contentPane.add(btnBack);
		lblNewLabel.setBounds(-120, -113, 599, 435);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel);
	}

}
