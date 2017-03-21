package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class dailycontributorstaffadmin extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	private ResultSet rs = null;
 private  Statement stmt = null;
	Container cont;
	private Connection con = null;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime,lblcfName,lblEmail, lblrAddress, lblpNumber, lblbalance, lblnkNumber,
	lbladeposited,lblchkid;
	JLabel lbl1, lbldd;

	private JTextArea txtrAddress;
	
	private JTextField txtcfName, txtEmail, txtwithdraw,txtpNumber, txtTime, txtDate,txtstaffid,txtchkid,txtadeposited,txtbalance,txtcomission;
		
	TextArea txtOthers;
	PreparedStatement ps = null;

	

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnClear,btnchkbalance,
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
	public dailycontributorstaffadmin() {
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
		setTitle("Staff Daily Contribution Update Portal");
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
		
		lbladeposited = new JLabel("<html><b>Amount Deposited :</i></b></html>");
		lbladeposited.setForeground(Color.white);
		lbladeposited.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lbladeposited).setBounds(10, 168, 100, 120);
		txtadeposited = new JTextField();
		txtadeposited.setEditable(true);
		txtadeposited.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtadeposited.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!  (c == KeyEvent.VK_BACK_SPACE)) {

					
				if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtadeposited).setBounds(130, 219, 100, 20);
		
		
		
		
		
		
		
		
		lblbalance = new JLabel("<html><b>Balance :</i></b></html>");
		lblbalance.setForeground(Color.white);
		lblbalance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblbalance).setBounds(10, 198, 180, 120);
		txtbalance = new JTextField();
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
		
		
		JLabel lblstat = new JLabel("For Staff/Manager Only Endorsed by (OPtional): ");
		lblstat.setForeground(Color.red);
		lblstat.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		//pAdmin.add(lblstat).setBounds(239, 200, 260, 120);
		

		lbladeposited = new JLabel("<html><b>Staff ID :</i></b></html>");
		lbladeposited.setForeground(Color.BLUE);
		lbladeposited.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lbladeposited).setBounds(360, 260, 100, 120);
		txtstaffid = new JTextField("GGTS");
		txtstaffid.setEditable(true);
		txtstaffid.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		txtstaffid.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pAdmin.add(txtstaffid).setBounds(420, 310, 50, 20);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		btnchkbalance= new JButton("<html><b>Check Balance");
		btnchkbalance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
			pAdmin.add(btnchkbalance).setBounds(170, 335, 130, 25);
			
			
		btnPreview = new JButton("Preview");
		pAdmin.add(btnPreview).setBounds(75, 335, 90, 25);
		btnClear = new JButton("Refresh");
		pAdmin.add(btnClear).setBounds(310, 335, 85, 25);
		btnExit = new JButton("Quit");
		pAdmin.add(btnExit).setBounds(399, 335, 75, 25);
		cont=getContentPane();
	    
		cont.add( new textcontributor(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);


		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnchkbalance.addActionListener(this);
		
		//String com=  txtcomission.setText("");
		/*String ampd=txtadeposited.getText();
		System.out.println(ampd);*/
		
		
		String url = "jdbc:mysql://localhost:3306/ggtelecom";
		try {
			
			
		con = DriverManager.getConnection(url,"root","setonji04");

		stmt=con.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		

		
	}
	
	void sumup(){
		try {
			String s = txtchkid.getText();
			int sum = 0;

			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT SUM(adeposited) FROM `dailycontributionupdate` where cid='" + s + "'");

			while (rs.next()) {

				int c = rs.getInt(1);

				sum += c;
				txtbalance.setEnabled(false);
				lblbalance.setEnabled(false);
				pAdmin.add(txtbalance).setBounds(130, 249, 100, 20);
				pAdmin.add(lblbalance).setBounds(10, 198, 180, 120);
				double adeposited = Double.parseDouble(txtadeposited.getText());
				txtcomission.setText(String.format("%.0f", (adeposited)));

				txtbalance.setText(String.format("%.0f", (adeposited + sum)));

				
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	
		
		
		
		
		
	}
	
void retrieve(){
		
		try{
			
			
			if(txtchkid.getText().length()==0 ||txtchkid.getText().equals("GGTC")||txtstaffid.getText().equals("GGTS")){
	
				JOptionPane.showMessageDialog(null, "invalid ID or empty Field");
			
			}else if(txtadeposited.getText().equals("")){
				
					JOptionPane.showMessageDialog(null, "Fill all editable empty fill");
				}
			
			else{
				sumup();
				double adeposited = Double.parseDouble(txtadeposited.getText());
				txtcomission.setText(String.format("%.0f", (adeposited)));
		
			
		 String sql="INSERT INTO dailycontributionupdate(date,time,cid,fname,number,adeposited,commission,loan,staffid)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtchkid.getText()+"','"+txtcfName.getText()+"','"+txtpNumber.getText()+"','"+txtadeposited.getText()+"','"+txtcomission.getText()+"','"+txtwithdraw.getText()+"','"+txtstaffid.getText()+"')";
	    
			
				ps=con.prepareStatement(sql);
				//System.out.println("sas");
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "<html><i>\n Your Commission is " + txtcomission.getText() + " NAIRA"+"\n\"Saved into Database\"");
				ps.close();
				dispose();
			dailycontributorstaffadmin sam = new dailycontributorstaffadmin();
			sam.setSize(480, 420);
			sam.setVisible(true);
			sam.setResizable(false);
			
			sam.setLocationRelativeTo(null);

			
			}}catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error");
				e1.printStackTrace();
	}
			}
	

	
	public static void main(String[] args) {
		
		dailycontributorstaffadmin sam = new dailycontributorstaffadmin();
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
    //txtstaffid.setText(rs.getString("staffid"));
    
    
}
     
	
	}
	catch (Exception ez) {
		// TODO: handle exception
	}
	
	try{
		rs = stmt.executeQuery("SELECT * FROM `dailycontributionupdate` WHERE cid ='"+s+"'");

			

		while(rs.next()){

			//txtstaffid.setText(rs.getString("staffid"));
		    
		    
		}
		     
			
			}
			catch (Exception ez) {
				// TODO: handle exception
			}
		
		}
