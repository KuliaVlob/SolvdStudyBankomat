package com.solvd.dao;

import java.util.List;

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
	public Eur getQuantityEUR(String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		Eur entity = entityDAO.getQuantityEUR(quantity);
		session.close();
		return entity;
	}

	
	@Override
	public List<Eur> getAvailableBanknoteEUR (String quantity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOEurClass);
		List<Eur> entities= entityDAO.getAvailableBanknoteEUR(quantity);
		session.close();
		return entities;
	}

	

	
}