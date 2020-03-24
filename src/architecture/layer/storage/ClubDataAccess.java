package architecture.layer.storage;

import architecture.entity.Club;
import architecture.layer.storage.blueprint.ClubData;
import architecture.layer.storage.storage.MapStorage;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class ClubDataAccess implements ClubData {
    //
    private Map<String, Club> clubMap;

    ClubDataAccess(){
        //
        clubMap = MapStorage.getInstance().getClubMap();
    }

    @Override
    public boolean exists(String name) {
        if(clubMap.values().stream().filter(club -> club.getName().equals(name)).collect(Collectors.toList()).isEmpty()){
            return false;
        }

        return true;
    }

    @Override
    public Club retrieveByName(String name) {
        Iterator<Club> clubIterator = clubMap.values().iterator();
        while(clubIterator.hasNext()){
            Club club = clubIterator.next();
            if(club.getName().equals(name)){
                return club;
            }
        }

        return null;
    }

    @Override
    public Club retrieveById(String id) {
        return clubMap.get(id);
    }

    @Override
    public Club insert(Club club) {
        return clubMap.put(club.getAutoId(), club);
    }

    @Override
    public void update(Club club) {
        clubMap.put(club.getAutoId(), club);
    }

    @Override
    public String delete(String id) {
        return clubMap.remove(id).getName();
    }
}
