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

public class DLGetReservedDocument extends JDialog {
	private static final long serialVersionUID = 721302519168599361L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtReaderId;

	private List<String[]> data;
	private String readerId;

	private void clickBTNClose() {
		dispose();
	}

	private void clickBTNBorrow() {
		if (readerId == null) {
			JOptionPane.showMessageDialog(this, "Please Search by Reader Id");
			return;
		}
		int selectIndex = table.getSelectedRow();
		if (selectIndex == -1) {
			JOptionPane.showMessageDialog(this, "Please Select a Document in the Table");
			return;
		}
		String[] selectData = data.get(selectIndex);
		if (ReaderControl.borrowReservedDocument(selectData[0], "1", selectData[1], readerId)) {
			JOptionPane.showMessageDialog(this, "Successful");
		} else {
			JOptionPane.showMessageDialog(this, "Failed");
		}
	}

	private void clickBTNSearch() {
		String readerId = txtReaderId.getText();
		if ("".equals(readerId)) {
			JOptionPane.showMessageDialog(this, "Please Enter Reader Id");
			return;
		}
		if (ReaderControl.getReaderById(readerId) == null) {
			JOptionPane.showMessageDialog(this, "Reader Not Found");
			return;
		}
		this.readerId = readerId;
		List<String[]> borrowData = ReaderControl.getReservedDocuments("1", readerId);
		setTableData(borrowData);
	}

	private void setTableData(List<String[]> data) {
		this.data = data;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (String[] rowData : data) {
			model.addRow(new Object[] { rowData[2], rowData[3] });
		}
		table.setModel(model);
	}

	/**
	 * Create the dialog.
	 */
	public DLGetReservedDocument(JFrame parent, boolean model) {
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
			btnClose.setForeground(Color.BLUE);
			btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnClose.addMouseListener(new MouseAdapter() {
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
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Name", "ReserveDateTime" }));
		((DefaultTableModel) table.getModel()).setRowCount(0);
		scrollPane.setViewportView(table);

		JButton btnBorrow = new JButton("BORROW");
		btnBorrow.setForeground(Color.BLUE);
		btnBorrow.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBorrow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickBTNBorrow();
			}
		});
		btnBorrow.setBounds(420, 344, 97, 34);
		contentPanel.add(btnBorrow);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(36, 10, 596, 47);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtReaderId = new JTextField();
		txtReaderId.setBounds(76, 9, 120, 27);
		panel.add(txtReaderId);
		txtReaderId.setColumns(10);

		JLabel lblReaderId = new JLabel("Reader Id");
		lblReaderId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblReaderId.setBounds(10, 15, 56, 16);
		panel.add(lblReaderId);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNSearch();
			}
		});
		btnSearch.setBounds(495, 9, 91, 27);
		panel.add(btnSearch);
	}
}
