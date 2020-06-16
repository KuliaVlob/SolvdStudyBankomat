package com.solvd.dao;

import com.solvd.model.Users;

import org.apache.ibatis.session.SqlSession;
import com.solvd.utils.MyBatisConfigUtil;

/**
 * DAO class, used to access data from database table "Users"
 * 
 * @see IUsersDAO
 * @author Iryna Iemelianova
 */
public class UsersDAO implements IUsersDAO {

	private IUsersDAO entityDAO;
	private Class<IUsersDAO> DAOUsersClass = IUsersDAO.class;

	/**
	   * Method returns field {@link Users#login}, which is present in the database
	   * 
	   * @return user's login
	   */
	@Override
	public Users getUsersByLogin(String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		Users entity = entityDAO.getUsersByLogin(login);
		session.close();
		return entity;
	}

	 /**
	   * Method returns field {@link Users#total_amount}, which is present in the database
	   * 
	   * @param login - user's login
	   * @return user's total_amount
	   */
	@Override
	public Users getUsersAmount(String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		Users entity = entityDAO.getUsersAmount(login);
		session.close();
		return entity;
	}

	/**
	   * Method updates column {@link Users#total_amount}, which is present in the database
	   * 
	   * @param login - user's login
	   * @param total_amount - user's total_amount
	   */
	@Override
	public void updateAmount(Double total_amount, String login) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOUsersClass);
		entityDAO.updateAmount(total_amount, login);
		session.commit();
		session.close();
	}

}
