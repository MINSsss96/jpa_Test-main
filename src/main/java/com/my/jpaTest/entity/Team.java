package com.my.jpaTest.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    @Id
    private String teamId;
    private String teamName;
    // 팀에 소속된 멤버의 리스트를 저장
    // 상관관계 설정 : Member 클래스의 team 정보 가리킨다
    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER)
    @Builder.Default
    private List<Member> memberList = new ArrayList<>();
}
