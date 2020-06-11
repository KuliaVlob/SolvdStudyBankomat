package com.solvd.dao;

import com.solvd.model.Users;

import org.apache.ibatis.session.SqlSession;
import com.solvd.utils.MyBatisConfigUtil;

public class UsersDAO implements IUsersDAO {

	private IUsersDAO entityDAO;
	private Class<IUsersDAO> DAOUsersClass = IUsersDAO.class;

	@Override
	public Users getUsersByLogin(String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		Users entity = entityDAO.getUsersByLogin(login);
		session.close();
		return entity;
	}

	@Override
	public Users getUsersAmmount(String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		Users entity = entityDAO.getUsersAmmount(login);
		session.close();
		return entity;
	}

	@Override
	public void updateAmmount(Double total_ammount, String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		entityDAO.updateAmmount(total_ammount, login);
		session.commit();
		session.close();
	}

}
