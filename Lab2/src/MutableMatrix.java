import javax.swing.tree.MutableTreeNode;

public class MutableMatrix implements Matrix{
    public int n, m;
    public double[][] a;
    MutableMatrix(int x, int y){
        this.n = x;
        this.m = y;
        this.a = new double[x][y];
    }
    MutableMatrix(MutableMatrix arr){
        this.n = arr.n;
        this.m = arr.m;
        this.a = arr.a;
    }
    MutableMatrix(ImmutableMatrix arr){
        this.n = arr.get_Dim()[0];
        this.m = arr.get_Dim()[1];
        this.a = new double[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.a[i][j] = arr.get_Element(i,j);
            }
        }
    }
    MutableMatrix(){
        this.n = 0;
        this.m = 0;
        this.a = null;
    }
    public double[] get_Column(int y){
        double[] column = new double[this.n];
        for(int i = 0; i < this.n; i++){
            System.out.print(this.a[i][y] + " ");
            column[i] = this.a[i][y];
        }
        System.out.println("\n");
        return column;
    }
    public double[] get_Raw(int x){
        double[] raw = new double[this.m];
        for(int i = 0; i < this.m; i++){
            System.out.print(this.a[x][i] + " ");
            raw[i] = this.a[x][i];
        }
        System.out.println("\n");
        return raw;
    }
    public double get_Element(int x, int y){
        System.out.print(this.a[x][y] + "\n");
        return this.a[x][y];
    }
    public Object set_Element(int x, int y, double number){
        this.a[x][y] = number;
        return this;
    }
    public Object set_Matrix(double[][] arr){
        this.n = arr.length;
        this.m = arr[0].length;
        this.a = arr;
        return this;
    }
    public Object set_Random(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] = Math.ceil(Math.random()*10);
            }
        }
        return this;
    }
    public void print(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                System.out.print((this.a)[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public int[] get_Dim(){
        System.out.print(this.n + "x" + this.m + "\n");
        int[] res = {this.n, this.m};
        return res;
    }
    public boolean equals(MutableMatrix arr){
        if(this.n != arr.n || this.m != arr.m)
            return false;
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                if(this.a[i][j] != arr.a[i][j]) return false;
            }
        }
        return true;
    }

    public boolean equals(ImmutableMatrix arr){
        if(this.n != arr.get_Dim()[0] || this.m != arr.get_Dim()[1])
            return false;
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                if(this.a[i][j] != arr.get_Element(i, j)) return false;
            }
        }
        return true;
    }
    public int hash_Code(){
        return this.hashCode();
    }

    public Object toIdentity(){
        if(this.n != this.m){
            System.out.print("Matrix is not square");
            return null;
        }
        for(int i = 0; i < this.n - 1; i++){
            if(this.a[i][i] == 0){
                boolean flag = true;
                for(int j = i + 1; j < this.n; j++){
                    if(this.a[j][i] != 0){
                        flag = false;
                        System.out.print("Swapp " + i + " and " + j + " raws\n");
                        for(int z = i; z < this.n; z++){
                            double tmp = this.a[i][z];
                            this.a[i][z] = this.a[j][z];
                            this.a[j][z] = tmp;
                        }
                        this.print();
                        break;
                    }
                    if(flag){
                        System.out.print("Matrix is not invertible!");
                        return null;
                    }
                }
            }
            for(int j = i + 1; j < this.n; j++) {
                double k = this.a[j][i] / this.a[i][i];
                if(k!=0){
                    System.out.print("Subtract " + i + " raw multiplied by " + k + " from " + j + " raw\n");
                    for(int z = i; z < this.n; z++){
                        this.a[j][z] -= k*this.a[i][z];
                    }
                    this.print();
                }
            }
        }
        for(int i = this.n - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                double k = this.a[j][i] / this.a[i][i];
                if(k!=0){
                    System.out.print("Subtract " + i + " raw multiplied by " + k + " from " + j + " raw\n");
                    for(int z = this.n - 1; z >= i; z--){
                        this.a[j][z] -= k*this.a[i][z];
                    }
                    this.print();
                }
            }
        }
        return this;
    }
    public Object transpose(){
        MutableMatrix res = new MutableMatrix(this.m, this.n);
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n; j++) {
                res.a[i][j] = this.a[j][i];
            }
        }
        return res;
    }
}
