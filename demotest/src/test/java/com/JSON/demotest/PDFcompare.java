/**
 * @author venkateshwara.d
 *
 */

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import de.redsix.pdfcompare.PdfComparator;

public class PDFcompare {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {

		String ProjectDir = System.getProperty("user.dir");
		
		Desktop desktop = Desktop.getDesktop();

		String file1 = ProjectDir + "\\PDF\\Doc1.pdf";
		
		String file2 = ProjectDir + "\\PDF\\Doc2.pdf";
		
		String diffOutput = ProjectDir + "\\PDF\\resultPDF";

		File file = new File(ProjectDir + "\\PDF\\resultPDF.pdf");
		
		File file11 = new File(file1);
		
		File file22 = new File(file2);
		
		try {

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean isEquals = new PdfComparator(file1, file2).compare().writeTo(diffOutput);

		if (!isEquals) {
			System.out.println("Differences found!");
		} else {
			System.out.println("PDF are similar");
		}

		if (file11.exists())
			desktop.open(file11);

		if (file22.exists())
			desktop.open(file22);
		
		if (file.exists())
			desktop.open(file);

	}

}

/*
<!-- https://mvnrepository.com/artifact/de.redsix/pdfcompare -->
<dependency>
    <groupId>de.redsix</groupId>
    <artifactId>pdfcompare</artifactId>
    <version>1.1.32</version>
</dependency>
*/
