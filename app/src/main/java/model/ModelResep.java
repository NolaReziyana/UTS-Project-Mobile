package model;

import com.google.gson.annotations.SerializedName;

public class ModelResep {
    @SerializedName("no_item")
    private int no_item;
    @SerializedName("namaresep")
    private String namaresep;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("date")
    private String date;
    @SerializedName("gambar")
    private String gambar;

    public ModelResep(String namaresep, String keterangan, String date, String gambar) {
        this.namaresep = namaresep;
        this.keterangan = keterangan;
        this.date = date;
        this.gambar = gambar;
    }

    public int getNo_item() {
        return no_item;
    }

    public void setNo_item(int no_item) {
        this.no_item = no_item;
    }

    public String getNamaresep() {
        return namaresep;
    }

    public void setNamaresep(String namaresep) {
        this.namaresep = namaresep;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
