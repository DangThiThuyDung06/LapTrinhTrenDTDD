package com.bt2.baikt2_th;

public class Ca {
    private String tenkhoahoc, tenthuonggoi, dactinh, mausac;
    private int anh;
    private float star;

    public Ca() {
    }

    @Override
    public String toString() {
        return "Ca{" +
                "tenkhoahoc='" + tenkhoahoc + '\'' +
                ", tenthuonggoi='" + tenthuonggoi + '\'' +
                ", dactinh='" + dactinh + '\'' +
                ", mausac='" + mausac + '\'' +
                ", anh=" + anh +
                ", star=" + star +
                '}';
    }

    public Ca(String tenkhoahoc, String tenthuonggoi, String dactinh, String mausac, int anh, float star) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.mausac = mausac;
        this.anh = anh;
        this.star = star;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
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
