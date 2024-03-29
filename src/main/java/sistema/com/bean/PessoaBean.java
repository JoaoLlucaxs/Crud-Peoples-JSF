package sistema.com.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Exceptions.ExceptionClass;
import sistema.com.dao.DAOGeneric;
import sistema.com.model.Pessoa;

@ViewScoped
@Named(value="pessoaBean")
public class PessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa=new Pessoa();
	
	@Inject
	private DAOGeneric<Pessoa> daoPessoa=new DAOGeneric<Pessoa>();
	
	private List<Pessoa> pessoas=new ArrayList<Pessoa>();  // listando na tabela

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
