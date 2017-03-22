/*package DailyContributor;


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



class MainPage extends JFrame implements ActionListener
{
	JPanel main;
	Container c=getContentPane();
	private JLabel lblsId,lblfName,lblAddress,lblgpNumber,lblgName,lblgAddress,lblDOE,lblGender,lblLGA,lblPosition,lblEmail,lblpNumber,lblCert,lblsofOrigin;
	private JComboBox cmbdDay,cmbdMonth,cmbdYear,cmbPosition;
	private JComboBox appyred;
	
	String[] Day1={"DAYS","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
	String[] yrs1={"YEAR","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

	private JComboBox cmbsofOrigin;
	private JTextField txtsId,txtfName,txtgpNumber,txtgName,txtPosition,txtEmail,txtsofOrigin,txtpNumber,txtCert,txtLGA;////////////////////////////
String[] position={"Select","CEO","MD","ADMIN","Supervisor","Attendant","Security","Cleaner"};
	String[] abiaLGA={"Arochukwu","Aba North","Aba South","Bende","Isiala Ngwa North","Isiala Ngwa South","Isuikwuato","Obi Ngwa","Ugwunagbo","Ukwa East","Ukwa West","Umu Nneochi","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	
	
	String[] state={"select","Abia" ,"Adamawa","Akwa-Ibom","Bauchi","Bayelsa","Benue","Borno","Cross-River","Delta","Ekiti","Ebonyi","Edo","Enugu","Gombe","Imo","Jigawa","Kaduna","Kastina","Kano","Kebbi","Kogi","Kwara","Lagos","Nassarawa","Niger","Ogun","Ondo","Osun","Oyo","Plateau","Rivers","Sokoto","Taraba","Yobe","Zamfara","FCT"};
PreparedStatement ps=null;
CheckboxGroup cbmf;
Checkbox cbm,cbf;


	private JTextArea addfield1,gAddress;/////////////////////////////////////////////////////////
	private JComboBox courselist;
	JComboBox joindateday;
	JComboBox joindatemon;
	JComboBox joindateyear;
private JButton btnNew,btnSave,btnModify,btnRemove,btnExit,btnSearch,btnOk;
	//private JButton save;
	//private JButton modify;
	//private JButton remove;
	//private JButton exit;
	private JTable table;
	boolean therty=false;
	boolean twentynine=false;
	boolean twentyeight=false;
	
	String coursename;
	
	JMenuBar mbar;
	Connection conn;
	Statement st;
	
	
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
	JMenu studs_Archieves,query_menu,view_menu,file_menu,registration_menu,setting_menu,reports_menu,help_menu;
	JMenu showStudentMenu;
	JMenuItem studentMasterList_Archieves,staff_item,staffReg,schedule_item,guest_item,classlist_item,classmaster_list_item;
	JMenu faculty_master_menu,platform_menu;
	JMenuItem faculty_master_item;
	JMenuItem staffmanagers_registration,contributors_registration;
	JMenuItem administrative_item;

	JMenuItem signout_item,exit_item;
	JMenuItem studentmaster_item;
	JMenuItem contributors_list;

	JMenuItem staffmanagers_list,courseItem;
	JMenuItem Class_Schedules_Archieves,student_masterList,faculty_masterList,course_masterList,studentMasterRecord;
	JMenuItem  staff_payrollList,discharge_List,staff_dailyTranList;
	JMenuItem course_detailsItem;
	JMenuItem course_item,staffentry_item,room_item,grade_item,reamain_fees_item;
	JMenuItem short_term_courses_item,dailycontributor_item;

	JMenuItem by_YearLevel,stud_contact,search_stud,calcy,caln,by_EnrollmentStatus;
	String StrBusinessTitle;
   	JLabel BusinessTitleLabel = new JLabel();
   	StudentInfoHandler h=new StudentInfoHandler();
   	CourseInfoHandler ch=new CourseInfoHandler();
   	int height;
   	int width;
   	Dimension screenSize;
	@SuppressWarnings("unchecked")
	MainPage()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+300);
		setTitle("Student Information");
		setLocation(screenSize.width/6,20);
		
		
		
		
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					
					MainMenuFrame sam=new MainMenuFrame();
					sam.setVisible(true);
					dis_charge_report.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					
					
					
				}
			});
		
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				cr.dispose();
				new MainMenuFrame();
				setVisible(false);
			}
		});
		MainPage.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setTitle("The God Grace Telecommunication Management System ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
		main=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//plain7.jpg");
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
				g.drawImage(img,0,0,width+180,height+260,null);
			}
		};
		
		
		
		
		
		//main.setLayout(new GridBagLayout());
		main.setLayout(null);
		main.setBackground(new Color(245,240,255));

		
		txtsId=new JTextField(10);
		
		lblsId=new JLabel("<html><b><i>Staff ID Number:</i></b></html>");
		main.add(lblsId).setBounds(10,60,500,20);
		txtsId.setToolTipText("Staff Identification Number");
		txtsId.setFont(new Font("Times New Roman",Font.ITALIC,18));
		txtsId.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtsId).setBounds(120,62,200,20);
		
		lblfName=new JLabel("<html><b><i>Staff Full name :</i></b></html>");
		main.add(lblfName).setBounds(10,90,500,20);
		txtfName=new JTextField(20);
		main.add(txtfName).setBounds(120,92,550,20);
		//txtfName.addKeyListener(onlyText);
		txtfName.setFont(new Font("Times New Roman",Font.ITALIC,18));
		txtfName.setToolTipText("Enter Staff full Name");
		txtfName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		
		
		lblPosition=new JLabel("<html><b><i>Position :</i></b></html>");
		main.add(lblPosition).setBounds(10,240,500,20);
		cmbPosition =new JComboBox(position);
		cmbPosition.setFont(new Font("Times New Roman",Font.ITALIC,14));
		cmbPosition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(cmbPosition).setBounds(120,242,180,20);
		
		lblsofOrigin=new JLabel("<html><b><i>State Of Origin :</i></b></html>");
		main.add(lblsofOrigin).setBounds(10,270,500,20);
		cmbsofOrigin=new JComboBox(state);
		cmbsofOrigin.setFont(new Font("serif",Font.ITALIC,15));
		cmbsofOrigin.setToolTipText("Select The State");
		cmbsofOrigin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		cmbsofOrigin.setEditable(false);
		cmbsofOrigin.setMaximumRowCount(5);
		main.add(cmbsofOrigin).setBounds(120,270,100,25);
		
		
		lblpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
		main.add(lblpNumber).setBounds(380,240,500,20);
		txtpNumber=new JTextField(20);
		//txtpNumber.addKeyListener(onlyText);
		txtpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
		txtpNumber.setToolTipText("Enter Staff Phone number ");
		txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtpNumber).setBounds(490,242,200,20);
		
		lblLGA=new JLabel("<html><b><i>Local Govt. Area :</i></b></html>");
		main.add(lblLGA).setBounds(10,310,500,20);
		txtLGA=new JTextField(20);
	//	txtLGA.addKeyListener(onlyText);
		txtLGA.setToolTipText("Enter Local Government Area");
		txtLGA.setFont(new Font("Times New Roman",Font.ITALIC,18));
		
		txtLGA.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtLGA).setBounds(120,312,200,20);
		
		lblGender=new JLabel("<html><b><i>Gender :</i></b></html>");
		main.add(lblGender).setBounds(380,310,100,20);


	   	
	   	cbmf=new CheckboxGroup();
	   	cbm=new Checkbox("Male",cbmf,true);
	   	cbf=new Checkbox("Female",cbmf,false);
	   	cbm.setBounds(590,315,50,15);
	   	add(cbm);
	   	cbf.setBounds(490,315,80,15);
	   	add(cbf);
	   	lblDOE=new JLabel("<html><b><i>Date Of Birth :</i></b></html>");
	   	main.add(lblDOE).setBounds(10,350,200,20);
	   	cmbdDay=new JComboBox(Day1);
	   	cmbdDay.setFont(new Font("serif",Font.ITALIC,10));
	   	cmbdDay.setToolTipText("Select The Day");
	   	cmbdDay.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdDay.setEditable(false);
	   	cmbdDay.setMaximumRowCount(5);
	   	main.add(cmbdDay).setBounds(120,350,65,20);
	   	cmbdMonth=new JComboBox(month1);
	   	cmbdMonth.setFont(new Font("Times New Roman",Font.ITALIC,10));
		 cmbdMonth.setToolTipText("Select The Month");
	   	cmbdMonth.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdMonth.setEditable(false);
	   	cmbdMonth.setMaximumRowCount(5);
	   	main.add(cmbdMonth).setBounds(185,350,80,20);
	   	cmbdYear=new JComboBox(yrs1);
	   	cmbdYear.setFont(new Font("Times New Roman",Font.ITALIC,10));
		cmbdYear.setToolTipText("Select The Year");
	   	cmbdYear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdYear.setEditable(false);
	   	cmbdYear.setMaximumRowCount(5);
	   	main.add(cmbdYear).setBounds(265,350,80,20);
	   	
		lblDOE=new JLabel("<html><b><i>Date Of Employment :</i></b></html>");
	   	main.add(lblDOE).setBounds(380,350,200,20);
	   	cmbdDay=new JComboBox(Day1);
	   	cmbdDay.setFont(new Font("serif",Font.ITALIC,10));
	   	cmbdDay.setToolTipText("Select The Day");
	   	cmbdDay.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdDay.setEditable(false);
	   	cmbdDay.setMaximumRowCount(5);
	   	main.add(cmbdDay).setBounds(510,350,65,20);
	   	cmbdMonth=new JComboBox(month1);
	   	cmbdMonth.setFont(new Font("serif",Font.ITALIC,10));
	   	cmbdMonth.setToolTipText("Select The Month ");
	   	cmbdMonth.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdMonth.setEditable(false);
	   	cmbdMonth.setMaximumRowCount(5);
	   	main.add(cmbdMonth).setBounds(572,350,80,20);
	   	cmbdYear=new JComboBox(yrs1);
	   	cmbdYear.setFont(new Font("serif",Font.ITALIC,10));
	   	cmbdYear.setToolTipText("Select The Year");
	   	cmbdYear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	   	cmbdYear.setEditable(false);
	   	cmbdYear.setMaximumRowCount(5);
	   	main.add(cmbdYear).setBounds(650,350,80,20);
	   	
	   	lblCert=new JLabel("<html><b><i>Certification :</i></b></html>");
		main.add(lblCert).setBounds(380,270,500,20);
		txtCert=new JTextField(20);
		//txtCert.addKeyListener(onlyText);
		txtCert.setFont(new Font("Times New Roman",Font.ITALIC,18));
		
		txtCert.setToolTipText("Enter Staff Certification");
		txtCert.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtCert).setBounds(490,272,200,20);
		
		
		lblEmail=new JLabel("<html><b><i>Email Address :</i></b></html>");
		main.add(lblEmail).setBounds(10,210,500,20);
		txtEmail=new JTextField(20);
		txtEmail.setFont(new Font("Times New Roman",Font.ITALIC,18));
		//txtEmail.addKeyListener(onlyText);
		txtEmail.setToolTipText("Enter Staff Email Address");
		txtEmail.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtEmail).setBounds(120,212,500,20);
		
		lblAddress=new JLabel("<html><b><i>Address :</i></b></html>");
		main.add(lblAddress).setBounds(10,120,500,20);
		
		
		
		addfield1=new JTextArea(2,20);
		addfield1.setToolTipText("Enter Staff Address");
		addfield1.setFont(new Font("Times New Roman",Font.ITALIC,18));
		addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield1.setWrapStyleWord(true);
		addfield1.setLineWrap(true);
		
		JScrollPane addfield=new JScrollPane(addfield1);
		main.add(addfield).setBounds(120,122,550,80);
		
		
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Enter The  Guarantor Details Below Correctly.");
		l.setBounds(100,370,900,80);
		main.add(l);
			
		JLabel lbl1 = new JLabel(new ImageIcon("images//HEADER.gif"));
		lbl1.setBounds(0,390,900,50);
		main.add(lbl1);
		
		lblgName=new JLabel("<html><b><i>Guarantor Name :</i></b></html>");
		main.add(lblgName).setBounds(10,450,500,20);
		txtgName=new JTextField();
		txtgName.setToolTipText("Enter The Guarantor Full Name");
		txtgName.setFont(new Font("Times New Roman",Font.ITALIC,18));
		txtgName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtgName).setBounds(120,452,500,23);
		
		lblgpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
		main.add(lblgpNumber).setBounds(10,480,500,20);
		txtgpNumber=new JTextField(20);
		//txtgpNumber.addKeyListener(onlyText);
		txtgpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
		txtgpNumber.setToolTipText("Enter The Guarantor Phone number ");
		txtgpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		main.add(txtgpNumber).setBounds(120,482,200,20);
		
		
		lblgAddress=new JLabel("<html><b><i>Address :</i></b></html>");
		main.add(lblgAddress).setBounds(10,510,500,20);
		gAddress=new JTextArea(2,20);
		gAddress.setFont(new Font("Times New Roman",Font.ITALIC,18));
		gAddress.setToolTipText("Enter The Guarantor Address");
		gAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		gAddress.setWrapStyleWord(true);
		gAddress.setLineWrap(true);
		
		JScrollPane gAddress1=new JScrollPane(gAddress);
		main.add(gAddress1).setBounds(120,512,550,80);
		
		
		

		btnSearch=new JButton("Search");
		main.add(btnSearch).setBounds(620,600,90,20);
		btnSearch.addActionListener(h);
		btnOk=new JButton("OK");
		btnOk.setVisible(false);
		main.add(btnOk).setBounds(330,62,90,20);
		
		btnNew=new JButton("New");
		 main.add(btnNew).setBounds(120,600,90,20);
		 btnNew.addActionListener(h);
		 	btnSave=new JButton("Save");
		 	btnSave.addActionListener(h);
		 	btnSave.setToolTipText("Save The Entry of Student");
			main.add(btnSave).setBounds(219,600,90,20);
			btnModify=new JButton("Modify");
			btnModify.addActionListener(h);
			btnModify.setToolTipText("Modify the Entry");
			main.add(btnModify).setBounds(320,600,90,20);
			btnRemove=new JButton("Remove");
			btnRemove.addActionListener(h);
			btnRemove.setToolTipText("Remove The Student Entry");
			main.add(btnRemove).setBounds(420,600,90,20);
			btnExit=new JButton("Exit");
			btnExit.setToolTipText("Close Staff Information Form");
			btnExit.addActionListener(h);
			main.add(btnExit).setBounds(520,600,90,20);
			
		 
		 
		 
		 
		 
		
		
		mbar=new JMenuBar();
     	setJMenuBar(mbar);

		file_menu=new JMenu("File");
     	file_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	file_menu.setMnemonic('F');

       	
       	registration_menu=new JMenu("Registration");
       	registration_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	registration_menu.setMnemonic('p');
       	
       	
     	platform_menu=new JMenu("Platform");
     	platform_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	platform_menu.setMnemonic('p');

     	setting_menu=new JMenu("System");
     	setting_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        setting_menu.setMnemonic('s');

     	view_menu=new JMenu("List");
     	view_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        view_menu.setMnemonic('i');


     	help_menu=new JMenu("Help");
     	help_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        help_menu.setMnemonic('H');


     	reports_menu=new JMenu("Query");
     	reports_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	reports_menu.setMnemonic('e');

     	//---JMenuItem
     	about_item=new JMenuItem("About Software?");
     	about_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	about_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		about_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
		about_item.addActionListener(h);




     	signout_item=new JMenuItem("Sign Out");
     	signout_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	signout_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		signout_item.setIcon(new ImageIcon("images//lockapplication.png"));
		signout_item.addActionListener(h);

		exit_item=new JMenuItem("Exit");
     	exit_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	exit_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exit_item.setIcon(new ImageIcon("images//EXIT.PNG"));
		exit_item.addActionListener(h);

		studentmaster_item=new JMenuItem("Current Semester & School Year");//enrollment master file
		studentmaster_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentmaster_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        studentmaster_item.setIcon(new ImageIcon("images//RESET.PNG"));
	//studentmaster_item.addActionListener(this);

//#############################################
		studentMasterList_Archieves=new JMenuItem("  ");//enrollment master file
		studentMasterList_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterList_Archieves.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        studentMasterList_Archieves.setIcon(new ImageIcon("images//SUPPLIER.PNG"));
		//studentMasterList_Archieves.addActionListener(this);


///################################################
		schedule_item=new JMenuItem("Clas");
		schedule_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		schedule_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        schedule_item.setIcon(new ImageIcon("images//RESET.png"));
		//schedule_item.addActionListener(this);

        
        
        //platform menuitem
        dailycontributor_item=new JMenuItem("Daily Contributor");
        dailycontributor_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
        dailycontributor_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        dailycontributor_item.setIcon(new ImageIcon("images//customer.png"));
        dailycontributor_item.addActionListener(h);

	    staffReg=new JMenuItem("");
        staffReg.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        staffReg.setIcon(new ImageIcon("images//delete.png"));
		staffReg.addActionListener(h);

		room_item=new JMenuItem("");
		room_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		room_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        room_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		//room_item.addActionListener(this);

		staff_item=new JMenuItem("");
		staff_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staff_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        staff_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		staff_item.addActionListener(h);

		studentMasterRecord=new JMenuItem("");
		studentMasterRecord.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        studentMasterRecord.setIcon(new ImageIcon("images//SalesRep.png"));
		//studentMasterRecord.addActionListener(this);

		staffentry_item=new JMenuItem("");
		staffentry_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffentry_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        staffentry_item.setIcon(new ImageIcon("images//RECIEVE.png"));
		staffentry_item.addActionListener(h);

		administrative_item=new JMenuItem("User Accounts");
		administrative_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		administrative_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        administrative_item.setIcon(new ImageIcon("images//SalesRep.png"));
		administrative_item.addActionListener(h);

		
		////###################################################
		grade_item=new JMenuItem("  ");
		grade_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		grade_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        grade_item.setIcon(new ImageIcon("images//SEARCH.png"));
		//grade_item.addActionListener(this);

		reamain_fees_item=new JMenuItem("  ");
		reamain_fees_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		reamain_fees_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        reamain_fees_item.setIcon(new ImageIcon("images//newinvoice.png"));
		reamain_fees_item.addActionListener(h);

		guest_item=new JMenuItem(" ");
		guest_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		guest_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        guest_item.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		guest_item.addActionListener(h);

    	showStudentMenu=new JMenu(" ");
		showStudentMenu.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    showStudentMenu.setIcon(new ImageIcon("images//categories.png"));

     	//short_term_courses_item=new JMenuItem("Short Term Courses");
	//	short_term_courses_item.setFont(new Font("Verdana",Font.PLAIN,13));
	//	short_term_courses_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
    //    short_term_courses_item.setIcon(new ImageIcon("newrecieve.png"));
//		short_term_courses_item.addActionListener(this);

	    
	    
	    
	    //list menuitem
	    staffmanagers_list=new JMenuItem("Staff's/Manager's List");
	    staffmanagers_list.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staffmanagers_list.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK));
	    staffmanagers_list.addActionListener(h);
	    staffmanagers_list.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	   
	    contributors_list=new JMenuItem("Contributor's List");
	    contributors_list.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    contributors_list.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    contributors_list.addActionListener(h);
	    contributors_list.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    staff_dailyTranList=new JMenuItem("");
	    staff_dailyTranList.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staff_dailyTranList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    staff_dailyTranList.addActionListener(h);
	    staff_dailyTranList.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    discharge_List=new JMenuItem("");
	    discharge_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    discharge_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    discharge_List.addActionListener(h);
	    discharge_List.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    //#######registration menuitem
	    staffmanagers_registration=new JMenuItem("Staff's/Manager's Registration Portal");
	    staffmanagers_registration.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staffmanagers_registration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK));
	    staffmanagers_registration.addActionListener(h);
	    staffmanagers_registration.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	   
	    contributors_registration=new JMenuItem("Contributor's Registration Portal");
	    contributors_registration.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    contributors_registration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    contributors_registration.addActionListener(h);
	    contributors_registration.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    
	    course_detailsItem=new JMenuItem(" ");
	    course_detailsItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    course_detailsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    course_detailsItem.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		course_detailsItem.addActionListener(h);

	    courseItem=new JMenuItem("  ");
	    courseItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    courseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    courseItem.setIcon(new ImageIcon("images//newrecieve.png"));
	    courseItem.addActionListener(h);

	   

	    stud_contact=new JMenuItem("Staff Contact");
		stud_contact.setFont(new Font("Times New Roman",Font.PLAIN,13));
		stud_contact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		stud_contact.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		stud_contact.addActionListener(h);

		search_stud=new JMenuItem("Search Staff");
		search_stud.setFont(new Font("Times New Roman",Font.PLAIN,13));
		search_stud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		search_stud.setIcon(new ImageIcon("images//SEARCH.png"));
		search_stud.addActionListener(h);

		calcy=new JMenuItem("Calculator");
		calcy.setFont(new Font("Times New Roman",Font.PLAIN,13));
		calcy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		calcy.setIcon(new ImageIcon("images//newrecieve.png"));
		calcy.addActionListener(h);


		caln=new JMenuItem("Calendar");
		caln.setFont(new Font("Times New Roman",Font.PLAIN,13));
		caln.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		caln.setIcon(new ImageIcon("images//purchaseorder.png"));
	    caln.addActionListener(h);

	    by_EnrollmentStatus=new JMenuItem("Query Student by Enrollment Status");
	    by_EnrollmentStatus.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    by_EnrollmentStatus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    by_EnrollmentStatus.setIcon(new ImageIcon("images//SEARCH.png"));
	    //by_EnrollmentStatus.addActionListener(this);

	    studs_Archieves=new JMenu("Student Enrollment File");
	    studs_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    studs_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));

	    Class_Schedules_Archieves=new JMenuItem("Class Schedules Archieves");
	    Class_Schedules_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
        Class_Schedules_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    //Class_Schedules_Archieves.addActionListener(this);


     	//---Add to JMenu
     	file_menu.add(signout_item);
     	file_menu.addSeparator();
        file_menu.add(exit_item);

        
        //registration menu
        registration_menu.add(staffmanagers_registration);
        platform_menu.addSeparator();
        registration_menu.add(contributors_registration);
      
        platform_menu.add(dailycontributor_item);
      platform_menu.addSeparator();
      platform_menu.add(staffReg);
        platform_menu.addSeparator();
        //registration_menu.add(room_item);
        //registration_menu.addSeparator();
        platform_menu.add(staffentry_item);
        platform_menu.addSeparator();
        platform_menu.add(guest_item);
        //registration_menu.addSeparator();
        //registration_menu.add(grade_item);
     //   registration_menu.addSeparator();
      //  registration_menu.add(short_term_courses_item);


        reports_menu.add(courseItem);
		reports_menu.addSeparator();
		reports_menu.add(course_detailsItem);
		reports_menu.addSeparator();
		reports_menu.add(reamain_fees_item);
		reports_menu.addSeparator();
		reports_menu.add(staff_item);
		reports_menu.addSeparator();
		
		reports_menu.addSeparator();
		reports_menu.add(stud_contact);
		reports_menu.addSeparator();
		reports_menu.add(search_stud);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Birthdate);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Faculty_Load);
	   // reports_menu.addSeparator();
       // reports_menu.add(by_EnrollmentStatus);

		
		
		//list menu
        view_menu.add(staffmanagers_list);
        view_menu.addSeparator();
        view_menu.add(contributors_list);
        view_menu.addSeparator();
        view_menu.add(discharge_List);
        view_menu.addSeparator();
        view_menu.add( staff_dailyTranList);
       
       // query_menu.add(query_builderItem);

        setting_menu.add(administrative_item);
		setting_menu.addSeparator();
		setting_menu.add(calcy);
		setting_menu.addSeparator();
       	setting_menu.add(caln);

       // help_menu.add(about_item);

        //reports_menu.add(facultyloading_item);
     	//---Add to JMenuBar
     	mbar.add(file_menu);
    	mbar.add(registration_menu);
     	mbar.add(platform_menu);
        mbar.add(reports_menu);
        mbar.add(view_menu);
        mbar.add(setting_menu);
        mbar.add(help_menu);
        
        Icon img1=new ImageIcon("images//ICON1.JPG");
        btn1=new JButton();
        btn1.setIcon(img1);
       	btn1.addActionListener(h);
        btn1.setToolTipText("New Staff Entry");

        //StrBusinessTitle = "AMIS Software Copyright (C) 2006";
        BusinessTitleLabel.setText(StrBusinessTitle);
		BusinessTitleLabel.setFont(new Font("Verdana",Font.PLAIN,12));
		BusinessTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        Icon img2=new ImageIcon("images//ICON2.JPG");
        btn2=new JButton();
        btn2.setIcon(img2);
		btn2.setToolTipText("Search Student Entry");
		btn2.addActionListener(h);

        Icon img3=new ImageIcon("images//ICON3.JPG");
        btn3=new JButton();
        btn3.setIcon(img3);
        btn3.setToolTipText("Modify Student Entry");
		btn3.addActionListener(h);

        Icon img4=new ImageIcon("images//ICON4.JPG");
        btn4=new JButton();
        btn4.setIcon(img4);
		btn4.setToolTipText("Remove Student Entry");
		btn4.addActionListener(h);

        Icon img5=new ImageIcon("images//ICON5.JPG");
        btn5=new JButton();
        btn5.setToolTipText("Sign Out");
        btn5.setIcon(img5);
		btn5.addActionListener(h);

        Icon img6=new ImageIcon("images//ICON6.JPG");
        btn6=new JButton();
        btn6.setIcon(img6);
		btn6.setToolTipText("Calculator");
        btn6.addActionListener(h);

        Icon img7=new ImageIcon("images//ICON7.JPG");
        btn7=new JButton();
        btn7.setIcon(img7);
        btn7.setToolTipText("Calendar");
        btn7.addActionListener(h);


        Icon img8=new ImageIcon("images//ICON8.JPG");
        btn8=new JButton();
        btn8.setIcon(img8);
        btn8.setToolTipText("Staff Contact's");
		btn8.addActionListener(h);


        Icon img9=new ImageIcon("images//ICON9.JPG");
        btn9=new JButton();
        btn9.setToolTipText("Next Course");
        btn9.setIcon(img9);
        btn9.addActionListener(h);

        Icon img10=new ImageIcon("images//ICON10.JPG");
        btn10=new JButton();
        btn10.setIcon(img10);
		btn10.setToolTipText("Change Password");
		btn10.addActionListener(h);

        Icon img11=new ImageIcon("images//ICON11.JPG");
        btn11=new JButton();
        btn11.setIcon(img11);
        btn11.setToolTipText("Save Student Entry");
        btn11.addActionListener(h);

        JToolBar toolbar=new JToolBar("Tools");
        c.add(toolbar);
        toolbar.setBounds(10,6,800,40);
		toolbar.setRollover(true);
		toolbar.setFloatable(false);
        toolbar.add(btn1);
        toolbar.add(btn2);
        toolbar.add(btn3);
        toolbar.add(btn4);
        toolbar.add(btn5);
        toolbar.add(btn6);
        toolbar.add(btn7);
        toolbar.add(btn8);
        toolbar.add(btn9);
        toolbar.add(btn10);
        toolbar.add(btn11);

        toolbar.add(BusinessTitleLabel);
        getContentPane().add(main,BorderLayout.CENTER);
        int row=0;
		int i=0;

		try
		{
			conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
		            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from course_name");
			ResultSet tableset;
			while(set.next())
			{
				courselist.addItem(set.getString(2));
			}
			String cours=(String)courselist.getSelectedItem();
			String day[]=new String[31];
			for(int p=0;p<31;p++)
			{
				day[p]=""+(p+1);
				joindateday.addItem(day[p]);
			}
			for(int y=1950;y<2100;y++)
			{
				joindateyear.addItem(Integer.toString(y));
				//appyrst.addItem(Integer.toString(y));
			}
			joindateyear.setSelectedItem("2007");
			//sappyrst.setSelectedItem("2007");
			if(cours!=null)
			{
				int x=0;
				try
				{
					set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cours))
							break;
					}
					if(dur.equals("Two Semester") || dur.equals("One Year"))
						x=1;
					else
					if(dur.equals("Four Semester") || dur.equals("Two Year"))
						x=2;
					else
					if(dur.equals("Six Semester") || dur.equals("Three Year"))
						x=3;
					else
					if(dur.equals("Eight Semester") || dur.equals("Four Year"))
						x=4;

			//		int y=Integer.parseInt((String)appyrst.getSelectedItem());
				//	y=y+x;
				//ssssss	appyred.addItem(Integer.toString(y));


				}
				catch(Exception ec)
				{
				}
			}
			if(cours!=null)
			{
				ResultSet feeinfo=st.executeQuery("select * from course_name");
				while(feeinfo.next())
				{
					if(cours.equals(feeinfo.getString(2)))
						break;
				}
				totalfees.setText(feeinfo.getString(3));
				DataInputStream sin=new DataInputStream(new FileInputStream(cours+"_id.dat"));
				txtsId.setText(sin.readUTF());
				paidfees.setText("0");
				addfees.setText("0");
			//	String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				//ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Mobile No"},row);
				table=new JTable(model);
		//		ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
			}
		}
		catch(Exception ex)
		{
		}
		table.addMouseListener(new TableHandler());

		table.setToolTipText("Select the Student for more information");
		JScrollPane table1=new JScrollPane(table);
		table.doLayout();
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setGridColor(Color.pink);
		table.setRowMargin(3);
		table.setSelectionBackground(new Color(194,253,254));
		table.setSelectionForeground(new Color(128,64,0));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setReorderingAllowed(false);


	
		
	addWindowListener(new WindowHandler());


	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		//comp.setPreferredSize(comp.getPreferredSize());
//
		c.add(main);
	}
	class TableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
				String cours=(String)courselist.getSelectedItem();
				ResultSet set=st.executeQuery("select * from "+cours+"_stud_info order by scode");
				String scd="";
				while(set.next())
				{
					scd=set.getString(1).trim();
					if(sel.equals(scd))
						break;
				}
				txtsId.setText(scd);
				sname.setText(set.getString(2));
				//mname.setText(set.getString(3));
				lname.setText(set.getString(4));
				addfield1.setText(set.getString(5));
				String dat=set.getString(6);
				String day=dat.substring(0,2);
				if(day.charAt(0) == '0')
					day=String.valueOf(day.charAt(1));
				String mon=dat.substring(3,7);
				String yr=dat.substring(8,12);
				joindateday.setSelectedItem(day);
				joindatemon.setSelectedItem(mon);
				joindateyear.setSelectedItem(yr);
				mobno.setText(set.getString(7));
				totalfees.setText(set.getString(8));
				paidfees.setText(set.getString(9));
				addfees.setText(set.getString(10));
				remainfees.setText(set.getString(11));
				//save.setEnabled(false);

			}
			catch(Exception ew)
			{
			}

		}
	}
	//change the table value on window activated
	class WindowHandler extends WindowAdapter
	{
		public void windowActivated(WindowEvent we)
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				//courselist.removeAllItems();
				//while(set.next())
				//{
				//	courselist.addItem(set.getString(2));
				//}

				String cours=(String)courselist.getSelectedItem();
				//String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				//aps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				ResultSetMetaData meta=tableset.getMetaData();
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact No"},row);
				//ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
				table.setModel(model);

			}
			catch(Exception ex)
			{
			}
		}
	}//end window handler
	//change the value when course is selected
	class CourseInfoHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
				st=conn.createStatement();
				String cours=(String)courselist.getSelectedItem();
				ResultSet feeinfo=st.executeQuery("select * from course_name");
				while(feeinfo.next())
				{
					if(cours.equals(feeinfo.getString(2)))
						break;
				}
				//totalfees.setText(feeinfo.getString(3));

				int x=0;
				try
				{
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cours))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
						x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;

					appyred.removeAllItems();
					//int y=Integer.parseInt((String)appyrst.getSelectedItem());
					//y=y+x;
				//	appyred.addItem(Integer.toString(y));
					//joindateyear.setSelectedItem((String)appyrst.getSelectedItem());
				}
				catch(Exception exc)
				{
				}

				st.close();
		DataInputStream sin=new DataInputStream(new FileInputStream(cours+"_id.dat"));
				txtsId.setText(sin.readUTF());
				//save.setEnabled(true);
				//String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				//ps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact No"},row);
				ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				//ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
				table.setModel(model);
				ps.close();
				sname.setText("");
				//mname.setText("");
				lname.setText("");
				addfield1.setText("");
				mobno.setText("");
				paidfees.setText("0");
				addfees.setText("0");
				remainfees.setText("");
				//save.setEnabled(true);

			}
			catch(Exception ex)
			{
			}
		}
	}//end course info handler
	class StudentInfoHandler implements ActionListener
	{
		
		public void insertUpdate(){
			

			String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			try {
				//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			          // "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
				
			conn = DriverManager.getConnection(url,"root","");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);

		//	e1.printStackTrace();
		}
			
		
	 if(cmbMonth.getSelectedItem().equals("MONTH") || cmbYear.getSelectedItem().equals("YEAR")  ){
		Icon error=new ImageIcon("images//error.png");
		JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Month & Year can't be in thier Default Value <br><i><b> MONTH & YEAR </i></b></font></html>  ","Warning",JOptionPane.ERROR_MESSAGE,error);
	 }
	 else if(!txtemail.getText().contains("@"))
		{
			Icon error=new ImageIcon("images//error.png");
			JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Invalid email address</font></html> \n\t\t example@gmail.com","Invalid Input",JOptionPane.ERROR_MESSAGE,error);
		}
	 else if(txtpNumber.getText().length()!=11 || txtgPhone.getText().length()!=11 )
		{
			Icon error=new ImageIcon("images//error.png");
			JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Mobile Number must not exceed 11 digits </font></html> \n\t\t Please Enter Valid Mobile Number","Invalid Input",JOptionPane.ERROR_MESSAGE,error);
		}
	 
	 if(txtDate.getText().equals("")||txtTime.getText().equals("")||txtfName.getText().equals("")||txtstaffID.getText().equals("")||txtemail.getText().equals("")||txtAmount.getText().equals("")||txtBonus.getText().equals("")||txtCert.getText().equals("")||txtgName.getText().equals("")||txtgName.getText().equals("")||txtgPhone.getText().equals("")||txtOthers.getText().equals("")||txtpNumber.getText().equals("")||txtPosition.getText().equals("")){
		 Icon error=new ImageIcon("images//error.png");
		JOptionPane.showMessageDialog(null,"<html><font size=4 color=red><i><b>Fill all editable Fields</i></b></font></html>  ","Warning",JOptionPane.ERROR_MESSAGE,error);
	 }
	 

			
			if(txtsId.getText().length()==0){
				System.out.println("invalid number");
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
		 try {
				
			 st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
		//String sql	= "INSERT INTO `staff`(`staffid`, `fName`, `address`, `position`, `email`, `sofOrigin`, `phone`, `cert`, `lgArea`, `dob`, `doe`, `gender`, `gname`, `gpnumber`, `gaddress`) VALUES ('"+txt,[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13],[value-14],[value-15])";
		String sql	= "INSERT INTO `staff`(`staffid`, `fName`, `address`, `position`, `email`, `sofOrigin`, `phone`, `cert`, `lgArea`, `dob`, `doe`, `gender`, `gname`, `gpnumber`, `gaddress`) VALUES ('"+txtsId.getText()+"',+'"+txtfName.getText()+"')";
			 
			 
			 
			//String sql=" INSERT INTO `payroll`(`date`, `time`, `sid`, `fname`,`gender`, `email`, `number`, `position`, `cert`, `gname`, `gpnumber`, `month`, `year`, `amount`, `bonus`, `others`) VALUES ('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtfName.getText()+"','"+gender1+"','"+txtemail.getText()+"','"+txtpNumber.getText()+"','"+txtPosition.getText()+"','"+txtCert.getText()+"','"+txtgName.getText()+"','"+txtgPhone.getText()+"','"+cmbMonth.getSelectedItem()+"','"+cmbYear.getSelectedItem()+"','"+txtAmount.getText()+"','"+txtBonus.getText()+"','"+txtOthers.getText()+"')";
			
		ps=conn.prepareStatement(sql);
			 ps.executeUpdate();
			 
		 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	JOptionPane.showMessageDialog(btnSave, "Saved into database");

		      	//	 clearText();
		      		         
		      		      }                              
		      		      
		      			      
			
//		}

		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
			Object source=e.getSource();
			//coursename=(String)courselist.getSelectedItem();
			//new button
			
			if(s.equals("Save"))
			{
				
				String url = "jdbc:mysql://localhost:3306/rakedomanagement";
				try {
					//con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
				          // "(*.mdb)};"+"DBQ=D:\\database\\rakedomanagement.mdb","ayets","setonji04");
					
				conn = DriverManager.getConnection(url,"root","");
				System.out.println("connected");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);

			//	e1.printStackTrace();
			}
				
		
				
				if(txtsId.getText().length()==0){
					System.out.println("invalid number");
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
			 try {
					
				 st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					
			//String sql	= "INSERT INTO `staff`(`staffid`, `fName`, `address`, `position`, `email`, `sofOrigin`, `phone`, `cert`, `lgArea`, `dob`, `doe`, `gender`, `gname`, `gpnumber`, `gaddress`) VALUES ('"+txt,[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13],[value-14],[value-15])";
			//String sql	= "INSERT INTO `staff`(`staffid`, `fName`, `address`, `position`, `email`, `sofOrigin`, `phone`, `cert`, `lgArea`, `dob`, `doe`, `gender`, `gname`, `gpnumber`, `gaddress`) VALUES ('"+txtsId.getText()+"',+'"+txtfName.getText()+"','"+addfield1.getText()+"','"+txtPosition.getText()+"','"+txtEmail.getText()+"','"+txtsofOrigin.getText()+"','"+txtpNumber.getText()+"','"+txtCert.getText()+"','"+txtLGA.getText()+"')";
			String sql =  "INSERT INTO `staffregistration`(`staffId`, `fName`, `address`, `position`, `email`, `sOfOrigin`, `pNumber`, `certification`, `lgovArea`, `dOfBirth`, `dOfEmployment`, `dOfRegistration`, `gName`, `gpNumber`, `gAddress`) VALUES ('"+txtsId.getText()+"')";
					///"//,'"+txtfName.getText()+"',[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11],[value-12],[value-13],[value-14],[value-15])";
				 
				 
				//String sql=" INSERT INTO `payroll`(`date`, `time`, `sid`, `fname`,`gender`, `email`, `number`, `position`, `cert`, `gname`, `gpnumber`, `month`, `year`, `amount`, `bonus`, `others`) VALUES ('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtfName.getText()+"','"+gender1+"','"+txtemail.getText()+"','"+txtpNumber.getText()+"','"+txtPosition.getText()+"','"+txtCert.getText()+"','"+txtgName.getText()+"','"+txtgPhone.getText()+"','"+cmbMonth.getSelectedItem()+"','"+cmbYear.getSelectedItem()+"','"+txtAmount.getText()+"','"+txtBonus.getText()+"','"+txtOthers.getText()+"')";
				
			ps=conn.prepareStatement(sql);
				 ps.executeUpdate();
				 
			 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		JOptionPane.showMessageDialog(btnSave, "Saved into database");

			      	//	 clearText();
			      		         
			      		      }    
				
				
				
			}
			
			if(s.equals("Exit"))
			{
				
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","EXIT",JOptionPane.YES_NO_OPTION,1,question);

				if(ans==JOptionPane.YES_OPTION)
              	{
					
					MainMenuFrame sam=new MainMenuFrame();
					sam.setVisible(true);
					dis_charge_report.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              	}
				
				
			}
			if(s.equals("New")||source==btn1)
			{
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream(coursename+"_id.dat"));
					txtsId.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				txtCert.setText("");
				txtgName.setText("");
				txtgpNumber.setText("");
				txtLGA.setText("");

				//paidfees.setText("0");
				//addfees.setText("0");
				txtpNumber.setText("");
				btnSave.setEnabled(true);
			}//end new
			//save button
		
			//}//end save
			
			//klkk
			if(s.equals("Staff's/Manager's Registration Portal"));;
			{	
				staffregistration sam = new staffregistration();
				sam.setSize(480, 420);
				sam.setVisible(true);
				sam.setResizable(false);
				sam.setLocationRelativeTo(null);


			}
			if(s.equals("Daily Contributor"))
			{
				contributormainmenu sa =new contributormainmenu();
				sa.setSize(340,190);
				sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				//c.add(sa);

			}
			
			if(s.equals("Contributor's Registration Portal"))
			{contributor_registration sam = new contributor_registration();
			sam.setSize(490, 593);
			sam.setVisible(true);
			sam.setResizable(false);
			sam.setLocation(200,200);
			//sam.setLocationRelativeTo(null);

			}
			
			if(source==signout_item||source==btn5)
			{
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Logout",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              		LoginFrame sam= new LoginFrame();
              		sam.setVisible(true);
              		
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              	}
			}
			if(source==about_item)
			{
				AboutDialog dl=new AboutDialog();
				dl.setVisible(true);
			}
			
			
			if(source==discharge_List)
			{
				dis_charge_report cr = new dis_charge_report();
				cr.setSize(1000,580);
				cr.setLocation(20,80);
				cr.setVisible(true);
				setVisible(false);
			}
			
			if(source==staff_item)
			{
				staffsReport report=new staffsReport();
				report.setVisible(true);
				report.setSize(570,540);
				report.setLocationRelativeTo(null);
				setVisible(false);
			}
			
			if(source==	staff_dailyTranList)
			{
				 daily_Trans_report sa=new daily_Trans_report();
					sa.setSize(1200, 520);
					sa.setLocation(12, 10);
					sa.setVisible(true);
					setVisible(false);
					
			}
			
			if(source==	staffentry_item)
			{
				staffQuery sa=new staffQuery();
				sa.setSize(570,390);
				sa.setLocationRelativeTo(null);
				sa.setVisible(true);
					setVisible(false);
					
			}
			
		
			if(source==staff_payrollList)
			{
				payroll_list cr = new payroll_list();
				cr.setSize(1320,580);
				cr.setLocation(20,80);
				cr.setVisible(true);
				setVisible(false);
			}
			
			
			if(source==staffReg)
			{
				MainPage cr = new MainPage();
				cr.setSize(800,690);
				//cr.setLocation(20,20);
				cr.setLocationRelativeTo(null);
				cr.setVisible(true);
				setVisible(false);
			}
			
			
		
			if(source==btn10||source==administrative_item)
			{
				ChangePass pass=new ChangePass();
				pass.setVisible(true);
				setVisible(false);
			}
			
			if(source==course_item)
			{
				dailyTransaction pass=new dailyTransaction();
				pass.setVisible(true);
				pass.setSize(799,410);
				pass.setLocationRelativeTo(null);
				setVisible(false);
			}
			
			if(source==staffentry_item)
			{
				

			}
			
			if(source==contributors_list)
			{
				contributors_list sa=new contributors_list();
				sa.setSize(500, 520);
				sa.setVisible(true);
				sa.setLocationRelativeTo(null);
				
			}
			if(source==btn7||source==caln)
			{
				calendar l=new calendar();
				l.setVisible(true);

			}
			if(source==btn6||source==calcy)
			{
				Calculator cl=new Calculator();
				cl.setVisible(true);
			}
			if(source==btn8||source==stud_contact)
			{
				StaffContact ct=new StaffContact();
				ct.setVisible(true);
				ct.setSize(790, 520);
				setVisible(false);
				
				
			}
			
			
			if(source==student_masterList)
			{
				staffsList ls=new staffsList();
				ls.setVisible(true);
				ls.setSize(1320,580);
				ls.setLocation(20,80);
				setVisible(false);
			}

		}
	}
	class AboutDialog extends JDialog
	{
		JButton ok;
		Container c;
		AboutDialog()
		{
			super(MainPage.this,"About",true);
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+50, height2+40);
			setLocation(width2-20,height2-30);
			setTitle("About");
			ok=new JButton("Ok");
			c=getContentPane();
			JPanel p=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("images//Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					Image img2=Toolkit.getDefaultToolkit().getImage("images//mainicon.png");
					t.addImage(img,1);
					t.addImage(img,2);
					while(true)
					{
						try
						{
							t.waitForID(1);
							t.waitForID(2);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width2+50,height+40,null);
					g.drawImage(img2,10,10,50,50,null);
				}

			};
			JLabel l=new JLabel("<html><font size=6 color=#800080<br><br><B>Filling Station Management System</B></dl></font><br><p><font size=4 color=blue align=left><B><dl>Developed By : </B></font><font size=4 color=#800000 align=left><B>Ayetolu Samuel Setonji</dd><br><p><font size=4 color=blue align=left><B><dl>Contact : </B></font><font size=4 color=#800000 align=left><B>+2348167137007<br><font size=4 color=green align=left>Email:</font>Ayetolusamuel@gmail.com</dd><dd><font size=3 color=black><br><center>version 1.1<br>Copyright 2008 All Rights Reserved");
			p.add(l);
			c.add(p);
			JPanel butpan=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}

			};
			butpan.add(ok);
			c.add("South",butpan);
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
		}
		public void paintComponent(Graphics g)
		{
			Image img=Toolkit.getDefaultToolkit().getImage("images//mainicon.gif");
			ImageIcon ic=new ImageIcon(img,"Center");
			g.drawImage(img,20,30,20,30,null);
		}
	}
	class DateHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			String mon=(String)joindatemon.getSelectedItem();
			int x=joindateyear.getSelectedIndex();
			int year=1950;
			year=year+x;
			if(mon.equals("Apr ")||mon.equals("June")||mon.equals("Sept")||mon.equals("Nov "))
			{
				joindateday.removeItem("31");
				therty=true;
				if (twentynine == true)
				{
					joindateday.addItem("30");
					twentynine = false;
					twentyeight = false;

				}
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					twentyeight = false;
					twentynine = false;
				}
			}
			else
			if(mon.equals("Feb ")&&year%4==0)
			{
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				twentynine=true;
				therty = false;
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					twentyeight = false;
					therty = false;
				}



			}
			else
			if(mon.equals("Feb "))
			{
				twentyeight=true;
				twentynine = false;
				therty = false;
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				joindateday.removeItem("29");

			}
			else
			if(mon.equals("Jan ")||mon.equals("Mar ")||mon.equals("May ")||mon.equals("July")||mon.equals("Aug ")||mon.equals("Oct ")||mon.equals("Desc"))
			{
				if(therty==true)
				{
					joindateday.addItem("31");
					therty=false;
					twentynine = false;
					twentyeight = false;
				}
				else
				if(twentynine==true)
				{
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentynine=false;
					therty = false;
					twentyeight = false;

				}
				else
				if(twentyeight==true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentyeight=false;
					twentynine = false;
					therty = false;
				}

			}

		}
	}
	class CourseHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			cr = new CourseAddition();
			cr.setVisible(true);
		}
	}




class ModifyInfo extends JFrame
{
	Container c=getContentPane();
	JTable table;
	JPanel main;
	DefaultTableModel model;
	ModifyDialog mdl;
	String stcode;
	ModifyInfo()
	{
		setSize(1350,600);
		setTitle("Staff Information");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				MainPage sam=new MainPage();
				sam.setVisible(true);
				sam.setLocationRelativeTo(null);
				payroll_list.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
			}});
		
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
				g.drawImage(img,0,0,1350,100,null);
			}
		};
		title.add(l);
		c.add("North",title);

		main=new JPanel();
		main.setLayout(new BorderLayout());
		
		try
		{
			 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
 			
 			conn = DriverManager.getConnection(url,"root","");
 			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from staff");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Staff_ID","Name","Address","Position","Email","State","phone_Number","Certification","L.G.A ","DOB","DOE","Gender ","Guar.Name","Guar.Num." ,"Guar.Address"},row);
			
			
			table=new JTable(model);
			set=st.executeQuery("select * from staff");
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
	  	//table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        
        c.add(main);
      
	}
		
		class SelectedCourse implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//String cors=(String)cour.getSelectedItem();
				try
				{
					int x=0;
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						//if(cr.equals(cors))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
						x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;

					//appyredmd.removeAllItems();
					//int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
				//	y=y+x;
					//appyredmd.addItem(Integer.toString(y));
					st.close();
					int row=0;
					int i=0;
					//String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
					//PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					//ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();

					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
			//		ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					//ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(6).trim(),i,2);
						i++;
					}
				//	stud.setModel(model);

				}
				catch(Exception ex)
				{
				}
			}
		}
		class ModifyStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=table.getSelectedRow();
				stcode=(String)table.getValueAt(ro,0);
				mdl=new ModifyDialog(stcode);
				mdl.setSize(800,660);
				mdl.setLocationRelativeTo(null);
				mdl.setResizable(false);
				mdl.setVisible(true);
				setVisible(false);
			}
		}
		
				public class ModifyDialog extends JDialog implements ActionListener {
					private JLabel lblsId,lblfName,lblPosition,lblsofOrigin,lblpNumber,lblLGA,lblDOE,lblCert,lblAddress,lblGender,lblEmail,lblgName,lblgpNumber,lblgAddress;
						private JPanel main;
						String mstud;
						private JTextField txtsCode,txtfName,txtEmail,txtpNumber,txtLGA,txtCert,txtgName,txtgpNumber,txtPosition,txtDob,txtDoe,txtGender;
						private JComboBox cmbsofOrigin;
						JTextArea addfield1,gAddress;
						private JButton btnUpdate,btnClear,btnCancel;
						
						String[] Day1={"DAYS","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
						String[] month1={"MONTH","January","February","March","April","May","June","July","August","September","October","November","December",};
						String[] yrs1={"YEAR","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

						
						String[] state={"select","Abia" ,"Adamawa","Akwa-Ibom","Bauchi","Bayelsa","Benue","Borno","Cross-River","Delta","Ekiti","Ebonyi","Edo","Enugu","Gombe","Imo","Jigawa","Kaduna","Kastina","Kano","Kebbi","Kogi","Kwara","Lagos","Nassarawa","Niger","Ogun","Ondo","Osun","Oyo","Plateau","Rivers","Sokoto","Taraba","Yobe","Zamfara","FCT"};
						PreparedStatement ps=null;
						CheckboxGroup cbmf;
						Checkbox cbm,cbf;
						ModifyStud ms=new ModifyStud();
						ModifyDialog(String s){
							mstud=s;
							main=new JPanel();
							main=new JPanel()
							{
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
									g.drawImage(img,0,0,800,650,null);
								}
							};
							
							
							
							setSize(800,670);
							setLocation(20,20);
							setResizable(false);
							main.setLayout(null);
						
						
						
						
						
						
						lblsId=new JLabel("<html><b><i>Staff ID Number:</i></b></html>");
						main.add(lblsId).setBounds(10,60,500,20);
						//scode=new JTextField();
						txtsCode=new JTextField(10);
						txtsCode.setEditable(false);
						txtsCode.setToolTipText("Staff Identification Number");
						txtsCode.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtsCode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtsCode).setBounds(120,62,200,20);
						
						lblfName=new JLabel("<html><b><i>Staff Full name :</i></b></html>");
						main.add(lblfName).setBounds(10,90,500,20);
						txtfName=new JTextField(20);
						main.add(txtfName).setBounds(120,92,550,20);
						//sname.addKeyListener(onlyText);
						txtfName.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtfName.setToolTipText("Enter Staff full Name");
						txtfName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						
						
						
						lblPosition=new JLabel("<html><b><i>Position :</i></b></html>");
						//main.add(lblPosition).setBounds(10,210,500,20);
						main.add(lblPosition).setBounds(10,240,500,20);
						
						txtPosition=new JTextField(20);
						txtPosition.setFont(new Font("Times New Roman",Font.ITALIC,18));
						//lname.addKeyListener(onlyText);
						txtPosition.setToolTipText("Enter Staff Email Address");
						txtPosition.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtPosition).setBounds(120,242,200,20);
						
						
						lblEmail=new JLabel("<html><b><i>Email :</i></b></html>");
						//main.add(lblEmail).setBounds(10,240,500,20);
						main.add(lblEmail).setBounds(10,210,500,20);
						
						txtEmail=new JTextField(20);
						txtEmail.setFont(new Font("Times New Roman",Font.ITALIC,18));
						//txtEmail.addKeyListener(onlyText);
						txtEmail.setToolTipText("Enter Staff Email Address");
						txtEmail.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtEmail).setBounds(120,212,500,20);
						
						//
						
						
						lblpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
						main.add(lblpNumber).setBounds(380,240,500,20);
						txtpNumber=new JTextField(20);
						//txtpNumber.addKeyListener(onlyText);
						txtpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtpNumber.setToolTipText("Enter Staff Phone number ");
						txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtpNumber).setBounds(490,242,200,20);

						lblsofOrigin=new JLabel("<html><b><i>State Of Origin :</i></b></html>");
						main.add(lblsofOrigin).setBounds(10,270,500,20);
						cmbsofOrigin=new JComboBox(state);
						cmbsofOrigin.setFont(new Font("serif",Font.ITALIC,15));
						cmbsofOrigin.setToolTipText("Select The State");
						cmbsofOrigin.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						cmbsofOrigin.setEditable(false);
						cmbsofOrigin.setMaximumRowCount(5);
						main.add(cmbsofOrigin).setBounds(120,270,100,25);
						
						
						lblLGA=new JLabel("<html><b><i>Local Govt. Area :</i></b></html>");
						main.add(lblLGA).setBounds(10,310,500,20);
						txtLGA=new JTextField(20);
						//txtLGA.addKeyListener(onlyText);
						txtLGA.setToolTipText("Enter Local Government Area");
						txtLGA.setFont(new Font("Times New Roman",Font.ITALIC,18));
						
						txtLGA.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtLGA).setBounds(120,312,200,20);
						
						lblGender=new JLabel("<html><b><i>Gender :</i></b></html>");
						main.add(lblGender).setBounds(380,310,100,20);
						txtGender =new JTextField();
						txtGender.setBounds(490,315,90,15);
						main.add(txtGender);
					  
						lblDOE=new JLabel("<html><b><i>Date Of Birth :</i></b></html>");
					   	main.add(lblDOE).setBounds(10,350,200,20);
					   	
					   txtDob=new JTextField();
						main.add(txtDob).setBounds(120,350,80,20);
					   
						lblDOE=new JLabel("<html><b><i>Date Of Employment :</i></b></html>");
					   	main.add(lblDOE).setBounds(380,350,200,20);
					   	 txtDoe=new JTextField();
					   	txtDoe.setFont(new Font("serif",Font.BOLD,12));
					 	txtDoe.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					   	main.add(txtDoe).setBounds(510,350,80,20);
					   	

					   	lblCert=new JLabel("<html><b><i>Certification :</i></b></html>");
						main.add(lblCert).setBounds(380,270,500,20);
						txtCert=new JTextField(20);
						//txtCert.addKeyListener(onlyText);
						txtCert.setFont(new Font("Times New Roman",Font.ITALIC,18));
						
						txtCert.setToolTipText("Enter Staff Certification");
						txtCert.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtCert).setBounds(490,272,200,20);
						
						lblAddress=new JLabel("<html><b><i>Address :</i></b></html>");
						main.add(lblAddress).setBounds(10,120,500,20);
						
						
						
						addfield1=new JTextArea(2,20);
						addfield1.setToolTipText("Enter Staff Address");
						addfield1.setFont(new Font("Times New Roman",Font.ITALIC,18));
						addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						addfield1.setWrapStyleWord(true);
						addfield1.setLineWrap(true);
						
						JScrollPane addfield=new JScrollPane(addfield1);
						main.add(addfield).setBounds(120,122,550,80);
						

					   

						JLabel l=new JLabel("<html><font size=6 color=#800080><i>Enter The  Guarantor Details Below Correctly.");
						l.setBounds(100,370,900,80);
						main.add(l);
							
						JLabel lbl1 = new JLabel(new ImageIcon("images//HEADER.gif"));
						lbl1.setBounds(0,390,900,50);
						main.add(lbl1);
						
						lblgName=new JLabel("<html><b><i>Guarantor Name :</i></b></html>");
						main.add(lblgName).setBounds(10,450,500,20);
						txtgName=new JTextField();
						txtgName.setToolTipText("Enter The Guarantor Full Name");
						txtgName.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtgName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtgName).setBounds(120,452,500,23);
						
						lblgpNumber=new JLabel("<html><b><i>Phone Number :</i></b></html>");
						main.add(lblgpNumber).setBounds(10,480,500,20);
						txtgpNumber=new JTextField(20);
						//txtgpNumber.addKeyListener(onlyText);
						txtgpNumber.setFont(new Font("Times New Roman",Font.ITALIC,18));
						txtgpNumber.setToolTipText("Enter The Guarantor Phone number ");
						txtgpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						main.add(txtgpNumber).setBounds(120,482,200,20);
						
						
						lblgAddress=new JLabel("<html><b><i>Address :</i></b></html>");
						main.add(lblgAddress).setBounds(10,510,500,20);
						gAddress=new JTextArea(2,20);
						gAddress.setFont(new Font("Times New Roman",Font.ITALIC,18));
						gAddress.setToolTipText("Enter The Guarantor Address");
						gAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
						gAddress.setWrapStyleWord(true);
						gAddress.setLineWrap(true);
						
						JScrollPane gAddress1=new JScrollPane(gAddress);
						
						main.add(gAddress1).setBounds(120,512,550,80);
						
						btnUpdate=new JButton("Update");
						main.add(btnUpdate).setBounds(250,610,100,20);
						btnUpdate.addActionListener(this);
						btnClear=new JButton("Clear");
						main.add(btnClear).setBounds(380,610,100,20);
						btnClear.addActionListener(this);
					
						btnCancel=new JButton("Cancel");
						main.add(btnCancel).setBounds(500,610,100,20);
					btnCancel.addActionListener(this);	
						
						getContentPane().add(main,BorderLayout.CENTER);
						
						
				
				
						try {
							
							
							
							
							st=conn.createStatement();
							
							
							ResultSet minfo=st.executeQuery("select * from staff order by staffid");
							
							String stco="";
							while(minfo.next())
							{
								stco=minfo.getString(1).trim();
								if(stco.equals(mstud))
									break;
									
									
						}
							
							txtsCode.setText(stco);
							txtfName.setText(minfo.getString(2));
							addfield1.setText(minfo.getString(3));
							txtEmail.setText(minfo.getString(5));
							txtPosition.setText(minfo.getString(4));
							cmbsofOrigin.setSelectedItem(minfo.getString(6));
							txtpNumber.setText(minfo.getString(7).trim());
							txtCert.setText(minfo.getString(8));
							txtLGA.setText(minfo.getString(9));
							txtDob.setText(minfo.getString(10));
							txtDoe.setText(minfo.getString(11));
							txtGender.setText(minfo.getString(12));
							txtgName.setText(minfo.getString(13));
							txtgpNumber.setText(minfo.getString(14));
							gAddress.setText(minfo.getString(15));
							
							
							
						}
						catch(Exception ed)
						{
							ed.printStackTrace();
							//ed.getMessage();
						//	System.out.println(ed);
					
						} 
				
						}

						 public  void UpdateRecords(){
							   String url = "jdbc:mysql://localhost:3306/rakedomanagement";
								
								try {
									conn = DriverManager.getConnection(url,"root","");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								//private	JTextField txtsCode,txtfName,txtEmail,txtpNumber,txtLGA,txtCert,txtgName,txtgpNumber,txtPosition,txtDob,txtDoe,txtGender;
								
								
								
								
								
								//UPDATE `staff` SET `staffid`=[value-1],`fName`=[value-2],`address`=[value-3],`position`=[value-4],`email`=[value-5],`sofOrigin`=[value-6],`phone`=[value-7],`cert`=[value-8],`lgArea`=[value-9],`dob`=[value-10],`doe`=[value-11],`gender`=[value-12],`gname`=[value-13],`gpnumber`=[value-14],`gaddress`=[value-15] WHERE 1
								
								
								
								String update1 = "Update staff set staffid = '" + txtsCode.getText() +"' where staffid = '" + txtsCode.getText() + "'" ;
								
								
								
								
								
								
								
							String update2 = "Update staff set fName = '" + txtfName.getText() +"' where staffid = '" + txtsCode.getText() + "'" ;
						      String update3 = "Update staff set address = '" + addfield1.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update4 = "Update staff set email = '" + txtEmail.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
							  String update5 = "Update staff set position = '" + txtPosition.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update6 = "Update staff set sofOrigin = '" + cmbsofOrigin.getSelectedItem() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update7 = "Update staff set phone = '" + txtpNumber.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update8 = "Update staff set cert = '" + txtCert.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update9 = "Update staff set lgArea = '" + txtLGA.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update10 = "Update staff set dob = '" + txtDob.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update11= "Update staff set doe = '" + txtDoe.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update12 = "Update staff set gender = '" + txtGender.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update13= "Update staff set gname = '" + txtgName.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update14= "Update staff set gpnumber = '" + txtgpNumber.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      String update15= "Update staff set gaddress = '" + gAddress.getText() +"' where staffid = '" +  txtsCode.getText() + "'" ;
						      
						      
						      try{
						          st = conn.createStatement();
						          st.executeUpdate(update1);
						          st.executeUpdate(update2);
						          st.executeUpdate(update3);
						          st.executeUpdate(update4);
						          st.executeUpdate(update5);
						          st.executeUpdate(update6);
						          st.executeUpdate(update7);
						          st.executeUpdate(update8);
						          st.executeUpdate(update9);
						          st.executeUpdate(update10);
						          st.executeUpdate(update11);
						          st.executeUpdate(update12);
						          st.executeUpdate(update13);
						          st.executeUpdate(update14);
						          st.executeUpdate(update15);
						          
						          
						        st.close();
						          conn.close();
						      }
						      catch(SQLException ex){
						          System.err.println(ex.getMessage());
						      }
						      JOptionPane.showMessageDialog(null,"Update Finished!");
						     // fillEmpty();
						     // clearText();
						     dispose();
						     
						    // ModifyStudList
						     ModifyInfo sam=new  ModifyInfo();
						     
								sam.setVisible(true);
								//sam.setSize(490,510);
								sam.setLocationRelativeTo(null);
								payroll_list.setDefaultLookAndFeelDecorated(true);
								setVisible(false);
						
						  }

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							
							Object obj = e.getSource();
							
							if(obj==btnCancel){
								ModifyInfo sam=new ModifyInfo();
								sam.setSize(1200, 520);
								sam.setVisible(true);
								sam.setLocationRelativeTo(null);
								setVisible(false);
							// TODO Auto-generated method stub
							}
							
							if(obj==btnClear){
								
								//fillEmpty();
								
							}
							
							
							if(obj==btnUpdate){
								
								 UpdateRecords();
								
									

								
							
						}
						}
						 
						 
						 
						 
						
			}
				
				
		
			class ModifyStud implements ActionListener
			{
			public void actionPerformed(ActionEvent e)
				{
					String minfo=e.getActionCommand();
					if(minfo.equals("    "))
					{
						boolean ok=false;
						try
						{
							
						
							String name=txtgName.getText();
							String mdname=txtCert.getText();
							String ltname=txtgpNumber.getText();
							String address=txtpNumber.getText();
							String mobile=txtLGA.getText();
							int total=Integer.parseInt(txtCert.getText());
							int paidfs=Integer.parseInt(txtgpNumber.getText());
							int additionfs=Integer.parseInt(txtgpNumber.getText());
					int remain=(total+additionfs)-paidfs;
							String totalf=Integer.toString(total);
							String paidfe=Integer.toString(paidfs);
							String additionfe=Integer.toString(additionfs);
							String remainf=Integer.toString(remain);
						if(remain<0)
							{
								Icon error=new ImageIcon("images//error.png");
								JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Paid Fees Over Than Total Fees </font></html> \n\t\t Please Enter Valid Ammount","Student Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							if(txtsId.equals("") || txtfName.equals(""))
							{
								Icon error=new ImageIcon("images//error.png");
								JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								String mobTest=txtgName.getText().trim();
								boolean valid=false;
								if((mobTest.length() == 14)||(mobTest.length() == 11))
								{
									valid=true;
									if(mobTest.length() == 11)
									{
										char ch=mobTest.charAt(0);
										if(ch != '0')
										{
											valid=false;
											Icon error=new ImageIcon("images//error.png");
											JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
										}
									}
								}
								else
								{
									valid=false;
									Icon error=new ImageIcon("images//error.png");
									JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
								}
								if(valid==true)
								{
									String csn=(String)cour.getSelectedItem();
									PreparedStatement pm=conn.prepareStatement("update "+csn+"_stud_info set sname=? ,mname=? ,lname=? ,address=? ,mobno=? ,paidfees=? ,addfees=? ,remfees=? where scode=?");
									pm.setString(1,name);
									pm.setString(2,mdname);
									pm.setString(3,ltname);
									pm.setString(4,address);
									pm.setString(5,mobile);
									pm.setInt(6,paidfs);
									pm.setInt(7,additionfs);
									pm.setInt(8,remain);
									//pm.setString(9,mstud);
									pm.execute();
								}
								mdl.dispose();
							}
						}
						catch(Exception es)
						{
							Icon error=new ImageIcon("images//error.png");
							JOptionPane.showMessageDialog(null,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}

					}
					else
					{
						mdl.dispose();
					}
				}
			}
		}
	
	class RemoveInfo extends JFrame
	{
		Container mic=getContentPane();
		JComboBox appyrstrm;
		JComboBox appyredrm;
		JTable stud;
		JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		RemoveDialog dlg;
		String corname;
		RemoveInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+100, height2+100);
			setLocation(width2-20,height2-50);setTitle("Student Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			RemoveInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("images//mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Student To Remove");
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
					g.drawImage(img,0,0,width2+100,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);
			pan=new JPanel();
			pan.setLayout(new GridBagLayout());
			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=10;
			cons.weighty=0;

			cour=new JComboBox();
			cour.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyrstrm=new JComboBox();
			appyrstrm.setToolTipText("Select apperaed year");
			appyrstrm.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyredrm=new JComboBox();
			appyredrm.setToolTipText("Select apperaed year");
			appyredrm.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
			            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
			st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				while(set.next())
				{
					cour.addItem(set.getString(2));
				}
				for(int y=1950;y<2100;y++)
				{
					appyrstrm.addItem(Integer.toString(y));
				}
				appyrstrm.setSelectedItem("2007");
				String crs=(String)cour.getSelectedItem();
				if(crs!=null)
				{
					int x=0;
					try
					{
						set=st.executeQuery("select * from course_name");
						String dur=null;
						while(set.next())
						{
							String cr=set.getString(2).trim();
							dur=set.getString(4).trim();
							if(cr.equals(crs))
								break;
						}
						if(dur.equals("Two Semester") || dur.equals("One Year"))
							x=1;
						else
						if(dur.equals("Four Semester") || dur.equals("Two Year"))
							x=2;
						else
						if(dur.equals("Six Semester") || dur.equals("Three Year"))
							x=3;
						else
						if(dur.equals("Eight Semester") || dur.equals("Four Year"))
							x=4;

						int y=Integer.parseInt((String)appyrstrm.getSelectedItem());
						y=y+x;
						appyredrm.addItem(Integer.toString(y));


					}
					catch(Exception ec)
					{
					}
				}

				st.close();

				String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+crs+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet stset=ps.executeQuery();
				int row=0;
				int i=0;
				while(stset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
				ps=conn.prepareStatement("select * from "+crs+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				stset=ps.executeQuery();

				while(stset.next())
				{
					model.setValueAt(stset.getString(1).trim(),i,0);
					String ft=stset.getString(2).trim();
					ft=ft+" "+stset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(stset.getString(6).trim(),i,2);
					i++;
				}
				stud=new JTable(model);
				stud.addMouseListener(new RemoveStudList());
				stud.setToolTipText("Select The Student For Modify");
				stud.doLayout();
				stud.setColumnSelectionAllowed(false);
				stud.setSelectionMode(1);
				stud.setEditingColumn(3);
				stud.setGridColor(Color.pink);
				stud.setRowMargin(3);
				stud.setSelectionBackground(Color.gray);
				stud.setSelectionForeground(Color.red);
				stud.setShowHorizontalLines(false);
				stud.setShowVerticalLines(false);
				stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(stud);
				mic.add(spl);

				cour.setMaximumRowCount(10);
				cons.anchor=GridBagConstraints.CENTER;
				cons.weightx=30;
				Box cor1=Box.createHorizontalBox();
				cor1.add(Box.createGlue());
				cor1.add(new JLabel("Course"));
				cor1.add(Box.createHorizontalStrut(5));
				cor1.add(cour);
				cor1.add(Box.createHorizontalStrut(5));
				addOn(cor1,cons,0,0,2,1);
				cons.weightx=40;
				Box cor = Box.createHorizontalBox();
				cor.add(Box.createGlue());
				cor.add(new JLabel("Appered Year"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyrstrm);
				cor.add(Box.createHorizontalStrut(5));
				cor.add(new JLabel("TO"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyredrm);
				addOn(cor,cons,3,0,2,1);
				cons.weightx=100;
				cons.weighty=100;
				addOn(spl,cons,0,1,5,1);
				stset.close();
				cour.setMaximumRowCount(10);
				cour.addActionListener(new SelectedCourseRemove());
				appyrstrm.addActionListener(new SelectedCourseRemove());
				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
						String cors=(String)cour.getSelectedItem();
						try
						{


							String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
							PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet stset=ps.executeQuery();
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
							ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							stset=ps.executeQuery();
							while(stset.next())
							{
								model.setValueAt(stset.getString(1).trim(),i,0);
								String ft=stset.getString(2).trim();
								ft=ft+" "+stset.getString(4).trim();
								model.setValueAt(ft,i,1);
								model.setValueAt(stset.getString(6).trim(),i,2);
								i++;
							}
							stud.setModel(model);
						}
						catch(Exception ex)
						{
						}
					}
				});

			}
			catch(Exception es)
			{
			}

		}
		public void addOn(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			pan.add(comp,cons);
			mic.add(pan);
		}
		class SelectedCourseRemove implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String cors=(String)cour.getSelectedItem();
				try
				{
					int x=0;
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cors))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
					x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;
					appyredrm.removeAllItems();
					int y=Integer.parseInt((String)appyrstrm.getSelectedItem());
					y=y+x;
					appyredrm.addItem(Integer.toString(y));
					st.close();
					String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
					PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();
					int row=0;
					int i=0;
					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
					ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(6).trim(),i,2);
						i++;
					}
					stud.setModel(model);
					}
					catch(Exception ex)
					{
					}

			}
		}
		class RemoveStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=stud.getSelectedRow();
				String stcode=(String)stud.getValueAt(ro,0);
				dlg=new RemoveDialog(stcode);
				dlg.setVisible(true);


			}
		}
		class RemoveDialog extends JDialog
		{
			JButton rok;
			JButton rcan;
			JLabel ls;
			String rmstud;
			RemoveDialog(String s)
			{
				super(RemoveInfo.this,"Remove Student",true);
				rmstud=s;
				setSize(250,150);
				setLocation(400,280);
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				rok=new JButton("  Ok  ");
				rcan=new JButton("Cancel");
				bp.add(rok);
				bp.add(rcan);
				add(bp,"South");
				JPanel lp=new JPanel();
				lp.add(new JLabel("<html><font size=4 color=#800080>Do You Want To Remove <br>    Student Information </font></html>"));
				add(lp);
				RemoveStud rs=new RemoveStud();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);

			}
			class RemoveStud implements ActionListener
			{
				String dur;
				public void actionPerformed(ActionEvent ev)
				{
					String cm=ev.getActionCommand();
					if(cm.equals("  Ok  "))
					{
						try
						{
							String csn=(String)cour.getSelectedItem();
							PreparedStatement pts=conn.prepareStatement("delete from "+csn+"_stud_info  where scode=?");
							pts.setString(1,rmstud);
							pts.execute();
							pts.close();

							pts=conn.prepareStatement("select course_dura from course_name where course_name=? ");
							pts.setString(1,csn);
							ResultSet set=pts.executeQuery();
							set.next();
							String dur=set.getString(1);

							pts.close();

							int semno=0;

							
							Connection cns=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
						            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
							
						
							for(int i=1;i<=semno;i++)
							{
								String tablename=csn+"_marks"+i;
								System.out.println(tablename);

								PreparedStatement pts2=cns.prepareStatement("delete from "+tablename+"  where scode=?");
								//pts2.setString(1,tablename);
								pts2.setString(1,rmstud);
								pts2.execute();
								pts2.close();

							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						dlg.dispose();
					}
					else
					{
						dlg.dispose();
					}

				}
			}

		}

	}
	class ChangePass extends JDialog
	{
		JTextField chuname1;
		JPasswordField chpass1;
		JTextField chuname2;
		JPasswordField chpass2;
		ResultSet set;
		ChangePass()
		{
			super(MainPage.this,"Change Password",true);

			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2,height2);setLocation(screenSize.width/3+20,screenSize.height/4+40);
			setResizable(false);
			MainPage.setDefaultLookAndFeelDecorated(true);
			Container c=getContentPane();
			chuname1=new JTextField(10);
			chuname1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass1=new JPasswordField(10);
			chpass1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chuname2=new JTextField(10);
			chuname2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass2=new JPasswordField(10);
			chpass2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));

			JPanel main=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}
			};
			main.setLayout(new BorderLayout());
			Box vbox=Box.createVerticalBox();
			JPanel chun1=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chun1.add(new JLabel("    User Name        "));
			chun1.add(chuname1);
			vbox.add(chun1);

			JPanel chpas1=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chpas1.add(new JLabel("    Password         "));
			chpas1.add(chpass1);
			vbox.add(chpas1);

			JPanel chun2=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chun2.add(new JLabel("New User Name   "));
			chun2.add(chuname2);
			vbox.add(chun2);

			JPanel chpas2=new JPanel()
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
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chpas2.add(new JLabel("New Password     "));
			chpas2.add(chpass2);
			vbox.add(chpas2);
			vbox.add(Box.createVerticalStrut(20));

			JButton ok=new JButton("Ok");
			JButton clear=new JButton("clear");
			JButton exit=new JButton("exit");
			Box butpan=Box.createHorizontalBox();
			butpan.setCursor(new Cursor(Cursor.HAND_CURSOR));
			butpan.add(ok);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(clear);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(exit);
			vbox.add(butpan);
			main.add(vbox);
			c.add(main);

			ok.setToolTipText("Save Password");
			clear.setToolTipText("Clear Text");
			exit.setToolTipText("Exit");
			chuname1.setToolTipText("Enter The User Name");
			chpass1.setToolTipText("Enter The Password");
			chuname2.setToolTipText("Enter The New User Name");
			chpass2.setToolTipText("Enter The New password");


			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					chuname1.setText("");
					chpass1.setText("");
					chuname2.setText("");
					chpass2.setText("");

				}
			});
			exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					MainPage sam=new MainPage();
				//sam.setDefaultLookAndFeelDecorated(true);
					sam.setVisible(true);
					
				}
			});

			chpass2.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					if((e.getKeyCode())==KeyEvent.VK_ENTER)
					{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
					
						conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
						            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
							
						st=conn.createStatement();
						set=st.executeQuery("Select * from Login");
						set.next();
						u_name=set.getString(1);
						p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
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
							if(chuname2.getText().equals("") || chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("images//error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{


							try
							{

							PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
							ps.setString(1,chuname2.getText());
							ps.setString(2,String.copyValueOf(chpass2.getPassword()));
							ps.setString(3,chuname1.getText());
							ps.execute();
							Icon info=new ImageIcon("images//info.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
							dispose();
							}
							catch(Exception e2)
							{
							}
							}

						}
						else
						{
							Icon error=new ImageIcon("images//error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}
					}
				}
			});
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
							conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
						            "(*.mdb)};"+"DBQ=D:\\database\\Student_Info.mdb","ayets","setonji04");
						st=conn.createStatement();
							set=st.executeQuery("Select * from Login");
							set.next();
							u_name=set.getString(1);
							p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
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
							if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("images//error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{

							try
							{

								PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
								ps.setString(1,chuname2.getText());
								ps.setString(2,String.copyValueOf(chpass2.getPassword()));
								ps.setString(3,chuname1.getText());
								ps.execute();
								Icon info=new ImageIcon("images//info.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
								dispose();
							}
							catch(Exception e2)
							{
							}
							}
						}
						else
						{
							 Icon error=new ImageIcon("images//error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}


				}
			});


		}



	}
public static void main(String[] args) {
	 MainPage sa=new  MainPage();
	 sa.setLocationRelativeTo(null);
	sa.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
*/