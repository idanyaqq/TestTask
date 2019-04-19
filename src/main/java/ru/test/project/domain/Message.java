package ru.test.project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty(value = "id_sample")
    private String idSample;
    @JsonProperty(value = "num_id")
    private String numId;
    @JsonProperty(value = "id_location")
    private String idLocation;
    @JsonProperty(value = "id_signal_par")
    private String idSignalPar;
    @JsonProperty(value = "id_detected")
    private String idDetected;
    @JsonProperty(value = "id_class_det")
    private String idClassDet;

    public Message(String idSample, String numId, String idLocation, String idSignalPar, String idDetected, String idClassDet) {
        this.idSample = idSample;
        this.numId = numId;
        this.idLocation = idLocation;
        this.idSignalPar = idSignalPar;
        this.idDetected = idDetected;
        this.idClassDet = idClassDet;
    }

    public Message() {
    }

    public String getIdSample() {
        return idSample;
    }

    public void setIdSample(String idSample) {
        this.idSample = idSample;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdSignalPar() {
        return idSignalPar;
    }

    public void setIdSignalPar(String idSignalPar) {
        this.idSignalPar = idSignalPar;
    }

    public String getIdDetected() {
        return idDetected;
    }

    public void setIdDetected(String idDetected) {
        this.idDetected = idDetected;
    }

    public String getIdClassDet() {
        return idClassDet;
    }

    public void setIdClassDet(String idClassDet) {
        this.idClassDet = idClassDet;
    }
}
