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
     
      Scanner input = new Scanner(System.in);
      
      System.out.println("Please enter your movie review. \n" +
    		  			 "Try to use proper grammar, however it's obviously not required to be a movie critic. ");
      String userReview = input.nextLine();
    		  
      String[] movieReviews = new String[9000];
      int[] movieReviewScores = new int[9000];
      
      MovieReviewReader.readMovieReviews( "movie_reviews.txt" , movieReviews , movieReviewScores );
      
//    String[] formattedReview = new String[500];  
//          
//      for(int i = 0; i < formattedReview.length ; i++) {
//    	  formattedReview = formatReview(reviews[i]);
//    	  
//    	  System.out.println();
//      }
//		All of this is here to test out the formatReview method on the movieReviews.txt file      
      
      userReviewScore( calculateWordScores( formatReview( userReview ).split("\\s+") , movieReviews , movieReviewScores ) ,
    		  								formatReview( userReview ).split("\\s+") );
      
      input.close();    
   }
   
   public static String formatReview( String userReview )
   {
	   String words = userReview.replaceAll("[^a-zA-Z ]", "").toLowerCase();
	   
//	   for(int j = 0; j < words.length ; j++) {
// 		  System.out.print(words[j] + " "); 		  
// 	  }
//	   System.out.println();
//  
	   return words;
   }
   
   public static double[] calculateWordScores( String[] editedUserReview , String[] movieReviews , int[] movieReviewScores) {
	   
	   double[] wordScores = new double[ editedUserReview.length ];
	   
	   double reviewContainsWord = 0 ;
	   double reviewSum = 0;
	   
	   for( int i = 0; i < editedUserReview.length ; i++) {
		   for( int j = 0; j < movieReviews.length ; j++ ) {
			   if ( formatReview( movieReviews[j] ).contains( editedUserReview[i] ) ) {
				   reviewSum += movieReviewScores[j];
				   reviewContainsWord++;
				
			   }
		   }
		   if ( reviewContainsWord > 0 )
			   wordScores[i] = reviewSum / reviewContainsWord;
		   else
			   wordScores[i] = 0;
	   }
	   
	   return wordScores;
   }
   
   public static void userReviewScore( double[] wordScores , String[] editedUserReview ) {
	   
	   double reviewScore = 0;
	   	   
	   double minScore = 4 , 		maxScore = 0;
	   double lowestWordScore = 0 , highestWordScore = 0 ;
	   String lowestWord = "",		highestWord = "";
	   
	   for(int i = 0; i < wordScores.length ; i++) {
		   if ( wordScores[i] < minScore ) {
			   minScore = wordScores[i];
			   lowestWordScore = wordScores[i];
			   lowestWord = editedUserReview[i];
		   }
		   
		   if ( wordScores[i] > maxScore ) {
			   maxScore = wordScores[i];
			   highestWordScore = wordScores[i];
			   highestWord = editedUserReview[i];
		   }
		   System.out.println( wordScores[i] );
		   
		   reviewScore += wordScores[i];
	   }
	   
	   System.out.println( reviewScore ); 
	   
	   System.out.println("The score of your review is " + (reviewScore / wordScores.length) );
	   
	   if ((reviewScore / wordScores.length) < 1.99 )
			System.out.println("The overall sentiment of your review is negative. \n" +
							   "You probably didn't like it because it's too smart for you.");
	   else if ((reviewScore / wordScores.length) < 2.009 )
			System.out.println("The overall sentiment of your review is neutral.  \n" +
							   "Don't you know it's boring to have a non-committal perspective?");
	   else
			System.out.println("The overall sentiment of your review is positive. \n" +
								"It was pretty awesome, wasn't it?");

	   System.out.println("The most positive word in your review is '" + highestWord +
			   			  "' with a score of " + highestWordScore + "." );
	   System.out.println("The most negative word in your review is '" + lowestWord + 
			   			  "' with a score of " + lowestWordScore + "." );
	   // Yay this is all done
   }
}

