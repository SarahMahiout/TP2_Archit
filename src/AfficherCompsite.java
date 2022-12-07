
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AfficherCompsite implements IJournal {

	private List<IJournal> j =new ArrayList<IJournal>();


	@Override
	public void outPut_Msg(String message) throws IOException {
		// TODO Auto-generated method stub

		AfficherMsgDateClasse s=new AfficherMsgDateClasse();
		String newMsg=s.outPut_Msg_withDate(message);
		for(int i=0;i<j.size();i++){
			j.get(i).outPut_Msg(newMsg);
		}

	}

	 public void ajouter(IJournal j){
			this.j.add(j);
		}
}