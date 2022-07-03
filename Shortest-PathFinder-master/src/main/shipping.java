package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;



import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class shipping {
	private String cities[]= {
			"Agra",
			"Aligarh",
			"Allahabad",
			"Ambedkar Nagar",
			"Amethi ",
			"Amroha ",
			"Auraiya",
			"Azamgarh",
			"Baghpat",
			"Bahraich",
			"Ballia",
			"Balrampur",
			"Banda",
			"Barabanki",
			"Bareilly",
			"Basti",
			"Bhadohi",
			"Bijnor",
			"Budaun",
			"Bulandshahr",
			"Chandauli",
			"Chitrakoot",
			"Deoria",
			"Etah",
			"Etawah",
			"Faizabad",
			"Farrukhabad",
			"Fatehpur",
			"Firozabad",
			"Gautam Buddha Nagar",
			"Ghaziabad",
			"Ghazipur",
			"Gonda",
			"Gorakhpur",
			"Hamirpur",
			"Hapur",
			"Hardoi",
			"Hathras",
			"Jalaun",
			"Jaunpur",
			"Jhansi",
			"Kannauj",
			"Kanpur Dehat",
			"Kanpur Nagar",
			"Kanshiram Nagar ",
			"Kaushambi",
			"Kushinagar ",
			"Lakhimpur - Kheri",
			"Lalitpur",
			"Lucknow",
			"Maharajganj",
			"Mahoba",
			"Mainpuri",
			"Mathura",
			"Mau",
			"Meerut",
			"Mirzapur",
			"Moradabad",
			"Muzaffarnagar",
			"Pilibhit",
			"Pratapgarh",
			"RaeBareli ",
			"Rampur",
			"Saharanpur ",
			"Sambhal ",
			"Sant Kabir Nagar",
			"Shahjahanpur",
			"Shamali",
			"Shravasti",
			"Siddharth Nagar",
			"Sitapur",
			"Sonbhadra",
			"Sultanpur",
			"Unnao",
			"Varanasi"};
	
	
	
	public String[] getcities() {
		return this.cities;
	}

	public static ArrayList <Integer> target = new ArrayList<Integer>();
	
	private JFrame frame;
	int counter;
	@SuppressWarnings("rawtypes")
	JList list;
	String before= "";
	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shipping window = new shipping();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public shipping() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel deliveryIcon = new JLabel("New label");
		deliveryIcon.setIcon(new ImageIcon(shipping.class.getResource("/images/Delivery\u0130con.png")));
		deliveryIcon.setBounds(471, 290, 430, 360);
		frame.getContentPane().add(deliveryIcon);
		
		JPanel panel = new JPanel();
		panel.setName("");
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 900, 650);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox combocity = new JComboBox(cities);
		combocity.setBounds(102, 120, 277, 34);
		combocity.setBorder(null);
		combocity.setBackground(new Color(255, 140, 0));
		combocity.setForeground(Color.WHITE);
		panel.add(combocity);
		
		JLabel closeIcon = new JLabel("New label");
		closeIcon.setBounds(837, -3, 58, 64);
		closeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		closeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeIcon.png")));
		panel.add(closeIcon);
		
		JPanel Horizontal = new JPanel();
		Horizontal.setBounds(0, 77, 900, 43);
		Horizontal.setBackground(new Color(255, 250, 205));
		Horizontal.setToolTipText("adad");
		panel.add(Horizontal);
		Horizontal.setLayout(null);
		
		JLabel choosecity = new JLabel("To go \u015cities of  Se\u00E7get off");
		choosecity.setBounds(104, -11, 299, 64);
		Horizontal.add(choosecity);
		choosecity.setForeground(Color.GRAY);
		choosecity.setFont(new Font("Gill Sans MT", Font.PLAIN, 26));
		
		JLabel carIcon = new JLabel("New label");
		carIcon.setIcon(new ImageIcon(shipping.class.getResource("/images/icons8_shipped_40px.png")));
		//carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carIcon.png")));
		carIcon.setBounds(40, 0, 43, 40);
		Horizontal.add(carIcon);
		
		JPanel Dik = new JPanel();
		Dik.setBounds(38, 0, 43, 650);
		Dik.setToolTipText("adad");
		Dik.setBackground(new Color(255, 250, 205));
		panel.add(Dik);
		Dik.setLayout(null);
		
		JPanel morDik = new JPanel();
		morDik.setBackground(new Color(147, 112, 219));
		morDik.setBounds(78, 0, 25, 650);
		panel.add(morDik);
		
		JPanel morHorizontal = new JPanel();
		morHorizontal.setBackground(new Color(147, 112, 219));
		morHorizontal.setBounds(0, 56, 900, 25);
		panel.add(morHorizontal);
		
		JLabel lblNewLabel = new JLabel("BHAI COURIER SERVICES");
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 50));
		lblNewLabel.setBounds(108, 3, 697, 58);
		panel.add(lblNewLabel);
		DefaultListModel<String> c1 = new DefaultListModel<String>();
		
		JButton addcity = new JButton("\u015Add City");
		addcity.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		addcity.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
					if(c1.contains(combocity.getSelectedItem().toString())) {
						JOptionPane sc = new JOptionPane();
						sc.showMessageDialog(frame, "Yo can not enter same city twice","Warning",JOptionPane.ERROR_MESSAGE);
					}
					else if (counter>9) {
						JOptionPane sc = new JOptionPane();
						sc.showMessageDialog(frame, "You cannot enter more than 10 city","Warning",JOptionPane.ERROR_MESSAGE);
					}
					else {
						c1.addElement(combocity.getSelectedItem().toString());
						counter++;
						target.add(combocity.getSelectedIndex());
					}
					before=combocity.getSelectedItem().toString();
			}
		});
		addcity.setBounds(174, 184, 126, 43);
		panel.add(addcity);
		
		list= new JList(c1);
		list.setSelectionBackground(new Color(154, 205, 50));
		list.setSelectionForeground(new Color(0, 100, 0));
		list.setForeground(new Color(255, 255, 255));
		list.setFont(new Font("Gill Sans MT", Font.PLAIN, 22));
		list.setBackground(new Color(250, 128, 114));
		list.setBounds(102, 359, 277, 291);
		panel.add(list);
		
		JButton showmap = new JButton("Show Map");
		showmap.setFont(new Font("Gill Sans MT", Font.PLAIN, 19));
		showmap.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				if(counter==0) {
					JOptionPane sc = new JOptionPane();
					sc.showMessageDialog(frame, "Empty List","Warning",JOptionPane.ERROR_MESSAGE);
				} 
				else {
					
					try {
						teslimHarita framex = new teslimHarita();
						framex.setVisible(true);
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		showmap.setBounds(147, 240, 212, 43);
		panel.add(showmap);
		
		
		JButton deletecity = new JButton("\u015Delete City");
		deletecity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(counter==0) {
					JOptionPane.showMessageDialog(frame, "No City Selected","Warning",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int delete=-1;
					for (int i=0; i<cities.length; i++) {
						if(cities[i].equals(list.getSelectedValue())) {
							delete=i;
							break;
						}				
					}
					target.remove(target.indexOf(delete));
					c1.removeElement(list.getSelectedValue());
					counter--;
				}
			}
		});
		deletecity.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		deletecity.setBounds(174, 296, 126, 43);
		panel.add(deletecity);
		
		
			
	}
}
