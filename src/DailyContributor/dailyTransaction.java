package project1;



import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings({ "serial", "unused" })
public class dailyTransaction extends JFrame implements ActionListener {
JPanel pane=new JPanel();
Statement stmt;
PreparedStatement ps;
int coc3;
JTextField txtoCounter,txtcCounter;
JTextField txtLitre,txtppLitre,txttime,txtdate,txtsId,txtfName,txtEmail,txtpNumber,txtSale;
JLabel lbloCounter,lblcCounter,lblLitre,lblPump,lblnNumber,lblProduct;
Choice cPump,cnNumber,cProduct;
JButton btnSave,btnCancel,btnClear,btnok,btnPreview, btnSearch,btnCalculate,btnRemove,btnModify;
TextArea txtAddress,txtReport;
Connection con=null;
Statement st=null;
							//Storing Date.
JTable table;
private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);
String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());
String[] name={"Select","PMS","AGO","DPK"};
	

dailyTransaction(){
		
		setTitle("Daily Transaction");
	Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
	setIconImage(img);

//super("daily Staff Record",false,true,false,true);
setSize(745,410);
setLocation(0,149);
/*
addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			
			StaffsInfo sam=new StaffsInfo();
			sam.setVisible(true);
			StaffsInfo.setDefaultLookAndFeelDecorated(true);
			setVisible(false);
			
			
			
		}
	});*/
pane.setLayout(null);


lbloCounter=new JLabel("Opening Metre :");
pane.add(lbloCounter).setBounds(10, 46, 300, 20);
txtoCounter=new JTextField();
txtoCounter.setEditable(false);
txtoCounter.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
			 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
			            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
			getToolkit().beep ();
			ke.consume ();
		}
	}
}}
);
pane.add(txtoCounter).setBounds(120, 48, 100, 20);



lblcCounter=new JLabel("Closing Metre :");
pane.add(lblcCounter).setBounds(240, 46, 100, 25);
txtcCounter=new JTextField();
txtcCounter.setEditable(false);
txtcCounter.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
			 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
			            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
			getToolkit().beep ();
			ke.consume ();
		}
	}
}}
);
pane.add(txtcCounter).setBounds(350, 48, 100, 20);

JLabel lblppLitre=new JLabel("Price /Lit. :");
pane.add(lblppLitre).setBounds(480, 15, 119, 25);
txtppLitre=new JTextField();
txtppLitre.setEditable(false);
txtppLitre.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
			 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
			            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
			getToolkit().beep ();
			ke.consume ();
		}
	}
}}
);
pane.add(txtppLitre).setBounds(550, 17, 70, 20);


JLabel lblst=new JLabel("<html><i>Click the calculate button before saving the details<i/></html>");
lblst.setForeground(Color.red);
pane.add(lblst).setBounds(380, 0, 300, 20);



btnCalculate=new JButton("Calculate");
pane.add(btnCalculate).setBounds(633, 16, 90, 20);
btnCalculate.addActionListener(this);
btnCalculate.setVisible(false);


 btnSearch=new JButton("Search Staff Details");
pane.add(btnSearch).setBounds(633, 55, 150, 20);
btnSearch.addActionListener(this);








JLabel lblst1=new JLabel("===============================================================================================================");

pane.add(lblst1).setBounds(10, 77, 800, 5);
  











JLabel lbldate=new JLabel("Date :");
pane.add(lbldate).setBounds(15, 90, 119, 25);

txtdate=new JTextField(d);
pane.add(txtdate).setBounds(58, 94, 80, 20);
txtdate.setEditable(false);

JLabel lbltime=new JLabel("Time :");
pane.add(lbltime).setBounds(15, 120, 119, 25);

txttime=new JTextField(timeStamp);
pane.add(txttime).setBounds(58, 124, 80, 20);
txttime.setEditable(false);

JLabel lblsale=new JLabel("Sale{N}:");
pane.add(lblsale).setBounds(10, 150, 119, 25);

txtSale=new JTextField();
pane.add(txtSale).setBounds(58, 154, 80, 20);
txtSale.setEditable(false);

