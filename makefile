clean	:
	cd src/ ; mvn clean ; cd ../
generate-gae:
	rm -rf src/weaving-web-gae/src/main/webapp/statics/
	rm -rf src/weaving-web-gae/src/main/webapp/WEB-INF/content/
	cp -r src/weaving-web/src/main/webapp/statics/ src/weaving-web/src/main/webapp/
	cp -r src/weaving-web/src/main/webapp/WEB-INF/content/ src/weaving-web/src/main/webapp/WEB-INF/
install :clean generate-gae
	cd src/ ; mvn package ; cd ../
	rm -rf doc/apidocs
	cp -r src/target/site/apidocs/ doc/
	rm -rf lib/
	mkdir -p lib
	cp -r src/weaving-web/target/weaving-web-1.0.war lib
	cd src/ ; mvn clean ; cd ../
package-src :install
	zip -r /tmp/weaving-src.zip *
package-all:package-with-src package-example package
upload  : package-all
	python build-scripts/googlecode_upload.py -s jsa4j-1.0-alpha-2.zip -p jsa4j /tmp/jsa4j-1.0-alpha-2.zip
	python build-scripts/googlecode_upload.py -s jsa4j-src-1.0-alpha-2.zip -p jsa4j /tmp/jsa4j-src-1.0-alpha-2.zip
	python build-scripts/googlecode_upload.py -s jsa4j-example-1.0-alpha-2.zip -p jsa4j /tmp/jsa4j-example-1.0-alpha-2.zip
deploy	:
	cd src/ ; mvn deploy ; cd ../
deploy-site:
	cd src/ ; mvn site-deploy ; cd ../

