package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
public List<MemberVO> selectMember();
	
	public String insertMember(MemberVO memVo);
	
	public String checkId(String id);
	
	public int updateMember(MemberVO memVo);
	
	public int deleteMember(String memId);
}
