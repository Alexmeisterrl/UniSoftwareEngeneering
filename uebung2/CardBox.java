package Ue2;

import java.util.ArrayList;
import java.util.List;

class CardBox {
    private List<PersonCard> cards;

    public CardBox() {
        cards = new ArrayList<>();
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

    public int size() {
        return cards.size();
    }
}
