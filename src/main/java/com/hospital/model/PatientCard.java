package com.hospital.model;

import java.util.ArrayList;

public class PatientCard {
    private int id;
    private int clientId;
    private ArrayList<Appointment> records;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public ArrayList<Appointment> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Appointment> records) {
        this.records = records;
    }
}
