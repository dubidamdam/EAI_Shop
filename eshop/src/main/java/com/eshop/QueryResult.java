package com.eshop;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "queryText",
        "parameters",
        "allRequiredParamsPresent",
        "fulfillmentMessages",
        "intent",
        "intentDetectionConfidence",
        "languageCode"
})
public class QueryResult {

    @JsonProperty("queryText")
    private String queryText;
    @JsonProperty("parameters")
    private Parameters parameters;
    @JsonProperty("allRequiredParamsPresent")
    private Boolean allRequiredParamsPresent;
    @JsonProperty("fulfillmentMessages")
    private List<FulfillmentMessage> fulfillmentMessages = null;
    @JsonProperty("intent")
    private Intent intent;
    @JsonProperty("intentDetectionConfidence")
    private Long intentDetectionConfidence;
    @JsonProperty("languageCode")
    private String languageCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("queryText")
    public String getQueryText() {
        return queryText;
    }

    @JsonProperty("queryText")
    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    @JsonProperty("parameters")
    public Parameters getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("allRequiredParamsPresent")
    public Boolean getAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    @JsonProperty("allRequiredParamsPresent")
    public void setAllRequiredParamsPresent(Boolean allRequiredParamsPresent) {
        this.allRequiredParamsPresent = allRequiredParamsPresent;
    }

    @JsonProperty("fulfillmentMessages")
    public List<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    @JsonProperty("fulfillmentMessages")
    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    @JsonProperty("intent")
    public Intent getIntent() {
        return intent;
    }

    @JsonProperty("intent")
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @JsonProperty("intentDetectionConfidence")
    public Long getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    @JsonProperty("intentDetectionConfidence")
    public void setIntentDetectionConfidence(Long intentDetectionConfidence) {
        this.intentDetectionConfidence = intentDetectionConfidence;
    }

    @JsonProperty("languageCode")
    public String getLanguageCode() {
        return languageCode;
    }

    @JsonProperty("languageCode")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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
