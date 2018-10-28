
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class sudoku extends JFrame{
        JTextField[][] a= new JTextField[9][9];
        String [][] copy=new String[9][9];
        Integer [] temp=new Integer[9];
        JButton create=new JButton("CREATE");
        JButton easy=new JButton("EASY");
        JButton medium=new JButton("MEDIUM");
        JButton hard=new JButton("HARD");
        JButton verify=new JButton("VERIFY");
        Random r=new Random();
        ImageIcon winner=new ImageIcon(getClass().getResource("winner.png"));
        ArrayList al=new ArrayList(9);
        int lk=10;
        boolean set,isfull,iswin,isset,onetime=true;
        public sudoku() {
            add(create);
            add(easy);
            add(medium);
            add(hard);
            add(verify);
            JLabel win=new JLabel(winner);
            add(win);
            create.setBounds(305,5, 75, 30);
            easy.setBounds(305,40, 75, 30);
            medium.setBounds(305,75, 75, 30);
            hard.setBounds(305,110, 75, 30);
            verify.setBounds(305,145, 75, 30);
            create.setMargin(new Insets(0,0,0,0));
            easy.setMargin(new Insets(0,0,0,0));
            medium.setMargin(new Insets(0,0,0,0));
            hard.setMargin(new Insets(0,0,0,0));
            verify.setMargin(new Insets(0,0,0,0));
            create.setBackground(new Color(65,114,253));
            easy.setBackground(new Color(65,114,253));
            medium.setBackground(new Color(65,114,253));
            hard.setBackground(new Color(65,114,253));
            verify.setBackground(new Color(65,114,253));
            easy.setEnabled(false);
            medium.setEnabled(false);
            hard.setEnabled(false);
            verify.setEnabled(false);
            for(int i=0;i<9;i++){
               for(int j=0;j<9;j++){
                    a[i][j]=new JTextField();
                }
            }
            for(int i=0;i<9;i++)              //loop to add jtextfield on jframe
                for(int j=0;j<9;j++){
                    add(a[i][j]);
                    a[i][j].setMargin(new Insets(0,8,0,8));
                    a[i][j].setFont(new Font("Arial",Font.BOLD,20));
                }
            int tempi=5,tempj=5;
            for(int i=0;i<9;i++){            //loop to set bounds of jtextfield
               for(int j=0;j<9;j++){
                    a[i][j].setBounds(j+tempi, i+tempj, 33, 33);
                    tempi=tempi+32; 
                  }
                    tempj=tempj+32;  
                    tempi=5;
                }
            create.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for(int i=0;i<9;i++)
                        for(int j=0;j<9;j++){
                            a[i][j].setText(String.valueOf(lk++));
                        }
                    onetime=true;
                    for (int i = 0; i < 9; i++) {
                        makequeue();
                        for (int j = 0; j < 9; j++) {
                            set=true;
                            while(set){
                                set=false;
                                a[i][j].setText(String.valueOf(al.get(0)));
//                                for(int k=0;k<j;k++){
//                                if(Integer.parseInt(a[i][k].getText())==Integer.parseInt(a[i][j].getText())){
//                                    set=true;
//                                    break;
//                                   }
//                                }
                                for(int k=0;k<i;k++){
                                if(Integer.parseInt(a[k][j].getText())==Integer.parseInt(a[i][j].getText())){
                                    set=true;
                                    break;
                                   }
                                }
                                qubecheck(i,j);
                                if(set){
                                    int a=(int)al.get(0);
                                    al.remove(0);
                                    al.add(a);
                                }
                                if(!set){
                                    al.remove(0);
                                }
                            }
                            a[i][j].setEditable(true);
                            a[i][j].setBackground(new Color(255,255,255));
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            copy[i][j]=a[i][j].getText();
                        }
                    }
                    easy.setEnabled(true);
                    medium.setEnabled(true);
                    hard.setEnabled(true);
                    verify.setEnabled(true);
                    win.setVisible(false);
                }
            });
            easy.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for (int i = 0; i < 20; i++) {
                        int x=r.nextInt(9);
                        int y=r.nextInt(9);
                        a[x][y].setText("");
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(a[i][j].getText().equals("")){}
                            else
                                a[i][j].setEditable(false);
                                a[i][j].setBackground(new Color(255,255,255));
                        }
                    }
                    easy.setEnabled(false);
                    medium.setEnabled(false);
                    hard.setEnabled(false);
                }
            });
            medium.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for (int i = 0; i < 40; i++) {
                        int x=r.nextInt(9);
                        int y=r.nextInt(9);
                        a[x][y].setText("");
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(a[i][j].getText().equals("")){}
                            else
                                a[i][j].setEditable(false);
                                a[i][j].setBackground(new Color(255,255,255));
                        }
                    }   
                    easy.setEnabled(false);
                    medium.setEnabled(false);
                    hard.setEnabled(false);                
                }
            });
            hard.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for (int i = 0; i < 60; i++) {
                        int x=r.nextInt(9);
                        int y=r.nextInt(9);
                        a[x][y].setText("");
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(a[i][j].getText().equals("")){}
                            else{
                                a[i][j].setEditable(false);
                                a[i][j].setBackground(new Color(255,255,255));
                            }
                        }
                    }  
                    easy.setEnabled(false);
                    medium.setEnabled(false);
                    hard.setEnabled(false);
                }
            });     
            verify.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    isfull=true;
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(a[i][j].getText().equals("")){
                                a[i][j].setBackground(new Color(255,100,100));
                                isfull=false;
                            }
                            else
                                a[i][j].setBackground(new Color(255,255,255));
                        }
                    }
                    if(isfull){
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                set=false;
                                if(qubecheck(i,j)){
                                    a[i][j].setBackground(new Color(255,100,100));
                            }
                            for(int k=0;k<j;k++){
                                if(Integer.parseInt(a[i][k].getText())==Integer.parseInt(a[i][j].getText())){
                                    a[i][j].setBackground(new Color(255,100,100));
                                }
                            }
                            for(int k=0;k<i;k++){
                                if(Integer.parseInt(a[k][j].getText())==Integer.parseInt(a[i][j].getText())){
                                    a[i][j].setBackground(new Color(255,100,100));
                                   }
                                }                         
                            }
                        }
                    }
                    iswin=true;
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(!copy[i][j].equals(a[i][j].getText())){
                                iswin=false;
                            }
                        }
                    }
                    if(iswin){
                        win.setVisible(true);
                        win.setBounds(305, 180, 75, 125);
                    }
                }
            });
            setTitle("SUDOKU");
            setLayout(null);
            setVisible(true);
            setSize(400,335);
            setResizable(false);
            setDefaultCloseOperation(3);
        }
        public void makequeue(){
            if(onetime){
                for (int i = 0; i < 9; i++) {
                    isset=true;
                    while(isset){
                        isset=false;
                        temp[i]=1+r.nextInt(9);
                        for (int j = 0; j < i; j++) {
                            if(temp[i]==temp[j])
                                isset=true;
                        }
                    }
                }
                onetime=false;
            }
            for (int i = 0; i < 9; i++) {
                al.add(temp[i]);
            }
        }
        public boolean qubecheck(int m,int n){
            if(m<3&&m>=0&&n<3&&n>=0){
                for (int i = 0; i <3; i++) {
                    for (int j = 0; j <3; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText())){
                            if(m!=i||n!=j){
                                set=true;
                               // break;
                            }
                        }
                    }
                }
            }
            if(m<3&&m>=0&&n<6&&n>2){
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                            //break;
                        }
                    }
                }
            }
            if(m<3&&m>=0&&n<9&&n>5){
                for (int i = 0; i < 3; i++) {
                    for (int j = 6; j < 9; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                           // break;
                        }
                    }
                }
            }
            if(m<6&&m>2&&n<3&&n>=0){
                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                            //break;
                        }
                    }
                }
            }
            if(m<6&&m>2&&n<6&&n>2){
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                           // break;
                        }
                    }
                }
            }
            if(m<6&&m>2&&n<9&&n>5){
                for (int i = 3; i < 6; i++) {
                    for (int j = 6; j < 9; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                            //break;
                        }
                    }
                }
            }
            if(m<9&&m>5&&n<3&&n>=0){
                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                           // break;
                        }
                    }
                }
            }
            if(m<9&&m>5&&n<6&&n>2){
                for (int i = 6; i < 9; i++) {
                    for (int j = 3; j < 6; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                           // break;
                        }
                    }
                }
            }
            if(m<9&&m>5&&n<9&&n>5){
                for (int i = 6; i < 9; i++) {
                    for (int j = 6; j < 9; j++) {
                        if(Integer.parseInt(a[m][n].getText())==Integer.parseInt(a[i][j].getText()))
                            if(m!=i||n!=j){
                            set=true;
                           // break;
                        }
                    }
                }
            }
            return set;
        }
          public void paint(Graphics g) {
            super.paint(g); 
            Graphics2D g2 = (Graphics2D) g;
            Line2D lin1 = new Line2D.Float(9, 129, 303, 129);
            Line2D lin2 = new Line2D.Float(9, 228, 303, 228);
            Line2D lin3 = new Line2D.Float(106, 31, 106, 325);
            Line2D lin4 = new Line2D.Float(205, 31, 205, 325);            
            g2.draw(lin1);
            g2.draw(lin2);
            g2.draw(lin3);
            g2.draw(lin4);            
            repaint();
          }
        public static void main(String[] args) {
            new sudoku();    
      }
}
