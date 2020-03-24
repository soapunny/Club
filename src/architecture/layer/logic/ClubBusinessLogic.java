package architecture.layer.logic;

import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;
import architecture.dto.StudentDTO;
import architecture.entity.Club;
import architecture.exception.*;
import architecture.layer.logic.blueprint.ClubBusiness;
import architecture.layer.storage.DataAccessDistributor;
import architecture.layer.storage.blueprint.ClubData;
import architecture.layer.storage.blueprint.IdData;
import architecture.layer.storage.blueprint.StudentData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClubBusinessLogic implements ClubBusiness {
    //
    private ClubData clubData;
    private StudentData studentData;
    private IdData idData;

    ClubBusinessLogic(){
        //
        clubData = DataAccessDistributor.getInstance().getClubData();
        studentData = DataAccessDistributor.getInstance().getStudentData();
        idData = DataAccessDistributor.getInstance().getIdData();
    }

    @Override
    public ClubDTO register(ClubDTO clubDTO) {
        //check if club name is duplicated, get auto generated id from IdData
        if(clubData.exists(clubDTO.getName()))
            throw new ClubDuplicationException("The club name is already in use -> "+clubDTO.getName());
        String clubId = idData.retrieveId(Club.class.getSimpleName());
        clubDTO.setId(clubId);

        return Optional.ofNullable(clubData.insert(clubDTO.toClub()))
                       .map(club -> new ClubDTO(club))
                       .orElseThrow(()->new RegisterFailureException("Registration failed!!"));
    }

    @Override
    public ClubDTO findByClubName(String clubName) {
        //
        return Optional.ofNullable(clubData.retrieveByName(clubName))
                       .map(club -> new ClubDTO(club))
                       .orElseThrow(()-> new ClubNotFoundException("No such club using this name -> "+clubName));
    }

    @Override
    public void modify(ClubDTO clubDTO) {
        //check if the club name exists
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveByName(clubDTO.getName()))
                                    .map(club -> new ClubDTO(club))
                                    .orElseThrow(()->new ClubNotFoundException("No such club using this club name -> "+clubDTO.getName()));
        clubDTO.setId(foundClub.getId());
        clubData.update(clubDTO.toClub());
    }

    @Override
    public String remove(String clubName) {
        //check if the club name exists
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveByName(clubName))
                .map(club -> new ClubDTO(club))
                .orElseThrow(()->new ClubNotFoundException("No such club using this club name -> "+clubName));
        return Optional.ofNullable(clubData.delete(foundClub.getId()))
                       .orElseThrow(()->new RemoveFailureException("Removing failed!!"));
    }

//=====================================Member Business==========================================
    @Override
    public ClubMemberDTO registerMember(ClubMemberDTO clubMemberDTO) {
        //check if the club name exists, if the member email is not duplicated, if the email is in StudentData
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveByName(clubMemberDTO.getName()))
                                    .map(club -> new ClubDTO(club))
                                    .orElseThrow(()-> new ClubNotFoundException("No such club using this name -> "+clubMemberDTO.getClubName()));
        List<ClubMemberDTO> clubMemberDTOList = foundClub.getClubMemberDTOList()
                                                         .stream()
                                                         .filter(clubMember -> clubMember.getEmail().equals(clubMemberDTO.getEmail()))
                                                         .collect(Collectors.toList());
        if(!clubMemberDTOList.isEmpty())
            throw new ClubMemberDuplicationException("The club member's email is already in use -> "+clubMemberDTO.getEmail());
        StudentDTO foundStudent = Optional.ofNullable(studentData.retrieveByEmail(clubMemberDTO.getEmail()))
                                          .map(student->new StudentDTO(student))
                                          .orElseThrow(() -> new StudentNotFoundException("There is no student using this email -> "+clubMemberDTO.getEmail()));
        clubMemberDTO.setName(foundStudent.getName());
        foundClub.getClubMemberDTOList().add(clubMemberDTO);
        clubData.update(foundClub.toClub()); // TODO check exception

        // TODO register the member's information to the studentMap either
        return clubMemberDTO;
    }

    @Override
    public List<ClubMemberDTO> findAllMembers(String name) {
        //해당 클럽의 모든 맴버 출력
        return Optional.ofNullable(clubData.retrieveByName(name))
                        .map(club -> new ClubDTO(club).getClubMemberDTOList())
                        .orElseThrow(() -> new ClubNotFoundException("No such club using this name -> "+name));
    }

    @Override
    public void modifyMember(ClubMemberDTO clubMemberDTO) {
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveByName(clubMemberDTO.getName()))
                .map(club -> new ClubDTO(club))
                .orElseThrow(()-> new ClubNotFoundException("No such club using this name -> "+clubMemberDTO.getClubName()));
        List<ClubMemberDTO> clubMemberDTOList = foundClub.getClubMemberDTOList()
                .stream()
                .filter(clubMember -> clubMember.getEmail().equals(clubMemberDTO.getEmail()))
                .collect(Collectors.toList());
        if(clubMemberDTOList.isEmpty())
            throw new ClubMemberNotFoundException("No such club member using this email -> "+clubMemberDTO.getEmail());

        //TODO modify the student information in the studentMap either
    }

    @Override
    public String removeMember(String name, String email) {
        return null;
    }
}
