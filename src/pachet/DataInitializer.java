package pachet;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataInitializer {
    public static void createData(ArrayList<Mentee> mentees, ArrayList<Mentor> mentors) {
        PrintStream systemOut = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));

        Mentor mentor1 = new Mentor("mentor1", "1234", "much");
        mentors.add(mentor1);
        Mentor mentor2 = new Mentor("mentor2", "1234", "very much");
        mentors.add(mentor2);
        Mentor mentor3 = new Mentor("mentor3", "1234", "a lot");
        mentors.add(mentor3);
        Mentee mentee1 = new Mentee("mentee1", "1234", "none");
        mentees.add(mentee1);
        Mentee mentee2 = new Mentee("mentee2", "1234", "0");
        mentees.add(mentee2);

        String simulatedInput = "description1\n" + "category1,category2\n";
        simulatedInput += "description2\n" + "category1,category2\n";
        simulatedInput += "description3\n" + "category1,category2\n";
        simulatedInput += "0\n" + "0\n";
        simulatedInput += "0\n" + "1\n";
        simulatedInput += "1\n" + "0\n" + "0\n" + "y\n";
        simulatedInput += "2\n" + "0\n" + "0\n" + "online\n" + "2025-05-23 14:00\n";
        Scanner sc = new Scanner(simulatedInput);

        mentor1.createMentorshipOffer(sc);
        mentor1.createMentorshipOffer(sc);
        mentor2.createMentorshipOffer(sc);
        mentee1.applyMentorship(sc, mentors);
        mentee1.applyMentorship(sc, mentors);
        mentor1.checkApplications(sc);
        mentor1.checkApplications(sc);

        sc.close();
        System.setOut(systemOut);
    }
}
