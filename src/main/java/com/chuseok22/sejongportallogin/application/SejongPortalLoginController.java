package com.chuseok22.sejongportallogin.application;

import com.chuseok22.sejongportallogin.core.SejongMemberInfo;
import com.chuseok22.sejongportallogin.infrastructure.SejongPortalLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sejong-portal")
@RequiredArgsConstructor
public class SejongPortalLoginController {

  private final SejongPortalLoginService sejongPortalLoginService;

  @PostMapping
  public ResponseEntity<SejongMemberInfo> login(String sejongPortalId, String sejongPortalPw) {
    return ResponseEntity.ok(sejongPortalLoginService.getMemberAuthInfos(sejongPortalId, sejongPortalPw));
  }

}
