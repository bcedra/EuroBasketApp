package loadPackage;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class LoadMatches extends JFrame {

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
					LoadMatches frame = new LoadMatches();
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
	public LoadMatches() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGroupMatches = new JButton("Group matches");
		btnGroupMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadGroupMatches tms = new LoadGroupMatches();
	             contentPane.setVisible(false);
	             tms.setVisible(true);
			}
		});
		btnGroupMatches.setBounds(139, 50, 169, 23);
		contentPane.add(btnGroupMatches);
		
		JButton btnNewButton = new JButton("Elimination Matches");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadEliminationMatches tms = new LoadEliminationMatches();
	             contentPane.setVisible(false);
	             tms.setVisible(true);
			}
		});
		btnNewButton.setBounds(139, 157, 169, 23);
		contentPane.add(btnNewButton);
		
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
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-68, 0, 522, 261);
		Image img1 = new ImageIcon(this.getClass().getResource("/cedra.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel);
	}

}
