package com.solvd.dao;

import org.apache.ibatis.session.SqlSession;

import com.solvd.model.Eur;
import com.solvd.utils.MyBatisConfigUtil;

public class EurDAO implements IEurDAO {

	private IEurDAO entityDAO;
	private Class<IEurDAO> DAOEurClass = IEurDAO.class;

	@Override
	public Eur getQuantityByBanknoteEUR(Integer banknote) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		Eur entity = entityDAO.getQuantityByBanknoteEUR(banknote);
		session.close();
		return entity;
	}

	@Override
	public Eur getQuantityEur(Integer quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		Eur entity = entityDAO.getQuantityEur(quantity);
		session.close();
		return entity;
	}

	@Override
	public void updateQuantityByBanknoteEUR(Eur entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		entityDAO.updateQuantityByBanknoteEUR(entity);
		session.commit();
		session.close();

	}

}
