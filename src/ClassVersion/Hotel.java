package ClassVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hotel {

    static Room[] roomArray = new Room[9];//creating the room array object
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){


        String customerName = "None"; //set the customer as null
        String optionMenu = null;
        int roomNumberForTheRooms = 1;

        initialise();

        while(roomNumberForTheRooms<9) {

            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("       Welcome to hotel Sunny");
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println("A: Add customer to a room");
            System.out.println("V: View all rooms");
            System.out.println("E: Display empty rooms");
            System.out.println("D: Delete customer from room");
            System.out.println("F: Find room from customer name");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: View guests Ordered alphabetically by name");
            System.out.println("10: Exit the program");
            System.out.println();
            System.out.print("Enter your Selection: ");


            optionMenu = input.nextLine().toUpperCase();
            System.out.println();

            switch (optionMenu) {
                case "A": {
                    addCustomer(roomArray);
                    break;
                }

                case "V": {
                    viewRoom(roomNumberForTheRooms);
                    break;
                }

                case "E": {
                    emptyRooms(roomArray,customerName,roomNumberForTheRooms);
                    break;
                }
                case "D": {
                    deleteCustomer(roomArray,roomNumberForTheRooms,input);
                    break;
                }
                case "F": {
                    findCustomer(roomArray,input,customerName);
                    break;
                }
                case "S": {
                    storeData(roomArray);
                    break;
                }
                case "L": {
                    loadData(roomArray);
                    break;
                }
                case "O": {
//                    alpherbetI(roomArray);

                    break;
                }
                case "10": {
                    System.out.println("Thank you! Have a Nice Day!");
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }
            }
        }

    }

