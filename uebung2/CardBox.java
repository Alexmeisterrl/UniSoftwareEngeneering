package Ue2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class CardBox {
    private List<PersonCard> cards;
    private static CardBox instance;

    private CardBox() {
        cards = new ArrayList<>();
    }

    public static CardBox getInstance() {
        if (instance == null) {
            instance = new CardBox();
        }
        return instance;
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        for (PersonCard card : cards) {
            if (card.getId() == personCard.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + personCard.getId() + " ist bereits vorhanden");
            }
        }
        cards.add(personCard);
    }

    public String deletePersonCard(int id) {
        for (PersonCard card : cards) {
            if (card.getId() == id) {
                cards.remove(card);
                return "Objekt mit ID " + id + " wurde entfernt.";
            }
        }
        return "Objekt mit ID " + id + " wurde nicht gefunden.";
    }

    public void showContent() {
        for (PersonCard card : cards) {
            String output = "ID = " + card.getId() + ", Vorname = " + card.getFirstName() + ", Nachname = " + card.getLastName();
            if (card instanceof DeveloperCard) {
                output += ", hasEnoughCoffee = " + ((DeveloperCard) card).hasEnoughCoffee();
            } else if (card instanceof EnduserCard) {
                output += ", isHungry = " + ((EnduserCard) card).isHungry();
            }
            System.out.println(output);
        }
    }

    public void save() throws CardboxStorageException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cardbox.dat"))) {
            oos.writeObject(cards);
        } catch (IOException e) {
            throw new CardboxStorageException("Fehler beim Speichern der CardBox: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public void load() throws CardboxStorageException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardbox.dat"))) {
            cards = (List<PersonCard>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox: " + e.getMessage(), e);
        }
    }

    public List<PersonCard> getCurrentList() {
        return new ArrayList<>(cards);
    }

    public int size() {
        return cards.size();
    }


}
