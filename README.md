# [![Stormheart](http://www.stormheart.net/assets/images/sh_github_logo.png)](http://www.stormheart.net)

[![Travis](https://img.shields.io/travis/Nutiler/stormheart-plugin.svg?style=flat-square)](https://travis-ci.org/Nutiler/stormheart-plugin.svg?branch=master)
[![Spigot](https://img.shields.io/badge/dependencies-spigot-yellow.svg?style=flat-square)](https://hub.spigotmc.org/javadocs/spigot/)
[![Stormheart](https://img.shields.io/badge/network-stormheart-FF5555.svg?style=flat-square)](http://www.stormheart.net) 

Describe what the resource does on the server and why it should be used. 
The resource included is a single class plugin which can be reloaded, load configuration, and has permissions.
PluginStyle was created to set the standard for each resource for STORMHEART.
It is much easier to understand a large codebase when all the code in it is in a consistent style.
This project will be maintained for future use, it is a guide and the framework for creating new resources.
New projects should be cloned from this repository and changed accordingly.

*See [google style](https://github.com/google/styleguide) for the standard settings on [eclipse](https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml) and [intellij](https://github.com/HPI-Information-Systems/Metanome/wiki/Installing-the-google-styleguide-settings-in-intellij-and-eclipse
).*

## Compiling

```
$ mvn clean install -U
$ build artifacts 
```

*Alternatively using IntelliJ, right-click __pom.xml__ and run __maven__ then select __reimport__ for the included dependencies.*

*Information about the server we are running can be found here. Java Development Kit 8 u50+ is the recommended environment for production.*

## Plugin.yml

```yml
  name: STORMHEART-pluginStyle
  main: net.stormheart.pluginStyle
  version: 1.0
  prefix: STORMHEART
  description: Plugin development guide.
  website: http://www.stormheart.net
```

*All instances of classes should extend the package `net.stormheart.x` within the source.*

## Functions

##### /pluginstyle

Alias: `/ps` `/styleguide`<br>
Permission: `pluginStyle.user`

Tells the sender what the command does and usage.

##### /pluginstyle admin

Permission: `pluginStyle.admin`

Gives the user the defined materials from the configuration.

##### /pluginstyle reload

Permission: `pluginStyle.admin`

Reloads the configuration file from disk. `/plugins/pluginStyle/config.yml`

## Team

<p align="center">
  <a href="https://github.com/nutiler"><img src="https://avatars0.githubusercontent.com/u/1874261?v=3&s=200" alt="Josh Wilson, nutiler"/></a>
  &nbsp; &nbsp;
  <a href="https://github.com/benneb1"><img src="https://avatars0.githubusercontent.com/u/3252354?v=3&s=200" alt="Ben Terry, benneb1"/></a>
  &nbsp;&nbsp;
  <a href="https://github.com/klemms"><img src="https://avatars0.githubusercontent.com/u/25405584?v=3&s=200" alt="Clément Ababou, klemms"/></a>
</p>

## License

GNU General Public License v3 (c) 2017 [STORMHEART](http://www.stormheart.net)
