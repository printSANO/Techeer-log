package consolelog.image.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.result.ResultCode;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(summary = "이미지 업로드", description = "이미지를 넘겨서 업로드")
    @PostMapping("/upload")
    public ResponseEntity<ResultResponse<String>> upload(@Login AuthInfo authInfo, @RequestParam MultipartFile multipartFile) {
        String imageUrl = imageService.upload(authInfo.getNickname(), multipartFile);
        ResultResponse<String> response = new ResultResponse<>(ResultCode.UPLOAD_SUCCESS, imageUrl);

        return ResponseEntity.ok().body(response);
    }
}
