package consolelog.scrap.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.scrap.dto.ScrapRequest;
import consolelog.scrap.dto.ScrapResponse;
import consolelog.scrap.service.ScrapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static consolelog.global.response.ResultCode.SCRAP_CREATED_SUCCESS;
import static consolelog.global.response.ResultCode.SCRAP_GET_SUCCESS;

@Tag(name = "Scrap", description = "Scrap API Document")
@RestController
@RequestMapping("/v1")
public class ScrapController {
    private final ScrapService scrapService;

    public ScrapController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @Operation(summary = "스크랩 생성", description = "스크랩 생성")
    @PostMapping("/scraps")
    public ResponseEntity<ResultResponse<Void>> createScrap(@RequestBody ScrapRequest scrapRequest,
                                                                     @Login AuthInfo authInfo) {
        scrapService.createScrap(scrapRequest.getProjectId(), authInfo);
        ResultResponse<Void> resultResponse = new ResultResponse<>(SCRAP_CREATED_SUCCESS);

        return ResponseEntity.status(SCRAP_CREATED_SUCCESS.getStatus()).body(resultResponse);

    }

    @GetMapping("/scraps/{memberId}")
    public ResponseEntity<ResultResponse<List<ScrapResponse>>> getScrapsByMemberId(@PathVariable Long memberId) {
        List<ScrapResponse> scraps = scrapService.getScrapsByMemberId(memberId);
        ResultResponse<List<ScrapResponse>> resultResponse = new ResultResponse<>(SCRAP_GET_SUCCESS, scraps);
        return ResponseEntity.status(SCRAP_GET_SUCCESS.getStatus()).body(resultResponse);
    }

}
