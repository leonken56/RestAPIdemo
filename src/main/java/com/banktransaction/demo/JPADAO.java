package jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPADAO extends JpaRepository<Bank, Long> {

	Bank findByName(String name);

}