package architecture.layer.logic;

import architecture.dto.StudentDTO;
import architecture.layer.logic.blueprint.StudentBusiness;

import java.util.List;

public class StudentBusinessLogic implements StudentBusiness {
    //
    StudentBusinessLogic(){
        //

    }

    @Override
    public StudentDTO register(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO findById(String id) {
        return null;
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        return null;
    }

    @Override
    public void modify(StudentDTO studentDTO) {

    }

    @Override
    public String remove(String email) {
        return null;
    }
}
