# hello-world

a [Sails v1](https://sailsjs.com) application


### Links

+ [Sails framework documentation](https://sailsjs.com/get-started)
+ [Version notes / upgrading](https://sailsjs.com/documentation/upgrading)
+ [Deployment tips](https://sailsjs.com/documentation/concepts/deployment)
+ [Community support options](https://sailsjs.com/support)
+ [Professional / enterprise options](https://sailsjs.com/enterprise)


### Version info

This app was originally generated on Mon Apr 20 2020 19:16:46 GMT-0500 (Central Daylight Time) using Sails v1.2.4.

<!-- Internally, Sails used [`sails-generate@1.16.13`](https://github.com/balderdashy/sails-generate/tree/v1.16.13/lib/core-generators/new). -->


This project's boilerplate is based on an expanded seed app provided by the [Sails core team](https://sailsjs.com/about) to make it easier for you to build on top of ready-made features like authentication, enrollment, email verification, and billing.  For more information, [drop us a line](https://sailsjs.com/support).

# Run My Instance (Sprint-4 Requirement)

Setup of Sails is very straight forward and quick. Below I will list the steps necessary to get my instance of Sails up and running (assuming you are using macOS).
1. Open terminal or your command line system of choice (I use iTerm2)
2. To install Sails, type: `npm install sails -g`
3. Clone the 'sprint-4' repository to your computer
4. cd into the 'Hello-World' folder inside of the sprint-4 repository using terminal or your command line system of choice
5. To check out the Sails instance, type: `sails lift`
6. Navigate to your web browswer of choice and type this into the URL bar: `localhost:1337`
7. The sails instance of the cloned repository should open!
8. To close the instance, go back to the command line, and press `Control + C`

# Setup and Run Your Own Instance

You can navigate to https://sailsjs.com/get-started or follow the steps below.
1. Open terminal or your command line system of choice (I use iTerm2)
2. To install Sails, type: `npm install sails -g`
3. cd into a directory of choice where you want your instance to be located
4. To generate a new app, type: `sails new project-name`
5. You will be prompted to choose a Web App by typing `1` or an empty Sails app by typing `2`. This this case, we want a Web App, so type `1`.
6. cd into the folder that matches the name of your project. If you typed exactly what I typed when you generated the new app, you would type: `cd project-name`
7. To run your instance, type: `sails lift`
8. Navigate to your web browser of choice and enter this into the URL bar: `localhost:1337`
9. To close the instance, go back to the command line, and press `Control + C`


<!--
Note:  Generators are usually run using the globally-installed `sails` CLI (command-line interface).  This CLI version is _environment-specific_ rather than app-specific, thus over time, as a project's dependencies are upgraded or the project is worked on by different developers on different computers using different versions of Node.js, the Sails dependency in its package.json file may differ from the globally-installed Sails CLI release it was originally generated with.  (Be sure to always check out the relevant [upgrading guides](https://sailsjs.com/upgrading) before upgrading the version of Sails used by your app.  If you're stuck, [get help here](https://sailsjs.com/support).)
-->
