package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.ReaderControl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DLReturnDocument extends JDialog {
	private static final long serialVersionUID = 721302519168599361L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtReaderId;

	private List<String[]> data;
	private String readerId;

	private void clickBTNClose() {
		dispose();
	}

	private void clickBTNReturn() {
		if (readerId == null) {
			JOptionPane.showMessageDialog(this, "Please Search by Reader Id");
			return;
		}
		int selectIndex = table.getSelectedRow();
		if (selectIndex == -1) {
			JOptionPane.showMessageDialog(this, "Please Select a Document in the Table");
			return;
		}
		
	}

	private void clickBTNSearch() {
		String readerId = txtReaderId.getText();
		if ("".equals(readerId)) {
			JOptionPane.showMessageDialog(this, "Please Enter Reader Id");
			return;
		}
		this.readerId = readerId;
		List<String[]> borrowData = ReaderControl.getBorrowedDocuments("1", readerId);
		setTableData(borrowData);
	}

	private void setTableData(List<String[]> data) {
		this.data = data;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (String[] rowData : data) {
			model.addRow(new Object[] { rowData[2], rowData[3], rowData[4], rowData[5] });
		}
		table.setModel(model);
	}

	/**
	 * Create the dialog.
	 */
	public DLReturnDocument(JFrame parent, boolean model) {
		super(parent, model);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 674, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnClose = new JButton("CLOSE");
			btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnClose.setForeground(Color.BLUE);
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickBTNClose();
				}
			});
			btnClose.setBounds(535, 344, 97, 34);
			contentPanel.add(btnClose);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 67, 596, 264);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Name", "BorrowDateTime", "DueDateTime", "Fine" }));
		((DefaultTableModel) table.getModel()).setRowCount(0);
		scrollPane.setViewportView(table);

		JButton btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnReturn.setForeground(Color.BLUE);
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNReturn();
			}
		});
		btnReturn.setBounds(421, 344, 97, 34);
		contentPanel.add(btnReturn);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(36, 10, 596, 47);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtReaderId = new JTextField();
		txtReaderId.setBounds(78, 10, 118, 26);
		panel.add(txtReaderId);
		txtReaderId.setColumns(10);

		JLabel lblReaderId = new JLabel("Reader Id");
		lblReaderId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReaderId.setBounds(10, 14, 54, 19);
		panel.add(lblReaderId);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearch.setForeground(Color.BLUE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNSearch();
			}
		});
		btnSearch.setBounds(494, 10, 92, 27);
		panel.add(btnSearch);
	}
}
