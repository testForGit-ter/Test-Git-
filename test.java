
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * GiangVien
 */
class GiangVien {
    static int ma = 2;
    String ten, hesokk, MA;
    double hesoLuong;
    int hour;
    int luong;

    public GiangVien(String ten, double hesoLuong, String hesoKK, int hour)
    {
        this.ten = ten;
        this.hesoLuong = hesoLuong;
        this.hesokk = hesoKK;
        this.hour = hour;
        MA = "PM" + String.format("%03d", ma+=1);
    }

    public long GetLuong()
    {
       double hs;
       if(hesokk.equals("A")){
        hs = 1.5;
       } else if(hesokk.equals("B")){
        hs = 1.2;
       }else{
        hs = 1;
       }

       double luo = hesoLuong * hs * 3000;
       if(hour <= 100){
        luo *= 0.85;
       }else if(hour <= 350){
        luo *= 0.9;
       }else if(hour <= 499){
        luo *= 0.95;
       }

       return Math.round(luo);


    }

    public String GetLowName()
    {
        return this.ten.toLowerCase();
    }

    @Override
    public String toString() {
        return this.MA + " " + this.ten + " " + this.hesoLuong + " " 
            + this.hesokk +" " + this.hour + " " + this.GetLuong();
    }


    
}

public class b3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        List<GiangVien> giangViens = new ArrayList<>();
        while (t-- > 0) {
            GiangVien giangVien = new GiangVien(scanner.nextLine(), Double.parseDouble(scanner.nextLine()), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
            giangViens.add(giangVien);
        }
        String check = scanner.nextLine();
        for (GiangVien giangVien : giangViens) {
            if(giangVien.GetLowName().contains(check))
                System.out.println(giangVien);

        }
        scanner.close();
    }

}
