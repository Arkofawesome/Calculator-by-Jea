/* @author Jackson Lee
*Calculator Program for mini project
*/
package javaapplication2;
import java.awt.event.*;
import javax.swing.*; 
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;
public class JavaApplication2 {

    // Class variable Declarations here
    private static double result = 0.0;
    private static double input1 = 0.0;
    private static double input2 = 0.0;
    private static int check = 0;
    private static int checker = 0;
    private static int operation = 0;
    private static JButton[] numberedButtons = new JButton[10];
    private static String inputString1 = "0";
    private static JLabel displayer = new JLabel(String.valueOf(input1));
    private static JFrame calculator = new JFrame("Super Cool Calc"); 
    public static void main(String[] args) {
        //Create main window and displayer
        createWindow();
        createDisplayer();
        
        //create the number buttons
        makeNumberedButton(7,0,250);
        makeNumberedButton(8,80,250);
        makeNumberedButton(9,160,250);
        makeNumberedButton(4,0,330);
        makeNumberedButton(5,80,330);
        makeNumberedButton(6,160,330);
        makeNumberedButton(1,0,410);
        makeNumberedButton(2,80,410);
        makeNumberedButton(3,160,410);
        makeNumberedButton(0,80,490);
        

        // buttons for different uses
        JButton percentage = new JButton("%");
        percentage.setBounds(0,90,80,80);
        calculator.add(percentage);
        percentage.setBackground(Color.LIGHT_GRAY);
        percentage.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs

                input1 = Double.parseDouble(inputString1);
                input1 *= 0.01;
                inputString1 = Double.toString(input1);
                displayer.setText(String.valueOf(input1));
                System.out.println(input1);
                System.out.println(inputString1);
            }
        });
        JButton clearEntry= new JButton("CE");
        clearEntry.setBounds(80,90,80,80);
        calculator.add(clearEntry);
        clearEntry.setBackground(Color.LIGHT_GRAY);
        clearEntry.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if(Double.parseDouble(inputString1) != 0){
                    inputString1 = "0";
                    input1 = Double.parseDouble(inputString1);
                    displayer.setText(String.valueOf(input1));
                    System.out.println(input1);
                    System.out.print(inputString1);  
                }//end if
                

            }//end actionPerformed
        });
        
        JButton clear = new JButton("C");
        clear.setBounds(160,90,80,80);
        calculator.add(clear);
        clear.setBackground(Color.LIGHT_GRAY);
        clear.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                result = 0.0;
                input1 = 0.0;
                input2 = 0.0;
                check = 0;
                checker = 0;
                operation = 0;
                inputString1 = "0";
                displayer.setText(String.valueOf(input1));
            }//end actionPerformed
        });
        
        JButton fraction = new JButton("1/x");
        fraction.setBounds(0,170,80,80);
        calculator.add(fraction);
        fraction.setBackground(Color.LIGHT_GRAY);
        fraction.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs

                input1 = Double.parseDouble(inputString1);
                input1 = 1 / input1;
                inputString1 = Double.toString(input1);
                displayer.setText(String.valueOf(input1));
            }//end actionPerformed
        });

        JButton squared = new JButton("x²");
        squared.setBounds(80,170,80,80);
        calculator.add(squared);
        squared.setBackground(Color.LIGHT_GRAY);
        squared.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs

                input1 = Double.parseDouble(inputString1);
                input1 = input1 * input1;
                inputString1 = Double.toString(input1);
                displayer.setText(String.valueOf(input1));
            }//end actionPerformed
        });

        JButton squareRoot = new JButton("√x");
        squareRoot.setBounds(160,170,80,80);
        calculator.add(squareRoot);
        squareRoot.setBackground(Color.LIGHT_GRAY);
        squareRoot.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs

                input1 = Double.parseDouble(inputString1);
                input1 = Math.sqrt(input1);
                inputString1 = Double.toString(input1);
                displayer.setText(String.valueOf(input1));
            }//end actionPerformed
        });
        
        
        JButton negate = new JButton("+/-");
        negate.setBounds(0,490,80,80);
        calculator.add(negate);
        negate.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                inputString1 = "-" + inputString1;
                if (inputString1.indexOf("--") >= 0){
                    inputString1 = inputString1.substring(2, inputString1.length());
                }//end if
                input1 = Double.parseDouble(inputString1);
                System.out.println(input1);
                System.out.println(inputString1);
                displayer.setText(String.valueOf(input1));
            }//end actionPerformed
        });
        
        JButton decimal= new JButton(".");
        decimal.setBounds(160,490,80,80);
        calculator.add(decimal);
        decimal.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if (check < 1){
                    inputString1 += ".";
                    check++;
                    System.out.println(inputString1);
                }//end if

            }//end actionPerformed
        });

  //create delete button
        JButton deleteButton = new JButton("←");
        deleteButton.setBounds(240,90,100,80);
        calculator.add(deleteButton);
        deleteButton.setBackground(Color.LIGHT_GRAY);
        deleteButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if(Double.parseDouble(inputString1) != 0){
                  inputString1 = inputString1.substring(0,inputString1.length() - 1);
                input1 = Double.parseDouble(inputString1);
                displayer.setText(String.valueOf(input1));
                System.out.println(input1);
                System.out.print(inputString1);  
                }//end if
                

            }//end actionPerformed
        });

        // Create add button
        JButton addButton = new JButton("+");
        addButton.setBounds(240,170,100,80);
        calculator.add(addButton);
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if(checker > 0){
                    //input2 = input2 + Double.parseDouble(inputString1);
                    input2 = runOperation(input2, Double.parseDouble(inputString1), operation);
                }//end if
                else{
                    input2 = Double.parseDouble(inputString1); 
                    checker++;
                }//end else

                inputString1 = "0";
                System.out.print(input2);
                operation = 1;
                displayer.setText(String.valueOf(input2));
            }//end actionPerformed
        });



        // Add Code for subtraction button
        JButton subtractButton = new JButton("-");
        subtractButton.setBounds(240,250,100,80);
        calculator.add(subtractButton);
        subtractButton.setBackground(Color.LIGHT_GRAY);
        subtractButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if(checker > 0){
                    //input2 = input2 - Double.parseDouble(inputString1);
                    input2 = runOperation(input2, Double.parseDouble(inputString1), operation);
                }
                else{
                    input2 = Double.parseDouble(inputString1); 
                    checker++;
                }

                inputString1 = "0";
                System.out.print(input2);
                operation = 2;
                displayer.setText(String.valueOf(input2));
            }//end actionPerformed
        });
        
        // Add Code for multiplication button
        JButton multiplicationButton = new JButton("x");
        multiplicationButton.setBounds(240,330,100,80);
        calculator.add(multiplicationButton);
        multiplicationButton.setBackground(Color.LIGHT_GRAY);
        multiplicationButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                if(checker > 0){
                    //input2 = input2 * Double.parseDouble(inputString1);
                    input2 = runOperation(input2, Double.parseDouble(inputString1), operation);
                }
                else{
                    input2 = Double.parseDouble(inputString1); 
                    checker++;
                }

                inputString1 = "0";
                System.out.print(input2);
                operation = 3;
                displayer.setText(String.valueOf(input2));
            }//end actionPerformed
        });


        // Add Code for division button
        JButton divisionButton = new JButton("÷");
        divisionButton.setBounds(240,410,100,80);
        calculator.add(divisionButton);
        divisionButton.setBackground(Color.LIGHT_GRAY);
        divisionButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                
                if(checker > 0){
                    //input2 = input2 / Double.parseDouble(inputString1);
                    input2 = runOperation(input2, Double.parseDouble(inputString1), operation);
                }
                else{
                    input2 = Double.parseDouble(inputString1); 
                    checker++;
                }

                inputString1 = "0";
                System.out.print(input2);
                operation = 4;
                displayer.setText(String.valueOf(input2));
            }//end actionPerformed
        });

        // Create equals button to press for result to display
        JButton equalsButton = new JButton("=");
        equalsButton.setBounds(240,490, 100,80);
        calculator.add(equalsButton);
        equalsButton.setBackground(Color.CYAN);
        equalsButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                input1 = runOperation(input2, Double.parseDouble(inputString1), operation);
                displayer.setText(String.valueOf(input1));
                //reset checker
                //checker = 0;
            }//end actionPerformed
        });
       calculator.setVisible(true);    
    }//end main()



    /*
    *runOperation()
    *@param the first value
    *@param the second value
    *@param double value corresponding to the operation
    *@return double result - value of correct opperation
    */
    public static double runOperation(double firstValue, double secondValue, int operation){
        switch (operation){
            case 0:   
                break;
            case 1:
                result = firstValue + secondValue;
                break;
            case 2:
                result = firstValue - secondValue;
                break;
            case 3:
                result = firstValue * secondValue;
                break;
            case 4:
                result = firstValue / secondValue;
                break;
            default:
                System.out.println("ERROR");
                break;

        }//end switch
        return result;
    }//end runOperation()
    
    /*
    *makeNumberedButton()
    *@param int the desired number
    *@param int the x value
    *@param int the y value
    */
    public static void  makeNumberedButton(int desiredNumber, int x_value, int y_value){
        numberedButtons[desiredNumber] = new JButton(Integer.toString(desiredNumber));
        numberedButtons[desiredNumber].setBounds(x_value,y_value,80,80);
        calculator.add(numberedButtons[desiredNumber]);
        numberedButtons[desiredNumber].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // insert code that you want to occur when actoin occurs
                inputString1 += Integer.toString(desiredNumber);
                input1 = Double.parseDouble(inputString1);
                displayer.setText(String.valueOf(input1));
            }
        });
    }//end makeNumberedButton
  
    /*
    *createWindow()
    *no param
    *@return a working JFrame Window
    */
    public static void createWindow(){
        calculator.setResizable(false);
        calculator.setSize(350,600);        
        calculator.setLayout(null);         
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end createWindow()
    
    /*
    *createDisplayer)_
    *simple code to create displayer to show inputed numbers and results
    */
    public static void createDisplayer(){
        displayer.setBounds(0,40, 350,50);
        displayer.setFont(new Font("Verdana", Font.PLAIN, 40));
        calculator.add(displayer);
    }//end createDisplayer
}//end class








