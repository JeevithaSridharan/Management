package demo.usecase.demo.service.Impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import demo.usecase.demo.model.Admin;
import demo.usecase.demo.model.AdminLogin;
import demo.usecase.demo.model.AdminProfileRepository;
import demo.usecase.demo.model.AdminRepository;
import demo.usecase.demo.model.Approval;
import demo.usecase.demo.model.ApprovalRepository;

@Service
public class AdminServiceImp {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminProfileRepository profileRepository;
	@Autowired
	private ApprovalRepository approvalRepository;

	public AdminLogin createAdmin(AdminLogin adminLogin) {
		if (adminLogin.getUser_name() == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		adminLogin.setLast_login(new Timestamp(System.currentTimeMillis()));
		return adminRepository.save(adminLogin);
	}

	public List<AdminLogin> findAll() {
		return adminRepository.findAll();
	}

	public AdminLogin findById(Long id) {
		Optional<AdminLogin> admin = adminRepository.findById(id);
		return admin.orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
	}

	public AdminLogin update(Long id, AdminLogin admin) {

		if (!adminRepository.existsById(id)) {
			throw new RuntimeException("Admin not found with ID: " + id);
		}
		admin.setAdmin_id(id);
		return adminRepository.save(admin);
	}

	public void deleteById(Long id) {
		if (adminRepository.existsById(id)) {
			adminRepository.deleteById(id);
		} else {
			throw new RuntimeException("Admin not found with ID: " + id);
		}
	}

	public Admin createProfile(Admin admin, Long admin_id) {
		if (adminRepository.existsById(admin_id)) {
			admin.setAdminId(admin_id);
			return profileRepository.save(admin);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AdminLogin not found with ID: " + admin_id);
		}
	}

	public List<Admin> findprofileAll() {
		return profileRepository.findAll();
	}

	public Admin findprofileId(Long id) {
		Optional<Admin> admin = profileRepository.findById(id);
		return admin.orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
	}

	public Admin update(Long id, Admin admin) {

		if (!adminRepository.existsById(id)) {
			throw new RuntimeException("Admin not found with ID: " + id);
		}
		admin.setAdminId(id);
		return profileRepository.save(admin);
	}

	public void deleteByProfileId(Long id) {
		if (profileRepository.existsById(id)) {
			profileRepository.deleteById(id);
		} else {
			throw new RuntimeException("Admin not found with ID: " + id);
		}
	}

	public List<Approval> getApprovalList(String status) {
	    if (status == null || status.isEmpty()) {
	       
	        return approvalRepository.findAll();
	    } else {
	        switch (status.toLowerCase()) {
	            case "pending":
	                return approvalRepository.findByStatus(0); 
	            case "approved":
	                return approvalRepository.findByStatus(1); 
	            case "rejected":
	                return approvalRepository.findByStatus(2); 
	            default:
	                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value");
	        }
	    }
	}

	public Approval updateApprovalStatus(Long id, Long adminId, int status, String reason) {
		Approval approval = approvalRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Approval request not found with ID: " + id));

		if (approval.getStatus() == 0) {
			approval.setStatus(status);
			approval.setReason(reason);
			approval.setApproval_time(LocalDateTime.now());
			approval.setAdmin_id(adminId);
			return approvalRepository.save(approval);
		} else {

			if (!approval.getAdmin_id().equals(adminId)) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"This request has already been " + (approval.getStatus() == 1 ? "approved" : "rejected")
								+ " by another admin. No further changes allowed.");
			} else {

				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request already "
						+ (approval.getStatus() == 1 ? "approved" : "rejected") + ". No further changes allowed.");
			}
		}
	}

	

}
