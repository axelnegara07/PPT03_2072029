package com.example.ppt03_2072029.Entity;

public class Barang {
    private String id;
    private String nama;
    private String supplier;

    public Barang(String id, String nama, String supplier) {
        this.id = id;
        this.nama = nama;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
