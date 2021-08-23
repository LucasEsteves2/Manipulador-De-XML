package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import visual.Menu;

public class Main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException

	{

		// pega o diretorio que o jar esta instalado (o arquivo xml ficara do lado do
		// jar)
		String dir = System.getProperty("user.dir");
		String nome = "\\faeterj.xml";
		String caminho = dir + nome;

		System.out.println(caminho);

		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document document = builder.parse("C:\\temp\\faeterj.xml"); // metdo que carrega na memoria

			Menu tela1 = new Menu(document, caminho);
			tela1.setLocationRelativeTo(null);
			tela1.setVisible(true);

		} catch (Exception e) {
			try { // abre o diretorio
				java.awt.Desktop.getDesktop().open(new File("C:\\temp\\"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(null,
					"Por favor, certifique se o arquivo FAETERJ.xml esteja no caminho C:\\temp :\n\n '"
							+ "'Por favor,mova o arquivo faeterj.xml para a pasta que foi aberta '", // mensagem
					"Erro 404", // titulo da janela
					JOptionPane.ERROR_MESSAGE);

		}

	}
}