package consolelog.project.dto;

import consolelog.project.enums.SearchFieldEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCondition {
    private String keyword;
    private SearchFieldEnum searchFieldEnum;
    private Sort.Direction sortDirection;
}
