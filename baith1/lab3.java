package lab1;

import java.util.Scanner;

public class lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("nhap canh hinh lap phuong : ");
		double canh = scanner.nextDouble();
		
		double thetich = canh * canh * canh ;
		System.out.printf("the tich lap phuong : %.2f",thetich);
	}

}
