# Semester Project - Food Logger

## Notes Before Running

Before you run this program, I want to make clear that the actual functionality has not been added yet. This is essentially a rough template of the food logger with functioning SSO. I did not have time to implement a database as I had never done it before, and have not been able to find the time to figure it out.

### Reflections

When researching SSO platforms for this project, I stumbled upon [Okta](www.okta.com). Okta seemed like the perfect fit for what I was trying to accomplish, so I planned to use it before trying to implement it. When I began working on the project, I ran into numerous issues with Okta and was unable to get SSO working using the platform. I kept looking around and eventually settled on [Auth0](www.auth0.com). Auth0 had a sample java project I was able to build off of and easily implement. The webpage itself is run by bootstrap, a framework I have never worked; thus, the homepage it quite rough, and mostly just an edited version of the sample. Regardless, while the project is in a very incomplete state right now, the idea is there, just needs more work to function as I want it to.

### Running The Program

In order to run this program, you need the [Gradle Build Tool](www.gradle.org) installed on your machine. If you are running macOS and have [Homebrew](www.brew.sh) installed, you can follow these steps to install Gradle:
1. Open terminal or your CLI of choice (I use iTerm2).
2. Run the command 'brew install gradle'
3. Done!
4. If this doesn't work, navigate to https://gradle.org/install/ and read over the installation documentation.

To actually run the program, follow these steps:
1. Clone the repository to your local machine.
2. Navivate to '~/Semester-Project-Final/FoodLogger/' using terminal or your CLI of choice.
3. Run the command './gradlew clean appRun'
4. If everything was installed correctly, the application should begin to run.
5. Open your web browser and navigate to 'http://localhost:3000/portal/home'
6. You should be greeted by a SSO page where you can login with google or create an account.
