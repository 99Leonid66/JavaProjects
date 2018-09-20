import java.util.Scanner;
public class SimpleAndPolindrom
{
	public static void main(String[] args) {
		
		System.out.println("Set 1 for Simple number or 2 for polindrome");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		//Prostye pr = new Prostye();
		//Polindrome pol = new Polindrome();

		switch(number)
		{
			case 1: Prostye.main(null);
			break;
			case 2: Polindrome.main(null);
			break;
		}
	}
}