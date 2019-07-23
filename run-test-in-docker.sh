#!/bin/bash

docker build -t micronaut_upload .
docker run --name micronaut_upload --rm micronaut_upload
docker rmi micronaut_upload
