package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.produto;
import util.HibernateUtil;

public class produtoDAO {

	public void saveProd(produto prod) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.save(prod);
			trans.commit();
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
		}
		
	}
	
	public void updateProd(produto prod) {
		Transaction trans = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			
			session.saveOrUpdate(prod);
			
			trans.commit();
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
		}
		
	}
	
	public produto getProdById(long cod_bar) {
		Transaction trans = null;
		produto prod = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			
			prod = session.get(produto.class, cod_bar);
			
			trans.commit();
		} catch (Exception e) {
			if(trans!=null) {
				e.printStackTrace();
			}
		}
		return prod;
		
	}
	
	public List<produto> getAllProd() {
		Transaction trans = null;
		List<produto> produtos = null;
		try( Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			
			CriteriaBuilder buider = session.getCriteriaBuilder();
			CriteriaQuery<produto> criteriaQuery = buider.createQuery(produto.class);
			criteriaQuery.from(produto.class);
			
			produtos = session.createQuery(criteriaQuery).getResultList();
			
			trans.commit();
			
		}catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
		}
		return produtos;
	}
	
	public void deleteProd(long cod_bar) {
		Transaction trans = null;
		produto prod = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			trans=session.beginTransaction();
			
			prod = session.get(produto.class, cod_bar);
			
			session.remove(prod);
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
		}
	}
	
}
