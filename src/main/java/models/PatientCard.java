package models;

import java.util.HashMap;

public class PatientCard {
    private int id;
    private int clientId;
    private HashMap<Integer, CardRecord> records;

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

    public HashMap<Integer, CardRecord> getRecords() {
        return records;
    }

    public void setRecords(HashMap<Integer, CardRecord> records) {
        this.records = records;
    }
}
