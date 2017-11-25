package studiomarcant.be.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import studiomarcant.be.model.Member;

public interface MemberDao extends JpaRepository<Member, Integer>{
	


}

