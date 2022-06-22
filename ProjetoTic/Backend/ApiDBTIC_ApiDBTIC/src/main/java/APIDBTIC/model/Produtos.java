package APIDBTIC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produtos {

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="nome")
		private String nome;
		@Column(name="especificacao")
		private String especificacao;
		@Column(name="valor")
		private float valor;
		@Column(name="quantidade")
		private float quantidade;
		public Produtos() {	
			
		}
		
		public Produtos(String nome, String especificacao, float valor, float quantidade) {
			super();
			this.nome = nome;
			this.especificacao = especificacao;
			this.valor = valor;
			this.quantidade = quantidade;
		}

		public Produtos(Long id, String nome, String especificacao, float valor, float quantidade) {
			super();
			this.id = id;
			this.nome = nome;
			this.especificacao = especificacao;
			this.valor = valor;
			this.quantidade = quantidade;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEspecificacao() {
			return especificacao;
		}

		public void setEspecificacao(String especificacao) {
			this.especificacao = especificacao;
		}

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}

		public float getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(float quantidade) {
			this.quantidade = quantidade;
		}

		@Override
		public String toString() {
			return "Produtos [id=" + id + ", nome=" + nome + ", especificacao=" + especificacao + ", valor=" + valor
					+ ", quantidade=" + quantidade + "]";
		}
		
		
}
