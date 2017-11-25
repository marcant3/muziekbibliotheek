package studiomarcant.be.services;

import studiomarcant.be.model.Member;

public interface MemberService {
	public Object findAll();

	public Member find(int id);

	public Member find(String memberName);

	public Member createMember(Member member);

	public Member updateMember(Member member);

	public Member deleteMember(Member member);

}
