package com.second.talentstock.member.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.member.dto.LoginMemberReqDto;
import com.second.talentstock.member.dto.SearchStudentReqDto;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.second.talentstock.common.BaseResponseStatus;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.web.bind.annotation.*;

import static com.second.talentstock.member.domain.MemberType.COMPANY;
import static com.second.talentstock.member.domain.MemberType.STUDENT;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginMemberReqDto reqDto) {
        try {
            return new BaseResponse(memberService.findByIdAndPw(reqDto));
        } catch (BaseException e) {
            return new BaseResponse(e.getStatus());
        }
    }


    @PostMapping("/search")
    public BaseResponse<?> searchStudent(@RequestBody SearchStudentReqDto reqDto) {
        try {
            return new BaseResponse<>(memberService.searchStudent(reqDto));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
          
    @GetMapping("/{userId}")
    public BaseResponse<?> profile(@PathVariable("userId") Long id) {
        try {
            if (memberService.judgeMemberType(id) == STUDENT) {
                return new BaseResponse<>(memberService.showStudentProfile(id));
            }
            else if (memberService.judgeMemberType(id) == COMPANY){
                return new BaseResponse<>(memberService.showCompanyProfile(id));
            }
            else {
                return new BaseResponse<>(BaseResponseStatus.INVALID_USER_ID);
            }
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());

        }
    }
}
