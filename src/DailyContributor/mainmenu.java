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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;



class mainmenu extends JFrame implements ActionListener{
	private JLabel lblcontinfo,lblPassword;
	private JTextField txtuserName;
	private JPasswordField txtPassword;
	private Connection con;
	private Container cont;
	
	private JPanel pRegister;
	//private JTextField txtuserName,txtcsfName,txtsfName;
	String[] info={"Select","Contributor's Main Menu","Staff/Admin Menu"};
	
Choice catt;
	JComboBox cmbcontinfo;
	PreparedStatement ps;
	
	private JButton btnOK,btnLogout,btnQuit;
	Connection conn;
	Statement st;
ResultSet set;
	//private 

private java.util.Date currDate = new java.util.Date ();					//Creating Object.
private SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());	//Changing Format.
private String d = sdf.format (currDate);							//Storing Date.

String timeStamp = new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());

	
	mainmenu(){
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
		
		lblcontinfo =new JLabel("<html><i>Contributor's Portal:");
		lblcontinfo.setForeground(Color.white);
		lblcontinfo.setFont(new Font("Times New Roman",Font.PLAIN,12));
		pRegister.add(lblcontinfo).setBounds(0, 50, 300, 25);
		cmbcontinfo=new JComboBox(info);
		cmbcontinfo.setEditable(false);
		cmbcontinfo.setFont(new Font("Times New Roman",Font.ITALIC,14));
		cmbcontinfo.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pRegister.add(cmbcontinfo).setBounds(105, 52, 190, 23);
		

		btnOK = new JButton(new ImageIcon("images//sam.gif"));
		pRegister.add(btnOK).setBounds(295, 50, 38, 25);
		btnOK.addActionListener(this);
		
		
		btnLogout = new JButton("Logout");
		pRegister.add(btnLogout).setBounds(22, 90, 108, 25);
		btnLogout.addActionListener(this);
		
		btnQuit = new JButton("Quit the Software");
		pRegister.add(btnQuit).setBounds(150, 90, 178, 25);
		btnQuit.addActionListener(this);
		
		
		
		
		
		cont=getContentPane();
	    
		cont.add( new textLoginPage(),BorderLayout.NORTH);
		
	getContentPane().add(pRegister,BorderLayout.CENTER);
	

	String url = "jdbc:mysql://localhost:3306/ggtelecom";
	try {
		
		
	conn = DriverManager.getConnection(url,"root","setonji04");
	System.out.println("connected");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


}
	
	}
	
	//

	
	static void productdetails(){
		
	//	try{
			String ggtc="ggtc";
			String ggtc1=ggtc.toUpperCase();
		String s = JOptionPane.showInputDialog(null,"<html><i>		Enter the Contributor ID",ggtc1);
		
		
		
			
		if(s == null || (s != null && ("".equals(s))))   
		{
		   System.exit(0);
		}
		
		
		
		
		else{
			dailycontributor sam = new dailycontributor();
			sam.setSize(480, 420);
			sam.setVisible(true);
			sam.setResizable(false);
			sam.setLocationRelativeTo(null);
		}
		

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
		sam.setSize(500, 420);
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

	
static void searchcont(){
	
	try{
		String ggtc="ggtc";
		String ggtc1=ggtc.toUpperCase();
	String s = JOptionPane.showInputDialog(null,"<html><i>		Enter the Contributor ID",ggtc1);
	
	
	
		
	if(s == null || (s != null && ("".equals(s))))   
	{
	   System.exit(0);
	}
	
	
	
	
	else{
		search_contributor sam = new search_contributor();
		sam.setSize(480, 439);
		sam.setVisible(true);
		sam.setResizable(false);
		sam.setLocationRelativeTo(null);
	}}
	
	catch (Exception e) {
		// TODO: handle exception
	
	
	System.out.println("Error");
	}
}

	public void actionPerformed(ActionEvent e) {

Object obj = e.getSource();
		if(obj==btnLogout){
			setVisible(false);
			LoginPage sa =new LoginPage();
			sa.setSize(300,250);
			sa.setLocationRelativeTo(null);
			sa.setVisible(true);
			contributor_list.setDefaultLookAndFeelDecorated(true);
			setVisible(false);	
		}
		else if(obj==btnQuit){
			System.exit(0);
		}
		else if(obj==btnOK){
	if(cmbcontinfo.getSelectedItem().equals("Contributor Registration")){
		setVisible(false);
		btnOK.setBounds(0,0,0,0);
		contributor_registration sam = new contributor_registration();
		sam.setSize(480, 589);
		sam.setVisible(true);
		sam.setResizable(false);
		sam.setLocationRelativeTo(null);
			}
	else if(cmbcontinfo.getSelectedItem().equals("Contributor's Main Menu")){
		
		contributormainmenu sa =new contributormainmenu();
		sa.setSize(340,190);
		sa.setLocationRelativeTo(null);
		sa.setVisible(true);
		contributormainmenu.setDefaultLookAndFeelDecorated(true);
		setVisible(false);
		
	}
	
else if(cmbcontinfo.getSelectedItem().equals("Staff/Admin Menu")){
		
	staffadminmainmenu sa =new staffadminmainmenu();
	sa.setSize(340,190);
	sa.setLocationRelativeTo(null);
	sa.setVisible(true);
	staffadminmainmenu.setDefaultLookAndFeelDecorated(true);
		setVisible(false);
		
	}
	
	
	
	try{
		javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		JFrame.setDefaultLookAndFeelDecorated(true);
	} catch (Exception ey) {
		System.out.println("error in loading theme "+ey.getMessage());
		
	}	

	
}
				
		
		
	}
	
	
	public static void main(String[] args) {
		mainmenu sa =new mainmenu();
		sa.setSize(340,190);
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