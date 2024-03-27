package com.cinema.backend.entity;

import lombok.Getter;

import java.util.Arrays;

public class Room {
    public static void main(String[] args) {
        Room room = new Room(1);
        assignSeats(room.getSeats());
        for (int i = 0; i < room.getSeats().length; i++) {
            System.out.println(Arrays.toString(room.getSeats()[i]));
        }
    }
    private int id;
    @Getter
    private int[][] seats;

    public Room(int id) {
        this.id = id;
        this.seats = new int[5][11];
    }
    static int availableSeats(int[][] seats){
        int sum = 0;
        for (int i = 0; i < seats[0].length; i++) {
            for (int[] seat : seats) {
                sum += seat[i];
            }
        }
        return sum;
    }
    static int[][] suggestSeats(int[][] seats, int amount){
        if(availableSeats(seats)>amount) return null;
        return new int[1][1];
    }
    static void assignSeats(int[][] seats){
        int rows = seats.length;
        int seatsInRow = seats[0].length;
        for (int i = 0; i < 0.4*rows*seatsInRow; i++) {
            int selectedRow = (int)(Math.random() * (rows));
            int selectedSeatInRow = (int)(Math.random() * (seatsInRow));
            seats[selectedRow][selectedSeatInRow] = 1;
        }
    }
}
