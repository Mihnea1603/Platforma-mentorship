package pachet;

public class User {
	private String username, password, experience;

	public User(String username, String password, String experience) {
		this.username = username;
		this.password = password;
		this.experience = experience;
	}

	public void viewProfile() {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Experience: " + experience);
	}
}
