package com.droidquest.materials;

import com.droidquest.Room;
import com.droidquest.items.Item;

import java.awt.*;

public class MineField extends Material {
    private int hit = 0;
    private Item target = null;

    public MineField() {
        super(Color.black, false, false);
    }

    public boolean passable(Item item) {
        hit += 2;
        target = item;
        return false;
    }

    public void animate() {
        if (hit > 0) {
            hit--;
        }
        if (hit >= 2) {
            target.room = level().rooms.get(58);
            target.charge = 0;
            if (target.InternalRoom != null) {
                Room room = target.InternalRoom;
                if (room.wires.size() > 0) {
                    for (int a = 0; a < room.wires.size(); a++) {
                        room.wires.get(0).remove();
                    }
                }
            }
        }
    }

}
