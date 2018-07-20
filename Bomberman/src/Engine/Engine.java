/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Bomb.Bomb;
import Character.Character;
import java.util.ArrayList;

/**
 *
 * @author Uzivatel
 */
public class Engine {
    private Character character;
    private Bomb bomb;
    private ArrayList<Character>characters;
    private ArrayList<Bomb>bombs;
    public Engine(){
        this.characters = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }
    
    public void addBomb(Bomb bomb){
        this.bombs.add(bomb);
    }
    
    public void addCharacter(Character character){
        this.characters.add(character);
    }
    
    private boolean finder(int ordinateX, int ordinateY, boolean character, boolean bomb){
        if(character){
            for(Character temp : this.characters){
                if(temp.getOrdinateX() == ordinateX && temp.getOrdinateY() == ordinateY){
                    return true;
                }
            }
        }
        if(bomb){
            for(Bomb temp : this.bombs){
                if(temp.getOrdinateX() == ordinateX && temp.getOrdinateY() == ordinateY){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isThereBomb(int ordinateX, int ordinateY, boolean thisIsDetonationFire){
        if(thisIsDetonationFire){
            if(this.finder(ordinateX, ordinateY,false, true )){
                this.giveBomb(ordinateX, ordinateY).detonation();
            }
            return true;
        }
        return this.finder(ordinateX, ordinateY, false, true);
    }
    
    public boolean isThereCharacter(int ordinateX, int ordinateY){
        if(this.finder(ordinateX, ordinateY, true, false)){
            this.giveCharacter(ordinateX, ordinateY).kill();
        }
        return this.finder(ordinateX, ordinateY, true, false);
    }
    
    public void removeBomb(Bomb bomb){
        this.bombs.remove(bomb);
    }
    
    private Bomb giveBomb(int ordinateX, int ordinateY){
        for(Bomb temp : this.bombs){
            if(temp.getOrdinateX() == ordinateX && temp.getOrdinateY() == ordinateY){
                return temp;
            }
        }
        return null;
    }
    
    private Character giveCharacter(int ordinateX, int ordinateY){
        for(Character temp : this.characters){
            if(temp.getOrdinateX() == ordinateX && temp.getOrdinateY() == ordinateY){
                return temp;
            }
        }
        return null;
    }
    
    public int howManyCharactersLive(){
        int result = 0;
        for(Character temp : this.characters){
            if(temp.getIsLive()){
                result++;
            }
        }
        return result;
    }
}
