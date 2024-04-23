package Ue2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    @Test
    void addPersonCard_shouldAddCard() throws CardBoxException {
        CardBox cardBox = new CardBox();
        PersonCard enduserCard = new EnduserCard(1, "John", "Doe", true);
        cardBox.addPersonCard(enduserCard);
        assertEquals(1, cardBox.size());
    }

    @Test
    void addPersonCard_duplicateId_shouldThrowException() {
        CardBox cardBox = new CardBox();
        PersonCard developerCard = new DeveloperCard(1, "Jane", "Doe", true);
        try {
            cardBox.addPersonCard(developerCard);
            cardBox.addPersonCard(developerCard); // Adding duplicate card
            fail("Expected CardBoxException to be thrown");
        } catch (CardBoxException e) {
            assertEquals("Das CardBox-Objekt mit der ID 1 ist bereits vorhanden", e.getMessage());
        }
    }

    @Test
    void deletePersonCard_shouldRemoveCard() throws CardBoxException {
        CardBox cardBox = new CardBox();
        PersonCard enduserCard = new EnduserCard(1, "John", "Doe", true);
        cardBox.addPersonCard(enduserCard);
        assertEquals(1, cardBox.size());
        cardBox.deletePersonCard(1);
        assertEquals(0, cardBox.size());
    }
}