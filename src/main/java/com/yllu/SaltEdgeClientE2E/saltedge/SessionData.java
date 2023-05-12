package com.yllu.SaltEdgeClientE2E.saltedge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionData {

    @JsonProperty("connect_url")
    String loginUrl;

    @JsonProperty("expires_at")
    String expirationDate;

}
