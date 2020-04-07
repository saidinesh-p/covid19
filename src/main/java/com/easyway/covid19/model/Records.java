package com.easyway.covid19.model;

public class Records {

    private Integer id;
    private String state;
    private Integer total;
    private Integer active;
    private Integer recovered;
    private Integer deaths;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Records(){

    }



    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", total='" + total + '\'' +
                ", active='" + active + '\'' +
                ", recovered='" + recovered + '\'' +
                ", deaths='" + deaths + '\'' +
                '}';
    }
}
