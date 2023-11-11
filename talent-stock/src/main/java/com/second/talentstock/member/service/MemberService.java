package com.second.talentstock.member.service;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.dto.LoginMemberResDto;
import com.second.talentstock.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_LOGIN_INFO;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }

    public LoginMemberResDto findByIdAndPw(String id, String pw) throws BaseException {
        Member member = memberRepository.findByLoginIDAndLoginPW(id, pw)
                .orElseThrow(() -> new BaseException(INVALID_LOGIN_INFO));
        return LoginMemberResDto.builder()
                .memberType(member.getUserType())
                .memberId(member.getId())
                .build();
    }

    public Member findById(Long id) throws BaseException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
    }
}
