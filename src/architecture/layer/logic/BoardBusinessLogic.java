package architecture.layer.logic;

import architecture.dto.BoardDTO;
import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;
import architecture.entity.Position;
import architecture.exception.*;
import architecture.layer.logic.blueprint.BoardBusiness;
import architecture.layer.storage.DataAccessDistributor;
import architecture.layer.storage.blueprint.BoardData;
import architecture.layer.storage.blueprint.ClubData;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardBusinessLogic implements BoardBusiness {
    //
    private BoardData boardData;
    private ClubData clubData;

    BoardBusinessLogic(){
        //
        boardData = DataAccessDistributor.getInstance().getBoardData();
        clubData = DataAccessDistributor.getInstance().getClubData();
    }

    @Override
    public BoardDTO register(String clubName, String boardName, String adminEmail) {
        //Club name(check if it exists, if it has a board already)
        //Board name(must be an unique datum), admin email(must be a club member(MANAGER))
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveByName(clubName))
                                    .map(club -> new ClubDTO(club))
                                    .orElseThrow(()->new ClubNotFoundException("There is no club with this name -> "+clubName));
        List<BoardDTO> foundDuplicatedBoard = boardData.retrieveAll()
                                                       .stream()
                                                       .filter(board -> board.getId().equals(foundClub.getId()))
                                                       .map(board -> new BoardDTO(board)).collect(Collectors.toList());
        if(!foundDuplicatedBoard.isEmpty()) throw new BoardDuplicationException("The club name already has a board -> "+clubName);
        List<ClubMemberDTO> foundMember = foundClub.getClubMemberDTOList()
                                                   .stream()
                                                   .filter(clubMemberDTO -> clubMemberDTO.getEmail().equals(adminEmail))
                                                   .collect(Collectors.toList());
        if(foundMember.isEmpty()) throw new ClubMemberNotFoundException("No such member using this email -> "+adminEmail);
        if(foundMember.get(0).getPosition() != Position.MANAGER)
            throw new HasNoRightException("Only the manager can create the club board!!");
        if(boardData.exists(boardName)) throw new BoardDuplicationException("Board name is already being used!! -> "+boardName);

        BoardDTO boardDTO = new BoardDTO(boardName, adminEmail);
        boardDTO.setId(foundClub.getId());

        boardData.insert(boardDTO.toBoard());
        BoardDTO foundBoard = Optional.ofNullable(boardData.retrieveById(boardDTO.getId()))
                                      .map(board -> new BoardDTO(board))
                                      .orElseThrow(()->new BoardNotFoundException("The board is not created -> "+boardName));
        return foundBoard;
    }

    @Override
    public BoardDTO findByName(String name) {
        //check if it has a board using this name.
        BoardDTO foundBoard = Optional.ofNullable(boardData.retrieveByName(name))
                                      .map(board -> new BoardDTO(board))
                                      .orElseThrow(()->new BoardNotFoundException("No such board using this name -> "+name));
        return foundBoard;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        //check if it has a board using this name
        //check if the adminEmail is on the club member list(as a manager)
        BoardDTO foundBoard = Optional.ofNullable(boardData.retrieveByName(boardDTO.getName()))
                .map(board -> new BoardDTO(board))
                .orElseThrow(()->new BoardNotFoundException("No such board using this name -> "+boardDTO.getName()));
        ClubDTO foundClub = Optional.ofNullable(clubData.retrieveById(foundBoard.getId()))
                                    .map(club -> new ClubDTO(club))
                                    .orElseThrow(()->new ClubNotFoundException("No such club using this id -> "+foundBoard.getId()));

        boardDTO.setId(foundBoard.getId());
        if(boardDTO.getAdminEmail() == null || boardDTO.getAdminEmail().equals("")){
            boardDTO.setAdminEmail(foundBoard.getAdminEmail());
        }else {
            List<ClubMemberDTO> foundMember = foundClub.getClubMemberDTOList()
                                                       .stream()
                                                       .filter(clubMemberDTO -> clubMemberDTO.getEmail().equals(boardDTO.getAdminEmail()))
                                                       .collect(Collectors.toList());
            if (foundMember.isEmpty())
                throw new ClubMemberNotFoundException("No such member using this email -> " + boardDTO.getAdminEmail());
            if (foundMember.get(0).getPosition() != Position.MANAGER)
                throw new HasNoRightException("Only the manager can be a manager of the club board!!");
        }
        if(boardDTO.getFoundationDay() == null || boardDTO.getFoundationDay().equals("")){
            boardDTO.setFoundationDay(foundBoard.getFoundationDay());
        }

        boardData.update(boardDTO.toBoard());
    }

    @Override
    public String remove(String name) {
        //check if a board exists using this board name
        if(!boardData.exists(name))
            throw new BoardNotFoundException("The board name is not in service -> "+name);
        BoardDTO foundBoard = new BoardDTO(boardData.retrieveByName(name));
        String removedBoardName = boardData.remove(foundBoard.getId());
        return removedBoardName;
    }
}
