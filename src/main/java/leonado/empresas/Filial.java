package leonado.empresas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Filial extends BaseEntity {
	
	private String nome;
	@ManyToOne
	private Empresa empresa;
	private String cnpj;
	private String codigo;
	@ManyToOne
	private Endereco enderco;
	
	public Filial() {}
	public Filial(String nome, Empresa empresa, String cnpj, Endereco endereco, String codigo) {
		this.nome = nome;
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.codigo = codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}
	public Endereco getEnderco() {
		return enderco;
	}
	public void setEnderco(Endereco enderco) {
		this.enderco = enderco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
