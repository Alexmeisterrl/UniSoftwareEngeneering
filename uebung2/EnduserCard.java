package Ue2;

public class EnduserCard implements PersonCard{

    private String nachname;
    private String vorname;
    private int id;

    private boolean isHungry;

    EnduserCard(int id, String nachname, String vorname, boolean isHungry){
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.isHungry = isHungry;

    }

    @Override
    public String getFirstName() {
        return this.vorname;
    }

    @Override
    public String getLastName() {
        return this.nachname;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public boolean isHungry() {
        return isHungry;
    }
    
}
