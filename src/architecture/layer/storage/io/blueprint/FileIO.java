package architecture.layer.storage.io.blueprint;

import architecture.layer.storage.io.ServiceType;

public interface FileIO {
    //
    Object readFile(String key);
    void writeFile(Object DTO);
}
