package consolelog.image.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultCode;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(summary = "이미지 업로드", description = "이미지를 넘겨서 업로드")
    @PostMapping( value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<ResultResponse<String>> upload(@Login AuthInfo authInfo, @RequestParam MultipartFile multipartFile) {
        String imageUrl = imageService.upload(authInfo.getNickname(), multipartFile);
        ResultResponse<String> response = new ResultResponse<>(ResultCode.UPLOAD_SUCCESS, imageUrl);

        // 수정 필요
        return ResponseEntity.ok().body(response);
    }
}
