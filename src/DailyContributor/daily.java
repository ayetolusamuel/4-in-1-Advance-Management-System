/*package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class dailycontributor extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	private ResultSet rs = null;
 private  Statement stmt = null;
	Container cont;
	private Connection con = null;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime, lblcId, lblcfName, lblGender,lblaType,
			lblEmail, lblrAddress, lblpNumber, lblnkName, lblnkNumber,
			lblofficialinfo, 	lblaName, lblaNumber,lblbName,lblchkid;
	JLabel lbl1, lbldd;

	private JTextArea txtrAddress;
	String [] account_type={"Select Bank type","Saving","Current","Domicilary Account","Non Resident Nigerian (NRN)","Fixed Deposit Account"};
	
	
	private JTextField txtcfName, txtEmail, txtstaffID, txtfName, 
			txtpNumber, txtnkNumber, txtnkName,txtaName, txtTime, txtDate,txtchkid,
			txtBonus;
	TextArea txtOthers;
	PreparedStatement ps = null;

	private JComboBox jcmbaType;

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,
			btnmessage,btnSearch,btnOK;

	private java.util.Date currDate = new java.util.Date(); // Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
			Locale.getDefault()); // Changing Format.
	private String d = sdf.format(currDate); // Storing Date.

	String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar
			.getInstance().getTime());

	// Statement for Getting the Required Table.
	private long id = 0; // To Hold the BookId.

	// Constructor of Class.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public dailycontributor() {
		pAdmin =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//plain1.jpg");
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
				g.drawImage(img,0,0,480,370,null);
			}
		}
		
		
	;
		setTitle("Staff Payroll System");
		setSize(397, 510);
		setLocation(100, 60);
	
		pAdmin.setLayout(null);
		
		
		lblchkid = new JLabel("<html><b><b>Enter the Contributor ID for Verification :</i></b></html>");
		lblchkid.setForeground(Color.white);
		lblchkid.setFont(new Font("Serif", Font.ITALIC, 16));
		pAdmin.add(lblchkid).setBounds(19, -40, 290, 120);

		txtchkid = new JTextField("GGTC");
		txtchkid.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtchkid.setEditable(true);
		pAdmin.add(txtchkid).setBounds(323, 12, 90, 20);
		
		btnOK = new JButton(new ImageIcon("images//sam.gif"));
		pAdmin.add(btnOK).setBounds(420, 10, 38, 25);
		btnOK.addActionListener(this);
		
		lblDate = new JLabel("<html><b><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Serif", Font.ITALIC, 16));
		//pAdmin.add(lblDate).setBounds(339, -40, 70, 120);

		txtDate = new JTextField(d);
		txtDate.setFont(new Font("Algerian", Font.ITALIC, 13));
		txtDate.setEditable(false);
		//pAdmin.add(txtDate).setBounds(383, 12, 90, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblTime).setBounds(339, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		//txtTime.setEditable(false);
		txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
		//pAdmin.add(txtTime).setBounds(383, 40, 90, 20);


		lblcfName = new JLabel("<html><b><b>Full Name :</i></b></html>");
		lblcfName.setForeground(Color.white);
		lblcfName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblcfName).setBounds(10, -40, 100, 120);

		txtcfName = new JTextField("");
		txtcfName.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtcfName.setEditable(false);
		//pAdmin.add(txtcfName).setBounds(90, 12, 220, 20);

		lblEmail = new JLabel("<html><i><b>Email :</i></b></html>");
		lblEmail.setForeground(Color.white);
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblEmail).setBounds(10, -10, 70, 120);
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Algerian", Font.ITALIC, 13));
		//pAdmin.add(txtEmail).setBounds(90, 40, 220, 20);

		

		lblpNumber = new JLabel("<html><i><b>Phone Num.:</i></b></html>");
		lblpNumber.setForeground(Color.white);
		lblpNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblpNumber).setBounds(8, 16, 180, 120);
		txtpNumber= new JTextField();
		txtpNumber.setEditable(false);
		txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtpNumber.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtpNumber).setBounds(90, 68, 220, 20);
		
	
		
	
		lblrAddress = new JLabel("<html><b>Res. Address:</i></b></html>");
		lblrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblrAddress.setForeground(Color.white);
		//pAdmin.add(lblrAddress).setBounds(10, 102, 80, 25);

		txtrAddress=new JTextArea();
		txtrAddress.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE))) {

					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c=='.'||c==',')) {
					
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
		txtrAddress.setEditable(false);
		txtrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		txtrAddress.setBounds(90, 104, 380, 100);
		//pAdmin.add(txtrAddress);
		
		lblnkNumber = new JLabel("<html><b>Amount Deposited :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		//pAdmin.add(lblnkNumber).setBounds(10, 168, 100, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(true);
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		//pAdmin.add(txtnkNumber).setBounds(130, 219, 100, 20);
		
		
		lblnkNumber = new JLabel("<html><b>Balance :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblnkNumber).setBounds(10, 198, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(false);
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		//pAdmin.add(txtnkNumber).setBounds(130, 249, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Commision :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblnkNumber).setBounds(10, 228, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(false);
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		//pAdmin.add(txtnkNumber).setBounds(130, 279, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Loan/Withdraw :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblnkNumber).setBounds(10, 258, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(true);
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		//pAdmin.add(txtnkNumber).setBounds(130, 309, 100, 20);
		
		
	
		btnSave = new JButton("Save");
		//pAdmin.add(btnSave).setBounds(0, 335, 65, 25);
		btnNew = new JButton("New");
		//pAdmin.add(btnNew).setBounds(69, 335, 60, 25);
		btnModify = new JButton("Modify");
		//pAdmin.add(btnModify).setBounds(135, 335, 80, 25);

		btnPreview = new JButton("Preview");
		//pAdmin.add(btnPreview).setBounds(225, 335, 80, 25);
		btnRemove = new JButton("Remove");
		//pAdmin.add(btnRemove).setBounds(310, 335, 85, 25);
		btnExit = new JButton("Exit");
		//pAdmin.add(btnExit).setBounds(399, 335, 75, 25);
		cont=getContentPane();
	    
		cont.add( new textcontributor(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);
		

		
		
		
		String url = "jdbc:mysql://localhost:3306/ggtelecom";
		try {
			
			
		con = DriverManager.getConnection(url,"root","");

		stmt=con.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		
		String s = JOptionPane.showInputDialog(null,"Enter the Contributor ID","GGTC");
		
		if(s == null || (s != null && ("".equals(s))))   
		{
		   System.exit(0);
		}

	else{
		
		

		try{
			
			System.out.println("Contributor Id: "+s);
		rs = stmt.executeQuery("SELECT * FROM `contributorreg` WHERE cid ='"+s+"'");
		//rs = stmt.executeQuery("select * from contributorreg where cid='"+txtstaffID.getText()+"'");
		//rs = stmt.executeQuery("select * from reg where UserName='"+t1.getText()+"' AND Password='"+t2.getText()+"'");
		
			while(rs.next()){
				System.out.println("Email: "+rs.getString("email"));
				System.out.println("Full Name:"+ rs.getString("fname"));
				System.out.println("Phone Number: "+ rs.getString("cpnumber"));
			     // String userID=rs.getString("pcode");
			    // txtemail.setText(rs.getString("email"));
			         
	}
			     
			    	 

	}catch (Exception e) {
			// TODO: handle exception
		
		
		System.out.println("Error");
	}//}
		
		
		
		
	//update();	

		
	}
	
	
	
	
	
	
	
	
	 void productdetails(){
		

		try{
			String s=txtstaffID.getText();
			System.out.println("Contributor Id: "+s);
		rs = stmt.executeQuery("SELECT * FROM `contributorreg` WHERE cid ='"+s+"'");
		//rs = stmt.executeQuery("select * from contributorreg where cid='"+txtstaffID.getText()+"'");
		//rs = stmt.executeQuery("select * from reg where UserName='"+t1.getText()+"' AND Password='"+t2.getText()+"'");
		
			while(rs.next()){
				System.out.println("Email: "+rs.getString("email"));
				System.out.println("Full Name:"+ rs.getString("fname"));
				System.out.println("Phone Number: "+ rs.getString("cpnumber"));
			     // String userID=rs.getString("pcode");
			   txtEmail.setText(rs.getString("email"));
			         
	}
			     
			    	 

	}catch (Exception e) {
			// TODO: handle exception
		
		
		System.out.println("Error");
	}
	}
	void update(){
		try{
			String s = JOptionPane.showInputDialog(null,"Enter the Contributor ID","GGTC");
			
			System.out.println("Contributor Id: "+s);
		rs = stmt.executeQuery("SELECT * FROM `contributorreg` WHERE cid ='"+s+"'");
		//rs = stmt.executeQuery("select * from contributorreg where cid='"+txtstaffID.getText()+"'");
		//rs = stmt.executeQuery("select * from reg where UserName='"+t1.getText()+"' AND Password='"+t2.getText()+"'");
		
			while(rs.next()){
				System.out.println("Email: "+rs.getString("email"));
				System.out.println("Full Name:"+ rs.getString("fname"));
				System.out.println("Phone Number: "+ rs.getString("cpnumber"));
			     // String userID=rs.getString("pcode");
			    txtemail.setText(rs.getString("email"));
			         
	}
			     
			    	 

	}catch (Exception e) {
			// TODO: handle exception
		
		
		System.out.println("Error");
	}
		}
	
	public static void main(String[] args) {
		
		dailycontributor sam = new dailycontributor();
		sam.setSize(480, 420);
		sam.setVisible(true);
		sam.setResizable(false);
		
		sam.setLocationRelativeTo(null);
		try{
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("error in loading theme "+e.getMessage());
			
		}	

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
if(obj==btnOK){
	
		String s=txtstaffID.getText();
		System.out.println("Contributor Id: "+s);
		try{
	rs = stmt.executeQuery("SELECT * FROM `contributorreg` WHERE cid ='"+s+"'");
	//rs = stmt.executeQuery("select * from contributorreg where cid='"+txtstaffID.getText()+"'");
	//rs = stmt.executeQuery("select * from reg where UserName='"+t1.getText()+"' AND Password='"+t2.getText()+"'");
	System.out.println(s);
		while(rs.next()){
			System.out.println("Email: "+rs.getString("email"));
			System.out.println("Full Name:"+ rs.getString("fname"));
			System.out.println("Phone Number: "+ rs.getString("cpnumber"));
		     // String userID=rs.getString("pcode");
		   txtEmail.setText(rs.getString("email"));
		   
		}}
		 catch (Exception e2) {
			 System.out.println("Error");
			// TODO: handle exception
		}  
		   
		   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
		
		
		}








	private void visible() {
		pAdmin.add(lblDate).setBounds(339, -40, 70, 120);
		pAdmin.add(txtDate).setBounds(383, 12, 90, 20);
		pAdmin.add(lblTime).setBounds(339, -10, 70, 120);
		pAdmin.add(txtTime).setBounds(383, 40, 90, 20);
		pAdmin.add(lblcfName).setBounds(10, -40, 100, 120);
		pAdmin.add(txtcfName).setBounds(90, 12, 220, 20);
		
		
		
		
		
		
		
	}
}*/