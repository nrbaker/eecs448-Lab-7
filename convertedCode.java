import java.util.Scanner;
import java.io.*;
public class convertedCode 
{
	public static void main (String [] args)
	{
		if(args.length < 3)
		{
			//makes sure that three arguments are being used
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			return;
		}
		try
		{
			//creating the ostream and ifstream in Java. Pass in args[1] and args [2]
			Scanner myInputFile = new Scanner(new File(args[1]));//input.txt
			OutputStream myFile = new FileOutputStream(args[2]);
			PrintStream myOut = new PrintStream(myFile);
			int n = myInputFile.nextInt(); 
			double[][] myArray = new double[n][n];
			//reading the file
			while(myInputFile.hasNextInt() && (n > 0))
			{
				myArray = new double[n][n];
				myOut.println("M = ");
				for(int i =0; i < n ; i++)
				{
					for(int j =0; j < n; j++)
					{
						//storing the read in integer into an index in the array.
						myArray[i][j] = myInputFile.nextInt();
						myOut.println((int)myArray[i][j]+" ");//casting to an int
					}
					myOut.println();
				}
				Matrix m = new Matrix(n);
				m.setMatrix(myArray);
				double det = m.determinant();
				myOut.println("det(M) = "+det);
				if(det != 0)
				{
					Matrix inv = m.inverse();
					myOut.println("Minv = ");
					for(int i =0; i<n; i++)
					{
						for(int j=0; j<n; j++)
						{
							//print out the inverse matrix.
							myOut.println(inv.getMatrixAtIndex(i, j)+" ");
						}
						myOut.println();
					}
					
				}
				//reinitialize n
				n = myInputFile.nextInt();
			}
			myOut.println("Done!");
		}
		catch(Exception e)
		{
			//only runs if error occurred in the try
			System.out.println("Error - read and write capabilities did not work properly.");
		}
		
	}
}
