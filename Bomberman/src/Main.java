
import BattleGround.BattleGround;
import Engine.Engine;
import Character.Character;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uzivatel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BattleGround battleGround = new BattleGround(7,7);
        Engine engine = new Engine();
        Character character = new Character(2,2,battleGround,engine);
        System.out.println("Ordinate X :" + character.getOrdinateX());
        System.out.println("Ordinate Y :" + character.getOrdinateY());
        System.out.println();
      
    
 
        
       
        
        
      
        System.out.println("Ordinate X :" + character.getOrdinateX());
        System.out.println("Ordinate Y :" + character.getOrdinateY());
      
    }
    
}
