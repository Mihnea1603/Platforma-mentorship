package pachet;

public class Application {
	private ApplicationStatus status = ApplicationStatus.Pending;
	private Mentee mentee;
	private MentorshipOffer mentorshipOffer;

	public void assignMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public void assignMentorshipOffer(MentorshipOffer mentorshipOffer) {
		this.mentorshipOffer = mentorshipOffer;
	}

	public void showApplication() {
		System.out.println("Status: " + status);
	}
}
