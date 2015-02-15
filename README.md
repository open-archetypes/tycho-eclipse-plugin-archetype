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

* JDK 1.7 or later (Java 1.8 is the default target)
* maven 3.0 or later
* Eclipse Juno (3.6) with PDE or later (Luna (4.4) is the default target)
* m2e 1.1 or later
* m2eclipse-tycho 0.6 or later

How to use
-------------------

### In Eclipse 

First add the Open Archetypes catalog :

* On the Archetypes Preferences page (Window > Preferences > Maven > Archetypes), click on the "Add Remote Catalog..." button

    - Catalog file : http://open-archetypes.github.com/maven-repo/releases/
    - Description : Open Archetypes

* Click OK to close the dialog
* Click OK to close the preferences

Now you can create a new project, using the Maven wizard :

* Create a new Maven project
* Click Next to land on the Archetype page
* Select the `Open Archetypes` catalog
* Select `tycho-eclipse-plugin-archetype` and click Next
* Enter the Group Id, Artifact Id and Version informations. Eclipse requires the version to follow a Major.Minor.Micro pattern, so you should use 1.0.0-SNAPSHOT instead of 1.0-SNAPSHOT
* You can change the required properties if needed :
    - java_version : The Java version to be used for compiling the plugins. Supported values are `1.7`, `1.8`. Defaults to `1.8`
    - tycho_version : the tycho version that will be used to build the project in command line. Defaults to `0.22.0`
    - eclipse_platform : the Eclipse platform, will drive what eclipse update site will be used to resolve the Eclipse dependencies.
    Supported values are : `helios`, `indigo`, `juno`, `kepler`, `luna`, `mars`. Defaults to `luna` .
* Hit Finish
* Wait for awesomeness
* Once the projects are created, you can start testing Eclipse hosted mode, run JUnit Plug-in tests ...
 
### From command line

Start maven in interactive mode by passing catalog URL:

     mvn archetype:generate -DarchetypeCatalog=http://open-archetypes.github.io/maven-repo/snapshots/

You can then build your projects in command line, in a terminal, by issuing :

    mvn clean verify

A zipped update site will be created as `<project.parent>/<project.site>/target/<project.site>-<project.version>-site.zip`.

Signed artifacts will be created when the `sign` profile is used.

    mvn package -Psign

In order to sign artifacts, you will need to generate/provide a keystore first (see http://docs.oracle.com/javase/6/docs/technotes/tools/solaris/jarsigner.html) and configure your settings.xml like :　　

```
  <profiles>
    <profile>
    <id>sign</id>
      <properties>
        <sign.keystore>~/.ssh/sample.keystore</sign.keystore>
        <sign.alias>sample</sign.alias>
        <sign.storepass>samplepass</sign.storepass>
        <sign.keypass>samplepass</sign.keypass>
      </properties>
    </profile>
  </profiles>
```

Alternative archetypes
----------------------
You can find somewhat similar tycho-based archetypes based on :

* Groovy : https://github.com/open-archetypes/groovy-eclipse-plugin-archetype
* XText : https://github.com/fuinorg/emt-xtext-archetype
