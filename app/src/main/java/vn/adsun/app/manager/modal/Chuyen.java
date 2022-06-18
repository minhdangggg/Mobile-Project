package vn.adsun.app.manager.modal;

public class Chuyen {
    private int id;
    private String noiDi;
    private String noiDen;
    private String ngayDi;
    private String ngayVe;
    private boolean khuHoi;

    public Chuyen() {
    }

    public Chuyen(int id, String noiDi, String noiDen, String ngayDi, String ngayVe, boolean khuHoi) {
        this.id = id;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.ngayDi = ngayDi;
        this.ngayVe = ngayVe;
        this.khuHoi = khuHoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public boolean isKhuHoi() {
        return khuHoi;
    }

    public void setKhuHoi(boolean khuHoi) {
        this.khuHoi = khuHoi;
    }

    public String getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(String ngayVe) {
        this.ngayVe = ngayVe;
    }
}
