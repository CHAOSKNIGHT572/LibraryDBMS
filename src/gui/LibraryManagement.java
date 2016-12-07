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

public class LibraryManagement extends JFrame {

	private static final long serialVersionUID = 1331809788690220988L;
	private JPanel contentPane;
	private JTextField txtReadername;
	private JTextField txtReaderid;
	private JTextField textField;
	private JTextField txtDocid;
	private JTextField txtDocname;
	private JTextField txtType;
	private JTable table;
	private JTextField textField_1;
	private JTextField txtDescriptor;
	private JTextField txtWelcomeToThe;

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
		setBounds(100, 100, 795, 560);
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
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(148, 6, 619, 510);
		layeredPane.add(layeredPane_1);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setBackground(SystemColor.window);
		txtWelcomeToThe.setForeground(new Color(0, 0, 128));
		txtWelcomeToThe.setEditable(false);
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtWelcomeToThe.setText("Welcome to the library management system!");
		txtWelcomeToThe.setBounds(62, 110, 499, 138);
		layeredPane_1.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(148, 6, 619, 510);
		layeredPane.add(layeredPane_2);
		layeredPane_2.setVisible(false);
		
		txtReadername = new JTextField();
		txtReadername.setForeground(Color.LIGHT_GRAY);
		txtReadername.setHorizontalAlignment(SwingConstants.CENTER);
		txtReadername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReadername.setText("readerName");
		txtReadername.setBounds(228, 13, 141, 41);
		layeredPane_2.add(txtReadername);
		txtReadername.setColumns(10);
		
		txtReaderid = new JTextField();
		txtReaderid.setForeground(Color.LIGHT_GRAY);
		txtReaderid.setHorizontalAlignment(SwingConstants.CENTER);
		txtReaderid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtReaderid.setText("readerId");
		txtReaderid.setBounds(20, 13, 141, 41);
		layeredPane_2.add(txtReaderid);
		txtReaderid.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("search");
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_4.setBounds(461, 15, 141, 41);
		layeredPane_2.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(SystemColor.window);
		textField.setBounds(6, 6, 607, 57);
		layeredPane_2.add(textField);
		textField.setColumns(10);
		
		txtDocid = new JTextField();
		txtDocid.setForeground(Color.LIGHT_GRAY);
		txtDocid.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDocid.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocid.setText("DocId");
		txtDocid.setBounds(20, 75, 130, 41);
		layeredPane_2.add(txtDocid);
		txtDocid.setColumns(10);
		
		txtDocname = new JTextField();
		txtDocname.setForeground(Color.LIGHT_GRAY);
		txtDocname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDocname.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocname.setText("DocName");
		txtDocname.setBounds(162, 75, 120, 41);
		layeredPane_2.add(txtDocname);
		txtDocname.setColumns(10);
		
		txtType = new JTextField();
		txtType.setForeground(Color.LIGHT_GRAY);
		txtType.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setText("Type");
		txtType.setBounds(294, 75, 120, 41);
		layeredPane_2.add(txtType);
		txtType.setColumns(10);
		
		txtDescriptor = new JTextField();
		txtDescriptor.setForeground(Color.LIGHT_GRAY);
		txtDescriptor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescriptor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDescriptor.setText("Descriptor");
		txtDescriptor.setBounds(20, 121, 130, 41);
		layeredPane_2.add(txtDescriptor);
		txtDescriptor.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearch.setBounds(461, 99, 141, 41);
		layeredPane_2.add(btnSearch);
		
		table = new JTable();
		table.setBounds(20, 172, 577, 285);
		layeredPane_2.add(table);
		
		JButton btnNewButton_5 = new JButton("BORROW");
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setBounds(350, 469, 117, 35);
		layeredPane_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("RESERVE");
		btnNewButton_6.setForeground(Color.BLUE);
		btnNewButton_6.setBounds(475, 469, 117, 35);
		layeredPane_2.add(btnNewButton_6);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(SystemColor.window);
		textField_1.setBounds(6, 66, 607, 446);
		layeredPane_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBounds(148, 6, 619, 510);
		layeredPane.add(layeredPane_3);
		layeredPane_3.setVisible(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 19, 607, 467);
		layeredPane_3.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Reader", null, panel, null);
		
		JLabel lblTab = new JLabel("tab 1");
		panel.add(lblTab);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Document", null, panel_1, null);
		
		JLabel lblTab_1 = new JLabel("tab 2");
		panel_1.add(lblTab_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Copy", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Library Branch", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		layeredPane_3.setVisible(false);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBounds(148, 6, 619, 510);
		layeredPane.add(layeredPane_4);
		layeredPane_4.setVisible(false);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(6, 17, 607, 467);
		layeredPane_4.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Reader", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Document", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Library Branch", null, panel_7, null);
		
		JButton btnNewButton = new JButton("Borrow/reserve");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.setVisible(false);
				layeredPane_2.setVisible(true);
				layeredPane_3.setVisible(false);
				layeredPane_4.setVisible(false);
			}
		});
		btnNewButton.setBounds(9, 52, 131, 42);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.setVisible(false);
				layeredPane_2.setVisible(false);
				layeredPane_3.setVisible(true);
				layeredPane_4.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(9, 114, 134, 39);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.setVisible(false);
				layeredPane_2.setVisible(false);
				layeredPane_3.setVisible(false);
				layeredPane_4.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(9, 178, 134, 39);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Quit");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_3.setBounds(9, 239, 131, 40);
		layeredPane.add(btnNewButton_3);
		contentPane.setLayout(groupLayout);
	}
}
