/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleGround;

/**
 *
 * @author Uzivatel
 */
public class Box {
    private final int ordinateX;
    private final int ordinateY;
    
    public Box(int ordinateX, int ordinateY){
        this.ordinateX = ordinateX;
        this.ordinateY = ordinateY;
    }

    public int getOrdinateX() {
        return this.ordinateX;
    }

    public int getOrdinateY() {
        return this.ordinateY;
    }
}
