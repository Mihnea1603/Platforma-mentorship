package pachet;

import java.util.Date;

public class Appointment {
	private AppointmentType type;
	private Date date;

	private Mentee mentee;
	private Mentor mentor;
	private Feedback feedback;

	public Appointment(AppointmentType type, Date date) {
		this.type = type;
		this.date = date;
	}

	public void assignMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public void assignMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public void assignFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public void showAppointment() {
		System.out.println("Appointment type: " + type);
		System.out.println("Date: " + date);
	}
}
