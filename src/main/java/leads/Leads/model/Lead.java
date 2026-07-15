package leads.Leads.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leads")
@Data
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String qualification;
    private Integer experienceYears;
    private Integer leadScore;
    private String status;
}