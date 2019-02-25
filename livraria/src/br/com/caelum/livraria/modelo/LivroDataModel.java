package br.com.caelum.livraria.modelo;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.DAO;

public class LivroDataModel extends LazyDataModel<Livro> {

	private DAO<Livro> dao = new DAO<Livro>(Livro.class);

	public LivroDataModel() {
		super.setRowCount(dao.contaTodos());
	}

	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao,
			Map<String, Object> filtros) {
		System.out.println("Carregando os livros");
		String titulo = (String) filtros.get("genero");
		return dao.listaTodosPaginada(inicio, quantidade, "genero", titulo);
	}

}
