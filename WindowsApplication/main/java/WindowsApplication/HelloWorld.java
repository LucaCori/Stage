package WindowsApplication;
	
	import java.io.IOException;
	
	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;

	import org.apache.pdfbox.pdmodel.PDPageContentStream;
	
	import org.apache.pdfbox.pdmodel.font.PDFont;
	import org.apache.pdfbox.pdmodel.font.PDType1Font;
	
	public class HelloWorld
	{
		public void create(String name, String message) throws IOException{
			try (PDDocument doc = new PDDocument())
	        {
	            PDPage page = new PDPage();
	            doc.addPage(page);
	            PDFont font = PDType1Font.COURIER;
	            try (PDPageContentStream contents = new PDPageContentStream(doc, page))
	            {
	                contents.beginText();
	                contents.setFont(font, 36);
	                contents.newLineAtOffset(100, 700);
	                contents.showText(message);
	                contents.endText();
	            }
	            doc.save(name);
	        }
	    }
	}
	
	