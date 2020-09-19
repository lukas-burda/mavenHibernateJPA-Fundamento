package teste;

import java.util.List;

import dao.produtoDAO;
import model.produto;

public class Teste {

	public static void main(String[] args) {
		produtoDAO dao = new produtoDAO();
		produto prod = null;
		/*
		prod = new produto("camisetaX", 1);
		dao.saveProd(prod);
		
		prod.setNome("camisetaUpdate");
		dao.updateProd(prod);
		
		produto pro2= null;
		pro2 = dao.getProdById(1);
		System.out.println(pro2.getNome() + " " +  pro2.getCod_interno());
		*/
		List<produto> lista = dao.getAllProd();
		
		for (produto s:lista) {
			System.out.println(s.getNome() + " " + s.getCod_interno());
		};
		

	
	}

}
