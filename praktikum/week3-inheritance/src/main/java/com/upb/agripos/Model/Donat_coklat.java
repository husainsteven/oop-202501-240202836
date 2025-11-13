package main.java.com.upb.agripos.Model;

public class Donat_coklat {
     private String varietas;

    public Donat_coklat(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
    
}
