# Micronaut #1905

Repository for Micronaut [#1905](https://github.com/micronaut-projects/micronaut-core/issues/1905) investigation, why streaming upload reports progress faster than is consumed on the server side.

You can increase upload file size using:

```bash
$ dd if=/dev/zero of=./test/file.txt count=1024 bs=1024
```

## How to run

```
$ gradle --info clean test

[...]

14:40:15.870 [main] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [test]
14:42:47.087 INFO  micronaut.upload.UploadTest - 4 kB
14:42:47.135 INFO  micronaut.upload.UploadTest - 512 kB
14:42:47.136 INFO  micronaut.upload.UploadController - 839 B
14:42:53.745 INFO  micronaut.upload.UploadController - 512 kB
14:42:53.803 INFO  micronaut.upload.UploadTest - 512 kB

[...]

BUILD SUCCESSFUL in 10s
5 actionable tasks: 4 executed, 1 up-to-date
```
