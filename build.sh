#!/bin/bash

SBTLAUNCH=`mktemp /tmp/sbt-launch.jar.XXXXX`
SBT=`mktemp /tmp/sbt.sh.XXXX`

curl https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.13.12/sbt-launch.jar -O $SBT

cat << "EOF" > $SBT
#!/bin/bash

SBT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M"
java $SBT_OPTS -jar `dirname $0`/sbt-launch.jar "$@"

EOF

chmod u+x $SBT

$SBT compile
