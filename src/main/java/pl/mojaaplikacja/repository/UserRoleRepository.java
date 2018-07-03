package pl.mojaaplikacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.mojaaplikacja.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	public UserRole findByRole(String role);	
}
