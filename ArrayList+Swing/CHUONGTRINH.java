package clc61.ntu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class CHUONGTRINH {
	//Khai bao danh sach
	ArrayList<String> dsten;
	
	
	private JFrame Demo;
	private JTextField txtName;
	JLabel lblHoTen;
	JButton btnAdd;
	JButton btnShow;
	JTextArea textAreaHoTen;
	JLabel lblStatus;
	private JTextField textNameFind;
	private JButton btnTim;
	private JLabel lblTim;
	private JTextArea textAreaNameNow;
	private JLabel lblDanhSach;
	private JFrame frmArraylist;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHUONGTRINH window = new CHUONGTRINH();
					window.Demo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CHUONGTRINH() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Demo = new JFrame();
		Demo.setTitle("Demo");
		Demo.setBounds(100, 100, 577, 402);
		Demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Demo.getContentPane().setLayout(null);
		
		lblHoTen = new JLabel("H\u1ECD v\u00E0 T\u00EAn :");
		lblHoTen.setBounds(23, 28, 73, 20);
		Demo.getContentPane().add(lblHoTen);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				lblStatus.setText("I'm waiting!");
			}
		});
		txtName.setBounds(121, 28, 273, 20);
		Demo.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		btnAdd = new JButton("Th\u00EAm");
		dsten = new ArrayList<String>();
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//su dung ArrayList la bien toan cuc
				addDS(dsten);	//void addDS(ArrayList<String> a)
			}
		});
		btnAdd.setBounds(434, 27, 89, 23);
		Demo.getContentPane().add(btnAdd);
		
		btnShow = new JButton("Hi\u1EC3n Th\u1ECB");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				showDS(dsten);//void showDS(ArrayList<String> a)
			}
		});
		btnShow.setBounds(58, 153, 89, 23);
		Demo.getContentPane().add(btnShow);
		
		textAreaHoTen = new JTextArea();
		textAreaHoTen.setBounds(23, 187, 173, 154);
		Demo.getContentPane().add(textAreaHoTen);
		
		lblStatus = new JLabel("Hi\u1EC7n Th\u1ECB Tr\u1EA1ng Th\u00E1i");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(231, 49, 137, 14);
		Demo.getContentPane().add(lblStatus);
		
		textNameFind = new JTextField();
		textNameFind.setBounds(121, 73, 273, 20);
		Demo.getContentPane().add(textNameFind);
		textNameFind.setColumns(10);
		
		btnTim = new JButton("T\u00ECm Ki\u1EBFm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
				for(int index = 0; index < dsten.size(); index++) {
					String sTen = dsten.get(index);
					if (sTen.equals(textNameFind.getText())){
						result = true;
						break;
					}
					else {
						result = false;
					}
				}
				if(result == true) {
					JOptionPane.showMessageDialog(Demo, "Tên vừa nhập có trong danh sách!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					JOptionPane.showMessageDialog(Demo, "Tên vừa nhập chưa có trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnTim.setBounds(434, 73, 89, 21);
		Demo.getContentPane().add(btnTim);
		
		lblTim = new JLabel("T\u00ECm Ki\u1EBFm T\u00EAn");
		lblTim.setBounds(23, 76, 88, 14);
		Demo.getContentPane().add(lblTim);
		
		textAreaNameNow = new JTextArea();
		textAreaNameNow.setBounds(350, 187, 173, 154);
		Demo.getContentPane().add(textAreaNameNow);
		
		lblDanhSach = new JLabel("Danh S\u00E1ch T\u00EAn");
		lblDanhSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSach.setBounds(350, 157, 173, 14);
		Demo.getContentPane().add(lblDanhSach);
	}
	//
	void addDS(ArrayList<String> a) {
		String hoten = txtName.getText();
		a.add(hoten);
		//xoa noi dung
		txtName.setText("");
		//status
		lblStatus.setText("added");
		textAreaNameNow.append(hoten + "\n");
	}
	
	void showDS(ArrayList<String> a) {
		String fName = textNameFind.getText();
		for(int index = 0; index<a.size(); index++) {
			//lay gia tri o vi tri index 
			String sTen = a.get(index);
			//dua vao dsshow
			if(fName.equals(sTen) == true) {
				textAreaHoTen.append(fName + "\n");
				textNameFind.setText("");
			}
		}
	}
}
