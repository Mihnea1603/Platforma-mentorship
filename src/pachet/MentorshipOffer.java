package pachet;

import java.util.ArrayList;

public class MentorshipOffer {
	private String description;
	private String[] categories;
	private Mentor mentor;
	private ArrayList<Application> applications;

	public MentorshipOffer(String description, String[] categories) {
		this.description = description;
		this.categories = categories;
		applications = new ArrayList<Application>();
	}

	public void assignMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public void addApplication(Application application) {
		applications.add(application);
	}

	public Mentor getMentor() {
		return mentor;
	}

	public ArrayList<Application> getApplications() {
		return applications;
	}

	public void showOffer(String indent) {
		System.out.println("\n" + indent + "Mentorship offer description: " + description);
		System.out.print(indent + "Categories: ");
		for (int i = 0; i < categories.length; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(categories[i]);
		}
		System.out.println();
	}
}
