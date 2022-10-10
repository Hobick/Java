public class ImmutableMatrix implements Matrix{
    private final int n, m;
    private final double[][] a;
    ImmutableMatrix(int x, int y){
        this.n = x;
        this.m = y;
        this.a = new double[x][y];
    }
    ImmutableMatrix(ImmutableMatrix arr){
        this.n = arr.n;
        this.m = arr.m;
        this.a = arr.a;
    }
    ImmutableMatrix(MutableMatrix arr){
        this.n = arr.n;
        this.m = arr.m;
        this.a = arr.a;
    }
    ImmutableMatrix(){
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
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                res.a[i][j] = this.a[i][j];
            }
        }
        res.a[x][y] = number;
        return res;
    }
    public Object set_Matrix(double[][] arr){
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j <this.m; j++){
                res.a[i][j] = arr[i][j];
            }
        }
        return res;
    }
    public Object set_Random(){
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                res.a[i][j] = Math.ceil(Math.random()*10);
            }
        }
        return res;
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
    public boolean equals(ImmutableMatrix arr){
        if(this.n != arr.n || this.m != arr.m)
            return false;
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                if(this.a[i][j] != arr.a[i][j]) return false;
            }
        }
        return true;
    }
    public int hash_Code(){
        return this.hashCode();
    }
    public Object toIdentity(){
        ImmutableMatrix res = new ImmutableMatrix(this);
        if(res.n != res.m){
            System.out.print("Matrix is not square");
            return null;
        }
        for(int i = 0; i < res.n - 1; i++){
            if(res.a[i][i] == 0){
                boolean flag = true;
                for(int j = i + 1; j < res.n; j++){
                    if(res.a[j][i] != 0){
                        flag = false;
                        System.out.print("Swapp " + i + " and " + j + " raws\n");
                        for(int z = i; z < res.n; z++){
                            double tmp = res.a[i][z];
                            res.a[i][z] = res.a[j][z];
                            res.a[j][z] = tmp;
                        }
                        res.print();
                        break;
                    }
                    if(flag){
                        System.out.print("Matrix is not invertible!");
                        return null;
                    }
                }
            }
            for(int j = i + 1; j < res.n; j++) {
                double k = res.a[j][i] / res.a[i][i];
                if(k!=0){
                    System.out.print("Subtract " + i + " raw multiplied by " + k + " from " + j + " raw\n");
                    for(int z = i; z < res.n; z++){
                        res.a[j][z] -= k*res.a[i][z];
                    }
                    res.print();
                }
            }
        }
        for(int i = res.n - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                double k = res.a[j][i] / res.a[i][i];
                if(k!=0){
                    System.out.print("Subtract " + i + " raw multiplied by " + k + " from " + j + " raw\n");
                    for(int z = res.n - 1; z >= i; z--){
                        res.a[j][z] -= k*res.a[i][z];
                    }
                    res.print();
                }
            }
        }
        return res;
    }
    public Object transpose(){
        ImmutableMatrix res = new ImmutableMatrix(this.m, this.n);
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n; j++) {
                res.a[i][j] = this.a[j][i];
            }
        }
        return res;
    }
}
