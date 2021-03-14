package interogari;

import scoala.School;
import scoala.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindSchool {
    public void findSchools(List<Student> studentList, Map<Student, List<School>> studentPreference, School[] schools) {
        List<School> target = Arrays.asList(schools[1], schools[2]);
        List<Student> result = studentList.stream()
                .filter(s -> studentPreference.get(s).containsAll(target))
                .collect(Collectors.toList());
        System.out.println("Scolile " + schools[1].getName() + ", " + schools[2].getName() +
                " sunt preferate de elevii " + result);
    }
}
