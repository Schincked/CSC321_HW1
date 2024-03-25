import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;


public class SentimentsCalculator {
    List<Float> listOfScores = new ArrayList<Float>();
	

		/**
	 * Determines the sentiments of the provided word by analyzing the 
	 * frequency that the word appears in a positive, negative or neutral
	 * review. The text can be determined to be positive, negative, 
	 * or neutral/unknown.
	 * @param word the word to determine the sentiments of
	 * @return a float of the rating of the word
	 */
	public float sentimentWordScore(String word) throws IOException {
            int reviewScores[] = new int[9000];
            float average = 0;
            int count = 0;
            int index = -1;
            word = word.replaceAll("\\p{Punct}", "").toLowerCase();
            

            BufferedReader fileReader = new BufferedReader(new FileReader("messyReviewsFull.txt"));
            String eachLine;
            eachLine = fileReader.readLine();


                while(eachLine!=null){
                    String wordList[] = eachLine.split(" ");
                    for(int i=0; i<wordList.length; i++){
                        if(wordList[i].equals(word)==true){
                            ++count;
                            ++index;
                            reviewScores[index] = Integer.parseInt(wordList[0]);
                        }
                    }
                    eachLine = fileReader.readLine();
                }

            for(int i=0; i<=count; i++){
                average = average + reviewScores[i];
            }
            if(count == 0) {
                return 2;
            } else {
                average = average/count;
                return average;
            }

	}
	
	/**
	 * Determines the array values for user input phrase.
	 * Takes that phrase and passes sentimentWordScore() to the phrase after 
	 * separating the phrase.
	 * @param sentence the word or phrase to determine the sentiments of
	 * @return average rating of the array of words.
	 */

	float sentimentSentenceScore(String sentence) throws IOException {
		String[] listOfWords = sentence.split(" ");
		for(int i = 0; i < listOfWords.length; i++){
			String word = listOfWords[i];
			listOfScores.add(sentimentWordScore(word));
		}

		return averageOfArray(listOfScores);

	}

	/**
	 * Determines the average of an Array list of elements.
	 * @param myArray the array of words to calculate the average of.
	 * @return decimal of the entire array list of elements.
	 */
	public float averageOfArray(List<Float> myArray){
		float sum = 0;
		for(int i=0; i<myArray.size(); i++){

			sum = sum + myArray.get(i);
		}
		float avg = sum / myArray.size();
		return avg;
	}

}