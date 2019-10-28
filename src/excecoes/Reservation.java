package excecoes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
	
	private  Integer roomNumber;
	private  Date checkin;
	private  Date checkout;
	
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long duration() {
		
		long time = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS); // converte millis em dias  
	}
	
	public void updateDates( Date checkin, Date checkout) throws DomainException {
		
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
		if(!checkin.after(new Date())|| !checkout.after(new Date())) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		
		this.checkin = checkin;
		this.checkout= checkout;
		
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ dateFormat.format(checkin)
			+ ", check-out: "
			+ dateFormat.format(checkout)
			+ ", "
			+ duration()
			+ " nights";
	}
	
	// Getters and Setters 
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	

	
	
	
}
