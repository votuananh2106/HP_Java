package tuananh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tinhBMI_ {

	private JFrame frame;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtBMI;
	private JTextField txtStatus;
	public double tinhtoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tinhBMI_ window = new tinhBMI_();
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
	public tinhBMI_() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblcal = new JLabel("BMI Calculator");
		lblcal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcal.setBounds(226, 0, 144, 63);
		frame.getContentPane().add(lblcal);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeight.setBounds(26, 81, 81, 33);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWeight.setBounds(26, 149, 81, 33);
		frame.getContentPane().add(lblWeight);
		
		txtHeight = new JTextField();
		txtHeight.setBounds(126, 87, 159, 30);
		frame.getContentPane().add(txtHeight);
		txtHeight.setColumns(10);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(126, 152, 159, 30);
		frame.getContentPane().add(txtWeight);
		txtWeight.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(351, 87, 192, 95);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton radioAsian = new JRadioButton("Asian");
		radioAsian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioAsian.setBounds(6, 22, 103, 21);
		panel.add(radioAsian);
		
		JRadioButton radioNon = new JRadioButton("Non-Asian");
		radioNon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioNon.setBounds(6, 57, 103, 21);
		panel.add(radioNon);
		
		JButton btnBMI = new JButton("BMI");
		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//get text
				String strHeight = txtHeight.getText();
				String strWeight = txtWeight.getText();
				//convert string to float
				Float numHeight = Float.parseFloat(strHeight);
				Float numWeight = Float.parseFloat(strWeight);
				//calculating BMI
				numHeight = numHeight/100;
				tinhtoan = numWeight/(numHeight*numHeight);
				//result
				txtBMI.setText(String.valueOf(tinhtoan));
			}
		});
		btnBMI.setBackground(Color.BLUE);
		btnBMI.setForeground(Color.BLACK);
		btnBMI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBMI.setBounds(81, 221, 81, 44);
		frame.getContentPane().add(btnBMI);
		
		txtBMI = new JTextField();
		txtBMI.setBounds(47, 291, 159, 36);
		frame.getContentPane().add(txtBMI);
		txtBMI.setColumns(10);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radioAsian.isSelected() == true) {
					if(tinhtoan < 18.5) txtStatus.setText("Underweight!");
					else	if(tinhtoan >= 18.5 && tinhtoan <= 22.9)	txtStatus.setText("You are Good :D");
					else	if(tinhtoan >= 23 && tinhtoan <= 24.9)	txtStatus.setText("You are Overweight");
					else	if(tinhtoan >= 25 && tinhtoan <=29.9)	txtStatus.setText("Pre-Obese!");
					else	if(tinhtoan == 30)	txtStatus.setText("Obese");
					else	if(tinhtoan > 30 && tinhtoan <= 40)		txtStatus.setText("Obese I");
					else	if(tinhtoan > 40 && tinhtoan <= 50)		txtStatus.setText("Obese II");
					else	txtStatus.setText("Obesity III");
				}
				else if(radioNon.isSelected() == true) {
					if(tinhtoan < 18.5) txtStatus.setText("Underweight!");
					else	if(tinhtoan >= 18.5 && tinhtoan <= 24.9)	txtStatus.setText("You are Good :D");
					else	if(tinhtoan >= 25 && tinhtoan <= 29.9)	txtStatus.setText("You are Overweight");
					else	if(tinhtoan == 30)	txtStatus.setText("Obese!");
					else	if(tinhtoan > 30 && tinhtoan <= 40)		txtStatus.setText("Obese I");
					else	if(tinhtoan > 40 && tinhtoan <= 50)		txtStatus.setText("Obese II");
					else 	txtStatus.setText("Obese III");
				}
			}
		});
		btnStatus.setBackground(Color.BLUE);
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStatus.setBounds(385, 221, 109, 44);
		frame.getContentPane().add(btnStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(340, 291, 178, 36);
		frame.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		frame.setBounds(100, 100, 637, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
