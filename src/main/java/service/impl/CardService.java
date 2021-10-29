package service.impl;

import dao.CardRepository;
import model.PatientCard;
import org.springframework.beans.factory.annotation.Autowired;

public class CardService implements service.CardService {
    @Autowired
    private CardRepository repository;

    @Override
    public void add(PatientCard patientCard) {
     repository.add(patientCard);
    }

    @Override
    public PatientCard getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Iterable<PatientCard> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(PatientCard patientCard) {
        repository.update(patientCard);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
