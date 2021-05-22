package kr.or.ddit.dao;

import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{

	SqlMapClient smc = null;
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<MemberVO> selectMember() throws SQLException {
		List<MemberVO> list = smc.queryForList("member.selectMember");
		return list;
	}

	@Override
	public String insertMembeer(MemberVO memVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String checkId(String id) throws SQLException {
		return (String) smc.queryForObject("member.checkId",id);
	}

}
