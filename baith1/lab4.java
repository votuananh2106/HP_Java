package lab1;

import java.util.Scanner;

public class lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a, b, c ;
		double delta, candelta ;
		System.out.print("nhap a");
		 a = scanner.nextInt();
		System.out.print("nhap b");
		 b = scanner.nextInt();
		System.out.print("nhap c");
		 c = scanner.nextInt();
		  
		 delta = Math.pow(b,2)-4*a*c;
		 candelta = Math.sqrt(delta);
		 
		 System.out.printf("delta bang : %f \n Căn delta bang : %f" ,delta, candelta);
		
		
		

	}

}
