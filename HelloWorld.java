public class HelloWorld {

    public class Languages{
        String[] l = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    }

    // Metoda returneaza un numar intreg random
    static int randomInteger(){
        int n = (int) (Math.random() * 1_000_000);
        return n;
    }

    // Metoda calculeaza suma cifrelor in felul urmator: aflam cate cifre are numarul apoi calculam suma cifrelor
    //in functie de cate cifre are numarul
    static int sumaCifrelor(int nr){
        int aux=nr, k=0;
        while(aux!=0)
        {
            aux=aux/10;
            k++;
        }
        int suma_cif=0;
        while(k>0)
        {
            suma_cif=suma_cif+nr%10;
            nr=nr/10;
        }
        return suma_cif;
    }

    static int calcul(int n){
        n=n+3;
        String binar="10101";
        n=n+Integer.parseInt(binar,2);
        String hex="FF";
        n=n+Integer.parseInt(hex,16);
        n=n*6;
        return n;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int n=randomInteger();
        int i=calcul(n);
        int cif=sumaCifrelor(i);
    }
}
