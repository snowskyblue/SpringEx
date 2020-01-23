package com.kim.social;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginApi extends DefaultApi20 {
	//protected는 다른 패키지에서 접근 불가(외부에서는 생성자를 통해 씀)
    //클래스 내부에서는 생성자를 사용할 수 있음
	protected NaverLoginApi(){
    }
	
	
	//내부에서는 생성자 쓸 수 있음
    private static class InstanceHolder{
        private static final NaverLoginApi INSTANCE = new NaverLoginApi();
    }

    //생성자 열할
    public static NaverLoginApi instance(){
        return InstanceHolder.INSTANCE;
    }
    
    //주소는 naver에서 정해놓음
    @Override
    public String getAccessTokenEndpoint() {
        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
    }                   

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://nid.naver.com/oauth2.0/authorize";
    } 
}
