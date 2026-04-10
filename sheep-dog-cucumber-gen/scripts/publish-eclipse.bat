@echo off
REM Publish Eclipse OSGi artifacts to Nexus that aren't available on Maven Central.
REM These are transitive dependencies of the Xtext/EMF/UML2 stack with Eclipse
REM OSGi-style version numbers (e.g. 2.35.0.v20230829-0934).
REM
REM Prereqs:
REM   - settings.xml has a nexus-releases server entry with helm-deployer credentials
REM   - mkcert root CA imported (for HTTPS to nexus.sheepdog.io)
REM   - Run from the sheep-dog-cucumber-gen/scripts directory
REM
REM Step 1: copy all transitive deps into target/dependency
REM Step 2: deploy the Eclipse-only jars to Nexus maven-releases

cd ..
call mvn clean
call mvn dependency:copy-dependencies -DoutputDirectory=target/dependency

set NEXUS_URL=https://nexus.sheepdog.io/repository/maven-releases/
set REPO_ID=nexus-releases

REM --- org.eclipse.core ---
call mvn deploy:deploy-file -Dfile=target/dependency/runtime-3.29.0.v20230726-0617.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.core -DartifactId=runtime -Dversion=3.29.0.v20230726-0617

REM --- org.eclipse.emf ---
call mvn deploy:deploy-file -Dfile=target/dependency/ecore-2.35.0.v20230829-0934.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.emf -DartifactId=ecore -Dversion=2.35.0.v20230829-0934
call mvn deploy:deploy-file -Dfile=target/dependency/ecore.xmi-2.35.0.v20230801-1141.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.emf -DartifactId=ecore.xmi -Dversion=2.35.0.v20230801-1141
call mvn deploy:deploy-file -Dfile=target/dependency/mapping.ecore2xml-2.12.0.v20230211-1150.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.emf -DartifactId=mapping.ecore2xml -Dversion=2.12.0.v20230211-1150
call mvn deploy:deploy-file -Dfile=target/dependency/common-2.29.0.v20230916-0637.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.emf -DartifactId=common -Dversion=2.29.0.v20230916-0637

REM --- org.eclipse.uml2 ---
call mvn deploy:deploy-file -Dfile=target/dependency/uml.profile.standard-1.5.0.v20221116-1811.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.uml2 -DartifactId=uml.profile.standard -Dversion=1.5.0.v20221116-1811
call mvn deploy:deploy-file -Dfile=target/dependency/common-2.5.0.v20221116-1811.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.uml2 -DartifactId=common -Dversion=2.5.0.v20221116-1811
call mvn deploy:deploy-file -Dfile=target/dependency/types-2.5.0.v20221116-1811.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.uml2 -DartifactId=types -Dversion=2.5.0.v20221116-1811
call mvn deploy:deploy-file -Dfile=target/dependency/uml.resources-5.5.0.v20221116-1811.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.uml2 -DartifactId=uml.resources -Dversion=5.5.0.v20221116-1811
call mvn deploy:deploy-file -Dfile=target/dependency/uml-5.5.0.v20210228-1829.jar -Durl=%NEXUS_URL% -DrepositoryId=%REPO_ID% -DgroupId=org.eclipse.uml2 -DartifactId=uml -Dversion=5.5.0.v20210228-1829

cd scripts
