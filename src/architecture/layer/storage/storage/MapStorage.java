package architecture.layer.storage.storage;

import architecture.entity.Board;
import architecture.entity.BoardPosting;
import architecture.entity.Club;
import architecture.entity.Student;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage {
    //Map들을 저장하고 있는 class
    private static MapStorage instance;

    private Map<String, String> nextIdMap;
    private Map<String, Club> clubMap;
    private Map<String, Board> boardMap;
    private Map<String, BoardPosting> boardPostingMap;
    private Map<String, Student> studentMap;

    public MapStorage(){
        //
        nextIdMap = new LinkedHashMap<>();
        clubMap = new LinkedHashMap<>();
        boardMap = new LinkedHashMap<>();
        boardPostingMap = new LinkedHashMap<>();
        studentMap = new LinkedHashMap<>();
    }

    public static MapStorage getInstance(){
        synchronized (MapStorage.class){
            if(instance == null){
                instance = new MapStorage();
            }
        }

        return instance;
    }

    public Map<String, String> getNextIdMap() {
        return nextIdMap;
    }
    public Map<String, Club> getClubMap() {
        return clubMap;
    }
    public Map<String, Board> getBoardMap() {
        return boardMap;
    }
    public Map<String, BoardPosting> getBoardPostingMap() {
        return boardPostingMap;
    }
    public Map<String, Student> getStudentMap() {
        return studentMap;
    }
}
