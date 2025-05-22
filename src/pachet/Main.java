package pachet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static User currentUser = null;
	private static ArrayList<Mentee> mentees = new ArrayList<>();
	private static ArrayList<Mentor> mentors = new ArrayList<>();

	public static void main(String[] args) {
		DataInitializer.createData(mentees, mentors);

		while (true) {
			System.out.println("\n----------------");
			System.out.println("Mentorship Platform:");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid option!");
				continue;
			}

			if (currentUser != null) {
				if (currentUser instanceof Mentee) {
					menteeMenu();
				} else if (currentUser instanceof Mentor) {
					mentorMenu();
				}
			}
		}
	}

	private static void login() {
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();

		for (Mentor mentor : mentors) {
			if (mentor.getUsername().equals(username) && mentor.checkPassword(password)) {
				System.out.println("Login successful as Mentor!");
				currentUser = mentor;
				return;
			}
		}

		for (Mentee mentee : mentees) {
			if (mentee.getUsername().equals(username) && mentee.checkPassword(password)) {
				System.out.println("Login successful as Mentee!");
				currentUser = mentee;
				return;
			}
		}

		System.out.println("Invalid credentials!");
	}

	private static void register() {
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		System.out.print("Enter experience: ");
		String experience = sc.nextLine();
		System.out.print("Choose role (Mentee/Mentor): ");
		String role = sc.nextLine();

		for (Mentee mentee : mentees) {
			if (mentee.getUsername().equals(username)) {
				System.out.println("Username already exists!");
				return;
			}
		}

		for (Mentor mentor : mentors) {
			if (mentor.getUsername().equals(username)) {
				System.out.println("Username already exists!");
				return;
			}
		}

		while (true) {
			if (role.equalsIgnoreCase("mentee")) {
				Mentee mentee = new Mentee(username, password, experience);
				mentees.add(mentee);
				System.out.println("Registration successful for Mentee!");
				currentUser = mentee;
				return;
			} else if (role.equalsIgnoreCase("mentor")) {
				Mentor mentor = new Mentor(username, password, experience);
				mentors.add(mentor);
				System.out.println("Registration successful for Mentor!");
				currentUser = mentor;
				return;
			} else {
				System.out.print("Invalid role! Please try again (Mentee/Mentor): ");
				role = sc.nextLine();
			}
		}
	}

	private static void menteeMenu() {
		Mentee mentee = (Mentee) currentUser;

		while (true) {
			System.out.println("\n----------------");
			System.out.println("Mentee Menu:");
			System.out.println("1. Visualize Profile");
			System.out.println("2. Apply Mentorship");
			System.out.println("3. View Applications");
			System.out.println("4. Check Appointments");
			System.out.println("5. Logout");
			System.out.print("Choose an option: ");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println();
				mentee.viewProfile("");
				break;
			case 2:
				mentee.applyMentorship(sc, mentors);
				break;
			case 3:
				mentee.viewApplications();
				break;
			case 4:
				mentee.viewAppointmentsFeedback();
				break;
			case 5:
				currentUser = null;
				return;
			default:
				System.out.println("Invalid option!");
			}
		}
	}

	private static void mentorMenu() {
		Mentor mentor = (Mentor) currentUser;

		while (true) {
			System.out.println("\n----------------");
			System.out.println("Mentor Menu:");
			System.out.println("1. Visualize Profile");
			System.out.println("2. Create Mentorship Offer");
			System.out.println("3. View Created Offers");
			System.out.println("4. Check Applications");
			System.out.println("5. Check Appointments");
			System.out.println("6. Logout");
			System.out.print("Choose an option: ");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println();
				mentor.viewProfile("");
				break;
			case 2:
				mentor.createMentorshipOffer(sc);
				break;
			case 3:
				mentor.viewCreatedOffers();
				break;
			case 4:
				mentor.checkApplications(sc);
				break;
			case 5:
				mentor.checkAppointments(sc);
				break;
			case 6:
				currentUser = null;
				return;
			default:
				System.out.println("Invalid option!");
			}
		}
	}
}
