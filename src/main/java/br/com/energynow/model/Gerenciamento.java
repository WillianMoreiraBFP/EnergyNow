package br.com.energynow.model;

import java.util.Date;

public class Gerenciamento {
    private int id;
    private Date data;
    private int kWh;
    private double precokWh;

    public Gerenciamento() {
    }

    public Gerenciamento(int id, Date data, int kWh, double precokWh) {
        this.id = id;
        this.data = data;
        this.kWh = kWh;
        this.precokWh = precokWh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getkWh() {
        return kWh;
    }

    public void setkWh(int kWh) {
        this.kWh = kWh;
    }

    public double getPrecokWh() {
        return precokWh;
    }

    public void setPrecokWh(double precokWh) {
        this.precokWh = precokWh;
    }
}
