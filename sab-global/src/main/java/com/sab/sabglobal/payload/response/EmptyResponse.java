package com.sab.sabglobal.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmptyResponse implements Response {

}
