/*
    @author: Tanvir Waseer <twaseer@protonmail.com>
    @version: May 13, 2020
    @description: This is a java class providing fast, flexible, and expressive data structures designed to make
     working with matrices.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int column;
    private double[][] matrix = null;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
        this.rows = getRowCount(matrix);
        this.column = getColCount(matrix);
    }
    /*
    Scanner object to take user inputs just in case if the user is not providing a constructor with values.
     */
    Scanner keyboardInput = new Scanner(System.in);

    /*
    Constructor accepting two parameters first one number of rows and second, number of columns so that its easy
    to initialize the object with predefined values, and the matrix will prompt the user, again and again,
    to fill in the values again.
     */
    public Matrix(int rows, int column) {
        this.rows = rows;
        this.column = column;
        /*
        The object which was initialized above we are allotting it some memory with a particular length
        of matrices so that they don't cause any further exception based on mathematical and logical rules.
         */
        matrix = new double[rows][column];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                /*
                Prompting the user to add the values based on particular indexes.
                 */
                System.out.printf("Enter the value for index [%d,%d]: ", i, j);
                matrix[i][j] = keyboardInput.nextInt();
            }
        }
    }
    /*
    Constructor which accepts one parameter that is the hard coded value of matrix which is a 2d array in
    this case, which makes it easy to input data rather than having to type every value for
    index separately.

    This method can be executed by creating an object and calling it as shown below

    i.e.
    Matrix a = new Matrix((new int[][] {
            {1,2},
            {3,4}
    }));

    and of course, this can also be represented as

    Matrix a = new Matrix((new double[][] {
            {1.0,2.0},
            {3.0,4.0}
    }));

    as shown in the above example it will create a 2 x 2 matrix and we can hard code the value
    into the object so that we can perform the operations directly.
     */

    public Matrix(double[][] inputMatrix){
        /*
        It does not do any special checking except the fact that there is something inside in the matrix
         */
        if((inputMatrix != null) && (checkIfUnbalanced(inputMatrix))){
            setMatrix(inputMatrix);
        }
        /*
        If there is not anything inside the matrix then it will print the message written below.
         */
        else{
            displayError();
            System.exit(0);
        }
    }
    /*
    Constructor with no arguments which makes it easy to initialize objects and it will prompt the user
    to enter the number of rows and columns and then based on that ask for the values.
     */
    public Matrix() {
        System.out.print("Please enter the number of rows you want: ");
        setRows(keyboardInput.nextInt());

        System.out.print("Please enter the number of columns you want: ");
        setColumn(keyboardInput.nextInt());

        matrix = new double[rows][column];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.printf("Enter the value for index [%d,%d]: ", i, j);
                matrix[i][j] = keyboardInput.nextInt();
            }
        }
    }
    /*
    Let's consider two matrix objects on which we are going to perform the add operation

    Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));
    Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));

    This matrix operation adds two matrices, it accepts one parameter the matrix class object on which this
    function is going to perform the operation.

    The line below is going to execute the add method and store the resultant matrix in the object c
    Matrix c = a.add(b);
    Now to display the matrix we have to call the toString method which in this case will be

    System.out.println(c.toString());

    and the resultant is:

    2.0 4.0
    6.0 8.0

     */
    public Matrix add(Matrix inputMatrix){
        /*
        The conditional statement below is going to check first whether the input object is empty or not and
        secondly it checks that both the matrices on which the add operation is going to be performed are
        having the same number of rows and columns.
         */
        if((inputMatrix != null) && (checkMatrix(getMatrix(), inputMatrix.getMatrix()))){
            double finalMatrix[][] = null;
            /*
            The array of type integer below is going to store two values the first one for the row and the second one column.
             */
            int[] counts = getInputRowsCols(getMatrix());
            /*
            The 2d array actually storing the matrix having the first length same as the matrix given but it doesn't
            really matter because when adding both of the lengths of rows and columns should be same or else the
            method will not permit to perform the operation and show the statement in the else condition.
             */
            finalMatrix = new double[counts[0]][counts[1]];

            try{
                for(int i=0; i<finalMatrix.length; i++){
                    for(int j=0; j<finalMatrix[i].length; j++){
                        finalMatrix[i][j] = getMatrix()[i][j] + inputMatrix.getMatrix()[i][j];
                    }
                }
                return new Matrix(finalMatrix);
            }catch(Exception e){
                displayError();
                System.exit(0);
                //e.printStackTrace();
            }
        }
        else{
            displayError();
            System.exit(0);
        }
        /*
        And of course, even if something terrible occurs, definitely not returning anything.
         */
        return null;
    }
    /*
    This function below performs the same operation with a slight difference having a static keyword assigned
    to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
    parameters, both of type matrices upon which the addition will be performed.

    Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));
    Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));

    This method can be executed without creating an object and calling it as shown below

    System.out.println(Matrix.add(a, b));

    and the resultant is:

    2.0 4.0
    6.0 8.0

     */
    public static Matrix add(Matrix firstMatrix, Matrix secondMatrix){
        double[][] finalMatrix = null;
        if(checkMatrix(firstMatrix.getMatrix(), secondMatrix.getMatrix())){
            int[] counts = getInputRowsCols(firstMatrix.getMatrix());
            try{
                finalMatrix = new double[counts[0]][counts[1]];

                for(int i=0; i<finalMatrix.length; i++){
                    for(int j=0; j<finalMatrix[i].length; j++){
                        finalMatrix[i][j] = firstMatrix.getMatrix()[i][j] + secondMatrix.getMatrix()[i][j];
                    }
                }

                return new Matrix(finalMatrix);
            }catch(Exception e){
                //System.out.println("Something went wrong while adding two matrices please check the error logs.");
                //e.printStackTrace();
                displayError();
                System.exit(0);
            }
        }
        else{
            displayError();
            System.exit(0);
        }
        return null;
    }

    /*
    Let's consider two matrix objects on which we are going to perform the subtract operation

    Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));
    Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));

    This matrix operation subtracts two matrices, it accepts one parameter the matrix class object on which this
     function is going to perform the operation.

    This method can be executed by creating an object and calling it as shown below

    Matrix c = a.subtract(b);

    Now to display the matrix we have to call the toString method which in this case will be

    System.out.println(c.toString());

    and the resultant is:

    0.0 0.0
    0.0 0.0

     */
    public Matrix subtract(Matrix inputMatrix){
        /*
        The conditional statement below is going to check first whether the input object is empty or not and
        secondly, it checks that both the matrices on which the subtract operation is going to be performed are
        having the same number of rows and columns.
         */
        if((inputMatrix != null) && (checkMatrix(getMatrix(), inputMatrix.getMatrix()))){
            double finalMatrix[][] = null;

            int[] counts = getInputRowsCols(getMatrix());
            finalMatrix = new double[counts[0]][counts[1]];

            try{
                for(int i=0; i<finalMatrix.length; i++){
                    for(int j=0; j<finalMatrix[i].length; j++){
                        finalMatrix[i][j] = getMatrix()[i][j] - inputMatrix.getMatrix()[i][j];
                    }
                }
                return new Matrix(finalMatrix);
            }catch(Exception e){
                //System.out.println("Something went wrong during matrix subtraction please check the logs.");
                //e.printStackTrace();
                displayError();
                System.exit(0);
            }
        }
        else{
            displayError();
            System.exit(0);
        }
        return null;
    }

    /*
    Let's consider two matrix objects on which we are going to perform the subtract operation

    Matrix a = new Matrix((new double[][] {
            {1.0,2.0},
            {3.0,4.0}
    }));
    Matrix b = new Matrix((new double[][] {
            {1.0,2.0},
            {3.0,4.0}
    }));

    This function below performs the same subtract operation with a slight difference having a static keyword assigned
    to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
    parameters, both of type matrices upon which the subtraction will be performed.
    This method can be executed without creating an object and calling it as shown below

    The line below is going to execute the add method and store the resultant matrix

    System.out.println(Matrix.subtract(a,b).toString());

    and the resultant is:

    0.0 0.0
    0.0 0.0

     */
    public static Matrix subtract(Matrix firstMatrix, Matrix secondMatrix){
        double[][] finalMatrix = null;
        /*
        The conditional statement below is going to check first whether the input object is empty or not and
        secondly, it checks that both the matrices on which the subtract operation is going to be performed are
        having the same number of rows and columns.
         */
        if(checkMatrix(firstMatrix.getMatrix(), secondMatrix.getMatrix())){
            int[] counts = getInputRowsCols(firstMatrix.getMatrix());
            try{
                finalMatrix = new double[counts[0]][counts[1]];

                for(int i=0; i<finalMatrix.length; i++){
                    for(int j=0; j<finalMatrix[i].length; j++){
                        finalMatrix[i][j] = firstMatrix.getMatrix()[i][j] - secondMatrix.getMatrix()[i][j];
                    }
                }

                return new Matrix(finalMatrix);
            }catch(Exception e){
                //System.out.println("Something went wrong while subtracting two matrices please check the error logs.");
                //e.printStackTrace();
                displayError();
                System.exit(0);
            }
        }
        else{
            displayError();
            System.exit(0);
        }
        return null;
    }

    /*
    Let's consider two matrix objects on which we are going to perform multiplication

    Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));
    Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));

    This matrix operation multiplies two matrices, it accepts one parameter the matrix class object on which this
    function is going to perform the operation.
    This method can be executed by creating an object and calling it as shown below

    The line below is going to execute the multiply method and store the resultant matrix in the object c

    Matrix c = a.multiply(b);

    Now to display the matrix we have to call the toString method which in this case will be

    System.out.println(c.toString());

    and the resultant is:

    7 10
    15 22

     */
    public Matrix multiply(Matrix inputMatrix){
        /*
        The conditional statement below is going to check first whether the input object is empty or not and
        secondly, it checks that both the matrices on which the subtract operation is going to be performed are
        having the same number of rows and columns.
         */
        if((inputMatrix != null) && (checkIfUnbalanced(inputMatrix.getMatrix()))){
            int[] firstMatrixRowCount = getInputRowsCols(getMatrix());
            int[] secondMatrixColumnCount = getInputRowsCols(inputMatrix.getMatrix());
            double finalMatrix[][] = new double[firstMatrixRowCount[0]][secondMatrixColumnCount[1]];

            try{
                for(int i=0; i<firstMatrixRowCount[0]; i++){
                    for(int j=0; j<secondMatrixColumnCount[1]; j++){
                        for(int k=0; k<firstMatrixRowCount[1]; k++){
                            finalMatrix[i][j] += matrix[i][k] * inputMatrix.getMatrix()[k][j];
                        }
                    }
                }
                return new Matrix(finalMatrix);
            }catch(Exception e){
                //e.printStackTrace();
                displayError();
                e.printStackTrace();
            }
        }else{
            displayError();
            System.exit(0);
        }
        return null;
    }

    /*
    Let's consider two matrix objects on which we are going to perform multiplication

    Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));
    Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
    }));

    This function below performs the same multiplication operation with a slight difference having a static keyword assigned
    to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
    parameters, both of type matrices upon which the subtraction will be performed.
    This method can be executed without creating an object and calling it as shown below

    The line below is going to execute the add method and store the resultant matrix in the object c

    System.out.println(Matrix.multiply(a,b).toString());

    and the resultant is:

    7 10
    15 22

     */
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix){
        int[] firstMatrixRowCount = getInputRowsCols(firstMatrix.getMatrix());
        int[] secondMatrixColumnCount = getInputRowsCols(secondMatrix.getMatrix());

        double[][] finalMatrix = new double[firstMatrixRowCount[0]][secondMatrixColumnCount[1]];
        try{
            for(int i=0; i<firstMatrixRowCount[0]; i++){
                for(int j=0; j<secondMatrixColumnCount[1]; j++){
                    for(int k=0; k<firstMatrixRowCount[1]; k++){
                        finalMatrix[i][j] += firstMatrix.getMatrix()[i][k] * secondMatrix.getMatrix()[k][j];
                    }
                }
            }
            return new Matrix(finalMatrix);
        }catch(Exception e){
            displayError();
            System.exit(0);
        }
        return null;
    }
    /*
    This matrix operation returns the transpose of the matrix it's a non-static method
    i.e. we can directly call it and straight print it from its object.

    e.g.
    Matrix a = new Matrix(new double[][]{
            {1,2},
            {3,4},
            {5,6}
    });

    Printing the object in the below statement.

    System.out.println(a.T());

    The resultant displayed on the console is

    1 3 5
    2 4 6

     */
    public Matrix T(){
        if((getMatrix() != null) && (checkIfUnbalanced(getMatrix()))){
            double[][] finalMatrix = new double[getColCount(getMatrix())][getRowCount(getMatrix())];

            for(int i=0; i<getColCount(getMatrix()); i++){
                for(int j=0; j<getRowCount(getMatrix()); j++){
                    finalMatrix[i][j] = getMatrix()[j][i];
                }
            }

            return new Matrix(finalMatrix);
        }
        else{
            displayError();
            System.exit(0);
        }
        return null;
    }
    /*
    This function below performs the same operation as it returns the transpose of the matrix the only difference
    is its a static method and it accepts one argument.

    e.g.

    Matrix a = new Matrix(new double[][]{
            {1,2},
            {3,4},
            {5,6}
    });

    System.out.println(Matrix.T(a));

    As seen in the above statement we are calling it directly from the class method without creating any
    object, after execution the resultant on the terminal can be displayed as follows.

    1 3 5
    2 4 6
     */
    public static Matrix T(Matrix inputMatrix){
        /*
        Some usual conditional checks before processing the whole matrix.
         */
        if((inputMatrix.getMatrix() != null) && checkIfUnbalanced(inputMatrix.getMatrix())){
            /*
            Creating a new matrix where the transpose of matrix is going to be saved as we can see
            both rows and columns are switching since here the first parameter is the column and second is row.
             */
            double[][] finalMatrix = new double[getColCount(inputMatrix.getMatrix())][getRowCount(inputMatrix.getMatrix())];

            for(int i=0; i<getColCount(inputMatrix.getMatrix()); i++){
                for(int j=0; j<getRowCount(inputMatrix.getMatrix()); j++){
                    finalMatrix[i][j] = inputMatrix.getMatrix()[j][i];
                }
            }

            return new Matrix(finalMatrix);
        }
        else{
            displayError();
            System.exit(0);
        }
        return null;
    }

    /*
    The function plays an important role in verifying mathematical rules when it comes to matrix dimensions.
    so far in this program, the only use is implemented in addition and subtraction function but it can also
    be used in many other cases.
    This takes two arguments both of the matrix and checks whether they have the same number of rows and columns.
    It's a general method which means it can also be used just to verify the attributes of two matrices

    e.g.
    double[][] test1 = {
            {1,2},
            {3,4}
    };
    double[][] test2 = {
            {1,2},
            {3,4}
    };

    Matrix a = new Matrix(test1);
    Matrix b = new Matrix(test2);

    Although it's a boolean statement we can also create an object of the class and work accordingly.
    And below printing the boolean resultant expression

    System.out.println(check.checkMatrix(a.getMatrix(), b.getMatrix()));

    It will print true because both of the matrices having the same count for row and column.

    e.g.
    double[][] test1 = {
            {1,2}
    };
    double[][] test2 = {
            {1},
            {3}
    };

    Matrix a = new Matrix(test1);
    Matrix b = new Matrix(test2);

    Although it's a boolean statement we can also create an object of the class and work accordingly.

    System.out.println(Matrix.checkMatrix(a.getMatrix(), b.getMatrix()));
    It will print false because both of the matrices do not have the same count for row and column.
     */
    private static boolean checkMatrix(double[][] first_matrix, double[][] second_matrix){
        /*
        A conditional statement checks that the matrices are not empty if they are it displays
        the message in the else block.
         */
        if((first_matrix != null) && (second_matrix != null)){
            int[] firstMatrixData = getInputRowsCols(first_matrix);
            int[] secondMatrixData = getInputRowsCols(second_matrix);
            /*
            Now it checks whether the row count of the first matrix is equal to the row count of the second
            matrix and the same with the column count.
             */
            if((firstMatrixData[0] == secondMatrixData[0]) && (firstMatrixData[1] == secondMatrixData[1])){
                return true;
            }
        }
        return false;
    }

    private static int getRowCount(Matrix inputMatrix){
        if(inputMatrix != null){
            return inputMatrix.matrix.length;
        }
        return 0;
    }

    private static int getColCount(Matrix inputMatrix){
        int colCount = 0;

        if(inputMatrix != null){
            for(int i=0; i<inputMatrix.matrix.length; i++){
                for(int j=0; j<inputMatrix.matrix[i].length; j++){
                    colCount++;
                }
                return colCount;
            }
        }
        return 0;
    }

    /*
    This method returns the row count of a particular matrix.
     */
    public static int getRowCount(double[][] inputMatrix){
        if(inputMatrix != null){
            return inputMatrix.length;
        }
        return 0;
    }
    /*
    This method returns the column count of a particular matrix.
     */
    public static int getColCount(double[][] inputMatrix){
        int colCount = 0;

        if((inputMatrix != null) && (checkIfUnbalanced(inputMatrix))){
            for(int i=0; i<inputMatrix.length; i++){
                for(int j=0; j<inputMatrix[i].length; j++){
                    colCount++;
                }
                return colCount;
            }
        }
        return 0;
    }

    /*
    This function plays an important role in various parts of the program when it comes to verifying column and row count
    of a particular matrix because it checks if there all the rows are having the same number of columns

    i.e.
    Matrix a = new Matrix(new int[][]{
            {1,2},
            {3,4},
            {5,6}
    });

    let's take this object above for example if we run this function on an object "a" it will return true
    System.out.println(Matrix.chackIfUnbalanced(a.getMatrix()));
    because all the columns are the same in this matrix.
    now let's try something different

    Matrix b = new Matrix(new int[][]{
            {1,2},
            {3,4},
            {5,6,9}
    });

    clearly there is some inconsistency noticeable in object b above since there aer 3 columns in 3rd row
    System.out.println(Matrix.checkIfUnbalanced(a.getMatrix()));
    now in this particular case, this function will return false
     */
    public static boolean checkIfUnbalanced(double[][] inputMatrix){
        ArrayList<Integer> storeCount = new ArrayList<Integer>();
        /*
        Below the first loop is getting the column count for every single row.
        and storing the count in an array list named colCount which is of type integer.
         */
        for(int i=0; i<inputMatrix.length; i++){
            storeCount.add(inputMatrix[i].length);
        }
        /*
        Now since we do have the count we can iterate through index values just to verify that all
        the values are same or not.
         */
        for(int i=0; i<storeCount.size(); i++){
            /*
            If the values are not same it will return false
             */
            if(storeCount.get(i) != storeCount.get(storeCount.size() - 1)){
                return false;
            }
        }
        /*
        else it return true.
         */
        return true;
    }

    /*
    The method is shown below return an array containing both row and column the row on the 0th index and
    column on the 1st index. It accepts one argument i.e. of the matrix itself of which we need the attributes
    we could have also chosen another approach and create separate methods, in which each will
    separately return row and column in int format but both of the ways do make sense and most importantly
    it gets work done.
    This can be easily applied to any 2d array to get its row and column count.
    e.g.

    int[][] test1 = {
            {1,2,3},
            {4,5,6}
    };

    Matrix a = new Matrix(test1);
    int[] count = Matrix.getInputRowsCols(a.getMatrix());
    System.out.println("Rows: "+count[0]);
    System.out.println("Column: "+count[1]);

    Terminal:
    Rows: 2
    Column: 3
     */
    private static int[] getInputRowsCols(double[][] inputMatrix){
        if(inputMatrix != null){
            int rowCount = 0;
            int colCount = 0;
            for(int i=0; i<inputMatrix.length; i++){
                if(i == (inputMatrix.length - 1) ){
                    rowCount = i + 1;
                }
                for(int j=0; j<inputMatrix[i].length; j++){
                    if(j == (inputMatrix[i].length - 1) ){
                        colCount = j + 1;
                    }
                }
            }
            int[] result = {rowCount,colCount};
            return result;
        }else{
            System.out.println("Please make sure that you are not passing an empty matrix.");
        }
        return null;
    }


    private static void displayError(){
        System.out.println("Please make sure if matrices have the same dimension; that is, they must have the " +
                "same number of rows and columns.");
    }

    @Override
    public String toString() {
        String finalString = new String();
        for(int i=0; i<getMatrix().length; i++){
            for(int j=0; j<getMatrix()[i].length; j++){
                finalString += getMatrix()[i][j]+" ";
            }
            finalString += "\n";
        }
        return finalString;
    }
}