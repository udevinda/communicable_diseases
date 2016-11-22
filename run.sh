mvn clean install
rm -rf $TOM/webapps/communicable-disease
rm -f $TOM/webapps/communicable-disease.war
cp target/communicable-disease.war $TOM/webapps/
sh $TOM/bin/catalina.sh run
