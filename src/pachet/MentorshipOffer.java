package pachet;

import java.util.ArrayList;

public class MentorshipOffer {

	static final int NR_MAX_CATEGORIES = 10;
	private String description;
	private String[] categories;
	private int nrCategories = 0;
	private Mentor mentor;
	private ArrayList<Application> applications;

	public MentorshipOffer(String description, String[] categories) {
		this.description = description;
		this.categories = categories;
		this.nrCategories = categories.length;
		applications = new ArrayList<Application>();
	}

	public void assignMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public void addApplication(Application application) {
		applications.add(application);
	}

	public void addCategory(String category) {
		categories[nrCategories] = category;
		nrCategories++;
	}

	public void showOffer() {
		System.out.println("Mentorship offer: " + description);
		System.out.println("Categories: ");
		for (int i = 0; i < nrCategories; i++) {
			System.out.print(categories[i] + ", ");
		}
	}
}
