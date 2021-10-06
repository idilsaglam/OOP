package td.td2;

public class Test3b {
    public static C h(C k){
        k = new C(5);
        return k;
    }
    public static void main(String[] args){
        C k = new C(0);
        C l = h(k);
    System.out.println("k= "+k+", l= "+l);
    }
}
