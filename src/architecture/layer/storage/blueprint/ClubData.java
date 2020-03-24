package architecture.layer.storage.blueprint;

import architecture.entity.Club;

public interface ClubData {
    //
    boolean exists(String name);
    Club retrieveByName(String name);
    Club retrieveById(String id);
    Club insert(Club club);
    void update(Club clubDTO);
    String delete(String id);
}
