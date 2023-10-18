package sistema.com.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.com.dao.DAOGeneric;
import sistema.com.model.Pessoa;

@ViewScoped
@ManagedBean
public class PessoaBean {
	
	private Pessoa pessoa=new Pessoa();
	
	private DAOGeneric<Pessoa> daoPessoa=new DAOGeneric<Pessoa>();
	
	public String salvar() {
		pessoa=daoPessoa.merge(pessoa);
		return "";
	}
	
	public String novo() { // limpando os campos
		pessoa=new Pessoa();
		return "";
	}
	
	public String delete() {
		daoPessoa.removerPorId(pessoa);
		
		pessoa=new Pessoa(); //limpando campos após remoção
		
		return "";
	}

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
	
	
}
