package sistema.com.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Exceptions.ExceptionClass;
import sistema.com.dao.DAOGeneric;
import sistema.com.model.Pessoa;

@ViewScoped  // Aqui não estou utilizando CDI para injeção pois estou fazendo mais manualmente
@ManagedBean(name="pessoaBean")
public class PessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Pessoa pessoa=new Pessoa();
	
	private DAOGeneric<Pessoa> daoPessoa=new DAOGeneric<Pessoa>();
	
	private List<Pessoa> pessoas=new ArrayList<Pessoa>();  // listando na tabela
	
	@PostConstruct
	public void salvar() {
		try {
		daoPessoa.merge(pessoa);
		
		carregarPessoas(); // fazer o carremento da tabela na tela após salvar
		
		
		}catch (ExceptionClass e) {
			e.printStackTrace();
		}
	}
	
	public void limpa() { // limpando os campos
		pessoa=new Pessoa();
	}
	
	public void delete() {
		try {
		daoPessoa.removerPorId(pessoa);
		
		carregarPessoas();	

		pessoa=new Pessoa(); //limpando campos após remoção
		
		
		}catch (ExceptionClass e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void carregarPessoas() {
			pessoas=daoPessoa.getListEntity(Pessoa.class);
			
	}
	// ================= GETTERS AND SETTERS=============

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DAOGeneric<Pessoa> getDaoPessoa() {
		return daoPessoa;
	}

	public void setDaoPessoa(DAOGeneric<Pessoa> daoPessoa) {
		this.daoPessoa = daoPessoa;
	}

	// Apenas o getter para lista, não faz sentido settar um list
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
}
