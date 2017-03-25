package DailyContributor;


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
	JMenu  staffmanager_menu;
	JMenuItem studentMasterList_Archieves,staff_item,staffReg,schedule_item,guest_item,classlist_item,classmaster_list_item;
	JMenu faculty_master_menu,platform_menu;
	JMenuItem cont_contact;
	JMenuItem staffmanagers_registration,contributors_registration;
	JMenuItem administrative_item;

	JMenuItem signout_item,exit_item;
	JMenuItem staffmanagerdailycontributionupdate;
	JMenuItem contributors_list;

	JMenuItem staffmanagers_list,dailycontributionstaff_List;
	JMenuItem search_staff,search_cont,faculty_masterList,course_masterList,studentMasterRecord;
	JMenuItem  staff_payrollList,discharge_List,staff_dailyTranList;
	JMenuItem course_detailsItem;
	JMenuItem course_item,staffentry_item,room_item,grade_item,reamain_fees_item;
	JMenuItem short_term_courses_item,dailycontributor_item;

	JMenuItem by_YearLevel,stud_contact,search_stud,calcy,caln,by_EnrollmentStatus;
	String StrBusinessTitle;
   	JLabel BusinessTitleLabel = new JLabel();
  
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
				/*	
					MainMenuFrame sam=new MainMenuFrame();
					sam.setVisible(true);
					dis_charge_report.setDefaultLookAndFeelDecorated(true);
					setVisible(false);
					*/
					
					
				}
			});
		
		
		/*addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				cr.dispose();
				new MainMenuFrame();
				setVisible(false);
			}
		});*/
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
		//main.setLayout(null);
		
		 
		
		
		mbar=new JMenuBar();
     	setJMenuBar(mbar);

		file_menu=new JMenu("File");
     	file_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	file_menu.setMnemonic('F');

       	
       	registration_menu=new JMenu("Registration");
       	registration_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	registration_menu.setMnemonic('r');
       	
       	
     	platform_menu=new JMenu("Platform");
     	platform_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	platform_menu.setMnemonic('p');

     	setting_menu=new JMenu("System");
     	setting_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        setting_menu.setMnemonic('s');

        staffmanager_menu=new JMenu("Staff/Manager Portal");
        staffmanager_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        staffmanager_menu.setMnemonic('s');

        
     	view_menu=new JMenu("List");
     	view_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        view_menu.setMnemonic('l');


     	help_menu=new JMenu("Help");
     	help_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        help_menu.setMnemonic('H');


     	reports_menu=new JMenu("Query");
     	reports_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	reports_menu.setMnemonic('q');

     	//---JMenuItem
     	/*about_item=new JMenuItem("About Software?");
     	about_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	about_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		about_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images//mainicon.png")));
		about_item.addActionListener(h);

*/


     	signout_item=new JMenuItem("Sign Out");
     	signout_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	signout_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		signout_item.setIcon(new ImageIcon("images//lockapplication.png"));
		signout_item.addActionListener(this);

		exit_item=new JMenuItem("Exit");
     	exit_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	exit_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exit_item.setIcon(new ImageIcon("images//EXIT.PNG"));
		//exit_item.addActionListener(h);

		
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
        dailycontributor_item.addActionListener(this);

	  staffReg=new JMenuItem("");
        staffReg.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        staffReg.setIcon(new ImageIcon("images//delete.png"));
		
		room_item=new JMenuItem("");
		room_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		room_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        room_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		//room_item.addActionListener(this);

		staff_item=new JMenuItem("");
		staff_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staff_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        staff_item.setIcon(new ImageIcon("images//purchaseorder.png"));
		//staff_item.addActionListener(h);

		studentMasterRecord=new JMenuItem("");
		studentMasterRecord.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        studentMasterRecord.setIcon(new ImageIcon("images//SalesRep.png"));
		//studentMasterRecord.addActionListener(this);

		staffentry_item=new JMenuItem("");
		staffentry_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffentry_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        staffentry_item.setIcon(new ImageIcon("images//RECIEVE.png"));
		//staffentry_item.addActionListener(h);

		administrative_item=new JMenuItem("User Accounts");
		administrative_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		administrative_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        administrative_item.setIcon(new ImageIcon("images//SalesRep.png"));
		//administrative_item.addActionListener(h);

		
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
		//reamain_fees_item.addActionListener(h);

		guest_item=new JMenuItem(" ");
		guest_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		guest_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        guest_item.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		//guest_item.addActionListener(h);

    	
	    
	    //list menuitem
	    staffmanagers_list=new JMenuItem("Staff's/Manager's List");
	    staffmanagers_list.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staffmanagers_list.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK));
	    staffmanagers_list.addActionListener(this);
	    staffmanagers_list.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	   
	    contributors_list=new JMenuItem("Contributor's List");
	    contributors_list.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    contributors_list.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    contributors_list.addActionListener(this);
	    contributors_list.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    dailycontributionstaff_List=new JMenuItem("daily Contribution Staff Update List");
	    dailycontributionstaff_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    dailycontributionstaff_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    dailycontributionstaff_List.addActionListener(this);
	    dailycontributionstaff_List.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    discharge_List=new JMenuItem("");
	    discharge_List.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    discharge_List.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	  //  discharge_List.addActionListener(h);
	    discharge_List.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    //#######registration menuitem
	    staffmanagers_registration=new JMenuItem("Staff's/Manager's Registration Portal");
	    staffmanagers_registration.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staffmanagers_registration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK));
	    staffmanagers_registration.addActionListener(this);
	    staffmanagers_registration.setIcon(new ImageIcon("images//CUSTOMER.PNG"));
	   
	    contributors_registration=new JMenuItem("Contributor's Registration Portal");
	    contributors_registration.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    contributors_registration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    contributors_registration.addActionListener(this);
	    contributors_registration.setIcon(new ImageIcon("images//CUSTOMER.PNG"));

	    
	    //###############staffmanager portal
	    staffmanagerdailycontributionupdate=new JMenuItem("Daily Contribution Update ");
	    staffmanagerdailycontributionupdate.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    staffmanagerdailycontributionupdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	   // course_detailsItem.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    staffmanagerdailycontributionupdate.addActionListener(this);

	    /*courseItem=new JMenuItem("  ");
	    courseItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    courseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    courseItem.setIcon(new ImageIcon("images//newrecieve.png"));
	   // courseItem.addActionListener(h);

	   */
	    
	    
	    
	    ///Query menuitem
		cont_contact = new JMenuItem("Contributor's Contact");
		cont_contact.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cont_contact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		cont_contact.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		cont_contact.addActionListener(this);
		search_staff = new JMenuItem("Search Staff");
		search_staff.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		search_staff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		search_staff.setIcon(new ImageIcon("images//EXPENSE.PNG"));
		search_staff.addActionListener(this);

		search_cont = new JMenuItem("Search Contributor");
		search_cont.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		search_cont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		search_cont.setIcon(new ImageIcon("images//SEARCH.png"));
		search_cont.addActionListener(this);

		calcy=new JMenuItem("Calculator");
		calcy.setFont(new Font("Times New Roman",Font.PLAIN,13));
		calcy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		calcy.setIcon(new ImageIcon("images//newrecieve.png"));
		//calcy.addActionListener(h);


		caln=new JMenuItem("Calendar");
		caln.setFont(new Font("Times New Roman",Font.PLAIN,13));
		caln.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		caln.setIcon(new ImageIcon("images//purchaseorder.png"));
	   // caln.addActionListener(h);

	    by_EnrollmentStatus=new JMenuItem("Query Student by Enrollment Status");
	    by_EnrollmentStatus.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    by_EnrollmentStatus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    by_EnrollmentStatus.setIcon(new ImageIcon("images//SEARCH.png"));
	    //by_EnrollmentStatus.addActionListener(this);

	    studs_Archieves=new JMenu("Student Enrollment File");
	    studs_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    studs_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));

	 /*   Class_Schedules_Archieves=new JMenuItem("Class Schedules Archieves");
	    Class_Schedules_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
        Class_Schedules_Archieves.setIcon(new ImageIcon("images//EXPENSE.PNG"));
	    //Class_Schedules_Archieves.addActionListener(this);
*/

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

        
        //staffmanager portal
        staffmanager_menu.add(staffmanagerdailycontributionupdate);
       // staffmanager_menu.addSeparator();
       
        
        
        //Query menu
     reports_menu.add(cont_contact);
        reports_menu.addSeparator();
        reports_menu.add(search_cont);
        reports_menu.addSeparator();
        reports_menu.add(search_staff);
     
        
		
		//list menu
        view_menu.add(staffmanagers_list);
        view_menu.addSeparator();
        view_menu.add(contributors_list);
        view_menu.addSeparator();
        view_menu.add(discharge_List);
        view_menu.addSeparator();
        view_menu.add(dailycontributionstaff_List);
       
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
        mbar.add(staffmanager_menu);
        mbar.add(view_menu);
        mbar.add(setting_menu);
        mbar.add(help_menu);
        
        Icon img1=new ImageIcon("images//ICON1.JPG");
        btn1=new JButton();
        btn1.setIcon(img1);
       	btn1.addActionListener(this);
        btn1.setToolTipText("New Staff/Manager Entry");

        //StrBusinessTitle = "AMIS Software Copyright (C) 2006";
        BusinessTitleLabel.setText(StrBusinessTitle);
		BusinessTitleLabel.setFont(new Font("Verdana",Font.PLAIN,12));
		BusinessTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        Icon img2=new ImageIcon("images//bNew.png");
        btn2=new JButton();
        btn2.setIcon(img2);
		btn2.setToolTipText("New Contributor Entry");
		btn2.addActionListener(this);

        Icon img3=new ImageIcon("images//ICON3.jpg");
        btn3=new JButton();
        btn3.setIcon(img3);
        btn3.setToolTipText("Daily Contributor Update");
		btn3.addActionListener(this);

        Icon img4=new ImageIcon("images//ICON4.JPG");
        btn4=new JButton();
        btn4.setIcon(img4);
		btn4.setToolTipText("Remove Student Entry");
		//btn4.addActionListener(h);

        Icon img5=new ImageIcon("images//ICON5.JPG");
        btn5=new JButton();
        btn5.setToolTipText("Sign Out");
        btn5.setIcon(img5);
		//btn5.addActionListener(h);

        Icon img6=new ImageIcon("images//ICON6.JPG");
        btn6=new JButton();
        btn6.setIcon(img6);
		btn6.setToolTipText("Calculator");
     //   btn6.addActionListener(h);

        Icon img7=new ImageIcon("images//ICON7.JPG");
        btn7=new JButton();
        btn7.setIcon(img7);
        btn7.setToolTipText("Calendar");
      //  btn7.addActionListener(h);


        Icon img8=new ImageIcon("images//ICON8.JPG");
        btn8=new JButton();
        btn8.setIcon(img8);
        btn8.setToolTipText("Staff Contact's");
		//btn8.addActionListener(h);


        Icon img9=new ImageIcon("images//ICON9.JPG");
        btn9=new JButton();
        btn9.setToolTipText("Next Course");
        btn9.setIcon(img9);
       // btn9.addActionListener(h);

        Icon img10=new ImageIcon("images//ICON10.JPG");
        btn10=new JButton();
        btn10.setIcon(img10);
		btn10.setToolTipText("Change Password");
		//btn10.addActionListener(h);

        Icon img11=new ImageIcon("images//ICON11.JPG");
        btn11=new JButton();
        btn11.setIcon(img11);
        btn11.setToolTipText("Save Student Entry");
       // btn11.addActionListener(h);

        JToolBar toolbar=new JToolBar("Tools");
        c.add(toolbar);
        toolbar.setBounds(10,6,800,40);
		toolbar.setRollover(true);
		toolbar.setFloatable(false);
		toolbar.setBackground(Color.white);
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
				/*totalfees.setText(feeinfo.getString(3));
				DataInputStream sin=new DataInputStream(new FileInputStream(cours+"_id.dat"));
				txtsId.setText(sin.readUTF());
				paidfees.setText("0");
				addfees.setText("0");
			//	String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
*/				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
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
		/*table.addMouseListener(new TableHandler());

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

*/
	
	
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
	

		public void actionPerformed(ActionEvent e)
		{
			//String s=e.getActionCommand();
			Object source=e.getSource();
			
			/*if(s.equals("Exit"))
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
				else if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              	}
				
				
			}
			*/
			//}//end save
			
			//klkk
			 if(source==staffmanagers_registration ||source==btn1)
			{	
				staffregistration sam = new staffregistration();
				sam.setSize(480, 420);
				sam.setVisible(true);
				sam.setResizable(false);
				sam.setLocationRelativeTo(null);

			}
			 else if(source==cont_contact)
				{	
				 contributors_contact sa=new contributors_contact();
					sa.setSize(1200, 520);
					sa.setLocation(12, 10);
					sa.setVisible(true);
					setVisible(false);

				}
			 
			 
			
			 else if(source==contributors_registration||source ==btn2)
				{	
				 contributor_registration sam = new contributor_registration();
					sam.setSize(490, 593);
					sam.setVisible(true);
					sam.setResizable(false);
					sam.setLocation(400,130);
					//sam.setLocationRelativeTo(null);

				}
			 else if(source==dailycontributor_item)
				{	

					contributormainmenu sa =new contributormainmenu();
					sa.setSize(340,190);
					sa.setLocationRelativeTo(null);
					sa.setVisible(true);

				}
			 else if(source==staffmanagers_list)
				{	
				 	staffmanager_list sa=new staffmanager_list();
					sa.setSize(1200, 520);
					sa.setLocation(12, 10);
					sa.setVisible(true);
					setVisible(false);

				}
			 else if(source==contributors_list)
				{	
				 contributor_list sa=new contributor_list();
					sa.setSize(1200, 520);
					sa.setLocation(12, 10);
					sa.setVisible(true);
					setVisible(false);
				}
			 
			 else if(source==staffmanagerdailycontributionupdate||source==btn3)
				{	
				 dailycontributorstaffadmin sam = new dailycontributorstaffadmin();
					sam.setSize(480, 420);
					sam.setVisible(true);
					sam.setResizable(false);
					sam.setLocationRelativeTo(null);

				}
			 
			 else if(source==dailycontributionstaff_List)
				{	
				 dailycontributorupdatestaffadmin_list sa=new dailycontributorupdatestaffadmin_list();
					sa.setSize(1200, 520);
					sa.setLocation(12, 10);
					sa.setVisible(true);
					setVisible(false);
				}
			 else if(source==signout_item||source==btn5)
			{
				Icon warning=new ImageIcon("images//warning.png");
				Icon question=new ImageIcon("images//question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Logout",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              	/*	LoginFrame sam= new LoginFrame();
              		sam.setVisible(true);
              		*/
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              	}
			}}
		
		
public static void main(String[] args) {
	 MainPage sa=new  MainPage();
	 sa.setLocationRelativeTo(null);
	sa.setVisible(true);
}
}
