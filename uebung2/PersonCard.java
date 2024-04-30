package Ue2;

import java.io.Serializable;

public interface PersonCard extends Serializable{
    public String getFirstName();
    public String getLastName();
    
    

    // Die ID dient als Primärschlüssel zur Unterscheidung alle PersonCard-Objekte.
    // Die ID darf nicht innerhalb der CardBox-Klasse gesetzt werden.
    public int getId();
}
