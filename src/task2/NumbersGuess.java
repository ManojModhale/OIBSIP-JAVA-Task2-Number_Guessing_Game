package task2;

import java.util.Random;
import java.util.Scanner;

public class NumbersGuess 
{
	public int level(Scanner sc)
	{
		Random random=new Random();
		int randomNumber=random.nextInt(100);
		
		System.out.println("we have selected/Generated a number between 1 and 100.\nTry to guess it in just 10 Attempts!");
		
		int userGuess;
		int attempts=0;
		final int maxAttempts=10;
		int score=0;
		do
		{
			System.out.println("Enter your Guess : ");
			 while (!sc.hasNextInt()) 
			 {
	                System.out.println("Invalid input. Please enter a number.");
	                sc.next(); 
	         }
			userGuess=sc.nextInt();
			attempts++;
				
			if(userGuess<randomNumber)
			{
				System.out.println("Too Low! Try again.");
			}
			else if(userGuess>randomNumber)
			{
				System.out.println("Too High! Try again.");
			}
			else
			{
				System.out.println("Congratulations! You guessed correct number "+randomNumber+" in just "+attempts+" Attempts.");
				score=((11-attempts)*10);
				System.out.println("Your Score is '"+score+"' Points out of 100.");
			}
			
		}while(userGuess!=randomNumber && attempts<maxAttempts);
		
		if(attempts==maxAttempts)
		{
			System.out.println("Sorry, your 10 attempts are finished. The Correct Number was "+randomNumber+".");
		}
		
		return score;	
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		NumbersGuess obj2=new NumbersGuess();
		System.out.println("Welcome to the Number Guessing Game!");
		String playAgain;
		int totalscore=0;
		int round=0;
		
		do
		{
			round++;
			System.out.println("This is '"+round+"' Round.");
			int roundscore=obj2.level(sc);
			System.out.println("Do you want to play this game again? Enter 'Yes' to start again.");
			playAgain=sc.next();
			totalscore=totalscore+roundscore;
		}while(playAgain.equalsIgnoreCase("Yes"));
		
		System.out.println("You Have Played "+round+" Rounds of this Game and You Have Scored Totalscore = "+totalscore);
	}

}
