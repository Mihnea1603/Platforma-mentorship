package pachet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Mentor extends User {
	private ArrayList<MentorshipOffer> mentorshipOffers;
	private ArrayList<Appointment> appointments;

	public Mentor(String username, String password, String experience) {
		super(username, password, experience);
		mentorshipOffers = new ArrayList<MentorshipOffer>();
		appointments = new ArrayList<Appointment>();
	}

	public ArrayList<MentorshipOffer> getMentorshipOffers() {
		return mentorshipOffers;
	}

	public void createMentorshipOffer(Scanner sc) {
		System.out.print("Enter mentorship offer description: ");
		String description = sc.nextLine();
		System.out.print("Enter categories (comma-separated): ");
		String[] categories = sc.nextLine().split(",");
		MentorshipOffer offer = new MentorshipOffer(description, categories);
		mentorshipOffers.add(offer);
		offer.assignMentor(this);
		System.out.println("Mentorship offer created successfully!");
	}

	public void viewCreatedOffers() {
		if (mentorshipOffers.isEmpty()) {
			System.out.println("No mentorship offers created.");
			return;
		}
		System.out.println("\nYour mentorship offers:");
		for (int i = 0; i < mentorshipOffers.size(); i++) {
			System.out.println("\n" + i + ". Mentorship offer:");
			mentorshipOffers.get(i).showOffer("  ");
		}
	}

	public void checkApplications(Scanner sc) {
		boolean hasApplications = false;

		for (int i = 0; i < mentorshipOffers.size(); i++) {
			MentorshipOffer offer = mentorshipOffers.get(i);
			ArrayList<Application> applications = offer.getApplications();
			if (applications.isEmpty()) {
				continue;
			}
			hasApplications = true;

			System.out.println("\n" + i + ". Mentorship offer:");
			offer.showOffer("  ");
			System.out.println("\n  Applications for offer:");
			for (int j = 0; j < applications.size(); j++) {
				System.out.println("\n  " + j + ". Application:");
				applications.get(j).showApplication(this, "    ");
			}
		}

		if (!hasApplications) {
			System.out.println("No applications found for your offers.");
		} else {
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Confirm Applications");
			System.out.println("2. Create Appointments");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			int choice;
			while (true) {
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					confirmApplications(sc);
					return;
				case 2:
					createAppointment(sc);
					return;
				case 3:
					return;
				default:
					System.out.print("Invalid option! Please choose another option: ");
				}
			}
		}
	}

	private void confirmApplications(Scanner sc) {
		System.out.print("\nSelect offer index (0 to " + (mentorshipOffers.size() - 1) + "): ");
		int i;
		while (true) {
			i = sc.nextInt();
			sc.nextLine();

			if (i >= 0 && i < mentorshipOffers.size()) {
				if (!mentorshipOffers.get(i).getApplications().isEmpty()) {
					break;
				} else {
					System.out.print("No applications for this offer. Please select another offer: ");
				}
			} else {
				System.out.print("Invalid offer index! Please try again: ");
			}
		}

		ArrayList<Application> selectedOfferApplications = mentorshipOffers.get(i).getApplications();
		System.out.print("Select application index (0 to " + (selectedOfferApplications.size() - 1) + "): ");
		int j;
		while (true) {
			j = sc.nextInt();
			sc.nextLine();

			if (j >= 0 && j < selectedOfferApplications.size()) {
				break;
			} else {
				System.out.print("Invalid application index! Please try again: ");
			}
		}

		Application selectedApplication = selectedOfferApplications.get(j);
		System.out.print("Confirm this application? (y/n): ");
		String response = sc.nextLine();
		if (response.equalsIgnoreCase("y")) {
			selectedApplication.setStatus(ApplicationStatus.ACCEPTED);
			System.out.println("Application confirmed.");
		} else {
			selectedApplication.setStatus(ApplicationStatus.REJECTED);
			System.out.println("Application rejected.");
		}
	}

	private void createAppointment(Scanner sc) {
		System.out.print("\nSelect offer index (0 to " + (mentorshipOffers.size() - 1) + "): ");
		int i;
		while (true) {
			i = sc.nextInt();
			sc.nextLine();

			if (i >= 0 && i < mentorshipOffers.size()) {
				if (!mentorshipOffers.get(i).getApplications().isEmpty()) {
					break;
				} else {
					System.out.print("No applications for this offer. Please select another offer: ");
				}
			} else {
				System.out.print("Invalid offer index! Please try again: ");
			}
		}

		ArrayList<Application> selectedOfferApplications = mentorshipOffers.get(i).getApplications();
		System.out.print("Select application index (0 to " + (selectedOfferApplications.size() - 1) + "): ");
		int j;
		while (true) {
			j = sc.nextInt();
			sc.nextLine();

			if (j >= 0 && j < selectedOfferApplications.size()) {
				break;
			} else {
				System.out.print("Invalid application index! Please try again: ");
			}
		}

		Mentee selectedApplicationMentee = selectedOfferApplications.get(j).getMentee();
		System.out.print("Enter appointment type (Online/InPerson): ");
		AppointmentType type = AppointmentType.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Enter date (yyyy-MM-dd): ");
		String dateStr = sc.nextLine();
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr);
			Appointment appointment = new Appointment(type, date);
			appointments.add(appointment);
			selectedApplicationMentee.addAppointment(appointment);
			appointment.assignMentor(this);
			appointment.assignMentee(selectedApplicationMentee);
			System.out.println("Appointment created successfully!");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void checkAppointments(Scanner sc) {
		if (appointments.isEmpty()) {
			System.out.println("No appointments found.");
			return;
		}
		System.out.println("Your appointments:");
		for (int i = 0; i < appointments.size(); i++) {
			System.out.println(i + ". Appointment:");
			appointments.get(i).showAppointment(this);
		}

		System.out.print("Do you want to provide feedback for an appointment? (y/n): ");
		String response = sc.nextLine();
		if (response.equalsIgnoreCase("y")) {
			provideFeedback(sc);
		}
	}

	private void provideFeedback(Scanner sc) {
		System.out.print("Select appointment index to provide feedback (0 to " + (appointments.size() - 1) + "): ");
		int choice;
		while (true) {
			choice = sc.nextInt();
			sc.nextLine();
			if (choice >= 0 && choice < appointments.size()) {
				Appointment selectedAppointment = appointments.get(choice);
				System.out.print("Enter feedback content: ");
				String content = sc.nextLine();
				Feedback feedback = new Feedback(content);
				selectedAppointment.assignFeedback(feedback);
				System.out.println("Feedback submitted successfully!");
				break;
			} else {
				System.out.println("Invalid index! Please try again: ");
			}
		}
	}
}
