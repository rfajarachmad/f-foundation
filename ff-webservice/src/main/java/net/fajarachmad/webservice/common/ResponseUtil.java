package net.fajarachmad.webservice.common;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.fajarachmad.common.model.CommonEntity;

public class ResponseUtil<E extends CommonEntity> {
	
	public static Response createResponseSuccess(Object data) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", true);
        responseMap.put("data", data);
        return Response.ok(responseMap, MediaType.APPLICATION_JSON).build();
    }
}
