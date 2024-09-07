# spring-jenkinsfile

In order to run Jenkinsfile do as follow:

C:\>java -jar jenkins.war

Then got to localhost:8080 after setup plugins and login, Click on 'New Item'-> Enter an item name->select 'Pipeline'->Click OK.

Then click your pipeline name and select 'Configure' and in the Pipeline->Definition section, Select 'Git' in 'SCM' combobox and then in the 'Repository URL' section, paste the address of this git URL

https://github.com/EsmaeilChitgar/spring-cucumber-test.git

In the 'Branch Specifier (blank for 'any')', select the desired branch (here 'master') and then click on 'Save'.

Finally go to 'Dashboard page' and click your pipeline name and in the left-menu, click on 'Build Now' to build and run he pipeline. 

------------------------------------------------------------
If you need to run jenkins script Locally (no Jenkinsfile in git repository root), do the following:

Click on 'New Item'-> Enter an item name->select 'Pipeline'->Click OK.

Then click your pipeline name and select 'Configure' and in the Pipeline->Definition section, Select 'Pipeline script' in 'SCM' combobox and then in the 'Script' section, paste the paste the whole contents of your Jenkinsfile in it and then click on 'Save'.

Finally go to 'Dashboard page' and click your pipeline name and in the left-menu, click on 'Build Now' to build and run he pipeline.
