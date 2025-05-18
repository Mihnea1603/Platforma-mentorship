package pachet;

import java.util.ArrayList;

public class Mentee extends User {
	private ArrayList<Application> applications;
	private ArrayList<Appointment> appointments;

	public Mentee(String username, String password, String experience) {
		super(username, password, experience);
		applications = new ArrayList<Application>();
		appointments = new ArrayList<Appointment>();
	}

	public void addApplication(Application application) {
		applications.add(application);
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public void applyMentorship() {

	}

	public void searchMentor() {

	}

	public void viewApplications() {

	}

	public void checkAppointments() {

	}

	public void viewFeedback() {

	}
}
