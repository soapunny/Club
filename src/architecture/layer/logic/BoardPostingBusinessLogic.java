package architecture.layer.logic;

import architecture.dto.BoardDTO;
import architecture.dto.BoardPostingDTO;
import architecture.layer.logic.blueprint.BoardPostingBusiness;

import java.util.List;

public class BoardPostingBusinessLogic implements BoardPostingBusiness {
    //
    BoardPostingBusinessLogic(){
        //

    }

    @Override
    public BoardDTO findBoard(String name) {
        return null;
    }

    @Override
    public BoardPostingDTO register(String boardId, BoardPostingDTO boardPostingDTO) {
        return null;
    }

    @Override
    public List<BoardPostingDTO> findByTitle(String boardId, String title) {
        return null;
    }

    @Override
    public List<BoardPostingDTO> findByEmail(String boardId, String email) {
        return null;
    }

    @Override
    public void modify(BoardPostingDTO boardPostingDTO) {

    }

    @Override
    public String remove(String sequence) {
        return null;
    }
}
