package architecture.layer.storage;

import architecture.layer.storage.blueprint.IdData;
import architecture.layer.storage.storage.MapStorage;

import java.util.Map;

public class IdDataAccess implements IdData {
    //
    private Map<String, String> nextIdMap;

    IdDataAccess(){
        //
        nextIdMap = MapStorage.getInstance().getNextIdMap();
    }

    @Override
    public String retrieveId(String className) {
        return nextId(className);
    }

    @Override
    public String retrieveId(String className, String boardId) {
        String nextId = nextId(className);
        return boardId+":"+nextId;
    }

    private String nextId(String className){
        if(!nextIdMap.containsKey(className)){
            nextIdMap.put(className, String.format("%05d", 1));
        }else{
            int nextId = Integer.valueOf(nextIdMap.get(className))+1;
            nextIdMap.put(className, String.format("%05d", nextId));
        }

        return nextIdMap.get(className);
    }
}
