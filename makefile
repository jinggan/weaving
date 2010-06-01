clean	:
	cd src/ ; mvn clean ; cd ../
generate-gae:
	rm -rf src/weaving-web-gae/src/main/webapp/statics/
	rm -rf src/weaving-web-gae/src/main/webapp/WEB-INF/content/
	cp -r src/weaving-web/src/main/webapp/statics/ src/weaving-web-gae/src/main/webapp/
	cp -r src/weaving-web/src/main/webapp/WEB-INF/content/ src/weaving-web-gae/src/main/webapp/WEB-INF/
install :clean generate-gae
	cd src/ ; mvn package ; cd ../
	rm -rf doc/apidocs
	cp -r src/target/site/apidocs/ doc/
	rm -f /tmp/weaving-local.war
	cp src/weaving-web/target/weaving-web-1.0.war /tmp/weaving-local.war
	cd src/ ; mvn clean ; cd ../
package-src:install
	rm -f /tmp/weaving-src.zip
	zip -r /tmp/weaving-src.zip *
package-bin:install
	rm -rf tmp/
	mkdir -p tmp/
	cp -r bin tmp/
	cp -r doc tmp/
	rm -f /tmp/weaving-bin.zip
	cd tmp/;zip -r /tmp/weaving-bin.zip *;cd ../
	rm -rf tmp/
package-all:package-src package-bin
upload-bin:package-bin
	python build-scripts/googlecode_upload.py -s weaving-bin -p weaving /tmp/weaving-bin.zip
upload-war:install
	python build-scripts/googlecode_upload.py -s weaving-local.war -p weaving /tmp/weaving-local.war
upload-src:package-src
	python build-scripts/googlecode_upload.py -s weaving-src -p weaving /tmp/weaving-src.zip	
upload-all:upload-bin upload-war upload-src
deploy-gae: generate-gae
	cd src/weaving-web-gae ; mvn gae:deploy ; cd ../../
