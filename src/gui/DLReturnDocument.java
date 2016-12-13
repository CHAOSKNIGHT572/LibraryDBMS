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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DLReturnDocument extends JDialog {
	private static final long serialVersionUID = 721302519168599361L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtReaderId;

	private void clickBTNClose() {

	}

	private void clickBTNReturn() {

	}

	private void clickBTNSearch() {

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
			JButton btnClose = new JButton("Close");
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickBTNClose();
				}
			});
			btnClose.setBounds(559, 344, 97, 25);
			contentPanel.add(btnClose);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 67, 596, 264);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Name", "DueDate" }));
		scrollPane.setViewportView(table);

		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNReturn();
			}
		});
		btnReturn.setBounds(449, 344, 97, 25);
		contentPanel.add(btnReturn);

		JPanel panel = new JPanel();
		panel.setBounds(94, 12, 480, 25);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtReaderId = new JTextField();
		txtReaderId.setBounds(78, 1, 116, 22);
		panel.add(txtReaderId);
		txtReaderId.setColumns(10);

		JLabel lblReaderId = new JLabel("Reader Id");
		lblReaderId.setBounds(0, 4, 56, 16);
		panel.add(lblReaderId);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNSearch();
			}
		});
		btnSearch.setBounds(383, 0, 97, 25);
		panel.add(btnSearch);
	}
}
