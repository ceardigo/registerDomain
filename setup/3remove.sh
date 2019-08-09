#!/bin/bash
docker container stop $(docker container ls -a -q -f "label=registerDomain")
docker container rm $(docker container ls -a -q -f "label=registerDomain")