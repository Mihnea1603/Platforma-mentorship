package pachet;

public class Application {
	private ApplicationStatus status = ApplicationStatus.PENDING;
	private Mentee mentee;
	private MentorshipOffer mentorshipOffer;

	public void assignMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public void assignMentorshipOffer(MentorshipOffer mentorshipOffer) {
		this.mentorshipOffer = mentorshipOffer;
	}

	public Mentee getMentee() {
		return mentee;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public void showApplication(User user, String indent) {
		if (user instanceof Mentee) {
			System.out.println("\n" + indent + "Mentor:");
			mentorshipOffer.getMentor().viewProfile(indent);
			mentorshipOffer.showOffer(indent);
		} else if (user instanceof Mentor) {
			System.out.println("\n" + indent + "Mentee:");
			mentee.viewProfile(indent);
		}
		System.out.println(indent + "Status: " + status);
	}
}
