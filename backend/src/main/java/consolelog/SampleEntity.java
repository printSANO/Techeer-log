package consolelog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
public class SampleEntity {
    @Id
    private Long id;

    private String name;
}
