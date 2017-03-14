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
class contributor_bank_details extends JFrame implements MouseListener
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	JButton cancle;
	contributor_bank_details()
	{
		setSize(620,520);
		setTitle("Staff Daily Transaction Report");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				/*StaffsInfo sam=new StaffsInfo();
				sam.setVisible(true);
				sam.setLocationRelativeTo(null);
				payroll_list.setDefaultLookAndFeelDecorated(true);
				setVisible(false);*/
				
			}
		});
		//StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Daily Transaction Report");
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
				
				/*dailyTransaction sam=new dailyTransaction();
				sam.setVisible(true);
				sam.setSize(799,410);
				sam.setLocationRelativeTo(null);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);*/
				
				
			}
		});
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
				
			}
		});
		cancle.setToolTipText("Exit");
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		/*try
		{
		*/	
			
			
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D://database//rakedomanagement.mdb;DriverID=22;READONLY=true) ","","");
			*/
			  String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			  
			   
			   try {
				conn = DriverManager.getConnection(url,"root","");
				//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			         //   "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
				
			   
		
			
			
			
			
			
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from dailystaffreport");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"staffid", "fname", "phone", "email", "oCounter", "cCounter", "ppLitre", "date", "time", "sale", "litre", "product", "pump", "nozzle", "address","Remark"},row);
			table=new JTable(model);
			set=st.executeQuery("select * from dailystaffreport");
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
				model.setValueAt(set.getString(10).trim(),i,9);
				model.setValueAt(set.getString(11).trim(),i,10);
				model.setValueAt(set.getString(12).trim(),i,11);
				model.setValueAt(set.getString(13).trim(),i,12);
				model.setValueAt(set.getString(14).trim(),i,13);
				model.setValueAt(set.getString(15).trim(),i,14);
				model.setValueAt(set.getString(16).trim(),i,15);
				
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
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.MAGENTA);
		table.setGridColor(new Color(0,128,192));
	  	//table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}
	
	
	
							public static void main(String args []){
								contributor_list sa=new contributor_list();
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
			
