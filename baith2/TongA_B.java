import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class lab {

	public static void main(String[] args) {
		Frame fr = new Frame("Tong 2 so A va B");
		fr.setBounds(0,0,600,400);
		fr.setSize(500, 500);
		fr.setLayout(null);
		
		//

		Label lblA = new Label("A  = ");
		Label lblB = new Label("B   = ");
		Label lblKQ = new Label("KQ  = ");

		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtKQ = new TextField();


		Button btnCong = new Button("Tinh tong");
		
		//GAN VAO F

		fr.add(lblA); fr.add(txtA);
		fr.add(lblB); fr.add(txtB);
		
		fr.add(btnCong);
		
		fr.add(lblKQ);fr.add(txtKQ);
		
		

		lblA.setLocation(50, 80 );
		lblA.setSize(50,50 );
		txtA.setLocation(120, 80 );
		txtA.setSize(100, 40);

		lblB.setLocation(50, 160);
		lblB.setSize(50, 50);
		txtB.setLocation(120, 140);
		txtB.setSize(100, 40);

		btnCong.setLocation(100, 220);
		btnCong.setSize(160, 40);

		lblKQ.setLocation(40, 300);
		lblKQ.setSize(50, 20);
		txtKQ.setLocation(90, 300);
		txtKQ.setSize(200, 40);
		
		// Xu ly su kien nut tinh tong 

		ActionListener bolangnghe = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strA = txtA.getText();
				String strB = txtB.getText();
				
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);

				int c = a + b;
				txtKQ.setText(String.valueOf(c));
				
			}

		};

		btnCong.addActionListener(bolangnghe);
		

		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		fr.setVisible(true);
	}
}



