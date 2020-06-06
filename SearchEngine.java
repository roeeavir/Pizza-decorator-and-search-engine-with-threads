import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {

	static Scanner s = new Scanner(System.in);

	//Variables
	private int numberOfArticles;
	private String word;
	private String[] articles;
	
	//Constructor
	public SearchEngine(){
			setWord(word);
			setNumberOfArticles(numberOfArticles);
			setArticles(articles);
	}

	public int getNumberOfArticles() {
		return numberOfArticles;
	}


	public String getWord() {
		return word;
	}


	public String[] getArticles() {
		return articles;
	}
	
	
	//Gets the number of articles from the user.
	public void setNumberOfArticles(int numberOfArticles) {
		System.out.println("Enter the number of articles:");
		try {
			this.numberOfArticles = Integer.parseInt(s.nextLine());
		} catch (Exception e) {
			System.err.println("ERROR! Number of articles must be an int!" + e.getMessage());
		}
	}
	//Gets the wanted word which the user wants to search.
	public void setWord(String word) {
		System.out.println("Enter the searched word:");
		this.word = s.nextLine();
	}
	
	//Gets the name of each article from the user.
	public void setArticles(String[] articles) {
		this.articles = new String[this.numberOfArticles];
		for (int i = 0; i < this.numberOfArticles; i++) {
			System.out.println("Enter name of article no " + (i+1) + ":");
			this.articles[i] = s.nextLine();
		}
	}

	//A method for creating threads to count the appearances of a string in a file.
	public void search() {
		ArrayList<Thread> threads = new ArrayList<>();// Threads array list.
		ArrayList<SearchInFile> searches = new ArrayList<>();// Runnable targets array list.
		
		int sum = 0;
		for (int i = 0; i < articles.length; i++) {
			SearchInFile search = new SearchInFile(word);
			searches.add(search);
			Thread thread = new Thread(search, articles[i]);
			threads.add(thread);
			threads.get(i).start();
		}
		for(int i = 0; i < articles.length; i++) {
			try {
				threads.get(i).join();
				sum += searches.get(i).getCount();
			} catch (InterruptedException e) {
				System.out.println("ERROR!" + e.getMessage());
			}			
		}
		System.out.println("Total number of times the word '" + word + "' appears in articles is " + sum);
	}
	
	//Thread class for counting the appearances of a string in a file.
	public static class SearchInFile implements Runnable {

		private String word;
		private int count;
		
		public SearchInFile(String word) {
			this.word = word;
			this.count = 0;
		}
		
		public int getCount() {
			return count;
		}

		@Override
		public void run() {
			try {
				File article = new File(Thread.currentThread().getName());
				Scanner fileReader = new Scanner(article);
				String[] words;;
				while(fileReader.hasNext()) {
					words = fileReader.nextLine().split(" ");
					for(String s : words) {
						if(word.equals(s.toLowerCase()) || word.equals(s.toUpperCase()))
							count++;
					}
				}
				System.out.println("Word '" + word + "' appears in " +
				Thread.currentThread().getName() + " " + count + " times.");
				fileReader.close();			
			} 
			catch (IOException e) {
				System.err.println("Error occurred. Error is: " +  Thread.currentThread().getName()
						+ "(The system cannot find the file specified)");
			}
		}

	}
	
}
