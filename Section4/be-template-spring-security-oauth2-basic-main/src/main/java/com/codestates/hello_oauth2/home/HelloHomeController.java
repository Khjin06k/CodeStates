package com.codestates.hello_oauth2.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloHomeController {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public HelloHomeController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/hello-oauth2")
    public String home(Authentication authentication) {

        var authorizedClient = authorizedClientService.loadAuthorizedClient("google", authentication.getName()); // (2)

        // (3)
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        System.out.println("Access Token Value: " + accessToken.getTokenValue());  // (3-1)
        System.out.println("Access Token Type: " + accessToken.getTokenType().getValue());  // (3-2)
        System.out.println("Access Token Scopes: " + accessToken.getScopes());       // (3-3)
        System.out.println("Access Token Issued At: " + accessToken.getIssuedAt());    // (3-4)
        System.out.println("Access Token Expires At: " + accessToken.getExpiresAt());  // (3-5)

        return "hello-oauth2";

        //Security Context를 이용
        //var oAuth2User = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(oAuth2User.getAttributes().get("email"));

        //Authentication 객체를 핸들러 메서드 파라미터로 전달받기 (home()에 파라미터 Authentication 추가)
        //var oAuth2User = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(oAuth2User);
        //System.out.println("User's email in Google : " + oAuth2User.getAttributes().get("email"));

        //OAuth2User을 파라미터로 전달 받기 (home() 파라미터에 OAuth2User 파라미터를 추가함 (AuthenticationPrincipal 애터테이션 필요)
        //System.out.println("User's email in Google : " + oAuth2User.getAttributes().get("email"));

    }
}
