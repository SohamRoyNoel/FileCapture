import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class MoveToProof {

	public static void moveToProof(String forTHEfolder) {
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
			// Copy1 TO Proof
			String source = "D:/COPY1/"+forTHEfolder;
			File srcDir = new File(source);

			String destination = "D:/PROOF/"+forTHEfolder;
			File destDir = new File(destination);

			try {
				FileUtils.copyDirectory(srcDir, destDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
