<br/>

<img src="site/src/jsMain/resources/public/icons/LUX-logo.svg" width="200px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="/site/src/jsMain/resources/public/icons/zenmo-logo-beter.svg" alt="Zenmo log" width="100px" >

This is the source code for the websites [lux.energy](https://lux.energy)
and [zenmo.com](https://zenmo.com)

It is built using [Kobweb](https://github.com/varabyte/kobweb).

A manual for editors is at [wiki.zenmo.com](https://wiki.zenmo.com/books)

Development
===

Troubleshooting
---

If you ever see imports from `@zenmo/...` left in the bundle:

- delete ./build
- run ./gradlew kotlinNpmInstall

These imports end up in the bundle because Rollup couldn't find them.
