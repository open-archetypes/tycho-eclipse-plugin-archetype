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

The generated plugin is based on the Hello World template from the PDE Wizard, using the Eclipse 3.x architecture :

    [...] creates a simple handler set that adds Sample Menu to the menu bar and a button to the tool bar.
    Both the menu item in the new menu and the button invoke the same Sample Handler.
    Its role is to open a simple message dialog with a message of your choice.

Pre-Requisites :
-------------------

* JDK 1.8 or later (Java 11 is the default target)
* maven 3.6.3 or later
* Eclipse 2020-12 is the default target, but earlier versions *might* work
* m2e 1.1 or later
* m2eclipse-tycho 0.6 or later

Accessing the archetype from Eclipse
-------------------
In Eclipse, first add the Open Archetypes catalog :

1. On the Archetypes Preferences page (Windows: `Window` > `Preferences`; OS X: `Eclipse`> `Preferences` or `⌘,`), open `Maven` > `Archetypes`, click on the `Add Remote Catalog...` button

    - Catalog file : https://open-archetypes.github.com/maven-repo/releases/
    - Description : `Open Archetypes`

2. Click `OK` to close the dialog
3. Click `OK` to close the preferences
 
Accessing the archetype from command line
-------------------
Open your terminal or Windows CMD:

1. Execute `mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -DarchetypeCatalog=http://open-archetypes.github.com/maven-repo/releases/ -DarchetypeGroupId=org.openarchetypes -DarchetypeArtifactId=tycho-eclipse-plugin-archetype`
2. Enter the groupId
3. Enter the artifactId
4. Enter the name of the package under which your code will be created
5. Enter the version of your project
6. Confirm

Creating a new project in Eclipse, using the Maven wizard
-------------------

1. Create a new Maven project
* Click `Next` to land on the Archetype page
* Select the `Open Archetypes` catalog
* Select `tycho-eclipse-plugin-archetype` and click Next
* Enter the Group Id, Artifact Id and Version informations. Eclipse requires the version to follow a Major.Minor.Micro pattern, so you should use 1.0.0-SNAPSHOT instead of 1.0-SNAPSHOT
* You can change the required properties if needed :
    - java_version : The Java version to be used for compiling the plugins. Supported values are `1.8` to `15`. Defaults to `11`
    - tycho_version : the tycho version that will be used to build the project in command line. Defaults to `2.1.0`
    - eclipse_platform : the Eclipse platform, will drive what eclipse update site will be used to resolve the Eclipse dependencies. Defaults to `2020-12`. Previous non-date-based platforms like `neon`, `luna` might work too.
* Hit `Finish`
* Wait for awesomeness

Once the projects are created, you can start testing Eclipse hosted mode, run JUnit Plug-in tests ...

Building the project with Maven
-------------------
You can then build your projects in command line, in a terminal, by issuing :

    mvn clean verify

A zipped update site will be created as `<project.parent>/<project.site>/target/<project.site>-<project.version>-site.zip`.

Signed artifacts
-------------------
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
