import java.util.Scanner;

class Polindrome
{
	public static void main(String[] args) {
		
		String word = setWord();
		answer(word);
	}

	static String setWord(){

		System.out.println("Set the word");
		Scanner word = new Scanner(System.in);
		return word.nextLine();
	}

	static void answer(String word){
		if(checkPolindrome(word))
			System.out.println("Yes, this is a polindrome");
		else
			System.out.println("No, it is not a polindrome");
	}

	static boolean checkPolindrome(String word){
		boolean pol = true;
		for(int i = 0, j = word.length() - 1; i < j; i++, j--)
		{
			if(word.charAt(i) != word.charAt(j))
				pol = false;
		}
		return pol;
	}
}