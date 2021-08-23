package visual;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import alunos.Aluno;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoAlunoo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtAv2;
	private JTextField txtAv1;
	private JTextField txtAv3;

	public NovoAlunoo(Document document, String caminho) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NovoAlunoo.class.getResource("/imgs/tempo-total.png")));

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel CadastroCliente = new JLabel("Sistema Academico");
		CadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		CadastroCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		CadastroCliente.setBounds(10, 11, 512, 31);
		contentPane.add(CadastroCliente);

		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon(NovoAlunoo.class.getResource("/imgs/student (1).png")));
		lblFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFoto.setBounds(23, 67, 95, 114);
		contentPane.add(lblFoto);

		txtNome = new JTextField();
		txtNome.setBounds(134, 89, 169, 27);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtAv2 = new JTextField();
		txtAv2.setColumns(10);
		txtAv2.setBounds(134, 141, 169, 27);
		contentPane.add(txtAv2);

		txtAv1 = new JTextField();
		txtAv1.setColumns(10);
		txtAv1.setBounds(328, 89, 182, 27);
		contentPane.add(txtAv1);

		JLabel lblNome = new JLabel("Aluno");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(135, 68, 46, 14);
		contentPane.add(lblNome);

		JLabel lblAv1 = new JLabel("1\u00B0 Avalia\u00E7\u00E3o");
		lblAv1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAv1.setBounds(384, 69, 77, 14);
		contentPane.add(lblAv1);

		JLabel lblAv2 = new JLabel("2\u00B0 Avalia\u00E7\u00E3o");
		lblAv2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAv2.setBounds(135, 124, 71, 14);
		contentPane.add(lblAv2);

		JPanel jpSituacao = new JPanel();
		jpSituacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		jpSituacao.setBorder(new TitledBorder(null, "Situação", TitledBorder.LEADING, TitledBorder.TOP,
				new java.awt.Font("Arial", 1, 11)));
		jpSituacao.setBounds(23, 192, 95, 48);
		contentPane.add(jpSituacao);
		jpSituacao.setLayout(null);

		JLabel lblSituacao = new JLabel("AGUARDANDO");
		lblSituacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSituacao.setBounds(0, 22, 95, 14);
		jpSituacao.add(lblSituacao);
		lblSituacao.setForeground(new Color(0, 0, 0));
		lblSituacao.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblmedia = new JLabel("Media:");
		lblmedia.setHorizontalAlignment(SwingConstants.CENTER);
		lblmedia.setHorizontalTextPosition(SwingConstants.CENTER);
		lblmedia.setBounds(0, 4, 95, 14);
		jpSituacao.add(lblmedia);
		lblmedia.setVisible(false);
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIconTextGap(12);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setIcon(new ImageIcon(NovoAlunoo.class.getResource("/imgs/limpar-limpo.png")));

		btnCancelar.setBounds(166, 201, 133, 39);
		contentPane.add(btnCancelar);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(329, 201, 125, 39);
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvar.setIconTextGap(9);
		btnSalvar.setIcon(new ImageIcon(NovoAlunoo.class.getResource("/imgs/salve-.png")));

		contentPane.add(btnSalvar);

		txtAv3 = new JTextField();
		txtAv3.setColumns(10);
		txtAv3.setBounds(328, 141, 182, 27);
		contentPane.add(txtAv3);

		JLabel lblAv3 = new JLabel("3\u00B0 Avalia\u00E7\u00E3o");
		lblAv3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAv3.setBounds(384, 121, 77, 14);
		contentPane.add(lblAv3);

		JLabel lblAluno = new JLabel("NomeAluno");
		lblAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAluno.setBounds(23, 160, 94, 14);
		contentPane.add(lblAluno);

		JLabel lblVoltar = new JLabel("");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Menu tela1 = new Menu(document, "C:\\temp\\faeterj.xml");
				tela1.setLocationRelativeTo(null);
				tela1.setVisible(true);

				dispose();
			}
		});
		lblVoltar.setIcon(new ImageIcon(NovoAlunoo.class.getResource("/imgs/de-volta.png")));
		lblVoltar.setBounds(20, 19, 48, 16);
		contentPane.add(lblVoltar);

		lblAluno.setVisible(false);

		// evento botao click
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// testa se todos os campos do formulario foram preenchidos
				boolean formularioValido = validaFormulario();

				if (formularioValido) // se todos os campos estiverem ok
				{

					// pegando valores dos campos e convertendo para double
					String nome = txtNome.getText();
					double nota1 = Double.valueOf(txtAv1.getText()).doubleValue();
					double nota2 = Double.valueOf(txtAv2.getText()).doubleValue();
					double nota3 = Double.valueOf(txtAv3.getText()).doubleValue();

					Aluno aluno2 = new Aluno(document, nota1, nota2, nota3, nome);
					try {
						aluno2.adicionarAluno();

					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					aluno2.imprimeAluno();

					Double media = aluno2.getMedia();

					// metodo que recebe o valor do javascript e altera o formulario do java
					mediaFinal(lblSituacao, jpSituacao, lblmedia, lblAluno, media);

					// dialog
					int i = JOptionPane.showConfirmDialog(null, "Deseja visualizar o conteudo do arquivo FAETERJ.XML?",
							"ALUNOS.XML", JOptionPane.OK_CANCEL_OPTION);

					if (i == JOptionPane.YES_OPTION) {
						System.out.println("Clicou em Sim");

						try {
							java.awt.Desktop.getDesktop().open(new File("C:\\temp\\faeterj.xml"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (i == JOptionPane.CANCEL_OPTION) {

						System.out.println("Clicou em Não");

					}

				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// setando so campos
				txtAv1.setText("");
				txtAv2.setText("");
				txtAv3.setText("");
				txtNome.setText("");

				// setando a situação
				lblSituacao.setForeground(new Color(0, 0, 0));
				lblSituacao.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblSituacao.setText("AGUARDANDO");
				jpSituacao.setFont(new Font("Tahoma", Font.BOLD, 11));
				jpSituacao.setBorder(new TitledBorder(null, "Situação", TitledBorder.LEADING, TitledBorder.TOP,
						new java.awt.Font("Arial", 1, 11)));
				jpSituacao.setBounds(23, 192, 95, 48);
				contentPane.add(jpSituacao);
				jpSituacao.setLayout(null);

				lblmedia.setVisible(false);

				lblAluno.setVisible(false);
				lblAluno.setText("");
				JOptionPane.showMessageDialog(null, "Todos os campos foram limpos!!", "Limpo",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}

	public boolean validaFormulario() {
		// verifica se todos os campos estao preenchidos
		if (txtAv1.getText().trim().equals("") || txtAv2.getText().trim().equals("")
				|| txtAv3.getText().trim().equals("") || txtNome.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Porfavor, preencha todos os campos", "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return false;

		} else {
			return true;
		}
	}

	public void mediaFinal(JLabel lblSituacao, JPanel jpSituacao, JLabel lblmedia, JLabel lblAluno, Double media) {

		if (media < 6) {
			// setando a situação
			lblSituacao.setText("REPROVADO");
			lblSituacao.setForeground(Color.RED);
			lblSituacao.setFont(new Font("Tahoma", Font.BOLD, 13));
			jpSituacao.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));

			// setando o lbl da media
			lblmedia.setVisible(true);
			lblmedia.setText("Media: " + media.toString());

			lblAluno.setVisible(true);
			lblAluno.setText(txtNome.getText());
			JOptionPane.showMessageDialog(null, "Aluno Salvo no arquivo aluno.xml!!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		}

		if (media > 6) {
			// setando a situação
			lblSituacao.setText("APROVADO");
			lblSituacao.setForeground(new Color(0, 128, 0));
			lblSituacao.setFont(new Font("Tahoma", Font.BOLD, 13));
			jpSituacao.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.green));

			// setando o lbl da media
			lblmedia.setVisible(true);
			lblmedia.setText("Media: " + media.toString());
			lblAluno.setVisible(true);
			lblAluno.setText(txtNome.getText());
			JOptionPane.showMessageDialog(null, "Aluno Salvo no arquivo aluno.xml!!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
