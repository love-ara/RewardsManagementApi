package com.balancee.rewardsManagementApi.security.utils;

import java.util.List;

public class SecurityUtils {
    private SecurityUtils() {}

    public static final List<String> PUBLIC_ENDPOINTS = List.of("/api/auth");

    public static final String JWT_PREFIX  = "Bearer ";
}
