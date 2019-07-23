# Micronaut #1905

Repository for Micronaut [#1905](https://github.com/micronaut-projects/micronaut-core/issues/1905) investigation, why streaming upload reports progress faster than is consumed on the server side.

## How to run

```
$ gradle --info clean test
[...]
Successfully started process 'Gradle Test Executor 1'

micronaut.upload.UploadTest STANDARD_OUT
    14:00:29.661 [Test worker] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [test]

micronaut.upload.UploadTest > testWithApacheHttpClient() STANDARD_OUT
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    CLIENT PROGRESS: 4096
    SERVER PROGRESS: 847
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 8192
    SERVER PROGRESS: 7345
    SERVER DONE
    CLIENT DONE

Gradle Test Executor 1 finished executing tests.

[...]

BUILD SUCCESSFUL in 10s
5 actionable tasks: 4 executed, 1 up-to-date
```