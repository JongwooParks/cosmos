package com.cosmos.app.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cosmos.app.board.vo.BoardDTO;
import com.cosmos.app.board.vo.BoardVO;
import com.cosmos.mybatis.config.MyBatisConfig;

public class MainDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public MainDAO() {
	      sqlSession = sqlSessionFactory.openSession(true);
	   }
	   
	   public List<BoardDTO> selectAll(String searchContent){
		   return sqlSession.selectList("Search.selectBoard", searchContent);
	   }
	   
	   public int countReply(int boardNumber) {
		   return sqlSession.selectOne("Search.countReply", boardNumber);
	   }
	   

	   
	   public List<String> skillFile(int boardNumber){
		   return sqlSession.selectList("Search.skillFile",boardNumber);
	   }
}
