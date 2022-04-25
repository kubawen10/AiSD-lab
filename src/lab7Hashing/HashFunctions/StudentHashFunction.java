package lab7Hashing.HashFunctions;

import lab7Hashing.Student;

public class StudentHashFunction implements HashFunction<Student>{
    @Override
    public int hashCode(Student object) {
        int hashCode = 0;

        hashCode ^= object.getName().hashCode();
        hashCode ^= object.getSurname().hashCode();

        //HashFunction<Integer> integerHashFunction = new IntegerHashFunction();
        hashCode ^= object.getAge();

        return hashCode;
    }
}
