package com.droidquest.materials.switches;

import com.droidquest.Room;
import com.droidquest.decorations.Arrow;
import com.droidquest.items.Item;
import com.droidquest.materials.ElevatorOutPortal;

public class ElevatorSwitch extends Switch {
    private int animationState = 0;
    // 0=open
// 1=closing
// 2=closing
// 3=switch arrow, switch outRoom
// 4=opening
// 5=opening
    private transient Room room;
    private transient final ElevatorOutPortal outPortal = new ElevatorOutPortal();

    public ElevatorSwitch() {
        super(Switch.ROT_LEFT);
    }

    public void touchedByItem(Item item) {
        room = item.room;
        if (animationState == 0) {
            animationState = 1;
        }
    }

    public void animate() {
        super.animate();
        switch (animationState) {
            case 0:
                value = false;
                break;
            case 1:
                // Play sound
                value = true;
                room.setMaterial(0, 7, 4);
                room.setMaterial(0, 10, 4);
                animationState++;
                break;
            case 2:
                room.setMaterial(0, 8, 4);
                room.setMaterial(0, 9, 4);
                animationState++;
                break;
            case 3:
                if (outPortal.outRoom == level().rooms.get(11)) {
                    for (int a = 0; a < room.arrows.size(); a++) {
                        Arrow arrow = room.arrows.get(a);
                        arrow.direction = Arrow.DIR_UP;
                        arrow.y = 66;
                    }
                    outPortal.SetOutRoom(9);
                }
                else {
                    for (int a = 0; a < room.arrows.size(); a++) {
                        Arrow arrow = room.arrows.get(a);
                        arrow.direction = Arrow.DIR_DOWN;
                        arrow.y = 94;
                    }
                    outPortal.SetOutRoom(11);
                }
                animationState++;
                break;
            case 4:
                room.setMaterial(0, 8, 12);
                room.setMaterial(0, 9, 12);
                animationState++;
                break;
            case 5:
                room.setMaterial(0, 7, 12);
                room.setMaterial(0, 10, 12);
                animationState = 0;
                break;
        }
    }

}

