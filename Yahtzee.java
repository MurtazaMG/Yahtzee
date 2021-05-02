/**
 * Yahtzee.java.
 * Display and play a Yahtzee game in GUI
 * Murtaza Gangardiwala
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Yahtzee implements ActionListener {
 boolean[] die = new boolean[5]; //list to see if the dice buttons were clicked
 int[] dNum = new int[5];//holds the five random numbers
 JFrame frame;//the frame 
 JPanel contentPane;
 JButton rollDice, dice1, dice2, dice3, dice4, dice5, start, end;//specific buttons for the playing part
 JButton ones, twos, threes, fours, fives, sixes, TofKind, FofKind, fullHouse, smallS, largeS, yahtzee, chance ;//buttons for scorecard
 JLabel Promo,Promo2,Promo3,empty,dieFace, displayPoints, upperPoints, lowerPoints;//labels for certain things
 String face;//what dice image to display
 int run,rolls,points=0,upperTotal=0,lowerTotal=0, totalOfNums = 0, buttons = 0;//accumulators and counters
 Color color, color1 = Color.white;//color to display
 boolean started = false;
 //all of these variables check/show the status of the entire scorecard, if they are clicked and how many points each one got
 boolean oneB = true, twoB = true,threeB = true,fourB = true,fiveB = true,sixB = true,TofKindB = true, FofKindB = true, fullHouseB = true, smallSB = true, largeSB = true, yahtzeeB = true, chanceB = true;
 int onesP =0, twosP =0, threesP =0, foursP =0, fivesP =0,sixesP =0,TofKindsP =0,FofKindsP =0,fullHsP =0,smallSsP =0, largeSsP =0, yahtzeesP =0, chancesP =0;
 JLabel oneP, twoP, threeP, fourP, fiveP,sixP,TofKindP,FofKindP,fullHP,smallSP, largeSP, yahtzeeP, chanceP;
 public Yahtzee(){
 /* Create and set up the frame */
 
   run = 0;  //initializing this variable to prevent holding or clicking buttons before rolling
 
for(int i = 0; i < die.length; i++) { //making all the dice buttons clickable
      die[i] = true;
}
 

   
 frame = new JFrame("Yahtzee"); //frame declaring
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 /* Create a content pane with a BoxLayout and
 empty borders */
 contentPane = new JPanel();
 contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 contentPane.setLayout(new GridLayout(0, 8, 5, 10));
 
 start = new JButton("Play Yahtzee"); //first button to display everything on the panel
 start.setActionCommand("start");
 start.setAlignmentX(JButton.CENTER_ALIGNMENT);
 start.addActionListener(this);
 contentPane.add(start);
 
 rollDice = new JButton("Roll"); //button to call the rolls and display new numbers
 rollDice.setActionCommand("roll");
 rollDice.addActionListener(this);
 rollDice.setLayout(new GridLayout(1, 2));
 rollDice.setVisible(false);
 contentPane.add(rollDice);
 
 //all of these dice buttons hold their own seperate images and can be clicked to be held if they are liked by the user
 dice1 = new JButton(new ImageIcon("die6.gif"));//dice button to hold
 dice1.setActionCommand("Dice1");
 dice1.addActionListener(this);
 dice1.setLayout(new GridLayout(1, 15));
 dice1.setBackground(Color.white);
 dice1.setVisible(false);
 contentPane.add(dice1);
 
 dice2 = new JButton(new ImageIcon("die6.gif"));//dice button to hold
 dice2.setActionCommand("Dice2");
 dice2.addActionListener(this);
 dice2.setLayout(new GridLayout(1, 16));
 dice2.setBackground(Color.white);
 dice2.setVisible(false);
 contentPane.add(dice2);
 
 dice3 = new JButton(new ImageIcon("die6.gif"));//dice button to hold
 dice3.setActionCommand("Dice3");
 dice3.addActionListener(this);
 dice3.setLayout(new GridLayout(1, 17));
 dice3.setBackground(Color.white);
 dice3.setVisible(false);
 contentPane.add(dice3);
 
 dice4 = new JButton(new ImageIcon("die6.gif"));//dice button to hold
 dice4.setActionCommand("Dice4");
 dice4.addActionListener(this);
 dice4.setLayout(new GridLayout(1, 18));
 dice4.setBackground(Color.white);
 dice4.setVisible(false);
 contentPane.add(dice4);
 
 dice5 = new JButton(new ImageIcon("die6.gif"));//dice button to hold
 dice5.setActionCommand("Dice5");
 dice5.addActionListener(this);
 dice5.setLayout(new GridLayout(1, 19));
 dice5.setBackground(Color.white);
 dice5.setVisible(false);
 contentPane.add(dice5);
 
