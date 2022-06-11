package vn.adsun.app.manager.modal;

public class Schedule {
    private int Id;
    private double fee;
    private String feeText;
    private String date;
    private String address;
    private int status;
    private String content;

    public Schedule(int id, double fee, String feeText, String date, String address, int status, String content) {
        Id = id;
        this.fee = fee;
        this.feeText = feeText;
        this.date = date;
        this.address = address;
        this.status = status;
        this.content = content;
    }

    public Schedule() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeeText() {
        return feeText;
    }

    public void setFeeText(String feeText) {
        this.feeText = feeText;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
