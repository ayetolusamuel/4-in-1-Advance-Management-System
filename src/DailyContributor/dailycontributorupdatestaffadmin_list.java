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
class dailycontributorupdatestaffadmin_list extends JFrame implements ActionListener
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	JButton cancle;
	dailycontributorupdatestaffadmin_list()
	{
		setSize(620,520);
		setTitle("Contributor's Daily Record");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		//StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Contributor's Daily Record");
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
				
				MainPage sa=new  MainPage();
				 sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				 MainPage.setDefaultLookAndFeelDecorated(true);
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
				
				
				MainPage sa=new  MainPage();
				 sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				 MainPage.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
			}
		});
		cancle.setToolTipText("Exit");
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		
			  String url = "jdbc:mysql://localhost:3306/ggtelecom";
			  
			   
			   try {
				conn = DriverManager.getConnection(url,"root","setonji04");
				//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			         //   "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
				
			   
		
			
			
			
			
			
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from dailycontributionupdate");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Date ","Time ","Contributor's ID", "full name", "Phone", "Amount Deposited","Commission", "Loan/Withdraw","Endorsed ID"},row);
			table=new JTable(model);
			set=st.executeQuery("select * from dailycontributionupdate");
			while(set.next())
			{
				model.setValueAt(set.getString(1).trim(),i,0);
				model.setValueAt(set.getString(2).trim(),i,1);
				model.setValueAt(set.getString(3).trim(),i,2);
				model.setValueAt(set.getString(4).trim(),i,3);
				model.setValueAt(set.getString(5).trim(),i,4);
				model.setValueAt(set.getString(6).trim(),i,5);
				model.setValueAt(set.getString(7).trim(),i,6);
				model.setValueAt(set.getString(8).trim(),i,7);
				model.setValueAt(set.getString(9).trim(),i,8);
				
				i++;
			}
			table=new JTable(model);
		}
		catch(Exception ex)
		{
		}
		JScrollPane sp=new JScrollPane(table);
		main.add(sp);
		table.setSelectionMode(0);
		table.setFont(new Font("Times New Roman",Font.PLAIN,14));
		table.setForeground(Color.MAGENTA);
		table.setGridColor(new Color(0,128,192));
		table.setRowHeight(25);
		table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}
	

							public static void main(String args []){
								dailycontributorupdatestaffadmin_list sa=new dailycontributorupdatestaffadmin_list();
								sa.setSize(1200, 520);
								sa.setLocation(12, 10);
								sa.setVisible(true);
								
							}



							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
							}



						


							}
			
