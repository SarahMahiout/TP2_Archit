
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AfficherMsgFichier implements IJournal {

	@Override
	public void outPut_Msg(String message) throws IOException {
		// TODO Auto-generated method stub

		   File file = new File("Fichier.txt");
		   file.createNewFile();
		   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		   BufferedWriter bw = new BufferedWriter(fw);
		   PrintWriter out = new PrintWriter(bw);
		   out.println(message);
		   out.close();
		   bw.close();


	}

}
