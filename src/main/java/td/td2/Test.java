package td.td2;

public class Test {
    public static void main(String[] args){
        A u = new A(0);
        A v = new A(0);
        u.g();
        System.out.println("u: a="+u.a+",b:="+u.b);

         v.g();
        System.out.println("v: a="+v.a+",b:="+v.b);

        u.g();
        System.out.println("u: a="+u.a+",b:="+u.b);

    }   
}
