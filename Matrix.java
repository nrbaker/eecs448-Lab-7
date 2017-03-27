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
	public double getMatrixAtIndex(int a, int b)
	{
		//return the array at the given index
		return mdata[a][b];
	}
	public double determinant()
	{
		
		double det = 0.0;
		//if size of array is 1 do this code
		if(number == 1)
		{
			det = mdata[0][0];
		}
		//if size of array is 2 do this code
		else if(number == 2)
		{
			det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
		}
		else
		{
			for(int i = 0; i < number ; ++i)
			{
				det += Math.pow(-1.0, (double)i) * mdata[0][i]*subMatrix(0, i).determinant();
			}
		}
		
		return det;//returns the double
		
	}
 }

