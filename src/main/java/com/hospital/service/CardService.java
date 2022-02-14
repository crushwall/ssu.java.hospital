package com.hospital.service;

import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;

public interface CardService extends Service<PatientCard>{
    public PatientCard getByClient(Client client);
}
