package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import control.Constant;
import jdbc.UpdateDocument;
import vo.Author;
import vo.Book;
import vo.Branch;
import vo.ChiefEditor;
import vo.ConferenceProceeding;
import vo.Document;
import vo.JournalVolume;
import vo.Publisher;
import vo.Reader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class LibraryManagement extends JFrame {

	private static final long serialVersionUID = 1331809788690220988L;
	private JPanel contentPane;
	private JTextField txtReadername;
	private JTextField txtReaderid;
	private JTextField txtPublisherName;
	private JTextField txtAuthorName;
	private JTextField txtTitle;
	private JTable table;
	private JTextField txtDescriptor;
	private JTextField txtWelcomeToThe;
	private JTextField textField_R_Type;
	private JTextField textField_R_ReaderName;
	private JTextField textField_R_Address;
	private JTextField textField_R_PhoneNum;
	private JTextField textField_D_PublisherName;
	private JTextField textField_D_Title;
	private JTextField textField_D_PDate;
	private JTextField textField_D_ISBN;
	private JTextField textField_D_VolumeNo;
	private JTextField textField_D_ChiefEditor;
	private JTextField textField_C_DocId;
	private JTextField textField_C_LibId;
	private JTextField textField_C_CopyNo;
	private JTextField textField_C_Position;
	private JTextField textField_Name;
	private JTextField textField_Location;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_Descriptor;
	private JTextField textField_AuthorName;
	private JTextField textField_CDate;
	private JTextField textField_CLocation;
	private JRadioButton rdbtnBook;
	private JRadioButton rdbtnJournal;
	private JRadioButton rdbtnCP;
	private int docType;
	private JTextField textField_CEditor;
	private JLabel lblCEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagement frame = new LibraryManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibraryManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
		);
	
		JLayeredPane layeredPane_New = new JLayeredPane();
		layeredPane_New.setBounds(148, 6, 774, 580);
		layeredPane.add(layeredPane_New);
		layeredPane_New.setVisible(false);
		
		JTabbedPane tabbedPane_New = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_New.setBounds(6, 19, 762, 555);
		layeredPane_New.add(tabbedPane_New);
		
		JPanel panel_N_Reader = new JPanel();
		tabbedPane_New.addTab("Reader", null, panel_N_Reader, null);
				
		textField_R_Type = new JTextField();
		textField_R_Type.setBounds(48, 88, 93, 39);
		textField_R_Type.setColumns(10);
		
		
		
		textField_R_ReaderName = new JTextField();
		textField_R_ReaderName.setBounds(189, 88, 93, 39);
		textField_R_ReaderName.setColumns(10);
		
		//---------------
		
		JButton R_add = new JButton("ADD");
		R_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Reader reader = new Reader();
				reader.setPhoneNum(textField_R_Type.getText());
				reader.setName(textField_R_ReaderName.getText());
				reader.setAddress(textField_R_Address.getText());
				reader.setPhoneNum(textField_R_PhoneNum.getText());
				
			}
		});
		R_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		R_add.setBounds(612, 89, 93, 38);
		panel_N_Reader.setLayout(null);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Arial", Font.PLAIN, 11));
		lblType.setBounds(77, 63, 36, 15);
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_N_Reader.add(lblType);

		JLabel lblReadername_ReaderName = new JLabel("READERNAME");
		lblReadername_ReaderName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReadername_ReaderName.setBounds(199, 63, 83, 15);
		panel_N_Reader.add(lblReadername_ReaderName);

		JLabel lblAdress = new JLabel("ADRESS");
		lblAdress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAdress.setBounds(350, 63, 54, 15);
		panel_N_Reader.add(lblAdress);
		
		JLabel lblPhonenum = new JLabel("PHONENUM");
		lblPhonenum.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhonenum.setBounds(481, 63, 66, 15);
		panel_N_Reader.add(lblPhonenum);
		panel_N_Reader.add(textField_R_Type);
		panel_N_Reader.add(textField_R_ReaderName);
		
		textField_R_Address = new JTextField();
		textField_R_Address.setBounds(330, 88, 93, 39);
		textField_R_Address.setColumns(10);
		
		panel_N_Reader.add(textField_R_Address);
		
		
		textField_R_PhoneNum = new JTextField();
		textField_R_PhoneNum.setBounds(471, 88, 93, 39);
		textField_R_PhoneNum.setColumns(10);

		panel_N_Reader.add(textField_R_PhoneNum);
		panel_N_Reader.add(R_add);
		
		JPanel panel_N_Document = new JPanel();
		tabbedPane_New.addTab("Document", null, panel_N_Document, null);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIsbn.setBounds(55, 139, 23, 14);
		
		textField_D_ISBN = new JTextField();
		textField_D_ISBN.setBounds(29, 161, 90, 35);
		textField_D_ISBN.setColumns(10);

		JLabel lblVolumeno = new JLabel("Volume Number");
		lblVolumeno.setFont(new Font("Arial", Font.PLAIN, 11));
		lblVolumeno.setBounds(29, 139, 76, 14);
		
		textField_D_VolumeNo = new JTextField();
		textField_D_VolumeNo.setBounds(29, 161, 90, 35);
		textField_D_VolumeNo.setColumns(10);
		
		JLabel lblChiefEditor = new JLabel("Chief Editor");
		lblChiefEditor.setFont(new Font("Arial", Font.PLAIN, 11));
		lblChiefEditor.setBounds(149, 139, 62, 14);
		
		textField_D_ChiefEditor = new JTextField();
		textField_D_ChiefEditor.setBounds(149, 163, 90, 35);
		textField_D_ChiefEditor.setColumns(10);
		
		//---------------------
		
		Publisher publisher = new Publisher();
		Book book = new Book();
		ChiefEditor chiefEditor = new ChiefEditor();
		JournalVolume journalVolume = new JournalVolume();
		ConferenceProceeding cp = new ConferenceProceeding();
		
		//---------------------
		
		JButton D_add = new JButton("ADD");
		D_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(docType == 0){
					String[] authorArray = textField_AuthorName.getText().split(",");
					for(int i=0; i<authorArray.length; i++){
						Author author = new Author();
						author.setAuName(authorArray[i]);
						book.addAuthor(author);
					}
					String[] descriptorArray = textField_Descriptor.getText().split(",");
					for(int i=0; i<descriptorArray.length; i++){
						book.addDescriptor(descriptorArray[i]);
					}
					publisher.setPubName(textField_D_PublisherName.getText());
					book.setPublisher(publisher);
					book.setTitle(textField_D_Title.getText());
					book.setPubDate(textField_D_PDate.getText());
					book.setIsbn(textField_D_ISBN.getText());
					UpdateDocument.newBook(book);
				}
				if(docType == 1){
					String[] authorArray = textField_AuthorName.getText().split(",");
					for(int i=0; i<authorArray.length; i++){
						Author author = new Author();
						author.setAuName(authorArray[i]);
						journalVolume.addAuthor(author);
					}
					String[] descriptorArray = textField_Descriptor.getText().split(",");
					for(int i=0; i<descriptorArray.length; i++){
						journalVolume.addDescriptor(descriptorArray[i]);
					}
					publisher.setPubName(textField_D_PublisherName.getText());
					journalVolume.setPublisher(publisher);
					journalVolume.setTitle(textField_D_Title.getText());
					journalVolume.setPubDate(textField_D_PDate.getText());
					journalVolume.setVolNum(textField_D_VolumeNo.getText());
					chiefEditor.setCeName(lblChiefEditor.getText());
					journalVolume.setEditor(chiefEditor);
					UpdateDocument.newJournalVolume(journalVolume);
				}
				if(docType == 2){
					String[] authorArray = textField_AuthorName.getText().split(",");
					for(int i=0; i<authorArray.length; i++){
						Author author = new Author();
						author.setAuName(authorArray[i]);
						book.addAuthor(author);
					}
					String[] descriptorArray = textField_Descriptor.getText().split(",");
					for(int i=0; i<descriptorArray.length; i++){
						book.addDescriptor(descriptorArray[i]);
					}
					publisher.setPubName(textField_D_PublisherName.getText());
					cp.setPublisher(publisher);
					cp.setTitle(textField_D_Title.getText());
					cp.setPubDate(textField_D_PDate.getText());
					cp.setConDate(textField_CDate.getText());
					cp.setConLocation(textField_CLocation.getText());
					cp.setConEditor(textField_CEditor.getText());
					UpdateDocument.newConferenceProceeding(cp);
				}
			}
		});
		
		D_add.setBounds(624, 160, 90, 36);
		panel_N_Document.setLayout(null);
		
		JLabel lblAddPublisherName = new JLabel("Publisher Name");
		lblAddPublisherName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAddPublisherName.setBounds(29, 61, 84, 14);
		panel_N_Document.add(lblAddPublisherName);
		
		JLabel lblTitle_Title = new JLabel("Title");
		lblTitle_Title.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTitle_Title.setBounds(157, 61, 26, 14);
		panel_N_Document.add(lblTitle_Title);
		
		JLabel lblBdate = new JLabel("Publish Date");
		lblBdate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBdate.setBounds(267, 61, 59, 14);
		panel_N_Document.add(lblBdate);
		panel_N_Document.add(lblIsbn);
		panel_N_Document.add(lblVolumeno);
		panel_N_Document.add(lblChiefEditor);
		
		textField_D_PublisherName = new JTextField();
		textField_D_PublisherName.setBounds(29, 86, 90, 35);
		textField_D_PublisherName.setColumns(10);
		panel_N_Document.add(textField_D_PublisherName);
		
		textField_D_Title = new JTextField();
		textField_D_Title.setBounds(149, 85, 90, 35);
		textField_D_Title.setColumns(10);
		panel_N_Document.add(textField_D_Title);
		
		textField_D_PDate = new JTextField();
		textField_D_PDate.setBounds(267, 86, 90, 35);
		textField_D_PDate.setColumns(10);
		panel_N_Document.add(textField_D_PDate);
		panel_N_Document.add(textField_D_ISBN);
		panel_N_Document.add(textField_D_VolumeNo);
		panel_N_Document.add(textField_D_ChiefEditor);
		panel_N_Document.add(D_add);
		
		JLabel lblNewDescriptor = new JLabel("Descriptor");
		lblNewDescriptor.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewDescriptor.setBounds(386, 61, 60, 15);
		panel_N_Document.add(lblNewDescriptor);
		
		textField_Descriptor = new JTextField();
		textField_Descriptor.setBounds(386, 86, 90, 35);
		panel_N_Document.add(textField_Descriptor);
		textField_Descriptor.setColumns(10);
		
		JLabel lblNewAuthorName = new JLabel("Author Name");
		lblNewAuthorName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewAuthorName.setBounds(502, 61, 63, 14);
		panel_N_Document.add(lblNewAuthorName);
		
		textField_AuthorName = new JTextField();
		textField_AuthorName.setBounds(502, 85, 90, 36);
		panel_N_Document.add(textField_AuthorName);
		textField_AuthorName.setColumns(10);
		
		JLabel lblCDate = new JLabel("Conference Date");
		lblCDate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCDate.setBounds(29, 139, 84, 15);
		panel_N_Document.add(lblCDate);
		
		textField_CDate = new JTextField();
		textField_CDate.setBounds(29, 161, 88, 35);
		panel_N_Document.add(textField_CDate);
		textField_CDate.setColumns(10);
		
		JLabel lblCLocation = new JLabel("Conference Location");
		lblCLocation.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCLocation.setBounds(149, 139, 106, 15);
		panel_N_Document.add(lblCLocation);
		
		textField_CLocation = new JTextField();
		textField_CLocation.setBounds(149, 163, 90, 35);
		panel_N_Document.add(textField_CLocation);
		textField_CLocation.setColumns(10);
		
		rdbtnBook = new JRadioButton("Book");
		rdbtnBook.setSelected(true);
		rdbtnBook.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				docType = Constant.TYPE_BOOK;
				rdbtnBook.setSelected(true);
				rdbtnJournal.setSelected(false);
				rdbtnCP.setSelected(false);
				lblIsbn.setVisible(true);
				lblVolumeno.setVisible(false);
				lblChiefEditor.setVisible(false);
				lblCDate.setVisible(false);
				lblCEditor.setVisible(false);
				lblCLocation.setVisible(false);
				textField_D_ISBN.setVisible(true);
				textField_D_VolumeNo.setVisible(false);
				textField_D_ChiefEditor.setVisible(false);
				textField_CDate.setVisible(false);
				textField_CLocation.setVisible(false);
				textField_CEditor.setVisible(false);
				
				
			}
		});
		
		lblCEditor = new JLabel("Conference Editor");
		lblCEditor.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCEditor.setBounds(267, 138, 102, 15);
		panel_N_Document.add(lblCEditor);
		
		textField_CEditor = new JTextField();
		textField_CEditor.setBounds(267, 161, 90, 35);
		panel_N_Document.add(textField_CEditor);
		textField_CEditor.setColumns(10);
		textField_CEditor.setVisible(false);
		rdbtnBook.setBounds(29, 20, 84, 23);
		panel_N_Document.add(rdbtnBook);
		
		rdbtnJournal = new JRadioButton("Journal");
		rdbtnJournal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				docType = Constant.TYPE_JOURNAL_VOLUME;
				rdbtnBook.setSelected(false);
				rdbtnJournal.setSelected(true);
				rdbtnCP.setSelected(false);
				lblIsbn.setVisible(false);
				lblVolumeno.setVisible(true);
				lblChiefEditor.setVisible(true);
				lblCDate.setVisible(false);
				lblCLocation.setVisible(false);
				lblCEditor.setVisible(false);
				textField_D_ISBN.setVisible(false);
				textField_D_VolumeNo.setVisible(true);
				textField_D_ChiefEditor.setVisible(true);
				textField_CDate.setVisible(false);
				textField_CLocation.setVisible(false);
				textField_CEditor.setVisible(false);
				
			}
		});
		rdbtnJournal.setBounds(149, 20, 90, 23);
		panel_N_Document.add(rdbtnJournal);
		
		rdbtnCP = new JRadioButton("Conference Proceeding");
		rdbtnCP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				docType = Constant.TYPE_CONFERENCE_PROCEEDING;
				rdbtnBook.setSelected(false);
				rdbtnJournal.setSelected(false);
				rdbtnCP.setSelected(true);
				lblIsbn.setVisible(false);
				lblVolumeno.setVisible(false);
				lblChiefEditor.setVisible(false);
				lblCDate.setVisible(true);
				lblCLocation.setVisible(true);
				lblCEditor.setVisible(true);
				textField_D_ISBN.setVisible(false);
				textField_D_VolumeNo.setVisible(false);
				textField_D_ChiefEditor.setVisible(false);
				textField_CDate.setVisible(true);
				textField_CLocation.setVisible(true);
				textField_CEditor.setVisible(true);
				
			}
		});
		rdbtnCP.setBounds(267, 20, 179, 23);
		panel_N_Document.add(rdbtnCP);
		
		lblIsbn.setVisible(true);
		lblVolumeno.setVisible(false);
		lblChiefEditor.setVisible(false);
		lblCDate.setVisible(false);
		lblCLocation.setVisible(false);
		lblCEditor.setVisible(false);
		textField_D_ISBN.setVisible(true);
		textField_D_VolumeNo.setVisible(false);
		textField_D_ChiefEditor.setVisible(false);
		textField_CDate.setVisible(false);
		textField_CLocation.setVisible(false);
		textField_CEditor.setVisible(false);
		
		JPanel panel_N_LibraryBranch = new JPanel();
		tabbedPane_New.addTab("Library Branch", null, panel_N_LibraryBranch, null);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(49, 89, 97, 36);
		textField_Name.setColumns(10);
		
		textField_Location = new JTextField();
		textField_Location.setBounds(200, 89, 97, 36);
		textField_Location.setColumns(10);
		
		JButton L_add = new JButton("ADD");
		L_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Branch branch = new Branch();
				branch.setName(textField_Name.getText());
				branch.setLocation(textField_Location.getText());
			}
		});
		L_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		L_add.setBounds(596, 89, 97, 36);
		L_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_N_LibraryBranch.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(83, 65, 29, 14);
		panel_N_LibraryBranch.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOCATION");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(222, 65, 52, 14);
		panel_N_LibraryBranch.add(lblNewLabel_2);
		panel_N_LibraryBranch.add(textField_Name);
		panel_N_LibraryBranch.add(textField_Location);
		panel_N_LibraryBranch.add(L_add);
		
		JPanel panel_N_Copy = new JPanel();
		tabbedPane_New.addTab("Copy", null, panel_N_Copy, null);
		
		JLabel lblDocid = new JLabel("DOCNAME");
		lblDocid.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDocid.setBounds(69, 66, 51, 14);
		
		textField_C_DocId = new JTextField();
		textField_C_DocId.setBounds(53, 87, 87, 36);
		textField_C_DocId.setColumns(10);
		
		JLabel lblLibid = new JLabel("LIBNAME");
		lblLibid.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLibid.setBounds(209, 66, 44, 14);
		
		textField_C_LibId = new JTextField();
		textField_C_LibId.setBounds(193, 87, 87, 36);
		textField_C_LibId.setColumns(10);
		
		JLabel lblCopyno = new JLabel("COPYNO");
		lblCopyno.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCopyno.setBounds(69, 162, 44, 14);
		
		JLabel lblPosition = new JLabel("POSITION");
		lblPosition.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPosition.setBounds(209, 162, 46, 14);
		
		textField_C_CopyNo = new JTextField();
		textField_C_CopyNo.setBounds(53, 186, 87, 35);
		textField_C_CopyNo.setColumns(10);
		
		textField_C_Position = new JTextField();
		textField_C_Position.setBounds(193, 186, 87, 36);
		textField_C_Position.setColumns(10);
		
		JButton C_add = new JButton("ADD");
		C_add.setBounds(608, 185, 87, 36);
		panel_N_Copy.setLayout(null);
		panel_N_Copy.add(lblDocid);
		panel_N_Copy.add(lblLibid);
		panel_N_Copy.add(lblCopyno);
		panel_N_Copy.add(lblPosition);
		panel_N_Copy.add(textField_C_DocId);
		panel_N_Copy.add(textField_C_LibId);
		panel_N_Copy.add(textField_C_CopyNo);
		panel_N_Copy.add(textField_C_Position);
		panel_N_Copy.add(C_add);
		layeredPane_New.setVisible(false);
		
		JLayeredPane layeredPane_Welcome = new JLayeredPane();
		layeredPane_Welcome.setBounds(148, 0, 780, 586);
		layeredPane.add(layeredPane_Welcome);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setBackground(SystemColor.menu);
		txtWelcomeToThe.setForeground(new Color(0, 0, 128));
		txtWelcomeToThe.setEditable(false);
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		txtWelcomeToThe.setText("Welcome to the library management system!");
		txtWelcomeToThe.setBounds(49, 115, 665, 216);
		layeredPane_Welcome.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		JLayeredPane layeredPane_BR = new JLayeredPane();
		layeredPane_BR.setBounds(148, 6, 767, 580);
		layeredPane.add(layeredPane_BR);
		layeredPane_BR.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 2, 741, 75);
		layeredPane_BR.add(panel);
		panel.setLayout(null);
		
		JLabel lblReaderid = new JLabel("READERID");
		lblReaderid.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblReaderid.setBounds(21, 26, 74, 35);
		panel.add(lblReaderid);
		
		txtReaderid = new JTextField();
		txtReaderid.setBounds(105, 25, 120, 35);
		panel.add(txtReaderid);
		txtReaderid.setForeground(SystemColor.desktop);
		txtReaderid.setHorizontalAlignment(SwingConstants.CENTER);
		txtReaderid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReaderid.setColumns(10);
		
		//-----------------------
		
		JLabel lblReadername = new JLabel("READERNAME");
		lblReadername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblReadername.setBounds(247, 26, 93, 35);
		panel.add(lblReadername);
		
		txtReadername = new JTextField();
		txtReadername.setBounds(350, 25, 120, 35);
		panel.add(txtReadername);
		txtReadername.setForeground(SystemColor.desktop);
		txtReadername.setHorizontalAlignment(SwingConstants.CENTER);
		txtReadername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReadername.setColumns(10);
		
		//-----------------------
		
		JButton btnNewButton_4 = new JButton("SEARCH");
		btnNewButton_4.setBounds(595, 26, 120, 35);
		panel.add(btnNewButton_4);
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		//-----------------------
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(10, 83, 741, 487);
		layeredPane_BR.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPublisherName = new JLabel("<html>PUBLISHER<br>NAME<html>");
		lblPublisherName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPublisherName.setBounds(21, 11, 74, 35);
		panel_1.add(lblPublisherName);
		
		txtPublisherName = new JTextField();
		txtPublisherName.setBounds(105, 11, 120, 35);
		panel_1.add(txtPublisherName);
		txtPublisherName.setForeground(SystemColor.desktop);
		txtPublisherName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtPublisherName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPublisherName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>AUTHOR<br>NAME<html>");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(247, 11, 74, 35);
		panel_1.add(lblNewLabel);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setBounds(350, 11, 120, 35);
		panel_1.add(txtAuthorName);
		txtAuthorName.setForeground(SystemColor.desktop);
		txtAuthorName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthorName.setColumns(10);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTitle.setBounds(21, 57, 74, 35);
		panel_1.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(105, 55, 120, 35);
		panel_1.add(txtTitle);
		txtTitle.setForeground(SystemColor.desktop);
		txtTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setColumns(10);
		
		JLabel lblDescriptor = new JLabel("DESCRIPTOR");
		lblDescriptor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDescriptor.setBounds(247, 57, 74, 35);
		panel_1.add(lblDescriptor);
		
		txtDescriptor = new JTextField();
		txtDescriptor.setBounds(350, 55, 120, 35);
		panel_1.add(txtDescriptor);
		txtDescriptor.setForeground(SystemColor.desktop);
		txtDescriptor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescriptor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDescriptor.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(595, 57, 117, 35);
		panel_1.add(btnSearch);
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		table = new JTable();
		table.setBounds(9, 102, 722, 330);
		panel_1.add(table);
		
		JButton btnNewButton_5 = new JButton("BORROW");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_5.setBounds(458, 442, 117, 35);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setForeground(Color.BLUE);
		
		JButton btnNewButton_6 = new JButton("RESERVE");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_6.setBounds(597, 442, 117, 35);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.setForeground(Color.BLUE);
		
		JLayeredPane layeredPane_Update = new JLayeredPane();
		layeredPane_Update.setBounds(148, 6, 774, 580);
		layeredPane.add(layeredPane_Update);
		layeredPane_Update.setVisible(false);
		
		JTabbedPane tabbedPane_Update = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Update.setBounds(6, 17, 762, 557);
		layeredPane_Update.add(tabbedPane_Update);
		
		JPanel panel_U_Reader = new JPanel();
		tabbedPane_Update.addTab("Reader", null, panel_U_Reader, null);
		
		JLabel lblReaderid_1 = new JLabel("READERID");
		lblReaderid_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReaderid_1.setBounds(23, 62, 70, 15);
		
		JLabel lblType_1 = new JLabel("TYPE");
		lblType_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblType_1.setBounds(143, 62, 53, 15);
		
		JLabel lblReadname = new JLabel("READNAME");
		lblReadname.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReadname.setBounds(238, 62, 70, 15);
		
		JLabel lblNumborbooks_1 = new JLabel("NUMBORBOOKS");
		lblNumborbooks_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNumborbooks_1.setBounds(342, 62, 89, 15);
		
		JLabel lblNumresbooks_1 = new JLabel("NUMRESBOOKS");
		lblNumresbooks_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNumresbooks_1.setBounds(441, 62, 80, 15);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAddress.setBounds(552, 62, 63, 15);
		
		JLabel lblPhonenum_1 = new JLabel("PHONENUM");
		lblPhonenum_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhonenum_1.setBounds(656, 62, 70, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(13, 87, 93, 43);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(119, 87, 97, 43);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(229, 87, 93, 43);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(335, 87, 93, 43);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(441, 87, 93, 43);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(547, 87, 89, 43);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(649, 87, 93, 43);
		textField_8.setColumns(10);
		
		JButton btnUpdate_2 = new JButton("UPDATE");
		btnUpdate_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUpdate_2.setBounds(649, 181, 93, 39);
		panel_U_Reader.setLayout(null);
		panel_U_Reader.add(lblReaderid_1);
		panel_U_Reader.add(textField_2);
		panel_U_Reader.add(lblType_1);
		panel_U_Reader.add(lblReadname);
		panel_U_Reader.add(textField_3);
		panel_U_Reader.add(textField_4);
		panel_U_Reader.add(lblNumborbooks_1);
		panel_U_Reader.add(textField_5);
		panel_U_Reader.add(lblNumresbooks_1);
		panel_U_Reader.add(textField_6);
		panel_U_Reader.add(textField_7);
		panel_U_Reader.add(lblAddress);
		panel_U_Reader.add(btnUpdate_2);
		panel_U_Reader.add(textField_8);
		panel_U_Reader.add(lblPhonenum_1);
		
		JPanel panel_U_Branch = new JPanel();
		tabbedPane_Update.addTab("Library Branch", null, panel_U_Branch, null);
		
		JLabel lblLibid_2 = new JLabel("LIBID");
		lblLibid_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLibid_2.setBounds(94, 64, 30, 15);
		
		textField_19 = new JTextField();
		textField_19.setBounds(62, 89, 111, 39);
		textField_19.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NAME");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(266, 64, 48, 15);
		
		textField_20 = new JTextField();
		textField_20.setBounds(235, 89, 111, 39);
		textField_20.setColumns(10);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLocation.setBounds(423, 64, 69, 15);
		
		textField_21 = new JTextField();
		textField_21.setBounds(408, 89, 111, 39);
		textField_21.setColumns(10);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUpdate_1.setBounds(581, 90, 111, 37);
		panel_U_Branch.setLayout(null);
		panel_U_Branch.add(textField_19);
		panel_U_Branch.add(textField_20);
		panel_U_Branch.add(textField_21);
		panel_U_Branch.add(btnUpdate_1);
		panel_U_Branch.add(lblLibid_2);
		panel_U_Branch.add(lblNewLabel_5);
		panel_U_Branch.add(lblLocation);
		
		JPanel panel_U_Document = new JPanel();
		tabbedPane_Update.addTab("Document", null, panel_U_Document, null);
		
		JLabel lblDocid_1 = new JLabel("DOCID");
		lblDocid_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDocid_1.setBounds(45, 68, 31, 14);
		
		textField_9 = new JTextField();
		textField_9.setBounds(14, 92, 109, 40);
		textField_9.setColumns(10);
		
		JLabel lblPublisherid_1 = new JLabel("PUBLISHERID");
		lblPublisherid_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPublisherid_1.setBounds(160, 68, 64, 14);
		
		textField_10 = new JTextField();
		textField_10.setBounds(137, 92, 109, 40);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TITLE");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(293, 68, 26, 14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(260, 92, 109, 40);
		textField_11.setColumns(10);
		
		JLabel lblPdate = new JLabel("PDATE");
		lblPdate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPdate.setBounds(422, 68, 33, 14);
		
		textField_12 = new JTextField();
		textField_12.setBounds(383, 91, 109, 41);
		textField_12.setColumns(10);
		
		JLabel lblBfg_1 = new JLabel("B_FG");
		lblBfg_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBfg_1.setBounds(542, 68, 27, 14);
		
		textField_13 = new JTextField();
		textField_13.setBounds(506, 91, 109, 41);
		textField_13.setColumns(10);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		lblIsbn_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIsbn_1.setBounds(45, 148, 23, 14);
		
		textField_14 = new JTextField();
		textField_14.setBounds(14, 172, 109, 41);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("J_FG");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(174, 148, 25, 14);
		
		textField_15 = new JTextField();
		textField_15.setBounds(137, 172, 109, 41);
		textField_15.setColumns(10);
		
		JLabel lblVolumeno_1 = new JLabel("VOLUMENO");
		lblVolumeno_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblVolumeno_1.setBounds(286, 148, 58, 14);
		
		textField_16 = new JTextField();
		textField_16.setBounds(260, 172, 109, 41);
		textField_16.setColumns(10);
		
		JLabel lblEditorid_1 = new JLabel("EDITORID");
		lblEditorid_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEditorid_1.setBounds(410, 148, 45, 14);
		
		textField_17 = new JTextField();
		textField_17.setBounds(383, 172, 109, 41);
		textField_17.setColumns(10);
		
		JLabel lblPfg_1 = new JLabel("P_FG");
		lblPfg_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPfg_1.setBounds(543, 149, 26, 14);
		
		textField_18 = new JTextField();
		textField_18.setBounds(506, 173, 109, 41);
		textField_18.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUpdate.setBounds(629, 171, 109, 42);
		panel_U_Document.setLayout(null);
		panel_U_Document.add(textField_14);
		panel_U_Document.add(textField_15);
		panel_U_Document.add(textField_16);
		panel_U_Document.add(textField_17);
		panel_U_Document.add(textField_18);
		panel_U_Document.add(lblDocid_1);
		panel_U_Document.add(textField_9);
		panel_U_Document.add(textField_10);
		panel_U_Document.add(textField_11);
		panel_U_Document.add(textField_12);
		panel_U_Document.add(textField_13);
		panel_U_Document.add(lblPublisherid_1);
		panel_U_Document.add(lblNewLabel_3);
		panel_U_Document.add(lblPdate);
		panel_U_Document.add(lblBfg_1);
		panel_U_Document.add(lblIsbn_1);
		panel_U_Document.add(lblNewLabel_4);
		panel_U_Document.add(lblVolumeno_1);
		panel_U_Document.add(lblEditorid_1);
		panel_U_Document.add(lblPfg_1);
		panel_U_Document.add(btnUpdate);
		
		JButton btnNewButton_new = new JButton("New");
		btnNewButton_new.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Welcome.setVisible(false);
				layeredPane_BR.setVisible(false);
				layeredPane_New.setVisible(true);
				layeredPane_Update.setVisible(false);
			}
		});
		
		JButton btnNewButton_br = new JButton("Borrow/reserve");
		btnNewButton_br.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_br.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Welcome.setVisible(false);
				layeredPane_BR.setVisible(true);
				layeredPane_New.setVisible(false);
				layeredPane_Update.setVisible(false);
			}
		});
		btnNewButton_br.setBounds(9, 62, 131, 42);
		layeredPane.add(btnNewButton_br);
		btnNewButton_new.setBounds(6, 133, 134, 39);
		layeredPane.add(btnNewButton_new);
		
		JButton btnNewButton_quit = new JButton("Quit");
		btnNewButton_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton_update = new JButton("Update");
		btnNewButton_update.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Welcome.setVisible(false);
				layeredPane_BR.setVisible(false);
				layeredPane_New.setVisible(false);
				layeredPane_Update.setVisible(true);
			}
		});
		btnNewButton_update.setBounds(9, 200, 134, 39);
		layeredPane.add(btnNewButton_update);
		btnNewButton_quit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_quit.setBounds(9, 267, 131, 40);
		layeredPane.add(btnNewButton_quit);
		contentPane.setLayout(groupLayout);
	}
}
