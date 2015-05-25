/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoxadrez;

/**
 *
 * @author Pedro
 */
public class Xadrez {
    private int num;
    private int x;
    private int y;

    public Xadrez(int num, int y, int x) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
    

}
