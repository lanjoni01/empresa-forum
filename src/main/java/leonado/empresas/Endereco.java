package leonado.empresas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco extends BaseEntity{
	
	@NotNull
	private String logradouro;
	@NotNull
	private String bairro;
	@NotNull
	private Long numero;
	@NotNull
	private String cep;
	private String pontoReferencia;
	private String cidade;

	public Endereco() {}
	public Endereco(@NotNull String logradouro, @NotNull String bairro, @NotNull Long numero, @NotNull String cep,
			String pontoReferencia, @NotNull String cidade) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.pontoReferencia = pontoReferencia;
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
}
