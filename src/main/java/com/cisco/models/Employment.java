
package com.cisco.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "companyName",
    "startDate",
    "endDate",
    "designation"
})
public class Employment {

    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("designation")
    private String designation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The companyName
     */
    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The companyName
     */
    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The startDate
     */
    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The endDate
     */
    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 
     * @return
     *     The designation
     */
    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    /**
     * 
     * @param designation
     *     The designation
     */
    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
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
