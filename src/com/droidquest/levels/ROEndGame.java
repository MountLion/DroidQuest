package com.droidquest.levels;

import java.awt.Color;

import com.droidquest.Room;
import com.droidquest.RoomDisplay;
import com.droidquest.avatars.GameCursor;
import com.droidquest.avatars.HelpCam;
import com.droidquest.avatars.Remote;
import com.droidquest.avatars.SolderingPen;
import com.droidquest.decorations.Arrow;
import com.droidquest.items.EndAnimation;
import com.droidquest.materials.Lock;
import com.droidquest.materials.Material;
import com.droidquest.materials.Portal;

class ROEndGame extends Level {
    public ROEndGame(RoomDisplay rd) {
        super(rd);

        materials.add(new Material(true, false));                         // 0 = Empty Space
        materials.add(new Material(new Color(0, 0, 255), false, true));      // 1 = Blue
        materials.add(new Portal("MainMenu.lvl", false, false));             // 2 = Portal

        int[][] program1 = {
                {Lock.NARROW},
                {4, 5, 0, 4, 6, 0},
                {4, 4, 0, 4, 7, 0},
                {Lock.NARROW},
                {4, 4, 1, 4, 7, 1},
                {4, 5, 1, 4, 6, 1},
        };
        materials.add(new Lock(Color.green, Color.green, program1));      // 3=Green Lock

        int[][] program2 = {
                {Lock.NARROW},
                {7, 5, 0, 7, 6, 0},
                {7, 4, 0, 7, 7, 0},
                {Lock.NARROW},
                {7, 4, 1, 7, 7, 1},
                {7, 5, 1, 7, 6, 1},
        };
        materials.add(new Lock(Color.yellow, Color.yellow, program2));      // 4=yellow Lock

        int[][] program3 = {
                {Lock.NARROW},
                {10, 5, 0, 10, 6, 0},
                {10, 4, 0, 10, 7, 0},
                {Lock.NARROW},
                {10, 4, 1, 10, 7, 1},
                {10, 5, 1, 10, 6, 1},
        };
        materials.add(new Lock(Color.red, Color.red, program3));      // 5=red Lock

        int[][] program4 = {
                {Lock.NARROW},
                {13, 5, 0, 13, 6, 0},
                {13, 4, 0, 13, 7, 0},
                {Lock.NARROW},
                {13, 4, 1, 13, 7, 1},
                {13, 5, 1, 13, 6, 1},
        };
        materials.add(new Lock(new Color(255, 128, 0), new Color(255, 128, 0), program4));      // 6=Orange lock

        int[][] program5 = {
                {Lock.NARROW},
                {16, 5, 0, 16, 6, 0},
                {16, 4, 0, 16, 7, 0},
                {Lock.NARROW},
                {16, 4, 1, 16, 7, 1},
                {16, 5, 1, 16, 6, 1},
        };
        materials.add(new Lock(new Color(255, 0, 255), new Color(255, 0, 255), program5));      // 7=purple Lock

        materials.add(new Portal("RO6.lvl", true, true)); // 8=portal


        for (int a = 0; a < 3; a++) {
            rooms.add(new Room());
        }

        {// Room 0  Help
            Room room = rooms.get(0);
            room.RoomArray = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            room.addTextBox("No help here. Press Return.",
                    118, 5 * 32, 450);
        }

        {// Room 1 Portal to Main Menu
            Room room = rooms.get(1);
            room.RoomArray = new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

            room.addTextBox("{BIG} {255,000,000} CONGRATULATIONS!", 64, 64, 500);
            room.addTextBox("You are one of the few, true", 112, 4 * 32, 560);
            room.addTextBox("Robot Masters.", 196, 4 * 32 + 20, 560);
            room.addTextBox("Return to the Main Menu", 2 * 28, 10 * 32 + 24, 500);
            room.addArrow(360, 10 * 32 + 16, Arrow.DIR_RIGHT, 28, Color.white);
            items.add(new EndAnimation(room));
        }

        {// Room 2 Locks to Secret Level
            Room room = rooms.get(2);
            room.RoomArray = new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 8, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {0, 0, 0, 3, 1, 0, 4, 1, 0, 5, 1, 0, 6, 1, 0, 7, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            room.addTextBox("You may want to take the keys with you...", 24, 24, 560);
        }

        linkRoomsLeftRight(1, 2);

        gameCursor = new GameCursor(10 * 28, 8 * 32, rooms.get(1));
        helpCam = new HelpCam(rooms.get(0));
        solderingPen = new SolderingPen();
        remote = new Remote();
        items.add(gameCursor);
        items.add(helpCam);
        items.add(solderingPen);
        items.add(remote);
        player = gameCursor;
        currentViewer = player;

    }

}
