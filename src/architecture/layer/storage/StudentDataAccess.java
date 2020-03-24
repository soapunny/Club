package architecture.layer.storage;

import architecture.entity.Student;
import architecture.layer.storage.blueprint.StudentData;
import architecture.layer.storage.storage.MapStorage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDataAccess implements StudentData {
    //
    private Map<String, Student> studentMap;

    StudentDataAccess(){
        //
        studentMap = MapStorage.getInstance().getStudentMap();
    }


    @Override
    public boolean exists(String email) {
        if(studentMap.containsKey(email)){
            return true;
        }

        return false;
    }

    @Override
    public Student retrieveByEmail(String email) {
        return studentMap.get(email);
    }

    @Override
    public Student insert(Student student) {
        return studentMap.put(student.getId(), student);
    }

    @Override
    public List<Student> retrieveByName(String name) {
        return studentMap.values()
                         .stream()
                         .filter(student -> student.getName().equals(name))
                         .collect(Collectors.toList());
    }

    @Override
    public void update(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public String delete(String email) {
        return studentMap.remove(email).getName();
    }
}
