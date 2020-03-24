package architecture.layer.storage;

import architecture.entity.Board;
import architecture.layer.storage.blueprint.BoardData;
import architecture.layer.storage.storage.MapStorage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BoardDataAccess implements BoardData {
    //
    private Map<String, Board> boardMap;

    BoardDataAccess(){
        //
        boardMap = MapStorage.getInstance().getBoardMap();
    }

    @Override
    public boolean exists(String boardName) {
        Iterator<Board> boardIterator = boardMap.values().iterator();
        while(boardIterator.hasNext()){
            Board board = boardIterator.next();
            if(board.getName().equals(boardName))
                return true;
        }

        return false;
    }

    @Override
    public void insert(Board board) {
        boardMap.put(board.getId(), board);
    }

    @Override
    public List<Board> retrieveAll() {
        return new ArrayList<>(boardMap.values());
    }

    @Override
    public Board retrieveById(String id) {
        return boardMap.get(id);
    }

    @Override
    public Board retrieveByName(String name) {
        Iterator<Board> boardIterator = boardMap.values().iterator();
        while(boardIterator.hasNext()){
            Board board = boardIterator.next();
            if(board.getName().equals(name))
                return board;
        }

        return null;
    }

    @Override
    public void update(Board board) {
        boardMap.put(board.getId(), board);
    }

    @Override
    public String remove(String id) {
        return boardMap.remove(id).getName();
    }
}
