package lab1;

import java.util.Scanner;

public class lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Họ Tên : ");
		String hoten = scanner.nextLine();
		
		System.out.print("Điểm Tb : ");
		double diem = scanner.nextDouble();
		
		System.out.printf("%s: %.1f điểm" ,hoten ,diem);		

	}

}
