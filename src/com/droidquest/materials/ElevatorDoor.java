package com.droidquest.materials;

import com.droidquest.avatars.GameCursor;
import com.droidquest.decorations.Graphix;
import com.droidquest.items.GenericRobot;
import com.droidquest.items.Item;
import com.droidquest.items.Magnet;

import java.awt.*;

public class ElevatorDoor extends Material {
    // This material will open or close the elevator doors based on where
    // the player is. It is sensitive to the player being inside a robot.
    private transient boolean checkedForMagnet = false;
    private transient Item magnet = null;

    public ElevatorDoor() {
        super(Color.black, true, false);
    }

    public void touchedByItem(Item item) {
        if (item.carriedBy != null) {
            return;
        }

        if (!checkedForMagnet) {
            for (int a = 0; a < level().items.size(); a++) {
                Item i = level().items.get(a);
                if (i instanceof Magnet) {
                    magnet = i;
                    checkedForMagnet = true;
                }
            }
        }

        boolean test = false;

        if (item == level().player) {
            test = true;
        }
        else if (item instanceof GenericRobot) {
            GameCursor gc = (GameCursor) level().gameCursor;
            if (gc.PlayerInRobot(null) == item) {
                test = true;
            }
        }

        Graphix gr = item.room.graphix.get(1);
        gr.x = 18 * 28;

        if (magnet != null) {
            if (magnet.room == item.room) {
                test = false;
                gr.x = 18 * 28 - 10;
            }
        }

        if (test) {
            int X = item.x / 28;
            switch (X) {
                case 3:
                    item.room.setMaterial(11, 1, 0);
                    item.room.setMaterial(11, 2, 0);
                    item.room.setMaterial(11, 3, 0);
                    item.room.setMaterial(11, 4, 0);
                    item.room.setMaterial(11, 5, 0);
                    item.room.setMaterial(11, 6, 0);
                    item.room.setMaterial(11, 7, 0);
                    item.room.setMaterial(11, 8, 0);
                    item.room.setMaterial(11, 9, 0);
                    item.room.setMaterial(11, 10, 0);
                    break;
                case 4:
                    item.room.setMaterial(11, 1, 2);
                    item.room.setMaterial(11, 2, 0);
                    item.room.setMaterial(11, 3, 0);
                    item.room.setMaterial(11, 4, 0);
                    item.room.setMaterial(11, 5, 0);
                    item.room.setMaterial(11, 6, 0);
                    item.room.setMaterial(11, 7, 0);
                    item.room.setMaterial(11, 8, 0);
                    item.room.setMaterial(11, 9, 0);
                    item.room.setMaterial(11, 10, 2);
                    break;
                case 5:
                    item.room.setMaterial(11, 1, 2);
                    item.room.setMaterial(11, 2, 2);
                    item.room.setMaterial(11, 3, 0);
                    item.room.setMaterial(11, 4, 0);
                    item.room.setMaterial(11, 5, 0);
                    item.room.setMaterial(11, 6, 0);
                    item.room.setMaterial(11, 7, 0);
                    item.room.setMaterial(11, 8, 0);
                    item.room.setMaterial(11, 9, 2);
                    item.room.setMaterial(11, 10, 2);
                    break;
                case 6:
                    item.room.setMaterial(11, 1, 2);
                    item.room.setMaterial(11, 2, 2);
                    item.room.setMaterial(11, 3, 2);
                    item.room.setMaterial(11, 4, 0);
                    item.room.setMaterial(11, 5, 0);
                    item.room.setMaterial(11, 6, 0);
                    item.room.setMaterial(11, 7, 0);
                    item.room.setMaterial(11, 8, 2);
                    item.room.setMaterial(11, 9, 2);
                    item.room.setMaterial(11, 10, 2);
                    break;
                case 7:
                    item.room.setMaterial(11, 1, 2);
                    item.room.setMaterial(11, 2, 2);
                    item.room.setMaterial(11, 3, 2);
                    item.room.setMaterial(11, 4, 2);
                    item.room.setMaterial(11, 5, 0);
                    item.room.setMaterial(11, 6, 0);
                    item.room.setMaterial(11, 7, 2);
                    item.room.setMaterial(11, 8, 2);
                    item.room.setMaterial(11, 9, 2);
                    item.room.setMaterial(11, 10, 2);
                    item.room.textBoxes.get(1).textString = "\"Hold please!\"";
                    break;
                case 8:
                    item.room.setMaterial(11, 1, 2);
                    item.room.setMaterial(11, 2, 2);
                    item.room.setMaterial(11, 3, 2);
                    item.room.setMaterial(11, 4, 2);
                    item.room.setMaterial(11, 5, 2);
                    item.room.setMaterial(11, 6, 2);
                    item.room.setMaterial(11, 7, 2);
                    item.room.setMaterial(11, 8, 2);
                    item.room.setMaterial(11, 9, 2);
                    item.room.setMaterial(11, 10, 2);
                    item.room.textBoxes.get(1).textString = "\"Going up!\"";
                    break;
            }
        }
    }

}
