This project is built using Tycho (http://tycho.sonatype.org/) and requires at least maven 3.0-beta-1 (http://maven.apache.org/download.html) to be built via CLI. 
Simply run :
mvn install
The first run will take quite a while since maven will download all the required dependencies in order to build everything.

In order to use the generated eclipse plugins in Eclipse, you will need m2eclipse (http://m2eclipse.sonatype.org/) 
and the m2eclipse-tycho plugin (http://github.com/sonatype/m2eclipse-tycho). Update sites to install these plugins : 
m2eclipse stable update site : http://m2eclipse.sonatype.org/sites/m2e
m2eclipse-tycho dev update site : http://repository.sonatype.org/content/repositories/forge-sites/m2eclipse-tycho/0.4.0/S/0.4.0.20100510-2012/