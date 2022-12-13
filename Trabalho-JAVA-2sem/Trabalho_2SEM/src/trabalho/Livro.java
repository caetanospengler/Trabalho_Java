package trabalho;

public class Livro {

	private String nome;
	private String autor;
	private String Editora;
	private Object genero;
	public Livro(String nome, String autor, String editora, Object genero) {
		super();
		this.nome = nome;
		this.autor = autor;
		Editora = editora;
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public Object getGenero() {
		return genero;
	}
	public void setGenero(Object genero) {
		this.genero = genero;
	}
	
	
	
	
	
}
