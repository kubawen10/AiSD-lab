package lab7Hashing.Comparators;

import lab7Hashing.Student;

import java.util.Comparator;
import java.util.List;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int comp;

        comp = o1.getSurname().compareTo(o2.getSurname());
        if(comp!=0)return comp;

        comp = o1.getName().compareTo(o2.getName());
        if(comp!=0)return comp;

        Comparator<Integer> integerComparator = new IntegerComparator();
        comp = integerComparator.compare(o1.getAge(), o2.getAge());
        if(comp!=0)return comp;

        if(o1.getGrades().size()>o2.getGrades().size()){
            return 1;
        }else if(o1.getGrades().size()<o2.getGrades().size()){
            return -1;
        }else{
            List<Integer> g1 = o1.getGrades();
            List<Integer> g2 = o2.getGrades();

            for (int i = 0; i < o1.getGrades().size(); i++) {
                if(g1.get(i) > g2.get(i)){
                    return 1;
                }
                else if(g1.get(i) < g2.get(i)){
                    return -1;
                }
            }
        }

        return 0;
    }
}
