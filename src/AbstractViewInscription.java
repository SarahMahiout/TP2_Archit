
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public abstract class AbstractViewInscription extends Observable {


	ArrayList<ActionListener> observable = new ArrayList<ActionListener>();

	public void addObserver(ActionListener actionListner) {

		if(!observable.contains(actionListner)){
			observable.add(actionListner);
			 }

	}


	public void deleteObserver(ActionListener actionListner) {
		int num = observable.indexOf(actionListner);
		observable.remove(num);


	}


	public void notifyObservers(JButton b) {

		for(ActionListener x : observable) {
			b.addActionListener(x);

		}
	}

	public abstract void addListnerButton();


	public abstract JButton getValider();


	public abstract boolean champs_validation();


	public abstract String Get_Mat();


	public abstract String Get_pwd();


	public abstract String Get_id_univ();


	public abstract String Get_email();


	public abstract void ShowDialog(String string);


	public abstract void Init_Champsn();


	public abstract void ShowErreur(String string);


	public abstract void Show_Inscription();


	public abstract void Annuler_Inscription();


	public abstract JButton getAnnuler();
}













