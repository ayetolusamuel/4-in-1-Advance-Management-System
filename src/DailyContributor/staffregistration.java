package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class staffregistration extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	ResultSet rs = null;
	Statement stmt = null;
	Connection conn = null;
	Container cont;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime, lblcId, lblcfName, lblGender,
			lblEmail, lblrAddress, lblpNumber,	lblpassword,lblposition;
	JLabel lbl1, lbldd;
	String txting = "ggts";
	String txt1=txting.toUpperCase();
	private JTextArea txtrAddress;
	String[] name={"Select","User","Manager"};
	private JComboBox jcmbposition;
	private JTextField txtDate, txtTime, txtstaffID, txtfName, txtemail,
			txtpNumber,txtaName, txtaNumber, txtbName;
		
	TextArea txtOthers;
	private JPasswordField txtpassword;
	PreparedStatement ps = null;

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,	btnOk,
			btnSearch;

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
	public staffregistration() {
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

		lblDate = new JLabel("<html><b><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblDate).setBounds(10, -40, 70, 120);

		txtDate = new JTextField(d);
		txtDate.setFont(new Font("Algerian", Font.ITALIC, 16));
		txtDate.setEditable(false);
		pAdmin.add(txtDate).setBounds(90, 12, 130, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblTime).setBounds(10, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		txtTime.setEditable(false);
		txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtTime).setBounds(90, 40, 130, 20);

	

		lblcId = new JLabel("<html><i><b>Staff. ID:</i></b></html>");
		lblcId.setForeground(Color.white);
		lblcId.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblcId).setBounds(10, 16, 180, 120);
		String txt= "ggts1";
		String txt1=txt.toUpperCase();
		txtstaffID = new JTextField(txt1);
		txtstaffID.setEditable(false);
		txtstaffID.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtstaffID.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(txtstaffID).setBounds(90, 68, 130, 20);
		
		
		btnOk = new JButton(new ImageIcon("images//sam.gif"));
		pAdmin.add(btnOk).setBounds(225, 65, 38, 25);
		btnOk.addActionListener(this);
		
		
		
		
		lblposition = new JLabel("<html><i><b>Position:</i></b></html>");
		lblposition.setForeground(Color.white);
		lblposition.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblposition).setBounds(250, -40, 180, 120);
		jcmbposition = new JComboBox(name);
		jcmbposition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		jcmbposition.setFont(new Font("Algerian", Font.ITALIC, 14));
		//pAdmin.add(jcmbposition).setBounds(315, 12, 115, 20);
		
		
		lblpassword = new JLabel("<html><i><b>Password:</i></b></html>");
		lblpassword.setForeground(Color.white);
		lblpassword.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblpassword).setBounds(246, -10, 180, 120);
		
		
		
		
		
		txtpassword = new JPasswordField();
		txtpassword.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtpassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		//pAdmin.add(txtpassword).setBounds(315, 40, 115, 20);
		
		
		lblcfName = new JLabel("<html><b>Full Name :</i></b></html>");
		lblcfName.setForeground(Color.white);
		lblcfName.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		//pAdmin.add(lblcfName).setBounds(10, 45, 180, 120);
		txtfName = new JTextField();
		txtfName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtfName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {

					getToolkit().beep();
					ke.consume();
				}

			}
		});
		//pAdmin.add(txtfName).setBounds(90, 96, 340, 20);
	
		lblEmail = new JLabel("<html><b>Email :</i></b></html>");
		lblEmail.setForeground(Color.white);
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblEmail).setBounds(10, 75, 180, 120);
		txtemail = new JTextField();
		txtemail.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtemail.addKeyListener(new KeyAdapter() {
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
		//pAdmin.add(txtemail).setBounds(90, 125, 230, 20);
	
		lblpNumber = new JLabel("<html><b>Phone Num:</i></b></html>");
		lblpNumber.setForeground(Color.white);
		lblpNumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		//pAdmin.add(lblpNumber).setBounds(10, 156, 180, 20);
		txtpNumber = new JTextField();
		txtpNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
						|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
					getToolkit().beep();
					ke.consume();

				}
			}
		});
		txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		//pAdmin.add(txtpNumber).setBounds(90,158,230,20);
		
		
		lblGender = new JLabel("<html><b>Gender :</i></b></html>");
		lblGender.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblGender.setForeground(Color.white);
		//pAdmin.add(lblGender).setBounds(10, 190, 100, 20);
	

		cbmf = new CheckboxGroup();
		cbm = new Checkbox("Male", cbmf, true);
		cbf = new Checkbox("Female", cbmf, false);
		cbm.setBounds(94, 193, 50, 20);
		//add(cbm);
		cbf.setBounds(190, 193, 80, 20);
		//add(cbf);

		lblrAddress = new JLabel("<html><b>Res. Address:</i></b></html>");
		lblrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblrAddress.setForeground(Color.white);
		//pAdmin.add(lblrAddress).setBounds(10, 220, 80, 25);


		//JScrollPane p=new JScrollPane();
		txtrAddress=new JTextArea();
		txtrAddress.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE)||(c == KeyEvent.VK_SPACE))) {

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
		txtrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		//pAdmin.add(txtrAddress).setBounds(90, 224, 370, 100);
	
		
		
		btnSave = new JButton("Save");
		//pAdmin.add(btnSave).setBounds(0, 334, 65, 25);
		btnNew = new JButton("New");
		//pAdmin.add(btnNew).setBounds(69, 334, 60, 25);
		btnModify = new JButton("Modify");
		//pAdmin.add(btnModify).setBounds(135,334, 80, 25);

		btnPreview = new JButton("Preview");
		//pAdmin.add(btnPreview).setBounds(225, 334, 80, 25);
		btnRemove = new JButton("Remove");
		//pAdmin.add(btnRemove).setBounds(310, 334, 85, 25);
		btnExit = new JButton("Exit");
		//pAdmin.add(btnExit).setBounds(399, 334, 75, 25);
		cont=getContentPane();
	    
		cont.add( new textstaffreg(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);
	


		String url = "jdbc:mysql://localhost:3306/ggtelecom";
		try {
			
			
		conn = DriverManager.getConnection(url,"root","");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		
		}
	void chkid(){
		
		
		 try{
				
				
				stmt=conn.createStatement();
				rs = stmt.executeQuery("select * from staffadminreg  ");
				
					while(rs.next()){
					    
					     int sn=Integer.parseInt(rs.getString("s/n"));
					     if(sn==0){
					    	 System.out.println(sn);
						
					}
		
					     int sn1=sn+1;
					 	txtstaffID.setText(txt1+""+sn1);
					}}
					catch (Exception e) {
						// TODO: handle exception
				
		
		 
	 }}
	
	
	
	void visible(){
		pAdmin.add(lblposition).setBounds(250, -40, 180, 120);
		pAdmin.add(jcmbposition).setBounds(315, 12, 115, 20);
		pAdmin.add(lblpassword).setBounds(246, -10, 180, 120);
		pAdmin.add(txtpassword).setBounds(315, 40, 115, 20);
		pAdmin.add(lblcfName).setBounds(10, 45, 180, 120);
		pAdmin.add(txtfName).setBounds(90, 96, 340, 20);
		pAdmin.add(lblEmail).setBounds(10, 75, 180, 120);
		pAdmin.add(txtemail).setBounds(90, 125, 230, 20);
		pAdmin.add(lblpNumber).setBounds(10, 156, 180, 20);
		pAdmin.add(lblGender).setBounds(10, 190, 70, 20);
		pAdmin.add(cbm);pAdmin.add(cbf);
		pAdmin.add(lblrAddress).setBounds(10, 220, 80, 25);
		
		pAdmin.add(btnSave).setBounds(0, 334, 65, 25);
		pAdmin.add(btnNew).setBounds(69, 334, 60, 25);
		pAdmin.add(btnModify).setBounds(135,334, 80, 25);
		pAdmin.add(btnPreview).setBounds(225, 334, 80, 25);
		pAdmin.add(btnRemove).setBounds(310, 334, 85, 25);
		pAdmin.add(btnExit).setBounds(399, 334, 75, 25);
		pAdmin.add(txtrAddress).setBounds(90, 224, 370, 100);
		pAdmin.add(txtpNumber).setBounds(90,158,230,20);
		
	}
	
	void clearText(){
		txtfName.setText("");
		txtemail.setText("");
		txtrAddress.setText("");
		txtpNumber.setText("");
		
		jcmbposition.setSelectedIndex(0);
		txtrAddress.setText("");}
	
	
	void insertUpdate(){
		
			
			
				if(txtemail.getText().contains("@")){
				}else{
					JOptionPane.showMessageDialog(null, "Invalid Email Address");	
					
					
					//System.out.println("Invalid email");
				}
			
		
				
				if(txtstaffID.getText().length()==0 ||txtstaffID.getText().equals("GGTC")){
					//System.out.println("invalid ID or empty Field");
				JOptionPane.showMessageDialog(null, "invalid ID or empty Field");	
				}
				else if(txtpNumber.getText().length()!=11 ){
						//System.out.println("Invalid Number");
						JOptionPane.showMessageDialog(null, "Invalid Number");	
						
					}
				else if(txtfName.getText().equals("")||txtemail.getText().equals("")||txtrAddress.getText().equals("")){
				//	System.out.println("fill all empty field");
					JOptionPane.showMessageDialog(null, "fill all empty field");	
					
				}
				
				else if(jcmbposition.getSelectedItem().equals("Select")){
					//System.out.println("Invalid Selection");
					JOptionPane.showMessageDialog(null, "fill all empty field");
					}
					
				
				else{
				String gender1="";

				if(cbm.getState()==true)
					{
						gender1="Male";
					}
				if(cbf.getState()==true)
					{
						gender1="Female";
					}
				String sql="INSERT INTO staffadminreg(date,time,staffid,position,password,fname,email,pnumber,gender,address)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+jcmbposition.getSelectedItem()+"','"+txtpassword.getText()+"','"+txtfName.getText()+"','"+txtemail.getText()+"','"+txtpNumber.getText()+"','"+gender1+"','"+txtrAddress.getText()+"')";
				
				try{
					ps=conn.prepareStatement(sql);
					//System.out.println("sas");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Saved into Database");
					clearText();

					ps.close();
				}catch (SQLException e1) {
					System.out.println("uuuuuuuuuuuuuuuu");
					// TODO Auto-generated catch block
					e1.printStackTrace();
		}}
				}
		
		
		
	
	public static void main(String[] args) {
		staffregistration sam = new staffregistration();
		sam.setSize(480, 420);
		sam.setVisible(true);
		sam.setResizable(false);
		sam.setLocationRelativeTo(null);

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
if(obj==btnSave){
	insertUpdate();
	
}else if(obj==btnOk){
	chkid();visible();
}
		}
	
	}