
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
    "mobileNo",
    "permanentAddress",
    "currentAddress",
    "gender",
    "birthDate"
})
public class PersonalDetails {

    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("permanentAddress")
    private String permanentAddress;
    @JsonProperty("currentAddress")
    private String currentAddress;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The mobileNo
     */
    @JsonProperty("mobileNo")
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 
     * @param mobileNo
     *     The mobileNo
     */
    @JsonProperty("mobileNo")
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 
     * @return
     *     The permanentAddress
     */
    @JsonProperty("permanentAddress")
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * 
     * @param permanentAddress
     *     The permanentAddress
     */
    @JsonProperty("permanentAddress")
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * 
     * @return
     *     The currentAddress
     */
    @JsonProperty("currentAddress")
    public String getCurrentAddress() {
        return currentAddress;
    }

    /**
     * 
     * @param currentAddress
     *     The currentAddress
     */
    @JsonProperty("currentAddress")
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    /**
     * 
     * @return
     *     The gender
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The birthDate
     */
    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * 
     * @param birthDate
     *     The birthDate
     */
    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