Promo3 = new JLabel("Yahtzee Game");//this label fills in space
 Promo3.setLayout(new GridLayout(100, 20));
 Promo3.setFont(new Font("Monospaced", Font.BOLD, 22));
 contentPane.add(Promo3);
 
 displayPoints = new JLabel("Total Points: " + points);//shows total points 
 displayPoints.setLayout(new GridLayout(100, 20));
 displayPoints.setVisible(false);
 contentPane.add(displayPoints);
 
 //all of these buttons are part of the scorecard, and each button can be clicked only once
 ones = new JButton("Ones");//one of the buttons
 ones.setActionCommand("ones");
 ones.addActionListener(new ScoreCard());//seperate class for this button for action listener
 ones.setLayout(new GridLayout(200, 1));
 ones.setVisible(false);
 contentPane.add(ones);
 
 twos = new JButton("Twos");//one of the buttons
 twos.setActionCommand("twos");
 twos.addActionListener(new ScoreCard());//seperate class for this button for action listener
 twos.setLayout(new GridLayout(250, 1));
 twos.setVisible(false);
 contentPane.add(twos);
 
 threes = new JButton("Threes");//one of the buttons
 threes.setActionCommand("threes");
 threes.addActionListener(new ScoreCard());//seperate class for this button for action listener
 threes.setLayout(new GridLayout(250, 1));
 threes.setVisible(false);
 contentPane.add(threes);
 
 fours = new JButton("Fours");//one of the buttons
 fours.setActionCommand("fours");
 fours.addActionListener(new ScoreCard());//seperate class for this button for action listener
 fours.setLayout(new GridLayout(250, 1));
 fours.setVisible(false);
 contentPane.add(fours);
 
 fives = new JButton("Fives");//one of the buttons
 fives.setActionCommand("fives");
 fives.addActionListener(new ScoreCard());//seperate class for this button for action listener
 fives.setLayout(new GridLayout(250, 1));
 fives.setVisible(false);
 contentPane.add(fives);
 
 sixes = new JButton("Sixes");//one of the buttons
 sixes.setActionCommand("sixes");
 sixes.addActionListener(new ScoreCard());//seperate class for this button for action listener
 sixes.setLayout(new GridLayout(250, 1));
 sixes.setVisible(false);
 contentPane.add(sixes);
 
 Promo = new JLabel("By: Murtaza Gangardiwala");//fller
 Promo.setFont(new Font("Monospaced", Font.BOLD, 11));
 contentPane.add(Promo);
 
 //this entire line shows the points for each button clicked
 upperPoints = new JLabel("Upper Points: " + upperTotal);//one of the labels
 upperPoints.setLayout(new GridLayout(100, 20));
 upperPoints.setVisible(false);
 contentPane.add(upperPoints);
 
 oneP = new JLabel("Points: " + onesP);//one of the labels
 oneP.setLayout(new GridLayout(100, 20));
 oneP.setVisible(false);
 contentPane.add(oneP);
 
 twoP = new JLabel("Points: " + twosP);//one of the labels
 twoP.setLayout(new GridLayout(100, 20));
 twoP.setVisible(false);
 contentPane.add(twoP);
 
 threeP = new JLabel("Points: " + threesP);//one of the labels
 threeP.setLayout(new GridLayout(100, 20));
 threeP.setVisible(false);
 contentPane.add(threeP);
 
 fourP = new JLabel("Points: " + foursP);//one of the labels
 fourP.setLayout(new GridLayout(100, 20));
 fourP.setVisible(false);
 contentPane.add(fourP);
 
 fiveP = new JLabel("Points: " + fivesP);//one of the labels
 fiveP.setLayout(new GridLayout(100, 20));
 fiveP.setVisible(false);
 contentPane.add(fiveP);
 
 sixP = new JLabel("Points: " + sixesP);//one of the labels
 sixP.setLayout(new GridLayout(100, 20));
 sixP.setVisible(false);
 contentPane.add(sixP);
 
 Promo2 = new JLabel("G.U.I.");//filler
 Promo2.setFont(new Font("Monospaced", Font.BOLD, 20));
 contentPane.add(Promo2);
 
 empty = new JLabel("  ");//filler
 empty.setLayout(new GridLayout(100, 20));
 empty.setVisible(true);
 contentPane.add(empty);
 
 TofKind = new JButton("Three of a Kind");//one of the buttons on the scorecard
 TofKind.setActionCommand("TofKind");
 TofKind.addActionListener(new ScoreCard());//seperate class for this button for action listener
 TofKind.setLayout(new GridLayout(250, 1));
 TofKind.setVisible(false);
 contentPane.add(TofKind);
 
 FofKind = new JButton("Four of a Kind");//one of the buttons on the scorecard
 FofKind.setActionCommand("FofKind");
 FofKind.addActionListener(new ScoreCard());//seperate class for this button for action listener
 FofKind.setLayout(new GridLayout(250, 1));
 FofKind.setVisible(false);
 contentPane.add(FofKind);
 
 fullHouse = new JButton("Full House");//one of the buttons on the scorecard
 fullHouse.setActionCommand("fullHouse");
 fullHouse.addActionListener(new ScoreCard());//seperate class for this button for action listener
 fullHouse.setLayout(new GridLayout(250, 1));
 fullHouse.setVisible(false);
 contentPane.add(fullHouse);
 
 smallS = new JButton("Small Straight");//one of the buttons on the scorecard
 smallS.setActionCommand("smallS");
 smallS.addActionListener(new ScoreCard());//seperate class for this button for action listener
 smallS.setLayout(new GridLayout(250, 1));
 smallS.setVisible(false);
 contentPane.add(smallS);
 
 largeS = new JButton("Large Straight");//one of the buttons on the scorecard
 largeS.setActionCommand("largeS");
 largeS.addActionListener(new ScoreCard());//seperate class for this button for action listener
 largeS.setLayout(new GridLayout(250, 1));
 largeS.setVisible(false);
 contentPane.add(largeS);
 
 yahtzee = new JButton("YAHTZEE");//one of the buttons on the scorecard
 yahtzee.setActionCommand("yahtzee");
 yahtzee.addActionListener(new ScoreCard());//seperate class for this button for action listener
 yahtzee.setLayout(new GridLayout(250, 1));
 yahtzee.setVisible(false);
 contentPane.add(yahtzee);

 
 chance = new JButton("Chance");//one of the buttons on the scorecard
 chance.setActionCommand("chance");
 chance.addActionListener(new ScoreCard());//seperate class for this button for action listener
 chance.setLayout(new GridLayout(250, 1));
 chance.setVisible(false);
 contentPane.add(chance);
 
 lowerPoints = new JLabel("Lower Points: " + lowerTotal);//displays the total for the bottom line
 lowerPoints.setLayout(new GridLayout(100, 20));
 lowerPoints.setVisible(false);
 contentPane.add(lowerPoints);
 
 TofKindP = new JLabel("Points: " + TofKindsP);//one of the labels on the scorecard
 TofKindP.setLayout(new GridLayout(100, 20));
 TofKindP.setVisible(false);
 contentPane.add(TofKindP);
                  
 FofKindP = new JLabel("Points: " + FofKindsP);//one of the labels on the scorecard
 FofKindP.setLayout(new GridLayout(100, 20));
 FofKindP.setVisible(false);
 contentPane.add(FofKindP);
 
 fullHP = new JLabel("Points: " + fullHsP);//one of the labels on the scorecard
 fullHP.setLayout(new GridLayout(100, 20));
 fullHP.setVisible(false);
 contentPane.add(fullHP);
 
 smallSP = new JLabel("Points: " + smallSsP);//one of the labels on the scorecard
 smallSP.setLayout(new GridLayout(100, 20));
 smallSP.setVisible(false);
 contentPane.add(smallSP);
 
 largeSP = new JLabel("Points: " + largeSsP);//one of the labels on the scorecard
 largeSP.setLayout(new GridLayout(100, 20));
 largeSP.setVisible(false);
 contentPane.add(largeSP);
 
 yahtzeeP = new JLabel("Points: " + yahtzeesP);//one of the labels on the scorecard
 yahtzeeP.setLayout(new GridLayout(100, 20));
 yahtzeeP.setVisible(false);
 contentPane.add(yahtzeeP);
 
 chanceP = new JLabel("Points: " + chancesP);//one of the labels on the scorecard
 chanceP.setLayout(new GridLayout(100, 20));
 chanceP.setVisible(false);
 contentPane.add(chanceP);
 
 end = new JButton("End the Game"); //first button to display everything on the panel
 end.setActionCommand("end");
 end.setAlignmentX(JButton.CENTER_ALIGNMENT);
 end.addActionListener(this);
 contentPane.add(end);
 
 
 
 
 frame.setContentPane(contentPane);//adding it to the frame
 
 frame.pack();
 frame.setVisible(true);
 
 }
 
