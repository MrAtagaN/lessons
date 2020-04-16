package com.plekhanov.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class AppService {
}
