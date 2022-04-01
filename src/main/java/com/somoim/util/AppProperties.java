package com.somoim.util;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
@ConstructorBinding
public class AppProperties {

    private final Auth auth;
    private final OAuth2 oauth2;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static final class OAuth2 {
        private List<String> authorizedRedirectUris = new ArrayList<>();

//        public List<String> getAuthorizedRedirectUris() {
//            return authorizedRedirectUris;
//        }
//
//        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
//            this.authorizedRedirectUris = authorizedRedirectUris;
//            return this;
//        }
    }

}
