package architecture.layer.storage.blueprint;

import architecture.entity.BoardPosting;
import java.util.List;

public interface BoardPostingData {
    //
    BoardPosting insert(BoardPosting BoardPosting);
    List<BoardPosting> retrieveByTitle(String boardId, String title);
    List<BoardPosting> retrieveByEmail(String boardId, String email);
    BoardPosting retrieveById(String sequence);
    void update(BoardPosting boardPosting);
    String delete(String sequence);
}
