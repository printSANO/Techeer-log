package com.techeerlog.image.controller;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.response.ResultResponse;
import com.techeerlog.global.support.token.Login;
import com.techeerlog.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.techeerlog.global.response.ResultCode.UPLOAD_SUCCESS;


@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(summary = "이미지 업로드", description = "이미지를 넘겨서 업로드")
    @PostMapping( value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<ResultResponse<String>> upload(@Login AuthInfo authInfo, @RequestParam("file") MultipartFile multipartFile) {
        String imageUrl = imageService.upload(authInfo.getNickname(), multipartFile);
        ResultResponse<String> response = new ResultResponse<>(UPLOAD_SUCCESS, imageUrl);

        return ResponseEntity
                .status(UPLOAD_SUCCESS.getStatus())
                .body(response);
    }
}
