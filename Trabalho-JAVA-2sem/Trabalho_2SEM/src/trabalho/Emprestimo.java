package trabalho;

public class Emprestimo {
	
	private String nomeUsuario;
	private String nomeLivro;
	private String dataRetirada;
	private String dataDevolucao;
	
	public Emprestimo(Object object, Object object2, String dataRetirada, String dataDevolucao) {
		super();
		this.nomeUsuario = (String) object;
		this.nomeLivro = (String) object2;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
}
