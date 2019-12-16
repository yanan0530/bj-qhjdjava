package com.spring.model;

public class GoodsModel {
    private int id;
    private int typeid;
    private String redirecturl;
    private String templet;
    private String userip;
    private String mz;
    private String gg;
    private String jdpj;
    private String pjbh;
    private String articlemain;
    private String pinming;
    private String nf;
    private String printUrl;
    private String isepq;
    private String img;
    private Long senddate;

    public Long getSenddate() {
        return senddate;
    }

    public void setSenddate(Long senddate) {
        this.senddate = senddate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    public String getTemplet() {
        return templet;
    }

    public void setTemplet(String templet) {
        this.templet = templet;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getJdpj() {
        return jdpj;
    }

    public void setJdpj(String jdpj) {
        this.jdpj = jdpj;
    }

    public String getPjbh() {
        return pjbh;
    }

    public void setPjbh(String pjbh) {
        this.pjbh = pjbh;
    }

    public String getArticlemain() {
        return articlemain;
    }

    public void setArticlemain(String articlemain) {

        this.articlemain = articlemain;
    }

    public String getPinming() {
        return pinming;
    }

    public void setPinming(String pinming) {
        this.pinming = pinming;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getPrintUrl() {
        return printUrl;
    }

    public void setPrintUrl(String printUrl) {
        this.printUrl = printUrl;
    }

    public String getIsepq() {
        return isepq;
    }

    public void setIsepq(String isepq) {
        this.isepq = isepq;
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "id=" + id +
                ", typeid=" + typeid +
                ", redirecturl='" + redirecturl + '\'' +
                ", templet='" + templet + '\'' +
                ", userip='" + userip + '\'' +
                ", mz='" + mz + '\'' +
                ", gg='" + gg + '\'' +
                ", jdpj='" + jdpj + '\'' +
                ", pjbh='" + pjbh + '\'' +
                ", articlemain='" + articlemain + '\'' +
                ", pinming='" + pinming + '\'' +
                ", nf='" + nf + '\'' +
                ", printUrl='" + printUrl + '\'' +
                ", isepq='" + isepq + '\'' +
                ", img='" + img + '\'' +
                ", senddate=" + senddate +
                '}';
    }
}
