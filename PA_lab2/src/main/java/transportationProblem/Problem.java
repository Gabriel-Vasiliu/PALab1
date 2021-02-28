package transportationProblem;

public class Problem {
    int totalCost = 0;

    Problem() {
    }

    void printSolution(Source s1, Source s2, Source s3, Destination d1, Destination d2, Destination d3, int[][] cost) {
        int line = 0, indexSource = 0;
        while (line <= 2) {
            Source source = new Source();
            switch (line) {
                case 0 -> {
                    source.setCapacity(s1.getCapacity());
                    source.setName(s1.getName());
                    indexSource = 1;
                }
                case 1 -> {
                    source.setCapacity(s2.getCapacity());
                    source.setName(s2.getName());
                    indexSource = 2;
                }
                case 2 -> {
                    source.setCapacity(s3.getCapacity());
                    source.setName(s3.getName());
                    indexSource = 3;
                }
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
                        destination.setCerere(d1.getCerere());
                        destination.setName(d1.getName());
                        indexDestination = 1;
                        break;
                    case 1:
                        destination.setCerere(d2.getCerere());
                        destination.setName(d2.getName());
                        indexDestination = 2;
                        break;
                    case 2:
                        destination.setCerere(d3.getCerere());
                        destination.setName(d3.getName());
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
                        case 1 -> d1.setCerere(auxDestination);
                        case 2 -> d2.setCerere(auxDestination);
                        case 3 -> d3.setCerere(auxDestination);
                    }
                    source.setCapacity(auxSource);
                    destination.setCerere(auxDestination);
                    switch (indexSource) {
                        case 1 -> s1.setCapacity(auxSource);
                        case 2 -> s2.setCapacity(auxSource);
                        case 3 -> s3.setCapacity(auxSource);
                    }
                }
                cost[line][indexColumn] = Integer.MAX_VALUE;
            }
            line++;
        }
        System.out.println(totalCost);
    }
}
