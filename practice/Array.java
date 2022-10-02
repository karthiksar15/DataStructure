package practice;

import java.util.Arrays;

public class Array {
	
	private int[] numbers;
	private int length;
	public Array(int length)
	{
		numbers=new int[length];
		this.length=length;
	}
	
	public void insert(int nos)
	{
		resize();
		numbers[Arrays.asList(numbers).size()-1]=nos;
	}
	public void resize()
	{
		
		if (Arrays.asList(numbers).size()==length)
		{
			numbers=Arrays.copyOf(numbers, length+5);
		}
	}

}
