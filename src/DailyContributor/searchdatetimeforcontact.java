package DailyContributor;


import javax.swing.*;
import javax.swing.plaf.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.plaf.metal.*;

import java.sql.*;
import java.io.*;

import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.print.*;
class searchdatetimeforcontact extends JFrame implements ActionListener
{JPanel pAdmin= new JPanel();
ResultSet rs= null;
Statement stmt;
Connection conn;


JTextField txtdate = new JTextField();
JTextField txtadepositd = new JTextField();
Object[] message = {
    "Date(dd/mm/yyyy):", txtdate,
    "Amont Deposited:", txtadepositd,
};
private JLabel lblrAddress;
private JTextArea txtrAddress;




	   
	
	
	
	searchdatetimeforcontact(){
		
pAdmin =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//back2.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,500,550,null);
			}
		}
		
		
	;
		setTitle("Staff Payroll System");
		setSize(397, 510);
		setLocation(100, 60);
	
		pAdmin.setLayout(null);

		lblrAddress = new JLabel("<html><b>Res. Address:</i></b></html>");
		lblrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblrAddress.setForeground(Color.white);
		pAdmin.add(lblrAddress).setBounds(10, 20, 80, 25);


		//JScrollPane p=new JScrollPane();
		txtrAddress=new JTextArea();
		txtrAddress.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((c == KeyEvent.VK_BACK_SPACE))) {

					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
					
					 	getToolkit().beep ();
					ke.consume ();
				}
				}
		}}
		);
		txtrAddress.setToolTipText("Enter contributor residential  Address");
		txtrAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtrAddress.setWrapStyleWord(true);
		txtrAddress.setLineWrap(true);
		txtrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		JScrollPane p=new JScrollPane(txtrAddress);
		pAdmin.add(p).setBounds(90, 24, 370, 300);
	
		String url = "jdbc:mysql://localhost:3306/ggtelecom";
		try {
			
			
		conn = DriverManager.getConnection(url,"root","setonji04");
		//System.out.println("connectd");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		
		fetch();
		//cont.add( new textstaffreg(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		/*btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);
		*/
		
	}
	void fetch(){
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		
String s= txtdate.getText();
String amount=txtadepositd.getText();
try {stmt=conn.createStatement();
			rs = stmt.executeQuery("select * from dailycontributionupdate  WHERE date='"+s+"' And adeposited='"+amount+"'");
			
		

		if (option == JOptionPane.OK_OPTION ) {
			
			rs.next();
			 String dat = rs.getString("number");
			if(txtadepositd.getText()!=null && txtdate.getText()!=null){
				System.out.println("Login succesfuly ");
				System.out.println(dat);
				txtrAddress.setText(dat);
				txtrAddress.setCaretPosition(11);
				
			}
			else{
				System.out.println("Invalid selection");
			}
		 
	}else{
	}
	}
		
		
		
		
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
				/*try{
				
					stmt=conn.createStatement();
				
				
					
					set = stmt.executeQuery("SELECT * FROM `dailycontributionupdate` WHERE date ='"+txtdate.getText()+"'And adeposited='"+txtadepositd+"'");
					
					while(set.next()){
					System.out.println(set.getString("number"));
					
					
					txtrAddress.setText(set.getString("number"));  
					System.out.println(set.getString("number"));}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			
	}
			
				
					/*
					 try {
			    		 set = stmt.executeQuery("SELECT * FROM `dailycontributionupdate` ");
			    		 
			    		while(set.next()){
			    		// if (option == JOptionPane.OK_OPTION) {	
									 System.out.println("samuel");
			    		// if (date.equals(txtdate.setText(set.getString("fname")) && (txtadepositd.getText().equals(txtdate.setText(set.getString("fname"))){
			    					  
			    				 txtrAddress.setText(set.getString("fname")); 
					// }
			    		// else{
							 //System.out.println("Error");
						 //}
					 }}
			    			 catch (Exception e) {
			    				 System.out.println("Big Error");
			    			 }
					 */
			 
								// TODO: handle exception
								 
				
	


	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		searchdatetimeforcontact sam= new searchdatetimeforcontact();
		sam.setLocationRelativeTo(null);
		sam.setSize(480,430);
		sam.setVisible(true);
	}
	
	
}