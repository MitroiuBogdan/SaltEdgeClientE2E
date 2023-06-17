package com.yllu.SaltEdgeClientE2E.saltedge.model;

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
    String connect_url;

    @JsonProperty("expires_at")
    String expires_at;

}
