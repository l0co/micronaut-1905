# Micronaut #1905

Repository for Micronaut [#1905](https://github.com/micronaut-projects/micronaut-core/issues/1905) investigation, why streaming upload reports progress faster than is consumed on the server side.

You can increase upload file size using:

```bash
$ dd if=/dev/zero of=./test/file.txt count=1024 bs=1024
```

## How to run

```
$ gradle --info clean test

micronaut.upload.UploadTest > testWithApacheHttpClient() STANDARD_OUT
14:34:47.819 [main] INFO  micronaut.upload.UploadTest - 4 kB
14:34:47.866 [nioEventLoopGroup-1-2] INFO  micronaut.upload.UploadController - 844 B
14:34:54.474 [nioEventLoopGroup-1-2] INFO  micronaut.upload.UploadController - 512 kB
14:34:54.497 [main] INFO  micronaut.upload.UploadTest - 512 kB

BUILD SUCCESSFUL in 10s
5 actionable tasks: 4 executed, 1 up-to-date
```
