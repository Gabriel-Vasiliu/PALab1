package transportationProblem;

public class Solution {
    Solution(Source S1, Source S2, Source S3, Destination D1, Destination D2, Destination D3, int[][] cost){
        int totalCost = 0; //retinem costul total
        int line = 0, indexSource = 0;
        Source source; //cream un nou obiect de tip Source care ca retine atributele sursei corespunzatoare
        //algoritmul ruleaza pentru fiecare linie din matrice
        while(line <= 2){
            switch (line) {
                case 0 -> {
                    source = new Fabrica();
                    source.setCapacity(S1.getCapacity());
                    source.setName(S1.getName());
                    indexSource = 1; // retine indexul sursei pentru a modifica capacitatea
                }
                case 1 -> {
                    source = new Depozit();
                    source.setCapacity(S2.getCapacity());
                    source.setName(S2.getName());
                    indexSource = 2;
                }
                case 2 -> {
                    source = new Depozit();
                    source.setCapacity(S3.getCapacity());
                    source.setName(S3.getName());
                    indexSource = 3;
                }
                default -> source = new Depozit();
            }
            int aux_source = source.getCapacity();
            while(aux_source > 0) { // cat timp capacitatea sursei este mai mare ca 0
                int column = 0;
                int indexColumn = 0;
                int minim = Integer.MAX_VALUE;
                while (column <= 2) {  // pentru fiecare linie cautam pretul minim si retinem coloana corespunzatoare
                    if (minim > cost[line][column]) {
                        minim = cost[line][column];
                        indexColumn = column;
                    }
                    column++;
                }
                int indexDestination = 0 ; // retine indexul destinatiei pentru a modifica cererea
                Destination destination = new Destination();
                switch (indexColumn) {
                    case 0: destination.setCerere(D1.getCerere());
                        destination.setName(D1.getName());
                        indexDestination = 1;
                        break;
                    case 1: destination.setCerere(D2.getCerere());
                        destination.setName(D2.getName());
                        indexDestination = 2;
                        break;
                    case 2: destination.setCerere(D3.getCerere());
                        destination.setName(D3.getName());
                        indexDestination = 3;
                        break;
                    default: break;
                }
                int aux_destination = destination.getCerere();
                if (aux_destination > 0){
                    if(aux_destination - aux_source > 0){
                        aux_destination = aux_destination - aux_source;
                        aux_source = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + source.getCapacity() + " units * cost " + cost[line][indexColumn]
                                + " = " + source.getCapacity() * cost[line][indexColumn]);
                        totalCost = totalCost + source.getCapacity() * cost[line][indexColumn];
                    }
                    else{
                        aux_source = aux_source - aux_destination;
                        aux_destination = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + destination.getCerere() + " units * cost " + cost[line][indexColumn]
                                + " = " + destination.getCerere() * cost[line][indexColumn]);
                        totalCost = totalCost + destination.getCerere() * cost[line][indexColumn];
                    }
                    switch (indexDestination) { // modificam cererea si in destinatia initiala
                        case 1 -> D1.setCerere(aux_destination);
                        case 2 -> D2.setCerere(aux_destination);
                        case 3 -> D3.setCerere(aux_destination);
                    }
                    source.setCapacity(aux_source);
                    destination.setCerere(aux_destination);
                    switch (indexSource) { // modificam capacitatea si in sursa initiala
                        case 1 -> S1.setCapacity(aux_source);
                        case 2 -> S2.setCapacity(aux_source);
                        case 3 -> S3.setCapacity(aux_source);
                    }
                }
                cost[line][indexColumn]=Integer.MAX_VALUE; //pentru a evita gasirea de 2 ori a aceluiasi minim
            }
            line++;
        }
        System.out.println(totalCost);

    }
}
