import java.io.*;
import static java.lang.Math.pow;
public class Matrix 
{
	private int MaxSize = 10;
	private int number;
	private double mdata[][] = new double[MaxSize][MaxSize];
	public Matrix(int myNum)//constructor
	{
		MaxSize = myNum;
		number = myNum;
	}
	public void setMatrix(double[][] arr)
	{
		//set the array parameter to the private member variable.
		mdata = arr;
	}
 }

