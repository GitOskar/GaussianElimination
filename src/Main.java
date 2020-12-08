public class Main {

    public static void main(String[] args)
    {
        MatrixFactory matrixFactory = new MatrixFactory();

        double[][] matrix = matrixFactory.createMatrix1();

        GaussianElimination gaussianElimination = new GaussianElimination(matrix);
        double[] result = gaussianElimination.solve();

        GaussianElimination.printResult(result);
    }

}