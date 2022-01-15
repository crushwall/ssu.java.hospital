package com.hospital.service;

public interface Service<E> {
    public void add(E e);

    public E getById(int id);

    public Iterable<E> getAll();

    public void update(E e);

    public void remove(int id);
}
