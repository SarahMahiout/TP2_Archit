
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class AfficherMsgDateClasse implements IJournal {


		public String outPut_Msg_withDate(String message) throws IOException {
			// TODO Auto-generated method stub
			StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
	        String callerClass = ste.getClassName(); 
	        SimpleDateFormat  sdf = new SimpleDateFormat("'Le : 'dd.MM.yyyy' Heure : ' HH:mm:ss");
	        String currentDateandTime = sdf.format(new Date());
	        return currentDateandTime+"\n"
			+ "la classe : "+ callerClass +"\n"
			+ "le message : "+message +"\n" +"\n" ;



		}

		@Override
		public void outPut_Msg(String message) throws IOException {
			// TODO Auto-generated method stub

		}

	}


