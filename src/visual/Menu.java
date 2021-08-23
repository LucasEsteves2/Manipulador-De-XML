package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Document;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import javax.swing.JSeparator;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public Menu(Document document, String caminho) {

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sistema Academico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane2_1 = new ScrollPane();
		scrollPane2_1.setBounds(-7, 0, 526, 14);
		contentPane.add(scrollPane2_1);

		JLabel lblClickXml = new JLabel("");

		lblClickXml.setBounds(6, 121, 230, 54);
		contentPane.add(lblClickXml);

		JLabel lblClickNovoAluno = new JLabel("");

		lblClickNovoAluno.setBounds(6, 11, 230, 56);
		contentPane.add(lblClickNovoAluno);

		JLabel lblClickView = new JLabel("");

		lblClickView.setBounds(8, 64, 228, 54);
		contentPane.add(lblClickView);

		JLabel lblNovoAluno = new JLabel("Cadastrar Aluno");
		lblNovoAluno.setIconTextGap(11);
		lblNovoAluno.setIcon(new ImageIcon(Menu.class.getResource("/imgs/aluna.png")));
		lblNovoAluno.setFont(new Font("Arial", Font.BOLD, 14));
		lblNovoAluno.setBounds(32, 24, 184, 32);
		contentPane.add(lblNovoAluno);

		JLabel lblVisualizar = new JLabel("Visualizar Alunos");
		lblVisualizar.setIconTextGap(11);
		lblVisualizar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/alunos.png")));
		lblVisualizar.setFont(new Font("Arial", Font.BOLD, 14));
		lblVisualizar.setBounds(33, 78, 169, 32);
		contentPane.add(lblVisualizar);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(6, 121, 230, 2);
		contentPane.add(separator_2_1);

		JLabel lblPassageiros = new JLabel("Abrir arquivo.XML");
		lblPassageiros.setIconTextGap(11);
		lblPassageiros.setIcon(new ImageIcon(Menu.class.getResource("/imgs/livro.png")));
		lblPassageiros.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassageiros.setBounds(32, 134, 184, 32);
		contentPane.add(lblPassageiros);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 66, 230, 11);
		contentPane.add(separator_2);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(-26, 0, 32, 177);
		contentPane.add(scrollPane);

		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(3, -6, 236, 183);
		contentPane.add(scrollPane_1);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Menu.class.getResource("/imgs/foi.png")));
		lblFundo.setBounds(-21, 186, 298, 85);
		contentPane.add(lblFundo);

		ScrollPane scrollPane2_2 = new ScrollPane();
		scrollPane2_2.setBounds(-79, 0, 519, 11);
		contentPane.add(scrollPane2_2);

		JLabel lblclickPassageiro = new JLabel("");
		lblclickPassageiro.setBounds(6, 122, 223, 53);
		contentPane.add(lblclickPassageiro);

		// instancia novo aluno
		lblClickNovoAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				NovoAlunoo tela1 = new NovoAlunoo(document, "C:\\temp\\faeterj.xml");
				tela1.setLocationRelativeTo(null);
				tela1.setVisible(true);

				dispose();

			}
		});

		// Abrir xml ao clicar
		lblClickXml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					java.awt.Desktop.getDesktop().open(new File("C:\\temp\\faeterj.xml"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		lblClickView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VisualizarAlunos tela1 = new VisualizarAlunos(document);
				tela1.setLocationRelativeTo(null);
				tela1.setVisible(true);

			}
		});

	}

}