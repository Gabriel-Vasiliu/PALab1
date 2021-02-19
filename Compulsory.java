public class Compulsory {
    public static void main(String[] args) {
        Hello a= new Hello();
        a.print();

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        Random randomInteger = new Random();
        int n = randomInteger.getRandom();

        Calcul c = new Calcul();
        int rez = c.operations(n);

        Sum sumCif = new Sum();
        System.out.println("Willy-nilly, this semester I will learn " + languages[sumCif.getSum(rez)]);
    }
}

class Hello{
    void print() {
        System.out.println("Hello World");
    }
}

//Clasa contine o functie, getRandom, care returneaza un numar random intreg.
class Random{
    int getRandom(){
        int n = (int) (Math.random() * 1_000_000);
        return n;
    }
}

//functia operations efectueaza operatiile cerute; functia Integer.parseInt transforma un string dintr-o
//baza oarecare in intreg.
class Calcul{
    int operations(int n)
    {
        int result = n * 3;
        result = result + Integer.parseInt("10101", 2);
        result = result + Integer.parseInt("FF", 16);
        result = result * 6;
        return result;
    }
}

//Functia getSum calculeaza suma cifrelor numarului n pana cand n este format dintr-o singura cifra.
class Sum{
    int getSum(int n){
        while(n>9)
        {
            int aux = 0;
            while(n > 0)
            {
                aux = aux + n % 10;
                n = n / 10;
            }
            n = aux;
        }
        return n;
    }
}