/*package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class contributor_registration extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	ResultSet rs = null;
	Statement stmt = null;
	Container cont;
	Connection con = null;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime, lblcId, lblcfName, lblGender,lblaType,
			lblEmail, lblrAddress, lblpNumber, lblnkName, lblnkNumber,
			lblofficialinfo, 	lblaName, lblaNumber,lblbName;
	JLabel lbl1, lbldd;

	private JTextArea txtrAddress;
	String [] account_type={"Select Bank type","Saving","Current","Domicilary Account","Non Resident Nigerian (NRN)","Fixed Deposit Account"};
	int num=0001;
	//String txt= "ggtc"+num;
	String txting = "ggtc";
	String txt1=txting.toUpperCase();
	private JTextField txtDate, txtTime, txtstaffID, txtfName, txtemail,
			txtpNumber, txtnkNumber, txtnkName,txtaName, txtaNumber, txtbName,
			txttype;
	TextArea txtOthers;
	PreparedStatement ps = null;

	private JComboBox jcmbaType;

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,btnOk,
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
	public contributor_registration() {
		pAdmin =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//plain.jpg");
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

	

		lblcId = new JLabel("<html><i><b>Cont. ID:</i></b></html>");
		lblcId.setForeground(Color.white);
		lblcId.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblcId).setBounds(10, 16, 180, 120);
		String txt= "ggtc1";
		String txt1=txt.toUpperCase();
		txtstaffID = new JTextField(txt1);
		txtstaffID.setEditable(false);
		txtstaffID.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtstaffID.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtstaffID.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' )) {
					
					 	getToolkit().beep ();
					ke.consume ();
				}
				}
		}
		);
		pAdmin.add(txtstaffID).setBounds(90, 68, 130, 20);
		
		
		btnOk = new JButton(new ImageIcon("images//sam.gif"));
		pAdmin.add(btnOk).setBounds(214, 65, 38, 25);
		btnOk.addActionListener(this);
		
		
		
		
		
		
		
		
		
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
	//	cbm.setBounds(94, 225, 50, 15);
		add(cbm);
		//cbf.setBounds(190, 225, 80, 15);
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
		txtrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		//txtrAddress.setBounds(90, 224, 370, 100);
		pAdmin.add(txtrAddress);
		
		lblnkName = new JLabel("<html><i><b>Next of Kin Name :</i></b></html>");
		lblnkName.setForeground(Color.white);
		lblnkName.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		//pAdmin.add(lblnkName).setBounds(0, 280, 180, 120);
		txtnkName= new JTextField();
		txtnkName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkName.setFont(new Font("Algerian", Font.ITALIC, 14));
		//pAdmin.add(txtnkName).setBounds(90, 332, 290, 20);
		
		lblnkNumber = new JLabel("<html><i><b>Next of Kin Number :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		//pAdmin.add(lblnkNumber).setBounds(0,310, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.setFont(new Font("Algerian", Font.ITALIC, 14));
		//pAdmin.add(txtnkNumber).setBounds(115, 360, 265, 20);
		
		
		lblofficialinfo = new JLabel("<html><i><b>Official Portal(Bank Details-Optional)</i></b></html>");
		lblofficialinfo.setForeground(Color.red);
		lblofficialinfo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		//pAdmin.add(lblofficialinfo).setBounds(40,338, 300, 120);
		

		lblaName = new JLabel("<html><i><b>Account Name :</i></b></html>");
		lblaName.setForeground(Color.white);
		lblaName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblaName).setBounds(40,370, 180, 120);
		txtaName = new JTextField();
		txtaName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtaName.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		//pAdmin.add(txtaName).setBounds(160, 422, 290, 20);
		
	lblaNumber = new JLabel("<html><i><b>Account Number :</i></b></html>");
		lblaNumber.setForeground(Color.white);
		lblaNumber.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblaNumber).setBounds(30,400, 180, 120);
		txtaNumber = new JTextField();
		txtaNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtaNumber.setFont(new Font("Times New RomanAlgerian", Font.ITALIC, 14));
		//pAdmin.add(txtaNumber).setBounds(160, 450, 290, 20);
		
		lblaType = new JLabel("<html><i><b>Act. Type :</i></b></html>");
		lblaType.setForeground(Color.white);
		lblaType.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		//pAdmin.add(lblaType).setBounds(0,430, 180, 120);
		
		jcmbaType = new JComboBox(account_type);
		jcmbaType.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		jcmbaType.setFont(new Font("Times New Roman",Font.ITALIC,12));
		//pAdmin.add(jcmbaType).setBounds(54, 480, 145, 22);
		
		
		lblbName = new JLabel("<html><i><b>Bank Name :</i></b></html>");
		lblbName.setForeground(Color.white);
		lblbName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		//pAdmin.add(lblaName).setBounds(215,430, 180, 120);
		txtbName = new JTextField();
		txtbName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtbName.setFont(new Font("Times New RomanAlgerian", Font.ITALIC, 12));
		//pAdmin.add(txtbName).setBounds(296, 480, 185, 20);
		

		btnSave = new JButton("Save");
		//pAdmin.add(btnSave).setBounds(0, 507, 65, 25);
		btnNew = new JButton("New");
		//pAdmin.add(btnNew).setBounds(69, 507, 60, 25);
		btnModify = new JButton("Modify");
		//pAdmin.add(btnModify).setBounds(135, 507, 80, 25);

		btnPreview = new JButton("Preview");
		//pAdmin.add(btnPreview).setBounds(225, 507, 80, 25);
		btnRemove = new JButton("Remove");
		//pAdmin.add(btnRemove).setBounds(310, 507, 85, 25);
		btnExit = new JButton("Exit");
		//pAdmin.add(btnExit).setBounds(399, 507, 75, 25);
		cont=getContentPane();
	    //visible();
	    chkid();
	   // visible();
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
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
	}
	
	
	void visible(){
		pAdmin.add(lblcfName).setBounds(10, 45, 180, 120);
		pAdmin.add(txtfName).setBounds(90, 96, 340, 20);
		pAdmin.add(lblEmail).setBounds(10, 75, 180, 120);
		pAdmin.add(txtemail).setBounds(90, 125, 230, 20);
		pAdmin.add(lblpNumber).setBounds(10, 156, 180, 20);
		pAdmin.add(txtpNumber).setBounds(90,158,230,20);
		pAdmin.add(lblGender).setBounds(10, 190, 100, 20);
		cbm.setBounds(94, 225, 50, 15);
	cbf.setBounds(190, 225, 80, 15);
				add(cbf);
				txtstaffID.setEditable(false);
				pAdmin.add(lblrAddress).setBounds(10, 220, 80, 25);
				pAdmin.add(lblnkName).setBounds(0, 280, 180, 120);
				pAdmin.add(txtnkName).setBounds(90, 332, 290, 20);
				txtrAddress.setBounds(90, 224, 370, 100);
				pAdmin.add(lblnkNumber).setBounds(0,310, 180, 120);
				pAdmin.add(txtnkNumber).setBounds(115, 360, 265, 20);
				pAdmin.add(lblofficialinfo).setBounds(40,338, 300, 120);
				pAdmin.add(lblaName).setBounds(40,370, 180, 120);
				pAdmin.add(txtaName).setBounds(160, 422, 290, 20);
				pAdmin.add(lblaNumber).setBounds(30,400, 180, 120);
				pAdmin.add(txtaNumber).setBounds(160, 450, 290, 20);
				pAdmin.add(lblaType).setBounds(0,430, 180, 120);
				pAdmin.add(jcmbaType).setBounds(54, 480, 145, 22);
				pAdmin.add(lblbName).setBounds(215,430, 180, 120);
				pAdmin.add(btnSave).setBounds(0, 507, 65, 25);
				pAdmin.add(btnNew).setBounds(69, 507, 60, 25);
				pAdmin.add(btnModify).setBounds(135, 507, 80, 25);
				pAdmin.add(btnPreview).setBounds(225, 507, 80, 25);
				pAdmin.add(btnRemove).setBounds(310, 507, 85, 25);
				pAdmin.add(btnExit).setBounds(399, 507, 75, 25);
	}
	
	if(userID.equals(txtstaffID.getText())){
	     JOptionPane.showMessageDialog(null,"Product Code Already taken");
	   }
	void chkid(){
		
		
		//txtstaffID.setText(txt1);
		 try{
				
				
				stmt=con.createStatement();
				rs = stmt.executeQuery("select * from contributorreg  ");
				
					//System.out.println("ssssssss");
			
			
					while(rs.next()){
					     //String userID=rs.getString("cid");
					    // String sn=rs.getString("s/n");
					     int sn=Integer.parseInt(rs.getString("s/n"));
					     if(sn==0){
					    	 System.out.println(sn);
								//txtstaffID.setText(sn);
					//String s=userID+1;
								
								//double dtoLitre=Double.parseDouble(txtoCounter.getText());
								
					//txtstaffID.setText(s);
					}
			//txtstaffID.setText(txt1);
					     int sn1=sn+1;
					 	txtstaffID.setText(txt1+""+sn1);
					}}
					catch (Exception e) {
						// TODO: handle exception
				
		// visible();
		 
	 }}
	void retrieve(){
		
		try{
		
		
	
			
			if(txtstaffID.getText().length()==0 ||txtstaffID.getText().equals("GGTC")){
				System.out.println("invalid ID or empty Field");
				
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
		 String sql="INSERT INTO contributorreg(date,time,cid,fname,email,cpnumber,gender,residentialaddress,nextofkinname,nextofkinnumber,actname,actnumber,acttype,bname)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtfName.getText()+"','"+txtemail.getText()+"','"+txtpNumber.getText()+"','"+gender1+"','"+txtrAddress.getText()+"','"+txtnkName.getText()+"','"+txtnkNumber.getText()+"','"+txtaName.getText()+"','"+txtaNumber.getText()+"','"+jcmbaType.getSelectedItem()+"','"+txtbName.getText()+"')";
	    
			
				ps=con.prepareStatement(sql);
				//System.out.println("sas");
				ps.executeUpdate();
				System.out.println("Saved");

				ps.close();
			}}catch (SQLException e1) {
				System.out.println("uuuuuuuuuuuuuuuu");
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
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
			 String sql="INSERT INTO contributorreg(date,time,cid,fname,email,cpnumber,gender,residentialaddress,nextofkinname,nextofkinnumber,actname,actnumber,acttype,bname)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtfName.getText()+"','"+txtemail.getText()+"','"+txtpNumber.getText()+"','"+gender1+"','"+txtrAddress.getText()+"','"+txtnkName.getText()+"','"+txtnkNumber.getText()+"','"+txtaName.getText()+"','"+txtaNumber.getText()+"','"+jcmbaType.getSelectedItem()+"','"+txtbName.getText()+"')";
		    
				try {
					ps=con.prepareStatement(sql);
					//System.out.println("sas");
					ps.executeUpdate();
					System.out.println("Saved");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		}}}
		catch (Exception e) {
			// TODO: handle exception
		}	}
void insertinfo(){


	if(txtstaffID.getText().length()==0 ||txtstaffID.getText().equals("GGTC")){
  		System.out.println("invalid ID");
  	
  	}
	else if(txtfName.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Invalid ");
		
		
	}
	else{
		//retrieve();
	
	}
	}
	public static void main(String[] args) {
		contributor_registration sam = new contributor_registration();
		sam.setSize(490, 593);
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
	//retrieve();
	
}else if(obj==btnOk){
	
	chkid();
	visible();
	
	
	
}
		}
	
	}*/