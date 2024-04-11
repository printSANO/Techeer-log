package consolelog.Framework.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@AllArgsConstructor
@Getter
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    public Framework() {
    }
}
