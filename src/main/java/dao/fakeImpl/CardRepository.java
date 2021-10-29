package dao.fakeImpl;

import model.Client;
import model.PatientCard;

import java.util.ArrayList;

public class CardRepository implements dao.CardRepository {
    private static ArrayList<PatientCard> cards = new ArrayList<>();

    @Override
    public void add(PatientCard patientCard) {
        int id = cards
                .stream()
                .mapToInt(PatientCard::getId)
                .max()
                .orElse(0);

        patientCard.setId(++id);
        cards.add(patientCard);
    }

    @Override
    public PatientCard getById(int id) {
        return cards
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterable<PatientCard> getAll() {
        return cards;
    }

    @Override
    public void update(PatientCard patientCard) {
        cards.remove(patientCard.getId());
        cards.add(patientCard);
    }

    @Override
    public void remove(int id) {
        cards.remove(id);
    }
}
