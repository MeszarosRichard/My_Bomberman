/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bomb;

import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Uzivatel
 */
public class BombTimer {
 
    Bomb bomb;
    Timer timer = new Timer();
    TimerTask task = new TimerTask(){
    
            @Override
            public void run(){
                System.out.println("Bum");
                bomb.detonation();
                cancelBombTimer();   
            }
        };
 
    public void start(){
        timer.scheduleAtFixedRate(task, 500, 1500);
    }
    
    public void cancelBombTimer(){
       timer.cancel();
    }
    
    public void setBomb(Bomb newBomb) {
        bomb = newBomb;
    }
    
  
}
