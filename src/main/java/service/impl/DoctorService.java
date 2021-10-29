package service.impl;

import dao.DoctorRepository;
import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorService implements service.DoctorService {
    @Autowired
    private DoctorRepository repository;

    @Override
    public void add(Doctor doctor) {
        repository.add(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Iterable<Doctor> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Doctor doctor) {
        repository.update(doctor);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
