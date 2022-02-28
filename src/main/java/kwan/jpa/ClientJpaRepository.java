package kwan.jpa;

import kwan.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.invoice = ?1")
    List<Client> findClientByInvoice(String invoice);
}
