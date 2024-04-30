package Ue2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CardBoxTest {

    @Test
    void addPersonCard_shouldAddCard() throws CardBoxException {
        CardBox cardBox = CardBox.getInstance();
        PersonCard enduserCard = new EnduserCard(1, "John", "Doe", true);
        cardBox.addPersonCard(enduserCard);
        assertEquals(1, cardBox.size());
    }

    @Test
    void addPersonCard_duplicateId_shouldThrowException() {
        CardBox cardBox = CardBox.getInstance();
        PersonCard developerCard = new DeveloperCard(2, "Jane", "Doe", true);
        try {
            cardBox.addPersonCard(developerCard);
            cardBox.addPersonCard(developerCard); // Adding duplicate card
            fail("Expected CardBoxException to be thrown");
        } catch (CardBoxException e) {
            assertEquals("Das CardBox-Objekt mit der ID 2 ist bereits vorhanden", e.getMessage());
        }
    }

    @Test
    void deletePersonCard_shouldRemoveCard() throws CardBoxException {
        CardBox cardBox = CardBox.getInstance();
        PersonCard enduserCard = new EnduserCard(3, "John", "Doe", true);
        cardBox.addPersonCard(enduserCard);
        assertEquals(2, cardBox.size());
        cardBox.deletePersonCard(1);
        assertEquals(1, cardBox.size());
    }

    @Test
    void testSaveAndLoad() {
        CardBox cardBox = CardBox.getInstance();
        for (PersonCard card : cardBox.getCurrentList()) {
            cardBox.deletePersonCard(card.getId());
        }
        try {
            cardBox.addPersonCard(new DeveloperCard(1, "John", "Doe", true));
            cardBox.save();

            cardBox.deletePersonCard(1);
            assertEquals(0, cardBox.size());

            cardBox.load();
            List<PersonCard> loadedCards = cardBox.getCurrentList();
            assertEquals(1, loadedCards.size());
            assertEquals("Doe", loadedCards.get(0).getFirstName());
            assertEquals("John", loadedCards.get(0).getLastName());
            assertTrue(((DeveloperCard) loadedCards.get(0)).hasEnoughCoffee());
        } catch (CardboxStorageException | CardBoxException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}