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
	public Matrix inverse()
	{
		Matrix inv = new Matrix(number);
		double[][] arr = new double[number][number];
		double det = determinant();
		
		for(int i = 0; i < number ; ++i)//increments i before the current expression is evaluated
		{
			for(int j =0; j < number ; ++j)
			{
				inv.mdata[i][j] = Math.pow(-1.0 , (double)i +j) * subMatrix(j, i).determinant() / det;
				//this if statement is used for fail safe of negative 0 which is
				// not a real number
				if(inv.mdata[i][j] == -0)
				{
					inv.mdata[i][j] = 0;
				}
			}
		}
		return inv;//returns the Matrix
		
	}
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(number - 1);
		int row = 0;
		for(int i = 0; i < number ; ++i)
		{
			if(i == r)
			{
				continue;
			}
			int col = 0;
			for(int j = 0; j < number; ++j)
			{
				if(j == c)
				{
					continue;
				}
				sub.mdata[row][col] = mdata[i][j];
				++col;
			}
			++row;
		}
		return sub;
	}
 }

