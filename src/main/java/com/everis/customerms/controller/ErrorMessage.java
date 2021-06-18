package com.everis.customerms.controller;

import java.util.List;
import java.util.Map;

import lombok.Builder;

@Builder

public class ErrorMessage {
	private String code;
	private List<Map<String, String>> messages;

}
