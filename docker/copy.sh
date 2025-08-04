#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20230223.sql ./mysql/db
cp ../sql/ry_config_20220929.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../travel-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy travel-gateway "
cp ../travel-gateway/target/travel-gateway.jar ./ruoyi/gateway/jar

echo "begin copy travel-auth "
cp ../travel-auth/target/travel-auth.jar ./ruoyi/auth/jar

echo "begin copy travel-visual "
cp ../travel-visual/travel-monitor/target/travel-visual-monitor.jar  ./ruoyi/visual/monitor/jar

echo "begin copy travel-modules-system "
cp ../travel-modules/travel-system/target/travel-modules-system.jar ./ruoyi/modules/system/jar

echo "begin copy travel-modules-file "
cp ../travel-modules/travel-file/target/travel-modules-file.jar ./ruoyi/modules/file/jar

echo "begin copy travel-modules-job "
cp ../travel-modules/travel-job/target/travel-modules-job.jar ./ruoyi/modules/job/jar

echo "begin copy travel-modules-gen "
cp ../travel-modules/travel-gen/target/travel-modules-gen.jar ./ruoyi/modules/gen/jar