public void actionPerformed(ActionEvent event) {//checks which button was clicked through the action listener
String eventName = event.getActionCommand();

if(eventName.equals("roll")) {//if it was rolled
  Random r = new Random();
  run = 1;//makes the other buttons clickable
  if(rolls < 3) {//checks if they have already rolled 3 times
    if (buttons<13) {//checks if the scorecard is fully used
      started = true;
      rolls+=1;//count up on rolls
      for(int i = 0; i < dNum.length; i++) {//this loop goes through the numbers list and resets the values on those that aren't clicked
        if (die[i]) {
          dNum[i] = r.nextInt(6-1+1) +1;//random gen.
        } else {
          die[i] = true;//making it clickable again
          dice1.setBackground(Color.white);
          dice2.setBackground(Color.white);
          dice3.setBackground(Color.white);
          dice4.setBackground(Color.white);
          dice5.setBackground(Color.white);
        }
      }
      //determines which dice face to display based on numbers by calling a method
      dice1.setIcon(new ImageIcon(DiceFace(dNum[0])));
      dice2.setIcon(new ImageIcon(DiceFace(dNum[1])));  
      dice3.setIcon(new ImageIcon(DiceFace(dNum[2])));
      dice4.setIcon(new ImageIcon(DiceFace(dNum[3])));
      dice5.setIcon(new ImageIcon(DiceFace(dNum[4])));
    } else {
      JOptionPane.showMessageDialog(null, "Game Over! Your total points: " + points,  "Status", JOptionPane.INFORMATION_MESSAGE);//if everything clciked, say game over
      Clear();
    }
  } else {//if rolled 3 times, button disappears and makes dice clickable
    rollDice.setVisible(false);
    dice1.setBackground(Color.white);
    dice2.setBackground(Color.white);
    dice3.setBackground(Color.white);
    dice4.setBackground(Color.white);
    dice5.setBackground(Color.white);
    for(int i = 0; i < die.length; i++) {
      die[i] = true;
    }
  }
} else if (eventName.equals("start")) {//start button displays all the buttons and labels
  rollDice.setVisible(true);
  start.setVisible(false);
  upperPoints.setVisible(true);
  lowerPoints.setVisible(true);
  dice1.setVisible(true);
  dice2.setVisible(true);
  dice3.setVisible(true);
  dice4.setVisible(true);
  dice5.setVisible(true);
  displayPoints.setVisible(true);
  ones.setVisible(true);
  twos.setVisible(true);
  threes.setVisible(true);
  fours.setVisible(true);
  fives.setVisible(true);
  sixes.setVisible(true);
  TofKind.setVisible(true);
  FofKind.setVisible(true);
  fullHouse.setVisible(true);
  smallS.setVisible(true);
  largeS.setVisible(true);
  yahtzee.setVisible(true);
  chance.setVisible(true);
  oneP.setVisible(true);
  twoP.setVisible(true);
  threeP.setVisible(true);
  fourP.setVisible(true);
  fiveP.setVisible(true);
  sixP.setVisible(true);
  TofKindP.setVisible(true);
  FofKindP.setVisible(true);
  fullHP.setVisible(true);
  smallSP.setVisible(true);
  largeSP.setVisible(true);
  yahtzeeP.setVisible(true);
  chanceP.setVisible(true);
} else if (eventName.equals("end")){  //this button ends the game
   if(started) {//if the dice has been rolled at least once in the game
     buttons = 14;//the amount of buttons clicked becomes bigger than the accepted number
     JOptionPane.showMessageDialog(null, "Game Over! Your total points: " + points,  "Status", JOptionPane.INFORMATION_MESSAGE);//display message
     Clear();
     //remove everything
     ones.setVisible(false);
     twos.setVisible(false);
     threes.setVisible(false);
     fours.setVisible(false);
     fives.setVisible(false);
     sixes.setVisible(false);
     TofKind.setVisible(false);
     FofKind.setVisible(false);
     fullHouse.setVisible(false);
     smallS.setVisible(false);
     largeS.setVisible(false);
     yahtzee.setVisible(false);
     chance.setVisible(false);
     oneP.setVisible(false);
     twoP.setVisible(false);
     threeP.setVisible(false);
     fourP.setVisible(false);
     fiveP.setVisible(false);
     sixP.setVisible(false);
     TofKindP.setVisible(false);
     FofKindP.setVisible(false);
     fullHP.setVisible(false);
     smallSP.setVisible(false);
     largeSP.setVisible(false);
     yahtzeeP.setVisible(false);
     chanceP.setVisible(false);
   }
} else {
//if the dice were clicked, a method makes the boolean its opposite, and then decides the color based on its boolean value through a method
   if(run!=0) {
     if(eventName.equals("Dice1")){
      die[0] = ReturnOpp(die[0]);
      dice1.setBackground(DecideColor(die[0]));
   } else if(eventName.equals("Dice2")){
      die[1] = ReturnOpp(die[1]);
      dice2.setBackground(DecideColor(die[1]));
   } else if(eventName.equals("Dice3")){
      die[2] = ReturnOpp(die[2]);
      dice3.setBackground(DecideColor(die[2]));
   } else if(eventName.equals("Dice4")){
      die[3] = ReturnOpp(die[3]);
      dice4.setBackground(DecideColor(die[3]));
   } else if(eventName.equals("Dice5")){
      die[4] = ReturnOpp(die[4]);
      dice5.setBackground(DecideColor(die[4]));
   } 
                  
     }
}
}
/**
 * send back a color to display based on boolean
 * pre: a boolean value that is initialized
 * post: color returned
 */
