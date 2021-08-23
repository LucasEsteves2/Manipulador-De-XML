package alunos;

import java.awt.TextArea;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Aluno {
	public static String dir = System.getProperty("user.dir");
	public static String arquivo = "C:\\faeterj.xml";

	public static String localArquivo = dir + arquivo;
	public static final String xmlFilePath = "C:\\temp\\faeterj.xml";
	private String nome;
	private double av1;
	private double av2;
	private double av3;
	private double media;

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	private Document document;

	public Aluno(Document document2, double nota1, double nota2, double nota3, String nome) {

		this.document = document2;
		this.av1 = nota1;
		this.av2 = nota2;
		this.av3 = nota3;
		this.nome = nome;
	}

	// Sobrecarga
	public Aluno(Document document2) {

		this.document = document2;

	}

	public double getAv3() {
		return av3;
	}

	public void setAv3(double av3) {
		this.av3 = av3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAv1() {
		return av1;
	}

	public void setAv1(double d) {
		this.av1 = d;
	}

	public double getAv2() {
		return av2;
	}

	public void setAv2(double d) {
		this.av2 = d;
	}

	public void imprimeAluno() {

		NodeList alunos = document.getElementsByTagName("aluno");

		for (int i = 0; i < alunos.getLength(); i++) {

			Element listaAlunos = (Element) alunos.item(i);

			// pegando do xml e passando para classe
			setNome(listaAlunos.getElementsByTagName("nome").item(0).getTextContent());
			setAv1(Double.parseDouble(listaAlunos.getElementsByTagName("av1").item(0).getTextContent()));
			setAv2(Double.parseDouble(listaAlunos.getElementsByTagName("av2").item(0).getTextContent()));
			setAv3(Double.parseDouble(listaAlunos.getElementsByTagName("av3").item(0).getTextContent()));

			imprimeConsole();

			setMedia(Double.parseDouble(listaAlunos.getElementsByTagName("Media").item(0).getTextContent()));

		}

	}

	public void imprimeConsole() {
		// Imprimir no console
		media = (av1 + av2 + av3) / 3;
		System.out.println("---Aluno-----");
		System.out.println("Nome: " + nome);
		System.out.println("Av1: " + av1);
		System.out.println("Av2: " + av2);
		System.out.println("Av3: " + av3);
		System.out.println("Media final: " + media);
		System.out.println();

	}

	public void alunosXml(TextArea x) {
		NodeList alunos = document.getElementsByTagName("aluno");

		for (int i = 0; i < alunos.getLength(); i++) {

			Element listaAlunos = (Element) alunos.item(i);

			// pegando do xml e passando para classe
			setNome(listaAlunos.getElementsByTagName("nome").item(0).getTextContent());
			setAv1(Double.parseDouble(listaAlunos.getElementsByTagName("av1").item(0).getTextContent()));
			setAv2(Double.parseDouble(listaAlunos.getElementsByTagName("av2").item(0).getTextContent()));
			setAv3(Double.parseDouble(listaAlunos.getElementsByTagName("av3").item(0).getTextContent()));

			String situacao = listaAlunos.getElementsByTagName("Situacao").item(0).getTextContent();

			x.append("\r\n | " + nome + " |  -   " + av1 + "           -   " + av2 + "           -   " + av3
					+ "         - " + situacao + "          \t\t\r\n\t\r\n ");

		}

	}

	public void adicionarAluno() throws ParserConfigurationException {
		try {

			// Elemento pai (aluno)
			Element aluno = document.createElement("aluno");
			document.getDocumentElement().appendChild(aluno);

			// nome aluno
			Element nome2 = document.createElement("nome");
			nome2.appendChild(document.createTextNode(nome));

			aluno.appendChild(nome2);

			// elemento pai notas
			Element notas = document.createElement("notas");

			aluno.appendChild(notas);

			// av1
			Element prova1 = document.createElement("av1");
			prova1.appendChild(document.createTextNode(Double.toString(av1)));

			notas.appendChild(prova1);

			// av2
			Element prova2 = document.createElement("av2");
			prova2.appendChild(document.createTextNode(Double.toString(av2)));

			notas.appendChild(prova2);

			// av3
			Element prova3 = document.createElement("av3");
			prova3.appendChild(document.createTextNode(Double.toString(av3)));

			notas.appendChild(prova3);

			media = (av1 + av2 + av3) / 3;

			// media
			Element mediaa = document.createElement("Media");
			mediaa.appendChild(document.createTextNode(Double.toString(media)));

			notas.appendChild(mediaa);

			if (media < 6) {
				Element situacao = document.createElement("Situacao");
				situacao.appendChild(document.createTextNode("REPROVADO"));

				notas.appendChild(situacao);

			} else {
				Element situacao = document.createElement("Situacao");
				situacao.appendChild(document.createTextNode("APROVADO"));

				notas.appendChild(situacao);
			}

			// Criando o arquivo ml
			// transformar o DOM em um arquivo XML

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			transformer.transform(domSource, streamResult);

			System.out.println("Aluno Adicionado ao xml");

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

}
