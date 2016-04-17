package cecs174;
import java.util.Scanner;
/**
 * TODO: complete JavaDoc comments
 *
 */
public class MovieReviewSentimentAnalysis {
   
   public static void main(String[] args) 
   {
      // TODO: complete me!
      System.out.println("Incomplete assignment");
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Simon Cowell up in this bitch nigga!");
      String userReview = input.nextLine();
    		  
      String[] movieReviews = new String[10];
      int[] movieReviewScores = new int[10];
      
      MovieReviewReader.readMovieReviews( "movie_reviews.txt" , movieReviews , movieReviewScores );
//    String[] formattedReview = new String[500];  
//          
//      for(int i = 0; i < formattedReview.length ; i++) {
//    	  formattedReview = formatReview(reviews[i]);
//    	  
//    	  System.out.println();
//      }
//		All of this is here to test out the formatReview method on the movieReviews.txt file      
      
      calculateReviewScore( calculateWordScores( userReview , movieReviews , movieReviewScores ) , userReview );
      
      input.close();    
   }
   
   public static String[] formatReview( String userReview )
   {
	   String[] words = userReview.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	   
//	   for(int j = 0; j < words.length ; j++) {
// 		  System.out.print(words[j] + " "); 		  
// 	  }
//	   System.out.println();
//  
	   return words;
   }
   
   public static double[] calculateWordScores( String userReview , String[] movieReviews , int[] movieReviewScores) {
	   double wordScores[] = {};
	   
	   
	   
	   
	   
	   
	   
	   return wordScores;
   }
   
   public static double calculateReviewScore( double[] wordScores , String userReview ) {
	   double reviewScore = 0;
	   
	   String[] wordsInUserReview = formatReview( userReview );
	   
	   double minScore = 4 , 		maxScore = 0;
	   double lowestWordScore = 0 , highestWordScore = 0 ;
	   String lowestWord = "",		highestWord = "";
	   
	   for(int i = 0; i < wordScores.length ; i++) {
		   if ( wordScores[i] < minScore ) {
			   minScore = wordScores[i];
			   lowestWordScore = wordScores[i];
			   lowestWord = wordsInUserReview[i];
		   }
		   
		   if ( wordScores[i] > maxScore ) {
			   maxScore = wordScores[i];
			   highestWordScore = wordScores[i];
			   highestWord = wordsInUserReview[i];
		   }
		   
		   reviewScore += wordScores[i];
	   }
	   
	   
	   System.out.println("The score of your review is " + (reviewScore / wordScores.length) );
	   
	   if ((reviewScore / wordScores.length) < 1.99 )
			System.out.println("The overall sentiment of your review is negative." );
	   else if ((reviewScore / wordScores.length) < 2.009 )
			System.out.println("The overall sentiment of your review is neutral." );
	   else
			System.out.println("The overall sentiment of your review is positive." );

	   System.out.println("The most positive word in your review is " + highestWord +
			   			  " with a score of " + highestWordScore + "." );
	   System.out.println("The most negative word in your review is " + lowestWord + 
			   			  " with a score of " + lowestWordScore + "." );
	   	   
	   return reviewScore; // Yay this is all done
   }
}

