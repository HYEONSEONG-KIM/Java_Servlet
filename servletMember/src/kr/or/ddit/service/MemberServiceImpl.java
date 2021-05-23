package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	
	
	@Override
	public List<MemberVO> selectMember() {
		List<MemberVO> memList = null;
		
		try {
			memList = dao.selectMember();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public String insertMember(MemberVO memVo) {
		String id = null;
		try {
			id = dao.insertMember(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int result = 0;
		
		try {
			result = dao.updateMember(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteMember(String memId) {
		int result = 0;
		
		try {
			result = dao.deleteMember(memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String checkId(String id) {
		String memId = null;
		
		try {
			memId = dao.checkId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memId;
	}

	@Override
	public MemberVO selecetOne(String memId) {
		
		MemberVO memVo = null; 
		try {
			memVo = dao.selecetOne(memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memVo;
	}

}