public Color DecideColor(boolean D) {
  if(D) {
    color = Color.white;
  } else {
    color = Color.gray;
  }
  return(color);
}
/**
 * send back a color to display based on boolean
 * pre: a boolean value that is initialized
 * post: color returned to show that the button on that scorecard is clicked
 */
public Color ClickedOrNot(boolean BV) {
  if(!(BV)) {
    color1 = Color.pink;
  } 
  return(color1);
}
/**
 * send back a string that will display the image based on number sent
 * pre: number has to be sent as parameter
 * post: string returned and image changes
 */
public String DiceFace(int num) {
  String face;
  if(num == 1) {
   face = "die1.gif";  
  } else if(num == 2) {
   face = "die2.gif";  
  } else if(num == 3) {
   face = "die3.gif";  
  } else if(num == 4) {
   face = "die4.gif";  
  } else if(num == 5) {
   face = "die5.gif";  
  } else {
    face = "die6.gif";  
  }
  return(face);
}
/**
 * makes the value  its opposite to make the dice button get held
 * pre: a boolean value that is initialized
 * post: opposite value returned
 */
public boolean ReturnOpp(boolean click) {
 boolean returnV;
 if(click) {
   returnV = false;
 } else {
   returnV = true;
 }
  
  return(returnV);
}
//a whole new nested class just for reacting to the scorecard buttons
class ScoreCard implements ActionListener {
  
