import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Commons-io
public class MoveFolder {

	public static void main(String[] args) {

		try {
			String forTHEfolder = "P12386";
			String forTHEfile = "abc";

			// location of the zip folder
			String zipFilePath = "D:/Air/release.zip";
			// location of destination folder
			String destDir = "D:/DUMP";
			File theDirC = new File(destDir);

			// Restricting the multiple unzip option
			if(!theDirC.exists()) {
				// call unzip method and copy all file to the DUMP Folder
				UnzipFile.unzip(zipFilePath, destDir);
				System.out.println("Unziped");
				
				// Copy all folder from DUMP to COPY(Backup)
				File srcDir = new File(destDir);
				// Destination
				String destination = "D:/COPY";
				File copyDir = new File(destination);
				DumpToCopy.dumpToCopy(srcDir, copyDir);
			}
			Thread.sleep(500);

			
			// get the single file from the folder
			String copy1folderpath = "D:\\COPY1\\"+ forTHEfolder;

			// Check if the File is already there
			File theDir = new File(copy1folderpath);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
				System.out.println("creating directory: " + theDir.getName());
				boolean result = false;
				try {
					theDir.mkdirs();
					result = true;
				} catch (SecurityException se) {
					System.out.println(se.getMessage());
				}
				if (result) {
					System.out.println("Folder created");
					// copies file without creating folder
					File sources = new File("D:\\COPY\\"+ forTHEfolder);
					File dests = new File("D:\\COPY1\\"+ forTHEfolder);
					try {
						// copy the files
						Path temp = Files.move(Paths.get("D:\\COPY\\"+forTHEfolder+"\\"+forTHEfile+".txt"), Paths.get("D:\\COPY1\\"+forTHEfolder+"\\"+forTHEfile+"_source"+".txt"));
						if(temp != null) { 
							System.out.println("File renamed and moved successfully"); 
							
							// Move file copy to PROOF : Empties the copy folder
							MoveToProof.moveToProof(forTHEfolder, forTHEfile);
						} 
						else { 
							System.out.println("Failed to move the file"); 
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if (theDir.exists()) {
				System.out.println("Folder exist");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
