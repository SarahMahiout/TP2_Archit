import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControleurInscription implements ActionListener {

	private AbstractViewInscription viewInscription;
	private EtudiantService Service;
	
	public ControleurInscription(AbstractViewInscription viewInscription,EtudiantService Service) {
		
		this.viewInscription=viewInscription;
		this.Service=Service;
		

	}



@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	if(arg0.getSource()==viewInscription.getValider()) {
	
		if(viewInscription.champs_validation()) {
			InterfEtudiant etud = new Etudiant(Integer.valueOf(viewInscription.Get_Mat()), viewInscription.Get_Mat(), viewInscription.Get_pwd(), viewInscription.Get_email(),viewInscription.Get_pwd(), Integer.valueOf(viewInscription.Get_id_univ()));
			
			try {
				   
				if(Service.inscription(etud)) {
					
					viewInscription.ShowDialog("Inscription réussie !");
					viewInscription.Init_Champsn();
					
				}else {
					viewInscription.ShowErreur("Inscription non réussie !");
					
				}
				
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	if(arg0.getSource()==viewInscription.getAnnuler()) {
			viewInscription.Annuler_Inscription();
	}
	
	
	
}
	
}