else if(obj==btnExit){
	dispose();
	staffadminmainmenu sa =new staffadminmainmenu();
	sa.setSize(340,190);
	sa.setLocationRelativeTo(null);
	sa.setVisible(true);
	sa.setResizable(false);
	
	
}
else if(obj==btnPreview){
	
	
	dailycontributorupdatestaffadmin_list sa=new dailycontributorupdatestaffadmin_list();
	sa.setSize(1200, 520);
	sa.setLocation(12, 10);
	sa.setVisible(true);
	dailycontributorupdatestaffadmin_list.setDefaultLookAndFeelDecorated(true);
	
	setVisible(false);
}

else if(obj==btnchkbalance){
	
	try{
		String s=txtchkid.getText();
		 int sum = 0;
		
	        Statement st = con.createStatement();
	         rs = st.executeQuery("SELECT SUM(adeposited) FROM `dailycontributionupdate` where cid='"+s+"'");
	    
	        while (rs.next()) {
	        	
	        	 int c = rs.getInt(1);
	        	//System.out.println(c);
	        	 sum += c;
	       // sum = sum + c;
	        String str = Integer.toString(sum);
	        txtbalance.setEnabled(false);
	        lblbalance.setEnabled(false);
	        pAdmin.add(txtbalance).setBounds(130, 249, 100, 20);
	        pAdmin.add(lblbalance).setBounds(10, 198, 180, 120);
	        txtbalance.setText(str);
	        String a= txtbalance.getText();
	        JOptionPane.showMessageDialog(null, "<html><i>Contributor with ID " +s+" \n Your Balance is " + a + " NAIRA"+"" );
			
	        }}
	        catch (Exception e2) {
				// TODO: handle exception
			}
	
	
}


else if(obj==btnSave){
sumup();
	retrieve();
	
	
}
else if(obj==btnClear){
	dispose();
	dailycontributorstaffadmin sam = new dailycontributorstaffadmin();
	sam.setSize(480, 420);
	sam.setVisible(true);
	sam.setResizable(false);
	sam.setLocationRelativeTo(null);
	
	
}
		
	}



	private void cleartext() {
		// TODO Auto-generated method stub
		txtcfName.setText("");
		txtadeposited.setText("");
		txtchkid.setText("GGTC");
		
		
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