package Menu;  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.Random;  
import java.util.Scanner;  
import object.Barang;
import object.Tarif;  

public class Welcome extends Bil {  

  public Welcome(int angka) {  
    super(angka);  
  }  

  static Scanner ssc1 = new Scanner(System.in);  
  static BufferedReader ssc2 = new BufferedReader(new InputStreamReader(System.in));  
  static Tarif trf = new Tarif(0,0,0,0);  
  static Barang brg;  
  static Random nores = new Random();  
  static ArrayList<Barang> data = new ArrayList<Barang>();  

  public static void main(String[] args) throws IOException {  
    Login();  
    do {
      menu();  
    } while (true);  
  }

  private static void Login() throws IOException {
    String myUser, myPassword;
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
  
    //instance of class
    Database user1= new Database();
    System.out.println("\n");
    System.out.println("============= LOGIN =============");
    System.out.print("|  Masukan username = "); myUser=br.readLine();
    System.out.print("|  Masukan password = "); myPassword=br.readLine();
    System.out.println("=================================\n\n");
  
    if(myUser.equals(user1.getUsername())&& myPassword.equals(user1.getPassword())) {
        System.out.println("      *** Login Sukses ***");
        System.out.println(" Selamat Datang " + user1.getNama());
        System.out.println("\n");
    } else {

      System.out.println("       *** Login Gagal ***\n\n");

      do {
        System.out.println("============ LOGIN ==============");
        System.out.print("|  Masukan username = "); myUser=br.readLine();
        System.out.print("|  Masukan password = "); myPassword=br.readLine();
        System.out.println("=================================");
      }
      while(myUser.equals(user1.getUsername())&& myPassword.equals(user1.getPassword()));
    }  
  }

  private static void menu() throws IOException { 
    System.out.println("===============================================");  
    System.out.println("\t         Welcome To          ");  
    System.out.println("\t     Indo Dana PayLatter     ");  
    System.out.println("===============================================");  
    System.out.println("Pilih Menu :");  
    System.out.println(" 1. Check Harga Paket \n 2. Input Data Paket \n 3. Lihat Data Paket \n 4. Mulai Menu \n 5. Exit ");  
    System.out.println("===============================================");  
    System.out.print("Memilih : ");  
    int pilih = ssc1.nextInt();  
    System.out.println("===============================================");  
    switch (pilih) {

      case 1:  
        System.out.println();  
        System.out.println("===============================================");  
        System.out.println("Check Tarif Paket");  
        System.out.println("===============================================");  
        System.out.print("Berat Paket (Kg)\t= ");  
        int berat = ssc1.nextInt();  
        System.out.print("Panjang Paket (Cm)\t= ");  
        int panjang = ssc1.nextInt();  
        System.out.print("Lebar Paket (Cm)\t= ");  
        int lebar = ssc1.nextInt();  
        System.out.print("Tinggi Paket (Cm)\t= ");  
        int tinggi = ssc1.nextInt();  
        trf = new Tarif(berat, panjang, lebar, tinggi);  
        trf.rumus();  
        System.out.println("===============================================");  
        System.out.println("Total Harga = Rp. "+trf.tarif);  
        System.out.println("===============================================");  
        System.out.println();  
        berat = 0;  
        panjang = 0;  
        lebar = 0;  
        tinggi = 0;  
        break;  

      case 2:  
        System.out.println();  
        System.out.println("===============================================");  
        System.out.println("Kirim Paket");  
        System.out.println("===============================================");  
        System.out.print("Nama Pengirim\t\t= ");  
        String namPengirim = ssc2.readLine();  
        System.out.print("Alamat Pengirim\t\t= ");  
        String alaPengirim = ssc2.readLine();  
        System.out.print("Nama Penerima\t\t= ");  
        String namPenerima = ssc2.readLine();  
        System.out.print("Alamat Penerima\t= ");  
        String alaPenerima = ssc2.readLine();  
        System.out.print("Berat Paket (Kg)\t= ");  
        berat = ssc1.nextInt();  
        System.out.print("Panjang Paket (Cm)\t= ");  
        panjang = ssc1.nextInt();  
        System.out.print("Lebar Paket (Cm)\t= ");  
        lebar = ssc1.nextInt();  
        System.out.print("Tinggi Paket (Cm)\t= ");  
        tinggi = ssc1.nextInt();  
        int resi = nores.nextInt(999999999) + 111111111;  
        data.add(brg = new Barang(namPengirim, alaPengirim, namPenerima, alaPenerima, resi, berat, panjang, lebar, tinggi));  
        brg.rumus();  
        System.out.println("===============================================");  
        System.out.println("Harga yang harus dibayar = Rp. "+brg.tarif);  
        System.out.println("Data Telah Disimpan ...");  
        System.out.println("===============================================");  
        System.out.println();  
        break;  

      case 3:  
        System.out.println();  
        System.out.println("===============================================");  
        System.out.println("Lihat  Data Paket");  
        System.out.println("===============================================");  
        int i = 0;  
        for (Barang o:data) {  
          System.out.println("Data To - "+(i+1));  
          System.out.println("Nama Pengirim\t= " + o.getNama_pengirim());  
          System.out.println("Alamat Pengirim\t= " + o.getAlamat_pengirim());  
          System.out.println("Nama Penerima\t= " + o.getNama_penerima());  
          System.out.println("Alamat Penerima\t= " + o.getAlamat_penerima());  
          System.out.println("Resi\t= " + o.getNomor_resi());  
          System.out.println("Status\t\t= " + o.getStatus());  
          System.out.println("Harga\t\t= &. " + o.tarif);  
          System.out.println("===============================================");  
          i++;  
        }  
        System.out.println();  
        break;  

      case 4:
        System.out.println();  
        break;  


      case 5:
        System.out.println("Exit ...");  
        System.exit(0);  
        break;    

      default:  
        System.out.println("Error, Mohon Isi data dengan Benar...");  
        break;  
    }  
  }  
}  
