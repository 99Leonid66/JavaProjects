public class Prostye
{
	public static void main(String[] args)
	{
		int n = 100;	
		boolean simple;
		for(int i = 1; i <= n; i++)
		{
			simple = true;
			for(int j = 2; j < i; j++)
			{
				if(i % j == 0)
				{
					simple = false;
					break;
				}
					
			}
			if(simple)
				System.out.println(i);
		}
	}
}