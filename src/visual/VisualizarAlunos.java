package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Document;

import alunos.Aluno;

import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;

public class VisualizarAlunos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VisualizarAlunos(Document document) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setResizable(false);
		setTitle("ALUNO.XML");
		setBounds(100, 100, 482, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(-20, -15, 566, 40);
		contentPane.add(panel);

		JLabel lblNewLabel_4 = new JLabel("ALUNOS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(218, 13, 93, 29);
		panel.add(lblNewLabel_4);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(-12, 25, 510, 14);
		contentPane.add(scrollPane);

		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);

		contentPane.add(textArea);

		JLabel lblNewLabel = new JLabel("Aluno");
		lblNewLabel.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/trabalho.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(34, 61, 68, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Av1");
		lblNewLabel_1.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/lista-de-controle.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(131, 61, 58, 32);
		contentPane.add(lblNewLabel_1);

		textArea.setFont(new Font("Arial", Font.PLAIN, 12));

		textArea.setBounds(24, 99, 425, 237);

		JLabel lblNewLabel_3 = new JLabel("");

		lblNewLabel_3.setBounds(138, 62, 51, 34);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_2 = new JLabel("");

		lblNewLabel_3_2.setBounds(27, 62, 32, 34);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblFechar = new JLabel("FECHAR");
		lblFechar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechar.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/fechar.png")));
		lblFechar.setBounds(189, 342, 98, 53);
		contentPane.add(lblFechar);

		Voltar(lblFechar);

		JLabel lblNewLabel_1_1 = new JLabel("Av2");
		lblNewLabel_1_1.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/lista-de-controle.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(208, 61, 58, 32);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Av3");
		lblNewLabel_1_2.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/lista-de-controle.png")));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(287, 61, 58, 32);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Situacao");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(VisualizarAlunos.class.getResource("/imgs/questionario.png")));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2_1.setBounds(358, 61, 93, 32);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_2 = new JLabel("*Dados retirados do arquivo alunos.xml");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(300, 365, 190, 45);
		contentPane.add(lblNewLabel_2);

		// Pega os dados dos alunos no arquivo xml e adiciona na text area
		Aluno alunos = new Aluno(document);
		alunos.alunosXml(textArea);

	}

	public void Voltar(JLabel lblFechar) {

		// botão voltar

		lblFechar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				// chama a tela principal novamente

				dispose();

			}
		});
	}
}