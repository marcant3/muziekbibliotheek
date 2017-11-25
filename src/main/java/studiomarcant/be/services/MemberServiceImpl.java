package studiomarcant.be.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiomarcant.be.dao.MemberDao;
import studiomarcant.be.model.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;
	
	@Override
	public Object findAll() {
		Object foundList = dao.findAll();
		return foundList;
	}

	@Override
	public Member find(int id) {
		Member found = dao.findOne(id);
		return found;
	}

	@Override
	public Member find(String memberName) {
		Member found = null;
		List<Member> foundList = (ArrayList<Member>) dao.findAll();
		for (Member member : foundList) {
			if (member.getUserName().equals(memberName)) {
				found = member;
			}
		}
		return found;
	}

	@Override
	public Member createMember(Member member) {
		dao.save(member);
		return member;
	}

	@Override
	public Member updateMember(Member member) {
		Member found = dao.findOne(member.getUserID());
		dao.save(member);
		return found;
	}

	@Override
	public Member deleteMember(Member member) {
		Member found = dao.findOne(member.getUserID());
		dao.delete(found);
		return found;
	}

}
