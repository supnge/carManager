package com.carManager.domain;

public class TChe {
    private Integer id;

    private String chepai;

    private String chexing;

    private String chuchangriqi;

    private String zaizhongliang;

    private Integer sijiId;

    private String shiyouleixing;

    private String insertDate;

    private String updateDate;

    private String deleteDate;

    private String del;

    // 添加个性信息：
    private String driverName;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public TChe() {
    }

    public TChe(Integer id, String chepai, String chexing, String chuchangriqi, String zaizhongliang, Integer sijiId, String shiyouleixing, String del) {
        this.id = id;
        this.chepai = chepai;
        this.chexing = chexing;
        this.chuchangriqi = chuchangriqi;
        this.zaizhongliang = zaizhongliang;
        this.sijiId = sijiId;
        this.shiyouleixing = shiyouleixing;
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChepai() {
        return chepai;
    }

    public void setChepai(String chepai) {
        this.chepai = chepai == null ? null : chepai.trim();
    }

    public String getChexing() {
        return chexing;
    }

    public void setChexing(String chexing) {
        this.chexing = chexing == null ? null : chexing.trim();
    }

    public String getChuchangriqi() {
        return chuchangriqi;
    }

    public void setChuchangriqi(String chuchangriqi) {
        this.chuchangriqi = chuchangriqi == null ? null : chuchangriqi.trim();
    }

    public String getZaizhongliang() {
        return zaizhongliang;
    }

    public void setZaizhongliang(String zaizhongliang) {
        this.zaizhongliang = zaizhongliang == null ? null : zaizhongliang.trim();
    }

    public Integer getSijiId() {
        return sijiId;
    }

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }

    public String getShiyouleixing() {
        return shiyouleixing;
    }

    public void setShiyouleixing(String shiyouleixing) {
        this.shiyouleixing = shiyouleixing == null ? null : shiyouleixing.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
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
}