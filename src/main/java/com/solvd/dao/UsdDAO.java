package com.solvd.dao;

import org.apache.ibatis.session.SqlSession;

import com.solvd.model.Usd;
import com.solvd.utils.MyBatisConfigUtil;

import java.util.List;

/**
 * DAO class, used to access data from database table "Usd"
 * 
 * @see IUsdDAO
 * @author Iryna Iemelianova
 */
public class UsdDAO implements IUsdDAO {

	private IUsdDAO entityDAO;
	private Class<IUsdDAO> DAOUsdClass = IUsdDAO.class;

	/**
	   * Method returns fields {@link Usd#banknote}, {@link Usd#quantity}, which is present in the
	   * database
	   * 
	   * @param banknote - banknote in denominations of n
	   * @return banknote, quantity of USD
	   */
	@Override
	public Usd getQuantityByBanknoteUSD(Integer banknote) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		Usd entity = entityDAO.getQuantityByBanknoteUSD(banknote);
		session.close();
		return entity;
	}

	/**
	   * Method returns fields {@link Usd#quantity}, which is present in the database
	   * 
	   * @param quantity - the presence of banknotes in the database
	   * @return quantity of USD banknotes
	   */
	@Override
	public Usd getQuantityUSD(String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		Usd entity = entityDAO.getQuantityUSD(quantity);
		session.close();
		return entity;
	}

	/**
	   * Method returns fields {@link Usd#banknote}, which is present in the database
	   * 
	   * @param quantity - the presence of banknotes in the database
	   * @return banknote of USD
	   */
	@Override
	public List<Usd> getAvailableBanknoteUSD (String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		List<Usd> entities= entityDAO.getAvailableBanknoteUSD(quantity);
		session.close();
		return entities;
	}

	

}
