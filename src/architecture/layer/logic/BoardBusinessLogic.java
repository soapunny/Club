package architecture.layer.logic;

import architecture.dto.BoardDTO;
import architecture.layer.logic.blueprint.BoardBusiness;

public class BoardBusinessLogic implements BoardBusiness {
    //
    BoardBusinessLogic(){
        //

    }

    @Override
    public BoardDTO register(String name, String email) {
        return null;
    }

    @Override
    public BoardDTO findByName(String name) {
        return null;
    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

    @Override
    public String remove(String name) {
        return null;
    }
}
