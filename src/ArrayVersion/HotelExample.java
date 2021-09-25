package ArrayVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelExample {

    static Scanner input = new Scanner(System.in);
    static String firstNameForTheRoom;
    static String surnameForTheRoom;
    static int roomNumberForTheRooms = 1;
    static int creditCardNo;
    static int noOfGuest;
    static String[] hotel = new String[9];

    public static void main(String[] args) {


        initialise(hotel);

        while ( roomNumberForTheRooms < 9 )
        {
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

            String user = input.next();

            switch (user){

                case "A": {
                   addCustomer();
                    break;
                }

                case "V": {
                    viewRoom();

                    break;
                }

                case "E": {
                    emptyRoom();
                    break;
                }

                case "D": {
                   deleteCustomer();
                    break;
                }

                case "F": {
                    findCustomer(hotel);

                    break;
                }

                case "S": {
                    storeData(hotel);

                    break;
                }

                case "L": {
                    loadData(hotel);

                    break;
                }

                case "O": {
                    alphabeticalOrder(hotel);
                    break;
                }

                case "10": {
                    System.out.println("Thank you! Have a Nice Day!");
                    System.exit(0);

                    break;
                }
            }

        }
    }

    /**
     * delete the customer from room
     */
    private static void deleteCustomer() {
        System.out.print("Enter room number to delete the customer (1-8): " );
        roomNumberForTheRooms = input.nextInt();
        hotel[roomNumberForTheRooms] = "-" ;
        System.out.println("Customer Deleted!");
    }

    private static void emptyRoom() {
        System.out.println("Displaying Empty rooms... ");
        for (int x = 1; x < 9; x++ ){
            if(hotel[x] .equals("-")){
                System.out.println("Room " + x + " is Empty...");
            }
        }
    }

    /**
     * showing details of room
     */
    private static void viewRoom() {
        System.out.println("View All Rooms: ");
        for (int x = 1; x < 9; x++ ){
            if(hotel[x] != "-"){
                System.out.println("Room " + x + " occupied by " + hotel[x]);
            }else{
                System.out.println("Room " + x + " is Empty...");
            }
        }
    }

    /**
     * adding the customer
     */
    private static void addCustomer() {
        System.out.print("Enter room number (1-8) or 10 to exit the program: " );
        roomNumberForTheRooms = input.nextInt();
        System.out.print("Enter your First name: " ) ;
        firstNameForTheRoom = input.next().toUpperCase();
        System.out.print("Enter your Surname: " ) ;
        surnameForTheRoom = input.next().toUpperCase();

        System.out.println("Enter Your Credit Card Number: ");
        creditCardNo = input.nextInt();

        System.out.println("Enter the number of Guests: ");
        noOfGuest = input.nextInt();


        hotel[roomNumberForTheRooms] = "Customer Name: "+ firstNameForTheRoom +" "+ surnameForTheRoom +" | "+"Credit Card Number: "+creditCardNo+" | "+"Number Of Guests in room: "+noOfGuest;

    }

    /**
     * setting the names in alphabetical order
     * @param hotelAO
     */
    private static void alphabeticalOrder(String hotelAO[]) {
        List<String> orderRooms = new ArrayList<>();
        String temp;
        for (int i = 0; i < 9; i++) {
            for (int x = i + 1; x < 9; x++) {
                if (hotelAO[i] != null) {
                    if (hotelAO[i].compareTo(hotelAO[x]) > 0) {
                        temp = hotelAO[i];
                        hotelAO[i] = hotelAO[x];
                        hotelAO[x] = temp;
                    }
                }
            }

        }
        System.out.println("Names in Alphabetical Order: ");
        for (int i = 1; i < 9 - 1; i++) {
            if (hotelAO[i] != null) {
                if (!hotelAO[i].equals("-")) {
                    orderRooms.add(hotelAO[i]);
                }


            }
        }
        orderRooms.add(hotelAO[(9) - 1]);
        orderRooms.stream().forEach((name) -> {
                    System.out.println(name);
                }
        );
    }

    private static void initialise( String hotelFind[] ) {
        for(int x = 1 ; x < 9 ; x++){
            hotelFind[x] = "-";
        }
    }

    private static void findCustomer(String hotelFind[]) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter your name : " ) ;
            String customerName = input.next().toUpperCase();


            for (int x = 1; x < 9; x++ ) {
                if (hotelFind[x] != null)
                    System.out.println("Room " + x + " is occupied by "+hotelFind[x]);
            }
        }
        catch (Exception excep)
        {
            excep.printStackTrace();
        }
    }

    public static void storeData(String storeData[])
    {
        try {
            PrintWriter print = new PrintWriter("hotelRecep.txt");  //file path
            if(storeData.length <= 0){
                System.out.println("No Records!");

            }
            for (int i=1; i<storeData.length ; i++){
                print.println(storeData[i]);  //storing the data to the txt file }
            }
            print.close();
        }
        catch (Exception excep) {
            excep.printStackTrace();
            System.out.println("File Not Found!");
        }
        System.out.println("Data Saved!");

    }

    private static void loadData(String[] loadData) {
        System.out.print("Load data back.");
        System.out.println();

        File hotelLoadFile = new File("hotelRecep.txt");
        BufferedReader bufferReaderForTheFile = null;
        FileReader fileReaderForTheFile = null;

        try{
            fileReaderForTheFile = new FileReader(hotelLoadFile);
            bufferReaderForTheFile = new BufferedReader(fileReaderForTheFile);

            String currentLine;

            bufferReaderForTheFile = new BufferedReader(new FileReader(hotelLoadFile));

            while ((currentLine = bufferReaderForTheFile.readLine()) != null) {
                System.out.println(currentLine);
            }
        }catch (IOException excep) {

            excep.printStackTrace();

        } finally {

            try {

                if (bufferReaderForTheFile != null)
                    bufferReaderForTheFile.close();

                if (fileReaderForTheFile != null)
                    fileReaderForTheFile.close();

            } catch (IOException exceptionForTheFile) {

                exceptionForTheFile.printStackTrace();

            }
        }
    }
}
