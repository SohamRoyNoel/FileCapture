import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class Copy1ToComparisonFolder {

	// PROOF to Sumanda's Automation folder
	public static void moveToSayanAutomationNew(String directory, String filenm) {
		String source = "D:/COPY1/"+directory;
		File srcDir = new File(source);

		String destination = "D:/Sayan Automation New/"+directory;
		File destDir = new File(destination);

		try {
			// copy the files
			if(!destDir.exists()) {
				Path temp = Files.move(Paths.get("D:\\COPY1\\"+directory), Paths.get("D:\\Sayan Automation New\\"+directory));

				if(temp != null) { 
					System.out.println("File moved successfully"); 

				} 
				else { 
					System.out.println("Failed to move the file"); 
				}
			} else {			
				// move a file to an already existing folder
				try {
					FileUtils.copyDirectory(srcDir, destDir);
					FileUtils.deleteDirectory(srcDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
