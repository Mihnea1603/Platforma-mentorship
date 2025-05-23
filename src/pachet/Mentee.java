package pachet;

import java.util.ArrayList;
import java.util.Scanner;

public class Mentee extends User {
	private ArrayList<Application> applications;
	private ArrayList<Appointment> appointments;

	public Mentee(String username, String password, String experience) {
		super(username, password, experience);
		applications = new ArrayList<Application>();
		appointments = new ArrayList<Appointment>();
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public void applyMentorship(Scanner sc, ArrayList<Mentor> mentors) {
		if (!searchMentor(mentors)) {
			return;
		}

		System.out.print("\nSelect mentor index (0 to " + (mentors.size() - 1) + "): ");
		int i;
		while (true) {
			i = sc.nextInt();
			sc.nextLine();

			if (i >= 0 && i < mentors.size()) {
				if (!mentors.get(i).getMentorshipOffers().isEmpty()) {
					break;
				} else {
					System.out.print("No offers from this mentor. Please select another mentor: ");
				}
			} else {
				System.out.print("Invalid mentor index! Please try again: ");
			}
		}

		ArrayList<MentorshipOffer> selectedMentorOffers = mentors.get(i).getMentorshipOffers();
		System.out.print("Select offer index (0 to " + (selectedMentorOffers.size() - 1) + "): ");
		int j;
		while (true) {
			j = sc.nextInt();
			sc.nextLine();

			if (j >= 0 && j < selectedMentorOffers.size()) {
				if (!mentors.get(i).getMentorshipOffers().isEmpty()) {
					break;
				} else {
					System.out.print("No offers from this mentor. Please select another mentor: ");
				}
			} else {
				System.out.print("Invalid offer index! Please try again: ");
			}
		}

		MentorshipOffer selectedOffer = selectedMentorOffers.get(j);
		Application application = new Application();
		applications.add(application);
		selectedOffer.addApplication(application);
		application.assignMentee(this);
		application.assignMentorshipOffer(selectedOffer);
	}

	public boolean searchMentor(ArrayList<Mentor> mentors) {
		if (mentors.isEmpty()) {
			System.out.println("No mentors found.");
			return false;
		}
		System.out.println("\nAvailable mentors and their offers:");
		for (int i = 0; i < mentors.size(); i++) {
			Mentor mentor = mentors.get(i);
			ArrayList<MentorshipOffer> mentorshipOffers = mentor.getMentorshipOffers();
			if (mentorshipOffers.isEmpty()) {
				continue;
			}

			System.out.println("\n" + i + ". Mentor:");
			mentor.viewProfile("  ");
			for (int j = 0; j < mentorshipOffers.size(); j++) {
				MentorshipOffer offer = mentorshipOffers.get(j);
				System.out.println("\n  " + j + ". Offer:");
				offer.showOffer("    ");
			}
		}
		return true;
	}

	public void viewApplications() {
		if (applications.isEmpty()) {
			System.out.println("No applications found.");
			return;
		}
		System.out.println("\nYour applications:");
		for (int i = 0; i < applications.size(); i++) {
			System.out.println("\n" + i + ". Application:");
			applications.get(i).showApplication(this, "  ");
		}
	}

	public void viewAppointmentsFeedback() {
		if (appointments.isEmpty()) {
			System.out.println("No appointments found.");
			return;
		}
		System.out.println("\nYour appointments:");
		for (int i = 0; i < appointments.size(); i++) {
			System.out.println("\n" + i + ". Appointment:");
			appointments.get(i).showAppointment(this);
		}
	}
}
