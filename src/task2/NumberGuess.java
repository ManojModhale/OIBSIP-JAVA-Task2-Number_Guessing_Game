package task2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess 
{
	public int level(int randomNumber, Scanner sc)
	{
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
				System.out.println("Your Score is "+score+" Points out of 100.");
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
		Scanner sc=new Scanner(System.in);
		NumberGuess obj=new NumberGuess();
		String playAgain;
		do
		{
			Random random=new Random();
			int randomNumber1=random.nextInt(100);
			
			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("---This is Easy Level---");
			System.out.println("we have selected/Generated a number between 1 and 100.\nTry to guess it in just 10 Attempts!");
			
			int score1=obj.level(randomNumber1,sc);
			
			System.out.println("Do you Want Play Next level");
			System.out.println("Enter Yes play next level");
			String choice=sc.next();
			
			if(!choice.equalsIgnoreCase("Yes"))
			{
				System.out.println("You haven't Entered 'Yes' to play next Level.");
			}
			else if(score1<=0)
			{
				System.out.println("You failed in Last Level, So can't Play Next Level");
			}
			else
			{
				System.out.println("_______________________________________________________");
				int randomNumber2=random.nextInt(200);
				
				System.out.println("Welcome to the Number Guessing Game!");
				System.out.println("-----This is Hard Level-----");
				System.out.println("we have selected/Generated a number between 1 and 200.\nTry to guess it in just 10 Attempts!");
				int score2=obj.level(randomNumber2, sc);
				int score=score2+score1;
				System.out.println("Your Total score is "+score);
				System.out.println("You are the Winner.");
			}
			System.out.println("Do you want to play this game again? Enter 'Yes' to start again.");
			playAgain=sc.next();
		}while(playAgain.equalsIgnoreCase("Yes"));
	}

}
