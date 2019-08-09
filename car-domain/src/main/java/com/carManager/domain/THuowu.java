package com.carManager.domain;

public class THuowu {
    private Integer id;

    private String name;

    private Float danjia;

    private Integer carId;

    private Float carZaizhong;

    private Float zongjia;

    private String insertDate;

    private String updateDate;

    private String deleteDate;

    private String remark;

    private String del;

    public THuowu() {
    }

    public THuowu(Integer id, String name, Float danjia, Integer carId, Float carZaizhong, Float zongjia, String remark, String del) {
        this.id = id;
        this.name = name;
        this.danjia = danjia;
        this.carId = carId;
        this.carZaizhong = carZaizhong;
        this.zongjia = zongjia;
        this.remark = remark;
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getDanjia() {
        return danjia;
    }

    public void setDanjia(Float danjia) {
        this.danjia = danjia;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Float getCarZaizhong() {
        return carZaizhong;
    }

    public void setCarZaizhong(Float carZaizhong) {
        this.carZaizhong = carZaizhong;
    }

    public Float getZongjia() {
        return zongjia;
    }

    public void setZongjia(Float zongjia) {
        this.zongjia = zongjia;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }
}