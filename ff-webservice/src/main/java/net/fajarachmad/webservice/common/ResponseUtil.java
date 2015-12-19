package net.fajarachmad.webservice.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
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
	
	public static Response createResponseError(int code, Object data, String message) {
		return buildErrorRespoes(code, data, message);
	}
	
	public static Response createResponseError(int code, Object data, Set<ConstraintViolation<?>> violations) {
		StringBuilder message = new StringBuilder();
		for (ConstraintViolation<?> constraintViolation : violations) {
			message.append(constraintViolation.getPropertyPath()+" - "+constraintViolation.getMessage());
		}
		return buildErrorRespoes(code, data, message.toString());
	}
	
	private static Response buildErrorRespoes(int code, Object data, String message) {
		Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", false);
        responseMap.put("data", data);
        responseMap.put("message", message);
        return Response.status(code).entity(responseMap).build();
	}
}
