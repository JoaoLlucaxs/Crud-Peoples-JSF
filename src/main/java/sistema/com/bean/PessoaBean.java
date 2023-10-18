package sistema.com.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.com.dao.DAOGeneric;
import sistema.com.model.Pessoa;

@ViewScoped
@ManagedBean
public class PessoaBean {
	
	private Pessoa pessoa=new Pessoa();
	
	private DAOGeneric<Pessoa> daoPessoa=new DAOGeneric<Pessoa>();
	
	private List<Pessoa> pessoas=new ArrayList<Pessoa>();
	
	public String salvar() {
		pessoa=daoPessoa.merge(pessoa);
		
		carregarPessoas(); // fazer o carremento da tabela na tela após salvar
		
		return "";
	}
	
	public String novo() { // limpando os campos
		pessoa=new Pessoa();
		return "";
	}
	
	public String delete() {
		daoPessoa.removerPorId(pessoa);
		
		carregarPessoas();	
		
		pessoa=new Pessoa(); //limpando campos após remoção
		
		return "";
	}
	
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
