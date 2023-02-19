package fr.m2i.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

//@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Length(min = 3, max = 255)
    @Column
    private String username;

    @Length(min = 5, max = 255)
    @Column
    private String description;

    @Column
    private LocalDate targetDate;

    public Todo(String username, String description, LocalDate targetDate) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
    }

    public Todo(String username, String description) {
        this.username = username;
        this.description = description;
    }

}
