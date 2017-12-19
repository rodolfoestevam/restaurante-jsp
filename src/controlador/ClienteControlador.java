package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Categoria;
import classes.Cliente;
import dados.DAOCliente;
import dao.DAOFactory;

public class ClienteControlador {

	public void salvar(Cliente cliente) throws Exception {
		DAOCliente factoryCliente = DAOFactory.getDAOCliente();

		if (cliente != null) {
			if (cliente.getNome().equals("") || cliente.getNome() == null) {
				throw new Exception("Nome não preenchido");
			} else if (cliente.getEmail().equals("") || cliente.getEmail() == null) {
				throw new Exception("E-mail não preenchido");
			} else if (cliente.getCidade().equals("") || cliente.getCidade() == null) {
				throw new Exception("Cidade não preenchido");
			} else if (cliente.getFacebookPage().equals("") || cliente.getFacebookPage() == null) {
				throw new Exception("Facebook não preenchido");
			} else if (cliente.getTwitterUser().equals("") || cliente.getTwitterUser() == null) {
				throw new Exception("Twitter não preenchido");
			} else if (cliente.getDataNascimento().equals("") || cliente.getDataNascimento() == null) {
				throw new Exception("Data Nascimento não preenchido");
			} else if (cliente.getBairro().equals("") || cliente.getBairro() == null) {
				throw new Exception("Bairro não preenchido");
			} else if (cliente.getNumero().equals("") || cliente.getNumero() == null) {
				throw new Exception("Número do endereço não preenchido");
			} else if (cliente.getTelefone().equals("") || cliente.getTelefone() == null) {
				throw new Exception("Telefone não preenchido");
			} else {
				factoryCliente.insert(cliente);
			}
		}

	}

	public void editar(Cliente cliente) throws Exception {

		DAOCliente factoryCliente = DAOFactory.getDAOCliente();
		Cliente cliente_search = factoryCliente.searchByKey(cliente.getId());
		if ((cliente_search != null) && (!cliente.getNome().trim().equals(""))) {
			factoryCliente.update(cliente);
		} else {
			throw new Exception("Erro ao editar o cliente");
		}

	}

	public void deletar(Cliente cliente) throws Exception {
		DAOCliente factoryCliente = DAOFactory.getDAOCliente();
		Cliente cliente_search = factoryCliente.searchByKey(cliente.getId());
		if ((cliente_search != null) && (!cliente.getNome().trim().equals(""))) {
			factoryCliente.remove(cliente);
		} else {
			throw new Exception("Erro ao deletar o cliente");
		}
	}

	public ArrayList<Cliente> listar() throws Exception {
		DAOCliente factoryCliente = DAOFactory.getDAOCliente();
		ArrayList<Cliente> retorno = (ArrayList<Cliente>) factoryCliente.getAll();
		return retorno;
	}

	public Cliente pesquisar(Cliente cliente) throws Exception {

		DAOCliente factoryCliente = DAOFactory.getDAOCliente();
		Cliente cliente_search = factoryCliente.searchByKey(cliente.getId());
		return cliente_search;
		/*
		 * if((cliente_search != null) &&
		 * (!cliente.getCpf_cnpj().trim().equals(""))){
		 * 
		 * } else { throw new Exception("Erro ao pesquisar o cliente"); }
		 */
	}
}
