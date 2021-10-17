package clc61.ntu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Program {

	private JFrame mainFrame;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtgia;
	JLabel lblma;
	JLabel lblTen;
	JLabel lblGia;
	JButton btnThem;
	JButton btnTim;
	JButton btnXoa;
	JButton btnSua;
	JTextArea txtArea;
	
	List<SanPham> hienDS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 698, 450);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		lblma = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
		lblma.setForeground(Color.RED);
		lblma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblma.setBounds(35, 38, 102, 25);
		mainFrame.getContentPane().add(lblma);
		
		txtma = new JTextField();
		txtma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtma.setBounds(159, 38, 474, 25);
		mainFrame.getContentPane().add(txtma);
		txtma.setColumns(10);
		
		txtten = new JTextField();
		txtten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtten.setColumns(10);
		txtten.setBounds(159, 85, 474, 25);
		mainFrame.getContentPane().add(txtten);
		
		lblTen = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
		lblTen.setForeground(Color.RED);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTen.setBounds(35, 85, 102, 25);
		mainFrame.getContentPane().add(lblTen);
		
		txtgia = new JTextField();
		txtgia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgia.setColumns(10);
		txtgia.setBounds(159, 132, 474, 25);
		mainFrame.getContentPane().add(txtgia);
		
		lblGia = new JLabel("Gi\u00E1 S\u1EA3n Ph\u1EA9m");
		lblGia.setForeground(Color.RED);
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGia.setBounds(35, 132, 102, 25);
		mainFrame.getContentPane().add(lblGia);
		
		hienDS = new ArrayList<SanPham>();
		
		btnThem = new JButton("Th\u00EAm");
		btnThem.setBackground(Color.BLUE);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(hienDS);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(10, 195, 120, 25);
		mainFrame.getContentPane().add(btnThem);
		
		btnTim = new JButton("T\u00ECm ki\u1EBFm");
		btnTim.setBackground(Color.BLUE);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchProduct(hienDS);
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(189, 195, 120, 25);
		mainFrame.getContentPane().add(btnTim);
		
		btnXoa = new JButton("X\u00F3a");
		btnXoa.setBackground(Color.BLUE);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProduct(hienDS);
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(376, 195, 120, 25);
		mainFrame.getContentPane().add(btnXoa);
		
		btnSua = new JButton("S\u1EEDa");
		btnSua.setBackground(Color.BLUE);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editProduct(hienDS);
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(554, 195, 120, 25);
		mainFrame.getContentPane().add(btnSua);
		
		txtArea = new JTextArea();
		txtArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtArea.setBounds(10, 247, 664, 135);
		txtArea.setText("M\u00E3SP_T\u00EAnSP_\u0110\u01A1nGi\u00E1");
		
		mainFrame.getContentPane().add(txtArea);
	}

	protected void addToList(List<SanPham> arr) {
		String id = txtma.getText();
		String name = txtten.getText();
		String price_text = txtgia.getText();
		
		int price;
		
		try {
			price = Integer.parseInt(price_text);
		} catch (Exception ex) {
			price = 0;
			txtgia.setText("");
		}
		
		if(!(checkma(id)) || (id.equals("")) || (id.contains(" ")))
			hienthi("MÃ KHÔNG HỢP LỆ>>>", "Lỗi", JOptionPane.ERROR_MESSAGE);
		else
			arr.add(new SanPham (id, name, price));
		
		displayList(arr);
		
		txtma.setText("");
		txtten.setText("");
		txtgia.setText("");
	}

	protected void searchProduct(List<SanPham> arr) {
		String toSearch = txtma.getText();

		for (SanPham  element : arr) {
			if (element.getma().contains(toSearch)) {
				hienthi("Mã SP: " + element.getma() + " - Tên SP: " + element.getten() + " - GIÁ SP: " + element.getgia(), "Sản Phẩm tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}

	protected void deleteProduct(List<SanPham > arr) {
		String toDelete = txtma.getText();

		for (SanPham  element : arr) {
			if (element.getma().equals(toDelete)) {
				arr.remove(arr.indexOf(element));
				break;
			}
		}
		
		displayList(arr);
	}
	
	protected void editProduct(List<SanPham > arr) {
		String toEdit = txtma.getText();

		for (SanPham  element : arr) {
			if (element.getma().equals(toEdit)) {
				arr.remove(arr.indexOf(element));
				addToList(arr);
				break;
			}
		}
		
		displayList(arr);
	}

	private void displayList(List<SanPham > arr) {
		txtArea.setText("MãSP_TênSP_ĐơnGiá\n");

		for (SanPham  element : arr) {
			txtArea.append(element.getma() + "_ " + element.getten() + "_ " + element.getgia() + "\n");
		}
	}
	
	private boolean checkma(String id) {
		for (SanPham element : hienDS) {
			if(element.getten().equals(id))
				return false;
		}		
		return true;
	}
	
	private void hienthi(String msg, String title, int msgType) {
		JFrame frame = new JFrame("JDialog");
		JOptionPane.showMessageDialog(frame, msg, title, msgType);
	}
}
