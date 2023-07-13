# serialize-json
is a simple example of how to serialize JSON). The project is written in
Java & [Quarkus](https://quarkus.io/) framework. You can find 2 ways of serializing:
- using [Jackson](#Jackson) library
- using [Jsonb](#Jsonb) library
### Jackson
```
    <dependency>
      <groupId>com.fasterxml.jackson.dataformat</groupId>
      <artifactId>jackson-dataformat-xml</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-jackson</artifactId>
    </dependency>
```
to serialize with jackson library simply use the ObjectMapper.
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
to serialize with jsonb simply use the **import** *jakarta.json.bind.Jsonb;*.
```
    @Inject
    Jsonb jsonb;
```