lblLitre=new JLabel("Litre Sold:");
pane.add(lblLitre).setBounds(0, 180, 70, 25);


txtLitre=new JTextField( );

pane.add(txtLitre).setBounds(58, 184, 70, 20);

txtLitre.setEditable(false);

lblPump=new JLabel("Pump :");
pane.add(lblPump).setBounds(21, 210, 40, 25);
lblPump.setForeground(Color.WHITE);

cPump=new Choice();
cPump.add("Select");
cPump.add("A");cPump.add("B");cPump.add("C");cPump.add("D");cPump.add("E");
pane.add(cPump).setBounds(72, 212, 60, 25);

lblnNumber=new JLabel("Nozzle No.:");
pane.add(lblnNumber).setBounds(2, 235, 70, 25);

cnNumber=new Choice();
cnNumber.add("Select");
cnNumber.add("1");cnNumber.add("2");cnNumber.add("3");cnNumber.add("4");cnNumber.add("5");cnNumber.add("6");
cnNumber.add("7");cnNumber.add("8");cnNumber.add("9");cnNumber.add("10");
pane.add(cnNumber).setBounds(72, 237, 60, 25);


lblProduct=new JLabel("Product:");
pane.add(lblProduct).setBounds(16, 259, 50, 25);
lblProduct.setForeground(Color.white);

cProduct=new Choice();
cProduct.add("Select");
cProduct.setFont(new Font("Times New Roman",Font.ITALIC,13));
cProduct.add("PMS");cProduct.add("AGO");cProduct.add("DPK");
pane.add(cProduct).setBounds(72, 261, 60, 25);





////////////////////////////


JLabel lblsId=new JLabel("Staff ID :");
pane.add(lblsId).setBounds(500, 55, 119, 25);
txtsId=new JTextField();
txtsId.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE ))) {
			 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
			            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' )) {
			
			 	getToolkit().beep ();
			ke.consume ();
		}}
	
}}
);
pane.add(txtsId).setBounds(550, 55, 80, 20);


JLabel lblname=new JLabel("Name:");
pane.add(lblname).setBounds(260, 105, 119, 25);
txtfName=new JTextField();
txtfName.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_SPACE))) {
			 	getToolkit().beep ();
			ke.consume ();
		}
	
}}
);
txtfName.setEditable(false);

pane.add(txtfName).setBounds(320, 107, 220, 25);

JLabel lblnumber=new JLabel("Contact :");
pane.add(lblnumber).setBounds(260, 130, 119, 25);
txtpNumber=new JTextField();
txtpNumber.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE ))) {
			 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
			            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
			getToolkit().beep ();
			ke.consume ();
		}
	}
}}
);
txtpNumber.setEditable(false);
pane.add(txtpNumber).setBounds(320, 133, 180, 20);

JLabel lblemail=new JLabel("Email :");

pane.add(lblemail).setBounds(260, 155, 119, 25);
txtEmail=new JTextField();
txtEmail.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
			if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
		            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'||c=='@'||c=='_'||c=='-')) {
		
			 	getToolkit().beep ();
			ke.consume ();
		}
	
}}}
);
pane.add(txtEmail).setBounds(320, 157, 220, 20);
txtEmail.setEditable(false);


JLabel lbladdress=new JLabel("Address :");
pane.add(lbladdress).setBounds(260, 180, 60, 25);


//JScrollPane p=new JScrollPane();
txtAddress=new TextArea();
txtAddress.addKeyListener (new KeyAdapter () {
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
txtAddress.setBounds(320, 187, 300, 65);
pane.add(txtAddress);

txtAddress.setEditable(false);

JLabel lblReport=new JLabel("<html><i>Expenses:");
lblReport.setForeground(Color.white);
pane.add(lblReport).setBounds(255, 260, 60, 25);

txtReport=new TextArea();
txtReport.addKeyListener (new KeyAdapter () {
	public void keyTyped (KeyEvent ke) {
		char c = ke.getKeyChar ();
		
		if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE ||c==KeyEvent.VK_SPACE))) {

			if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
		            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c=='.'||c==','||c==':' ||c==';')) {
			
			 	getToolkit().beep ();
			ke.consume ();
		}
		}
}}
);
txtReport.setFont(new Font("Comic Sans MS",Font.ITALIC,15));
txtReport.setBounds(320, 262, 390, 110);
pane.add(txtReport);






