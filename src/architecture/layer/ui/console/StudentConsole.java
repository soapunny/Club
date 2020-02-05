package architecture.layer.ui.console;

import architecture.dto.AddressDTO;
import architecture.dto.StudentDTO;
import architecture.entity.AddressType;
import architecture.layer.logic.BusinessLogicDistributor;
import architecture.layer.logic.blueprint.StudentBusiness;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.List;
import java.util.Scanner;

public class StudentConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private StudentBusiness studentBusiness;

    public StudentConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);

        studentBusiness = BusinessLogicDistributor.getInstance().getStudentBusiness();
    }

    public void register(){
        //
        String email = inputUtil.getValueOf("Email to register(0. Student menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;
        String name = inputUtil.getValueOf("Name to register(0. Student menu)").trim();
        if(name.isEmpty() || name.equals("0"))
            return;
        String nickname = inputUtil.getValueOf("Nickname to register(0. Student menu)").trim();
        if(nickname.isEmpty() || nickname.equals("0"))
            return;
        String birthday = inputUtil.getValueOf("Birthday to register(0. Student menu)").trim();
        if(birthday.isEmpty() || birthday.equals("0"))
            return;
        String phoneNumber = inputUtil.getValueOf("Phone number to register(0. Student menu)").trim();
        if(phoneNumber.isEmpty() || phoneNumber.equals("0"))
            return;
        String nation = inputUtil.getValueOf("Nation to register(0. Student menu)").trim();
        if(nation.isEmpty() || nation.equals("0"))
            return;
        String streetAddress = inputUtil.getValueOf("Street address to register(0. Student menu)").trim();
        if(streetAddress.isEmpty() || streetAddress.equals("0"))
            return;
        String addressType = inputUtil.getValueOf("Address type to register(HOME/OFFICE)(0. Student menu)").trim();
        if(streetAddress.isEmpty() || streetAddress.equals("0"))
            return;

        try{
            StudentDTO studentDTO = new StudentDTO(email, name, birthday, phoneNumber);
            studentDTO.setNickname(nickname);
            AddressDTO addressDTO = new AddressDTO(streetAddress);
            addressDTO.setNation(nation);
            addressDTO.setAddressType(AddressType.valueOf(addressType.toUpperCase()));
            studentDTO.getAddresses().add(addressDTO);
            StudentDTO registeredStudent = studentBusiness.register(studentDTO);
            broadcasting.broadcastln("Register Success -> "+registeredStudent);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findById() {
        //
        String id = inputUtil.getValueOf("Email(0. StudentMenu)").trim();
        if(id.isEmpty() || id.equals("0"))
            return;

        try{
            StudentDTO studentDTO = studentBusiness.findById(id);
            broadcasting.broadcastln("Found student -> "+studentDTO);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findByName() {
        //
        String name = inputUtil.getValueOf("Student name(0. Student menu)").trim();
        if(name.isEmpty() || name.equals("0"))
            return;

        try{
            List<StudentDTO> studentList = studentBusiness.findByName(name);
            if(studentList == null || studentList.isEmpty()){
                broadcasting.broadcastln("No student is found with -> "+name);
                return;
            }
            int cnt = 0;
            broadcasting.broadcastln(studentList.size()+" rows are found!!");
            for(StudentDTO studentDTO : studentList) {
                broadcasting.broadcastln("[" +(++cnt)+ "] " + studentDTO);
            }
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void modify(){
        //
        String email = inputUtil.getValueOf("Select Email to modify(0. Student menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;

        String name = inputUtil.getValueOf("Name to modify(0. Student menu, Enter. No change)").trim();
        if(name.equals("0"))
            return;
        String nickname = inputUtil.getValueOf("Nickname to modify(0. Student menu, Enter. No change)").trim();
        if(nickname.equals("0"))
            return;
        String birthday = inputUtil.getValueOf("Birthday to modify(0. Student menu, Enter. No change)").trim();
        if(birthday.equals("0"))
            return;
        String phoneNumber = inputUtil.getValueOf("Phone number to modify(0. Student menu, Enter. No change)").trim();
        if(phoneNumber.equals("0"))
            return;
        String nation = inputUtil.getValueOf("Nation to modify(0. Student menu, Enter. No change)").trim();
        if(nation.equals("0"))
            return;
        String streetAddress = inputUtil.getValueOf("Street address to modify(0. Student menu, Enter. No change)").trim();
        if(streetAddress.equals("0"))
            return;
        String addressType = inputUtil.getValueOf("Address type to modify(HOME/OFFICE)(0. Student menu, Enter. No change)").trim();
        if(streetAddress.equals("0"))
            return;

        try{
            StudentDTO studentDTO = new StudentDTO(email, name, birthday, phoneNumber);
            studentDTO.setNickname(nickname);
            AddressDTO addressDTO = new AddressDTO(streetAddress);
            addressDTO.setNation(nation);
            addressDTO.setAddressType(AddressType.valueOf(addressType.toUpperCase()));
            studentDTO.getAddresses().add(addressDTO);
            studentBusiness.modify(studentDTO);
            broadcasting.broadcastln("Modify Success!!");
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void remove(){
        //
        String email = inputUtil.getValueOf("Select Email to remove(0. Student menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;
        String confirmStr = inputUtil.getValueOf("Do you really want to remove this data?(Y:yes, N:no)").trim().toLowerCase();
        if(!confirmStr.equals("y") && !confirmStr.equals("yes")){
            broadcasting.broadcastln("Removing is cancelled!!");
            return;
        }
        try {
            String removedStudentName = studentBusiness.remove(email);
            broadcasting.broadcastln("Removed student -> "+removedStudentName);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }
}
