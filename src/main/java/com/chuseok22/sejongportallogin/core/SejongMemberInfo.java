package com.chuseok22.sejongportallogin.core;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SejongMemberInfo {
  private String major; // 학과명
  private String studentId; // 학번
  private String name; // 이름
  private String grade; // 학년
  private String status; // 사용자 상태 (재학, 휴학 등)
  private String completedSemester; // 이수 학기
}
