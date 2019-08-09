package com.carManager.domain;

public class THetong {
    private Integer id;

    private String name;

    private Integer cheId;

    private String photoId;

    private Integer huowuId;

    private String insertDate;

    private String updateDate;

    private String deleteDate;

    private String del;

    public THetong() {
    }

    public THetong(Integer id, Integer cheId, String photoId, Integer huowuId) {
        this.id = id;
        this.cheId = cheId;
        this.photoId = photoId;
        this.huowuId = huowuId;
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
        this.name = name;
    }

    public Integer getCheId() {
        return cheId;
    }

    public void setCheId(Integer cheId) {
        this.cheId = cheId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public Integer getHuowuId() {
        return huowuId;
    }

    public void setHuowuId(Integer huowuId) {
        this.huowuId = huowuId;
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