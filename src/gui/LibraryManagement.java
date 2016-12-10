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
import javax.swing.LayoutStyle.ComponentPlacement;

public class LibraryManagement extends JFrame {

	private static final long serialVersionUID = 1331809788690220988L;
	private JPanel contentPane;
	private JTextField txtReadername;
	private JTextField txtReaderid;
	private JTextField textField;
	private JTextField txtPublisherName;
	private JTextField txtAuthorName;
	private JTextField txtTitle;
	private JTable table;
	private JTextField textField_1;
	private JTextField txtDescriptor;
	private JTextField txtWelcomeToThe;
	private JTextField textField_R_ReaderId;
	private JTextField textField_R_Type;
	private JTextField textField_R_ReaderName;
	private JTextField textField_R_NumBorBooks;
	private JTextField textField_R_NumResBooks;
	private JTextField textField_R_Address;
	private JTextField textField_R_PhoneNum;
	private JTextField textField_D_DocId;
	private JTextField textField_D_PublisherId;
	private JTextField textField_D_Title;
	private JTextField textField_D_PDate;
	private JTextField textField_D_BFg;
	private JTextField textField_D_ISBN;
	private JTextField textField_D_JFg;
	private JTextField textField_D_VolumeNo;
	private JTextField textField_D_EditorId;
	private JTextField textField_D_PFg;
	private JTextField textField_C_DocId;
	private JTextField textField_C_LibId;
	private JTextField textField_C_CopyNo;
	private JTextField textField_C_Position;
	private JTextField textField_LibId;
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
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLayeredPane layeredPane_Welcome = new JLayeredPane();
		layeredPane_Welcome.setBounds(148, 0, 780, 586);
		layeredPane.add(layeredPane_Welcome);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setBackground(SystemColor.window);
		txtWelcomeToThe.setForeground(new Color(0, 0, 128));
		txtWelcomeToThe.setEditable(false);
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		txtWelcomeToThe.setText("Welcome to the library management system!");
		txtWelcomeToThe.setBounds(62, 110, 665, 216);
		layeredPane_Welcome.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		JLayeredPane layeredPane_BR = new JLayeredPane();
		layeredPane_BR.setBounds(148, 6, 774, 580);
		layeredPane.add(layeredPane_BR);
		layeredPane_BR.setVisible(false);
		
		JLabel lblReaderid = new JLabel("READERID");
		lblReaderid.setBounds(29, 38, 74, 16);
		layeredPane_BR.add(lblReaderid);
		
		txtReaderid = new JTextField();
		txtReaderid.setForeground(Color.LIGHT_GRAY);
		txtReaderid.setHorizontalAlignment(SwingConstants.CENTER);
		txtReaderid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReaderid.setBounds(115, 28, 100, 35);
		layeredPane_BR.add(txtReaderid);
		txtReaderid.setColumns(10);
		
		JLabel lblReadername = new JLabel("READERNAME");
		lblReadername.setBounds(255, 38, 95, 16);
		layeredPane_BR.add(lblReadername);
		
		txtReadername = new JTextField();
		txtReadername.setForeground(Color.LIGHT_GRAY);
		txtReadername.setHorizontalAlignment(SwingConstants.CENTER);
		txtReadername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReadername.setBounds(373, 28, 117, 35);
		layeredPane_BR.add(txtReadername);
		txtReadername.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("search");
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_4.setBounds(579, 26, 141, 41);
		layeredPane_BR.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(SystemColor.window);
		textField.setBounds(6, 6, 762, 81);
		layeredPane_BR.add(textField);
		textField.setColumns(10);
		
		JLabel lblPublisherName = new JLabel("<html>PUBLISHER<br>NAME<html>");
		lblPublisherName.setBounds(29, 99, 74, 35);
		layeredPane_BR.add(lblPublisherName);
		
		txtPublisherName = new JTextField();
		txtPublisherName.setForeground(Color.LIGHT_GRAY);
		txtPublisherName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtPublisherName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPublisherName.setBounds(115, 99, 100, 35);
		layeredPane_BR.add(txtPublisherName);
		txtPublisherName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>AUTHOR<br>NAME<html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(255, 100, 74, 34);
		layeredPane_BR.add(lblNewLabel);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setForeground(Color.LIGHT_GRAY);
		txtAuthorName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthorName.setBounds(373, 99, 120, 35);
		layeredPane_BR.add(txtAuthorName);
		txtAuthorName.setColumns(10);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setBounds(29, 156, 61, 16);
		layeredPane_BR.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setForeground(Color.LIGHT_GRAY);
		txtTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setBounds(115, 146, 100, 35);
		layeredPane_BR.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDescriptor = new JLabel("DESCRIPTOR");
		lblDescriptor.setBounds(265, 156, 85, 16);
		layeredPane_BR.add(lblDescriptor);
		
