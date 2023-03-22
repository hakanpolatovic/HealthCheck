import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;                   	
import javax.swing.JFrame;                     
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Main {
	
	public static String[] answer=new String[10]; //This is a string array for answers
	public static String name;  //This is a string for user's name

	
	public static void main(String[] args) {
		
			
		
		
		String[] question=new String[9];	//This is a string array contains all questions
		
		String results = question0analyze();		//This is a string for results	
		question[0] = "What is your gender? 1=male 2=female";
		question[1] = "What is your height? (in cm)";
		question[2] = "What is your weight? (in kg)";
		question[3] = "Alcohol Consumption (Rate 1 to 10)";
		question[4] = "Cigarette Consumption (Rate 1 to 10)";
		question[5] = "Junk Food Consumption (Rate 1 to 10)";
		question[6] = "Do you do Sports? (Rate 1 to 10)";
		question[7] = results;		//Last string of question array is answers,therefore there is no need for an extra variable
		
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("HealthCheck");	//This five lines define our java frame
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel questionfield = new JLabel(); //questionfield is a label contains all of our text content
		questionfield.setText("<html>Welcome to the HealthCheck!<br/>Fatum is a basic calculating algorithm that takes your info and "
				+ "by applying some mathematical formula,it gives you a output about your health.Since these "
				+ "calculations are just basic outputs there is no need to take it serious.Please type your"
				+ "name to begin!</html>");
		
		
		questionfield.setFont(new Font("Verdana", Font.PLAIN, 18));	//adjustments for our text
		questionfield.setBounds(25,-0, 450, 200);
		
		JTextArea answers = new JTextArea();	//answers is a textarea for getting user input and adjustments follows
		answers.setBackground(Color.black);
		answers.setForeground(Color.white);
		answers.setBounds(187,450, 225, 37);
		answers.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JButton submit = new JButton("Submit");
		
		submit.setBounds(262, 500, 75, 25);
	
		
		frame.add(answers);			//now we add these fields to the main frame
		frame.add(questionfield);
		frame.add(submit);
		
		frame.setResizable(false);
		
	
		
		frame.setVisible(true); 		//we set our frame visible
		
		
		
		submit.addActionListener(new ActionListener() { //This part listens for mouse clicks on our button,it's always active
			int i=0;	//This is for showing next question each time
		
			@Override
			public void actionPerformed(ActionEvent e) {
			if(i==0) {name=answers.getText();}
				
				
			questionfield.setText(question[i]);
			answer[i]=answers.getText();		//Everytime user clicks button,we ask the new question
			System.out.println(answer[i]);
			if(i==7) {
				
				results();	//when we ask all seven question to the user,we will show results
			
			}
			i++;
			
			
			}

			public void results() {	//Results are a combination of four different methods
				
				// TODO Auto-generated method stub
				questionfield.setText(question0analyze()+question1analyze()+question3analyze()+question4analyze());
			
				
			}
			
			
			
			
			
		});
		


		
		
	}

	public static  String question0analyze() { //in this part we calculate user's bmi and output a result depending on it
		
		// TODO Auto-generated method stub
		try {
			int height = Integer.parseInt(answer[2]);
			float heightinmeters = (float) height / 100;
			int weight = Integer.parseInt(answer[3]);
			float bmi = weight/(heightinmeters*heightinmeters);
			if(bmi<18.5) {
				return "<html>Body Max Index="+ bmi +"<br/>You are underweight.Try to gain some weight!";
			}
			if(bmi>=18.5 && bmi<25) {
				return "<html>Body Max Index="+ bmi +"<br/>You are in healthy weight range.Stay fit!";
			
			}
			if(bmi>=25 && bmi<30) {
				return "<html>Body Max Index="+ bmi +"<br/>You are overweight.Try to lose some weight!";
			}
			if(bmi>30) {
				return "<html>Body Max Index="+ bmi +"<br/>You are in obesity range.Better to get medical help";
			}
		
			
			
			
			return "Body Max Index="+ bmi ;
			
			
			
	    } catch (NumberFormatException e) {
	        return null;
	    }
		
	

		
	}
	public static String question1analyze() { //In this method we analyze alcohol consumption
		int alcohol = Integer.parseInt(answer[4]);
		switch(alcohol) {
		case 1,2,3:
			return "";
		case 4,5,6:
			return " <html>You must lower your alcohol consumption!<html> ";
		}
		if(alcohol>=7) {
			return " <html>You must lower your alcohol consumption!<br/>Maybe get some medical help!<br/><html> ";
		}
		if(alcohol<=0) {
			return " ";
		}
		return " ";
		// TODO Auto-generated method stub
	
	}
	public static String question2analyze() { //In this method we analyze cigarette consumption
		// TODO Auto-generated method stub
		int cigarette = Integer.parseInt(answer[5]);
		switch(cigarette) {
		case 1,2,3:
			return "";
		case 4,5,6:
			return " <html>You must lower your cigarette consumption!<br/><html> ";
		}
		if(cigarette>=7) {
			return " <html>You must lower your cigarette consumption!<br/>Maybe get some medical help!<br/><html> ";
		}
		if(cigarette<=0) {
			return " ";
		}
		return " ";
	}
	public static String question3analyze() { //In this method we analyze junk food consumption
		int junkfood = Integer.parseInt(answer[6]);
		switch(junkfood) {
		case 1,2,3:
			return " <html>Nice for you to not eating any junk food!<br/><html>";
		case 4,5,6:
			return " <html>Junk foods are bad for your health.<br/>Lower consumption is advisable<br/><html> ";
		}
		if(junkfood>=7) {
			return " <html>Eating that much junk food may result various health problems<br/><html> ";
		}
		if(junkfood<=0) {
			return " ";
		}
		return " ";
		// TODO Auto-generated method stub
	
	}
	public static String question4analyze() { //In this method we analyze sports
		int sports = Integer.parseInt(answer[7]);
		switch(sports) {
		case 1,2,3:
			return " <html>It would be better if you do more sports<br/><html>";
		case 4,5,6:
			return " <html>Doing sports are a key to healthy life! Keep up!<br/><html> ";
		}
		if(sports>=7) {
			return " <html>That much of sports will make you a superman! Keep Up!<br/><html> ";
		}
		if(sports<=0) {
			return " Healthy life is impposible without doing sports! Consider that..";
		}
		return " ";
	}

	



}
