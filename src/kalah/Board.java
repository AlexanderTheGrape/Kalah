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
            default:
                ownHouseList = houseList1;
                otherHouseList = houseList2;
                store = store1;
                break;
            case 2:
                ownHouseList = houseList2;
                otherHouseList = houseList1;
                store = store2;
                break;
        }
        int remainingSeeds = ownHouseList.get(houseIndex).GetSeeds();
        int listSize = ownHouseList.size();
        String phase = "ownHouses";
        ownHouseList.get(houseIndex).RemoveSeeds(remainingSeeds);
        while (remainingSeeds > 0) {
            switch (phase) {
                case ("ownHouses"):
                    for (; houseIndex < listSize; houseIndex++) {
                        if (remainingSeeds > 0) {
                            ownHouseList.get(houseIndex).AddSeeds(1);
                            remainingSeeds += -1;
                        }
                    }
                    if (remainingSeeds == 0) {
                        break;
                    } else {
                        phase = "ownStore";
                    }
                    break;

                case ("ownStore"):
                    if (remainingSeeds > 0) {
                        store.AddSeeds(1);
                        remainingSeeds += -1;
                    }
                    if (remainingSeeds == 0) {
                        break;
                    } else {
                        phase = "otherHouses";
                        houseIndex = 0;
                    }
                    break;

                case ("otherHouses"):
                    for (; houseIndex < listSize; houseIndex++) {
                        if (remainingSeeds > 0) {
                            ownHouseList.get(houseIndex).AddSeeds(1);
                            remainingSeeds += -1;
                        }
                    }
                    if (remainingSeeds == 0) {
                        break;
                    } else {
                        phase = "ownHouses";
                        houseIndex = 0;
                    }
                    break;
            }
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
        //2
        if (phase == "ownStore"){
            return playerNum;
        }
        //3
        if (phase == "ownHouses"){
            if (ownHouseList.get(houseIndex).GetSeeds() <= 1){
                if (otherHouseList.get(listSize - houseIndex - 1).GetSeeds() >= 1){
                    int capturedSeeds = otherHouseList.get(listSize - houseIndex - 1).GetSeeds();
                    otherHouseList.get(listSize - houseIndex - 1).RemoveSeeds(capturedSeeds);
                    store.AddSeeds(capturedSeeds);
                    ownHouseList.get(houseIndex).RemoveSeeds(1);
                    store.AddSeeds(1);
                }
            }
            // It's now the other player's turn
            if (playerNum == 1){
                return 2;
            } else {
                return 1;
            }
        }
        //this case should never happen
        return 1;
    }

    public boolean checkForEndCondition(int finishingPlayer){
        List<House> houseList;

        if (finishingPlayer == 1){
            houseList = houseList1;
        } else {
            houseList = houseList2;
        }

        //
        for (House house : houseList){
            if (house.GetSeeds() > 0){
                //game can continue
                return false;
            }
        }
        return true;
    }


}