 public void actionPerformed(ActionEvent event) {
  String eventName = event.getActionCommand();
  
  
  if (run!=0) { //checks if dice has been rolled
    if(buttons<13) {//checks if all buttons are clicked
      //this decision structure only exists to prevent a button from being clicked more than once
       //checks which button was clicked
      if(eventName.equals("ones")){
        oneB = Pressed(oneB, eventName, "ones", 1);//a method call for adding the proper points after checking if its clicked
        ones.setBackground(ClickedOrNot(oneB));//method decides background color
        onesP = Points(oneB, 1);//adds its own individual points
        oneP.setText("Points: " + onesP);
      } else if(eventName.equals("twos")) {
        twoB = Pressed(twoB, eventName, "twos", 2);//a method call for adding the proper points after checking if its clicked
        twos.setBackground(ClickedOrNot(twoB));
        twosP = Points(twoB, 2);//adds its own individual points
        twoP.setText("Points: " + twosP);
      } else if(eventName.equals("threes")) {
        threeB = Pressed(threeB, eventName, "threes", 3);//a method call for adding the proper points after checking if its clicked
        threes.setBackground(ClickedOrNot(threeB));
        threesP = Points(threeB, 3);//adds its own individual points
        threeP.setText("Points: " + threesP);
      } else if(eventName.equals("fours")) {             
        fourB = Pressed(fourB, eventName, "fours", 4);//a method call for adding the proper points after checking if its clicked
        fours.setBackground(ClickedOrNot(fourB));
        foursP = Points(fourB, 4);//adds its own individual points
        fourP.setText("Points: " + foursP);
      } else if(eventName.equals("fives")) {   
        fiveB = Pressed(fiveB, eventName, "fives", 5);//a method call for adding the proper points after checking if its clicked
        fives.setBackground(ClickedOrNot(fiveB));
        fivesP = Points(fiveB, 5);//adds its own individual points
        fiveP.setText("Points: " + fivesP);
      } else if(eventName.equals("sixes")) {  
        sixB = Pressed(sixB, eventName, "sixes", 6);//a method call for adding the proper points after checking if its clicked
        sixes.setBackground(ClickedOrNot(sixB));
        sixesP = Points(sixB, 6);//adds its own individual points
        sixP.setText("Points: " + sixesP);
      } else if(eventName.equals("TofKind")) {  
        TofKindB = Pressed(TofKindB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        TofKind.setBackground(ClickedOrNot(TofKindB));//method decides background color
        TofKindP.setText("Points: " + TofKindsP);
      } else if(eventName.equals("FofKind")){ 
        FofKindB = Pressed(FofKindB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        FofKind.setBackground(ClickedOrNot(FofKindB));//method decides background color
        FofKindP.setText("Points: " + FofKindsP);
      } else if(eventName.equals("fullHouse")){
        fullHouseB = Pressed(fullHouseB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        fullHouse.setBackground(ClickedOrNot(fullHouseB));//method decides background color
        fullHP.setText("Points: " + fullHsP);
      } else if(eventName.equals("smallS")){
        smallSB = Pressed(smallSB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        smallS.setBackground(ClickedOrNot(smallSB));//method decides background color
        smallSP.setText("Points: " + smallSsP);
      } else if(eventName.equals("largeS")){
        largeSB = Pressed(largeSB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        largeS.setBackground(ClickedOrNot(largeSB));//method decides background color
        largeSP.setText("Points: " + largeSsP);
      } else if(eventName.equals("yahtzee")){
        yahtzeeB = Pressed(yahtzeeB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        yahtzee.setBackground(ClickedOrNot(yahtzeeB));//method decides background color
        yahtzeeP.setText("Points: " + yahtzeesP);
      } else if(eventName.equals("chance")){
        chanceB = Pressed(chanceB, eventName, " ", 0);//a method call for adding the proper points after checking if its clicked
        chance.setBackground(ClickedOrNot(chanceB));//method decides background color
        chanceP.setText("Points: " + chancesP);
      }
    
    } else {
       JOptionPane.showMessageDialog(null, "Game Over! Your total points: " + points,  "Status", JOptionPane.INFORMATION_MESSAGE);//display message
    }
  }
  upperTotal = onesP + twosP + threesP + foursP + fivesP + sixesP;//adds up the points for its category
  lowerTotal = TofKindsP + FofKindsP + fullHsP + smallSsP + largeSsP + yahtzeesP + chancesP;
  
  //update the points
  upperPoints.setText("Upper Points: " + upperTotal);
  lowerPoints.setText("Lower Points: " + lowerTotal);
  displayPoints.setText("Total Points: " + (points));
}
}
/**
 * checks if button clicked and then adds the points based on whether the points are valid
 * pre: a boolean value and the eventname have to be sent, and soemtimes a number for getting points
 * post: boolean value false returned to prevent a repeated click
 */
public boolean Pressed(boolean press,String eventName, String command,int num) {
  boolean rtnV = true;
  totalOfNums = 0;//reset value each time
  for(int i = 0; i < dNum.length; i++) {
      totalOfNums += dNum[i];//sets the total
    }
  if(press) {//checks if clicked
    
    //the clear method is called after every button click to make everything except roll button unclickable
    if(eventName.equals("TofKind")) {
      //checks if any number shows up three or more times and  adds points
       if((CountOcc(1) >= 3) || (CountOcc(2) >= 3) ||(CountOcc(3) >= 3) ||(CountOcc(4) >= 3) ||(CountOcc(5) >= 3) ||(CountOcc(6) >= 3) ){
        points += (totalOfNums);
        TofKindsP = totalOfNums;
       }
       Clear();
       rtnV = false;
       
    } else if(eventName.equals("FofKind")) {
      //checks if any number shows up four or more times and  adds points
       if((CountOcc(1) >= 4) || (CountOcc(2) >= 4) ||(CountOcc(3) >= 4) ||(CountOcc(4) >= 4) ||(CountOcc(5) >= 4) ||(CountOcc(6) >= 4) ){
        points += (totalOfNums);
        FofKindsP = totalOfNums;
       }
       Clear();
       rtnV = false;
    } else if(eventName.equals("fullHouse")) {
      //this loop runs to see if any number comes three times, and then checks if another number comes twice
       for(int i = 0; i < dNum.length; i++) {
         if(CountOcc(dNum[i]) == 3) {
           if((CountOcc(1) == 2) || (CountOcc(2) == 2) ||(CountOcc(3) == 2) ||(CountOcc(4) == 2) ||(CountOcc(5) == 2) ||(CountOcc(6) == 2)) {
             points += 25;
             fullHsP = 25;
             break;//breaks when found
           }   
         }
        }
       rtnV = false;
       Clear();
    } else if(eventName.equals("smallS")) {
      //checks if consecutive numbers show up in the rolls 4 times
      if(((CountOcc(1) >= 1) && (CountOcc(2) >= 1) && (CountOcc(3) >= 1) && (CountOcc(4) >= 1)) || 
         ((CountOcc(2) >= 1) && (CountOcc(3) >= 1) && (CountOcc(4) >= 1) && (CountOcc(5) >= 1)) || 
         ((CountOcc(3) >= 1) && (CountOcc(4) >= 1) && (CountOcc(5) >= 1) && (CountOcc(6) >= 1)) ) {
           points += 30;
           smallSsP = 30;
      }
       rtnV = false;
       Clear();
    } else if(eventName.equals("largeS")) {
      //checks if consecutive numbers show up in the rolls 5 times
       if(((CountOcc(1) == 1) && (CountOcc(2) == 1) && (CountOcc(3) == 1) && (CountOcc(4) == 1) && (CountOcc(5) == 1))  || 
         ((CountOcc(2) == 1) && (CountOcc(3) == 1) && (CountOcc(4) == 1) && (CountOcc(5) == 1) && (CountOcc(6) == 1))) {
           points += 40;
           largeSsP = 40;
       }
      
       rtnV = false;
       Clear();
    } else if(eventName.equals("yahtzee")) {
      //if all numbers are the same
       if((dNum[0] == dNum[1]) && (dNum[1] == dNum[2]) && (dNum[2] == dNum[3]) && (dNum[3] == dNum[4])) {
         points += 50;
         yahtzeesP = 50;
         
       }
       rtnV = false;
       Clear();
    } else if(eventName.equals("chance")) {
      //adds the total to the points
       points += totalOfNums;
       chancesP = totalOfNums;
       Clear();
       rtnV = false;
    } else if (eventName.equals(command)) {
      //this method works for buttons ones to sixes and uses the parameter to add points
      points += ((CountOcc(num))*num);
      Clear();
      rtnV = false;
    }
    buttons += 1;
  } else {
     rtnV = false;
  displayPoints.setText("Total Points: " + (points));
}
  return(rtnV);
}
/**
 * sets the amount of points on the variable
 * pre:the boolean value is initialized
 * post: points returned
 */
public int Points(boolean pressed, int num1) {
  int num3 = 0;
  if(!(pressed)) {
    num3 = (CountOcc(num1) * num1);
  }
  return num3;
}
/**
 * counts the total occurences of the number sent 
 * pre: number parameter
 * post: sends back the amount of times the number occured
 */
public int CountOcc(int num) {
  int occurences = 0;
  for(int i = 0; i < dNum.length; i++) {
    if (dNum[i] == num){
    occurences += 1;
    }
  }
  return(occurences);
}
/**
 * method makes everything except roll button unclickable
 * pre:
 * post: variables are reset
 */
public void Clear() {
 run = 0;
 rolls = 0;
 dice1.setBackground(Color.white);
 dice2.setBackground(Color.white);
 dice3.setBackground(Color.white);
 dice4.setBackground(Color.white);
 dice5.setBackground(Color.white);
 rollDice.setVisible(true);
 for(int i = 0; i < die.length; i++) {
      die[i] = true;
}
}
 /**
 * Create and show the GUI.
 */
 private static void runGUI() {
   
 JFrame.setDefaultLookAndFeelDecorated(true);
 Yahtzee game = new Yahtzee();
 }
 public static void main(String[] args) {

 javax.swing.SwingUtilities.invokeLater(new Runnable() {
 public void run() {
 runGUI();
 }
 });
 }
 }
