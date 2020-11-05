package com.plekhanov.service;

//@Slf4j
//public class NcsaLogger extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (logger.isInfoEnabled()) {
//            ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
//            ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
//            long executionTime = performAndGetExecutionTime(filterChain, wrappedRequest, wrappedResponse);
//            performLogging(executionTime, wrappedRequest, wrappedResponse);
//            wrappedResponse.copyBodyToResponse();  // важно!
//        }
//    }
//
//    private void performLogging(long executionTime, ContentCachingRequestWrapper wrappedRequest, ContentCachingResponseWrapper wrappedResponse) throws UnsupportedEncodingException {
//        String fullRequest = getFullRequest(wrappedRequest);
//        if(!fullRequest.equals("/actuator/health?null")) { //не логгируем health check
//            String responseBody = new String(wrappedResponse.getContentAsByteArray(), wrappedResponse.getCharacterEncoding());
//            log.info("{} - {} {} - {} - {} ms - {}",
//                    wrappedRequest.getRemoteAddr(), wrappedRequest.getMethod(), fullRequest, wrappedResponse.getStatus(), executionTime, maskPhoneNumber(responseBody));
//        }
//    }
//
//    private String getFullRequest(ContentCachingRequestWrapper wrappedRequest) {
//        String queryString = wrappedRequest.getQueryString();
//        String requestURI = wrappedRequest.getRequestURI();
//
//        // в queryString благодаря чьей-то бесконечной мудрости _действительно_ приходит _строка_ "null"
//        return "null".equals(queryString) ? requestURI : requestURI + "?" + queryString;
//    }
//
//    private long performAndGetExecutionTime(FilterChain filterChain, ContentCachingRequestWrapper wrappedRequest, ContentCachingResponseWrapper wrappedResponse) throws IOException, ServletException {
//        long start = System.currentTimeMillis();
//        filterChain.doFilter(wrappedRequest, wrappedResponse);
//        return System.currentTimeMillis() - start;
//    }
//}


