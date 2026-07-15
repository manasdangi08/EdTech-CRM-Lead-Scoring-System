package leads.Leads.controller;

import leads.Leads.model.Lead;
import leads.Leads.repository.LeadRepository;
import leads.Leads.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private LeadService leadService;

    @PostMapping("/add-lead")
    public Lead addLead(@RequestBody Lead lead) {
        Lead scoredLead = leadService.calculateScore(lead);
        return leadRepository.save(scoredLead);
    }

    @GetMapping("/daily-queue")
    public List<Lead> getDailyQueue() {
        return leadRepository.findTop80ByStatusOrderByLeadScoreDesc("New");
    }
}