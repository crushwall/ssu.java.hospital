package service.impl;

import dao.AppointmentRepository;
import model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentService implements service.AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    @Override
    public void add(Appointment appointment) {
        repository.add(appointment);
    }

    @Override
    public Appointment getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Appointment appointment) {
        repository.update(appointment);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
