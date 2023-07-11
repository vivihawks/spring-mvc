<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="0;url=employee" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
<h4>Topics Covered</h4>
<ul>
	<li>@ModelAttribute in detail</li>
	<li>@Controller</li>
	<li>@RestController</li>
	<li>Model, ModelMap & ModelAndView</li>
	<li>Form Handling</li>
	<li>@ControllerAdvice and @ExceptionHandler</li>
	<li>HttpMediaTypeNotAcceptable</li>
	<li>Uśage of @EnableWebMVC. WebMvcConfigurer vs WebMvcConfigurationSupport</li>
	
</ul>

<h4>WebMvcConfigurationSupport</h4>

This class registers the following HandlerMappings:
<br>
    RequestMappingHandlerMapping ordered at 0 for mapping requests to annotated controller methods.
    HandlerMapping ordered at 1 to map URL paths directly to view names.
    BeanNameUrlHandlerMapping ordered at 2 to map URL paths to controller bean names.
    RouterFunctionMapping ordered at 3 to map router functions.
    HandlerMapping ordered at Integer.MAX_VALUE-1 to serve static resource requests.
    HandlerMapping ordered at Integer.MAX_VALUE to forward requests to the default servlet. 
<br>

Registers these HandlerAdapters:
<br>

    RequestMappingHandlerAdapter for processing requests with annotated controller methods.
    HttpRequestHandlerAdapter for processing requests with HttpRequestHandlers.
    SimpleControllerHandlerAdapter for processing requests with interface-based Controllers. 
<br>

Registers a HandlerExceptionResolverComposite with this chain of exception resolvers:

<br>
    ExceptionHandlerExceptionResolver for handling exceptions through ExceptionHandler methods.
    ResponseStatusExceptionResolver for exceptions annotated with ResponseStatus.
    DefaultHandlerExceptionResolver for resolving known Spring exception types 
<br>

Registers an AntPathMatcher and a UrlPathHelper to be used by:
<br>

    the RequestMappingHandlerMapping,
    the HandlerMapping for ViewControllers
    and the HandlerMapping for serving resources 
<br>

Note that those beans can be configured with a PathMatchConfigurer.

<br>
Both the RequestMappingHandlerAdapter and the ExceptionHandlerExceptionResolver are configured with default instances of the following by default:

<br>
    a ContentNegotiationManager
    a DefaultFormattingConversionService
    an OptionalValidatorFactoryBean if a JSR-303 implementation is available on the classpath
    a range of HttpMessageConverters depending on the third-party libraries available on the classpath. 

<br>
<br>
	
</head>
</html>