btnSave=new JButton("Save");
pane.add(btnSave).setBounds(0, 300, 80, 20);
btnSave.addActionListener(this);

btnPreview =new JButton("Preview");
pane.add(btnPreview).setBounds(90, 300, 80, 20);
btnPreview.addActionListener(this);

btnModify =new JButton("Modify");
pane.add(btnModify).setBounds(180, 300, 80, 20);
btnModify.addActionListener(this);



btnRemove =new JButton("Remove");
pane.add(btnRemove).setBounds(0, 330, 80, 20);
btnRemove.addActionListener(this);


btnClear=new JButton("Clear");
pane.add(btnClear).setBounds(90, 330, 80, 20);
btnClear.addActionListener(this);



btnCancel=new JButton("Cancel");
pane.add(btnCancel).setBounds(180, 330, 80, 20);
btnCancel.addActionListener(this);
//btnok.addActionListener(this);


	JLabel lblimage = new JLabel(new ImageIcon("images//lightblue.jpg"));
	
	lblimage.setBounds(0,0,1000,500);
pane.add(lblimage);
	
	
	

	getContentPane().add(pane,BorderLayout.CENTER);		
	
	
	
	
		}
		
		
	
	


	public void actionPerformed(ActionEvent e) {
		

		
		Object obj = e.getSource();
		try{
		if(obj==btnCalculate){
			

			
			double dtoLitre=Double.parseDouble(txtoCounter.getText());
				double dtcLitre=Double.parseDouble(txtcCounter.getText());
				 txtLitre.setText(String.format("%.2f", ((dtcLitre)-(dtoLitre))));
				double dtLitre =  Double.parseDouble(txtppLitre.getText());
			txtSale.setText(String.format("%.2f", (((dtcLitre-dtoLitre)*(dtLitre)))));
			
	JOptionPane.showMessageDialog(btnok, "<html><i>\nThe total litre sold is " +txtLitre.getText()+ "\nand the Sale(Amount) is "+txtSale.getText()+ " NAIRA");

SearchRecord();

}
		}	
catch(Exception ex){
	JOptionPane.showMessageDialog(btnok, "<html><i>Opening Counter field,\n Closing Counter field \n Price per litre field \n staff id field can't be empty ");
	
	//JOptionPane.showMessageDialog(btnok, "Opening Counter field,\n Closing Counter field \n Price per litre field \n staff id field can't be empty ");
	
}
		
		 if(obj==btnPreview){
			 daily_Trans_report sa=new daily_Trans_report();
				sa.setSize(1200, 520);
				sa.setLocation(12, 10);
				sa.setVisible(true);
				setVisible(false);
				
		}
		
			
		 if(obj==btnCancel){
				StaffsInfo sam=new StaffsInfo();
				sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
		}
		else if(obj==btnClear){
			clearText();
		}
		 
		if(obj==btnModify){
				
				ModifyInfo s=new ModifyInfo();
				s.setVisible(true);
				s.setLocation(100,100);
				s.setSize(1200,520);
				setVisible(false);
		}
		 
		else if(obj==btnSearch){
			SearchRecord();
			 btnSearch.setVisible(false);
			btnCalculate.setVisible(true);
			txtsId.setEditable(false);
			txtoCounter.setEditable(true);
			txtcCounter.setEditable(true);
			txtppLitre.setEditable(true);
			
			
			
			 		 
		}
		 
		 if(obj==btnSave){


			 insertUpdate();
		 
		
					 
		 }}
					
				
		
			public void insertUpdate(){
				

				String url = "jdbc:mysql://localhost:3306/rakedomanagement";
				try {
					/*con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
				            "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
					*/
					con = DriverManager.getConnection(url,"root","");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		 if(cPump.getSelectedItem().equalsIgnoreCase("Select") || cnNumber.getSelectedItem().equalsIgnoreCase("Select")  ){
			 JOptionPane.showMessageDialog(btnSave, "<html><i>pump,nozzle number and product can't be in their default value\"select\"" );} 
		 
		 
		 else if(txtoCounter.getText().equals("")||txtcCounter.getText().equals("")||txtppLitre.getText().equals("")||txtsId.getText().equals("")||txtSale.getText().equals("")||txtLitre.getText().equals("")||txtfName.getText().equals("")||txtpNumber.getText().equals("")||txtEmail.getText().equals("")||txtAddress.getText().equals("")||txtReport.getText().equals("")){
			 JOptionPane.showMessageDialog(btnSave, "<html><i>Fill all an empty Fields");
		 }
		 

			 else{
				

			 try {
				 stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					
				 
				 
				 String sql=" INSERT INTO `dailystaffreport`(`staffid`, `fname`, `phone`, `email`, `oCounter`, `cCounter`, `ppLitre`, `date`, `time`, `sale`, `litre`, `product`, `pump`, `nozzle`, `address`,`report`) VALUES ('"+txtsId.getText()+"','"+txtfName.getText()+"','"+txtpNumber.getText()+"','"+txtEmail.getText()+"','"+txtoCounter.getText()+"','"+txtcCounter.getText()+"','"+txtppLitre.getText()+"','"+txtdate.getText()+"','"+txttime.getText()+"','"+txtSale.getText()+"','"+txtLitre.getText()+"','"+cProduct.getSelectedItem()+"','"+cPump.getSelectedItem()+"','"+cnNumber.getSelectedItem()+"','"+txtAddress.getText()+"','"+txtReport.getText()+"')";
					
			ps=con.prepareStatement(sql);
				 ps.executeUpdate();
				 
			 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    
					
			
       JOptionPane.showMessageDialog(btnSave, "Saved into database");
     
    		      		    dispose();
    		      		         
    		      		      }                              
    		      		      
    		      			      
				
			}
		

	
	

	
void clearText(){
	txtppLitre.setText(" ");
	txtsId.setText(" ");
	txtfName.setText("");
	txtEmail.setText("");
	txtpNumber.setText("");
	
txtAddress.setText(" ");

}

public  void SearchRecord(){
     
	   String url = "jdbc:mysql://localhost:3306/rakedomanagement";
	  
	   
	   try {
		con = DriverManager.getConnection(url,"root","");
		//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
	         //   "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
		
	   
		
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		
	}
		String staffid=null,fname=null,phone=null,email=null,address=null;
		
		  String query = "select * from staff where staffid like '"+txtsId.getText()+"'";
          
 
 
try{
     st = con.createStatement();
     ResultSet rs = st.executeQuery(query);
     
while(rs.next()){
    
 staffid = rs.getString("staffid");
 
fname= rs.getString("fName");

phone = rs.getString("phone");

   email = rs.getString("email");
   address = rs.getString("address");
    
}
//st.close();
//con.close();

}catch(Exception ex){

System.err.println(ex.getMessage());
}

txtsId.setText(staffid);

txtfName.setText(fname);
txtpNumber.setText(phone);

txtEmail.setText(email);
txtAddress.setText(address);
//txtLitre.setText(c);

if(txtfName .getText().equals("") && txtsId.getText().equals("") &&  txtEmail.getText().equals("")&&  txtAddress.getText().equals("") ){

	txtfName.setText("");
    txtEmail.setText("");
    txtpNumber.setText("");
    txtAddress.setText("");
    
    
   
    
    
    
}
else
{
	 txtfName.setText(fname);
   
    txtEmail.setText(email);
    txtpNumber.setText(phone);
    
    txtAddress.setText(address);
    
}
try{
st.close();
con.close();} 
catch(Exception ex){
	System.out.println("error");
}

}


class ModifyInfo extends JFrame
{
	Container c=getContentPane();
	JTable stud;
	JPanel main;
	DefaultTableModel model;
	ModifyDialog mdl;
	String stcode;
	ModifyInfo()
	{
		
		setTitle("Discharge Information");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				 discharge_or sam=new discharge_or();
					sam.setVisible(true);
				dis_charge_report.setDefaultLookAndFeelDecorated(true);
				setVisible(false);}});
	
		ModifyInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Row To Modify");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//HEADER.gif");
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
				
				g.drawImage(img,0,0,1200,520,null);
			}
		};
		title.add(l);
		c.add("North",title);

		main=new JPanel();
		main.setLayout(new BorderLayout());
		
		try
		{
			 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
 			
 			con = DriverManager.getConnection(url,"root","");
 			st=con.createStatement();
			ResultSet set=st.executeQuery("select * from dailystaffreport");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"staffid","fname","phone","email","oCounter","cCounter","ppLitre","date","time","Sale","litre","product","pump","nozzle","address","Remark"},row);
			
			
			
		 table=new JTable(model);
			set=st.executeQuery("select * from dailystaffreport");
			while(set.next())
			{
				model.setValueAt(set.getString(2).trim(),i,0);
				model.setValueAt(set.getString(1).trim(),i,1);
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
		table.addMouseListener(new ModifyStudList());
		table.setSelectionMode(0);
		table.setToolTipText("Select The ROW For Modify");
		table.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.MAGENTA);
		table.setGridColor(new Color(0,128,192));
	  //	table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}
		

	
	class ModifyStudList extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			int ro=table.getSelectedRow();
			stcode=(String)table.getValueAt(ro,0);
			mdl=new ModifyDialog(stcode);
			mdl.setVisible(true);
			setVisible(false);
		}
	}
		
	}
	
	
	

		class ModifyDialog extends JDialog implements ActionListener {
	
	
			JPanel pane=new JPanel();
			Statement stmt;
			PreparedStatement ps;
			int coc3;
			JTextField txtoCounter,txtcCounter;
			JTextField txtLitre,txtppLitre,txttime,txtdate,txtsId,txtfName,txtEmail,txtpNumber,txtSale;
			JLabel lbloCounter,lblcCounter,lblLitre,lblPump,lblnNumber,lblProduct;
			JComboBox cmbPump,cmbnNumber,cmbProduct;
			JButton btnSave,btnCancel,btnClear,btnok,btnPreview, btnSearch,btnCalculate,btnRemove,btnModify;
			TextArea txtAddress,txtReport;
			Connection con=null;
			Statement st=null;
			String mstud;
		/*	private java.util.Date currDate = new java.util.Date ();					//Creating Object.
			private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
			private String d = sdf.format (currDate);							//Storing Date.
			JTable table;
			String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar.getInstance().getTime());
			*/
			String[] name={"Select","PMS","AGO","DPK"};
		
				
				
			ModifyDialog(String s){
				mstud=s;
					setTitle("Daily Transaction");
				Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
				setIconImage(img);

			//super("daily Staff Record",false,true,false,true);
			setSize(745,410);
			setLocation(0,149);
			
			pane.setLayout(null);


			lbloCounter=new JLabel("Opening Counter :");
			pane.add(lbloCounter).setBounds(10, 46, 300, 20);
			txtoCounter=new JTextField();
			txtoCounter.setEditable(false);
			txtoCounter.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
						 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
						            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
						getToolkit().beep ();
						ke.consume ();
					}
				}
			}}
			);
			pane.add(txtoCounter).setBounds(120, 48, 100, 20);



			lblcCounter=new JLabel("Closing Counter :");
			pane.add(lblcCounter).setBounds(240, 46, 100, 25);
			txtcCounter=new JTextField();
			txtcCounter.setEditable(false);
			txtcCounter.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
						 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
						            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
						getToolkit().beep ();
						ke.consume ();
					}
				}
			}}
			);
			pane.add(txtcCounter).setBounds(350, 48, 100, 20);

			JLabel lblppLitre=new JLabel("Price /Lit. :");
			pane.add(lblppLitre).setBounds(480, 15, 119, 25);
			txtppLitre=new JTextField();
			txtppLitre.setEditable(false);
			txtppLitre.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
						 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
						            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||c=='.')) {
						getToolkit().beep ();
						ke.consume ();
					}
				}
			}}
			);
			pane.add(txtppLitre).setBounds(550, 17, 70, 20);


			JLabel lblst=new JLabel("<html><i>Click the calculate button before saving the details<i/></html>");
			lblst.setForeground(Color.red);
			pane.add(lblst).setBounds(380, 0, 300, 20);



			btnCalculate=new JButton("Calculate");
			pane.add(btnCalculate).setBounds(633, 16, 90, 20);
			btnCalculate.addActionListener(this);
			btnCalculate.setVisible(false);


			 btnSearch=new JButton("Search Staff Details");
			pane.add(btnSearch).setBounds(633, 55, 150, 20);
			btnSearch.addActionListener(this);








			JLabel lblst1=new JLabel("===============================================================================================================");

			pane.add(lblst1).setBounds(10, 77, 800, 5);
			  











			JLabel lbldate=new JLabel("Date :");
			pane.add(lbldate).setBounds(15, 90, 119, 25);

			txtdate=new JTextField();
			pane.add(txtdate).setBounds(58, 94, 80, 20);
			txtdate.setEditable(false);

			JLabel lbltime=new JLabel("Time :");
			pane.add(lbltime).setBounds(15, 120, 119, 25);

			txttime=new JTextField();
			pane.add(txttime).setBounds(58, 124, 80, 20);
			txttime.setEditable(false);

			JLabel lblsale=new JLabel("Sale{N}:");
			pane.add(lblsale).setBounds(10, 150, 119, 25);

			txtSale=new JTextField();
			pane.add(txtSale).setBounds(58, 154, 80, 20);
			txtSale.setEditable(false);

			lblLitre=new JLabel("Litre Sold:");
			pane.add(lblLitre).setBounds(0, 180, 70, 25);


			txtLitre=new JTextField( );

			pane.add(txtLitre).setBounds(58, 184, 70, 20);

			txtLitre.setEditable(false);

			lblPump=new JLabel("Pump :");
			pane.add(lblPump).setBounds(21, 210, 40, 25);
			lblPump.setForeground(Color.WHITE);

			cmbPump=new JComboBox();
			pane.add(cmbPump).setBounds(72, 214, 60, 15);

			lblnNumber=new JLabel("Nozzle No.:");
			pane.add(lblnNumber).setBounds(2, 235, 70, 25);
			cmbnNumber=new JComboBox();
			pane.add(cmbnNumber).setBounds(72, 239, 60, 15);


			lblProduct=new JLabel("Product:");
			pane.add(lblProduct).setBounds(16, 259, 50, 25);
			lblProduct.setForeground(Color.white);

			cmbProduct=new JComboBox();
			//cProduct.add("PMS");cProduct.add("AGO");cProduct.add("DPK");
			pane.add(cmbProduct).setBounds(72, 264, 120, 15);





			////////////////////////////


			JLabel lblsId=new JLabel("Staff ID :");
			pane.add(lblsId).setBounds(500, 55, 119, 25);
			txtsId=new JTextField();
			txtsId.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE ))) {
						 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
						            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' )) {
						
						 	getToolkit().beep ();
						ke.consume ();
					}}
				
			}}
			);
			pane.add(txtsId).setBounds(550, 55, 80, 20);


			JLabel lblname=new JLabel("Name:");
			pane.add(lblname).setBounds(260, 105, 119, 25);
			txtfName=new JTextField();
			txtfName.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_SPACE))) {
						 	getToolkit().beep ();
						ke.consume ();
					}
				
			}}
			);
			txtfName.setEditable(false);

			pane.add(txtfName).setBounds(320, 107, 220, 25);

			JLabel lblnumber=new JLabel("Contact :");
			pane.add(lblnumber).setBounds(260, 130, 119, 25);
			txtpNumber=new JTextField();
			txtpNumber.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE ))) {
						 if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
						            c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
						getToolkit().beep ();
						ke.consume ();
					}
				}
			}}
			);
			txtpNumber.setEditable(false);
			pane.add(txtpNumber).setBounds(320, 133, 180, 20);

			JLabel lblemail=new JLabel("Email :");

			pane.add(lblemail).setBounds(260, 155, 119, 25);
			txtEmail=new JTextField();
			txtEmail.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9'||c=='@'||c=='_'||c=='-')) {
					
						 	getToolkit().beep ();
						ke.consume ();
					}
				
			}}}
			);
			pane.add(txtEmail).setBounds(320, 157, 220, 20);
			txtEmail.setEditable(false);


			JLabel lbladdress=new JLabel("Address :");
			pane.add(lbladdress).setBounds(260, 180, 60, 25);


			//JScrollPane p=new JScrollPane();
			txtAddress=new TextArea();
			txtAddress.addKeyListener (new KeyAdapter () {
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
			txtAddress.setBounds(320, 187, 300, 65);
			pane.add(txtAddress);

			txtAddress.setEditable(false);

			JLabel lblReport=new JLabel("<html><i>Expenses:");
			lblReport.setForeground(Color.white);
			pane.add(lblReport).setBounds(255, 260, 60, 25);

			txtReport=new TextArea();
			txtReport.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					
					if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE ||c==KeyEvent.VK_SPACE))) {

						if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
					            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c=='.'||c==','||c==':' ||c==';')) {
						
						 	getToolkit().beep ();
						ke.consume ();
					}
					}
			}}
			);
			txtReport.setFont(new Font("Comic Sans MS",Font.ITALIC,15));
			txtReport.setBounds(320, 262, 390, 110);
			pane.add(txtReport);






			btnSave=new JButton("Save");
			pane.add(btnSave).setBounds(0, 300, 80, 20);
			btnSave.addActionListener(this);

			btnPreview =new JButton("Preview");
			pane.add(btnPreview).setBounds(90, 300, 80, 20);
			btnPreview.addActionListener(this);

			btnModify =new JButton("Modify");
			pane.add(btnModify).setBounds(180, 300, 80, 20);
			btnModify.addActionListener(this);



			btnRemove =new JButton("Remove");
			pane.add(btnRemove).setBounds(0, 330, 80, 20);
			btnRemove.addActionListener(this);


			btnClear=new JButton("Clear");
			pane.add(btnClear).setBounds(90, 330, 80, 20);
			btnClear.addActionListener(this);



			btnCancel=new JButton("Cancel");
			pane.add(btnCancel).setBounds(180, 330, 80, 20);
			btnCancel.addActionListener(this);
			//btnok.addActionListener(this);


				JLabel lblimage = new JLabel(new ImageIcon("images//plain.jpg"));
				
				lblimage.setBounds(0,0,1000,500);
			pane.add(lblimage);
				
				
				

				getContentPane().add(pane,BorderLayout.CENTER);		
		
		 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			
			try {
			con = DriverManager.getConnection(url,"root","");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			
			
			
	
			st=con.createStatement();
			
			
			ResultSet minfo=st.executeQuery("select * from dailystaffreport order by staffid");
			
			String stco="";
			while(minfo.next())
			{
				stco=minfo.getString(1).trim();
				if(stco.equals(mstud))
					break;}
			//txtsId.setText(stco);
			txttime.setText(stco);
			txtdate.setText(minfo.getString(8).trim());
			/*txtsId.setText(minfo.getString(3));
			txtfName.setText(minfo.getString(4));
			txtEmail.setText(minfo.getString(5));
			txtoCounter.setText(minfo.getString(6));
			txtcCounter.setText(minfo.getString(7));
			txtpNumber.setText(minfo.getString(8));
			txtppLitre.setText(minfo.getString(2));
			txtSale.setText(minfo.getString(10));
			txtLitre.setText(minfo.getString(11));
			cmbnNumber.setSelectedItem(minfo.getString(12));
			cmbPump.setSelectedItem(minfo.getString(13));
		cmbProduct.setSelectedItem(minfo.getString(14));
		txtReport.setText(minfo.getString(15));
			*/
			
		}
		catch(Exception ed)
		{
			ed.printStackTrace();
			
		}
				}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		}

public static void main(String[] args) {
	dailyTransaction s=new dailyTransaction();
	//s.setSize(799,410);
	s.setLocationRelativeTo(null);
	s.setVisible(true);
	s.setResizable(false);
	
}		
}
	



		
