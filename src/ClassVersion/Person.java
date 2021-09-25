package ClassVersion;

public class Person extends Hotel{
    private String firstName;
    private String lastName;
    private int creditCardNum;
    private int numberOfGuest;

    //Declaring Constructor
    @Override
    public String toString() {
        String personDetails = "Name : "+firstName+" "+ lastName +" | Credit Card Number: "+creditCardNum + " | Number of Guest in the room: "+numberOfGuest;
        return  personDetails;
    }

    public Person(String firstName, String lastName, int creditCardNum, int numberOfGuest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNum = creditCardNum;
        this.numberOfGuest = numberOfGuest;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }


    public void setCreditCardNum(int creditCardNum) { this.creditCardNum = creditCardNum;}
    public int getCreditCardNum() { return creditCardNum;}

    public void setnumberOfGuest(int numberOfGuest) {this.numberOfGuest = numberOfGuest;}
    public  int getnumberOfGuest(){return numberOfGuest;}

}