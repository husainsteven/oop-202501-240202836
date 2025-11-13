package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("PKK-505", "Benih Padi Galur", 30000, 60, "Galur");
        Pupuk p = new Pupuk("AKA-195", "Pupuk Gramason", 450000, 90, "Gramason");
        AlatPertanian a = new AlatPertanian("LOT-990", "Rontog", 1500000, 10, "Kayu");

        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print("240202836", "Husain Stefano");
    }
}