# Matrix-Operations

This is a java class providing fast, flexible, and expressive data structures designed to make working with matrices.

Soon going to upload a new version of matrix-operations which makes the use of Generics.

### Table of Contents:

[Installation](#installation)
<br>
[Usage](#usage)
<br>
[Contributing](#contributing)
<br>
[Credits](#credits)
<br>
[License](#license)

<h3 id="installation">
Installation
</h3>
Before installation, I would like to point out one thing that you should have Maven installed.

Now we are all done with the prerequisites let's jump to the installation part

In order to create a JAR for this project, the process is pretty straightforward navigate to the project directory and run the following:

```bash
mvn package
```
This will automatically create a JAR file in the directory /target

<h3 id="usage">
Usage
</h3>

#### Primarily there are two ways that you can create a matrix, one of the ways is discussed below which demonstrates the creation of a matrix with the help of a constructor.

Constructor which accepts one parameter that is the hard coded value of matrix which is a 2d array in this case,
which makes it easy to input data rather than having to type every value for index separately. This
method can be executed by creating an object and calling it as shown below

```java
Matrix a = new Matrix((new int[][]{
        {1,2},
        {3,4}
}));
```

and of course, this can also be represented as

```java
Matrix a = new Matrix((new double[][]{
        {1.0,2.0},
        {3.0,4.0}
}));
```

as shown in the above example it will create a 2 x 2 matrix and we can hard code the value into the
object so that we can perform the operations directly.

#### Another way is to input the number of rows and columns and then add the values using setters.

Constructor accepting two parameters first one number of rows and second, number of columns so that its easy
to initialize the object with predefined values, and the matrix will prompt the user,
to fill in the values.

The following will create a 2 x 2 matrix, for which the user will have to fill the input prompts for adding values.
```java
Matrix a = new Matrix(2,2);
```

#### Matrix operations that this class supports with the examples are listed below

<hr>

#### Addition 
Let's consider two matrix objects on which we are going to perform the add operation

```java
Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```    
```java
Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```

This matrix operation adds two matrices, it accepts one parameter the matrix class object on which this
function is going to perform the operation.
This method can be executed by creating an object and calling it as shown below

The line below is going to execute the add method and store the resultant matrix in the object c
```java
Matrix c = a.add(b);
```

Now to display the matrix we have to call the toString method which in this case will be
```java
System.out.println(c.toString());
```

and the resultant is:
```java
2.0 4.0
6.0 8.0
```

Another way to perform addition would be making the use of static function

This function below performs the same operation with a slight difference having a static keyword assigned
to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
parameters, both of type matrices upon which the addition will be performed.
This method can be executed without creating an object and calling it as shown below

```java
Matrix.add(a, b);
```
<hr>

#### Subtract
Let's consider two matrix objects on which we are going to perform the subtract operation

```java
Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```

```java
Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```    

This matrix operation subtracts two matrices, it accepts one parameter the matrix class object on which this
function is going to perform the operation.
This method can be executed by creating an object and calling it as shown below



The line below is going to execute the add method and store the resultant matrix in the object c
```java
Matrix c = a.subtract(b);
```

Another way to perform subtraction would be making the use of static function

This function below performs the same subtract operation with a slight difference having a static keyword assigned
to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
parameters, both of type matrices upon which the subtraction will be performed.
This method can be executed without creating an object and calling it as shown below

```java
Matrix.subtract(a,b);
```

<hr>

#### Multiply
Let's consider two matrix objects on which we are going to perform the multiplication
```java
Matrix a = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```
```java
Matrix b = new Matrix((new double[][] {
            {1,2},
            {3,4}
}));
```

This matrix operation multiplies two matrices, it accepts one parameter the matrix class object on which this
function is going to perform the operation.
This method can be executed by creating an object and calling it as shown below

The line below is going to execute the multiply method and store the resultant matrix in the object c

```java
Matrix c = a.multiply(b);
```

Now to display the matrix we have to call the toString method which in this case will be

```java
System.out.println(c);
```

and the resultant is:

```java
7.0 10.0
15.0 22.0
```

Another way to perform multiplication would be making use of static function

This function below performs the same multiplication operation with a slight difference having a static keyword assigned
to it, makes it accessible from anywhere without having to call it from its object moreover it accepts two
parameters, both of type matrices upon which the subtraction will be performed.
This method can be executed without creating an object and calling it as shown below

```java
Matrix c = Matrix.multiply(a,b);
```

<hr>

#### Transpose
This matrix operation returns the transpose of the matrix it's a non-static method
i.e. we can directly call it and straight print it from its object.

```java
Matrix a = new Matrix(new double[][]{
            {1,2},
            {3,4},
            {5,6}
});
```

Printing the object in the below statement.

System.out.println(a.T());

The resultant displayed on the console is

```java
1 3 5
2 4 6
```

This function below performs the same operation as it returns the transpose of the matrix the only difference
is its a static method and it accepts one argument.

```java
Matrix.T(a);
```

As seen in the above statement we are calling it directly from the class method without creating any
object, after execution the resultant on the terminal can be displayed as follows.

```java
1 3 5
2 4 6
```

<hr>

#### Get row count
Let's consider the following matrix
```java
Matrix a = new Matrix(new double[][]{
        {1.0,2.0},
        {3.0,4.0}
});
```
To get the row count for matrix a we can do
```java
a.getRows();
```
<hr>

#### Get column count
Let's consider the following matrix
```java
Matrix a = new Matrix(new double[][]{
        {1.0,2.0},
        {3.0,4.0}
});
```
To get the column count for matrix a we can do
```java
a.getCols();
```

<h3 id="contributing">
Contributing
</h3>
This project is open to contribution, but before pushing the modified or changed source code please leave an email to the author at twaseer@protonmail.com

<h3 id="credits">
Credits
</h3>
This project was only created by the author itself.


<h3 id="license">
License
</h3>
The content of this project and the underlying source code used is licensed under the MIT license.
