import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControleurInscription {

	private ViewInscription viewInscription;
	private EtudiantService Service;

	public ControleurInscription(ViewInscription viewInscription,EtudiantService Service) {

		this.viewInscription=viewInscription;
		this.Service=Service;

		this.viewInscription.addInscrirListener(new InscrirListener());
		this.viewInscription.addAnnulerListener(new AnnulerListener());
	}


	public class InscrirListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub



			if(viewInscription.champs_validation()) {
				InterfEtudiant etud = new Etudiant(Integer.valueOf(viewInscription.Get_Mat()), viewInscription.Get_Name(), viewInscription.Get_Prenom(), viewInscription.Get_email(),viewInscription.Get_pwd(), Integer.valueOf(viewInscription.Get_id_univ()));

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

	}


	public class AnnulerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			viewInscription.Annuler_Inscription();

		}


	}









}