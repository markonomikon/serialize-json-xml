# serialize-json-xml
is a simple example of how to serialize JSON). The project is written in
Java & [Quarkus](https://quarkus.io/) framework. You can find 2 ways of serializing:
- using [Jackson](#Jackson) library
- using [Jsonb](#Jsonb) library
- using [Jackson-XML](#xml) library
### Jackson
```
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-jackson</artifactId>
    </dependency>
```
to serialize into JSON with jackson library simply use the ObjectMapper injecting it.
```
import com.fasterxml.jackson.databind.ObjectMapper;
```
```
    @Inject
    ObjectMapper objectMapper;
```
### Jsonb
```
  <!--JSON-B-->
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-jsonb</artifactId>
    </dependency>
```
to serialize into JSON with jsonb simply use the Jsonb injecting it.
```
import jakarta.json.bind.Jsonb;
```
```
    @Inject
    Jsonb jsonb;
```
### XML
```
  <!--XML-->
    <dependency>
      <groupId>com.fasterxml.jackson.dataformat</groupId>
      <artifactId>jackson-dataformat-xml</artifactId>
    </dependency>
```
to serialize into XML with jackson library simply use the XmlMapper.
```
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
```
you can try to inject it, but for me it hasn't worked:) so i instanced it inside the method.
```
XmlMapper xmlMapper = new XmlMapper();
```