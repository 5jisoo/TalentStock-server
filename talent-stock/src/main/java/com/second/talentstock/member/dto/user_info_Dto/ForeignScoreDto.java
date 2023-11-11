package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
public class ForeignScoreDto {

    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private String score;
    private String type;
    private LocalDate acquisitionDate;

    @Builder
    public ForeignScoreDto(Long id, Member member, String score, String type, LocalDate acquisitionDate) {
        this.id = id;
        this.member = member;
        this.score = score;
        this.type = type;
        this.acquisitionDate = acquisitionDate;
    }
}