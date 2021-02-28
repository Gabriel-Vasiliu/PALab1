package transportationProblem;

public class Solution {
    Solution(Source S1, Source S2, Source S3, Destination D1, Destination D2, Destination D3, int[][] cost) {
        int totalCost = 0;
        int line = 0, indexSource = 0;
        Source source;
        while (line <= 2) {
            switch (line) {
                case 0 -> {
                    source = new Fabrica();
                    source.setCapacity(S1.getCapacity());
                    source.setName(S1.getName());
                    indexSource = 1;
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
            int auxSource = source.getCapacity();
            while (auxSource > 0) {
                int column = 0;
                int indexColumn = 0;
                int minim = Integer.MAX_VALUE;
                while (column <= 2) {
                    if (minim > cost[line][column]) {
                        minim = cost[line][column];
                        indexColumn = column;
                    }
                    column++;
                }
                int indexDestination = 0;
                Destination destination = new Destination();
                switch (indexColumn) {
                    case 0:
                        destination.setCerere(D1.getCerere());
                        destination.setName(D1.getName());
                        indexDestination = 1;
                        break;
                    case 1:
                        destination.setCerere(D2.getCerere());
                        destination.setName(D2.getName());
                        indexDestination = 2;
                        break;
                    case 2:
                        destination.setCerere(D3.getCerere());
                        destination.setName(D3.getName());
                        indexDestination = 3;
                        break;
                    default:
                        break;
                }
                int auxDestination = destination.getCerere();
                if (auxDestination > 0) {
                    if (auxDestination - auxSource > 0) {
                        auxDestination = auxDestination - auxSource;
                        auxSource = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + source.getCapacity() + " units * cost " + cost[line][indexColumn]
                                + " = " + source.getCapacity() * cost[line][indexColumn]);
                        totalCost = totalCost + source.getCapacity() * cost[line][indexColumn];
                    } else {
                        auxSource = auxSource - auxDestination;
                        auxDestination = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + destination.getCerere() + " units * cost " + cost[line][indexColumn]
                                + " = " + destination.getCerere() * cost[line][indexColumn]);
                        totalCost = totalCost + destination.getCerere() * cost[line][indexColumn];
                    }
                    switch (indexDestination) {
                        case 1 -> D1.setCerere(auxDestination);
                        case 2 -> D2.setCerere(auxDestination);
                        case 3 -> D3.setCerere(auxDestination);
                    }
                    source.setCapacity(auxSource);
                    destination.setCerere(auxDestination);
                    switch (indexSource) {
                        case 1 -> S1.setCapacity(auxSource);
                        case 2 -> S2.setCapacity(auxSource);
                        case 3 -> S3.setCapacity(auxSource);
                    }
                }
                cost[line][indexColumn] = Integer.MAX_VALUE;
            }
            line++;
        }
        System.out.println(totalCost);

    }
}
