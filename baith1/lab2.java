package lab1;

import java.util.Scanner;

public class lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("nhập chiều dài : ");
		float chieudai = scanner.nextFloat();
		
		System.out.print("nhập chiều rộng : ");
		float chieurong = scanner.nextFloat();
		
		float cv = ( chieudai + chieurong ) * 2 ;
		float dt = (chieudai*chieurong);
		float mincanh= Math.min(chieudai,chieurong);
		
		System.out.printf("CHU VI LA : %.2f \nDIEN TICH LA : %.2f \nMINCANH LA : %.2f", cv, dt, mincanh);
		

	}

}
