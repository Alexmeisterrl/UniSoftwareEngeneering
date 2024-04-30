package Ue2;

class Client {
    public static void main(String[] args) throws CardBoxException {
        CardBox cardBox = CardBox.getInstance();
        cardBox.addPersonCard(new DeveloperCard(1, "John", "Doe", true));
        cardBox.addPersonCard(new EnduserCard(2, "Jane", "Doe", false));

        PersonCardView view = new PersonCardView();
        view.showContent(cardBox.getCurrentList());
    }
}
