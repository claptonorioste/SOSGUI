/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileOutputStream;

/**
 * @author Orioste, Christian Clapton Edison G.
 * BS-IT3R3
 * FINAL PROJECT
 */
public class SOSGUI extends JFrame {
    
    Timer restartTime,score;//Variable for delay using Timer
    String choice = "S";//Default Choice is S
    String turns1 = "";
    char choice1 = 'S';
    char[][] Game = new char[5][5];//Creates 3d array for storage for S and O
    char[][] loc = {{'A','B','C','D','E'},{'F','G','H','I','J'},{'K','L','M','N','O'},{'P','Q','R','S','T'},{'U','V','W','X','Y'}};//Location label as A - Y
    int match = 0, p1score = 0, p2score = 0,rand=0,full=0,hiscore=0;
    Random randomize = new Random();
    
    JLabel p1Score = new JLabel("Player 1: 0");
    JLabel p2Score = new JLabel("Player 2: 0");
    JLabel turns = new JLabel("Turns:");
    PrintWriter pw;
   Scanner sc;
   File file1 = new File("score.txt");
    
    

    SOSGUI() throws Exception {
        if(file1.exists()){
         sc = new Scanner(file1);
         while(sc.hasNextInt()){
         hiscore=sc.nextInt();
         }
        }
        pw = new PrintWriter(new FileOutputStream(file1,true));   
        
         
         
       
        setTitle("SOS Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel scores = new JPanel(); //Panels
        JPanel inputs = new JPanel();
        JPanel buttons = new JPanel();
        JPanel btnSO = new JPanel();
        
        btnSO.setLayout(new GridLayout(1,2)); //Layouts
        scores.setLayout(new GridLayout(2,2));
        inputs.setLayout(new GridLayout(5,5));
        buttons.setLayout(new GridLayout(1,2));
        
        
        JLabel hiScore = new JLabel("Hi Score:"+hiscore); //Buttons rani

        
        JButton S = new JButton("S"); //Buttons rani
        JButton O = new JButton("O");
        
        JButton restart = new JButton("RESTART");
        
        
        setLayout(new BorderLayout());
        
        JButton tf1 = new JButton(); //Creates Button name as tf1 - tf25
        JButton tf2 = new JButton(); // kanang button btaw na imo tuplokon during game
        JButton tf3 = new JButton(); // Until tf25 kay 5x5 mn atong array
        JButton tf4 = new JButton();
        JButton tf5 = new JButton();
        
        JButton tf6 = new JButton();
        JButton tf7 = new JButton();
        JButton tf8 = new JButton();
        JButton tf9 = new JButton();
        JButton tf10 = new JButton();
        
        JButton tf11 = new JButton();
        JButton tf12 = new JButton();         
        JButton tf13 = new JButton();
        JButton tf14 = new JButton();
        JButton tf15 = new JButton();
        
        JButton tf16 = new JButton();
        JButton tf17 = new JButton();
        JButton tf18 = new JButton();
        JButton tf19 = new JButton();
        JButton tf20 = new JButton();

        JButton tf21 = new JButton();
        JButton tf22 = new JButton();
        JButton tf23 = new JButton();
        JButton tf24 = new JButton();
        JButton tf25 = new JButton();
      
        
        tf1.setHorizontalAlignment(JTextField.CENTER);//tf1.set...... para ni matunga ang text
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        tf4.setHorizontalAlignment(JTextField.CENTER);
        tf5.setHorizontalAlignment(JTextField.CENTER);
        
        tf6.setHorizontalAlignment(JTextField.CENTER);
        tf7.setHorizontalAlignment(JTextField.CENTER);
        tf8.setHorizontalAlignment(JTextField.CENTER);
        tf9.setHorizontalAlignment(JTextField.CENTER);
        tf10.setHorizontalAlignment(JTextField.CENTER);
        
        tf11.setHorizontalAlignment(JTextField.CENTER);
        tf12.setHorizontalAlignment(JTextField.CENTER);
        tf13.setHorizontalAlignment(JTextField.CENTER);
        tf14.setHorizontalAlignment(JTextField.CENTER);
        tf15.setHorizontalAlignment(JTextField.CENTER);
        
        tf16.setHorizontalAlignment(JTextField.CENTER);
        tf17.setHorizontalAlignment(JTextField.CENTER);
        tf18.setHorizontalAlignment(JTextField.CENTER);
        tf19.setHorizontalAlignment(JTextField.CENTER);
        tf20.setHorizontalAlignment(JTextField.CENTER);
        
        tf21.setHorizontalAlignment(JTextField.CENTER);
        tf22.setHorizontalAlignment(JTextField.CENTER);
        tf23.setHorizontalAlignment(JTextField.CENTER);
        tf24.setHorizontalAlignment(JTextField.CENTER);
        tf25.setHorizontalAlignment(JTextField.CENTER);
        
       
        
        
        scores.add(turns); //mag add sa mga buttons/label/etc para mkita sa panel nga scores
        scores.add(hiScore);
        scores.add(p1Score);
        scores.add(p2Score);
        
        
        inputs.add(tf1);//same rani sa inputs ra nga panel gbutang
        inputs.add(tf2);
        inputs.add(tf3);
        inputs.add(tf4);
        inputs.add(tf5);
        
        inputs.add(tf6);
        inputs.add(tf7);
        inputs.add(tf8);
        inputs.add(tf9);
        inputs.add(tf10);
        
        inputs.add(tf11);
        inputs.add(tf12);
        inputs.add(tf13);
        inputs.add(tf14);
        inputs.add(tf15);
        
        inputs.add(tf16);
        inputs.add(tf17);
        inputs.add(tf18);
        inputs.add(tf19);
        inputs.add(tf20);
        
        inputs.add(tf21);
        inputs.add(tf22);
        inputs.add(tf23);
        inputs.add(tf24);
        inputs.add(tf25);
        
        btnSO.add(S);
        btnSO.add(O);
        
        buttons.add(restart);
        buttons.add(btnSO);
        
        add(scores,BorderLayout.NORTH);
        add(inputs,BorderLayout.CENTER);
        add(buttons,BorderLayout.SOUTH);
        
        rand = randomize.nextInt(2)+1;
        
        if(rand==1){
            turns.setText("Turns: PLAYER1");
            turns1 = "p1";
        }else{
            turns.setText("Turns: PLAYER2");
            turns1 = "p2";
        }
        
        S.addActionListener(new ActionListener(){//action para kng e click sa button nga s
            public void actionPerformed(ActionEvent e){
               choice = S.getText();//kwaun nko ang text sa s nga button e store nko sa choice nga variable then
               choice1 = choice.charAt(0);//ako eupdate ang choice1 para pag click nmo sa box s na ang value
            }
        });
        
        O.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){//same rani sa taas o lng ang value
               choice = O.getText();
               choice1 = choice.charAt(0);
            }
        });
        
        tf1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){//kni libog haha ang tf1 man is pnka una nga button so game[0][0] iyang array akong ge label og A
               full = full + 1;
               tf1.setEnabled(false);//pag click dna matuplok blik
               tf1.setText(choice);//e set mko ang text either s or o
               location('A',Game,loc,choice1); //kani is tanawon nko asa na array ang A w/c is [0][0]
               match = check('A',Game,loc);//daun kani naa namn tay value anang loc = [0][0] so sa game[0][0] nato ibutang ang npili na letter
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf2.addActionListener(new ActionListener(){ //preha rani [0][1] ra nga array and so on padulong tf25
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf2.setEnabled(false);
               tf2.setText(choice);
               location('B',Game,loc,choice1);
                match = check('B',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf3.setEnabled(false);
               tf3.setText(choice);
               location('C',Game,loc,choice1);
                match = check('C',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf4.setEnabled(false);
               tf4.setText(choice);
               location('D',Game,loc,choice1);
               match = check('D',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf5.setEnabled(false);
               tf5.setText(choice);
               location('E',Game,loc,choice1);
                match = check('E',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf6.setEnabled(false);
               tf6.setText(choice);
               location('F',Game,loc,choice1);
                match = check('F',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf7.setEnabled(false);
               tf7.setText(choice);
               location('G',Game,loc,choice1);
               match = check('G',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf8.setEnabled(false);
               tf8.setText(choice);
               location('H',Game,loc,choice1);
                match = check('H',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf9.setEnabled(false);
               tf9.setText(choice);
               location('I',Game,loc,choice1);
                match = check('I',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf10.setEnabled(false);
               tf10.setText(choice);
               location('J',Game,loc,choice1);
               match = check('J',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf11.setEnabled(false);
               tf11.setText(choice);
               location('K',Game,loc,choice1);
                match = check('K',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf12.setEnabled(false);
               tf12.setText(choice);
               location('L',Game,loc,choice1);
                match = check('L',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf13.setEnabled(false);
               tf13.setText(choice);
               location('M',Game,loc,choice1);
               match = check('M',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf14.setEnabled(false);
               tf14.setText(choice);
               location('N',Game,loc,choice1);
                match = check('N',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf15.setEnabled(false);
               tf15.setText(choice);
               location('O',Game,loc,choice1);
                match = check('O',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf16.setEnabled(false);
               tf16.setText(choice);
               location('P',Game,loc,choice1);
               match = check('P',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf17.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf17.setEnabled(false);
               tf17.setText(choice);
               location('Q',Game,loc,choice1);
                match = check('Q',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf18.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf18.setEnabled(false);
               tf18.setText(choice);
               location('R',Game,loc,choice1);
                match = check('R',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf19.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf19.setEnabled(false);
               tf19.setText(choice);
               location('S',Game,loc,choice1);
               match = check('S',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf20.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf20.setEnabled(false);
               tf20.setText(choice);
               location('T',Game,loc,choice1);
                match = check('T',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf21.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf21.setEnabled(false);
               tf21.setText(choice);
               location('U',Game,loc,choice1);
                match = check('U',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        tf22.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf22.setEnabled(false);
               tf22.setText(choice);
               location('V',Game,loc,choice1);
               match = check('V',Game,loc);
               if(turns1=="p1"){
                    setP1score();
               }else{
                   setP2score();
               }              
            }
        });
        tf23.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf23.setEnabled(false);
               tf23.setText(choice);
               location('W',Game,loc,choice1);
                match = check('W',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
                }
            }
        });
        tf24.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf24.setEnabled(false);
               tf24.setText(choice);
               location('X',Game,loc,choice1);
                match = check('X',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        
        tf25.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               full = full + 1;
               tf25.setEnabled(false);
               tf25.setText(choice);
               location('Y',Game,loc,choice1);
                match = check('Y',Game,loc);
                if(turns1=="p1"){
                    setP1score();
                }else{
                   setP2score();
               }
            }
        });
        restart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               restartTime.start();
            }
        });
         restartTime = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try { 
                    restart();
                } catch (Exception ex) {
                    Logger.getLogger(SOSGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
             dispose();
             restartTime.stop();
            }
        
        });
        
         score = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(p1score>hiscore){
                    pw.print(" "+p1score);

                }else{
                    pw.print(" "+p2score);

                }
                pw.close();
             score.stop();
            }
        
        });
        
        
        
    }
    public void restart() throws Exception{
        SOSGUI sos = new SOSGUI();   
        sos.setSize(400,400);
        sos.setVisible(true);
        sos.setLocation(450, 220);
        sos.setResizable(false);
    }
    public void isGamefull(){
         
        if(full==25){
            if(p1score>p2score){
                JOptionPane.showMessageDialog(null,"Player 1 Wins!");
                score.start();
            }else if (p2score>p1score){
                JOptionPane.showMessageDialog(null,"Player 2 Wins!");
                score.start();
            }else{
                JOptionPane.showMessageDialog(null,"Draw!");
            }
            
        }
    }
    public void setP1score(){
            if (match!=0){
                p1score = p1score + match;
                p1Score.setText("Player 1: "+p1score);
                match = 0;
                turns1 = "p1";
            }
            else{
                turns1 = "p2";
            }
            checkTurns();
    }
     public void setP2score(){
            if (match!=0){
                p2score = p2score + match;
                p2Score.setText("Player 2: "+p2score);
                match = 0;
                turns1 = "p2";
            }
            else{
                turns1 = "p1";
            }
            checkTurns();
    }
    public void checkTurns(){
        isGamefull();
        if(turns1=="p1"){
                turns.setText("Turns: PLAYER1");
        }else{
                turns.setText("Turns: PLAYER2");
        }
    }
    
     public void location (char locate,char arr1[][],char charr[][],char playerXO){
         for (int x=0;x<arr1.length;x++){
            for(int y=0;y<arr1[x].length;y++){
                 if (charr[x][y]==locate){
                     if (playerXO=='S'){
                         arr1[x][y]='S';
                     }
                     else if(playerXO=='O'){
                        arr1[x][y]='O';
                     }
                     break;
                     
                 }
            }
         }
    }
       public int check(char loc,char arr1[][],char charr[][]){ //kani e check niya tanan line horizontal/vertical/diagonal kng naporma bag sos if true add daun sa score
        int score = 0;
        for (int x=0;x<arr1.length;x++){
            for(int y=0;y<arr1[x].length;y++){
                if (charr[x][y]==loc){
                    if(!((loc=='D')||(loc=='E')||(loc=='I')||(loc=='J')||(loc=='N')||(loc=='O')||(loc=='S')||(loc=='T')||(loc=='X')||(loc=='Y'))){
                        if ((arr1[x][y]+""+arr1[x][y+1]+""+arr1[x][y+2]).equals("SOS")){
                            score = score + 1;
                        }
                    }
                    if(!((loc=='A')||(loc=='B')||(loc=='F')||(loc=='G')||(loc=='K')||(loc=='L')||(loc=='P')||(loc=='Q')||(loc=='U')||(loc=='V'))){
                        if ((arr1[x][y]+""+arr1[x][y-1]+""+arr1[x][y-2]).equals("SOS")){
                                score = score + 1;
                        }
                     }
                    if(!((loc=='A')||(loc=='F')||(loc=='K')||(loc=='P')||(loc=='U')||(loc=='E')||(loc=='J')||(loc=='O')||(loc=='T')||(loc=='Y'))){
                        if ((arr1[x][y-1]+""+arr1[x][y]+""+arr1[x][y+1]).equals("SOS")){
                                score = score + 1;
                        }
                    }
                    if((loc=='A')||(loc=='G')||(loc=='M')||(loc=='B')||(loc=='H')||(loc=='C')||(loc=='F')||(loc=='L')||(loc=='K')){
                        if ((arr1[x][y]+""+arr1[x+1][y+1]+""+arr1[x+2][y+2]).equals("SOS")){
                                score = score + 1;
                        }
                    }
                    if((loc=='Y')||(loc=='S')||(loc=='M')||(loc=='T')||(loc=='N')||(loc=='O')||(loc=='X')||(loc=='R')||(loc=='W')){
                        if ((arr1[x][y]+""+arr1[x-1][y-1]+""+arr1[x-2][y-2]).equals("SOS")){
                                score = score + 1;
                        }
                    }
                    if((loc=='U')||(loc=='Q')||(loc=='M')||(loc=='V')||(loc=='R')||(loc=='W')||(loc=='P')||(loc=='L')||(loc=='K')){
                        if ((arr1[x][y]+""+arr1[x-1][y+1]+""+arr1[x-2][y+2]).equals("SOS")){
                                score = score + 1;
                        }
                    }
                    if((loc=='E')||(loc=='I')||(loc=='M')||(loc=='D')||(loc=='H')||(loc=='C')||(loc=='J')||(loc=='N')||(loc=='O')){
                        if ((arr1[x][y]+""+arr1[x+1][y-1]+""+arr1[x+2][y-2]).equals("SOS")){
                                score = score + 1;
                        }
                    }
                    if(!((loc=='P')||(loc=='U')||(loc=='Q')||(loc=='V')||(loc=='R')||(loc=='W')||(loc=='S')||(loc=='X')||(loc=='T')||(loc=='Y'))){
                        if ((arr1[x][y]+""+arr1[x+1][y]+""+arr1[x+2][y]).equals("SOS")){
                            score = score + 1;
                        }
                    }
                    if(!((loc=='A')||(loc=='F')||(loc=='B')||(loc=='G')||(loc=='C')||(loc=='H')||(loc=='D')||(loc=='I')||(loc=='E')||(loc=='J'))){
                        if ((arr1[x][y]+""+arr1[x-1][y]+""+arr1[x-2][y]).equals("SOS")){
                            score = score + 1;
                        }
                    }
                    if(!((loc=='A')||(loc=='B')||(loc=='C')||(loc=='D')||(loc=='E')||(loc=='U')||(loc=='V')||(loc=='W')||(loc=='X')||(loc=='Y'))){
                        if ((arr1[x-1][y]+""+arr1[x][y]+""+arr1[x+1][y]).equals("SOS")){
                            score = score + 1;
                        }
                    }
                    if((loc=='G')||(loc=='M')||(loc=='S')||(loc=='H')||(loc=='N')||(loc=='I')||(loc=='L')||(loc=='R')||(loc=='Q')){
                        if ((arr1[x-1][y-1]+""+arr1[x][y]+""+arr1[x+1][y+1]).equals("SOS")){
                                score = score + 1;
                        }
                        if ((arr1[x-1][y+1]+""+arr1[x][y]+""+arr1[x+1][y-1]).equals("SOS")){
                                score = score + 1;
                        }
                    }


                    break;
                }
            }
        }
        return score;
    }
    public static void main(String[] args) throws Exception {
       
     
        SOSGUI sos = new SOSGUI();   
        sos.setSize(400,400);
        sos.setVisible(true);
        sos.setLocation(450, 220);
        sos.setResizable(false);
        
    }
    
}
