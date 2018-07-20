/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Npc;

import BattleGround.BattleGround;
import Engine.Engine;
import Character.Character;

/**
 *
 * @author Uzivatel
 */
public class NpcBomberman {
    private Character character;
    public NpcBomberman(Engine engine, BattleGround battleGround){
        this.character = new Character(battleGround.getHorizontal() - 1, battleGround.getVertical() - 1, battleGround, engine);
        engine.addCharacter(this.character);
    }
}
