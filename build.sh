#!/bin/bash

set -x

. `dirname $0`/init-sbt

sbt compile
