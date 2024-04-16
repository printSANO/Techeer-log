package consolelog.member.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.global.support.token.TokenManager;
import consolelog.member.domain.Member;
import consolelog.member.dto.EditMemberRequest;
import consolelog.member.dto.MemberMapper;
import consolelog.member.dto.MemberResponse;
import consolelog.member.dto.ProfileResponse;
import consolelog.member.dto.SignupRequest;
import consolelog.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static consolelog.global.response.ResultCode.FIND_PROFILE_SUCCESS;
import static consolelog.global.response.ResultCode.SIGNUP_SUCCESS;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

    private final MemberService memberService;
    private final TokenManager tokenManager;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, TokenManager tokenManager, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.tokenManager = tokenManager;
        this.memberMapper = memberMapper;
    }

    @Operation(summary = "회원가입", description = "회원가입 기능")
    @PostMapping(value = "/signup", consumes = "multipart/form-data")
    public ResponseEntity<ResultResponse<MemberResponse>> signUp(@RequestPart("data") SignupRequest signupRequest,
                                                                @RequestPart("file") MultipartFile multipartFile) {
        Member member = memberService.signUp(signupRequest, multipartFile);
        ResultResponse<MemberResponse> resultResponse = new ResultResponse<>(SIGNUP_SUCCESS, memberMapper.memberToMemberResponse(member));

        return ResponseEntity.status(SIGNUP_SUCCESS.getStatus()).body(resultResponse);
    }

//    @GetMapping(value = "/signup/exists", params = "loginId")
//    public ResponseEntity<UniqueResponse> validateUniqueLoginId(@RequestParam String loginId) {
//        UniqueResponse uniqueResponse = memberService.checkUniqueLoginId(loginId);
//        return ResponseEntity.ok(uniqueResponse);
//    }
//
//    @GetMapping(value = "/signup/exists", params = "nickname")
//    public ResponseEntity<UniqueResponse> validateUniqueNickname(@RequestParam String nickname) {
//        UniqueResponse uniqueResponse = memberService.checkUniqueNickname(nickname);
//        return ResponseEntity.ok(uniqueResponse);
//    }

    @Operation(summary = "프로필 조회", description = "프로필 조회 기능")
    @GetMapping("/profile")
    public ResponseEntity<ResultResponse<ProfileResponse>> findProfile(@Login AuthInfo authInfo) {
        ProfileResponse profileResponse = memberService.findProfile(authInfo);
        ResultResponse<ProfileResponse> resultResponse = new ResultResponse<>(FIND_PROFILE_SUCCESS, profileResponse);

        return ResponseEntity.status(FIND_PROFILE_SUCCESS.getStatus()).body(resultResponse);
    }

    // 수정 필요
    // 닉네임 수정 구현해 볼 것

    @PatchMapping(consumes = "multipart/form-data")
    public ResponseEntity<Void> editMember(@RequestPart(value = "data", required = false) EditMemberRequest editMemberRequest,
                                           @RequestPart(value = "part", required = false) Optional<MultipartFile> multipartFile,
                                           @Login AuthInfo authInfo) {
        memberService.edit(editMemberRequest, authInfo, multipartFile);
        return ResponseEntity.noContent()
                .header(HttpHeaders.AUTHORIZATION,
                        "Bearer " + tokenManager.createNewTokenWithNewNickname(
                                editMemberRequest.getNickname(), authInfo)
                )
                .build();
    }
}
