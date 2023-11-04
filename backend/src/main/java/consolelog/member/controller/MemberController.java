package consolelog.member.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.dto.NicknameResponse;
import consolelog.member.dto.SignupRequest;
import consolelog.member.dto.UniqueResponse;
import consolelog.member.service.MemberService;
import consolelog.global.support.token.Login;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignupRequest signupRequest) {
        memberService.signUp(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/signup/exists", params = "loginId")
    public ResponseEntity<UniqueResponse> validateUniqueLoginId(@RequestParam String loginId) {
        UniqueResponse uniqueResponse = memberService.checkUniqueLoginId(loginId);
        return ResponseEntity.ok(uniqueResponse);
    }

    @GetMapping(value = "/signup/exists", params = "nickname")
    public ResponseEntity<UniqueResponse> validateUniqueNickname(@RequestParam String nickname) {
        UniqueResponse uniqueResponse = memberService.checkUniqueNickname(nickname);
        return ResponseEntity.ok(uniqueResponse);
    }

    @GetMapping("/nickname")
    public ResponseEntity<NicknameResponse> findNickname(@Login AuthInfo authInfo) {
        NicknameResponse nicknameResponse = memberService.findNickname(authInfo);
        return ResponseEntity.ok(nicknameResponse);
    }
//    @PatchMapping("/nickname")
//    public ResponseEntity<Void> editNickname(@ResponseBody EditNicknameRequest editNicknameRequest, @Login AuthInfo authInfo) {
//        memberService.editNickname(editNicknameRequest, authInfo);
//        return ResponseEntity.noContent()
//                .header(HttpHeaders.AUTHORIZATION,
//                        "Bearer" + tokenManager.createNewTokenWithNewNickName(
//                                nicknameUpdateRequest.getNickname(), authInfo)
//                )
//                .build();
//    }
}
