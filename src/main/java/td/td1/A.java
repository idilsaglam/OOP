package td.td1;

public class A {
    private int attr;
    public A(int vallue_attr){
        this.attr = vallue_attr;
    }
    public boolean egal(A b){
        return (this.attr ==b.attr);
    }
    public int getAttr(){
        return this.attr;
    }
    public String toString(){
        return "attribut: "+attr+" ";
    }
    public static void main(String[] args){
        A obj = new A(2);
        A obj2 = obj;
        A obj3 = new A(2);

        if(obj.egal(obj2)){ //1
            System.out.println("Egal");
        }else{
            System.out.println("Different");
        }

        System.out.println((obj.egal(obj2))?"Egal":"Different"); //2
        System.out.println((obj2.egal(obj3))?"Egal":"Different"); //3
        System.out.println((obj.egal(obj3))?"Egal":"Different");//4
       System.out.println((obj==obj2)?"Egal":"Different");//5
        System.out.println((obj==obj3)?"Egal":"Different");//6
        System.out.println((obj2==obj3)?"Egal":"Different");//7
        System.out.println(obj.toString());
        System.out.println(obj);

        int[] a = {};
        System.out.println(a.length);


    }
}
