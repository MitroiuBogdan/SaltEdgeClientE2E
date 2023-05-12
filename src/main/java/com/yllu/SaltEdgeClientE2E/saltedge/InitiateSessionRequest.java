package com.yllu.SaltEdgeClientE2E.saltedge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class InitiateSessionRequest {
    @JsonProperty("customerId")
    private String customerId;
    String connectionId;
    String aspspCode;
    Boolean dailyRefresh;

}
