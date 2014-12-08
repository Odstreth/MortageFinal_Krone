import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class MortageGUI implements FocusListener, ItemListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<Integer> comboBox;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_9;
	
	
	private static ArrayList<Integer> terms;

	private double interest;
	private double income;
	private double debt;
	private double down;
	private int term;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		terms = new ArrayList<Integer>();
		terms.add(5);
		terms.add(10);
		terms.add(15);
		terms.add(30);

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortageGUI window = new MortageGUI();
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
	public MortageGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Gross Income: ");
		lblNewLabel.setBounds(10, 20, 100, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Monthly Debt: ");
		lblNewLabel_1.setBounds(10, 50, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Interest Rate: ");
		lblNewLabel_2.setBounds(217, 20, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Term: ");
		lblNewLabel_3.setBounds(10, 80, 80, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Down Payment: ");
		lblNewLabel_4.setBounds(217, 50, 100, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(121, 17, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addFocusListener(this);
		
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(338, 17, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(this);
	
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(121, 49, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.addFocusListener(this);
		
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setBounds(338, 47, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addFocusListener(this);
	
		
		comboBox = new JComboBox(terms.toArray());
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(121, 77, 49, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItemListener(this);
		
		JLabel lblNewLabel_5 = new JLabel("House Payment:");
		lblNewLabel_5.setBounds(10, 120, 120, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("House payment and obligations: ");
		lblNewLabel_6.setBounds(10, 150, 180, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Maximum Payment:");
		lblNewLabel_7.setBounds(10, 180, 180, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mortage Amount:");
		lblNewLabel_8.setBounds(10, 210, 180, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(271, 120, 100, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(271, 150, 100, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(271, 180, 100, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(271, 210, 100, 14);
		frame.getContentPane().add(lblNewLabel_12);

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object source = e.getSource();
		if (source.equals(textField)){
			this.income = Double.parseDouble(textField.getText());
			this.lblNewLabel_12.setText("1");
		}
		else if( source == textField_1){
			this.interest = Double.parseDouble(textField_1.getText());
		}
		else if (source == textField_2){
			this.debt = Double.parseDouble(textField_2.getText());	
		}
		else if (source == textField_3){
			this.down = Double.parseDouble(textField_3.getText());
			
		}
	
		lblNewLabel_9.setText(Double.toString(MortageCalc.set18(income)));
		lblNewLabel_10.setText(Double.toString(MortageCalc.set36(income, debt)));
		lblNewLabel_11.setText(Double.toString(MortageCalc.setMaxPay(income, debt)));
		DecimalFormat Currency = new DecimalFormat("##.##");
		lblNewLabel_12.setText(Currency.format((MortageCalc.calcFinance(income, interest, term, debt)-down)));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source.equals(comboBox)){
			this.term = (Integer)comboBox.getSelectedItem();
	
		}
		DecimalFormat Currency = new DecimalFormat("##.##");
		lblNewLabel_12.setText(Currency.format((MortageCalc.calcFinance(income, interest, term, debt)-down)));
	}

	

	
}
