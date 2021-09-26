package tp.tp1;

public class Exercice3 {
    public static String changer(String s){
        Character[] voyelles = new Character[]{'a','e','i','o','u','y'};
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<voyelles.length; j++){
                if(s.charAt(i)==voyelles[j] && voyelles[j]=='y'){
                    s = s.substring(0,i)+'a'+s.substring(i+1);
                    break;
                }
                if(s.charAt(i)==voyelles[j]){
                    s = s.substring(0,i)+voyelles[j+1]+s.substring(i+1);
                }

            }
        }
        return s;
    }
    public static void main(String[] args){
        for(int i=0; i<args.length; i++){
            System.out.println(changer(args[i]));
        }

    }
}
