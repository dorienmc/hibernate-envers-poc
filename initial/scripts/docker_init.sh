#!/bin/bash

set -eou pipefail

if [ $# -eq 0 ]; then
    echo "Usage: $0 <jarfile> [java-options]" >&2
    exit 1
fi

JAVA_OPTS=${JAVA_OPTS:--XX:TieredStopAtLevel=1 -XX:+UnlockExperimentalVMOptions -XX:+ExitOnOutOfMemoryError}

if [ "${DEBUG:-false}" == "true" ]; then
    JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
fi

java $JAVA_OPTS -jar $*
