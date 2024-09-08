# spring-jenkinsfile

In order to run Jenkinsfile do as follow:

C:\>java -jar jenkins.war

------------------------------------------------------------------------
In the Dashboard Page, click on 'Manage Jenkins'->Tools and do the following:
- In the 'Jdk Installation' section click on 'Add JDK' and set a Name and set the JAVA_HOME of JDK in your system.
for example for me:

Name: JDK 17

JAVA_HOME: C:\Program Files\JetBrains\IntelliJ IDEA 2022.2\jbr


- In the 'Maven' section click on 'Add Maven' and set a Name and set the 'MAVEN_HOME' in your system.
for example for me:

Name: Maven 3.9.8

MAVEN_HOME: C:\Program Files\Git\bin



- In the 'Git' section click on 'Add Git' and set a Name and set the 'Path to Git executable' in your system.
for example for me:

Name: Git 2.38.1

Path to Git executable: C:\Program Files\Git\bin

(In this sample, we do not need to set the Git.)
------------------------------------------------------------------------

Then got to localhost:8080 after setup plugins and login, Click on 'New Item'-> Enter an item name->select 'Pipeline'->Click OK.

Then click your pipeline name and select 'Configure' and in the Pipeline->Definition section, Select 'Git' in 'SCM' combobox and then in the 'Repository URL' section, paste the address of this git URL

https://github.com/EsmaeilChitgar/spring-jenkinsfile.git

In the 'Branch Specifier (blank for 'any')', select the desired branch (here 'master') and then click on 'Save'.

Finally go to 'Dashboard page' and click your pipeline name and in the left-menu, click on 'Build Now' to build and run he pipeline. 

------------------------------------------------------------
If you need to run jenkins script Locally (no Jenkinsfile in git repository root), do the following:

Click on 'New Item'-> Enter an item name->select 'Pipeline'->Click OK.

Then click your pipeline name and select 'Configure' and in the Pipeline->Definition section, Select 'Pipeline script' in 'SCM' combobox and then in the 'Script' section, paste the paste the whole contents of your Jenkinsfile in it and then click on 'Save'.

Finally go to 'Dashboard page' and click your pipeline name and in the left-menu, click on 'Build Now' to build and run he pipeline.


------------------------------------------------------------------------
Note: The name of maven and jdk in 'tool{}' section in script must match the names you set in 'Manage Jenkins'->Tools.
