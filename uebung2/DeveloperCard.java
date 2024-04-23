package Ue2;

public class DeveloperCard implements PersonCard{

    private String nachname;
    private String vorname;
    private int id;

    private boolean hasEnoughCoffee;

    DeveloperCard(int id, String nachname, String vorname, boolean hasEnoughCoffee){
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.hasEnoughCoffee = hasEnoughCoffee;
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

    public boolean hasEnoughCoffee() {
        return hasEnoughCoffee;
    }
    
}
