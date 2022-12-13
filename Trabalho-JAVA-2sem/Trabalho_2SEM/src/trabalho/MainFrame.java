package trabalho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;




public class MainFrame {

	private JFrame frmDevoluoDeLivro;
	private JTextField textFieldNomeLivro;
	private JTextField textFieldAutor;
	private JTextField TextField_Editoralivro;
	private JPanel panelCadastrarLivro;
	private JTextField textFieldNameCadUser;
	private JTextField textFieldFoneCadUser;
	private JTextField textCPFCadUser;
	private JTextField textField_DataRetirada;
	private JTextField textField_DataDevolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmDevoluoDeLivro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. # INICIALIZAÇAO DO MAIN FRAME
	 *
	 */
	private void initialize() {
		frmDevoluoDeLivro = new JFrame();
		frmDevoluoDeLivro.setType(Type.UTILITY);
		frmDevoluoDeLivro.setTitle("IFRS-FELIZ BIBLIOTECA");
		frmDevoluoDeLivro.setBounds(100, 100, 450, 300);
		frmDevoluoDeLivro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDevoluoDeLivro.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel mainFrame = new JPanel();
		frmDevoluoDeLivro.getContentPane().add(mainFrame, "name_42072309762100");
		mainFrame.setLayout(null);
		
		//INICIALIZAÇÃO DO ARRAY DE LIVROS QUANDO INICIA O CODIGO
		
		File NomesLivros = new File("dados/NomesLivrosCadastrados.txt");
		File CadastroLivros = new File("dados/CadastroLivros.txt");
		File CadastroUsuarios = new File("dados/CadastroUsuarios.txt");
		File NomesUsuarios = new File("dados/NomesUsuarios.txt");
		File EmprestimoLivros = new File("dados/Emprestimos.txt");
		
		
		

//###########################################################################################
// PARTE DO CODIGO QUE TRATA SOBRE RETIRADA DE LIVROS:
		
		JPanel panelRetirarLivro = new JPanel();
		frmDevoluoDeLivro.getContentPane().add(panelRetirarLivro, "name_42072323130900");
		panelRetirarLivro.setLayout(null);
		
		JButton btnVoltarToMainFramePanelRetLivro = new JButton("Voltar");
		btnVoltarToMainFramePanelRetLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDevoluoDeLivro.getContentPane().removeAll();
				frmDevoluoDeLivro.getContentPane().add(mainFrame);
				frmDevoluoDeLivro.getContentPane().repaint();
				frmDevoluoDeLivro.getContentPane().revalidate();
			}
		});
		
			//LISTA OS LIVROS QUE ESTÃO LOCADOS;
		
			JComboBox comboBox_RetirarLivro = new JComboBox();
			comboBox_RetirarLivro.setBounds(124, 16, 186, 26);
			panelRetirarLivro.add(comboBox_RetirarLivro);
			
			File listaLivros = new File("dados/NomesLivrosCadastrados.txt");
			try {
			FileReader reader = new FileReader(listaLivros);
			BufferedReader buffer = new BufferedReader(reader);
			comboBox_RetirarLivro.addItem("--");
			for (int i = 0; i < listaLivros.length(); i++) {
				String nomeLivro = buffer.readLine();
				comboBox_RetirarLivro.addItem(nomeLivro);
			}
			
			buffer.close();
			reader.close();
			frmDevoluoDeLivro.getContentPane().removeAll();
			frmDevoluoDeLivro.getContentPane().add(mainFrame);
			frmDevoluoDeLivro.getContentPane().repaint();
			frmDevoluoDeLivro.getContentPane().revalidate();
			
			} catch (IOException e1) {
			e1.printStackTrace();
			
			}
			
			JComboBox comboBox_ChooseUser = new JComboBox();
			comboBox_ChooseUser.setBounds(124, 54, 186, 26);
			panelRetirarLivro.add(comboBox_ChooseUser);
			comboBox_ChooseUser.addItem("--");
			
			JButton btnRetirarLivro = new JButton("Retirar Livro");
			btnRetirarLivro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			//LISTA OS USUARIOS DISPONIVEIS NO SISTEMA;
					
					File listaUsers = new File("dados/NomesUsuarios.txt");
					try {
					FileReader reader = new FileReader(listaUsers);
					BufferedReader buffer = new BufferedReader(reader);
					
					for (int i = 0; i < listaUsers.length(); i++) {
						String nomeLivro = buffer.readLine();
						comboBox_ChooseUser.addItem(nomeLivro);
					}
					
					buffer.close();
					reader.close();
					frmDevoluoDeLivro.getContentPane().removeAll();
					frmDevoluoDeLivro.getContentPane().add(mainFrame);
					frmDevoluoDeLivro.getContentPane().repaint();
					frmDevoluoDeLivro.getContentPane().revalidate();
					
					} catch (IOException e1) {
					e1.printStackTrace();
					
					}
					
					frmDevoluoDeLivro.getContentPane().removeAll();
					frmDevoluoDeLivro.getContentPane().add(panelRetirarLivro);
					frmDevoluoDeLivro.getContentPane().repaint();
					frmDevoluoDeLivro.getContentPane().revalidate();
				
				}
			});
			btnRetirarLivro.setBounds(136, 107, 161, 23);
			mainFrame.add(btnRetirarLivro);
			
			JLabel lblNewLabel = new JLabel("Livro");
			lblNewLabel.setBounds(33, 21, 55, 16);
			panelRetirarLivro.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
			lblNewLabel_1.setBounds(33, 59, 55, 16);
			panelRetirarLivro.add(lblNewLabel_1);
			
			textField_DataRetirada = new JTextField();
			textField_DataRetirada.setBounds(124, 92, 186, 28);
			panelRetirarLivro.add(textField_DataRetirada);
			textField_DataRetirada.setColumns(10);
			
			textField_DataDevolucao = new JTextField();
			textField_DataDevolucao.setBounds(124, 132, 186, 26);
			panelRetirarLivro.add(textField_DataDevolucao);
			textField_DataDevolucao.setColumns(10);
			
			JLabel lblRetirada = new JLabel("Retirada");
			lblRetirada.setBounds(33, 98, 55, 16);
			panelRetirarLivro.add(lblRetirada);
			
			JLabel lblDevolucao = new JLabel("Devolu\u00E7\u00E3o");
			lblDevolucao.setBounds(33, 137, 82, 16);
			panelRetirarLivro.add(lblDevolucao);
			
			btnVoltarToMainFramePanelRetLivro.setBounds(256, 227, 172, 28);
			panelRetirarLivro.add(btnVoltarToMainFramePanelRetLivro);
			
			JButton btnRetiroLivro_panelRetLivro = new JButton("Retirar Livro");
			btnRetiroLivro_panelRetLivro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
					
					Emprestimo emp = new Emprestimo(comboBox_ChooseUser.getSelectedItem(),comboBox_RetirarLivro.getSelectedItem(),textField_DataRetirada.getText(),textField_DataDevolucao.getText());
					
					emprestimos.add(emp);
					
					try {
						
						EmprestimoLivros.createNewFile();
						FileWriter writer = new FileWriter(EmprestimoLivros,true);
						BufferedWriter buffer = new BufferedWriter(writer);
												
						for (Iterator iterator2 = emprestimos.iterator(); iterator2.hasNext();) {
							Emprestimo emprestimoLivros = (Emprestimo) iterator2.next();
							buffer.write("Nome do livro: "+emprestimoLivros.getNomeLivro()+"\n");
							buffer.write("Nome do Locatário: "+emprestimoLivros.getNomeUsuario()+"\n");
							buffer.write("Data de Locação: "+emprestimoLivros.getDataRetirada()+"\n");
							buffer.write("Data de Devolução: "+emprestimoLivros.getDataDevolucao()+"\n");
							buffer.write("------------------------------\n");
							
							}
						
						buffer.close();
						writer.close();
						textFieldFoneCadUser.setText("");
						textCPFCadUser.setText("");
						textFieldNameCadUser.setText("");
						frmDevoluoDeLivro.getContentPane().removeAll();
						frmDevoluoDeLivro.getContentPane().add(mainFrame);
						frmDevoluoDeLivro.getContentPane().repaint();
						frmDevoluoDeLivro.getContentPane().revalidate();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			btnRetiroLivro_panelRetLivro.setBounds(6, 227, 172, 28);
			panelRetirarLivro.add(btnRetiroLivro_panelRetLivro);
			
			
			
			
				
//###########################################################################################
// PARTE PARA TRATAR DO CÓDIGO SOBRE CADASTRO DE USUÁRIO:
		
		JPanel panelCadastrarUsuario = new JPanel();
		frmDevoluoDeLivro.getContentPane().add(panelCadastrarUsuario, "name_42072318718600");
		panelCadastrarUsuario.setLayout(null);
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Usuario");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDevoluoDeLivro.getContentPane().removeAll();
				frmDevoluoDeLivro.getContentPane().add(panelCadastrarUsuario);
				frmDevoluoDeLivro.getContentPane().repaint();
				frmDevoluoDeLivro.getContentPane().revalidate();
				
			}
		});
		
		JButton btnCdUserBackHome = new JButton("Voltar");
		btnCdUserBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDevoluoDeLivro.getContentPane().removeAll();
				frmDevoluoDeLivro.getContentPane().add(mainFrame);
				frmDevoluoDeLivro.getContentPane().repaint();
				frmDevoluoDeLivro.getContentPane().revalidate();
			}
		});
		
		btnCdUserBackHome.setBounds(276, 227, 152, 28);
		panelCadastrarUsuario.add(btnCdUserBackHome);
		
		textFieldNameCadUser = new JTextField();
		textFieldNameCadUser.setBounds(156, 21, 122, 28);
		panelCadastrarUsuario.add(textFieldNameCadUser);
		textFieldNameCadUser.setColumns(10);
		
		textFieldFoneCadUser = new JTextField();
		textFieldFoneCadUser.setColumns(10);
		textFieldFoneCadUser.setBounds(156, 124, 122, 28);
		panelCadastrarUsuario.add(textFieldFoneCadUser);
		
		JLabel lblNameUser = new JLabel("Nome");
		lblNameUser.setBounds(89, 27, 55, 16);
		panelCadastrarUsuario.add(lblNameUser);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(89, 130, 55, 16);
		panelCadastrarUsuario.add(lblTelefone);
		
		btnCadastrarUsuario.setBounds(136, 39, 161, 23);
		mainFrame.add(btnCadastrarUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(89, 79, 55, 16);
		panelCadastrarUsuario.add(lblNewLabel_2);
		
		textCPFCadUser = new JTextField();
		textCPFCadUser.setBounds(156, 73, 122, 28);
		panelCadastrarUsuario.add(textCPFCadUser);
		textCPFCadUser.setColumns(10);
		
		JButton btnCadastrarUser = new JButton("Cadastrar");
		btnCadastrarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				
				Usuario user = new Usuario(textFieldNameCadUser.getText(),textCPFCadUser.getText(),textFieldFoneCadUser.getText());
				
				usuarios.add(user);
				
				//AQUI O PROGRAMA ESCREVE O USUARIO CADASTRADO DENTRO DO ARQUIVO;
				try {
					CadastroUsuarios.createNewFile();
					FileWriter writer = new FileWriter(CadastroUsuarios,true);
					BufferedWriter buffer = new BufferedWriter(writer);
					
					for (Iterator iterator2 = usuarios.iterator(); iterator2.hasNext();) {
						Usuario usuario = (Usuario) iterator2.next();
						buffer.write("Nome Completo: "+usuario.getNomeCompleto()+"\n");
						buffer.write("CPF: "+usuario.getCpf()+"\n");
						buffer.write("Telefone: "+usuario.getTelefone()+"\n");
						buffer.write("------------------------------\n");;
					}
					buffer.close();
					writer.close();
					textFieldFoneCadUser.setText("");
					textCPFCadUser.setText("");
					textFieldNameCadUser.setText("");
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//AQUI VAI SER ESCRITO SOMENTE O NOME NO ARQUIVO;
					
				try {
					NomesUsuarios.createNewFile();
					FileWriter writer = new FileWriter(NomesUsuarios,true);
					BufferedWriter buffer = new BufferedWriter(writer);
					
					for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
						Usuario usuarios1 = (Usuario) iterator.next();
						buffer.write(usuarios1.getNomeCompleto()+"\n");
						
					}
					buffer.close();
					writer.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				File listaLivros = new File("dados/NomesUsuarios.txt");
				try {
				FileReader reader = new FileReader(listaLivros);
				BufferedReader buffer = new BufferedReader(reader);
				
				for (int i = 0; i < listaLivros.length(); i++) {
					String nomeLivro = buffer.readLine();
					comboBox_ChooseUser.addItem(nomeLivro);
				}
				
				buffer.close();
				reader.close();
				frmDevoluoDeLivro.getContentPane().removeAll();
				frmDevoluoDeLivro.getContentPane().add(mainFrame);
				frmDevoluoDeLivro.getContentPane().repaint();
				frmDevoluoDeLivro.getContentPane().revalidate();
				
				} catch (IOException e1) {
				e1.printStackTrace();
				
				}
				
			}
		});

		btnCadastrarUser.setBounds(6, 227, 152, 28);
		panelCadastrarUsuario.add(btnCadastrarUser);
		
		
		
		
		
		
		
		
