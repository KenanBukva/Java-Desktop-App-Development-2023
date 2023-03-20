package six.gui.ui;

import six.gui.dao.Player;

public class PlayerWrapper {
    private final Player player;


    public PlayerWrapper(Player player){
        this.player = player;

    }

    public Object getColumValue(int index){
        switch (index){
            case 0: return player.getId();
            case 1: return player.getName();
            case 2: return player.getSurname();
            case 3: return player.getSport();
            case 4: return player.getOfYears();
            case 5: return player.getVegetarian();
            case 6: return player.getFavouriteColor();
        }
        return null;
    }

    public void setColumValue(int index, Object aValue){
        switch (index){
            case 0: player.setId((Long)aValue);break;
            case 1: player.setName((String)aValue);break;
            case 2: player.setSurname((String) aValue);break;
            case 3: player.setSport((String) aValue);break;
            case 4: player.setOfYears((Integer) aValue);break;
            case 5: player.setVegetarian((Boolean) aValue);break;
            case 6: player.setFavouriteColor((String)aValue);break;
        }
    }

}
