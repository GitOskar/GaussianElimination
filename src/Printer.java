public class Printer {

    public static void printMatrix(double[][] matrix)
    {
        for (int i=0 ; i<matrix.length ; i++) {
            for (int j = 0; j < matrix.length + 1; j++)
                System.out.print(matrix[i][j] + " \t");
            System.out.println();
        }
    }

    public static void printResult(double[] result)
    {
        char variable = 'a';
        for (int i=0 ; i<result.length ; i++)
        {
            System.out.println(variable + " = " + result[i]);
            variable++;
        }
    }
}
