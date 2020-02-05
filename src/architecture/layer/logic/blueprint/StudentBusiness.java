package architecture.layer.logic.blueprint;

import architecture.dto.StudentDTO;

import java.util.List;

public interface StudentBusiness {
    //
    StudentDTO register(StudentDTO studentDTO);
    StudentDTO findById(String id);
    List<StudentDTO> findByName(String name);
    void modify(StudentDTO studentDTO);
    String remove(String email);
}
