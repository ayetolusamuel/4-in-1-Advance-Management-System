package DailyContributor;

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
	private JLabel lblDate, lblTime,lblcfName,lblEmail, lblrAddress, lblpNumber,  lblnkNumber,lblchkid;
	JLabel lbl1, lbldd;

	private JTextArea txtrAddress;
	
	private JTextField txtcfName, txtEmail, txtwithdraw,txtpNumber, txtTime, txtDate,txtchkid,txtadeposited,txtbalance,txtcomission;
		
	TextArea txtOthers;
	PreparedStatement ps = null;

	

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
		txtchkid.setCaretPosition(4);
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
		txtDate.setEditable(true);
		//pAdmin.add(txtDate).setBounds(383, 12, 90, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblTime).setBounds(339, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		txtTime.setEditable(false);
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
		pAdmin.add(lblrAddress).setBounds(10, 102, 80, 25);

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
		pAdmin.add(txtrAddress);
		
		lblnkNumber = new JLabel("<html><b>Amount Deposited :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lblnkNumber).setBounds(10, 168, 100, 120);
		txtadeposited = new JTextField();
		txtadeposited.setEditable(true);
		txtadeposited.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtadeposited.addKeyListener(new KeyAdapter() {
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
		pAdmin.add(txtadeposited).setBounds(130, 219, 100, 20);
		
		
		lblnkNumber = new JLabel("<html><b>Balance :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 198, 180, 120);
		txtbalance = new JTextField("0.00");
		txtbalance.setEditable(false);
		txtbalance.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtbalance.addKeyListener(new KeyAdapter() {
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
		pAdmin.add(txtbalance).setBounds(130, 249, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Commision :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 228, 180, 120);
		txtcomission = new JTextField();
		txtcomission.setEditable(false);
		txtcomission.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtcomission.addKeyListener(new KeyAdapter() {
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
		pAdmin.add(txtcomission).setBounds(130, 279, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Loan/Withdraw :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 258, 180, 120);
		txtwithdraw = new JTextField("0.00");
		txtwithdraw.setEditable(true);
		txtwithdraw.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtwithdraw.addKeyListener(new KeyAdapter() {
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
		pAdmin.add(txtwithdraw).setBounds(130, 309, 100, 20);
		
		
	
		btnSave = new JButton("Save");
		pAdmin.add(btnSave).setBounds(0, 335, 65, 25);
		btnNew = new JButton("New");
		pAdmin.add(btnNew).setBounds(69, 335, 60, 25);
		btnModify = new JButton("Modify");
		pAdmin.add(btnModify).setBounds(135, 335, 80, 25);

		btnPreview = new JButton("Preview");
		pAdmin.add(btnPreview).setBounds(225, 335, 80, 25);
		btnRemove = new JButton("Remove");
		pAdmin.add(btnRemove).setBounds(310, 335, 85, 25);
		btnExit = new JButton("Exit");
		pAdmin.add(btnExit).setBounds(399, 335, 75, 25);
		cont=getContentPane();
	    
		cont.add( new textcontributor(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

	btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);
		
		//String com=  txtcomission.setText("");
		/*String ampd=txtadeposited.getText();
		System.out.println(ampd);*/
		
		
		String url = "jdbc:mysql://localhost:3306/ggtelecom";
		try {
			
			
		con = DriverManager.getConnection(url,"root","");

		stmt=con.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		

		
	}
	
	
	
void retrieve(){
		
		try{
			
			
			if(txtchkid.getText().length()==0 ||txtchkid.getText().equals("GGTC")){
				System.out.println("invalid ID or empty Field");
			
			}else if(txtadeposited.getText().equals("")){
					System.out.println("Fill empty field");
				}
			
			else{
				double adeposited = Double.parseDouble(txtadeposited.getText());
				txtcomission.setText(String.format("%.2f", (adeposited)));
				
			
		 String sql="INSERT INTO dailycontributionupdate(date,time,cid,fname,number,adeposited,balance,commission,loan)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtchkid.getText()+"','"+txtcfName.getText()+"','"+txtpNumber.getText()+"','"+txtadeposited.getText()+"','"+txtbalance.getText()+"','"+txtcomission.getText()+"','"+txtwithdraw.getText()+"')";
	    
			
				ps=con.prepareStatement(sql);
				//System.out.println("sas");
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "<html><i>\n Your Commission is " + txtcomission.getText() + " NAIRA"+"\n\"Saved into Database\"");
				//clearText();

				ps.close();
			}}catch (SQLException e1) {
				System.out.println("uuuuuuuuuuuuuuuu");
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

		String ampd=txtadeposited.getText();
		//String s=txtcomission.setText(ampd);
if(obj==btnOK){
	
	
	

			
	String s=txtchkid.getText();
	try {
		stmt=con.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		rs = stmt.executeQuery("select * from contributorreg ");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		while(rs.next()){
		String fetch= rs.getString("cid");
		
		if(fetch.equals(s)){

txtchkid.setBounds(0,0,0,0);;
lblchkid.setBounds(0,0,0,0);;
btnOK.setBounds(0,0,0,0);
pAdmin.add(lblDate).setBounds(339, -40, 70, 120);
pAdmin.add(lblTime).setBounds(339, -10, 70, 120);
JLabel lblxk= new JLabel("<html><b>Cont.ID:");

pAdmin.add(lblxk).setBounds(336, 70, 70, 20);
lblxk.setForeground(Color.white);
lblxk.setFont(new Font("Times New Roman", Font.ITALIC, 12));
pAdmin.add(txtchkid).setBounds(385, 70, 70, 20);

txtchkid.setEditable(false);
pAdmin.add(txtDate).setBounds(383, 12, 90, 20);
pAdmin.add(txtTime).setBounds(383, 40, 90, 20);
pAdmin.add(lblcfName).setBounds(10, -40, 100, 120);
pAdmin.add(txtcfName).setBounds(90, 12, 220, 20);
pAdmin.add(lblEmail).setBounds(10, -10, 70, 120);
pAdmin.add(txtEmail).setBounds(90, 40, 220, 20);
	
		}}}catch (Exception e2) {
		// TODO: handle exception
	}
	
	
	try{
rs = stmt.executeQuery("SELECT * FROM `contributorreg` WHERE cid ='"+s+"'");

	

while(rs.next()){

	txtcfName.setText(rs.getString("fname"));
    txtEmail.setText(rs.getString("email"));
    txtpNumber.setText(rs.getString("cpnumber"));
    txtrAddress.setText(rs.getString("residentialaddress"));
    
    
    
}
     
	
	}
	catch (Exception ez) {
		// TODO: handle exception
	}
		
		}
else if(obj==btnExit){
	dispose();
	staffnadminloginpage sa =new staffnadminloginpage();
	sa.setSize(300,190);
	sa.setLocationRelativeTo(null);
	sa.setVisible(true);
	
	
}else if(obj==btnSave){
	System.out.println(ampd);
	//String amtpaid= txtadeposited.getText();
	//String com= txtcomission.getText();

	retrieve();
	
	
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
}