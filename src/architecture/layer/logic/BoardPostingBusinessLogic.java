package architecture.layer.logic;

import architecture.dto.BoardDTO;
import architecture.dto.BoardPostingDTO;
import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;
import architecture.entity.BoardPosting;
import architecture.exception.*;
import architecture.layer.logic.blueprint.BoardPostingBusiness;
import architecture.layer.storage.DataAccessDistributor;
import architecture.layer.storage.blueprint.BoardData;
import architecture.layer.storage.blueprint.BoardPostingData;
import architecture.layer.storage.blueprint.ClubData;
import architecture.layer.storage.blueprint.IdData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardPostingBusinessLogic implements BoardPostingBusiness {
    //
    private BoardPostingData boardPostingData;
    private BoardData boardData;
    private ClubData clubData;
    private IdData idData;

    BoardPostingBusinessLogic(){
        //
        boardPostingData = DataAccessDistributor.getInstance().getBoardPostingData();
        boardData = DataAccessDistributor.getInstance().getBoardData();
        clubData = DataAccessDistributor.getInstance().getClubData();
        idData = DataAccessDistributor.getInstance().getIdData();
    }

    @Override
    public BoardDTO findBoard(String name) {
        //check if the board exists
        return Optional.ofNullable(boardData.retrieveByName(name))
                       .map(board -> new BoardDTO(board))
                       .orElseThrow(()->new BoardNotFoundException("No such board using this board name -> "+name));
    }

    @Override
    public BoardPostingDTO register(String boardId, BoardPostingDTO boardPostingDTO) {
        //Check if the writer's email is available, give the boardPostingDTO an id
        ClubDTO clubDTO = new ClubDTO(clubData.retrieveById(boardId));
        List<ClubMemberDTO> foundClubMember = clubDTO.getClubMemberDTOList()
                                                     .stream()
                                                     .filter(clubMemberDTO -> clubMemberDTO.getEmail().equals(boardPostingDTO.getWriterEmail()))
                                                     .collect(Collectors.toList());
        if(foundClubMember.isEmpty()) throw new ClubMemberNotFoundException("You're not a club member -> "+boardPostingDTO.getWriterEmail());
        String id = idData.retrieveId(BoardPosting.class.getSimpleName(), boardId);
        boardPostingDTO.setId(id);
        boardPostingDTO.setBoardId(boardId);
        return Optional.ofNullable(boardPostingData.insert(boardPostingDTO.toBoardPosting()))
                       .map(boardPosting -> new BoardPostingDTO(boardPosting))
                       .orElseThrow(()->new RegisterFailureException("Registration Failed!!"));
    }

    @Override
    public List<BoardPostingDTO> findByTitle(String boardId, String title) {
        //
        return Optional.ofNullable(boardPostingData.retrieveByTitle(boardId, title)
                                                   .stream()
                                                   .map(boardPosting -> new BoardPostingDTO(boardPosting))
                                                   .collect(Collectors.toList()))
                       .orElseThrow(()->new FindFailureException("Finding failed!!"));
    }

    @Override
    public List<BoardPostingDTO> findByEmail(String boardId, String email) {
        //
        return Optional.ofNullable(boardPostingData.retrieveByEmail(boardId, email)
                                                   .stream()
                                                   .map(boardPosting -> new BoardPostingDTO(boardPosting))
                                                   .collect(Collectors.toList()))
                       .orElseThrow(()->new FindFailureException("Finding failed!!"));
    }

    @Override
    public void modify(BoardPostingDTO boardPostingDTO) {
        //check if there is a board posting using this sequence
        String sequence = boardPostingDTO.getId();
        BoardPostingDTO foundBoardPosting = Optional.ofNullable(boardPostingData.retrieveById(sequence))
                                                    .map(boardPosting->new BoardPostingDTO(boardPosting))
                                                    .orElseThrow(()->new BoardPostingNotFoundException("No such board posting exists -> "+sequence));
        if(boardPostingDTO.getTitle() == null || boardPostingDTO.getTitle().length() == 0)
            boardPostingDTO.setTitle(foundBoardPosting.getTitle());
        if(boardPostingDTO.getContents() == null || boardPostingDTO.getContents().length() == 0)
            boardPostingDTO.setContents(foundBoardPosting.getContents());
        boardPostingDTO.setWriterEmail(foundBoardPosting.getWriterEmail());
        boardPostingDTO.setWrittenDate(foundBoardPosting.getWrittenDate());

        boardPostingData.update(boardPostingDTO.toBoardPosting());
    }

    @Override
    public String remove(String sequence) {
        //
        return Optional.ofNullable(boardPostingData.delete(sequence))
                       .orElseThrow(()->new RemoveFailureException("Removing failed"));
    }
}