//    public static void alpherbetI(Room[] room) {
//        Room temp;
//        for (int i = 1; i < roomArray.length; i++) {
//            for (int j = i + 1; j < roomArray.length; j++) {
//                if (roomArray[i] != null) {
//
//                    // to compare one string with other strings
//                    if (roomArray[i].compareTo(roomArray[j]) > 1) {
//                        // swapping
//                        temp = roomArray[i];
//                        roomArray[i] = roomArray[j];
//                        roomArray[j] = temp;
//                    }
//                }
//            }
//        }
//
//        // print output array
//        System.out.println(
//                "The names in alphabetical order are: ");
//        for (int i = 1; i < roomArray.length; i++) {
//            System.out.println(roomArray[i]);
//        }
//    }



    private static void initialise(){
        for (int i = 1; i < roomArray.length; i++) {
            roomArray[i] = new Room();
            roomArray[i].setRoom(i);
        }
    }

    /**
     * adding the customer
     * @param nameForTheRoom
     */

    private static void addCustomer(Room nameForTheRoom[]){
        System.out.println("Enter a Room Number between (1 - 8): ");
        int roomNumberForTheRoom = input.nextInt();
        if(roomNumberForTheRoom <9 && roomNumberForTheRoom >= 1){

            System.out.println("Enter the first Name for room Number "+roomNumberForTheRoom+": ");
            String firstName = input.next().toUpperCase();

            System.out.println("Enter the last Name for room Number "+roomNumberForTheRoom+": ");
            String lastName = input.next().toUpperCase();

            System.out.println("Enter the Credit Card Number: ");
            int creditCardNum = input.nextInt();

            System.out.println("Enter the number of Guests in the room: ");
            int numberOfGuest = input.nextInt();

            Person person = new Person(firstName,lastName,creditCardNum, numberOfGuest);

            if (nameForTheRoom[roomNumberForTheRoom].getCustomer() == null) {
                nameForTheRoom[roomNumberForTheRoom].setCustomer(person);

                System.out.println("Added Customer " + person.toString() + " to Room number " + roomNumberForTheRoom);

            }else{
                System.out.println("Invalid Name. Please enter a valid name!");
            }
        }else{
            System.out.println("Invalid Room Number. Enter a valid Room Number between 1 to 8");
        }
    }

    /**
     * showing details of room
     * @param numberOfTheRoom
     */
    public static void viewRoom(int numberOfTheRoom){
        for(int i = 1; i< roomArray.length; i++){
            if(roomArray[i].getRoom()!=0){
                System.out.println("Room Number " + roomArray[i].getRoom() + " occupied by " + roomArray[i].getCustomer());
            }else{
                System.out.println("Room Number " + roomArray[i].getRoom() + " is Empty...");
            }
        }
    }

    /**
     * delete the customer from room
     * @param deleteCustomer
     * @param roomNumberForTheRoom
     * @param input
     */
    public static void deleteCustomer(Room deleteCustomer[], int roomNumberForTheRoom, Scanner input){
        System.out.println("Enter the room number to delete customer: ");
        roomNumberForTheRoom = input.nextInt();
        for(int i=1; i<deleteCustomer.length;i++){
            if(deleteCustomer[i].getRoom() == roomNumberForTheRoom){
                Person person = null;
                deleteCustomer[roomNumberForTheRoom].setCustomer(person);
                System.out.println("Room number "+roomNumberForTheRoom+ " customer deleted.");
            }
        }
    }

    /**
     * showing empty rooms
     * @param emptyRooms
     * @param customerName
     * @param roomNo
     */
    public static void emptyRooms(Room emptyRooms[], String customerName, int roomNo){
        for(int i=1;i<9;i++){
            if (emptyRooms[i].getRoom() == i){
                System.out.println("Room Number " + i + " is Empty...");
            }

        }
    }

    /**
     * finding the customer
     * @param roomFind
     * @param input
     * @param customerName
     */
    public static void findCustomer(Room roomFind[], Scanner input, String customerName){
        System.out.println("Enter the name of the customerName :");
        customerName = input.next();
        for(int i=1;i<roomFind.length;i++){
            if(roomFind[i].getCustomer() !=null){
                System.out.println("Room " + i + " is occupied by "+roomFind[i].getCustomer());
            }

        }
    }

    /**
     * Saving the entered data to a text file
     * @param storeData
     */
    public static void storeData(Room storeData[]){
        try {
            // getting the Hotel text file
            File hotelSaveFile = new File("HotelSystemSaveFile.txt");
            PrintWriter printWriter = new PrintWriter(hotelSaveFile);
            // printing all the array element text file
            for (int j = 1; j < storeData.length; j++) {
                if (storeData[j].getCustomer() != null) {
                    // printing the array to text file
                    printWriter.println(storeData[j].getCustomer());
                } else {
                    printWriter.println(storeData[j].getCustomer());
                }
            }
            System.out.println("Succesfully added");
            printWriter.close();
        }
        catch (IOException excep) {
            System.out.println("Check your file.");
        }
    }

    /**
     * loading the saved file
     * @param loadData
     */

    public static void loadData(Room loadData[]){
        System.out.print("Load the data back.");
        System.out.println();

        File hotelLoadFile = new File("HotelSystemSaveFile.txt");
        BufferedReader bufferReaderForTxtFile = null;
        FileReader fileReaderForTxtFile = null;

        try{
            fileReaderForTxtFile = new FileReader(hotelLoadFile);
            bufferReaderForTxtFile = new BufferedReader(fileReaderForTxtFile);

            String currentLine;

            bufferReaderForTxtFile = new BufferedReader(new FileReader(hotelLoadFile));

            while ((currentLine = bufferReaderForTxtFile.readLine()) != null) {
                System.out.println(currentLine);
            }
        }catch (IOException excep) {

            excep.printStackTrace();

        } finally {

            try {

                if (bufferReaderForTxtFile != null)
                    bufferReaderForTxtFile.close();

                if (fileReaderForTxtFile != null)
                    fileReaderForTxtFile.close();

            } catch (IOException exceptionForTheFile) {

                exceptionForTheFile.printStackTrace();

            }

        }
        System.out.println();
        System.out.println("Load success");

    }



}