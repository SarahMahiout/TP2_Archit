import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Image;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;



public class ViewInscription extends AbstractViewInscription  {
    
	private JFrame Jframe;
    private JPanel Panel;
    private JTextField EditTextMat;
    private JTextField EditTxtNom;
    private JTextField EditTxtPrenom;
    private JTextField EditTxtEmail;
    private JPasswordField EditTxtPwd;
    private JTextField EditTxtUnivId;
    private JButton valider;
   

	public JButton getValider() {
		return valider;
	}

	public JButton getAnnuler() {
		return annuler;
	}

	private JButton annuler;
    
    
    
    private void initialiser() {
        
    	// creer Frame
        this.Jframe = new JFrame();
        Jframe.setBounds(300, 300, 450, 350);
        Jframe.setResizable(false);
        Jframe.setDefaultCloseOperation(3);
        Jframe.getContentPane().setLayout(null);
        
        // creer conteneur
        this.Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        Jframe.setContentPane(this.Panel);
        Panel.setLayout(null);
        
        // lablel text Matricule
        final JLabel Lab_Matricule = new JLabel("Matricule");
        Lab_Matricule.setBounds(30, 33, 68, 17);
        this.EditTextMat = new JTextField("");
        EditTextMat.setBounds(184, 27, 200, 20);
        EditTextMat.setColumns(10);
        
        
     // lablel text Nom
        final JLabel LabNom = new JLabel("Nom");
        LabNom.setBounds(30, 60, 46, 14);
        this.EditTxtNom = new JTextField("");
        EditTxtNom.setBounds(184, 54, 200, 20);
        EditTxtNom.setColumns(10);
        
     // lablel text prenom
        final JLabel LabPrenom = new JLabel("Pr\u00e9nom");
        LabPrenom.setBounds(30, 91, 46, 14);
        this.EditTxtPrenom = new JTextField("");
        EditTxtPrenom.setBounds(184, 85, 200, 20);
        EditTxtPrenom.setColumns(10);
        
     // lablel text Email
        final JLabel LabEmail = new JLabel("Email");
        LabEmail.setBounds(30, 126, 46, 14);
        this.EditTxtEmail = new JTextField("");
        EditTxtEmail.setColumns(10);
        EditTxtEmail.setBounds(184, 120, 200, 20);
        
        
     // lablel text Mdp
        final JLabel LabPwd = new JLabel("Mots de passe");
        LabPwd.setBounds(30, 165, 90, 14);
        this.EditTxtPwd = new JPasswordField("");
        EditTxtPwd.setColumns(10);
        EditTxtPwd.setEchoChar('*');
        EditTxtPwd.setBounds(184, 159, 200, 20);
        
     // lablel text UnivId
        final JLabel LabId_Univ = new JLabel("Identifiant universit\u00e9");
        LabId_Univ.setBounds(30, 200, 125, 14);
        this.EditTxtUnivId = new JTextField("");
        EditTxtUnivId.setColumns(10);
        EditTxtUnivId.setBounds(184, 194, 200, 20);
        
        
     // valider btn
        //this.btnSubmit = new JButton("Confirmer", new ImageIcon("vert.png"));
        Image img = new ImageIcon("C:\\Users\\Hacker\\Desktop\\Rep\\TP2_Archit\\src\\vert.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        
        Icon icon= new ImageIcon(img);
        valider = new JButton("valider" ,icon);
        valider.setBounds(270, 250, 120, 30);
        
     // Annuler btn
        
        Image imgred = new ImageIcon("C:\\Users\\Hacker\\Desktop\\Rep\\TP2_Archit\\src\\red.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        
        Icon iconred= new ImageIcon(imgred);
        this.annuler = new JButton("Annuler",iconred);
        annuler.setBounds(120, 250, 120, 30);
        
        this.Panel.add(Lab_Matricule);
        this.Panel.add(EditTextMat);
        this.Panel.add(LabNom);
        this.Panel.add(EditTxtNom);
        this.Panel.add(LabPrenom);
        this.Panel.add(EditTxtPrenom);
        this.Panel.add(LabEmail);
        this.Panel.add(EditTxtEmail);
        this.Panel.add(LabPwd);
        this.Panel.add(EditTxtPwd);
        this.Panel.add(LabId_Univ);
        this.Panel.add(EditTxtUnivId);
        this.Panel.add(valider);
        this.Panel.add(annuler);
    }
    
	@Override
	public void addListnerButton() {
		// TODO Auto-generated method stub
		notifyObservers(valider);
		notifyObservers(annuler);
		
		
	}
    
    
    

    
    public boolean champs_validation() {
    	
        if (Get_Mat().isEmpty() || Get_Name().isEmpty() || Get_Prenom().isEmpty() || Get_email().isEmpty() || Get_pwd().isEmpty() || Get_id_univ().isEmpty()) {
            this.ShowErreur("veuillez remplir tous les champs");
            return false;
        }
        if (!this.EditTextMat.getText().matches("-?\\d+") || !this.EditTxtUnivId.getText().matches("-?\\d+")) {
            this.ShowErreur("les champs matricule et id universit\u00e9 doivent etre de format num\u00e9riques ");
            return false;
        }
        if (!this.EditTxtEmail.getText().matches("^(.+)@(.+)$")) {
            this.ShowErreur("il faut respecter le format d'un email xxx@xxx.xxx");
            return false;
        }
        return true;
    }
    
    


    
    
    
    
    public void Show_Inscription() {
        this.initialiser();
        this.Jframe.setVisible(true);
        
    }
    
    public void Annuler_Inscription() {
        this.Jframe.dispose();
        
    }
    
   /* void addInscrirListener(ActionListener listenForCalcButton) {
    	valider.addActionListener(listenForCalcButton);
    }
    
    void addAnnulerListener(ActionListener listenForCalcButton) {
    	annuler.addActionListener(listenForCalcButton);
    }*/
    
    public void Init_Champsn() {
        this.EditTextMat.setText("");
        this.EditTxtNom.setText("");
        this.EditTxtPrenom.setText("");
        this.EditTxtEmail.setText("");
        this.EditTxtPwd.setText("");
        this.EditTxtUnivId.setText("");
    }

    
    public void ShowDialog(final String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg);
    }
    
    public void ShowErreur(final String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg, "Erreur", 0);
    }
     
    public String Get_Mat() {
        return this.EditTextMat.getText();
    }
    
    public String Get_Name() {
        return this.EditTxtNom.getText();
    }
    
    public String Get_Prenom() {
        return this.EditTxtPrenom.getText();
    }
    
    public String Get_email() {
        return this.EditTxtEmail.getText();
    }
    
    public String Get_pwd() {
        return this.EditTxtPwd.getText();
    }
    
    public String Get_id_univ() {
        return this.EditTxtUnivId.getText();
    }




}