package demo.usecase.demo.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminLogin, Long> {

	AdminLogin save(AdminLogin adminLogin);
  
}