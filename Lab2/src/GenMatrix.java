public class GenMatrix<T> {
    public int n,m;
    public T[][] a;
    GenMatrix(int x, int y){
        this.n = x;
        this.m = y;
        this.a = (T[][]) new Object[x][y];
    }
    public void set_Element(int x, int y, T obj){
        this.a[x][y] = obj;
    }
    public T get_Element(int x, int y){
        System.out.println(this.a[x][y]);
        return this.a[x][y];
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
}
