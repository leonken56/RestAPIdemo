package jpa;

public interface JPADAO extends JpaRepository<Bank, Long> {

	Bank findByName(String name);

}