package demo.usecase.demo.model;


import demo.usecase.demo.model.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface AdminProfileRepository extends JpaRepository<Admin, Long> {

	//Optional<Admin> getAdminProfileById(Long id);
	 List<Admin> findAll();
	 Admin getAdminProfileById(Long id);
	

                     	
}
