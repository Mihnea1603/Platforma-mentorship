package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pachet.DataInitializer;
import pachet.Mentee;
import pachet.Mentor;

class TestMentor {
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;

	@BeforeEach
	void setUpStream() {
		System.setOut(new PrintStream(out));
	}

	@AfterEach
	void restoreStream() {
		System.setOut(originalOut);
	}

	@Test
	void testCheckAppointments() {
		ArrayList<Mentee> mentees = new ArrayList<>();
		ArrayList<Mentor> mentors = new ArrayList<>();
		DataInitializer.createData(mentees, mentors);

		Mentor mentor = mentors.get(2);
		mentor.checkAppointments(null);
		String expectedOutput = "No appointments found.";
		assertEquals(expectedOutput, out.toString().replace("\r\n", "\n").strip());
		out.reset();

		String simulatedInput = "n\n";
		simulatedInput += "y\n" + "0\n" + "gj\n";
		Scanner sc = new Scanner(simulatedInput);

		mentor = mentors.get(0);
		mentor.checkAppointments(sc);
		expectedOutput = """
				Your appointments:

				0. Appointment:

				  Mentee:
				  Username: mentee1
				  Experience: none

				  Appointment type: ONLINE
				  Date: Fri May 23 14:00:00 EEST 2025
				Do you want to provide feedback for an appointment? (y/n):""";
		assertEquals(expectedOutput, out.toString().replace("\r\n", "\n").strip());
		out.reset();

		mentor.checkAppointments(sc);
		expectedOutput += " Select appointment index to provide feedback (0 to 0): Enter feedback content: Feedback submitted successfully!";
		assertEquals(expectedOutput, out.toString().replace("\r\n", "\n").strip());

		sc.close();
	}
}
