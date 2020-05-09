package kalah;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<House> houseList1;
    List<House> houseList2;
    Store store1;
    Store store2;

    public Board(){
        houseList1 = new ArrayList<House>();
        houseList2 = new ArrayList<House>();
        store1 = new Store();
        store2 = new Store();
    }

    public int MoveSeeds(int houseIndex, int playerNum){
        List<House> ownHouseList;
        List<House> otherHouseList;
        Store store;
        switch(playerNum) {
            case 1:
                ownHouseList = houseList1;
                otherHouseList = houseList2;
                store = store1;
                break;
            case 2:
                ownHouseList = houseList2;
                otherHouseList = houseList1;
                store = store2;
                break;
            default:
                ownHouseList = houseList1;
                otherHouseList = houseList2;
                store = store1;
                break;
        }
        int remainingSeeds = ownHouseList.get(houseIndex).GetSeeds();
        String phase = "ownHouses";
        ownHouseList.get(houseIndex).RemoveSeeds(remainingSeeds);
        while (remainingSeeds > 0){
            switch(phase){
                case("ownHouses"):
                    for(House house: ownHouseList) {
                        if (remainingSeeds > 0) {
                            house.AddSeeds(1);
                            remainingSeeds += -1;
                        }
                    }
                    if (remainingSeeds == 0){
                        break;
                    } else {
                        phase = "ownStore";
                    }
                    break;

                case("ownStore"):
                    if(remainingSeeds > 0) {
                        store.AddSeeds(1);
                        remainingSeeds += -1;
                    }
                    if (remainingSeeds == 0){
                        break;
                    } else {
                        phase = "otherHouses";
                    }
                break;

                case("otherHouses"):
                    for(House house: otherHouseList) {
                        if (remainingSeeds > 0) {
                            house.AddSeeds(1);
                            remainingSeeds += -1;
                        }
                    }
                    if (remainingSeeds == 0){
                        break;
                    } else {
                        phase = "ownHouses";
                    }
                    break;
            }
            // Check for end of turn conditions
            //1
            if (phase == "otherHouses"){
                // It's now the other player's turn
                if (playerNum == 1){
                    return 2;
                } else {
                    return 1;
                }
            }

        }



    }
}