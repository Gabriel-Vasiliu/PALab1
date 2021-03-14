package scoala;

import problem.solution.Problem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Set<School> schoolTree = new TreeSet<>();
        List<Student> studentList = new LinkedList<>();

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        Collections.addAll(studentList, students);
        List<Student> sortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);
        Collections.addAll(schoolTree, schools);
        for (School s : schools) {
            s.setCapacity(2);
        }
        schools[0].setCapacity(1);
        System.out.println(sortedList);

        Problem p = new Problem();
        p.showPreference(students, schools, studentList, schoolTree);
    }
}
