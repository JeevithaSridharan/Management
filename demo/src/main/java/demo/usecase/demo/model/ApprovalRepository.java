package demo.usecase.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Approval ,Long> {

	List<Approval> findByStatus(int i);
	

}
