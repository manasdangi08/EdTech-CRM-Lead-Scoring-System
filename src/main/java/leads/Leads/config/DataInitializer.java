package leads.Leads.config;

import leads.Leads.model.Lead;
import leads.Leads.repository.LeadRepository;
import leads.Leads.service.LeadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner start(LeadRepository repo, LeadService service) {
        return args -> {
            if (repo.count() == 0) {
                // High Score Lead Target
                Lead l1 = new Lead();
                l1.setName("Rahul Sharma");
                l1.setQualification("B.Tech");
                l1.setExperienceYears(3);
                l1.setStatus("New");
                repo.save(service.calculateScore(l1));

                // Low Score Lead Target
                Lead l2 = new Lead();
                l2.setName("Amit Kumar");
                l2.setQualification("B.Com");
                l2.setExperienceYears(0);
                l2.setStatus("New");
                repo.save(service.calculateScore(l2));
                
                System.out.println(">>> System Initialized with package leads.Leads! <<<");
            }
        };
    }
}