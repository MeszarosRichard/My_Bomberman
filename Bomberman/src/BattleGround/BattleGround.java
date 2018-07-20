/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleGround;

import java.util.ArrayList;

/**
 *
 * @author Uzivatel
 */
public class BattleGround {
    private ArrayList<Box>boxes;
    private ArrayList<Wall>walls;
    private final int horizontal;
    private final int vertical;
    public BattleGround(int horizontal, int vertical){
        this.boxes = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.horizontal = horizontal;
        this.vertical = vertical;
        int ordinateX = 0;
        int ordinateY = 0;
        for(int x = 0 ;x < horizontal;x++){
            ordinateX++;
            for(int y = 0;y < vertical;y++){
                ordinateY++;
                if(ordinateY > vertical){
                    ordinateY = 1;
                }
                if(ordinateX == 1 || ordinateX == horizontal || ordinateY == 1 || ordinateY == vertical){
                    Wall outSideWall = new Wall(ordinateX,ordinateY);
                    this.walls.add(outSideWall);
                   
                } else if(ordinateX % 2 != 0 && ordinateY % 2 != 0){
                    Wall inSideWall = new Wall(ordinateX,ordinateY);
                    this.walls.add(inSideWall);
                } else {
                    Box box = new Box(ordinateX, ordinateY);
                    this.boxes.add(box);
                }
            }
        }
        this.cleaner();
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }
    public boolean isThereBox(int x, int y, boolean thisIsDetonation){
        for(Box temp : this.boxes){
            if(x == temp.getOrdinateX() && y == temp.getOrdinateY()){
                if(thisIsDetonation){
                    this.boxes.remove(temp);
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean isThereWall(int x, int y){
        for(Wall temp : this.walls){
            if(x == temp.getOrdinateX() && y == temp.getOrdinateY()){
                return true;
            }
        }
        return false;
    }
    
    
    private void cleaner(){
        this.isThereBox(2, 2, true);
        this.isThereBox(2, 3, true);
        this.isThereBox(3, 2, true);
        this.isThereBox(4, 2, true);
    }
}
