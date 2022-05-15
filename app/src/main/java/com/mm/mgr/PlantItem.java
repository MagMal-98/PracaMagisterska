package com.mm.mgr;

public class PlantItem {

    String title, subtitle, bloomTime, info, soilPh, sunExpoisure, purl;

    public PlantItem() {
    }

    public PlantItem(String title, String subtitle, String bloomTime, String info, String soilPh, String sunExpoisure, String purl) {
        this.title = title;
        this.subtitle = subtitle;
        this.bloomTime = bloomTime;
        this.info = info;
        this.soilPh = soilPh;
        this.sunExpoisure = sunExpoisure;
        this.purl = purl;
    }

    public PlantItem(String title, String subtitle, String purl) {
        this.title = title;
        this.subtitle = subtitle;
        this.purl = purl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBloomTime() {
        return bloomTime;
    }

    public void setBloomTime(String bloomTime) {
        this.bloomTime = bloomTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSoilPh() {
        return soilPh;
    }

    public void setSoilPh(String soilPh) {
        this.soilPh = soilPh;
    }

    public String getSunExpoisure() {
        return sunExpoisure;
    }

    public void setSunExpoisure(String sunExpoisure) {
        this.sunExpoisure = sunExpoisure;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
