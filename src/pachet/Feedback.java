package pachet;

public class Feedback {
	private String content;
	
	public Feedback(String content)
	{
		this.content=content;
	}
	
	public void showFeedback()
	{
		System.out.println("Feedback: "+content);
	}
}
