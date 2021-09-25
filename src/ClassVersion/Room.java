package ClassVersion;

/**
 *
 * This class represent the Room
 */
public class Room {
    Person numberOfCustomers;
    int numberOfTheRoom;

    /**
     * Sets the customer
     *
     * @param numberOfCustomers
     */
    public void setCustomer(Person numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;

    }

    /**
     * get the customer as String type
     * @return
     */
    public Person getCustomer() {
        return this.numberOfCustomers;
    }

    /**
     * set the room number
     * @param numberOfRoom
     */
    public void setRoom(int numberOfRoom) {

        this.numberOfTheRoom = numberOfRoom;
    }

    /**
     * numberOfRoom into int type
     * @return
     */
    public int getRoom() {
        return this.numberOfTheRoom;

    }


}
