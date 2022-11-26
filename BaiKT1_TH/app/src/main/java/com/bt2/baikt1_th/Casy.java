package com.bt2.baikt1_th;

public class Casy {
    private String ten, nghedanh, quocgia;
    private int anh;
    private float star;

    public Casy(String ten, String nghedanh, String quocgia, int anh, float star) {
        this.ten = ten;
        this.nghedanh = nghedanh;
        this.quocgia = quocgia;
        this.anh = anh;
        this.star = star;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNghedanh() {
        return nghedanh;
    }

    public void setNghedanh(String nghedanh) {
        this.nghedanh = nghedanh;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
