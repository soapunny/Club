package architecture.layer.storage.blueprint;

public interface IdData {
    //
    String retrieveId(String className);
    String retrieveId(String className, String boardId);
}
