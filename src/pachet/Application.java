package pachet;

public class Application {
	private ApplicationStatus status = ApplicationStatus.Pending;

	public void showApplication() {
		System.out.println("Status: " + status);
	}
}
