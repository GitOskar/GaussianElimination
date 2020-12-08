public class GaussianElimination
{
    private static final double EPSILON = 1e-10;
    double[][] matrix;
    int n;

    public GaussianElimination(double [][] matrix)
    {
        this.matrix = matrix;
        this.n = matrix.length;
    }

    public double[] solve()
    {
        try{
            forwardElimination();
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        return backSub();
    }

    private void swapRow(double matrix[][], int i, int j)
    {
        for (int k=0; k<=n; k++)
        {
            double tmp = matrix[i][k];
            matrix[i][k] = matrix[j][k];
            matrix[j][k] = tmp;
        }
    }

    private void forwardElimination() throws ArithmeticException
    {
        for (int k=0; k<n; k++)
        {
            int maxIndex = k;
            double maxValue = matrix[maxIndex][k];

            for (int i = k+1; i < n; i++)
                if (Math.abs(matrix[i][k]) > maxValue) {
                    maxValue = matrix[i][k];
                    maxIndex = i;
                }

            if (Math.abs(matrix[k][maxIndex]) < EPSILON)
                throw new ArithmeticException("Matrix is singular or close to be singular");

            if (maxIndex != k)
                swapRow(matrix, k, maxIndex);

            for (int i=k+1; i<n; i++)
            {
                double multiplier = matrix[i][k]/matrix[k][k];

                matrix[i][k] = 0;

                for (int j=k+1; j<=n; j++)
                    matrix[i][j] -= matrix[k][j]*multiplier;
            }
        }
    }

    private double[] backSub()
    {
        double[] resault = new double[n];

        for (int i = n-1; i >= 0; i--)
        {
            resault[i] = matrix[i][n];

            for (int j=i+1; j<n; j++)
                resault[i] -= matrix[i][j]*resault[j];

            resault[i] = resault[i] / matrix[i][i];
        }

        return resault;
    }
}