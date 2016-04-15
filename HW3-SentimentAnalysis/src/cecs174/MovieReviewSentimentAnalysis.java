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
      String userInput = input.nextLine();
    		  
      String[] reviews = new String[100];
      int[] reviewScores = new int[100];
      
      MovieReviewReader.readMovieReviews( "movie_reviews.txt" , reviews , reviewScores );
      
//      String endString = userInput.replaceAll( userInput.substring( 3 , 3 ) , "LOL" );
//      
//      System.out.println( endString );

      
      String[] words = formatReview( userInput );

      input.close();    
   }
   
   public static String[] formatReview( String userReview )
   {
	   userReview.toLowerCase();
	   
	   String noPunctuationReview = "";
	     
	   for( int i = 0; i < userReview.length() ; i++ ) {
			   System.out.print( userReview.substring( i , i + 1 ) + "- "  );

			   if( !Character.isLetter(userReview.charAt(i)) 
				&& !Character.isWhitespace(userReview.charAt(i))) {
				   noPunctuationReview =
				   userReview.replaceAll( userReview.substring( i , i + 1 ) , "" );
				   userReview = noPunctuationReview;
			   }
			   System.out.println( userReview.substring( i , i + 1 ) + "- "  );
		   }
		   System.out.println( userReview );
	   
	   return noPunctuationReview.split(" ");
	   // Yay!
   }
}

