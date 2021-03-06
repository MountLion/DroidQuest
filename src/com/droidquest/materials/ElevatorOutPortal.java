package com.droidquest.materials;

import com.droidquest.Room;
import com.droidquest.items.Item;

public class ElevatorOutPortal extends Material {
    public transient Room outRoom;

    public ElevatorOutPortal() {
        super(true, false);
    }

    public void touchedByItem(Item item) {
        if (item == level().player) {
            if (outRoom == null) {
                outRoom = level().rooms.get(9);
            }
            if (outRoom == level().rooms.get(9)) {
                item.x = 15 * 28;
                item.y = 5 * 32;
                item.setRoom(outRoom);
            }
            else {
                item.x = 13 * 28;
                item.y = 5 * 32;
                item.setRoom(outRoom);
            }

        }
    }

    public void SetOutRoom(int roomNum) {
        outRoom = level().rooms.get(roomNum);
    }

}