		txtDescriptor = new JTextField();
		txtDescriptor.setForeground(Color.LIGHT_GRAY);
		txtDescriptor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescriptor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDescriptor.setBounds(373, 146, 117, 35);
		layeredPane_BR.add(txtDescriptor);
		txtDescriptor.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearch.setBounds(579, 120, 141, 41);
		layeredPane_BR.add(btnSearch);
		
		table = new JTable();
		table.setBounds(20, 186, 737, 341);
		layeredPane_BR.add(table);
		
		JButton btnNewButton_5 = new JButton("BORROW");
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setBounds(463, 539, 117, 35);
		layeredPane_BR.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("RESERVE");
		btnNewButton_6.setForeground(Color.BLUE);
		btnNewButton_6.setBounds(603, 539, 117, 35);
		layeredPane_BR.add(btnNewButton_6);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(SystemColor.window);
		textField_1.setBounds(6, 90, 762, 484);
		layeredPane_BR.add(textField_1);
		textField_1.setColumns(10);
		
		JLayeredPane layeredPane_New = new JLayeredPane();
		layeredPane_New.setBounds(148, 6, 774, 580);
		layeredPane.add(layeredPane_New);
		layeredPane_New.setVisible(false);
		
		JTabbedPane tabbedPane_New = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_New.setBounds(6, 19, 762, 555);
		layeredPane_New.add(tabbedPane_New);
		
		JPanel panel_N_Reader = new JPanel();
		tabbedPane_New.addTab("Reader", null, panel_N_Reader, null);
		
		JLabel lblTab = new JLabel("READERID");
		
		textField_R_ReaderId = new JTextField();
		textField_R_ReaderId.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_R_Type = new JTextField();
		textField_R_Type.setColumns(10);
		
		JLabel lblReadername_ReaderName = new JLabel("READERNAME");
		
		JLabel lblNumborbooks = new JLabel("NUMBORBOOKS");
		
		textField_R_ReaderName = new JTextField();
		textField_R_ReaderName.setColumns(10);
		
		JLabel lblNumresbooks = new JLabel("NUMRESBOOKS");
		
		textField_R_NumBorBooks = new JTextField();
		textField_R_NumBorBooks.setColumns(10);
		
		textField_R_NumResBooks = new JTextField();
		textField_R_NumResBooks.setColumns(10);
		
		JLabel lblAdress = new JLabel("ADRESS");
		
		textField_R_Address = new JTextField();
		textField_R_Address.setColumns(10);
		
		JLabel lblPhonenum = new JLabel("PHONENUM");
		
		textField_R_PhoneNum = new JTextField();
		textField_R_PhoneNum.setColumns(10);
		
