import java.util.Scanner;

public class tinh_bmi {

	public static void main(String[] args) {
		double chieucao , cannang, chisoBMI;
		String ketqua;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap chieu cao :");
		chieucao = scanner.nextDouble();
		System.out.println("nhap can nang :");
		cannang = scanner.nextDouble();
		
		chisoBMI = cannang/(chieucao*chieucao);
		
		if (chisoBMI<18) {
			ketqua = "ban la nguoi gay";
		}else if(chisoBMI<25){
			ketqua="ban la nguoi binh thuong";
			
		}else if(chisoBMI<=30) {
			ketqua="ban bi beo phi 1";
		}else if(chisoBMI<=35) {
			ketqua="ban bi beo phi 2";
			
		}else {
			ketqua="ban bi beo phi 3";
		}
		System.out.println(ketqua);

	}

}
