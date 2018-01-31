import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.CardLayout;

import javax.swing.JTextField;

import java.awt.Label;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.Font;


public class MainFrame{

	private JFrame frame;
	private JTextField textField_3;
	private JTextField txt_startDate;
	private JTextField txt_endDate;
	private JTextArea txt_RoomsInfo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}
	
	public JPanel panel;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_655875406604871");
		
		panel = new JPanel();
		//JPanel panel = new JPanel();
		tabbedPane.addTab("Owner", null, panel, null);
		panel.setLayout(null);
		
		Label label = new Label("Owner Password:");
		label.setBounds(117, 5, 104, 22);
		panel.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 7, 89, 20);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerForm of = new OwnerForm();
				of.setVisible(true);
			}
		});
		btnLogin.setBounds(326, 4, 89, 23);
		panel.add(btnLogin);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(131, 71, 408, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGetStatistics = new JButton("Get Statistics");
		btnGetStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(Main.MSC.getStatistics(textField_1.getText(), textField_2.getText()));
			}
		});
		btnGetStatistics.setBounds(10, 76, 112, 23);
		panel.add(btnGetStatistics);
		
		JLabel label_3 = new JLabel("\u0397\u03BC. \u0388\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2");
		label_3.setBounds(31, 39, 62, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setText("2018-2-4");
		textField_1.setColumns(10);
		textField_1.setBounds(98, 39, 86, 20);
		panel.add(textField_1);
		
		JLabel label_4 = new JLabel("\u0397\u03BC. \u039B\u03AE\u03BE\u03B7\u03C2");
		label_4.setBounds(192, 42, 54, 14);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setText("2018-2-10");
		textField_2.setColumns(10);
		textField_2.setBounds(247, 39, 86, 20);
		panel.add(textField_2);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Staff", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblStaffPassword = new JLabel("Staff Password:");
		lblStaffPassword.setBounds(50, 11, 77, 14);
		panel_1.add(lblStaffPassword);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 8, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0397\u03BC. \u0388\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2");
		label_1.setBounds(10, 36, 62, 14);
		panel_1.add(label_1);
		
		txt_startDate = new JTextField();
		txt_startDate.setText("2018-2-4");
		txt_startDate.setBounds(77, 36, 86, 20);
		panel_1.add(txt_startDate);
		txt_startDate.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0397\u03BC. \u039B\u03AE\u03BE\u03B7\u03C2");
		label_2.setBounds(171, 39, 54, 14);
		panel_1.add(label_2);
		
		txt_endDate = new JTextField();
		txt_endDate.setText("2018-2-10");
		txt_endDate.setBounds(226, 36, 86, 20);
		panel_1.add(txt_endDate);
		txt_endDate.setColumns(10);
		
		JButton button = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Room> rums = Main.MSC.getRoomsByDate(txt_startDate.getText(), txt_endDate.getText());
				txt_RoomsInfo.setText("");
				rums.forEach(rum -> {
					txt_RoomsInfo.append(rum+"\n");
				});
				
			}
		});
		button.setBounds(322, 35, 89, 23);
		panel_1.add(button);
		
		txt_RoomsInfo = new JTextArea();
		txt_RoomsInfo.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txt_RoomsInfo.setBounds(10, 61, 529, 158);
		panel_1.add(txt_RoomsInfo);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Client", null, panel_2, null);
		
		
		frame.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
