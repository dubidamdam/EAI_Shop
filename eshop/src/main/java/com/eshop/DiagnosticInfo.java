package com.eshop;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "webhook_latency_ms"
})
public class DiagnosticInfo {

    @JsonProperty("webhook_latency_ms")
    private Long webhookLatencyMs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("webhook_latency_ms")
    public Long getWebhookLatencyMs() {
        return webhookLatencyMs;
    }

    @JsonProperty("webhook_latency_ms")
    public void setWebhookLatencyMs(Long webhookLatencyMs) {
        this.webhookLatencyMs = webhookLatencyMs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
