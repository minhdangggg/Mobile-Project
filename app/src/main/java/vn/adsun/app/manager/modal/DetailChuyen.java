package vn.adsun.app.manager.modal;

import java.util.List;

public class DetailChuyen {
    private int id;

    private String giaTienChu;

    private double giaTienSo;

    private List<Chuyen> chuyens;

    public DetailChuyen() {
    }

    public DetailChuyen(int id, String giaTienChu, double giaTienSo, List<Chuyen> chuyens) {
        this.id = id;
        this.giaTienChu = giaTienChu;
        this.giaTienSo = giaTienSo;
        this.chuyens = chuyens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiaTienChu() {
        return giaTienChu;
    }

    public void setGiaTienChu(String giaTienChu) {
        this.giaTienChu = giaTienChu;
    }

    public double getGiaTienSo() {
        return giaTienSo;
    }

    public void setGiaTienSo(double giaTienSo) {
        this.giaTienSo = giaTienSo;
    }

    public List<Chuyen> getChuyens() {
        return chuyens;
    }

    public void setChuyens(List<Chuyen> chuyens) {
        this.chuyens = chuyens;
    }
}
