package bitlab.g1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "course_name", length = 50)
    private String courseName;

    @Column(name = "commentary", length = 500)
    private String commentary;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "handled")
    private boolean handled;
}
