package main.java.com.upb.agripos;

import main.java.com.upb.agripos.Model.Pembayaran.*;
import main.java.com.upb.agripos.Model.Kontrak.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("MDL-076", 150000, 170000);
        Pembayaran ew = new EWallet("SMS-098", 250000, "Steve@ewallet", "123456");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

    CreditBy.print("240202836", "Husain Stefano");
    }
}