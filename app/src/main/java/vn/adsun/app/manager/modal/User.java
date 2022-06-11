package vn.adsun.app.manager.modal;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private String position;
    private String companyname;
    private String addressCompany;
    private String MST;

    public User(String name, String email, String position, String companyname, String addressCompany, String MST) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.companyname = companyname;
        this.addressCompany = addressCompany;
        this.MST = MST;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getAddressCompany() {
        return addressCompany;
    }

    public void setAddressCompany(String addressCompany) {
        this.addressCompany = addressCompany;
    }

    public String getMST() {
        return MST;
    }

    public void setMST(String MST) {
        this.MST = MST;
    }
}
