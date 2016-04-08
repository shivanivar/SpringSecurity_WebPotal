
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
    "register",
    "employment",
    "education",
    "personalDetails"
})
public class UserJson {

    @JsonProperty("register")
    private Register register;
    @JsonProperty("employment")
    private Employment employment;
    @JsonProperty("education")
    private Education education;
    @JsonProperty("personalDetails")
    private PersonalDetails personalDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The register
     */
    @JsonProperty("register")
    public Register getRegister() {
        return register;
    }

    /**
     * 
     * @param register
     *     The register
     */
    @JsonProperty("register")
    public void setRegister(Register register) {
        this.register = register;
    }

    /**
     * 
     * @return
     *     The employment
     */
    @JsonProperty("employment")
    public Employment getEmployment() {
        return employment;
    }

    /**
     * 
     * @param employment
     *     The employment
     */
    @JsonProperty("employment")
    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    /**
     * 
     * @return
     *     The education
     */
    @JsonProperty("education")
    public Education getEducation() {
        return education;
    }

    /**
     * 
     * @param education
     *     The education
     */
    @JsonProperty("education")
    public void setEducation(Education education) {
        this.education = education;
    }

    /**
     * 
     * @return
     *     The personalDetails
     */
    @JsonProperty("personalDetails")
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * 
     * @param personalDetails
     *     The personalDetails
     */
    @JsonProperty("personalDetails")
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
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
