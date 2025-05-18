package pachet;

import java.util.Date;

public class Appointment {
	private AppointmentType type;
	private Date date;

	public Appointment(AppointmentType type, Date date) {
		this.type = type;
		this.date = date;
	}

	public void showAppointment() {
		System.out.println("Appointment type: " + type);
		System.out.println("Date: " + date);
	}
}
