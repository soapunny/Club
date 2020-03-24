package architecture.layer.storage;

import architecture.entity.BoardPosting;
import architecture.layer.storage.blueprint.BoardPostingData;
import architecture.layer.storage.storage.MapStorage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardPostingDataAccess implements BoardPostingData {
    //
    private Map<String, BoardPosting> boardPostingMap;

    BoardPostingDataAccess(){
        //
        boardPostingMap = MapStorage.getInstance().getBoardPostingMap();
    }

    @Override
    public BoardPosting insert(BoardPosting boardPosting) {
        return boardPostingMap.put(boardPosting.getAutoId(), boardPosting);
    }

    @Override
    public List<BoardPosting> retrieveByTitle(String boardId, String title) {
        return boardPostingMap.values()
                              .stream()
                              .filter(boardPosting -> boardPosting.getBoardId().equals(boardId) && boardPosting.getTitle().equals(title))
                              .collect(Collectors.toList());
    }

    @Override
    public List<BoardPosting> retrieveByEmail(String boardId, String email) {
        return boardPostingMap.values()
                .stream()
                .filter(boardPosting -> boardPosting.getBoardId().equals(boardId) && boardPosting.getWriterEmail().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public BoardPosting retrieveById(String sequence) {
        return boardPostingMap.get(sequence);
    }

    @Override
    public void update(BoardPosting boardPosting) {
        boardPostingMap.put(boardPosting.getAutoId(), boardPosting);
    }

    @Override
    public String delete(String sequence) {
        return boardPostingMap.remove(sequence).getTitle();
    }
}
