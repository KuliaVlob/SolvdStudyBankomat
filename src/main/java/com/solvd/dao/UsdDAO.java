package com.solvd.dao;

import org.apache.ibatis.session.SqlSession;

import com.solvd.model.Usd;
import com.solvd.utils.MyBatisConfigUtil;

import java.util.List;

public class UsdDAO implements IUsdDAO {

	private IUsdDAO entityDAO;
	private Class<IUsdDAO> DAOUsdClass = IUsdDAO.class;

	@Override
	public Usd getQuantityByBanknoteUSD(Integer banknote) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		Usd entity = entityDAO.getQuantityByBanknoteUSD(banknote);
		session.close();
		return entity;
	}

	@Override
	public Usd getQuantityUSD(String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		Usd entity = entityDAO.getQuantityUSD(quantity);
		session.close();
		return entity;
	}

	@Override
	public void updateQuantityByBanknoteUSD(Usd entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		entityDAO.updateQuantityByBanknoteUSD(entity);
		session.commit();
		session.close();
	}

	@Override
	public List<Usd> getUSD() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		List<Usd> entities= entityDAO.getUSD();
		session.close();
		return entities;
	}

	@Override
	public void getBanknoteUSD(Usd entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsdClass);
		entityDAO.getBanknoteUSD(entity);
		session.commit();
		session.close();
	}

}
