public class Main {
    public static void main(String[] args) {
       /* double[][] d = {{1,2,3},{4,5,6},{4,5,6},{4,5,6}};
        MutableMatrix D = new MutableMatrix();
        MutableMatrix A = new MutableMatrix();
        System.out.println(A.hash_Code());
        A = (MutableMatrix) A.set_Matrix(d);
        System.out.println(A.hash_Code());
        D.set_Matrix(d);
        System.out.println(A.equals(D));
        System.out.println(A.hash_Code());
        System.out.println(D.hash_Code());
        D.get_Element(1,1);
        D.get_Raw(0);
        D.get_Column(0);
        D.set_Element(1,1,0.5);
        D.print();
        D.set_Random();
        D.print();
        D.get_Dim();
        ImmutableMatrix B = new ImmutableMatrix(2,3);
        System.out.println(B.hash_Code());
        B = (ImmutableMatrix) B.set_Random();
        System.out.println(B.hash_Code());
        B.set_Element(0,0,-2);
        B.print();
        B.get_Column(1);*/
        /*double[][] m = {{2, 2, 8, 3}, {6, 2, 3, 8}, {1, 1, 2, 1}, {0, 8, 2, 0}};
        ImmutableMatrix A = new ImmutableMatrix(2, 4);
        System.out.println(A.hash_Code());
        A = (ImmutableMatrix) A.set_Matrix(m);
        A.print();
        ImmutableMatrix B = (ImmutableMatrix) A.transpose();
        B.print();
        System.out.println(A.hash_Code());
        A = (ImmutableMatrix) A.toIdentity();
        System.out.println(A.hash_Code());
        A.print();*/
        GenMatrix<MutableMatrix> G = new GenMatrix<MutableMatrix>(2,2);
        MutableMatrix A = new MutableMatrix();
        MutableMatrix B = new MutableMatrix(3,3);
        B.set_Matrix(new double[][] {{0, 1, 2},{1, 2, 3},{0, -1, -2}});
        MutableMatrix C = new MutableMatrix(B);
        MutableMatrix D = new MutableMatrix(2,2);
        D.set_Random();
        G.set_Element(0,0, A);
        G.set_Element(0,1, B);
        G.set_Element(1,0, C);
        G.set_Element(1,1, D);
        G.print();
        G.get_Element(0,1).print();
    }
}