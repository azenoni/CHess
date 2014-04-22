import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class TableApplet extends Applet implements ActionListener{

	
	public void actionPerformed(ActionEvent ae) {
		dealerSum = dealer.getValue();
		playerSum = player.getValue();
		answer = "";
		if ("Hit".equals(ae.getActionCommand())) {
			hit();
			
		} else if ("Stay".equals(ae.getActionCommand())) {
			stay();
		}

		if ("New Game".equals(ae.getActionCommand())) {
			dealerSum = 0;
			front = false;
			first = true;
			dealer.amountOfCards = 2;
			player.amountOfCards = 2;	
			first = true;
			playerWin = false;
			playerTie = false;
			dealerWin = false;
			repaint();
		}
		if ("Bet $10".equals(ae.getActionCommand())) {
			pot += 20;
			wallet -=10;
			label.setText("You have $" + wallet + " the pot is $" + pot);
		}
		if ("Confirm Bet".equals(ae.getActionCommand())) {
			first = false;
			initialDeal();
			repaint();
		}

		if ("Double Down".equals(ae.getActionCommand())) {
			wallet -= pot/2;
			pot += pot;
			hit();
			stay();
			doubleDown.setEnabled(false);
			label.setText("You have $" + wallet + " the pot is $" + pot);
		}
	}
}