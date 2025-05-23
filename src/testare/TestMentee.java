package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pachet.DataInitializer;
import pachet.Mentee;
import pachet.Mentor;

class TestMentee {
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
	void testSearchMentor() {
		ArrayList<Mentee> mentees = new ArrayList<>();
		ArrayList<Mentor> mentors = new ArrayList<>();

		Mentee mentee = new Mentee("mentee", "1234", "n am");
		mentee.searchMentor(mentors);
		String expectedOutput = "No mentors found.";
		assertEquals(expectedOutput, out.toString().replace("\r\n", "\n").strip());
		out.reset();

		DataInitializer.createData(mentees, mentors);
		mentee = mentees.get(0);
		mentee.searchMentor(mentors);
		expectedOutput = """
				Available mentors and their offers:

				0. Mentor:
				  Username: mentor1
				  Experience: much

				  0. Offer:

				    Mentorship offer description: description1
				    Categories: category1, category2

				  1. Offer:

				    Mentorship offer description: description2
				    Categories: category1, category2

				1. Mentor:
				  Username: mentor2
				  Experience: very much

				  0. Offer:

				    Mentorship offer description: description3
				    Categories: category1, category2""";
		assertEquals(expectedOutput, out.toString().replace("\r\n", "\n").strip());
	}
}
