package com.eshop;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseId",
        "queryResult"
})
public class Jsonconv {

    @JsonProperty("responseId")
    private String responseId;
    @JsonProperty("queryResult")
    private QueryResult queryResult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("responseId")
    public String getResponseId() {
        return responseId;
    }

    @JsonProperty("responseId")
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    @JsonProperty("queryResult")
    public QueryResult getQueryResult() {
        return queryResult;
    }

    @JsonProperty("queryResult")
    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
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
