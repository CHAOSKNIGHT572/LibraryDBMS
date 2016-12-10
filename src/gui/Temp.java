package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Temp extends JFrame {
	private static final long serialVersionUID = -8086892358193012069L;
	private JPanel contentPane;
	private PNBorrowReserve pnBorrowReserve;
	private PNNew pnNew;
	private PNUpdate pnUpdate;
	private JPanel visiblePanel;
	private JPanel pnWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Temp frame = new Temp();
		frame.init();
		frame.setVisible(true);
	}

	private void init() {
		visiblePanel = pnWelcome;
		pnBorrowReserve = new PNBorrowReserve();
		getContentPane().add(pnBorrowReserve);
		pnBorrowReserve.setBounds(189, 0, 896, 675);
		pnBorrowReserve.setVisible(false);

		pnNew = new PNNew();
		getContentPane().add(pnNew);
		pnNew.setBounds(189, 0, 896, 675);
		pnNew.setVisible(false);

		pnUpdate = new PNUpdate();
		getContentPane().add(pnUpdate);
		pnUpdate.setBounds(189, 0, 896, 675);
		pnUpdate.setVisible(false);
	}

	private void clickBTNBorrev() {
		changeToPanel(pnBorrowReserve);
	}

	private void clickBTNNew() {
		changeToPanel(pnNew);
	}

	private void clickBTNUpdate() {
		changeToPanel(pnUpdate);
	}

	private void clickBTNQuit() {

	}

	private void changeToPanel(ResetablePanel toPanel) {
		visiblePanel.setVisible(false);
		toPanel.reset();
		toPanel.setVisible(true);
		visiblePanel = toPanel;
	}

	/**
	 * Create the frame.
	 */
	public Temp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBorRev = new JButton("Borrow/Reserve");
		btnBorRev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNBorrev();
			}
		});
		btnBorRev.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBorRev.setBounds(12, 24, 165, 60);
		contentPane.add(btnBorRev);

		JButton btnNew = new JButton("New");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNNew();
			}
		});
		btnNew.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNew.setBounds(12, 97, 165, 60);
		contentPane.add(btnNew);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNUpdate();
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(12, 170, 165, 60);
		contentPane.add(btnUpdate);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBTNQuit();
			}
		});
		btnQuit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnQuit.setBounds(12, 243, 165, 60);
		contentPane.add(btnQuit);

		pnWelcome = new JPanel();
		pnWelcome.setBounds(189, 0, 896, 675);
		contentPane.add(pnWelcome);
	}
}
