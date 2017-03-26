package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class search_contributor extends JFrame implements ActionListener, FocusListener {
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
	
	
	private JTextField txtcfName, txtEmail, txtstaffID, txtfName, txtemail,
			txtpNumber, txtnkNumber, txtnkName,txtaName, txtaNumber, txtbName,
			txtBonus;
	TextArea txtOthers;
	PreparedStatement ps = null;

	private JComboBox jcmbaType;

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,
			btnSearch;

	private java.util.Date currDate = new java.util.Date(); // Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
			Locale.getDefault()); // Changing Format.
	private String d = sdf.format(currDate); // Storing Date.

	String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar
			.getInstance().getTime());

	// Statement for Getting the Required Table.
	private long id = 0; // To Hold the BookId.
	private JLabel lbl2;
	private JLabel lbl3;

	// Constructor of Class.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public search_contributor() {
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
	
	
	
		setTitle("Contributor Profile");
		setSize(397, 510);
		setLocation(100, 60);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				 MainPage sa=new  MainPage();
				 sa.setLocationRelativeTo(null);
				sa.setVisible(true);
				MainPage.setDefaultLookAndFeelDecorated(true);
				setVisible(false);
				
				
				
			}
		});
		pAdmin.setLayout(null);

		lblcfName = new JLabel("<html><b><b>Full Name :</i></b></html>");
		lblcfName.setForeground(Color.white);
		lblcfName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblcfName).setBounds(10, -40, 100, 120);

		txtcfName = new JTextField("");
		txtcfName.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtcfName.setEditable(false);
		pAdmin.add(txtcfName).setBounds(90, 12, 220, 20);

		lblEmail = new JLabel("<html><i><b>Email :</i></b></html>");
		lblEmail.setForeground(Color.white);
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblEmail).setBounds(10, -10, 70, 120);
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		pAdmin.add(txtEmail).setBounds(90, 40, 220, 20);

		

		lblpNumber = new JLabel("<html><i><b>Phone Num.:</i></b></html>");
		lblpNumber.setForeground(Color.white);
		lblpNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblpNumber).setBounds(8, 16, 180, 120);
		txtpNumber= new JTextField();
		txtpNumber.setEditable(false);
		txtpNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtpNumber.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtpNumber).setBounds(90, 68, 220, 20);
		
		JLabel pic1= new JLabel(new ImageIcon("images/picback.png"));
		//pAdmin.add(pic1).setBounds(310, 7, 160, 120);
		

		JLabel lblppic = new JLabel("<html><i><b>Profile Picture</i></b></html>");
		lblppic.setForeground(Color.red);
		lblppic.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		pAdmin.add(lblppic).setBounds(310, 80, 180, 120);
		
	
		lblnkName = new JLabel("<html><b>Next of Kin Name :</i></b></html>");
		lblnkName.setForeground(Color.white);
		lblnkName.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		pAdmin.add(lblnkName).setBounds(10, 138, 180, 120);
		//pAdmin.add(lblnkName).setBounds(10, 100, 180, 120);
		txtnkName = new JTextField();
		txtnkName.setEditable(false);
		txtnkName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {

					getToolkit().beep();
					ke.consume();
				}

			}
		});
		pAdmin.add(txtnkName).setBounds(130, 189, 330, 20);
		lblnkNumber = new JLabel("<html><b>Next of Kin Contact :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 12));
	
		pAdmin.add(lblnkNumber).setBounds(10, 100, 180, 120);
		
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(false);
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.addKeyListener(new KeyAdapter() {
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
		
		pAdmin.add(txtnkNumber).setBounds(130, 152, 100, 20);
		
		
		JLabel pic2= new JLabel(new ImageIcon("images/picback.png"));
		

		JLabel lblpic2 = new JLabel("<html><i><b>Next of Kin picture</i></b></html>");
		lblpic2.setForeground(Color.blue);
		lblpic2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		pAdmin.add(lblpic2).setBounds(10, 290, 180, 120);
		

		JLabel pic3= new JLabel(new ImageIcon("images/picback.png"));
		

		JLabel lblpic3 = new JLabel("<html><i><b>Contributor Signature</i></b></html>");
		lblpic3.setForeground(Color.blue);
		lblpic3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		pAdmin.add(lblpic3).setBounds(310, 300, 180, 120);
		
	
		getContentPane().add(pAdmin,BorderLayout.CENTER);
		 String url = "jdbc:mysql://localhost:3306/ggtelecom";
		  
		   
		   try {
			con = DriverManager.getConnection(url,"root","setonji04");
			//System.out.println("Connected");
	}
		   catch (Exception e) {
			// TODO: handle exception
		}
		   productdetails();   
	}
		   
		   
	 void productdetails(){
		
		
			String ggtc="ggtc";
			String ggtc1=ggtc.toUpperCase();
		String s = JOptionPane.showInputDialog(null,"<html><i>		Enter the Contributor ID",ggtc1);
		

	//cont pic
		String urlimage="C://Users//DELL//workspace//GGBadagry//contributorimages/"+s+".png";
		
		lbl1= new JLabel(new ImageIcon(urlimage));
		pAdmin.add(lbl1).setBounds(310, -10, 200, 199);
		
		//nextof kin
String urlimage1="C://Users//DELL//workspace//GGBadagry//nextofkinpics/"+s+".png";
		
		lbl2= new JLabel(new ImageIcon(urlimage1));
		pAdmin.add(lbl2).setBounds(10, 220, 200, 199);
		
String urlimage3="C://Users//DELL//workspace//GGBadagry//contributorsign/"+s+".png";
		
		lbl3= new JLabel(new ImageIcon(urlimage1));
		pAdmin.add(lbl3).setBounds(310, 220, 200, 190);
		
		
			
		if(s == null || (s != null && ("".equals(s))))   
		{
		   System.exit(0);
		}
		
		
		try{
		
			
			stmt=con.createStatement();
			rs = stmt.executeQuery("select * from contributorreg  WHERE cid ='"+s+"'");
			
		/*if(s==null){
			
		}*/
				while(rs.next()){
			txtcfName.setText(rs.getString("fname"));
			txtEmail.setText(rs.getString("email"));
			txtpNumber.setText(rs.getString("cpnumber"));
			txtnkName.setText(rs.getString("nextofkinname"));
			txtnkNumber.setText(rs.getString("nextofkinnumber"));
			
		}}
		
		catch (Exception e) {
			// TODO: handle exception
		
		}
	}
	public static void main(String[] args) {
		search_contributor sam= new search_contributor();
		sam.setSize(500,450);
		sam.setLocationRelativeTo(null);
		sam.setVisible(true);
		
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

		}
	
	}