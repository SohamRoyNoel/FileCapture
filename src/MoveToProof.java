import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveToProof {

	public static void moveToProof(String forTHEfolder, String forTHEfile) {
		String proofDirectory = "D:/PROOF";
		File theDirC = new File(proofDirectory);
		if (!theDirC.exists()) {
			try {
				theDirC.mkdirs();
			} catch (SecurityException se) {
				se.printStackTrace();
			}
		}

		try {
			// copy the files
			Path temp = Files.move(Paths.get("D:\\COPY1\\"+forTHEfolder), Paths.get("D:\\PROOF\\"+forTHEfolder));
			if(temp != null) { 
				System.out.println("File moved successfully"); 

			} 
			else { 
				System.out.println("Failed to move the file"); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
