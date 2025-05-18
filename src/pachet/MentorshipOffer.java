package pachet;

public class MentorshipOffer {

	static final int NR_MAX_CATEGORIES = 10;
	private String description;
	private String[] categories;
	private int nrCategories = 0;

	public MentorshipOffer(String description) {
		this.description = description;
		categories = new String[NR_MAX_CATEGORIES];
	}

	public void showOffer() {
		System.out.println("Mentorship offer: " + description);
		System.out.println("Categories: ");
		for (int i = 0; i < nrCategories; i++) {
			System.out.print(categories[i] + ", ");
		}
	}
}
