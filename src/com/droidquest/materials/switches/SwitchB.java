package com.droidquest.materials.switches;

import com.droidquest.decorations.TextBox;
import com.droidquest.items.Item;
import com.droidquest.items.Sentry;
import com.droidquest.materials.Material;

public class SwitchB extends Switch {
    private transient SwitchA switchA = null;
    private boolean flipped = false;
    private transient Sentry sentry = null;

    public SwitchB() {
        super(ROT_LEFT);
    }

    public void touchedByItem(Item item) {
        value = true;
        for (int a = 0; a < level().materials.size(); a++) {
            Material mat = level().materials.get(a);
            if (mat.getClass().toString().endsWith("SwitchA")) {
                switchA = (SwitchA) mat;
            }
        }
        for (int a = 0; a < level().items.size(); a++) {
            Item item2 = level().items.get(a);
            if (item2.room == item.room) {
                if (item2.getClass().toString().endsWith("Sentry")) {
                    sentry = (Sentry) item2;
                }
            }
        }
    }

    public void animate() {
        super.animate();
        if (!flipped) {
            if (value) {
                if (switchA != null) {
                    if (switchA.value) {
                        flipped = true;
                        TextBox textbox = sentry.room.textBoxes.get(0);
                        textbox.textString = "KLAATA BARADA NIKTO!";
                        textbox.y = 6 * 32;
                        textbox.width = 400;
                        level().items.remove(sentry);
                    }
                }
            }
        }
    }

}