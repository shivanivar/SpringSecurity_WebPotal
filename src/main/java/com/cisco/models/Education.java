
package com.cisco.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
//import org.codehaus.jackson.annotate.JsonAnyGetter;
//import org.codehaus.jackson.annotate.JsonAnySetter;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonProperty;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;
//import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "qualification",
    "specialization",
    "startDate",
    "endDate",
    "university",
    "percentage"
})
public class Education {

    @JsonProperty("qualification")
    private String qualification;
    @JsonProperty("specialization")
    private String specialization;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("university")
    private String university;
    @JsonProperty("percentage")
    private String percentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The qualification
     */
    @JsonProperty("qualification")
    public String getQualification() {
        return qualification;
    }

    /**
     * 
     * @param qualification
     *     The qualification
     */
    @JsonProperty("qualification")
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * 
     * @return
     *     The specialization
     */
    @JsonProperty("specialization")
    public String getSpecialization() {
        return specialization;
    }

    /**
     * 
     * @param specialization
     *     The specialization
     */
    @JsonProperty("specialization")
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
     *     The university
     */
    @JsonProperty("university")
    public String getUniversity() {
        return university;
    }

    /**
     * 
     * @param university
     *     The university
     */
    @JsonProperty("university")
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * 
     * @return
     *     The percentage
     */
    @JsonProperty("percentage")
    public String getPercentage() {
        return percentage;
    }

    /**
     * 
     * @param percentage
     *     The percentage
     */
    @JsonProperty("percentage")
    public void setPercentage(String percentage) {
        this.percentage = percentage;
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
