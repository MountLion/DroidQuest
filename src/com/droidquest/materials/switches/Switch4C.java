package com.droidquest.materials.switches;

import com.droidquest.items.Item;
import com.droidquest.materials.Material;

public class Switch4C extends Switch {
    private transient Switch4A sw = null;

    public Switch4C() {
        super(Switch.ROT_DOWN);
    }

    public void touchedByItem(Item item) {
        if (sw == null) {
            for (int a = 0; a < level().materials.size(); a++) {
                Material mat = level().materials.get(a);
                if (mat instanceof Switch4A) {
                    sw = (Switch4A) mat;
                }
            }
        }

        if (!value) {
            value = true;
            sw.count++;
            sw.room = item.room;
        }
    }
}