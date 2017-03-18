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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;



class loginpageadmin extends JFrame implements ActionListener{
	private JLabel lbluserName,lblPlatform,lblPosition,lblPassword;
	private JTextField txtuserName;
	private JPasswordField txtPassword;
	private JComboBox jcmbPosition,jcmbPlatform;
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

	
loginpageadmin(){
		
		
		addWindowListener(new WindowAdapter()
		{
			@SuppressWarnings("static-access")
			public void windowClosing(WindowEvent e)
			{
				LoginPage sa =new LoginPage();
				sa.setSize(300,250);
				sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				sa.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
				
			}
		});
		
		
		
		pRegister =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//pic1.jpg");
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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		
		
		
		
		lblPlatform =new JLabel("<html><i>Platform");
		lblPlatform.setForeground(Color.white);
		lblPlatform.setFont(new Font("Times New Roman",Font.PLAIN,15));
		pRegister.add(lblPlatform).setBounds(10, 60, 300, 25);
		jcmbPlatform = new JComboBox(platform);
		jcmbPlatform.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		jcmbPlatform.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pRegister.add(jcmbPlatform).setBounds(100, 62, 140, 22);
		
		
	

		lblPosition =new JLabel("<html><i>Position:");
		lblPosition.setForeground(Color.white);
		lblPosition.setVisible(true);
		lblPosition.setFont(new Font("Times New Roman",Font.PLAIN,15));
		pRegister.add(lblPosition).setBounds(10, 90, 300, 25);
		jcmbPosition = new JComboBox(position);
		jcmbPosition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		jcmbPosition.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pRegister.add(jcmbPosition).setBounds(100, 92, 140, 22);
		
		

		btnOK = new JButton(new ImageIcon("images//sam.gif"));
		pRegister.add(btnOK).setBounds(244, 90, 38, 25);
		btnOK.addActionListener(this);
		//btnOK.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		
		
		lblPassword =new JLabel("<html><i>Password:");
		lblPassword.setForeground(Color.white);
		lblPassword.setVisible(true);
		lblPassword.setFont(new Font("Times New Roman",Font.PLAIN,15));
		//pRegister.add(lblPassword).setBounds(10, 120, 300, 25);
		txtPassword = new JPasswordField();
		txtPassword.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		//pRegister.add(txtPassword).setBounds(100, 122, 140, 20);
		
		
		cmbsId=new JComboBox();
		cmbsId.setVisible(false);
		pRegister.add(cmbsId).setBounds(120, 84, 120, 20);
		
		
		
		
		
		
		
		btnLogin=new JButton("<html><i>Login");
		btnLogin.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		btnLogin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		//pRegister.add(btnLogin).setBounds(20, 150, 70, 25);
		btnLogin.addActionListener(this);
		
		btnCancel=new JButton("<html><i>Cancel");
		btnCancel.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		//pRegister.add(btnCancel).setBounds(106, 150, 90, 25);
		btnCancel.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		btnCancel.addActionListener(this);
		
		btnQuit=new JButton("<html><i>Quit");
		btnQuit.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		pRegister.add(btnQuit).setBounds(210, 150, 70, 25);
		btnQuit.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		btnQuit.addActionListener(this);
		
		cont=getContentPane();
	    
		cont.add( new textLoginPage(),BorderLayout.NORTH);
		
	getContentPane().add(pRegister,BorderLayout.CENTER);
	

	String url = "jdbc:mysql://localhost:3306/ggtelecom";
	try {
		
		
	conn = DriverManager.getConnection(url,"root","setonji04");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


}
	
	}
	

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
		mainmenu sa =new mainmenu();
		sa.setSize(340,190);
		sa.setLocationRelativeTo(null);
		sa.setVisible(true);
	}
	else
	{
		Icon error=new ImageIcon("images//error.png");
		
		JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Invalid Password \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
	}
}

	
	

	public void actionPerformed(ActionEvent e) {

Object obj = e.getSource();
		
		if(obj==btnLogin){
			retrieve();
			//dispose();
			
		}
		else if(obj==btnQuit	){
		System.exit(0);
	}
		
		else if(obj==btnCancel){
			txtuserName.setText("");
			txtPassword.setText("");
			jcmbPlatform.setSelectedIndex(0);
			jcmbPosition.setSelectedIndex(0);
		}
		else if(obj==btnOK){
			if(jcmbPosition.getSelectedItem().equals("Admin")){
				
				pRegister.add(lblPassword).setBounds(10, 120, 300, 25);
				pRegister.add(txtPassword).setBounds(100, 122, 140, 20);
				pRegister.add(btnLogin).setBounds(20, 150, 70, 25);
				pRegister.add(btnCancel).setBounds(106, 150, 90, 25);
			
		}else if (jcmbPosition.getSelectedItem().equals("User")||jcmbPosition.getSelectedItem().equals("Manager")){
			setVisible(false);
			JFrame frame = new JFrame();
			String[] options = new String[2];
			options[0] = new String("Login");
			options[1] = new String("Register");
			int s=JOptionPane.showOptionDialog(frame.getContentPane(),"Click below Button to access\n the main Menu portal!","Confirm", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
			
			switch (s) {
            case JOptionPane.YES_OPTION:
            	staffnadminloginpage sa =new staffnadminloginpage();
        		sa.setSize(300,190);
        		sa.setLocationRelativeTo(null);
        		sa.setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
            	staffregistration sam = new staffregistration();
        		sam.setSize(480, 420);
        		sam.setVisible(true);
        		sam.setResizable(false);
        		sam.setLocationRelativeTo(null);
            break;
			
			}
			
			
		
		}
		}
		

		
		
		
	}
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		try{
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("error in loading theme "+e.getMessage());
			
		}	
		loginpageadmin sa =new loginpageadmin();
		sa.setSize(300,250);
		sa.setLocationRelativeTo(null);
		sa.setVisible(true);
		sa.setDefaultLookAndFeelDecorated(true);
		
		
	}
	
	
}