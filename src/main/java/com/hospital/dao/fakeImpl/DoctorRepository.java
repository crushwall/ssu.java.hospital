package com.hospital.dao.fakeImpl;

import com.hospital.model.Doctor;

import java.util.ArrayList;

public class DoctorRepository implements com.hospital.dao.DoctorRepository {
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    @Override
    public void add(Doctor doctor) {
        int id = doctors
                .stream()
                .mapToInt(Doctor::getId)
                .max()
                .orElse(0);

        doctor.setId(++id);
        doctors.add(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return doctors
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterable<Doctor> getAll() {
        return doctors;
    }

    @Override
    public void update(Doctor doctor) {
        doctors.removeIf(d -> d.getId() == doctor.getId());
        doctors.add(doctor);
    }

    @Override
    public void remove(int id) {
        doctors.removeIf(d -> d.getId() == id);
    }
}
