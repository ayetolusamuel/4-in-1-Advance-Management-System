package DailyContributor;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;



class staffnadminloginpage extends JFrame implements ActionListener{
	private JLabel lbluserName,lblPassword;
	private JTextField txtuserName;
	private JPasswordField txtPassword;
	
	private Container cont;
	
	private JPanel pRegister;
	//private JTextField txtuserName,txtcsfName,txtsfName;
	String[] position={"Select","Admin","User","Manager"};
	String[] platform={"Select","Daily Contribution","",""};
Choice catt;
	JComboBox cmbsId;
	
	private JButton btnOK,btnLogin,btnCancel,btnQuit;
	Connection conn;
	Statement st;
ResultSet set;
	//private 

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());

	
	staffnadminloginpage(){
		pRegister =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//wall2.jpg");
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
				g.drawImage(img,0,0,400,230,null);
			}
		}
		
		
	;
		pRegister.setLayout(null);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		lbluserName =new JLabel("<html><i>UserName:");
		lbluserName.setForeground(Color.white);
		lbluserName.setFont(new Font("Times New Roman",Font.PLAIN,15));
		pRegister.add(lbluserName).setBounds(10, 30, 300, 25);
		txtuserName=new JTextField();
		txtuserName.setEditable(true);
		txtuserName.setFont(new Font("Times New Roman",Font.ITALIC,15));
		txtuserName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pRegister.add(txtuserName).setBounds(100, 32, 140, 20);
		
		
		
		
		lblPassword =new JLabel("<html><i>Password:");
		lblPassword.setForeground(Color.white);
		lblPassword.setVisible(true);
		lblPassword.setFont(new Font("Times New Roman",Font.PLAIN,15));
		pRegister.add(lblPassword).setBounds(10, 60, 300, 25);
		txtPassword = new JPasswordField();
		txtPassword.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pRegister.add(txtPassword).setBounds(100, 62, 140, 22);
		
		
	
		
		
		
		
		btnLogin=new JButton("<html><i>Login");
		btnLogin.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		btnLogin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pRegister.add(btnLogin).setBounds(20, 100, 70, 25);
		btnLogin.addActionListener(this);
		
		btnCancel=new JButton("<html><i>Cancel");
		btnCancel.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnCancel).setBounds(106, 100, 90, 25);
		btnCancel.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		btnCancel.addActionListener(this);
		
		btnQuit=new JButton("<html><i>Quit");
		btnQuit.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnQuit).setBounds(210, 100, 70, 25);
		btnQuit.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		btnQuit.addActionListener(this);
		
		cont=getContentPane();
	    
		cont.add( new textLoginPage(),BorderLayout.NORTH);
		
	getContentPane().add(pRegister,BorderLayout.CENTER);
	

	String url = "jdbc:mysql://localhost:3306/ggtelecom";
	try {
		
		
	conn = DriverManager.getConnection(url,"root","");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


}
	
	}
	
	//
	
	class TableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
			
			}
				catch (Exception e) {
					// TODO: handle exception
				}
			/*if(cmbAttendance.getSelectedItem().equals("Present") ){
				cmbCover1.setSelectedItem("No");
			}*/
		}}
		

	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
void retrieve(){
	boolean flag=false;
	String s=txtuserName.getText();
	char a[]=txtPassword.getPassword();

	String u_name="";
	String p_name="";
	try{
			st=conn.createStatement();
	set=st.executeQuery("Select * from mainlogin");
	set.next();
	u_name=set.getString("username");
	p_name=set.getString("password");
	}
	catch (Exception e) {
		System.out.println("erroe");
		// TODO: handle exception
	}
	if(s.equals(u_name)&&a.length==p_name.length())
	{
		for(int i=0;i<p_name.length();i++)
		{
		  if(a[i]==p_name.charAt(i))
		       flag=true;
		  else
		  {
		       flag=false;
		       break;
		  }


		}
	 }
	if(flag==true)
	{
		JOptionPane.showMessageDialog(null, "Login Succesfuly");
		setVisible(false);
		MainPage sam = new MainPage();
		sam.setSize(480, 420);
		sam.setVisible(true);
		sam.setResizable(false);
		sam.setLocationRelativeTo(null);
	}
	else
	{
		Icon error=new ImageIcon("images//error.png");
		
		JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Invalid Password \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
	}
}

	
	

	public void actionPerformed(ActionEvent e) {

Object obj = e.getSource();
		

				
		
		
	}
	
	
	public static void main(String[] args) {
		staffnadminloginpage sa =new staffnadminloginpage();
		sa.setSize(300,190);
		sa.setLocationRelativeTo(null);
		sa.setVisible(true);

		
		try{
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("error in loading theme "+e.getMessage());
			
		}	
	}
	
	
}