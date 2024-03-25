import java.io.*;
import java.util.Scanner;

public class ReviewAnalysisDriver {
	
	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(System.in);
		SentimentsCalculator sentiments = new SentimentsCalculator();
		String input;
		
		while(true) {
			System.out.print("Please enter your review:\n");
			input = in.nextLine();
			float score = sentiments.sentimentSentenceScore(input);
			if (1.90 < score && score < 2.10) {
				System.out.println("The score is : " + score + " and the review is neutral");
			} else if (score <= 1.90 && score > 1.75){
				System.out.println("The score is : " + score + " and the review is slightly negative");
			} else if (score <= 1.75){
				System.out.println("The score is : " + score + " and the review is negative");
			} else if (score < 2.25 && score >= 2.10){
				System.out.println("The score is : " + score + " and the review is slightly positive");
			} else {
				System.out.println("The score is : " + score + " and the review is positive");
			}
			break;
		
		}
	
	}
  
}