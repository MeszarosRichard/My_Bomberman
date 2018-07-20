/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bomb;

import BattleGround.BattleGround;
import Engine.Engine;
import Character.Character;
import java.util.Timer;

/**
 *
 * @author Uzivatel
 */
public class Bomb {
    private final int ordinateX;
    private final int ordinateY;
    private final int fireSize;
    private final Character character;
    private final Engine engine;
    private final BattleGround battleGround;
    private BombTimer bombTimer;
    public Bomb(BattleGround battleGround,Engine engine, Character character, int ordinateX, int ordinateY, int fireSize){
        this.ordinateX = ordinateX;
        this.ordinateY = ordinateY;
        this.fireSize = fireSize;
        this.character = character;
        this.engine = engine;
        this.battleGround = battleGround;
        this.bombTimer = new BombTimer();
        bombTimer.setBomb(this);
        bombTimer.start();
          
        
    }

    public int getOrdinateX() {
        return ordinateX;
    }
    

    public int getOrdinateY() {
        return ordinateY;
    }
    
    public void detonation(){
        this.explosion(1);
        this.explosion(-1);
        this.removeBomb();
    }
    
    private void explosion(int direction){
        int tempOrdinateX = this.ordinateX;
        int tempOrdinateY = this.ordinateY;
        for(int i = 0; i < this.fireSize; i++){
            tempOrdinateX = tempOrdinateX + (1 * direction);
            if(this.engine.isThereCharacter(tempOrdinateX, this.ordinateY)){
                i = this.fireSize;
            }
            if(this.engine.isThereBomb(tempOrdinateX, this.ordinateY, true)){
                i = this.fireSize;
            }
            if(this.battleGround.isThereBox(tempOrdinateX, this.ordinateY, true)){
                i = this.fireSize;
            }
            if(this.battleGround.isThereWall(tempOrdinateX, this.ordinateY)){
                i = this.fireSize;
            }
        }
        
        for(int i = 0; i < this.fireSize; i++){
            tempOrdinateY = tempOrdinateY + (1 * direction);
            if(this.engine.isThereCharacter(this.ordinateX, tempOrdinateY)){
                i = this.fireSize;
            }
            if(this.engine.isThereBomb(this.ordinateX, tempOrdinateY, true)){
                i = this.fireSize;
            }
            if(this.battleGround.isThereWall(this.ordinateX, tempOrdinateY)){
                i = this.fireSize;
            }
            if(this.battleGround.isThereBox(this.ordinateX, tempOrdinateY, true)){
                i = this.fireSize;
            }
        }
        
    }
    
    private void removeBomb(){
        this.character.increaseBombQuantity();
        this.engine.removeBomb(this);
    }
    
  
}
