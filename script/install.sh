#bin/sh
cd ../code
mvn install
cd ..
rm -r -f target
mkdir -p target
cp script/runner.jar script/start.* script/uninstall.sh target/
cp code/weaving-web/target/weaving-web-1.0.war target/

