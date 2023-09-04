package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate chackOut;
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate chackOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.chackOut = chackOut;
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

	public LocalDate getChackOut() {
		return chackOut;
	}

	public long duration() {
		return checkIn.until(chackOut, ChronoUnit.DAYS);
	}
	
	public void upDateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.chackOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", checkIn: "
				+ dtf.format(checkIn)
				+ ", chackOut: "
				+ dtf.format(chackOut)
				+ ", "
				+ duration()
				+ " nigths";
	}
	
}
