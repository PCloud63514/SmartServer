package org.macchiato.member;


import lombok.RequiredArgsConstructor;
import org.macchiato.member.domain.Member;
import org.macchiato.member.library.body.request.AddMemberRequest;
import org.macchiato.member.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RequestMapping("members")
@RestController
public class MemberApi {
    private final MemberService memberService;

    @PostMapping
    public Long addUser(@RequestBody AddMemberRequest request) {
        return memberService.addMember(new Member(request.getName(), request.getMailAddress()));
    }

    // add
    // search list
    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    // search
    // modify
    // remove
}
