# OpenAPI from Springfox
## 3.x
**1.** Dependency
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```
**2.** Configuration
```java
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(allApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .groupName("GroupName");
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("ContactName", "ContactURL", "ContactEmail");
        return new ApiInfoBuilder()
                .title("Title")
                .description("Description")
                .version("v1.0")
                .contact(contact)
                .build();
    }

}
```
**3.** Access the API document at `http://server:port/swagger-ui/`
## 2.x
**1.** Dependency
```xml
<dependencies>
    <!-- ... other dependency elements ... -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>
</dependencies>
```
**2.** Configuration
```java
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(Sample.class.getPackageName()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("ContactName", "ContactURL", "ContactEmail");
        return new ApiInfoBuilder()
                .title("Title")
                .description("Description")
                .version("1.0")
                .contact(contact)
                .build();
    }

}
```
**3.** Access the API document at `http://server:port/swagger-ui.html`
## Notice
* Use `Spring Boot 2.6.x` or `Spring Framework 5.3.x` with Springfox might cause `Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException`, because above-mentioned Spring use `PathPattern` but Springfox use `AntPathMatcher`, to figure out this exception, we can add properties to application.yml:
```yml
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```
## Reference
* [springfox](https://github.com/springfox/springfox)
* [Springfox Reference Documentation](https://springfox.github.io/springfox/docs/snapshot/)
