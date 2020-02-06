package architecture.layer.storage.blueprint;

import architecture.dto.BoardDTO;
import architecture.entity.Board;
import java.util.List;

public interface BoardData {
    //
    boolean exists(String boardName);
    void insert(Board board);
    List<Board> retrieveAll();
    Board retrieveById(String id);
    Board retrieveByName(String name);
    void update(Board board);
    String remove(String id);
}
