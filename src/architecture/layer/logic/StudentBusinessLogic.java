package architecture.layer.logic;

import architecture.dto.StudentDTO;
import architecture.exception.StudentDuplicationException;
import architecture.exception.StudentNotFoundException;
import architecture.layer.logic.blueprint.StudentBusiness;
import architecture.layer.storage.DataAccessDistributor;
import architecture.layer.storage.blueprint.StudentData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentBusinessLogic implements StudentBusiness {
    //
    private StudentData studentData;

    StudentBusinessLogic(){
        //
        studentData = DataAccessDistributor.getInstance().getStudentData();
    }

    @Override
    public StudentDTO register(StudentDTO studentDTO) {
        //해당 id의 학생이 있는지 확인
        if(studentData.exists(studentDTO.getId())){
            throw new StudentDuplicationException("There is a student using this email -> "+studentDTO.getId());
        }
        return new StudentDTO(studentData.insert(studentDTO.toStudent()));
    }

    @Override
    public StudentDTO findById(String id) {
        return Optional.ofNullable(studentData.retrieveByEmail(id))
                       .map(student -> new StudentDTO(student))
                       .orElseThrow(()->new StudentNotFoundException("There is no student using this email -> "+id));
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        return studentData.retrieveByName(name)
                          .stream()
                          .map(student -> new StudentDTO(student))
                          .collect(Collectors.toList());
    }

    @Override
    public void modify(StudentDTO studentDTO) {
        studentData.update(studentDTO.toStudent());
    }

    @Override
    public String remove(String email) {
        return studentData.delete(email);
    }
}