//###########################################################################################
// PARTE DO CODIGO QUE TRATA SOBRE DEVOLUÇÃO DE LIVRO;	
		
		JPanel panelDevolverLivro = new JPanel();
		frmDevoluoDeLivro.getContentPane().add(panelDevolverLivro, "name_42072327407900");
		panelDevolverLivro.setLayout(null);
		
		JComboBox Combobox_DevolverLivro = new JComboBox();
		Combobox_DevolverLivro.setBounds(73, 29, 155, 26);
		panelDevolverLivro.add(Combobox_DevolverLivro);
		
		JLabel lblNewLabel_3 = new JLabel("Livro");
		lblNewLabel_3.setBounds(6, 34, 55, 16);
		panelDevolverLivro.add(lblNewLabel_3);
		
		JButton btnGiveBack = new JButton("Devolver");
		
		btnGiveBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File listaEmprestimo = new File("dados/Emprestimos.txt");
				try {
				FileReader reader = new FileReader(listaEmprestimo);
				BufferedReader buffer = new BufferedReader(reader);
				Combobox_DevolverLivro.addItem("--");
				for (int i = 0; i < listaLivros.length(); i++) {
					String emp = buffer.readLine();
					Combobox_DevolverLivro.addItem(emp);
				}
				
				buffer.close();
				reader.close();
				frmDevoluoDeLivro.getContentPane().removeAll();
				frmDevoluoDeLivro.getContentPane().add(mainFrame);
				frmDevoluoDeLivro.getContentPane().repaint();
				frmDevoluoDeLivro.getContentPane().revalidate();
				
				} catch (IOException e1) {
				e1.printStackTrace();
				
				}
			}
		});
		btnGiveBack.setBounds(6, 227, 90, 28);
		panelDevolverLivro.add(btnGiveBack);
		
		JButton btnVoltarHomeDevolverLivro = new JButton("Voltar");
		btnVoltarHomeDevolverLivro.setBounds(338, 227, 90, 28);
		panelDevolverLivro.add(btnVoltarHomeDevolverLivro);
		
		JButton btnDevolverLivro = new JButton("Devolver Livro");
		btnDevolverLivro.setBounds(136, 141, 161, 23);
		mainFrame.add(btnDevolverLivro);
		
		
		
		
		
