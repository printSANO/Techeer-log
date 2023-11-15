package consolelog.image.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.result.ResultCode;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(summary = "이미지 업로드", description = "이미지를 넘겨서 업로드")
    @PostMapping("/upload")
    public ResponseEntity<ResultResponse<String>> upload(@Login AuthInfo authInfo, @RequestParam("imageFile")File file) {
        String imageUrl = imageService.upload(authInfo.getId(), file);
        ResultResponse<String> response = new ResultResponse<>(ResultCode.UPLOAD_SUCCESS, imageUrl);

        return ResponseEntity.ok().body(response);
    }
}
