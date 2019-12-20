package com.kim.myBatis1.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.myBatis1.dto.ContentDto;

//mybatis사용을 위해서는 SqlSession클래스를 이용함
//DAO클래스를 나타내며 bean클래스로 사용 가능케 함(DB를 처리하기때문에 어노테이션이 저장소임)
@Repository //(@Controller, @Service는 Command클래스, @Repository는 Dao클래스)
public class ContentDao implements IDao {
	
	@Autowired
	private SqlSession sqlSession; //field로 autowired(servlet-context.xml에서 빈생성)
	
	//Constructor
	public ContentDao() {
		
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList) sqlSession.selectList("listDao");
		//selectList("xml의 id")는 여러개의 레코드를 반환 시에 사용
		//sqlSession.close();(x) SqlSession은 강제 종료 안됨
		return result;
	}

	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0,mWriter,mContent);
		sqlSession.insert("writeDao",dto);
		//insert("IDao.xml의 insert element의 id명",IDao.xml의 insert element의 parameterType속성에 맞는 parameter);
	}

	@Override
	public ContentDto viewDao(String strID) {
		return sqlSession.selectOne("viewDao", Integer.parseInt(strID));
		//.selectOne()은 반환되는 레코드가 1개 일때(id가 pk여서 반환값이 1개)
	}

	@Override
	public void deleteDao(String bId) {
		sqlSession.delete("deleteDao", Integer.parseInt(bId));
	}	

}
