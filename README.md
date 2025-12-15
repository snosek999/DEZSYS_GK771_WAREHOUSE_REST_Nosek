# Middleware Engineering – REST & Data Formats

## Aufgabenstellung

Entwicklung eines Spring-Boot-Simulators für einen Lagerstandort, der realistische Lager- und Produktdaten generiert und diese über eine REST-Schnittstelle im JSON- und XML-Format zur Verfügung stellt.

## Implementierung

### Datenmodell – WarehouseData

```java
@JacksonXmlRootElement(localName = "warehouse")
public class WarehouseData {
    private String warehouseID;
    private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private String timestamp;
    private HashSet<WarehouseProducts> products;
}
```

Diese Klasse repräsentiert einen Lagerstandort inklusive Metadaten und einer Produktliste. Durch `@JacksonXmlRootElement` kann das Objekt sowohl als JSON als auch als XML serialisiert werden.

### Datenmodell – WarehouseProducts

```java
public class WarehouseProducts {
    private String productId;
    private String productName;
    private String productCategory;
    private String productQuantity;
    private String productUnit;
}
```

Diese Klasse beschreibt ein einzelnes Produkt im Lager mit Bezeichnung, Kategorie, Menge und Einheit.

### Simulation der Lagerdaten

```java
public class WarehouseSimulation {
    public WarehouseData getData(String inID) {
        WarehouseData data = new WarehouseData();
        data.setWarehouseID(inID);
        data.setWarehouseName("Linz Bahnhof");
        data.addWarehouseProducts(new WarehouseProducts(
            "00-443175", "Bio Orangensaft Sonne", "Getraenk", "2500", "Packung 1L"));
        return data;
    }
}
```

Die Klasse simuliert einen Lagerstandort und erzeugt realistische Beispieldaten für Standort und Produkte.

### Service-Schicht

```java
@Service
public class WarehouseService {
    public WarehouseData getWarehouseData(String inID) {
        WarehouseSimulation simulation = new WarehouseSimulation();
        return simulation.getData(inID);
    }
}
```

Der Service kapselt die Geschäftslogik und stellt dem Controller die generierten Lagerdaten zur Verfügung.

### REST-Controller

```java
@RestController
public class WarehouseController {

    @RequestMapping(value="/warehouse/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseData(@PathVariable String inID) {
        return service.getWarehouseData(inID);
    }

    @RequestMapping(value="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXml(@PathVariable String inID) {
        return service.getWarehouseData(inID);
    }
}
```

Der Controller stellt die REST-Endpunkte bereit und ermöglicht den Abruf der Lagerdaten im JSON- oder XML-Format.

### Application Start

```java
@SpringBootApplication
public class WarehouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }
}
```

Dies ist der Einstiegspunkt der Spring-Boot-Applikation.

## Technologien

* Java 21
* Spring Boot
* Gradle
* REST
* JSON und XML (Jackson)

## Quellen

* XML Daten - Timing Station (Example) warehouse.xml

* Spring Boot https://spring.io/projects/spring-boot

* Building an Application with Spring Boot https://spring.io/guides/gs/spring-boot/

* Spring Initializr https://start.spring.io/

* Building a RESTful Web Service https://spring.io/guides/gs/rest-service/

* Consuming a RESTful Web Service https://spring.io/guides/gs/consuming-rest/
