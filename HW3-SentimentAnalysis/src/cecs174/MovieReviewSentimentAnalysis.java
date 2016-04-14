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
      String userIn = input.nextLine();
    		  
      String[] reviews = new String[20];
      int[] reviewScores = new int[20];
      
      MovieReviewReader.readMovieReviews( "movie_reviews.txt" , reviews , reviewScores );
      
      //System.out.println(reviews[12]);
      //System.out.println(reviewScores[12]);
      
      String[] words = userIn.split(" ");
       
      
      for ( int i = 0; i < words.length; i++ )
          System.out.println( words[i] );
     
   }
   
   
}


