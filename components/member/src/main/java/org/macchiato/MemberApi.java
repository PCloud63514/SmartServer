package org.macchiato;


import lombok.RequiredArgsConstructor;
import org.macchiato.domain.Member;
import org.macchiato.member.library.body.request.AddMemberRequest;
import org.macchiato.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RequestMapping("members")
@RestController
public class MemberApi {
    private final MemberService memberService;

    @PostMapping
    public void addUser(@RequestBody AddMemberRequest request) {
        memberService.addMember(new Member(request.getName(), request.getMailAddress()));
    }

    // add
    // search list
    // search
    // modify
    // remove
}
