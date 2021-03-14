package problem.solution;

import scoala.School;
import scoala.Student;
import interogari.FindSchool;

import java.util.*;

public class Problem {
    Map<Student, List<School>> studentPreference = new HashMap<>();
    Map<School, List<Student>> schoolPreference = new TreeMap<>();

    public void showPreference(Student[] students, School[] schools, List<Student> studentList, Set<School> schoolTree) {
        studentPreference.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studentPreference.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studentPreference.put(students[2], Arrays.asList(schools[0], schools[1]));
        studentPreference.put(students[3], Arrays.asList(schools[0], schools[2]));
        System.out.println(studentPreference);

        schoolPreference.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolPreference.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPreference.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        System.out.println(schoolPreference);

        FindSchool find_School = new FindSchool();
        find_School.findSchools(studentList, studentPreference, schools);
    }
}