//###########################################################################################		
//AQUI É A PARTE EM QUE ESTAMOS TRABALHANDO NA PARTE DO CADASTRO DE LIVROS;
				
				JButton btnCadastrarLivro = new JButton("Cadastrar Livro"); //ENTRA NO MENU DE CADASTRAR LIVRO
				btnCadastrarLivro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmDevoluoDeLivro.getContentPane().removeAll();
						frmDevoluoDeLivro.getContentPane().add(panelCadastrarLivro);
						frmDevoluoDeLivro.getContentPane().repaint();
						frmDevoluoDeLivro.getContentPane().revalidate();
						
					}
				});
				btnCadastrarLivro.setBounds(136, 73, 161, 23);
				mainFrame.add(btnCadastrarLivro);
						
				panelCadastrarLivro = new JPanel();
				frmDevoluoDeLivro.getContentPane().add(panelCadastrarLivro, "name_42072314497100");
				panelCadastrarLivro.setLayout(null);
				
				JButton btnVoltarHome = new JButton("Voltar");
				btnVoltarHome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmDevoluoDeLivro.getContentPane().removeAll();
						frmDevoluoDeLivro.getContentPane().add(mainFrame);
						frmDevoluoDeLivro.getContentPane().repaint();
						frmDevoluoDeLivro.getContentPane().revalidate();
						
					}
				});
				
				btnVoltarHome.setBounds(338, 227, 90, 28);
				panelCadastrarLivro.add(btnVoltarHome);
				
				textFieldNomeLivro = new JTextField();
				textFieldNomeLivro.setBounds(89, 6, 193, 28);
				panelCadastrarLivro.add(textFieldNomeLivro);
				textFieldNomeLivro.setColumns(10);
				
				textFieldAutor = new JTextField();
				textFieldAutor.setColumns(10);
				textFieldAutor.setBounds(89, 46, 193, 28);
				panelCadastrarLivro.add(textFieldAutor);
				
				JLabel lblNameCadUser = new JLabel("Nome");
				lblNameCadUser.setBounds(6, 12, 55, 16);
				panelCadastrarLivro.add(lblNameCadUser);
				
				JLabel lblAutor = new JLabel("Autor(a)");
				lblAutor.setBounds(6, 52, 55, 16);
				panelCadastrarLivro.add(lblAutor);
				
				TextField_Editoralivro = new JTextField();
				TextField_Editoralivro.setBounds(89, 86, 193, 28);
				panelCadastrarLivro.add(TextField_Editoralivro);
				TextField_Editoralivro.setColumns(10);
				
				JLabel lblEditora = new JLabel("Editora");
				lblEditora.setBounds(6, 92, 55, 16);
				panelCadastrarLivro.add(lblEditora);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(89, 126, 193, 26);
				panelCadastrarLivro.add(comboBox);
				comboBox.addItem(" -- ");
				comboBox.addItem("Ação");
				comboBox.addItem("Ficção Científica");
				comboBox.addItem("Romance");
				comboBox.addItem("Aventura");
				comboBox.addItem("Drama");
				
				JButton btnCadLivro = new JButton("Cadastrar");
				btnCadLivro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
					
					ArrayList<Livro> livros = new ArrayList<Livro>(); 
						
					Livro l = new Livro(textFieldNomeLivro.getText(), textFieldAutor.getText(), TextField_Editoralivro.getText(), comboBox.getSelectedItem());
					livros.add(l);
					
					
					//CADASTRO DO LIVRO
					try {
						CadastroLivros.createNewFile();
						FileWriter writer = new FileWriter(CadastroLivros,true);
						BufferedWriter buffer = new BufferedWriter(writer);
						
						for (Iterator iterator = livros.iterator(); iterator.hasNext();) {
							Livro livro = (Livro) iterator.next();
							buffer.write("Nome do Livro: "+livro.getNome()+"\n");
							buffer.write("Nome Autor: "+livro.getAutor()+"\n");
							buffer.write("Gênero: "+livro.getGenero()+"\n");
							buffer.write("Editora: "+livro.getEditora()+"\n");
							buffer.write("-----------------------------\n");
							
						}
						buffer.close();
						writer.close();
						textFieldAutor.setText("");
						textFieldNomeLivro.setText("");
						TextField_Editoralivro.setText("");

						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//AQUI VAI SER ESCRITO SOMENTE O NOME NO ARQUIVO;
					
					try {
						NomesLivros.createNewFile();
						FileWriter writer = new FileWriter(NomesLivros,true);
						BufferedWriter buffer = new BufferedWriter(writer);
						
						for (Iterator iterator = livros.iterator(); iterator.hasNext();) {
							Livro livro = (Livro) iterator.next();
							buffer.write(livro.getNome()+"\n");
							
						}
			
						buffer.close();
						writer.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					File listaLivros = new File("dados/NomesLivrosCadastrados.txt");
					try {
					FileReader reader = new FileReader(listaLivros);
					BufferedReader buffer = new BufferedReader(reader);
					
					for (int i = 0; i < listaLivros.length(); i++) {
						String nomeLivro = buffer.readLine();
						comboBox_RetirarLivro.addItem(nomeLivro);
					}
					
					buffer.close();
					reader.close();
					frmDevoluoDeLivro.getContentPane().removeAll();
					frmDevoluoDeLivro.getContentPane().add(mainFrame);
					frmDevoluoDeLivro.getContentPane().repaint();
					frmDevoluoDeLivro.getContentPane().revalidate();
					
					} catch (IOException e1) {
					e1.printStackTrace();
					
					}
					
					}
					
				});
				btnCadLivro.setBounds(6, 227, 90, 28);
				panelCadastrarLivro.add(btnCadLivro);
				
				JLabel lblGenero = new JLabel("G\u00EAnero");
				lblGenero.setBounds(6, 131, 55, 16);
				panelCadastrarLivro.add(lblGenero);

	}
}
