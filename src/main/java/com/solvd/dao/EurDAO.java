package com.solvd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.model.Eur;
import com.solvd.utils.MyBatisConfigUtil;

/**
 * DAO class, used to access data from database table "Eur"
 * 
 * @see IEurDAO
 * @author Iryna Iemelianova
 */
public class EurDAO implements IEurDAO {

	private IEurDAO entityDAO;
	private Class<IEurDAO> DAOEurClass = IEurDAO.class;

	/**
	   * Method returns fields {@link Eur#banknote}, {@link Eur#quantity}, which is present in the
	   * database
	   * 
	   * @param banknote - banknote in denominations of n
	   * @return banknote, quantity of Eur
	   */
	@Override
	public Eur getQuantityByBanknoteEUR(Integer banknote) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		Eur entity = entityDAO.getQuantityByBanknoteEUR(banknote);
		session.close();
		return entity;
	}

	/**
	   * Method returns fields {@link Eur#quantity}, which is present in the database
	   * 
	   * @param quantity - the presence of banknotes in the database
	   * @return quantity of Eur banknotes
	   */
	@Override
	public Eur getQuantityEUR(String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		Eur entity = entityDAO.getQuantityEUR(quantity);
		session.close();
		return entity;
	}

	/**
	   * Method returns fields {@link Eur#banknote}, which is present in the database
	   * 
	   * @param quantity - the presence of banknotes in the database
	   * @return banknotes of Eur
	   */
	@Override
	public List<Eur> getAvailableBanknoteEUR (String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		List<Eur> entities= entityDAO.getAvailableBanknoteEUR(quantity);
		session.close();
		return entities;
	}

	

	
}