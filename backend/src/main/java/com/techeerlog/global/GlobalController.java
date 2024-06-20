package com.techeerlog.global;

import com.techeerlog.global.response.ResultResponse;
import com.techeerlog.global.support.EnumModel;
import com.techeerlog.member.enums.RoleType;
import com.techeerlog.project.enums.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.techeerlog.global.response.ResultCode.FIND_PROJECT_SUCCESS;

@Tag(name = "Global", description = "Global API Document")
@RestController
@RequestMapping("/v1")
public class GlobalController {

    @Operation(summary = "health check", description = "health check")
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.status(200)
                .body("health check Ok");
    }

    @Operation(summary = "Enum 조회", description = "Enum 조회")
    @GetMapping("/enums")
    public ResponseEntity<ResultResponse<Map<String, String[]>>> findEnum() {
        Map<String, String[]> enumMap = new HashMap<>();

        enumMap.put("platformEnum", enumValuesToJson(PlatformEnum.class));
        enumMap.put("projectMemberTypeEnum", enumValuesToJson(ProjectMemberTypeEnum.class));
        enumMap.put("projectStatusEnum", enumValuesToJson(ProjectStatusEnum.class));
        enumMap.put("projectTypeEnum", enumValuesToJson(ProjectTypeEnum.class));
        enumMap.put("searchFieldEnum", enumValuesToJson(SearchFieldEnum.class));
        enumMap.put("semesterEnum", enumValuesToJson(SemesterEnum.class));
        enumMap.put("roleType", enumValuesToJson(RoleType.class));
        enumMap.put("rankEnum", enumValuesToJson(RankEnum.class));
        enumMap.put("sortDirection", new String[]{"ASC", "DESC"});

        ResultResponse<Map<String, String[]>> resultResponse = new ResultResponse<>(FIND_PROJECT_SUCCESS, enumMap);

        return ResponseEntity.status(FIND_PROJECT_SUCCESS.getStatus())
                .body(resultResponse);
    }

    public static String[] enumValuesToJson(Class<? extends EnumModel> enumClass) {
        EnumModel[] enumConstants = enumClass.getEnumConstants();
        String[] enumValues = new String[enumConstants.length];

        for (int i = 0; i < enumConstants.length; ++i) {
            enumValues[i] = enumConstants[i].getName();
        }
        return enumValues;
    }
}
