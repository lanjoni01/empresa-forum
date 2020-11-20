package leonado.empresas;

import javax.persistence.Entity;

@Entity
public class Empresa extends BaseEntity{
	
	private String nome;
	private String cnpj;
	
	public Empresa() {}
	public Empresa(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
