package architecture.layer.logic.blueprint;

import architecture.dto.BoardDTO;

public interface BoardBusiness {
    //
    BoardDTO register(String name, String email);
    BoardDTO findByName(String name);
    void modify(BoardDTO boardDTO);
    String remove(String name);
}
