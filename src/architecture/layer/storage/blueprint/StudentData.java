package architecture.layer.storage.blueprint;

import architecture.entity.Student;

public interface StudentData {
    //
    boolean exists(String email);
    Student retrieveByEmail(String email);
}
