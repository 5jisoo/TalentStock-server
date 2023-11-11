package com.second.talentstock.member.domain;

  
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import com.second.talentstock.member.domain.user_info.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StudentMember extends Member {
    private String university;
    private String department;
    private String grade;
    private float majorScore;
    private float totalScore;
    private String shortIntroduce;
    private String introduce;
  
    @OneToMany(mappedBy = "member")
    private List<Award> awards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<ForeignScore> foreignScores = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<GroupActivity> groupActivities = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Project> projects = new ArrayList<>();

    @Builder
    public StudentMember(String loginID, String loginPW, MemberType memberType, String name, String email,
                         String university, String department, String grade, float majorScore, float totalScore, String shortIntroduce, String introduce) {
        super(loginID, loginPW, memberType, name, email);
        this.university = university;
        this.department = department;
        this.grade = grade;
        this.majorScore = majorScore;
        this.totalScore = totalScore;
        this.shortIntroduce = shortIntroduce;
        this.introduce = introduce;
    }
}