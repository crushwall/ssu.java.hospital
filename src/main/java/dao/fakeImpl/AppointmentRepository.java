package dao.fakeImpl;

import dao.Repository;
import model.Appointment;

import java.util.ArrayList;

public class AppointmentRepository implements dao.AppointmentRepository {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    @Override
    public void add(Appointment appointment) {
        int id = appointments
                .stream()
                .mapToInt(Appointment::getId)
                .max()
                .orElse(0);

        appointment.setId(++id);
        appointments.add(appointment);
    }

    @Override
    public Appointment getById(int id) {
        return appointments
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return appointments;
    }

    @Override
    public void update(Appointment appointment) {
        appointments.remove(appointment.getId());
        appointments.add(appointment);
    }

    @Override
    public void remove(int id) {
        appointments.remove(id);
    }
}
