package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainExceptions;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		if(checkOut.isBefore(checkIn)) {
			throw new DomainExceptions("Error in reservation: check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getcheckOut() {
		return checkOut;
	}

	public long duration() {
		return checkIn.until(checkOut, ChronoUnit.DAYS);
	}
	
	public void upDateDates(LocalDate checkIn, LocalDate checkOut) {
		if(checkOut.isBefore(checkIn)) {
			throw new DomainExceptions("Error in reservation: check-out date must be after check-in date.");
		}
		if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
			throw new DomainExceptions("Error in reservation: Reservation dates for update must be future dates.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", checkIn: "
				+ dtf.format(checkIn)
				+ ", checkOut: "
				+ dtf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths.";
	}
	
}
