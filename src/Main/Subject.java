/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author harou
 */
public interface Subject {
    public void register(Observer observer);
    public void notifyObserver(String tweet);
}
