# Java Servlet Web App Sample

A simple Java Servlet WebApp with Prometheus metrics provided by `servlet-monitor` library.
You can see how to configure and customize the metrics in [servlet-monitor](https://github.com/labbsr0x/servlet-monitor)  page.

## Run with Docker

Run above command to run the project in a container environment.
```shell script
docker-compose up --build
```

Sample servlet: `localhost:8080/app/sample`

Metrics:  `localhost:8080/app/metrics`
