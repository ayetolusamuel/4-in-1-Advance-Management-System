package DailyContributor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class dailycontributor extends JFrame implements ActionListener, FocusListener {
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
			txtpNumber, txtnkNumber, txtnkName,txtaName, txtTime, txtDate,
			txtBonus;
	TextArea txtOthers;
	PreparedStatement ps = null;

	private JComboBox jcmbaType;

	JButton btnSave, btnRemove, btnPreview, btnExit, btnModify, btnNew,
			btnmessage,btnSearch;

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
	public dailycontributor() {
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
		setTitle("Staff Payroll System");
		setSize(397, 510);
		setLocation(100, 60);
	
		pAdmin.setLayout(null);
		
		
		
		lblDate = new JLabel("<html><b><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Serif", Font.ITALIC, 16));
		pAdmin.add(lblDate).setBounds(339, -40, 70, 120);

		txtDate = new JTextField(d);
		txtDate.setFont(new Font("Algerian", Font.ITALIC, 13));
		txtDate.setEditable(false);
		pAdmin.add(txtDate).setBounds(383, 12, 90, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblTime).setBounds(339, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		txtTime.setEditable(false);
		txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtTime).setBounds(383, 40, 90, 20);


		lblcfName = new JLabel("<html><b><b>Full Name :</i></b></html>");
		lblcfName.setForeground(Color.white);
		lblcfName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblcfName).setBounds(10, -40, 100, 120);

		txtcfName = new JTextField("hdbfchds,chjbdschdsbchbshbc");
		txtcfName.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtcfName.setEditable(false);
		pAdmin.add(txtcfName).setBounds(90, 12, 220, 20);

		lblEmail = new JLabel("<html><i><b>Email :</i></b></html>");
		lblEmail.setForeground(Color.white);
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblEmail).setBounds(10, -10, 70, 120);
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Algerian", Font.ITALIC, 13));
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
		
		lblnkNumber = new JLabel("<html><b>Amount Deposited :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lblnkNumber).setBounds(10, 168, 100, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(true);
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
		pAdmin.add(txtnkNumber).setBounds(130, 219, 100, 20);
		
		
		lblnkNumber = new JLabel("<html><b>Balance :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 198, 180, 120);
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
		pAdmin.add(txtnkNumber).setBounds(130, 249, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Commision :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 228, 180, 120);
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
		pAdmin.add(txtnkNumber).setBounds(130, 279, 100, 20);
		
		lblnkNumber = new JLabel("<html><b>Loan/Withdraw :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblnkNumber).setBounds(10, 258, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setEditable(true);
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
		pAdmin.add(txtnkNumber).setBounds(130, 309, 100, 20);
		
		
		
		
		
	/*	
		JFrame frame = new JFrame();
		String[] options = new String[2];
		options[0] = new String("Agree");
		options[1] = new String("Disagree");
		JOptionPane.showOptionDialog(frame.getContentPane(),"Message!","Title", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
		
		*
		*int res = JOptionPane.showConfirmDialog(null, "Are you want to continue the process?", "", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
            JOptionPane.showMessageDialog(null, "Process Successfully");
            break;
            case JOptionPane.NO_OPTION:
            JOptionPane.showMessageDialog(null, "Process is Canceled");
            break;
        }
		*
		*
		*
		*
		*
		*
		*/
		
		
		/*lblpNumber = new JLabel("<html><b>Phone Num:</i></b></html>");
		lblpNumber.setForeground(Color.white);
		lblpNumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		pAdmin.add(lblpNumber).setBounds(10, 156, 180, 20);
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
		pAdmin.add(txtpNumber).setBounds(90,158,230,20);*/
		/*
		
		lblGender = new JLabel("<html><b>Gender :</i></b></html>");
		lblGender.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblGender.setForeground(Color.white);
		pAdmin.add(lblGender).setBounds(10, 190, 100, 20);
	

		cbmf = new CheckboxGroup();
		cbm = new Checkbox("Male", cbmf, true);
		cbf = new Checkbox("Female", cbmf, false);
		cbm.setBounds(94, 225, 50, 15);
		add(cbm);
		cbf.setBounds(190, 225, 80, 15);
		add(cbf);

		lblrAddress = new JLabel("<html><b>Res. Address:</i></b></html>");
		lblrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblrAddress.setForeground(Color.white);
		pAdmin.add(lblrAddress).setBounds(10, 220, 80, 25);


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
		txtrAddress.setBounds(90, 224, 370, 100);
		pAdmin.add(txtrAddress);
		
		lblnkName = new JLabel("<html><i><b>Next of Kin Name :</i></b></html>");
		lblnkName.setForeground(Color.white);
		lblnkName.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lblnkName).setBounds(0, 280, 180, 120);
		txtnkName= new JTextField();
		txtnkName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkName.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtnkName).setBounds(90, 332, 290, 20);
		
		lblnkNumber = new JLabel("<html><i><b>Next of Kin Number :</i></b></html>");
		lblnkNumber.setForeground(Color.white);
		lblnkNumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		pAdmin.add(lblnkNumber).setBounds(0,310, 180, 120);
		txtnkNumber = new JTextField();
		txtnkNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtnkNumber.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtnkNumber).setBounds(115, 360, 265, 20);
		
		
		lblofficialinfo = new JLabel("<html><i><b>Official Portal(Bank Details-Optional)</i></b></html>");
		lblofficialinfo.setForeground(Color.red);
		lblofficialinfo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		pAdmin.add(lblofficialinfo).setBounds(40,338, 300, 120);
		

		lblaName = new JLabel("<html><i><b>Account Name :</i></b></html>");
		lblaName.setForeground(Color.white);
		lblaName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblaName).setBounds(40,370, 180, 120);
		txtaName = new JTextField();
		txtaName.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtaName.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtaName).setBounds(160, 422, 290, 20);
		
	lblaNumber = new JLabel("<html><i><b>Account Number :</i></b></html>");
		lblaNumber.setForeground(Color.white);
		lblaNumber.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblaNumber).setBounds(30,400, 180, 120);
		txtaNumber = new JTextField();
		txtaNumber.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtaNumber.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtaNumber).setBounds(160, 450, 290, 20);
		
		lblaType = new JLabel("<html><i><b>Account Type :</i></b></html>");
		lblaType.setForeground(Color.white);
		lblaType.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblaType).setBounds(40,430, 180, 120);
		
		jcmbaType = new JComboBox(account_type);
		jcmbaType.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		jcmbaType.setFont(new Font("Times New Roman",Font.ITALIC,12));
		pAdmin.add(jcmbaType).setBounds(160, 480, 145, 22);
		*//*
		
		
		
		*/
		
		btnSave = new JButton("Save");
		pAdmin.add(btnSave).setBounds(0, 335, 65, 25);
		btnNew = new JButton("New");
		pAdmin.add(btnNew).setBounds(69, 335, 60, 25);
		btnModify = new JButton("Modify");
		pAdmin.add(btnModify).setBounds(135, 335, 80, 25);

		btnPreview = new JButton("Preview");
		pAdmin.add(btnPreview).setBounds(225, 335, 80, 25);
		btnRemove = new JButton("Remove");
		pAdmin.add(btnRemove).setBounds(310, 335, 85, 25);
		btnExit = new JButton("Exit");
		pAdmin.add(btnExit).setBounds(399, 335, 75, 25);
		cont=getContentPane();
	    
		cont.add( new textcontributor(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		/*btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnPreview.addActionListener(this);
		btnExit.addActionListener(this);
		btnModify.addActionListener(this);*/

	}
	static void productdetails(){
		
		try{
		String s = JOptionPane.showInputDialog(null,"<html><i>		Enter the Contributor ID");
		
		

		/*
		 switch (s) {
         case 
         JOptionPane.showMessageDialog(null, "Process Successfully");
         break;
         case JOptionPane.NO_OPTION:
         JOptionPane.showMessageDialog(null, "Process is Canceled");
         break;
		//pane.add(sam);
		//show();
*/		}
		
		catch (Exception e) {
			// TODO: handle exception
		
		
		System.out.println("Error");
		}
	}
	public static void main(String[] args) {
		productdetails();
		dailycontributor sam = new dailycontributor();
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

		}
	
	}