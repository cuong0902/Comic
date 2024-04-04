package com.hyquangcuong.commicapp.Model;

public class Truyen {
    private int id;
    private String tenTruyen;
    private String noiDung;
    private String anh;
    private int ID_USER;

    public Truyen(String tenTruyen, String noiDung, String anh, int ID_USER) {
        this.tenTruyen = tenTruyen;
        this.noiDung = noiDung;
        this.anh = anh;
        this.ID_USER = ID_USER;
    }

    public Truyen(int id, String tenTruyen, String noiDung, String anh, int ID_USER) {
        this.id = id;
        this.tenTruyen = tenTruyen;
        this.noiDung = noiDung;
        this.anh = anh;
        this.ID_USER = ID_USER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }
}
