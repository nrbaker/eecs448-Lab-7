import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void testMatrix() 
	{
		try
		{
			//creating new instances with different numerical values
			new Matrix(10);
			new Matrix(20);
			new Matrix(40);
			new Matrix(70);
			new Matrix(1);
			//if the code has made it thus far, then we know it was successful
			assertTrue("It worked!", true);
		}
		catch(Exception e)
		{
			fail("Failed...");
		}
	}

	@Test
	public void testSetMatrix() 
	{
		//no need to be tested since its returns void or nothing.
	}

	@Test
	public void testGetMatrixAtIndex() 
	{
		Matrix myMatrix = new Matrix(3);
		double[][] matrix1 = new double[3][3];
		myMatrix.setMatrix(matrix1);
		//inserting values into the matrix created.
		matrix1[0][0] = 5;
		matrix1[0][1] = 10;
		matrix1[0][2] = 15;
		matrix1[1][0] = 20;
		matrix1[1][1] = 25;
		matrix1[1][2] = 30;
		matrix1[2][0] = 2;
		matrix1[2][1] = 1;
		matrix1[2][2] = 9;
		//test to see if both cases hold the same value.
		if(matrix1[0][0] == myMatrix.getMatrixAtIndex(0, 0))
		{
			assertTrue("It worked!", true);
		}
		else
		{
			//use the fail function if the if statement above was not true
			fail("Failed...");
		}
		
		
		
	}

	@Test
	public void testDeterminant() 
	{
		//creating a new instance of a matrix and initializing a new matrix
		Matrix myMatrix = new Matrix(3);
		double[][] matrix1 = new double[3][3];
		myMatrix.setMatrix(matrix1);
		//inserting values into the matrix created.
		matrix1[0][0] = 5;
		matrix1[0][1] = 10;
		matrix1[0][2] = 15;
		matrix1[1][0] = 20;
		matrix1[1][1] = 25;
		matrix1[1][2] = 30;
		matrix1[2][0] = 2;
		matrix1[2][1] = 1;
		matrix1[2][2] = 9;
		
		//calling the assertEquals method to test the determinant method.
		assertEquals(-675.0, myMatrix.determinant(), 0.001);
	}

	@Test
	public void testInverse() 
	{
		boolean isTrue = true;
		Matrix myMatrix = new Matrix(3);
		double[][] matrix1 = new double[3][3];
		myMatrix.setMatrix(matrix1);
		//inserting values into the matrix created.
		matrix1[0][0] = 5;
		matrix1[0][1] = 10;
		matrix1[0][2] = 15;
		matrix1[1][0] = 20;
		matrix1[1][1] = 25;
		matrix1[1][2] = 30;
		matrix1[2][0] = 2;
		matrix1[2][1] = 1;
		matrix1[2][2] = 9;
		Matrix myMatrix1 = myMatrix.inverse();
		double[][] inverseMatrix = new double[3][3];
		myMatrix1.setMatrix(inverseMatrix);
		//inserting the inverse matrix values
		inverseMatrix[0][0] = -13/45;
		inverseMatrix[0][1] = 1/9;
		inverseMatrix[0][2] = 1/9;
		inverseMatrix[1][0] = 8/45;
		inverseMatrix[1][1] = -1/45;
		inverseMatrix[1][2] = -2/9;
		inverseMatrix[2][0] = 2/45;
		inverseMatrix[2][1] = -1/45;
		inverseMatrix[2][2] = 1/9;

		for(int i = 0; i < 3 ; i++)
		{
			for(int j =0; j<3; j++)
			{
				//checking every index to see if they are equal
				if(inverseMatrix[i][j] == myMatrix1.getMatrixAtIndex(i, j))
				{
					isTrue = true;
				}
				else
				{
					isTrue = false;
					fail("Failed...");
				}	
			}
		}
	}

	@Test
	public void testSubMatrix() 
	{
		boolean isTrue = true;
		Matrix myMatrix = new Matrix(3);
		double[][] matrix1 = new double[3][3];
		myMatrix.setMatrix(matrix1);
		//inserting values into the matrix created.
		matrix1[0][0] = 5;
		matrix1[0][1] = 10;
		matrix1[0][2] = 15;
		matrix1[1][0] = 20;
		matrix1[1][1] = 25;
		matrix1[1][2] = 30;
		matrix1[2][0] = 2;
		matrix1[2][1] = 1;
		matrix1[2][2] = 9;
		
		Matrix myMatrix2 = myMatrix.subMatrix(0 , 0);
		myMatrix2.setMatrix(matrix1);
		for(int i = 0; i < 3 ; i++)
		{
			for(int j =0; j<3; j++)
			{
				//checks if they are the same value
				if(matrix1[0][0] == myMatrix2.getMatrixAtIndex(0, 0))
				{								
					isTrue = true;
				}
				else
				{
					fail("Failed...");
				}
			}
		}
		
	}

}
