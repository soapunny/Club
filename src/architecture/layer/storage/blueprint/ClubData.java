package architecture.layer.storage.blueprint;

import architecture.dto.ClubDTO;
import architecture.entity.Club;

public interface ClubData {
    //
    boolean exists(String name);
    Club retrieveByName(String name);
    Club retrieveById(String id);
    Club insert(Club toClub);
    void update(ClubDTO clubDTO);
    String delete(String id);
}
