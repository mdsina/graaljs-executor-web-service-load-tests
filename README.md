# graaljs-executor-web-service-load-tests
Load tests for graaljs-executor-web-service


To execute tests just run sbt task:

```
gatling:testOnly com.github.mdsina.graaljs.load.tests.StableTest
```

In IDEA do not forget to quote the command and turn off the checkbox `use sbt shell`
