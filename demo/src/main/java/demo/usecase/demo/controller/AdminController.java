package demo.usecase.demo.controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.usecase.demo.model.Admin;
import demo.usecase.demo.model.AdminLogin;
import demo.usecase.demo.model.Approval;
import demo.usecase.demo.service.Impl.AdminServiceImp;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminServiceImp adminService;

	@GetMapping("/all")
	public List<AdminLogin> getAdmins() {
		return adminService.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<AdminLogin> createAdmin(@RequestBody AdminLogin adminLogin) {
		AdminLogin newAdmin = new AdminLogin();
		newAdmin.setUser_name(adminLogin.getUser_name());
		newAdmin.setPassword(adminLogin.getPassword());
		newAdmin.setLast_login(new Timestamp(System.currentTimeMillis()));
		AdminLogin savedAdmin = adminService.createAdmin(newAdmin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}

	@GetMapping("/all/{id}")
	public AdminLogin getAdminById(@PathVariable Long id) {
		return adminService.findById(id);
	}

	@PutMapping("/{id}")
	public AdminLogin updateAdmin(@PathVariable Long id, @RequestBody AdminLogin admin) {
		return adminService.update(id, admin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
		adminService.deleteById(id);
		return ResponseEntity.ok("Admin with ID " + id + " was deleted successfully.");
	}

	@PostMapping("/createProfile")
	public ResponseEntity<Admin> createProfile(@RequestBody Admin admin, @RequestParam Long admin_Id) {
		Admin savedAdmin = adminService.createProfile(admin, admin_Id);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}

	@GetMapping("/allProfile")
	public List<Admin> getAllProfile() {
		return adminService.findprofileAll();
	}

	@GetMapping("/allProfile/{id}")
	public Admin getAdminProfileById(@PathVariable Long id) {
		return adminService.findprofileId(id);
	}

	@PutMapping("/profile/{id}")
	public Admin updateAdminProfile(@PathVariable Long id, @RequestBody Admin admin) {
		return adminService.update(id, admin);
	}

	@DeleteMapping("/profile/{id}")
	public ResponseEntity<String> deleteAdminProfile(@PathVariable Long id) {
		adminService.deleteByProfileId(id);
		return ResponseEntity.ok("Admin with ID " + id + " was deleted successfully.");
	}

	@GetMapping("/approvals")
	public List<Approval> getApprovalList(@RequestParam(required = false) String status) {
	    return adminService.getApprovalList(status);
	}

	@PutMapping("/approvals/{id}")
	public Approval updateApprovalStatus(@PathVariable Long id, @RequestParam Long adminId, @RequestParam int status,
			@RequestParam(required = false) String reason) {

		return adminService.updateApprovalStatus(id, adminId, status, reason);
	}
}