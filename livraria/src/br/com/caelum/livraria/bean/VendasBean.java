package br.com.caelum.livraria.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;

public class VendasBean {

	public List<Venda> getVendas() {
		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		List<Venda> vendas = new ArrayList();
		Random random = new Random(1234);
		for (Livro livro : livros) {
			Integer quantidade = random.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		return vendas;
	}

	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		ChartSeries vendasSerie = new ChartSeries();
		vendasSerie.setLabel("Vendas 2019");
		List<Venda> vendas = getVendas();
		for (Venda venda : vendas) {
			vendasSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		model.addSeries(vendasSerie);
		return model;
	}

}
