package com.carManager.domain;

public class TChuche {

    private Integer id;

    private Integer cheId;

    private String kaichushijian;

    private String huilaishijian;

    private String shiyou;

    private String del;

    private String mudidizhi;

    private String qishidizhi;

    private String insertDate;

    private String updateDate;

    private String deleteDate;

    private String chepai;

    public TChuche() {
    }

    public TChuche(Integer id, Integer cheId, String kaichushijian, String huilaishijian, String shiyou, String del, String mudidizhi, String qishidizhi) {
        this.id = id;
        this.cheId = cheId;
        this.kaichushijian = kaichushijian;
        this.huilaishijian = huilaishijian;
        this.shiyou = shiyou;
        this.del = del;
        this.mudidizhi = mudidizhi;
        this.qishidizhi = qishidizhi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheId() {
        return cheId;
    }

    public void setCheId(Integer cheId) {
        this.cheId = cheId;
    }

    public String getKaichushijian() {
        return kaichushijian;
    }

    public void setKaichushijian(String kaichushijian) {
        this.kaichushijian = kaichushijian == null ? null : kaichushijian.trim();
    }

    public String getHuilaishijian() {
        return huilaishijian;
    }

    public void setHuilaishijian(String huilaishijian) {
        this.huilaishijian = huilaishijian == null ? null : huilaishijian.trim();
    }

    public String getShiyou() {
        return shiyou;
    }

    public void setShiyou(String shiyou) {
        this.shiyou = shiyou == null ? null : shiyou.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }

    public String getMudidizhi() {
        return mudidizhi;
    }

    public void setMudidizhi(String mudidizhi) {
        this.mudidizhi = mudidizhi == null ? null : mudidizhi.trim();
    }

    public String getQishidizhi() {
        return qishidizhi;
    }

    public void setQishidizhi(String qishidizhi) {
        this.qishidizhi = qishidizhi == null ? null : qishidizhi.trim();
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getChepai() {
        return chepai;
    }

    public void setChepai(String chepai) {
        this.chepai = chepai;
    }
}