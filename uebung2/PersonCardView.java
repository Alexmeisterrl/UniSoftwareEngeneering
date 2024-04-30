package Ue2;

import java.util.List;

class PersonCardView {
    public void showContent(List<PersonCard> list) {
        for (PersonCard card : list) {
            String output = "ID = " + card.getId() + ", Vorname = " + card.getFirstName() + ", Nachname = " + card.getLastName();
            if (card instanceof DeveloperCard) {
                output += ", hasEnoughCoffee = " + ((DeveloperCard) card).hasEnoughCoffee();
            } else if (card instanceof EnduserCard) {
                output += ", isHungry = " + ((EnduserCard) card).isHungry();
            }
            System.out.println(output);
        }
    }
}