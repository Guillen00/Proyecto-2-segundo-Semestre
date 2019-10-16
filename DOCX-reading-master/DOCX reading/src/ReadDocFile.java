import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
public class ReadDocFile
{
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    	jfc.setDialogTitle("Select Resume");
    	jfc.setMultiSelectionEnabled(true);
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	String fileName = null;
    	File[] files = null;
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			files = jfc.getSelectedFiles();
			
			}
	
		for (int i = 0; i < files.length; i++) {
		fileName = files[i].getAbsolutePath();
        try
        {
        	 Map<String, Integer> dict = new HashMap<String, Integer>();
        	 File file = new File(fileName);
            XWPFDocument document;
            try (FileInputStream fis = new FileInputStream(file.getAbsolutePath())) {

                document = new XWPFDocument(fis);

                List<XWPFParagraph> paragraphs = document.getParagraphs();
                dict.put("What", 0);

                for (XWPFParagraph para : paragraphs) {
                    if (dict.get(para.getText()) != null) {
                        dict.put(para.getText(), dict.get(para.getText()) + 1);
                    }
                }
                int sum = 0;
                for (int a : dict.values()) {
                    sum += a;
                }
                System.out.println(sum / dict.size());
                fis.close();
            }
            document.close();
            input.close();
            }
        
        catch (Exception exep)
        {
            exep.printStackTrace();
        }
    }
    }
}
