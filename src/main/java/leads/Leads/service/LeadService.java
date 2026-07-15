package leads.Leads.service;

import leads.Leads.model.Lead;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    public Lead calculateScore(Lead lead) {
        int score = 0;
        if (lead.getQualification().equalsIgnoreCase("B.Tech") || 
            lead.getQualification().equalsIgnoreCase("MCA")) {
            score += 5;
        } else {
            score += 2;
        }

        if (lead.getExperienceYears() >= 2) {
            score += 5;
        } else if (lead.getExperienceYears() > 0) {
            score += 3;
        }

        lead.setLeadScore(score);
        return lead;
    }
}