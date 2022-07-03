package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
	

@SuppressWarnings("serial")
public class deliveryMap extends JFrame {
												
					
	int x[]={842,1066,410,1470,820,595,484,1345,226,225,403,1282,1434,565,351,259,78,659,760,291,1283,108,1196,1110,1346,500,1037,1087,1168,1610,921,464,716,329,181,1447,681,871,185,743,392,571,326,1057,217,966,1268,250,1384,778,771,978,1289,436,860,1430,789,1016,145,903,1163,1161,1172,286,1539,837,527,706,1249,622,696,1348,1487,596,1458,1527,295,615,1009,905,475};
	int y[]={639,613,523,411,280,398,670,251,590,411,339,430,493,295,639,346,375,325,301,623,533,205,507,406,376,424,687,314,355,580,721,579,716,235,548,315,188,488,159,423,250,546,419,496,489,573,645,671,448,480,613,275,237,266,224,565,193,407,265,351,247,466,638,524,525,416,244,521,308,689,375,548,596,184,212,334,306,230,730,636,244};


					
					
					
					distanceMatrices matrix = new distanceMatrices();
					 String gidilencity="Kocaeli : ";
					 String toPrinted= " G�TMEK ���N => Kocaeli ";
					 
					public static dijkstra calculate = new dijkstra ();
					
					
    @SuppressWarnings("static-access")
	public deliveryMap() throws IOException {
        super(""); 
		
        setResizable(false);
        setUndecorated(true);
		setBounds(100, 100, 1700, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
        
		shipping sc = new shipping();
		calculate.dijkstra(matrix.getdistancematrix(), 40, sc.targets);
			
		
		HashSet <Integer> hs = new HashSet <Integer>();
        hs.addAll(calculate.targetcity);
        String targets="";
        
        for(int i : hs) {   	
        	JLabel marker = new JLabel("New label");
    		marker.setBounds(x[i]-24,y[i]-60, 48, 48);
    		marker.setIcon(new ImageIcon(deliveryMap.class.getResource("/images/marker.png")));
    		getContentPane().add(marker);
        	targets+="-"+sc.getcities()[i];
        }
		
		// KAPATMA TU�U 
		JLabel closeIcon = new JLabel("New label");
		closeIcon.setBounds(1636, 0, 64, 64);
		closeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		getContentPane().setLayout(null);
				
		JLabel panelText2 = new JLabel("G\u0130D\u0130\u015E YOLU");
		panelText2.setHorizontalAlignment(SwingConstants.CENTER);
		panelText2.setForeground(Color.WHITE);
		panelText2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelText2.setBounds(1454, 823, 123, 35);
		getContentPane().add(panelText2);
		
		JLabel panelText1 = new JLabel("D\u00D6N\u00DC\u015E YOLU");
		panelText1.setForeground(Color.WHITE);
		panelText1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelText1.setHorizontalAlignment(SwingConstants.CENTER);
		panelText1.setBounds(1454, 754, 123, 35);
		getContentPane().add(panelText1);
		
		JPanel panelOrange = new JPanel();
		panelOrange.setBackground(Color.ORANGE);
		panelOrange.setBounds(1407, 823, 35, 35);
		getContentPane().add(panelOrange);
		
		JPanel panelRed = new JPanel();
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(1407, 754, 35, 35);
		getContentPane().add(panelRed);
		
		closeIcon.setIcon(new ImageIcon(deliveryMap.class.getResource("/images/closeIcon.png")));
		getContentPane().add(closeIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBounds(648, 0, 498, 94);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel distance = new JLabel("      GIDILEN TOPLAM distance : ");
		distance.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		distance.setBounds(0, 0, 498, 94);
		panel_1.add(distance);
		distance.setText(distance.getText()+calculate.totaldistance(calculate.distancetogo)+"KM");
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(39, 871, 1617, 116);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel cityName = new JLabel("New label");
		cityName.setFont(new Font("Gill Sans MT", Font.PLAIN, 22));
		cityName.setBounds(0, 0, 1575, 116);
		panel.add(cityName);
		
		for(int i : calculate.city) {	
			toPrinted+="->"+sc.getcities()[i];
			 if (calculate.targetcity.contains(i)){
				gidilencity+=">"+"<b>"+sc.getcities()[i]+"</b>";
				continue;
			}			
			gidilencity+=">"+sc.getcities()[i];	
		}
		cityName.setText("<html>"+gidilencity);
		
		JLabel mapBackGround = new JLabel("New label");
		mapBackGround.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		mapBackGround.setIcon(new ImageIcon(deliveryMap.class.getResource("/images/city-map.jpg")));
		mapBackGround.setBounds(0, 0, 1700, 1000);
		getContentPane().add(mapBackGround);
		
		
		 String str =toPrinted;
		 BufferedWriter bufferedWriter=null;
	        File file=new File("roadsTraveled.txt"); 
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        FileWriter fileWriter = new FileWriter(file,false);
	        bufferedWriter=new BufferedWriter(fileWriter); 
	        bufferedWriter.write("Kocaeli'nden"+'['+targets+']');
	        bufferedWriter.write(str);
	        bufferedWriter.flush();
	        bufferedWriter.close();		
    }
    
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        Stroke stroke = new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);
        
    	int x1=-1;
        int y1=-1;
        int x2=-1;
        int y2=-1;
        g2d.drawLine(x[40], y[40]+15,x[calculate.city.get(0)], y[calculate.city.get(0)]+15); // kocaelinden ilk �izgi
         
        for(int i=0; i<calculate.city.size()-1; i++) {
        		int ilk=calculate.city.get(i);
        		int next=calculate.city.get(i+1);
           	 	x1=x[ilk];
                y1=y[ilk];          
                x2=x[next];
                y2=y[next];
        	
        	g2d.drawLine(x1, y1+15,x2, y2+15);
    }           
   }   
    void drawLinesD(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        Stroke stroke3 = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke3);
        
    	int x1=-1;
        int y1=-1;
        int x2=-1;
        int y2=-1;      
        
        for(int i=0; i<calculate.roadsD.size()-1; i++) {
        		int ilk=calculate.roadsD.get(i);
        		int next=calculate.roadsD.get(i+1);
           	 	x1=x[ilk];
                y1=y[ilk];
                
                x2=x[next];
                y2=y[next];
        	
        	
        	g2d.drawLine(x1,y1+15,x2, y2+15);
        }
      }
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
        drawLinesD(g);
    }
    
 
    public static void main(String[] args) throws IOException {    
             
    	new deliveryMap().setVisible(true);
                
               
    }
}