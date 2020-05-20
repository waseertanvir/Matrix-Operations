public class TestCase {
    public static void main(String[] args) {
        Matrix a,b,c,d,e,f;
        a = new Matrix(new double[][]{
                {3,4,2},
                {2,3,-1}
        });

        b = new Matrix(new double[][]{
                {1,-2,-4},
                {0,-1,2},
                {6,-3,9}
        });

        c = new Matrix(new double[][]{
                {1,1},
                {1,1},
                {1,1}
        });

        d = new Matrix(new double[][]{
                {1,1},
                {1,1},
                {1,1}
        });

        System.out.println(Matrix.subtract(c,d));
    }
}
