package leads.Leads.repository;

import leads.Leads.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findTop80ByStatusOrderByLeadScoreDesc(String status);
}