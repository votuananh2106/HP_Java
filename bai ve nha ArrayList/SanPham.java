package clc61.ntu;

public class SanPham {
	String ma, ten;
	int gia;
	
	public SanPham() {
		super();
		ma = "MA";
		ten= "TEN";
		gia = 0;
	}

	public SanPham(String ma, String ten, int gia) {
		this.ma = ma;
		this.ten = ten;
		this.gia = gia;
	}

	public String getma() {
		return ma;
	}

	public void setma(String ma) {
		this.ma = ma;
	}

	public String getten() {
		return ten;
	}

	public void setten(String ten) {
		this.ten = ten;
	}

	public int getgia() {
		return gia;
	}

	public void setgia(int gia) {
		this.gia= gia;
	}
}
