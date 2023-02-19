package fr.m2i.spring;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todoadded {
    
    private String username;
    private String description;
    private String targetDate;

    public Todoadded(String username, String description, String targetDate) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
    }
    
    
    
}
