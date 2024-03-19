package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class RockPaperScissors extends JFrame {
    JLabel computerChoise,result;
    JLabel computerScore,playerScore;
    int player_score=0;
    int computer_score=0;
    ImageIcon rockIcon,paperIcon,scissorIcon;
    public void setup() {
        rockIcon = new ImageIcon( new ImageIcon("Rock.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        paperIcon = new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        scissorIcon = new ImageIcon(new ImageIcon("Scissor.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel score=new JLabel();
        score.setText("Score");
        score.setBounds(410,0,100,100);
        score.setFont(new Font("Serif",Font.BOLD,25));
        score.setForeground(Color.white);
        computerScore=new JLabel();
        computerScore.setText("Computer : 0");
        computerScore.setBounds(400,25,100,100);
        computerScore.setFont(new Font("Serif",Font.ITALIC,18));
        playerScore=new JLabel();
        playerScore.setText("Player : 0");
        playerScore.setBounds(400,50,100,100);
        playerScore.setFont(new Font("Serif",Font.ITALIC,18));

        add(computerScore);
        add(playerScore);
        add(score);
        computerChoise=new JLabel();
        computerChoise.setHorizontalTextPosition(JLabel.CENTER);
        computerChoise.setVerticalTextPosition(JLabel.BOTTOM);
        computerChoise.setBounds(250,90,100,100);
        result=new JLabel();
        result.setFont(new Font("Serif",Font.BOLD,25));
        result.setBounds(250,450,100,100);
        add(computerChoise);
        add(result);
        JLabel rockLabel=new JLabel();
        rockLabel.setText("Rock");
        rockLabel.setIcon(rockIcon);
        rockLabel.setHorizontalTextPosition(JLabel.CENTER);
        rockLabel.setVerticalTextPosition(JLabel.BOTTOM);
        rockLabel.setBounds(150,300,100,100);
        add(rockLabel);
        JLabel PaperLabel=new JLabel();
        PaperLabel.setText("Paper");
        PaperLabel.setIcon(paperIcon);
        PaperLabel.setHorizontalTextPosition(JLabel.CENTER);
        PaperLabel.setVerticalTextPosition(JLabel.BOTTOM);
        PaperLabel.setBounds(250,300,100,100);
        add(PaperLabel);
        JLabel ScissorLabel=new JLabel();
        ScissorLabel.setText("Scissor");
        ScissorLabel.setIcon(scissorIcon);
        ScissorLabel.setHorizontalTextPosition(JLabel.CENTER);
        ScissorLabel.setVerticalTextPosition(JLabel.BOTTOM);
        ScissorLabel.setBounds(350,300,100,100);
        add(ScissorLabel);
        setLayout(null);
        rockLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(rockLabel.getText());
            }
        });
        PaperLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(PaperLabel.getText());
            }
        });
        ScissorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(ScissorLabel.getText());
            }
        });

    }
    public void calculate(String player){
     String[] list={"Rock","Paper","Scissor"};
     int randomChoice=(int)((Math.random()*10)%3);
     String compute=list[randomChoice];
     computerChoise.setText(compute);
     if(randomChoice==0){
         computerChoise.setIcon(rockIcon);
     }else if(randomChoice==1){
         computerChoise.setIcon(paperIcon);
     }else{
         computerChoise.setIcon(scissorIcon);
     }
     String res="";
     if(player.equals(compute)){
         res="Draw";
     }else if(player.equals("Rock")){
         if(compute.equals("paper")){
             res="You lose";
             computer_score++;
         }
         else {
             res="You win";
             player_score++;
         }
     }
     else if(player.equals("Paper")){
         if(compute.equals("Scissor")){
             res="You lose";
             computer_score++;
         }
         else{
             res="You win";
             player_score++;
         }
     }else {
         if(compute.equals("Rock")){
             res="You lose";
             computer_score++;
         }else{
             res="You win";
             player_score++;
         }

     }
     result.setText(res);
     playerScore.setText(STR."Player :\{player_score}");
     computerScore.setText(STR."Computer : \{computer_score}");
     playerScore.setForeground(Color.black);
     computerScore.setForeground(Color.black);
    }
    public void main(String[] args){
        RockPaperScissors frame=new RockPaperScissors();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.decode("#A020F0"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("R-P-S");
        frame.setVisible(true);
        frame.setup();
        ImageIcon image =new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
    }
}
