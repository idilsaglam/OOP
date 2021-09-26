package tp.tp1;

public class Exercice3 {
    public static String changer(String s){
        Character[] voyelles = new Character[]{'a','e','i','o','u','y'};
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<voyelles.length; j++){
                if(s.charAt(i)==voyelles[j] && voyelles[j]=='y'){
                    s.charAt(i)='a';
                    break;
                }
                if(s.charAt(i)==voyelles[j]){
                    s.charAt(i)=voyelles[j+1];
                }

            }
        }
        return s;
    }
    public static void main(String[] args){
        for(int i=0; i<args.length; i++){
            changer(args[i]);
        }
    }
}
