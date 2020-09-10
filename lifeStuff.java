import javax.swing.JPanel;
import javax.swing.Timer;
import java.lang.Math;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lifeStuff extends JPanel implements ActionListener{

    int x = 700;
    int y = 650;
    int side = 10;
    int width = x/side;
    int height = y/side;

    int[][] cell = new int[width][height];
    int[][] beforecell = new int[width][height];
    boolean start = true;


    
    public lifeStuff(){
        setSize(x, y);
        setLayout(null);
        setBackground(Color.BLACK);

        new Timer(80, this).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
       

        grid(g);
        spawnLife(g);
        display(g);
    
    }

    private void grid(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i < cell.length; i++){
            g.drawLine(0, i * side, x, i * side); //row
            g.drawLine(i * side, 0, i * side, y); //col
        }
    }

    private void spawnLife(Graphics g){
        if(start == true){
            for(int i = 0; i < cell.length; i++){
                for(int j = 0; j < (height); j++){

                    if((int)(Math.random() * 5) == 0){
                        beforecell[i][j] = 1;
                    }
                }
            }
            start = false;
        }
    }

    private void display(Graphics g){
        g.setColor(Color.WHITE);

        copyArray();

        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < (height); j++){

                if(cell[i][j] == 1){
                    g.fillRect(i * side, j * side, side, side);
                }
                    
            }
        }
    }

    private void copyArray(){
        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < (height); j++){
                
                cell[i][j] = beforecell[i][j];    
            }
        }
    }

    private int check(int i, int j){
        int alive = 0;

        alive += cell[(i + width - 1) % width][(j + height - 1) % height];
        alive += cell[(i + width) % width][(j + height - 1) % height];
        
        alive += cell[(i + width + 1) % width][(j + height - 1) % height];
        alive += cell[(i + width - 1) % width][(j + height) % height];
        
        alive += cell[(i + width + 1) % width][(j + height) % height]; 
        alive += cell[(i + width - 1) % width][(j + height + 1) % height];
        
        alive += cell[(i + width) % width][(j + height + 1) % height];
        alive += cell[(i + width + 1) % width][(j + height + 1) % height]; 

        return alive;
    }

    public void actionPerformed(ActionEvent e){
        int alive;

        repaint(); // refresh

        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < (height); j++){
                alive = check(i, j);
                
                if(alive == 3){
                    beforecell[i][j] = 1;
                }
                else if(alive == 2 && cell[i][j] == 1){
                    beforecell[i][j] = 1;
                }
                else{
                    beforecell[i][j] = 0;
                }

            }
        }

        

    }

}
