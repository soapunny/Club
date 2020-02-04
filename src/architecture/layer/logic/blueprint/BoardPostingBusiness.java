package architecture.layer.logic.blueprint;

import architecture.dto.BoardDTO;
import architecture.dto.BoardPostingDTO;

import java.util.List;

public interface BoardPostingBusiness {
    //
    BoardDTO findBoard(String name);
    BoardPostingDTO register(String boardId, BoardPostingDTO boardPostingDTO);
    List<BoardPostingDTO> findByTitle(String boardId, String title);
    List<BoardPostingDTO> findByEmail(String boardId, String email);
    void modify(BoardPostingDTO boardPostingDTO);
    String remove(String sequence);
}
