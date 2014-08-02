import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SqlFileToDB {
	public static void main(String[] args) {
		String fileName = "UFLUD_dbo_TB_SYSTEM_LOG.SQL";
		File newFile = new File("C:/Users/kby/Desktop/货单捞磐",fileName);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(newFile));
			String inStr = null;
			while ( (inStr = reader.readLine()) != null) {
				if(inStr.indexOf("SEQ,")!=-1){
					inStr = inStr.replaceAll("SEQ,", "");
				}
				if(inStr.indexOf(";")!=-1){
					int start = inStr.indexOf("(");
					int end = inStr.indexOf(",");	
					String sub = inStr.substring(start+1, end+1);
					inStr = inStr.replace( sub, "");
				}
				System.out.println(inStr);
				writeLog(inStr,fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeLog(String message,String fileName){
		File parentDir = new File(".");
		System.out.println(parentDir.getAbsolutePath());
		File newFile = new File("C:/Users/kby/Desktop/货单捞磐"+"/sql",fileName);
		try {
			if(newFile.exists()){

			}else{
				File fileDir = newFile.getParentFile();
				fileDir.mkdirs();
				newFile.createNewFile();
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(newFile,true));
			out.write(message);
			out.newLine();
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
