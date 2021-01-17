import java.awt.EventQueue;
import java.awt.TextArea;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JDesktopPane;

public class BankAccountGui {

	private JFrame frame;
	private  JTextField textId;
	private JTextField textName;
	private JTextField textBalance;
	private JTextField textAccountId;
	private JTextField textAmount;
	private JTextField textShowInfo;
	//Define array of Class Account
	Account [] Accounts_List = new Account[10];
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGui window = new BankAccountGui();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankAccountGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textId = new JTextField();
		textId.setBounds(94, 8, 86, 20);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		textId.requestFocus();
		

		JLabel lbld = new JLabel("ID");
		lbld.setBounds(13, 14, 46, 14);
		frame.getContentPane().add(lbld);

		textName = new JTextField();
		textName.setBounds(94, 39, 86, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Balance");
		lblNewLabel_1.setBounds(10, 77, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textBalance = new JTextField();
		textBalance.setBounds(94, 71, 86, 20);
		frame.getContentPane().add(textBalance);
		textBalance.setColumns(10);

		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(13, 136, 159, 93);
		frame.getContentPane().add(textAreaInfo);

		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account s = new Account();
				s.acc_no=Integer.parseInt(textId.getText());
				s.name= textName.getText();
				s.amount = Float.parseFloat(textBalance.getText());
				Accounts_List[i]=s;
				i++;
				String pTextarea = textAreaInfo.getText();
				textAreaInfo.setText(
						pTextarea + textId.getText() + "  " + textName.getText() + "  " + textBalance.getText() + "\n");
				textId.setText("");
				textName.setText("");
				textBalance.setText("");
				textId.requestFocus();
				
			}
		});
		
		btnAddCustomer.setBounds(13, 102, 159, 23);
		frame.getContentPane().add(btnAddCustomer);
		
		
		JRadioButton rdDeposit = new JRadioButton("Deposit");
		rdDeposit.setSelected(true);
		rdDeposit.setBounds(221, 73, 74, 23);
		frame.getContentPane().add(rdDeposit);
		
		JRadioButton rdWithdraw = new JRadioButton("Withdraw");
		rdWithdraw.setBounds(321, 73, 80, 23);
		frame.getContentPane().add(rdWithdraw);
		
		// Add Radio Buttons in one group
		ButtonGroup group = new ButtonGroup();
		group.add(rdDeposit);
		group.add(rdWithdraw);
		
		JLabel lblAccountId = new JLabel("Account ID");
		lblAccountId.setBounds(221, 14, 74, 14);
		frame.getContentPane().add(lblAccountId);
		
		textAccountId = new JTextField();
		textAccountId.setColumns(10);
		textAccountId.setBounds(311, 11, 86, 20);
		frame.getContentPane().add(textAccountId);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(221, 45, 60, 14);
		frame.getContentPane().add(lblAmount);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(311, 42, 86, 20);
		frame.getContentPane().add(textAmount);
		
		JButton btnTransfer = new JButton("Deposit / Withdraw");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Account account : Accounts_List) {
					if (account.acc_no== Integer.parseInt(textAccountId.getText())) {
						if(rdDeposit.isSelected())
						{account.deposit(Float.parseFloat(textAmount.getText()));
						textShowInfo.setText(account.acc_no +"  " +account.name+"  "+account.amount);
						}
						if(rdWithdraw.isSelected())
						{account.withdraw(Float.parseFloat(textAmount.getText()));
						textShowInfo.setText(account.acc_no +"  " +account.name+"  "+account.amount);
						}
							
					}
					
					
				}
			}
		});
		btnTransfer.setBounds(221, 102, 173, 23);
		frame.getContentPane().add(btnTransfer);
		
		textShowInfo = new JTextField();
		textShowInfo.setEditable(false);
		textShowInfo.setColumns(10);
		textShowInfo.setBounds(221, 136, 170, 20);
		frame.getContentPane().add(textShowInfo);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textId, textName, textBalance}));
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lbld, lblNewLabel, frame.getContentPane(), lblNewLabel_1, textAreaInfo, btnAddCustomer, rdDeposit, rdWithdraw, lblAccountId, lblAmount, btnTransfer, textShowInfo, textId, textName, textBalance, textAccountId, textAmount}));

	}
}
