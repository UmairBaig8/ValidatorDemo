## Spring Boot Custom Validator
### Welcome to the ValidatorDemo!!

### Steps:
1. Create an annotation e.g.
```java
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UpperCase {
    String value();
}
```

2. Write a resolver e.g.
```java
public class UpperCaseResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(UpperCase.class) != null;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        UpperCase attr = parameter.getParameterAnnotation(UpperCase.class);
        return webRequest.getParameter(attr.value()).toUpperCase();
    }
}
```

3. java-config
```java
    @Configuration
    @EnableWebMvc
    public class Config extends WebMvcConfigurerAdapter {
    ...
      @Override
      public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
          argumentResolvers.add(new UpperCaseResolver());
      }
    ...
    }
```

4. use an annotation in your controller method e.g.
```java
public String test(@UpperCase("foo") String foo)
```


## References:
- https://fullstackdeveloper.guru/2021/06/15/how-to-create-a-custom-annotation-in-spring-boot/
- https://stackoverflow.com/questions/30715579/custom-spring-annotation-for-request-parameters
- https://www.baeldung.com/java-custom-annotation
- https://www.javatpoint.com/spring-boot-aop-before-advice
- https://www.programmersought.com/article/31265341713/

