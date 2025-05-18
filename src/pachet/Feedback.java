package pachet;

public class Feedback {
	private String content;
	private Appointment appointment;

	public Feedback(String content) {
		this.content = content;
	}

	public void assignAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public void showFeedback() {
		System.out.println("Feedback: " + content);
	}
}
