package demo.usecase.demo.service;

import java.util.List;
import demo.usecase.demo.model.AdminLogin;

public interface AdminService {

	AdminLogin createAdmin(AdminLogin adminLogin);
	List<AdminLogin> findAll();
	List<AdminLogin> findprofileAll();


}
