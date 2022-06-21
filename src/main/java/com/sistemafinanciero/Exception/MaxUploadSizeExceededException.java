package com.sistemafinanciero.Exception;

public class MaxUploadSizeExceededException extends RuntimeException {
	
	private static final String DESCRIPTION = "Bad Request Exception (400)";
	
		public MaxUploadSizeExceededException (String detail) {
			super (DESCRIPTION + " " + detail);
	}

}
