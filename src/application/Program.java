package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/dd/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
		System.out.print("Check-out date (dd/dd/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), dtf);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to uodate the reservation:");
			System.out.print("Check-in date (dd/dd/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Check-out date (dd/dd/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), dtf);
			
			if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} else if(!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: check-out date must be after check-in date.");
			} else {
				reservation.upDateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		sc.close();
	}

}
