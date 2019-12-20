package com.kim.myBatis1.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.myBatis1.dto.ContentDto;

//mybatis����� ���ؼ��� SqlSessionŬ������ �̿���
//DAOŬ������ ��Ÿ���� beanŬ������ ��� ������ ��(DB�� ó���ϱ⶧���� ������̼��� �������)
@Repository //(@Controller, @Service�� CommandŬ����, @Repository�� DaoŬ����)
public class ContentDao implements IDao {
	
	@Autowired
	private SqlSession sqlSession; //field�� autowired(servlet-context.xml���� �����)
	
	//Constructor
	public ContentDao() {
		
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList) sqlSession.selectList("listDao");
		//selectList("xml�� id")�� �������� ���ڵ带 ��ȯ �ÿ� ���
		//sqlSession.close();(x) SqlSession�� ���� ���� �ȵ�
		return result;
	}

	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0,mWriter,mContent);
		sqlSession.insert("writeDao",dto);
		//insert("IDao.xml�� insert element�� id��",IDao.xml�� insert element�� parameterType�Ӽ��� �´� parameter);
	}

	@Override
	public ContentDto viewDao(String strID) {
		return sqlSession.selectOne("viewDao", Integer.parseInt(strID));
		//.selectOne()�� ��ȯ�Ǵ� ���ڵ尡 1�� �϶�(id�� pk���� ��ȯ���� 1��)
	}

	@Override
	public void deleteDao(String bId) {
		sqlSession.delete("deleteDao", Integer.parseInt(bId));
	}	

}
