/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import BattleGround.BattleGround;
import Bomb.Bomb;
import Engine.Engine;

/**
 *
 * @author Uzivatel
 */
public class Character {
    private boolean isLive;
    private int ordinateX;
    private int ordinateY;
    private int fireSize;
    private int bombQuantity;
    private final BattleGround battleGround;
    private final Engine engine;
    
    public Character(int ordinateX, int ordinateY, BattleGround battleGround, Engine engine){
        this.ordinateX = ordinateX;
        this.ordinateY = ordinateY;
        this.fireSize = 1;
        this.bombQuantity = 1;
        this.battleGround = battleGround;
        this.engine = engine;
        this.engine.addCharacter(this);
        this.isLive = true;
    }

    public void kill() {
        this.isLive = false;
    }
    
    public boolean getIsLive(){
        return this.isLive;
    }
    
    public int getOrdinateX(){
        return this.ordinateX;
    }
    
    public int getOrdinateY(){
        return this.ordinateY;
    }
    
    public void increaseFireSize(){
        this.fireSize++;
    }
    
    public void increaseBombQuantity(){
        this.bombQuantity++;
    }
    
    public void decreaseBombQunatity(){
        this.bombQuantity--;
    }
    
    private boolean move(int ordinateX, int ordinateY){
        if(this.battleGround.isThereBox(this.ordinateX + ordinateX, this.ordinateY + ordinateY , false)){
            return false;
        }
        if(this.battleGround.isThereWall(this.ordinateX + ordinateX, this.ordinateY + ordinateY)){
            return false;
        }
        if(this.engine.isThereBomb(this.ordinateX + ordinateX, this.ordinateY + ordinateY, false)){
            return false;
        }
        this.ordinateX = this.ordinateX + ordinateX;
        this.ordinateY = this.ordinateY + ordinateY; 
        return true;
    }
    
    public boolean moveRight(){
        return this.move(1,0);
    }
    
    public boolean moveLeft(){
        this.move(-1,0);
        return this.move(-1,0);
    }
    
    public boolean moveDown(){
        this.move(0,1);
        return this.move(0,1);
    }
    
    public boolean moveUp(){
        this.move(0,-1);
        return this.move(0,-1);
    }
    
    public void putBomb(){
        if(this.bombQuantity > 0){
            Bomb placed = new Bomb(this.battleGround, this.engine, this, this.ordinateX, this.ordinateY, this.fireSize);  
            this.decreaseBombQunatity();
            this.engine.addBomb(placed);
           
        }
    }
    
    
}
