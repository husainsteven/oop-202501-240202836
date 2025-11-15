package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BKN-670", "Benih Padi Mapan", 40000, 110, "Mapan");
        Pupuk p = new Pupuk("PKK-191", "Pupuk Gramason", 300000, 35, "Gramason");
        AlatPertanian a = new AlatPertanian("JJA-551", "Pompa Air", 1000000, 10, "Besi");

        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print("240202836", "Husain Stefano");
    }
}