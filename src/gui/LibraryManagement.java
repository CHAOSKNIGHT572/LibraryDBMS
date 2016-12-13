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
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import control.BranchControl;
import control.Constant;
import control.DocumentControl;
import control.ReaderControl;
import jdbc.UpdateCopy;
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
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

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
	private JTextField textField_C_Position;
	private JTextField textField_Name;
	private JTextField textField_Location;
	private JTextField textFieldRReaderId;
	private JTextField textFieldRType;
	private JTextField textFieldRReaderName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNum;
	private JTextField textFieldLibId;
	private JTextField textFieldLibName;
	private JTextField textFieldLibLocation;
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

	private static LibraryManagement selfObj;

	String addCopyDocId = null;
	String addCopyLibId = null;
	String borResReaderId = null;
	List<Document> borResDocList = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagement frame = new LibraryManagement();
					selfObj = frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setValueForTable(List<Document> docList) {
		borResDocList = docList;
		DefaultTableModel model = (DefaultTableModel) getTableModel();
		model.setRowCount(0);
		for (Document doc : docList) {
			String type;
			if (doc instanceof Book) {
				type = "Book";
			} else if (doc instanceof JournalVolume) {
				type = "Journal Volume";
			} else if (doc instanceof ConferenceProceeding) {
				type = "Conference Proceeding";
			} else {
				continue;
			}
			model.addRow(new Object[] { doc.getTitle(), doc.getPublisher().getPubName(), type });
		}
		setTableModel(model);
	}

	private void setEmptyTable() {
		DefaultTableModel model = (DefaultTableModel) getTableModel();
		model.setRowCount(0);
		setTableModel(model);
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(layeredPane,
				GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE));

		Publisher publisher = new Publisher();
		Book book = new Book();
		ChiefEditor chiefEditor = new ChiefEditor();
		JournalVolume journalVolume = new JournalVolume();
		ConferenceProceeding cp = new ConferenceProceeding();

		JLayeredPane layeredPane_BR = new JLayeredPane();
		layeredPane_BR.setBounds(148, 6, 767, 580);
		layeredPane.add(layeredPane_BR);
		layeredPane_BR.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 2, 741, 75);
		layeredPane_BR.add(panel);
		panel.setLayout(null);

		JLabel lblReaderid = new JLabel("Reader Id");
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

		// -----------------------

		JLabel lblReadername = new JLabel("Reader Name");
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

		// -----------------------

		JButton btnNewButton_4 = new JButton("SEARCH");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = txtReaderid.getText();
				String name = txtReadername.getText();
				if (!"".equals(id)) {
					borResReaderId = ReaderControl.getReaderById(id).getId();
					if (borResReaderId == null) {
						//System.out.println("Not Found");
						JOptionPane.showMessageDialog(null, "Reader not found!");
					} else {
						//System.out.println("Find Reader");
						JOptionPane.showMessageDialog(null, "Reader found!");
					}
				} else if (!"".equals(name)) {
					List<Reader> list = ReaderControl.getReaderByName(name);
					if (list.isEmpty()) {

					} else if (list.size() == 1) {
						borResReaderId = list.get(0).getId();
						//System.out.println("Find Reader");
						JOptionPane.showMessageDialog(null, "Reader Found!");
					} else {
						Reader reader = (Reader) JOptionPane.showInputDialog(selfObj,
								"Choose one from the following list", "Select One", JOptionPane.QUESTION_MESSAGE, null,
								list.toArray(), null);
						if (reader != null) {
							borResReaderId = reader.getId();
						}
					}
				} else {
					//System.out.println("Enter id or name");
					JOptionPane.showMessageDialog(null, "Please enter reader id or reader name!");
					return;
				}

			}
		});
		btnNewButton_4.setBounds(595, 26, 120, 35);
		panel.add(btnNewButton_4);
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		// -----------------------

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(10, 83, 741, 487);
		layeredPane_BR.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPublisherName = new JLabel("<html>Publisher<br>Name<html>");
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

		JLabel lblNewLabel = new JLabel("<html>Author<br>Name<html>");
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

		JLabel lblTitle = new JLabel("Title");
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

		JLabel lblDescriptor = new JLabel("Descriptor");
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
		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String publisherName = txtPublisherName.getText();
				String authorName = txtAuthorName.getText();
				String title = txtTitle.getText();
				String descriptor = txtDescriptor.getText();
				Document doc = new Document();
				if (!"".equals(publisher)) {
					Publisher publisher = new Publisher();
					publisher.setPubName(publisherName);
					doc.setPublisher(publisher);
				}
				if (!"".equals(authorName)) {
					Author author = new Author();
					author.setAuName(authorName);
					doc.addAuthor(author);
				}
				if (!"".equals(title)) {
					doc.setTitle(title);
				}
				if (!"".equals(descriptor)) {
					doc.addDescriptor(descriptor);
				}
				List<Document> list = DocumentControl.getDocumentListByConditions(doc);
				if (!list.isEmpty()) {
					setValueForTable(list);
				} else {
					JOptionPane.showMessageDialog(selfObj, "Cannot find documents with the conditions.", "Not Found",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(595, 57, 117, 35);
		panel_1.add(btnSearch);
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 102, 722, 330);
		panel_1.add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Name", "Publisher", "Type" }) {
			private static final long serialVersionUID = 1209687639246047000L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(24);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JButton btnNewButton_5 = new JButton("BORROW");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (borResReaderId == null) {
					//System.out.println("Check reader first");
					JOptionPane.showMessageDialog(null, "Please check reader first!");
					return;
				}
				int selectIndex = table.getSelectedRow();
				if (selectIndex == -1) {
					//System.out.println("Select a document");
					JOptionPane.showMessageDialog(null, "Please select a document!");
					return;
				}
				String docId = borResDocList.get(selectIndex).getId();
				int result = ReaderControl.borrow(docId, "1", borResReaderId);
				if (result == Constant.SUCCESSFUL) {
					//System.out.println("Successful");
					JOptionPane.showMessageDialog(null, "Successfully borrow the document!");
				} else if (result == Constant.CHECK_REPEAT_FAILED) {
					//System.out.println("You have already borrow the document");
					JOptionPane.showMessageDialog(null, "You have already borrowed the document! ");
				} else if (result == Constant.CHECK_COUNT_FAILED) {
					//System.out.println("You have borrowed/reserved too much documents.(10 limit)");
					JOptionPane.showMessageDialog(null, "You have borrowed/reserved too many documents. (Max is 10)");
				} else if (result == Constant.NO_AVAILABLE_DOCUMENT_COPY) {
					//System.out.println("No available copy for the document");
					JOptionPane.showMessageDialog(null, "No more copies for the document.");
				} else {
					//System.out.println("Failed");
					JOptionPane.showMessageDialog(null, "Fail to borrow!");
				}
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_5.setBounds(396, 442, 117, 35);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setForeground(Color.BLUE);

		JButton btnNewButton_6 = new JButton("RESERVE");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (borResReaderId == null) {
					//System.out.println("Check reader first");
					JOptionPane.showMessageDialog(null, "Please check reader first!");
					return;
				}
				int selectIndex = table.getSelectedRow();
				if (selectIndex == -1) {
					//System.out.println("Select a document");
					JOptionPane.showMessageDialog(null, "Please select a document!");
					return;
				}
				String docId = borResDocList.get(selectIndex).getId();
				int result = ReaderControl.reserve(docId, "1", borResReaderId);
				if (result == Constant.SUCCESSFUL) {
					//System.out.println("Successful");
					//JOptionPane.showMessageDialog(null, "Successfully reserve the document!");
				} else if (result == Constant.CHECK_REPEAT_FAILED) {
					//System.out.println("You have already borrow the document");
					JOptionPane.showMessageDialog(null, "You have already reserved the document!");
				} else if (result == Constant.CHECK_COUNT_FAILED) {
					//System.out.println("You have borrowed/reserved too much documents.(10 limit)");
					JOptionPane.showMessageDialog(null, "You have borrowed/reserved too much documents.(Max is 10)");
				} else if (result == Constant.NO_AVAILABLE_DOCUMENT_COPY) {
					//System.out.println("No available copy for the document");
					JOptionPane.showMessageDialog(null, "No more copy for the document!");
				} else {
					//System.out.println("Failed");
					JOptionPane.showMessageDialog(null, "Fail to reserve the document!");
				}
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_6.setBounds(567, 442, 117, 35);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.setForeground(Color.BLUE);

		JButton btnReturn = new JButton("RETURN");
		btnReturn.setForeground(Color.BLUE);
		btnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DLReturnDocument dialog = new DLReturnDocument(selfObj, true);
				dialog.setVisible(true);
			}
		});
		btnReturn.setBounds(225, 442, 117, 35);
		panel_1.add(btnReturn);

		JButton btnGetReserve = new JButton("GET RESERVE");
		btnGetReserve.setForeground(Color.BLUE);
		btnGetReserve.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnGetReserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DLGetReservedDocument dialog = new DLGetReservedDocument(selfObj, true);
				dialog.setVisible(true);
			}
		});
		btnGetReserve.setBounds(54, 442, 117, 35);
		panel_1.add(btnGetReserve);

		JLayeredPane layeredPane_Update = new JLayeredPane();
		layeredPane_Update.setBounds(148, 6, 774, 580);
		layeredPane.add(layeredPane_Update);
		layeredPane_Update.setVisible(false);

		JTabbedPane tabbedPane_Update = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Update.setBounds(6, 17, 762, 557);
		layeredPane_Update.add(tabbedPane_Update);

		JPanel panel_U_Reader = new JPanel();
		tabbedPane_Update.addTab("Reader", null, panel_U_Reader, null);

		JLabel lblReaderid_1 = new JLabel("Reader Id");
		lblReaderid_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReaderid_1.setBounds(38, 62, 70, 15);

		JLabel lblType_1 = new JLabel("Type");
		lblType_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblType_1.setBounds(163, 62, 53, 15);

		JLabel lblReadname = new JLabel("Reader Name");
		lblReadname.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReadname.setBounds(286, 62, 70, 15);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAddress.setBounds(407, 62, 63, 15);

		JLabel lblPhonenum_1 = new JLabel("Phone No.");
		lblPhonenum_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhonenum_1.setBounds(522, 62, 70, 15);

		textFieldRReaderId = new JTextField();
		textFieldRReaderId.setBounds(28, 87, 93, 39);
		textFieldRReaderId.setColumns(10);

		textFieldRType = new JTextField();
		textFieldRType.setBounds(149, 87, 93, 39);
		textFieldRType.setColumns(10);

		textFieldRReaderName = new JTextField();
		textFieldRReaderName.setBounds(274, 87, 93, 39);
		textFieldRReaderName.setColumns(10);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(395, 87, 93, 39);
		textFieldAddress.setColumns(10);

		textFieldPhoneNum = new JTextField();
		textFieldPhoneNum.setBounds(512, 87, 93, 39);
		textFieldPhoneNum.setColumns(10);

		JButton btnUpdate_2 = new JButton("UPDATE");
		btnUpdate_2.setForeground(Color.BLUE);
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textFieldRReaderId.getText();

				if ("".equals(id)) {
					//System.out.println("Enter Id");
					JOptionPane.showMessageDialog(null, "Id cannot be empty, please enter again!");

				}
				Reader reader = ReaderControl.getReaderById(id);
				if (reader == null) {
					//System.out.println("Not Found");
					JOptionPane.showMessageDialog(null, "Id not found!");
				}

				String name = textFieldRReaderName.getText();
				if (!"".equals(name)) {
					reader.setName(name);
				}

				String address = textFieldAddress.getText();
				if (!"".equals(address)) {
					reader.setAddress(address);
				}

				String phone = textFieldPhoneNum.getText();
				if (!"".equals(phone)) {
					reader.setPhoneNum(phone);
				}
				if (ReaderControl.updateInfo(reader)) {
					//System.out.println("Successful");
					JOptionPane.showMessageDialog(null, "Update successfully!");
				} else {
					//System.out.println("Failed");
					JOptionPane.showMessageDialog(null, "Update failed!");
				}
			}
		});
		btnUpdate_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUpdate_2.setBounds(633, 90, 93, 39);
		panel_U_Reader.setLayout(null);
		panel_U_Reader.add(lblReaderid_1);
		panel_U_Reader.add(textFieldRReaderId);
		panel_U_Reader.add(lblType_1);
		panel_U_Reader.add(lblReadname);
		panel_U_Reader.add(textFieldRType);
		panel_U_Reader.add(textFieldRReaderName);
		panel_U_Reader.add(textFieldAddress);
		panel_U_Reader.add(lblAddress);
		panel_U_Reader.add(btnUpdate_2);
		panel_U_Reader.add(textFieldPhoneNum);
		panel_U_Reader.add(lblPhonenum_1);

		JPanel panel_U_Branch = new JPanel();
		tabbedPane_Update.addTab("Library Branch", null, panel_U_Branch, null);

		JLabel lblLibid_2 = new JLabel("Library Id");
		lblLibid_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLibid_2.setBounds(81, 64, 50, 15);

		textFieldLibId = new JTextField();
		textFieldLibId.setBounds(62, 89, 111, 39);
		textFieldLibId.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Library Name");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(249, 64, 74, 15);

		textFieldLibName = new JTextField();
		textFieldLibName.setBounds(235, 89, 111, 39);
		textFieldLibName.setColumns(10);

		JLabel lblLocation = new JLabel("Library Location");
		lblLocation.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLocation.setBounds(418, 64, 87, 15);

		textFieldLibLocation = new JTextField();
		textFieldLibLocation.setBounds(408, 89, 111, 39);
		textFieldLibLocation.setColumns(10);
		// TODO: update library branch
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.setForeground(Color.BLUE);
		btnUpdate_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String id = textFieldLibId.getText();
				if ("".equals(id)) {
					//System.out.println("Enter Id");
					JOptionPane.showMessageDialog(null, "Id cannot be empty, please enter again!");
					return;
				}
				Branch branch = BranchControl.getBranchById(id);
				if (branch == null) {
					//System.out.println("Not Found");
					JOptionPane.showMessageDialog(null, "Id not found!");
					return;
				}
				String name = textFieldLibName.getText();
				if (!"".equals(name)) {
					branch.setName(name);
				}

				String location = textFieldLibLocation.getText();
				if (!"".equals(location)) {
					branch.setLocation(location);
				}
				if (BranchControl.updateInfo(branch)) {
					//System.out.println("Successful");
					JOptionPane.showMessageDialog(null, "Update successfully!");
				} else {
					//System.out.println("Failed");
					JOptionPane.showMessageDialog(null, "Update failed!");
				}
			}
		});
		btnUpdate_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnUpdate_1.setBounds(581, 90, 111, 37);
		panel_U_Branch.setLayout(null);
		panel_U_Branch.add(textFieldLibId);
		panel_U_Branch.add(textFieldLibName);
		panel_U_Branch.add(textFieldLibLocation);
		panel_U_Branch.add(btnUpdate_1);
		panel_U_Branch.add(lblLibid_2);
		panel_U_Branch.add(lblNewLabel_5);
		panel_U_Branch.add(lblLocation);

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

		// ---------------

		JButton R_add = new JButton("ADD");
		R_add.setForeground(Color.BLUE);
		R_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Reader reader = new Reader();
				String name = textField_R_ReaderName.getText();
				String phone = textField_R_PhoneNum.getText();
				if ("".equals(name) || "".equals(phone)) {
					JOptionPane.showMessageDialog(null, "Please enter reader name and reader phone number!");
					return;
				}
				reader.setType(textField_R_Type.getText());
				reader.setName(name);
				reader.setAddress(textField_R_Address.getText());
				reader.setPhoneNum(phone);
				if (ReaderControl.newReader(reader)) {
					JOptionPane.showMessageDialog(selfObj, "Successful!", "Successful",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		R_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		R_add.setBounds(612, 89, 93, 38);
		panel_N_Reader.setLayout(null);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 11));
		lblType.setBounds(77, 63, 36, 15);
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_N_Reader.add(lblType);

		JLabel lblReadername_ReaderName = new JLabel("Reader Name");
		lblReadername_ReaderName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReadername_ReaderName.setBounds(199, 63, 83, 15);
		panel_N_Reader.add(lblReadername_ReaderName);

		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAdress.setBounds(350, 63, 54, 15);
		panel_N_Reader.add(lblAdress);

		JLabel lblPhonenum = new JLabel("Phone Number");
		lblPhonenum.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhonenum.setBounds(481, 63, 83, 15);
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

		// ---------------------

		JButton D_add = new JButton("ADD");
		D_add.setForeground(Color.BLUE);
		D_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		D_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (docType == 0) {
					if(textField_D_Title.getText().isEmpty() == false && textField_D_ISBN.getText().isEmpty() == false){
						String[] authorArray = textField_AuthorName.getText().split(",");
						for (int i = 0; i < authorArray.length; i++) {
							Author author = new Author();
							author.setAuName(authorArray[i]);
							book.addAuthor(author);
						}
						String[] descriptorArray = textField_Descriptor.getText().split(",");
						for (int i = 0; i < descriptorArray.length; i++) {
							book.addDescriptor(descriptorArray[i]);
						}
						publisher.setPubName(textField_D_PublisherName.getText());
						book.setPublisher(publisher);
						book.setTitle(textField_D_Title.getText());
						book.setPubDate(textField_D_PDate.getText());
						book.setIsbn(textField_D_ISBN.getText());
						if (UpdateDocument.newBook(book)) {
							//System.out.println("Successful!");
							JOptionPane.showMessageDialog(null, "Add book information successfully!");
						} else {
							//System.out.println("Failed!");
							JOptionPane.showMessageDialog(null, "Fail to add book information!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please enter both document title and ISBN!");
					}
				}
				if (docType == 1) {
					if(textField_D_Title.getText().isEmpty() == false && textField_D_VolumeNo.getText().isEmpty() == false
							&& textField_D_ChiefEditor.getText().isEmpty() == false){
						String[] authorArray = textField_AuthorName.getText().split(",");
						for (int i = 0; i < authorArray.length; i++) {
							Author author = new Author();
							author.setAuName(authorArray[i]);
							journalVolume.addAuthor(author);
						}
						String[] descriptorArray = textField_Descriptor.getText().split(",");
						for (int i = 0; i < descriptorArray.length; i++) {
							journalVolume.addDescriptor(descriptorArray[i]);
						}
						publisher.setPubName(textField_D_PublisherName.getText());
						journalVolume.setPublisher(publisher);
						journalVolume.setTitle(textField_D_Title.getText());
						journalVolume.setPubDate(textField_D_PDate.getText());
						journalVolume.setVolNum(textField_D_VolumeNo.getText());
						chiefEditor.setCeName(textField_D_ChiefEditor.getText());
						journalVolume.setEditor(chiefEditor);
						if (UpdateDocument.newJournalVolume(journalVolume)) {
							//System.out.println("Successful!");
							JOptionPane.showMessageDialog(null, "Add journal information successfully!");
						} else {
							//System.out.println("Failed!");
							JOptionPane.showMessageDialog(null, "Fail to add journal information!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please enter document title, volume number and chief editor!");
					}
				}
				if (docType == 2) {
					if(textField_D_Title.getText().isEmpty() == false && textField_CDate.getText().isEmpty() == false
							&& textField_CLocation.getText().isEmpty() == false){
						String[] authorArray = textField_AuthorName.getText().split(",");
						for (int i = 0; i < authorArray.length; i++) {
							Author author = new Author();
							author.setAuName(authorArray[i]);
							cp.addAuthor(author);
						}
						String[] descriptorArray = textField_Descriptor.getText().split(",");
						for (int i = 0; i < descriptorArray.length; i++) {
							cp.addDescriptor(descriptorArray[i]);
						}
						publisher.setPubName(textField_D_PublisherName.getText());
						cp.setPublisher(publisher);
						cp.setTitle(textField_D_Title.getText());
						cp.setPubDate(textField_D_PDate.getText());
						cp.setConDate(textField_CDate.getText());
						cp.setConLocation(textField_CLocation.getText());
						cp.setConEditor(textField_CEditor.getText());
						if (UpdateDocument.newConferenceProceeding(cp)) {
							//System.out.println("Successful!");
							JOptionPane.showMessageDialog(null, "Add conference proceeding information successfully!");
						} else {
							//System.out.println("Failed!");
							JOptionPane.showMessageDialog(null, "Fail to add conference proceeding information!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please enter document title, conference date and conference location!");
					}
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
		L_add.setForeground(Color.BLUE);
		L_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Branch branch = new Branch();
				String name = textField_Name.getText();
				if ("".equals(name)) {
					JOptionPane.showMessageDialog(null, "Please enter library name!");
					return;
				}
				branch.setName(name);
				branch.setLocation(textField_Location.getText());
				if (BranchControl.newBranch(branch)) {
					JOptionPane.showMessageDialog(selfObj, "Successful!", "Successful",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		L_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		L_add.setBounds(596, 89, 97, 36);
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

		JLabel lblDocid = new JLabel("Documentation Name");
		lblDocid.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDocid.setBounds(147, 65, 101, 14);

		textField_C_DocId = new JTextField();
		textField_C_DocId.setBounds(147, 89, 87, 36);
		textField_C_DocId.setColumns(10);

		JLabel lblLibid = new JLabel("Library Name");
		lblLibid.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLibid.setBounds(147, 156, 64, 14);

		textField_C_LibId = new JTextField();
		textField_C_LibId.setBounds(147, 180, 87, 36);
		textField_C_LibId.setColumns(10);

		JLabel lblPosition = new JLabel("Library Position");
		lblPosition.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPosition.setBounds(147, 240, 74, 14);

		textField_C_Position = new JTextField();
		textField_C_Position.setBounds(147, 264, 87, 36);
		textField_C_Position.setColumns(10);

		JButton C_add = new JButton("ADD");
		C_add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String position = textField_C_Position.getText();
				if (addCopyDocId == null || addCopyLibId == null || position == null) {
					return;
				}
				if (UpdateCopy.newCopy(addCopyDocId, addCopyLibId, position)) {
					textField_C_DocId.setText("");
					textField_C_LibId.setText("");
					textField_C_Position.setText("");
					addCopyDocId = addCopyLibId = null;
					JOptionPane.showMessageDialog(selfObj, "Successful!", "Successful",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		C_add.setForeground(Color.BLUE);
		C_add.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		C_add.setBounds(547, 264, 87, 36);
		panel_N_Copy.setLayout(null);
		panel_N_Copy.add(lblDocid);
		panel_N_Copy.add(lblLibid);
		panel_N_Copy.add(lblPosition);
		panel_N_Copy.add(textField_C_DocId);
		panel_N_Copy.add(textField_C_LibId);
		panel_N_Copy.add(textField_C_Position);
		panel_N_Copy.add(C_add);

		JButton btnSearchDocName = new JButton("SEARCH");
		btnSearchDocName.setForeground(Color.BLUE);
		btnSearchDocName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchDocName.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String documentTitle = textField_C_DocId.getText();
				if ("".equals(documentTitle)) {
					JOptionPane.showMessageDialog(null, "Please enter document title!");
					return;
				}
				List<Document> list = DocumentControl.getDocumentListByName(documentTitle);
				Document doc;
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot find document with title:" + documentTitle, "Not Found",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if (list.size() == 1) {
					doc = list.get(0);
				} else {
					doc = (Document) JOptionPane.showInputDialog(selfObj,
							"Find several documents with the title:" + documentTitle, "Select One",
							JOptionPane.QUESTION_MESSAGE, null, list.toArray(), null);
					if (doc == null) {
						return;
					}
				}
				addCopyDocId = doc.getId();
				textField_C_DocId.setText(doc.getTitle());
			}
		});
		btnSearchDocName.setBounds(547, 89, 87, 36);
		panel_N_Copy.add(btnSearchDocName);

		JButton btnSearchLibName = new JButton("SEARCH");
		btnSearchLibName.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String branchName = textField_C_LibId.getText();
				if ("".equals(branchName)) {
					JOptionPane.showMessageDialog(null, "Please enter library branch name!");
					return;
				}
				List<Branch> list = BranchControl.getBranchByName(branchName);
				Branch lib;
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot find branch with name:" + branchName, "Not Found",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if (list.size() == 1) {
					lib = list.get(0);
				} else {
					lib = (Branch) JOptionPane.showInputDialog(selfObj,
							"Find several branch with the name:" + branchName, "Select One",
							JOptionPane.QUESTION_MESSAGE, null, list.toArray(), null);
					if (lib == null) {
						return;
					}
				}
				addCopyLibId = lib.getId();
				textField_C_LibId.setText(lib.getName());
			}
		});
		btnSearchLibName.setForeground(Color.BLUE);
		btnSearchLibName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchLibName.setBounds(547, 180, 87, 36);
		panel_N_Copy.add(btnSearchLibName);
		layeredPane_New.setVisible(false);
		setEmptyTable();

		JLayeredPane layeredPane_Welcome = new JLayeredPane();
		layeredPane_Welcome.setBounds(148, 0, 780, 586);
		layeredPane.add(layeredPane_Welcome);

		JButton btnNewButton_new = new JButton("NEW");
		btnNewButton_new.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Welcome.setVisible(false);
				layeredPane_BR.setVisible(false);
				layeredPane_New.setVisible(true);
				layeredPane_Update.setVisible(false);
			}
		});

		JButton btnNewButton_br = new JButton("CIRCULATION");
		btnNewButton_br.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_br.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Welcome.setVisible(false);
				layeredPane_BR.setVisible(true);
				layeredPane_New.setVisible(false);
				layeredPane_Update.setVisible(false);
			}
		});

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
		btnNewButton_br.setBounds(9, 62, 131, 42);
		layeredPane.add(btnNewButton_br);
		btnNewButton_new.setBounds(6, 133, 134, 39);
		layeredPane.add(btnNewButton_new);

		JButton btnNewButton_quit = new JButton("QUIT");
		btnNewButton_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showOptionDialog(null, "You really want to quit?", "Quit?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JButton btnNewButton_update = new JButton("UPDATE");
		btnNewButton_update.setFont(new Font("Dialog", Font.PLAIN, 14));
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
		btnNewButton_quit.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_quit.setBounds(9, 267, 131, 40);
		layeredPane.add(btnNewButton_quit);
		contentPane.setLayout(groupLayout);
	}

	public TableModel getTableModel() {
		return table.getModel();
	}

	public void setTableModel(TableModel model) {
		table.setModel(model);
	}
}
