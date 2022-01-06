package javaHCM;

public class QuanTanBinh {

	public static void main(String[] args) {
		QuanBinhThanh binhthanh = new QuanBinhThanh();
		
		System.out.println(binhthanh.getSchool());
		
		binhthanh.setSchool("Hồng Bàng");
		
		System.out.println(binhthanh.getSchool());
		
		System.out.println(binhthanh.getfood());
		binhthanh.setFood("Phở Thanh Đa");
		System.out.println(binhthanh.getfood());

		
		
	}

}