		JButton R_add = new JButton("ADD");
		GroupLayout gl_panel_N_Reader = new GroupLayout(panel_N_Reader);
		gl_panel_N_Reader.setHorizontalGroup(
			gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Reader.createSequentialGroup()
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_N_Reader.createSequentialGroup()
							.addGap(16)
							.addComponent(lblTab))
						.addGroup(Alignment.TRAILING, gl_panel_N_Reader.createSequentialGroup()
							.addGap(16)
							.addComponent(textField_R_ReaderId, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_N_Reader.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_R_Type, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_N_Reader.createSequentialGroup()
							.addGap(31)
							.addComponent(lblType)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_R_ReaderName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReadername_ReaderName, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNumborbooks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_R_NumBorBooks, 0, 0, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_R_NumResBooks, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNumresbooks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_N_Reader.createSequentialGroup()
							.addGap(29)
							.addComponent(lblAdress)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblPhonenum)
							.addGap(43))
						.addGroup(gl_panel_N_Reader.createSequentialGroup()
							.addComponent(textField_R_Address, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
								.addComponent(R_add, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(textField_R_PhoneNum, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
							.addGap(29))))
		);
		gl_panel_N_Reader.setVerticalGroup(
			gl_panel_N_Reader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Reader.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTab)
						.addComponent(lblType)
						.addComponent(lblNumresbooks)
						.addComponent(lblAdress)
						.addComponent(lblReadername_ReaderName)
						.addComponent(lblNumborbooks)
						.addComponent(lblPhonenum))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_N_Reader.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_R_ReaderId, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_Type, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_ReaderName, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_NumBorBooks, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_NumResBooks, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_Address, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_R_PhoneNum, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(R_add, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(305))
		);
		panel_N_Reader.setLayout(gl_panel_N_Reader);
		
		JPanel panel_N_Document = new JPanel();
		tabbedPane_New.addTab("Document", null, panel_N_Document, null);
		
		JLabel lblTab_DocId = new JLabel("DOCID");
		
		textField_D_DocId = new JTextField();
		textField_D_DocId.setColumns(10);
		
		JLabel lblPublisherid = new JLabel("PUBLISHERID");
		
		textField_D_PublisherId = new JTextField();
		textField_D_PublisherId.setColumns(10);
		
		textField_D_Title = new JTextField();
		textField_D_Title.setColumns(10);
		
		JLabel lblTitle_Title = new JLabel("TITLE");
		
		JLabel lblBdate = new JLabel("PDATE");
		
		textField_D_PDate = new JTextField();
		textField_D_PDate.setColumns(10);
		
		JLabel lblBfg = new JLabel("B_FG");
		
		textField_D_BFg = new JTextField();
		textField_D_BFg.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		textField_D_ISBN = new JTextField();
		textField_D_ISBN.setColumns(10);
		
		JLabel lblJfg = new JLabel("J_FG");
		
		textField_D_JFg = new JTextField();
		textField_D_JFg.setColumns(10);
		
		JLabel lblVolumeno = new JLabel("VOLUMENO");
		
		textField_D_VolumeNo = new JTextField();
		textField_D_VolumeNo.setColumns(10);
		
		JLabel lblEditorid = new JLabel("EDITORID");
		
		textField_D_EditorId = new JTextField();
		textField_D_EditorId.setColumns(10);
		
		JLabel lblPfg = new JLabel("P_FG");
		
		textField_D_PFg = new JTextField();
		textField_D_PFg.setColumns(10);
		
		JButton D_add = new JButton("ADD");
		GroupLayout gl_panel_N_Document = new GroupLayout(panel_N_Document);
		gl_panel_N_Document.setHorizontalGroup(
			gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Document.createSequentialGroup()
					.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_N_Document.createSequentialGroup()
							.addGap(40)
							.addComponent(lblIsbn)
							.addGap(66)
							.addComponent(lblJfg)
							.addGap(79)
							.addComponent(lblVolumeno)
							.addGap(48)
							.addComponent(lblEditorid)
							.addGap(72)
							.addComponent(lblPfg))
						.addGroup(gl_panel_N_Document.createSequentialGroup()
							.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(37)
									.addComponent(lblTab_DocId))
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(15)
									.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_D_ISBN, 0, 0, Short.MAX_VALUE)
										.addComponent(textField_D_DocId, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
							.addGap(18)
							.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_D_JFg, 0, 0, Short.MAX_VALUE)
								.addComponent(lblPublisherid)
								.addComponent(textField_D_PublisherId, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(48)
									.addComponent(lblTitle_Title)
									.addGap(80)
									.addComponent(lblBdate))
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_D_VolumeNo, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(textField_D_Title, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_D_EditorId, 0, 0, Short.MAX_VALUE)
										.addComponent(textField_D_PDate, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))))
							.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(46)
									.addComponent(lblBfg))
								.addGroup(gl_panel_N_Document.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_D_PFg, 0, 0, Short.MAX_VALUE)
										.addComponent(textField_D_BFg, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
									.addGap(38)
									.addComponent(D_add, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel_N_Document.setVerticalGroup(
			gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Document.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTab_DocId)
						.addComponent(lblPublisherid)
						.addComponent(lblTitle_Title)
						.addComponent(lblBdate)
						.addComponent(lblBfg))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_D_DocId, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(textField_D_PublisherId, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_D_Title, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(textField_D_PDate, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(textField_D_BFg, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(lblJfg)
						.addComponent(lblVolumeno)
						.addComponent(lblEditorid)
						.addComponent(lblPfg))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_D_PFg, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(D_add, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
						.addComponent(textField_D_EditorId, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(textField_D_VolumeNo, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGroup(gl_panel_N_Document.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_D_ISBN, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(textField_D_JFg, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
					.addGap(307))
		);
		panel_N_Document.setLayout(gl_panel_N_Document);
		
		JPanel panel_N_Copy = new JPanel();
		tabbedPane_New.addTab("Copy", null, panel_N_Copy, null);
		
		JLabel lblDocid = new JLabel("DOCID");
		
		textField_C_DocId = new JTextField();
		textField_C_DocId.setColumns(10);
		
		JLabel lblLibid = new JLabel("LIBID");
		
		textField_C_LibId = new JTextField();
		textField_C_LibId.setColumns(10);
		
		JLabel lblCopyno = new JLabel("COPYNO");
		
		JLabel lblPosition = new JLabel("POSITION");
		
		textField_C_CopyNo = new JTextField();
		textField_C_CopyNo.setColumns(10);
		
		textField_C_Position = new JTextField();
		textField_C_Position.setColumns(10);
		
		JButton C_add = new JButton("ADD");
		GroupLayout gl_panel_N_Copy = new GroupLayout(panel_N_Copy);
		gl_panel_N_Copy.setHorizontalGroup(
			gl_panel_N_Copy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Copy.createSequentialGroup()
					.addGap(25)
					.addComponent(lblDocid)
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(lblLibid)
					.addGap(55)
					.addComponent(lblCopyno)
					.addGap(50)
					.addComponent(lblPosition)
					.addGap(355))
				.addGroup(gl_panel_N_Copy.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_C_DocId, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_C_LibId, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_C_CopyNo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_C_Position, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(155)
					.addComponent(C_add, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		gl_panel_N_Copy.setVerticalGroup(
			gl_panel_N_Copy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_Copy.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel_N_Copy.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocid)
						.addComponent(lblCopyno)
						.addComponent(lblLibid)
						.addComponent(lblPosition))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_N_Copy.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(C_add, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_C_Position, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_panel_N_Copy.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_C_LibId, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addComponent(textField_C_CopyNo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_C_DocId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap(385, Short.MAX_VALUE))
		);
		panel_N_Copy.setLayout(gl_panel_N_Copy);
		
		JPanel panel_N_LibraryBranch = new JPanel();
		tabbedPane_New.addTab("Library Branch", null, panel_N_LibraryBranch, null);
		
		JLabel lblLibid_1 = new JLabel("LIBID");
		
		textField_LibId = new JTextField();
		textField_LibId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("LOCATION");
		
		textField_Location = new JTextField();
		textField_Location.setColumns(10);
		
		JButton L_add = new JButton("ADD");
		L_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel_N_LibraryBranch = new GroupLayout(panel_N_LibraryBranch);
		gl_panel_N_LibraryBranch.setHorizontalGroup(
			gl_panel_N_LibraryBranch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_LibraryBranch.createSequentialGroup()
					.addGroup(gl_panel_N_LibraryBranch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_N_LibraryBranch.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_LibId, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_Name, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_Location, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(235)
							.addComponent(L_add, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_N_LibraryBranch.createSequentialGroup()
							.addGap(30)
							.addComponent(lblLibid_1)
							.addGap(81)
							.addComponent(lblNewLabel_1)
							.addGap(69)
							.addComponent(lblNewLabel_2)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_panel_N_LibraryBranch.setVerticalGroup(
			gl_panel_N_LibraryBranch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_N_LibraryBranch.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_N_LibraryBranch.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLibid_1)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_N_LibraryBranch.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_N_LibraryBranch.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_Location, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(L_add, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addComponent(textField_LibId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(textField_Name, Alignment.LEADING))
					.addContainerGap(381, Short.MAX_VALUE))
		);
		panel_N_LibraryBranch.setLayout(gl_panel_N_LibraryBranch);
		layeredPane_New.setVisible(false);
		
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
		
		JLabel lblType_1 = new JLabel("TYPE");
		
		JLabel lblReadname = new JLabel("READNAME");
		
		JLabel lblNumborbooks_1 = new JLabel("NUMBORBOOKS");
		
		JLabel lblNumresbooks_1 = new JLabel("NUMRESBOOKS");
		
		JLabel lblAddress = new JLabel("ADDRESS");
		
		JLabel lblPhonenum_1 = new JLabel("PHONENUM");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JButton btnUpdate_2 = new JButton("UPDATE");
		GroupLayout gl_panel_U_Reader = new GroupLayout(panel_U_Reader);
		gl_panel_U_Reader.setHorizontalGroup(
			gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Reader.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnUpdate_2)
						.addGroup(gl_panel_U_Reader.createSequentialGroup()
							.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_2, 0, 0, Short.MAX_VALUE)
								.addComponent(lblReaderid_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addGap(28)
									.addComponent(lblType_1)
									.addGap(47)
									.addComponent(lblReadname))
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addGap(6)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNumborbooks_1))
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addGap(6)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addComponent(lblNumresbooks_1)
									.addGap(36)
									.addComponent(lblAddress)
									.addGap(44)
									.addComponent(lblPhonenum_1))
								.addGroup(gl_panel_U_Reader.createSequentialGroup()
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel_U_Reader.setVerticalGroup(
			gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Reader.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblReaderid_1)
							.addComponent(lblType_1)
							.addComponent(lblAddress)
							.addComponent(lblPhonenum_1)
							.addComponent(lblNumresbooks_1))
						.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblReadname)
							.addComponent(lblNumborbooks_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_U_Reader.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
					.addGap(31)
					.addComponent(btnUpdate_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(308))
		);
		panel_U_Reader.setLayout(gl_panel_U_Reader);
		
		JPanel panel_U_Document = new JPanel();
		tabbedPane_Update.addTab("Document", null, panel_U_Document, null);
		
		JLabel lblDocid_1 = new JLabel("DOCID");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblPublisherid_1 = new JLabel("PUBLISHERID");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TITLE");
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JLabel lblPdate = new JLabel("PDATE");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JLabel lblBfg_1 = new JLabel("B_FG");
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("J_FG");
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		JLabel lblVolumeno_1 = new JLabel("VOLUMENO");
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		
		JLabel lblEditorid_1 = new JLabel("EDITORID");
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JLabel lblPfg_1 = new JLabel("P_FG");
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		GroupLayout gl_panel_U_Document = new GroupLayout(panel_U_Document);
		gl_panel_U_Document.setHorizontalGroup(
			gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Document.createSequentialGroup()
					.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_U_Document.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_14, 0, 0, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_U_Document.createSequentialGroup()
							.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_U_Document.createSequentialGroup()
									.addGap(21)
									.addComponent(lblDocid_1))
								.addGroup(gl_panel_U_Document.createSequentialGroup()
									.addContainerGap()
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_U_Document.createSequentialGroup()
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_U_Document.createSequentialGroup()
									.addComponent(lblPublisherid_1)
									.addGap(59)
									.addComponent(lblNewLabel_3)
									.addGap(75)
									.addComponent(lblPdate)
									.addGap(72)
									.addComponent(lblBfg_1))))
						.addGroup(gl_panel_U_Document.createSequentialGroup()
							.addGap(30)
							.addComponent(lblIsbn_1)
							.addGap(74)
							.addComponent(lblNewLabel_4)
							.addGap(68)
							.addComponent(lblVolumeno_1)
							.addGap(41)
							.addComponent(lblEditorid_1)
							.addGap(51)
							.addComponent(lblPfg_1)))
					.addGap(41)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		gl_panel_U_Document.setVerticalGroup(
			gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Document.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisherid_1)
						.addComponent(lblDocid_1)
						.addComponent(lblBfg_1)
						.addComponent(lblNewLabel_3)
						.addComponent(lblPdate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addComponent(textField_13, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
						.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn_1)
						.addComponent(lblNewLabel_4)
						.addComponent(lblVolumeno_1)
						.addComponent(lblEditorid_1)
						.addComponent(lblPfg_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_U_Document.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
						.addComponent(textField_14, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(textField_15)
						.addComponent(textField_16)
						.addComponent(textField_17))
					.addGap(302))
		);
		panel_U_Document.setLayout(gl_panel_U_Document);
		
		JPanel panel_U_Branch = new JPanel();
		tabbedPane_Update.addTab("Library Branch", null, panel_U_Branch, null);
		
		JLabel lblLibid_2 = new JLabel("LIBID");
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NAME");
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		
		JLabel lblLocation = new JLabel("LOCATION");
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		GroupLayout gl_panel_U_Branch = new GroupLayout(panel_U_Branch);
		gl_panel_U_Branch.setHorizontalGroup(
			gl_panel_U_Branch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Branch.createSequentialGroup()
					.addGap(15)
					.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
					.addComponent(btnUpdate_1)
					.addGap(82))
				.addGroup(gl_panel_U_Branch.createSequentialGroup()
					.addGap(42)
					.addComponent(lblLibid_2)
					.addGap(78)
					.addComponent(lblNewLabel_5)
					.addGap(73)
					.addComponent(lblLocation)
					.addContainerGap(412, Short.MAX_VALUE))
		);
		gl_panel_U_Branch.setVerticalGroup(
			gl_panel_U_Branch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_U_Branch.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_U_Branch.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(lblNewLabel_5)
						.addComponent(lblLibid_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_U_Branch.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_19, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addGroup(gl_panel_U_Branch.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_20, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdate_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(380, Short.MAX_VALUE))
		);
		panel_U_Branch.setLayout(gl_panel_U_Branch);
		
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
		btnNewButton_update.setBounds(9, 200, 134, 39);
		layeredPane.add(btnNewButton_update);
		
		JButton btnNewButton_quit = new JButton("Quit");
		btnNewButton_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_quit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_quit.setBounds(9, 267, 131, 40);
		layeredPane.add(btnNewButton_quit);
		contentPane.setLayout(groupLayout);
	}
}
