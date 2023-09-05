package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/dd/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Check-out date (dd/dd/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), dtf);
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to uodate the reservation:");
			System.out.print("Check-in date (dd/dd/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Check-out date (dd/dd/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), dtf);
			
			reservation.upDateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		sc.close();
	}

}
