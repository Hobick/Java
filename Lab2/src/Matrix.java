public interface Matrix {
    double[] get_Column(int n);
    double[] get_Raw(int n);
    void print();
    double get_Element(int n, int m);
    Object set_Element(int n, int m, double number);
    Object set_Matrix(double[][] arr);
    Object set_Random();
    int[] get_Dim();
    Object toIdentity();
    Object transpose();
}
