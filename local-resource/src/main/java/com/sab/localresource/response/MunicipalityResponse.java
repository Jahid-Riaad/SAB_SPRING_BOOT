package com.sab.localresource.response;

import com.sab.sabglobal.payload.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipalityResponse  implements Response {
    private String responseCode;
    private String responseMessage;
}
