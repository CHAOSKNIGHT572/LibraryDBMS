package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LibraryManagement extends JFrame {
	private static final long serialVersionUID = 5083779219459314797L;
	private JPanel contentPane;

	public static void main(String[] args) {
		LibraryManagement frame = new LibraryManagement();
		frame.setVisible(true);
	}

	public LibraryManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
