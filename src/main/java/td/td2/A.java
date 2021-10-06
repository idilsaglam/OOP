package td.td2;

public class A {
    public static  int a=3;
    public int b;

    public A(int c){
        this.b = c;
    }
    public void g(){
        a=a+1;
        b=b+1;
    }

    public static void h(){
        //1. On peut utiliser le champs 'a' mais pos 'b'
    }
    public void h1(){
        //On peut utiliser toutes les champs qui sont définis dans la classe A
    }

}
