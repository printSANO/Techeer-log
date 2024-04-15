package consolelog.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListRequest {
    private int pageStart;
    private int pageSize;
    private SearchCondition searchCondition;
}
