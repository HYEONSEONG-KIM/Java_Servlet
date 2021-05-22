package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapException;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {
	
	public List<MemberVO> selectMember() throws SQLException;
	
	public String checkId(String id) throws SQLException;
	
	public String insertMembeer(MemberVO memVo) throws SQLException;
	
	public int updateMember(MemberVO memVo) throws SQLException;
	
	public int deleteMember(String memId) throws SQLException;
}
