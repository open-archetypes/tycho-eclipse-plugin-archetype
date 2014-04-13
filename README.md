tycho-eclipse-plugin-archetype
==============================

This archetype will create a multi-modules project with a nested structure :

     __artifactId__    : parent pom project
     |
     |---__artifactId__.core   : eclipse-plugin 
     |
     |---__artifactId__.feature: eclipse-feature 
     |
     |---__artifactId__.test   : eclipse-test-plugin (Fragment project)
     |
     |---__artifactId__.site : eclipse-repository

The generated plugin is based on the Hello World template from the PDE Wizard :

    [...] creates a simple handler set that adds Sample Menu to the menu bar and a button to the tool bar. 
    Both the menu item in the new menu and the button invoke the same Sample Handler. 
    Its role is to open a simple message dialog with a message of your choice.

This archetype is an updated version of the one I gave to https://issues.sonatype.org/browse/TYCHO-442

Pre-Requisites :
-------------------

* JDK 1.7 or later
* maven 3.0 or later
* Eclipse Kepler (4.3.2) with PDE

How to use
-------------------

* You will clone this project and install this project to local maven repository.   
```
$ git clone https://github.com/ko2ic/tycho-eclipse-plugin-archetype.git
$ cd tycho-eclipse-plugin-archetype   
$ mvn install   
```
* A new project is created by selecting the local archetype. (About a version, you should select numeric value like Major.Minor.Revision-SNAPSHOT but not Major.Minor) 
```
$ mvn archetype:generate -DarchetypeCatalog=local
[INFO] Generating project in Interactive mode
...
1: local -> org.openarchetypes:tycho-eclipse-plugin-archetype (Project for develop and release with tycho.)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): :1
```     
* It will enable to work in eclipse by the follow command.
```
$ mvn eclipse:eclipse
```
If 'Version' contains '-SNAPSHOT', 'Bundle-Version' in MANIFEST.MF unintentionally replaces 'qualifier' to 'SNAPSHOT'.  
So You must revert 'qualifier' of the file.

You can then build your projects in command line, in a terminal, by issuing :
```
$ mvn clean verify
```
An zipped update site will be created as 
```
/~.site/target/~site-<version>.zip
```

A Signed jar will be created by the follow command
```
$ mvn package -Psign
```

Add devendency jar:  
You can add <dependency> tag in pom.xml of root.   
In Eclipse, you should add 'libs/' to the first of value of 'Bundle-ClassPath:' in MANIFEST.MF.   
Otherwise, a created Plugin won't recognize the added dependency jar.  
ex)
```
Bundle-ClassPath: .,
 libs/poi-ooxml-3.10-beta2.jar,
 libs/poi-3.10-beta2.jar,
 libs/poi-ooxml-schemas-3.10-beta2.jar,
 libs/xmlbeans-2.3.0.jar,
 libs/stax-api-1.0.1.jar,
 libs/dom4j-1.6.1.jar,
 libs/xml-apis-1.0.b2.jar
```
