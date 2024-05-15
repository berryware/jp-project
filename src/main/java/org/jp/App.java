package org.jp;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(101, 2));
        rooms.add(new Room(102, 1));
        rooms.add(new Room(103, 4));
        rooms.add(new Room(104, 3));
        rooms.add(new Room(105, 1));
        rooms.add(new Room(201, 1));
        rooms.add(new Room(202, 1));
        rooms.add(new Room(203, 1));
        rooms.add(new Room(204, 2));
        rooms.add(new Room(205, 2));
        Hotel LGAHotel = new Hotel(rooms);
        while (true) {
            System.out.println("Welcome to the Lumen Gentium Hotel! What is your name?");
            String input = reader.nextLine();
            Guest guest = new Guest(input);
            System.out.println("Thank you " + input + ". Would you like to make a reservation?");
            while (true) {
                input = reader.nextLine();
                if (input.equals("Yes")) {
                    System.out.println("Here are all the rooms in our hotel, which would you like?");
                    for (int i = 0; i < rooms.size(); i++) {
                        boolean available = LGAHotel.isRoomAvailable(rooms.get(i).roomNumber);
                        if (available == true) {
                            System.out.println("Room " + rooms.get(i).roomNumber + ", Fits " + rooms.get(i).capacity + ", Price Per Day " + rooms.get(i).pricePerDay);
                        }
                    }
                    while (true) {
                        input = reader.nextLine();
                        int roomNumber = Integer.valueOf(input);
                        boolean available = LGAHotel.isRoomAvailable(roomNumber);
                        if (available == false) {
                            System.out.println("Sorry, that room is unavailable. Please pick anonther room.");
                            continue;
                        } else {

                            Room room = LGAHotel.getRoom(roomNumber);
                            Reservation reservation = new Reservation(guest, room);
                            LGAHotel.addReservation(reservation);
                            System.out.println("Room " + roomNumber + " is all yours! We hope you enjoy your stay at the LGA Hotel.");
                            break;
                        }
                    }
                    break;

                } else if (input.equals("No")) {
                    System.out.println("Enjoy your day.");
                    break;
                } else {
                    System.out.println("Please answer Yes or No.");
                    continue;
                }

            }
        }
    }
}
