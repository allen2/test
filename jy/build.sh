WEB_ROOT=/home
mvn clean package
$WEB_ROOT/q/tools/bin/stop_tomcat.sh  $WEB_ROOT/q/www/cat.com
mv  $WEB_ROOT/q/www/cat.com/webapps/ROOT/   ~/ROOT`date +%Y%m%d`
mv target/jy-1    $WEB_ROOT/q/www/cat.com/webapps/ROOT
$WEB_ROOT/q/tools/bin/start_tomcat.sh  $WEB_ROOT/q/www/cat.com
