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
class dateamountgetcontact extends JFrame implements MouseListener
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	 ResultSet set;
	JButton cancle;
	JTextField txtdate = new JTextField();
	JTextField txtadepositd = new JTextField();
	Object[] message = {
	    "Date(dd/mm/yyyy):", txtdate,
	    "Amont Deposited:", txtadepositd,
	};
	
	private JLabel lbldate,lbladeposited;
	//private JTextField ,;
	dateamountgetcontact()
	{
		setSize(620,520);
		setTitle("Retrieve Contact via Date & Amount Deposited");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			}
		});
		//StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Daily Payment Report for all Contributor's");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//Gradien.jpg");
				
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
				g.drawImage(img,0,0,1350,50,null);
			}
		};
		title.add(l);
		main.add("North",title);
		
		Icon prt=new ImageIcon("images//PRINT.png");
		print=new JButton("Print",prt);
		print.setToolTipText("Print");
		cancle=new JButton("Exit");
		
		
		
		
		
		cancle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				contributormainmenu sa =new contributormainmenu();
				sa.setSize(340,190);
				sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				contributormainmenu.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
			}
		});
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
		            boolean complete = table.print();
		            
		            if (complete) {
		                /* show a success message  */
		              
		            } else {
		                /*show a message indicating that printing was cancelled */
		              
		            }
		        } catch (PrinterException pe) {
		            /* Printing failed, report to the user */
		           
		        }
				contributormainmenu sa =new contributormainmenu();
				sa.setSize(340,190);
				sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				contributormainmenu.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
			}
				
			
		});
		cancle.setToolTipText("Exit");
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
	
		{
			 String url = "jdbc:mysql://localhost:3306/ggtelecom";
			  
			   
			   try {
				conn = DriverManager.getConnection(url,"root","setonji04");
				//System.out.println("Connected");
		}
			   catch (Exception e) {
				// TODO: handle exception
			}
			   
			/* try{
					
					
					stmt=con.createStatement();
					rs = stmt.executeQuery("select * from contributorreg  WHERE cid ='"+s+"'");
					
				if(s==null){
					
				}
						while(rs.next()){
					txtcfName.setText(rs.getString("fname"));
					txtEmail.setText(rs.getString("email"));
					txtpNumber.setText(rs.getString("cpnumber"));
					txtnkName.setText(rs.getString("nextofkinname"));
					txtnkNumber.setText(rs.getString("nextofkinnumber"));
					
				}}
				
				catch (Exception e) {
					// TODO: handle exception
				
				}*/
			   
			   
			   
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				
				String date= txtdate.getText();
				String amount = txtadepositd.getText();
			 	 try {
			    		 set = st.executeQuery("select * from dailycontributionupdate");
								 while(set.next()){
									 String dt=set.getString("pcode");
			    		// if (date.equals(txtdate.setText(set.getString("fname")) && (txtadepositd.getText().equals(txtdate.setText(set.getString("fname"))){
			    			 if (date.equals(dt)){
						    			  
			    		 
			    		// rs = stmt.executeQuery("SELECT * FROM `salemanagent` WHERE pcode ='"+s+"'And date='"+dat+"'");
					ResultSet set=st.executeQuery("select * from dailycontributionupdate");
			    		 //set=st.executeQuery("SELECT * FROM `dailycontributionupdate` WHERE date ='"+txtdate.getText()+"'And adeposited='"+txtadepositd.getText()+"'");
							
					int row=0;
					int i=0;
					while(set.next())
					{
						row++;
					}
					DefaultTableModel model=new DefaultTableModel(new String[]{"Contributor ID", "full Name", "Amount Deposited", "Total Amount Paid", "Commission", "Loan/Withdraw"},row);
					table=new JTable(model);
					set=st.executeQuery("SELECT * FROM `dailycontributionupdate`");
					while(set.next())
					{
						model.setValueAt(set.getString(3).trim(),i,0);
						model.setValueAt(set.getString(4).trim(),i,1);
						model.setValueAt(set.getString(6).trim(),i,2);
						model.setValueAt(set.getString(7).trim(),i,3);
						model.setValueAt(set.getString(8).trim(),i,4);
						model.setValueAt(set.getString(9).trim(),i,5);
						
						i++;
					}
					table=new JTable(model);
				}}}
				catch(Exception ex)
				{
				}
				JScrollPane sp=new JScrollPane(table);
				main.add(sp);
				table.setSelectionMode(0);
				table.setFont(new Font("Times New Roman",Font.PLAIN,13));
				table.setForeground(Color.MAGENTA);
				table.setGridColor(new Color(0,128,192));
			  	table.setRowHeight(25);
			  	table.setEnabled(false);
		        table.getTableHeader().setReorderingAllowed(false);
		     c.add(main);
			    	
			    	
			    	
			    	
			    	
			    	System.out.println("Login successful");
			    } else {
			        System.out.println("login failed");
			    }
			} 
			  
			   
			  
			
			
			
			
			
		}
	
	
	
							public static void main(String args []){
								dateamountgetcontact sa=new dateamountgetcontact();
								sa.setSize(1200, 520);
								sa.setLocation(12, 10);
								sa.setVisible(true);
								
							}



							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}



							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}



							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}



							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}



							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
								
							}
			
