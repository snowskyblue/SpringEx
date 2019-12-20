package com.kim.myBatis1.dao;

import java.util.ArrayList;

import com.kim.myBatis1.dto.ContentDto;

//mybatis�� xml(IDao.xml)�� ������ �����ϴ� �������̽�
public interface IDao {
	//CRUD(Create-insert(record),Retrieve-select,Update, Delete)
	public ArrayList<ContentDto> listDao(); //select
	public void writeDao(String mWriter, String mContent); //insert,update
	public ContentDto viewDao(String strID); 
	public void deleteDao(String bId);
}
