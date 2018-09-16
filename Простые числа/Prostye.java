import java.util.Scanner;
public class Prostye
{
	public static void main(String[] args)
	{
		int n = setValue();	
		printSimpleNumberUptoN(n);
	}

	static int setValue()
	{
		System.out.println("Set value");
		Scanner value = new Scanner(System.in);
		int v = value.nextInt();
		return v;
	}

	static void printSimpleNumberUptoN(int n)
	{
		System.out.println("Simple numbers up to " + n);
		for(int i = 1; i <= n; i++)
		{
			if(checkSimpleNumber(i))
			{
				System.out.println(i);
			}
		}
	}

	static boolean checkSimpleNumber(int number)
	{
		boolean simple = true;
		for(int j = 2; j < number; j++)
			{
				if(number % j == 0)
				{
					simple = false;
					break;
				}		
			}
		return simple;
	}
}