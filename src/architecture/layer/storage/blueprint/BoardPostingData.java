package architecture.layer.storage.blueprint;

import architecture.dto.BoardPostingDTO;
import architecture.entity.BoardPosting;
import java.util.List;

public interface BoardPostingData {
    //
    BoardPosting insert(BoardPosting toBoardPosting);
    List<BoardPosting> retrieveByTitle(String boardId, String title);
    List<BoardPosting> retrieveByEmail(String boardId, String email);
    BoardPosting retrieveById(String sequence);
    void update(BoardPostingDTO boardPostingDTO);
    String delete(String sequence);
}
