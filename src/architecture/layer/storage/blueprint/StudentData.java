package architecture.layer.storage.blueprint;

import architecture.dto.StudentDTO;
import architecture.entity.Student;

import java.util.List;

public interface StudentData {
    //
    boolean exists(String email);
    Student retrieveByEmail(String email);
    Student insert(Student toStudent);
    List<Student> retrieveByName(String name);
    void update(Student toStudent);
    String delete(String email);
}
