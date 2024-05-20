package com.techeerlog.scrap.controller;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.response.ResultResponse;
import com.techeerlog.global.support.token.Login;
import com.techeerlog.scrap.service.ScrapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.techeerlog.global.response.ResultCode.SCRAP_CREATED_SUCCESS;
import static com.techeerlog.global.response.ResultCode.SCRAP_DELETED_SUCCESS;

@Tag(name = "Scrap", description = "Scrap API Document")
@RestController
@RequestMapping("/v1")
public class ScrapController {
    private final ScrapService scrapService;
    public ScrapController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @Operation(summary = "스크랩 하기", description = "스크랩 하기")
    @PostMapping("/scraps/{projectId}")
    public ResponseEntity<ResultResponse<Void>> createScrap(@PathVariable("projectId") Long projectId,
                                                            @Login AuthInfo authInfo) {
        scrapService.createScrap(projectId, authInfo);
        ResultResponse<Void> resultResponse = new ResultResponse<>(SCRAP_CREATED_SUCCESS);

        return ResponseEntity.status(SCRAP_CREATED_SUCCESS.getStatus()).body(resultResponse);

    }

    @Operation(summary = "스크랩 취소", description = "스크랩 취소")
    @DeleteMapping("/scraps/{projectId}")
    public ResponseEntity<ResultResponse<Void>> deleteScrap(@PathVariable("projectId") Long projectId,
                                                                     @Login AuthInfo authInfo) {
        scrapService.deleteScrap(projectId, authInfo);
        ResultResponse<Void> resultResponse = new ResultResponse<>(SCRAP_DELETED_SUCCESS);

        return ResponseEntity.status(SCRAP_DELETED_SUCCESS.getStatus()).body(resultResponse);
    }

}
