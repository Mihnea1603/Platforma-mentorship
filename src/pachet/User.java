package pachet;

public class User {
	private String username, password, experience;

	public User(String username, String password, String experience) {
		this.username = username;
		this.password = password;
		this.experience = experience;
	}

	public String getUsername() {
		return username;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public void viewProfile(String indent) {
		System.out.println(indent + "Username: " + username);
		System.out.println(indent + "Experience: " + experience);
	}
}
