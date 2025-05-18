package pachet;

import java.util.ArrayList;

public class Mentor extends User {
	private ArrayList<MentorshipOffer> mentorshipOffers;
	private ArrayList<Appointment> appointments;

	public Mentor(String username, String password, String experience) {
		super(username, password, experience);
		mentorshipOffers = new ArrayList<MentorshipOffer>();
		appointments = new ArrayList<Appointment>();
	}

	public void addMentorshipOffer(String description, String[] categories) {
		mentorshipOffers.add(new MentorshipOffer(description, categories));
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public void createMentorshipOffer() {

	}

	public void viewCreatedOffers() {

	}

	public void checkApplications() {

	}

	public void confirmApplications() {

	}

	public void createAppointment() {

	}

	public void checkAppointments() {

	}

	public void provideFeedback() {

	}
}
