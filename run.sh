mvn clean install
rm -rf $TOM/webapps/communicable-disease
rm -f $TOM/webapps/communicable-disease.war
cp target/communicable-disease.war $TOM/webapps/
export JPDA_ADDRESS=5005
export JPDA_TRANSPORT=dt_socket
sh $TOM/bin/catalina.sh jpda run
